package com.hzfh.p2p.controller.payment.ajax;

import com.hzfh.api.baseInfo.model.helper.SnEnum;
import com.hzfh.api.payment.model.common.PaymentData;
import com.hzfh.api.payment.model.request.gateway.BindBankCardReq;
import com.hzfh.api.payment.model.request.gateway.UnbindBankCardReq;
import com.hzfh.p2p.controller.common.CommonAction;
import com.hzfh.p2p.controller.payment.notify.BindBankCardNotifyAction;
import com.hzfh.p2p.model.baseInfo.SnModel;
import com.hzfh.p2p.model.common.helper.LogHelper;
import com.hzfh.p2p.model.common.helper.UrlHelper;
import com.hzfh.p2p.model.common.state.StateValues;
import com.hzfh.p2p.model.payment.GatewayModel;

/**
 * Created by Administrator on 2015/6/12.
 */
public class AjaxPaymentUnRindBankCard extends CommonAction{
	public static final LogHelper logger = LogHelper.getLogger(BindBankCardNotifyAction.class.getName());
    private PaymentData paymentData;

    public PaymentData getPaymentData() {
        return paymentData;
    }

    public void setPaymentData(PaymentData paymentData) {
        this.paymentData = paymentData;
    }

    @Override
    public String execute(){
    	logger.info("解除银行卡绑定开始！");
        UnbindBankCardReq unbindBankCardReq = new UnbindBankCardReq();
        //unbindBankCardReq.setRequestNo(SnModel.getSn(SnEnum.SN_UNBIND_BANK_CARD));
        unbindBankCardReq.setRequestNo(SnModel.getSn(SnEnum.SN_UNBIND_BANK_CARD));
        unbindBankCardReq.setCallbackUrl(UrlHelper.bulidWebBackUrl("customer/unBindBankCardCallback"));
        unbindBankCardReq.setPlatformUserNo(String.valueOf(StateValues.getCustomerId()));
        unbindBankCardReq.setPlatformNo(unbindBankCardReq.getPlatformNo());
        try {
			this.paymentData = GatewayModel.unbindBankCardCallback(unbindBankCardReq);
			logger.info("解除银行卡绑定-封装数据，xml、sign、url成功！");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("解除银行卡绑定-封装数据，xml、sign、url失败！");
		}
        return SUCCESS;
    }
}
