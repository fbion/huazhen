package com.hzfh.service.payment.serviceImpl;

import com.hzfh.api.payment.service.SignService;
import com.hzfh.service.payment.serviceImpl.Helper.SignUtil;
import org.springframework.stereotype.Service;
@Service("signService")
public class SignServiceImpl implements SignService {

	@Override
	public boolean verifySign(String verifyXml, String sign) {
		// 验证签名
		// 如果要在生产上验证易宝的签名,请在第三个参数传入yeepay.com
		return SignUtil.verifySign(verifyXml,sign);
	}
}
