package com.hzfh.p2p.controller.common;

import com.hzfh.api.payment.model.PaymentyCallbackNotify;
import com.hzfh.p2p.model.common.helper.LogHelper;
import com.hzfh.p2p.model.payment.PaymentyCallbackNotifyModel;
import com.hzfh.p2p.model.payment.SignModel;
import com.hzframework.helper.StringHelper;
import com.hzframework.xml.XStreamHandler;

public class CallBackAction<T> extends PaymentBaseAction {
	public static final LogHelper logger = LogHelper.getLogger(CallBackAction.class.getName());
	private T resp;

	public T getResp() {
		return resp;
	}

	private String verifyXml;
	@SuppressWarnings("unchecked")
	public void setResp(String resp) {
		verifyXml = resp;
		this.resp= (T) XStreamHandler.toBean(resp,this.getClass());
	}
	/**
	 * 验签
	 * @return true/false
	 */
	public boolean verifySign(){
		addCallbackNotify();
		if(StringHelper.isNullOrEmpty(verifyXml)){
			logger.error("callback收到的原始xml数据为空!");
			return false;
		}
		if(StringHelper.isNullOrEmpty(getSign())){
			logger.error("callback收到签名数据为空!");
			return false;
		}
		return SignModel.verifySign(verifyXml,getSign());
	}
	//保存回调数据
    public String addCallbackNotify() {
		try {
			PaymentyCallbackNotify paymentCallbackNotify= new PaymentyCallbackNotify();
			if(this.resp!=null){
				paymentCallbackNotify.setOperType(this.resp.getClass().getName());
			}
			paymentCallbackNotify.setParam(verifyXml);
			paymentCallbackNotify.setSign(getSign());
			paymentCallbackNotify.setType("callback");
			PaymentyCallbackNotifyModel.add(paymentCallbackNotify);
			logger.info("保存回调callback数据成功！");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("保存回调callback数据失败！",e);
		}
        return SUCCESS;
	}
}
