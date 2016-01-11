package com.hzfh.p2p.controller.payment.ajax;

import com.hzfh.api.baseInfo.model.helper.SnEnum;
import com.hzfh.api.customer.model.PaymentAccountInformation;
import com.hzfh.api.payment.model.common.PaymentData;
import com.hzfh.api.payment.model.request.gateway.BindBankCardReq;
import com.hzfh.p2p.controller.common.CommonAction;
import com.hzfh.p2p.controller.payment.notify.BindBankCardNotifyAction;
import com.hzfh.p2p.model.baseInfo.SnModel;
import com.hzfh.p2p.model.common.AuthenticationModel;
import com.hzfh.p2p.model.common.helper.LogHelper;
import com.hzfh.p2p.model.common.helper.UrlHelper;
import com.hzfh.p2p.model.common.state.StateValues;
import com.hzfh.p2p.model.customer.PaymentAccountInformationModel;
import com.hzfh.p2p.model.payment.GatewayModel;

/**
 * Created by Administrator on 2015/6/11.
 */
public class AjaxPaymentRindBankCard extends CommonAction {
	public static final LogHelper logger = LogHelper.getLogger(BindBankCardNotifyAction.class.getName());
    private PaymentData paymentData;
    private int realnameStatus;
    public int getRealnameStatus() {
		return realnameStatus;
	}

	public PaymentData getPaymentData() {
        return paymentData;
    }

    public void setPaymentData(PaymentData paymentData) {
        this.paymentData = paymentData;
    }

    @Override
    public String execute(){
    	logger.info("绑定银行卡开始！");
    	
    	int customerNo = AuthenticationModel.getCustomerId();
    	PaymentAccountInformation paymentAccountInformation = PaymentAccountInformationModel.getInfoByCustomerNo(customerNo);
    	if(paymentAccountInformation!=null){
    		this.realnameStatus = paymentAccountInformation.getAuthenticationName();
    		if(realnameStatus==0){
    			return SUCCESS;
    		}
    	}
        BindBankCardReq bindBankCardReq = new BindBankCardReq();
        bindBankCardReq.setCallbackUrl(UrlHelper.bulidWebBackUrl("customer/bindBankCardCallback"));
        bindBankCardReq.setPlatformUserNo(String.valueOf(StateValues.getCustomerId()));
       //bindBankCardReq.setRequestNo(SnModel.getSn(SnEnum.SN_BIND_BANK_CARD));
        bindBankCardReq.setRequestNo(SnModel.getSn(SnEnum.SN_BIND_BANK_CARD));
        bindBankCardReq.setNotifyUrl(UrlHelper.bulidWebBackUrl("customer/bindBankCardNotify"));
        bindBankCardReq.setPlatformNo(bindBankCardReq.getPlatformNo());
        try {
			this.paymentData = GatewayModel.rindBankCard(bindBankCardReq);
			logger.info("绑卡-封装绑卡数据，xml、sign、url成功！");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("绑卡-封装绑卡数据，xml、sign、url成功！");
		}  
        return SUCCESS;
    }
    
    /*public String checkRealnameAuthentication(){
    	int customerNo = AuthenticationModel.getCustomerId();
    	PaymentAccountInformation paymentAccountInformation = PaymentAccountInformationModel.getInfoByCustomerNo(customerNo);
    	if(paymentAccountInformation!=null){
    		this.realnameStatus = paymentAccountInformation.getAuthenticationName();
    	}
    	return SUCCESS;
    }*/
}
