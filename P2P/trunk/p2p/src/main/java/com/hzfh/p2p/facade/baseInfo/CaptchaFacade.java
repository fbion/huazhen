package com.hzfh.p2p.facade.baseInfo;

import com.hzfh.api.baseInfo.model.Captcha;
import com.hzfh.api.baseInfo.model.query.CaptchaCondition;
import com.hzfh.api.baseInfo.service.CaptchaService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class CaptchaFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-baseInfo.xml");

    public static PagedList<Captcha> getPagingList(CaptchaCondition captchaCondition) {
        CaptchaService captchaService = (CaptchaService) context.getBean("captchaService");

        return  captchaService.getPagingList(captchaCondition);
    }

    public static int add(Captcha captcha){
        CaptchaService captchaService = (CaptchaService) context.getBean("captchaService");

        return captchaService.add(captcha);
    }

    public static int update(Captcha captcha){
        CaptchaService captchaService = (CaptchaService) context.getBean("captchaService");

        return captchaService.update(captcha);
    }

    public static List<Captcha> getList(){
        CaptchaService captchaService = (CaptchaService) context.getBean("captchaService");

        return captchaService.getList();
    }

    public static Captcha getInfo(int id){
        CaptchaService captchaService = (CaptchaService) context.getBean("captchaService");

        return captchaService.getInfo(id);
    }

	public static Captcha selectByIdAndCode(int id, String code) {
		CaptchaService captchaService = (CaptchaService) context.getBean("captchaService");
		return captchaService.selectByIdAndCode(id,code);
	}

    public static int delete(int id){
        CaptchaService captchaService = (CaptchaService) context.getBean("captchaService");
        return captchaService.delete(id);
    }
}
