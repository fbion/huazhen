package com.hzfh.fmp.controller.common;

import com.hzfh.api.payment.model.PaymentyCallbackNotify;
import com.hzfh.fmp.model.payment.PaymentyCallbackNotifyModel;
import com.hzfh.fmp.model.payment.SignModel;
import com.hzframework.xml.XStreamHandler;
import org.apache.struts2.interceptor.ServletResponseAware;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class NotifyAction<T> extends PaymentBaseAction implements ServletResponseAware {
	
	
	//private String notify;
	
	
	private T notify;
	private String verifyXml;
	private HttpServletResponse response;
	public T getNotify() {
		return notify;
	}

	public void setNotify(String notify) {
		//this.notify = (todo)notify;
		verifyXml = notify;
		System.out.println(notify);
		this.notify= (T) XStreamHandler.toBean(notify,this.getClass());
		addCallbackNotifyResponseData(verifyXml);
	}
	public boolean verifySign(){
		return SignModel.verifySign(verifyXml, getSign());
	}

	public void sendSuccess(){
		try {
			response.getWriter().write("SUCCESS");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private int  addCallbackNotifyResponseData(String param){
		PaymentyCallbackNotify paymentCallbackNotify= new PaymentyCallbackNotify();
		paymentCallbackNotify.setParam(param);
		paymentCallbackNotify.setSign(getSign());
		paymentCallbackNotify.setType("notify");
		return PaymentyCallbackNotifyModel.add(paymentCallbackNotify);
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}


}
