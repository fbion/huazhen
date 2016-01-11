package com.hzfh.p2p.controller.payment.notify;

import com.hzfh.api.customer.model.PaymentMoneyChange;
import com.hzfh.api.customer.model.PaymentMoneyWithdraw;
import com.hzfh.api.payment.model.ExamineCallbackRecord;
import com.hzfh.api.payment.model.common.constant.QueryType;
import com.hzfh.api.payment.model.common.constant.StatusCode;
import com.hzfh.api.payment.model.response.gateway.WithdrawNotify;
import com.hzfh.p2p.controller.common.NotifyAction;
import com.hzfh.p2p.model.baseInfo.SmsModel;
import com.hzfh.p2p.model.common.helper.LogHelper;
import com.hzfh.p2p.model.common.parameter.ContactInfo;
import com.hzfh.p2p.model.common.parameter.PaymentType;
import com.hzfh.p2p.model.common.properties.WebInfoHelper;
import com.hzfh.p2p.model.customer.P2pCustomerModel;
import com.hzfh.p2p.model.customer.PaymentAccountInformationModel;
import com.hzfh.p2p.model.customer.PaymentMoneyChangeModel;
import com.hzfh.p2p.model.customer.PaymentMoneyRechargeModel;
import com.hzfh.p2p.model.customer.PaymentMoneyWithdrawModel;
import com.hzfh.p2p.model.payment.ExamineCallbackRecordModel;
import com.hzframework.helper.DateHelper;

