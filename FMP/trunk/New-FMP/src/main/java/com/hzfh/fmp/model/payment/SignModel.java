package com.hzfh.fmp.model.payment;


import com.hzfh.fmp.facade.payment.SignFacade;

/**
 * Created by Administrator on 2015/6/11.
 */
public class SignModel {

	/**
	 * 验签
	 * @param verifyXml 原始数据
	 * @param sign 签名
	 * @return
	 */
	public static boolean verifySign(String verifyXml, String sign) {
		return SignFacade.verifySign(verifyXml, sign);
	}
}
