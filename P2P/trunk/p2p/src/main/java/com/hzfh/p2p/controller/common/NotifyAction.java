package com.hzfh.p2p.controller.common;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;

import com.hzfh.api.payment.model.PaymentyCallbackNotify;
import com.hzfh.p2p.model.common.helper.LogHelper;
import com.hzfh.p2p.model.payment.PaymentyCallbackNotifyModel;
import com.hzfh.p2p.model.payment.SignModel;
import com.hzframework.helper.StringHelper;
import com.hzframework.xml.XStreamHandler;


public class NotifyAction<T> extends PaymentBaseAction implements ServletResponseAware{
	public static final LogHelper logger = LogHelper.getLogger(NotifyAction.class.getName());
	
	private T notify;
	private String verifyXml="";
	public T getNotify() {
		return notify;
	}
	public HttpServletResponse getResponse() {
		return response;
	}
	private HttpServletResponse response;
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
	
	public void setNotify(String notify) {
		verifyXml = notify;
		System.out.println(notify);
		this.notify= (T) XStreamHandler.toBean(notify,this.getClass());
	}
	public boolean verifySign(){
		//addCallbackNotify();
		if(StringHelper.isNullOrEmpty(verifyXml)){
			logger.error("notify收到的原始xml数据为空!");
			return false;
		}
		if(StringHelper.isNullOrEmpty(getSign())){
			logger.error("notify收到签名数据为空!");
			return false;
		}
		return SignModel.verifySign(verifyXml,getSign());
		//return true;
	}
	public String sendSuccess(){
		try {
			response.getWriter().write("SUCCESS");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
    public void addCallbackNotify() {
		PaymentyCallbackNotify paymentCallbackNotify= new PaymentyCallbackNotify();
		paymentCallbackNotify.setOperType(this.notify.getClass().getName());
		paymentCallbackNotify.setParam(verifyXml);
		paymentCallbackNotify.setSign(getSign());
		paymentCallbackNotify.setType("notify");
		PaymentyCallbackNotifyModel.add(paymentCallbackNotify);
        //return SUCCESS;
	}
}
