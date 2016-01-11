package com.hzfh.fmp.facade.payment;

import com.hzfh.api.payment.service.SignService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2015/6/11.
 */
public class SignFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-payment.xml");

	public static boolean verifySign(String verifyXml, String sign) {
		SignService signService = (SignService) context.getBean("signService");
	    return signService.verifySign(verifyXml,sign);
	}
}
