package com.hzfh.api.payment.service;


public interface SignService {
	public boolean verifySign(String verifyXml, String sign);
}
