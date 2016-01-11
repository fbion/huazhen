package com.hzfh.fmp.controller.common;

import com.hzfh.api.payment.model.PaymentyCallbackNotify;
import com.hzfh.fmp.model.payment.PaymentyCallbackNotifyModel;
import com.hzfh.fmp.model.payment.SignModel;
import com.hzframework.xml.XStreamHandler;

public class CallBackAction<T> extends PaymentBaseAction {
	private T resp;

	public T getResp() {
		return resp;
	}

	private String verifyXml;
	@SuppressWarnings("unchecked")
	public void setResp(String resp) {
		verifyXml = resp;
		this.resp= (T) XStreamHandler.toBean(resp,this.getClass());
		addCallbackNotifyResponseData(verifyXml);
	}
	/**
	 * 验签
	 * @return true/false
	 */
	public boolean verifySign(){
		return SignModel.verifySign(verifyXml, getSign());
	}
	//保存回调数据

	private int  addCallbackNotifyResponseData(String param){
		PaymentyCallbackNotify paymentCallbackNotify= new PaymentyCallbackNotify();
		paymentCallbackNotify.setParam(param);
		paymentCallbackNotify.setSign(getSign());
		paymentCallbackNotify.setType("callback");
		return PaymentyCallbackNotifyModel.add(paymentCallbackNotify);
	}
}
