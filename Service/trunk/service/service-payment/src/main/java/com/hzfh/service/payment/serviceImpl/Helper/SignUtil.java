package com.hzfh.service.payment.serviceImpl.Helper;

import com.hzframework.helper.HttpHelper;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class SignUtil {

	public static String sign(String sourceMessage) {
		
		Map<String, String> params = new HashMap<String, String>();
		try {
			params.put("req",URLEncoder.encode(sourceMessage, "utf-8") );
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		String url = "http://127.0.0.1:8088/sign";
		String signMsg="";
		try {
			signMsg = HttpHelper.doPost(url, params);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return signMsg;
		
		/*JKey privateKey;
		X509Cert publicKey;
		
		String password ="jinkong@20150617";
		String fileName = "cfca.pfx";
		
		String rootPath = SignUtil.class.getResource("/").getPath();
	        if (rootPath.contains(":"))
	            rootPath = StringHelper.trimStart(rootPath,"/");//"/../../"
	    String file=  StringHelper.trimEnd(rootPath, "/") + "/"+fileName;
	        
		try {
			
			privateKey = CFCACertSignUtils.getPrivateKey(file, password);
			publicKey = CFCACertSignUtils.getPublicKey(file, password);
		} catch (Exception e) {
			throw new RuntimeException(file+"+++"+password,e);
		}

		String signMsg = CFCACertSignUtils.sign(sourceMessage, privateKey,
				new X509Cert[] { publicKey }, "UTF-8");
		return signMsg;*/
		//return "123456";

	}

	public static boolean verifySign(String sourceMessage, String signMsg) {
		
		Map<String, String> params = new HashMap<String, String>();
		try {
			params.put("req", URLEncoder.encode(sourceMessage, "utf-8"));
			params.put("sign", URLEncoder.encode(signMsg, "utf-8"));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		
		String url = "http://127.0.0.1:8088/verify";
		String result="";
		try {
			result = HttpHelper.doPost(url, params);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if("SUCCESS".equals(result)){
			return true;
		}
		return false;
		//return CFCACertSignUtils.verifySign(sourceMessage, signMsg,"yeepay.com");
		//return true;
	}

}
