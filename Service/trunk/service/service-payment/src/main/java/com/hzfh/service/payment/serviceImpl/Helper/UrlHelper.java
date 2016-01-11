package com.hzfh.service.payment.serviceImpl.Helper;

public class UrlHelper {
    public static String bulidGatewayUrl(String url){
    	return WebInfoHelper.PAYMENT_URL_GATEWAY+ "/"+url;
    }
    public static String bulidConnectionUrl(){
    	return WebInfoHelper.PAYMENT_URL_CONNECTION;
    }
}