public class WithdrawNotifyAction extends NotifyAction<WithdrawNotify>{
	public static final LogHelper logger = LogHelper.getLogger(WithdrawNotifyAction.class.getName());
	@Override
    public String execute(){
		logger.info("提现回调Notify开始！");
		if (!verifySign()){
			logger.error("提现—验签失败!");
			return null;
        }
		logger.info("提现-验签成功!");
		if(getNotify()==null){
			logger.error("提现-notify is null!");
			return null;
		}
		WithdrawNotify withdrawNotify = this.getNotify();
		PaymentMoneyWithdraw paymentMoneyWithdraw = new PaymentMoneyWithdraw();
		
		String operationType = QueryType.QUERY_WITHDRAW;
		String sn = withdrawNotify.getRequestNo();
		ExamineCallbackRecord examineCallbackRecord  = new ExamineCallbackRecord();
		try {
			examineCallbackRecord = ExamineCallbackRecordModel.getinfoByoperationTypeAndSn(operationType,sn);
			logger.info("【提现】通过QUERY_WITHDRAW提现,sn获取examineCallbackRecord！");
		} catch (Exception e1) {
			logger.error("【提现】通过QUERY_WITHDRAW提现,sn获取examineCallbackRecord失败！", e1);
		}
		
		byte callbackStatus = examineCallbackRecord.getStatus();
		if(callbackStatus==QueryType.QUERY_YES_NOTIFY){
			logger.info("【提现】examineCallbackRecord记录中已经有notify,操作不在向下进行！");
			return sendSuccess();
		}
		
		//PaymentMoneyChange payMonChange =PaymentMoneyChangeModel.getInfoByMoneyChangeTypeAndRefSn(PaymentType.MONEYCHANGE_WITHDRAW,withdrawNotify.getRequestNo());
		if (Integer.parseInt(withdrawNotify.getCode()) == StatusCode.SUCCESS) {
			try {
				logger.info("【提现】examineCallbackRecord记录中没有notify,更新记录中的status开始！");
				ExamineCallbackRecordModel.updateStatusByoperationTypeAndSn(QueryType.QUERY_YES_NOTIFY,operationType,sn);
				logger.info("【提现】examineCallbackRecord记录中没有notify,更新记录中的status成功！");
			} catch (Exception e2) {
				logger.error("【提现】examineCallbackRecord记录中没有notify,更新记录中的status失败！",e2);
			}
			double money = Double.parseDouble(withdrawNotify.getAmount());
			int customerNo = Integer.parseInt(withdrawNotify.getPlatformUserNo());
			
			PaymentMoneyWithdraw payMoneyWithdraw = PaymentMoneyWithdrawModel.getInfoBystateAndSn(PaymentType.WITHDRA_SUCCESS,withdrawNotify.getRequestNo());
			
			if(payMoneyWithdraw==null){
				try {
					paymentMoneyWithdraw.setMoneyFactorage(Double.parseDouble(withdrawNotify.getFee()));
					paymentMoneyWithdraw.setCustomerMoneyFactorage(withdrawNotify.getFeeMode());
					paymentMoneyWithdraw.setResultCode(withdrawNotify.getCode());
					paymentMoneyWithdraw.setResultNote(withdrawNotify.getMessage());
					paymentMoneyWithdraw.setState(PaymentType.WITHDRA_SUCCESS);
					paymentMoneyWithdraw.setBankCode(withdrawNotify.getBank());
					paymentMoneyWithdraw.setSn(withdrawNotify.getRequestNo());
					paymentMoneyWithdraw.setAmount(money);
					paymentMoneyWithdraw.setBankCardNo(withdrawNotify.getBankCardNo());
					PaymentMoneyWithdrawModel.updateWithdraw(paymentMoneyWithdraw);
					logger.info("提现-更新提现表payment_money_withdraw成功！");
				} catch (Exception e) {
					e.printStackTrace();
					logger.error("提现-跟新提现表payment_money_withdraw失败！",e);
				}
				
				try {
					PaymentAccountInformationModel.updateMoneyAmount(-money,customerNo);
					logger.info("提现-更新账户详情表payment_account_information总金额成功！");
				} catch (Exception e) {
					e.printStackTrace();
					logger.error("提现-更新账户详情表payment_account_information总金额失败！");
				}
				
				try {
					PaymentAccountInformationModel.updateMoneyWithDarw(-money, customerNo);
					logger.info("提现-更新账户详情表payment_account_information可提现金额成功！");
				} catch (Exception e) {
					e.printStackTrace();
					logger.error("提现-更新账户详情表payment_account_information可提现金额失败！");
				}
			}
			
			PaymentMoneyChange payMoneyChange =PaymentMoneyChangeModel.getInfoByMoneyChangeTypeAndRefSn(PaymentType.MONEYCHANGE_WITHDRAW, withdrawNotify.getRequestNo());
			if(payMoneyChange==null){
				try {
					PaymentMoneyChange paymentMoneyChange = new PaymentMoneyChange();
					paymentMoneyChange.setP2pCustomerNo(customerNo);
					paymentMoneyChange.setMoneyChangeType(PaymentType.MONEYCHANGE_WITHDRAW);
					paymentMoneyChange.setMoneyWithdraw(Double.parseDouble(withdrawNotify.getAmount()));
					paymentMoneyChange.setRefSn(withdrawNotify.getRequestNo());
					double moneyAmountLater =PaymentAccountInformationModel.getInfoByCustomerNo(customerNo).getMoneyAmount();
					paymentMoneyChange.setMoneyAmountLater(moneyAmountLater);
					PaymentMoneyChangeModel.add(paymentMoneyChange);
					logger.info("提现-增加资金变动流水表payment_Money_change成功!");
				} catch (Exception e) {
					e.printStackTrace();
					logger.error("提现-增加资金变动流水表payment_Money_change失败!");
				}
			}
			
			SmsModel.smsWithdrawalsApply(P2pCustomerModel.getInfo(customerNo).getCellphone(), DateHelper.getCurrentTime().toString(), WebInfoHelper.WEB_P2P_WWW, paymentMoneyWithdraw.getBankCardName(), paymentMoneyWithdraw.getBankCardNo(), String.valueOf(paymentMoneyWithdraw.getAmount()), ContactInfo.P2P_HOTLINE);
			logger.info("提现成功！");
		}else{
			PaymentMoneyWithdrawModel.updateState(PaymentType.RECHARGE_FAILURE,sn);//更新提现状态
			logger.error("提现失败！");
		}
			//paymentMoneyWithdraw.setState(PaymentType.WITHDRA_FAILURE);
			//PaymentMoneyWithdrawModel.add(paymentMoneyWithdraw);
		logger.info("提现-回调Notify结束！");
		return sendSuccess();
    }
}
