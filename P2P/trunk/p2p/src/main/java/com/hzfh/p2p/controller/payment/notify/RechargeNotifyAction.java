package com.hzfh.p2p.controller.payment.notify;

import com.hzfh.api.customer.model.PaymentMoneyChange;
import com.hzfh.api.customer.model.PaymentMoneyRecharge;
import com.hzfh.api.payment.model.ExamineCallbackRecord;
import com.hzfh.api.payment.model.common.constant.QueryType;
import com.hzfh.api.payment.model.common.constant.StatusCode;
import com.hzfh.api.payment.model.response.gateway.RechargeNotify;
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
import com.hzfh.p2p.model.payment.ExamineCallbackRecordModel;

public class RechargeNotifyAction extends NotifyAction<RechargeNotify> {
	public static final LogHelper logger = LogHelper.getLogger(RechargeNotifyAction.class.getName());
    @Override
    public String execute() {
    	logger.info("充值Notify开始！");
        if (!verifySign()){
        	logger.error("充值-验签失败!");
			return null;
        }
		if(getNotify()==null){
			logger.error("充值-notify is null!");
			return null;
		}
		RechargeNotify rechargeNotify = this.getNotify();
		PaymentMoneyRecharge paymentMoneyRecharge = new PaymentMoneyRecharge();
		
		
		String operationType = QueryType.QUERY_RECHARGE;
		String sn = rechargeNotify.getRequestNo();
		
		
		ExamineCallbackRecord examineCallbackRecord  = new ExamineCallbackRecord();
		try {
			examineCallbackRecord = ExamineCallbackRecordModel.getinfoByoperationTypeAndSn(operationType,sn);
			logger.info("【充值】通过QUERY_RECHARGE,sn获取examineCallbackRecord！");
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error("【充值】通过QUERY_RECHARGE,sn获取examineCallbackRecord失败！", e1);
		}
		
		byte callbackStatus = examineCallbackRecord.getStatus();
		if(callbackStatus==QueryType.QUERY_YES_NOTIFY){
			logger.info("【充值】examineCallbackRecord记录中已经有notify,操作不在向下进行！");
			return sendSuccess();
		}
		
		
        if (Integer.parseInt(rechargeNotify.getCode()) == StatusCode.SUCCESS ) {
        	try {
        		logger.info("【充值】examineCallbackRecord记录中没有notify,更新记录中的status开始！");
        		ExamineCallbackRecordModel.updateStatusByoperationTypeAndSn(QueryType.QUERY_YES_NOTIFY,operationType,sn);
        		logger.info("【充值】examineCallbackRecord记录中没有notify,更新记录中的status成功！");
        	} catch (Exception e2) {
        		logger.error("【充值】examineCallbackRecord记录中没有notify,更新记录中的status失败！",e2);
        	}
        	double money = Double.parseDouble(rechargeNotify.getAmount());
        	int customerNo = Integer.parseInt(rechargeNotify.getPlatformUserNo());
        	PaymentMoneyRecharge payMoneyRecharge = PaymentMoneyRechargeModel.getInfoByStateAndSn(PaymentType.RECHARGE_SUCCESS,rechargeNotify.getRequestNo());
        	if(payMoneyRecharge==null){
        		try {
        			paymentMoneyRecharge.setMoneyFactorage(Double.parseDouble(rechargeNotify.getFee()));
        			paymentMoneyRecharge.setCustomerMoneyFactorage(rechargeNotify.getFeeMode());
        			paymentMoneyRecharge.setResultCode(rechargeNotify.getCode());
        			paymentMoneyRecharge.setResultNote(rechargeNotify.getMessage());
        			paymentMoneyRecharge.setState(PaymentType.RECHARGE_SUCCESS);
        			paymentMoneyRecharge.setAmount(money);
        			paymentMoneyRecharge.setSn(rechargeNotify.getRequestNo());
        			PaymentMoneyRechargeModel.updateRecharge(paymentMoneyRecharge);
        			logger.info("充值-更新充值表成功！");
        		} catch (Exception e) {
        			e.printStackTrace();
        			logger.error("充值-更新充值表异常！", e);
        		}
        		try {
        			PaymentAccountInformationModel.updateMoneyAmount(money,customerNo);
        			logger.info("充值-更新账户详情表payment_account_information总金额成功！");
        		} catch (Exception e) {
        			e.printStackTrace();
        			logger.error("充值-更新账户详情表payment_account_information总金额失败！");
        		}
        		try {
        			PaymentAccountInformationModel.updateMoneyWithDarw(money, customerNo);
        			logger.info("充值-更新账户详情表payment_account_information可提现金额成功！");
        		} catch (Exception e) {
        			e.printStackTrace();
        			logger.error("充值-更新账户详情表payment_account_information可提现金额失败！");
        		}
        	}

			PaymentMoneyChange payMoneyChange =PaymentMoneyChangeModel.getInfoByMoneyChangeTypeAndRefSn(PaymentType.MONEYCHANGE_RECHARGE, rechargeNotify.getRequestNo());
			if(payMoneyChange==null){
				try {
					PaymentMoneyChange paymentMoneyChange = new PaymentMoneyChange();
					paymentMoneyChange.setP2pCustomerNo(customerNo);
					paymentMoneyChange.setMoneyChangeType(PaymentType.MONEYCHANGE_RECHARGE);
					paymentMoneyChange.setMoneyWithdraw(money);
					paymentMoneyChange.setRefSn(rechargeNotify.getRequestNo());
					double moneyAmountLater =PaymentAccountInformationModel.getInfoByCustomerNo(customerNo).getMoneyAmount();
					paymentMoneyChange.setMoneyAmountLater(moneyAmountLater);
					PaymentMoneyChangeModel.add(paymentMoneyChange);
					logger.info("充值-更新资金变动流水表成功！");
				} catch (Exception e) {
					e.printStackTrace();
					logger.error("充值-更新资金变动流水表异常！", e);
				}
			}
            logger.info("充值成功！");
            SmsModel.smsRechargeSuccess(P2pCustomerModel.getInfo(customerNo).getCellphone(), WebInfoHelper.WEB_P2P_WWW, String.valueOf(paymentMoneyRecharge.getAmount()), ContactInfo.P2P_HOTLINE);
        }else{
        	PaymentMoneyRechargeModel.updateStateBySn(sn,PaymentType.RECHARGE_FAILURE);//更新充值状态
        	logger.error("充值失败！");
        }
        logger.info("充值Notify结束！");
		return sendSuccess();
    }
}
