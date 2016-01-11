package com.hzfh.p2p.controller.payment.notify;

import com.hzfh.api.customer.model.PaymentCustomerBank;
import com.hzfh.api.customer.model.TradeReqnoInfo;
import com.hzfh.api.payment.model.common.constant.StatusCode;
import com.hzfh.api.payment.model.response.gateway.BindBankCardNotify;
import com.hzfh.p2p.controller.common.NotifyAction;
import com.hzfh.p2p.model.common.helper.LogHelper;
import com.hzfh.p2p.model.common.parameter.StatusType;
import com.hzfh.p2p.model.customer.P2pCustomerModel;
import com.hzfh.p2p.model.customer.PaymentAccountInformationModel;
import com.hzfh.p2p.model.customer.PaymentBankInfoModel;
import com.hzfh.p2p.model.customer.PaymentCustomerBankModel;
import com.hzfh.p2p.model.customer.TradeReqnoInfoModel;


public class BindBankCardNotifyAction extends NotifyAction<BindBankCardNotify> {
	public static final LogHelper logger = LogHelper.getLogger(BindBankCardNotifyAction.class.getName());
    @Override
    public String execute(){
    	logger.info("绑卡-Notify开始！");
    	if (!verifySign()){
        	logger.error("绑卡-签名失败！");
			return null;
        }
		if(getNotify()==null){
			logger.error("绑卡-notify is null！");
			return null;
		}
		TradeReqnoInfo tradeInfo = TradeReqnoInfoModel.getInfoBySnAndIsOk(getNotify().getRequestNo(),1);
		if(Integer.parseInt(this.getNotify().getCode())== StatusCode.SUCCESS&&tradeInfo==null){
			PaymentCustomerBank paymentCustomerBank = new PaymentCustomerBank();
			paymentCustomerBank.setBankCard(getNotify().getCardNo());
			String bankName = PaymentBankInfoModel.getBankByBankCode(getNotify().getBank()).getName();
			paymentCustomerBank.setBankName(bankName);
			paymentCustomerBank.setBankCode(getNotify().getBank());
			paymentCustomerBank.setCustomerNo(Integer.parseInt(getNotify().getPlatformUserNo()));
			String userName = P2pCustomerModel.getInfo(Integer.parseInt(getNotify().getPlatformUserNo())).getUserName();
			paymentCustomerBank.setCustomerName(userName);
			paymentCustomerBank.setState(1);
			int paymentCustomerBankNo=0;
			try {
				paymentCustomerBankNo = PaymentCustomerBankModel.add(paymentCustomerBank);
				logger.info("绑卡-添加客户银行卡表成功！");
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("绑卡-添加客户银行卡表出现异常！",e);
			}
			
			try {
				PaymentAccountInformationModel.updateAuthenticationBankCard(StatusType.BIND_BANK_STATUS,Integer.parseInt(getNotify().getPlatformUserNo()));
				logger.info("绑卡-更新paymenAccountInformation中银行卡的状态成功！");
			} catch (NumberFormatException e1) {
				e1.printStackTrace();
				logger.error("绑卡-更新paymenAccountInformation中银行卡的状态失败！",e1);
			}
			//绑定成功
			TradeReqnoInfo tradeReqnoInfo = new TradeReqnoInfo();
			//tradeReqnoInfo.setCustomerNo(AuthenticationModel.getCustomerId());
			tradeReqnoInfo.setCustomerNo(Integer.parseInt(getNotify().getPlatformUserNo()));
			tradeReqnoInfo.setStatus((byte)8);
			tradeReqnoInfo.setSn(getNotify().getRequestNo());
			tradeReqnoInfo.setIsOk(1);
			tradeReqnoInfo.setBusinessNo(paymentCustomerBankNo);
			try {
				TradeReqnoInfoModel.add(tradeReqnoInfo);
				logger.info("绑卡-TradeReqnoInfo添加成功！ ");
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("绑卡-TradeReqnoInfo添加出现异常！ ",e);
			}
			logger.info("绑卡-绑卡成功");
    	}else{
    		logger.error("绑卡-绑卡失败！");
    	}
        
        /*TradeReqnoInfo tradeReqnoInfo = new TradeReqnoInfo();
        tradeReqnoInfo.setCustomerNo(Integer.parseInt(getNotify().getPlatformUserNo()));
        tradeReqnoInfo.setStatus((byte)8);
        tradeReqnoInfo.setSn(getNotify().getRequestNo());
        tradeReqnoInfo.setIsOk(0);
        TradeReqnoInfoModel.add(tradeReqnoInfo);*/
        //失败
		logger.info("绑卡-Notify结束！");
		return sendSuccess();
    }

}
