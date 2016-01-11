package com.hzfh.weixin.facade.baseInfo;

import com.hzfh.api.baseInfo.model.SmsCaptcha;
import com.hzfh.api.baseInfo.model.query.SmsCaptchaCondition;
import com.hzfh.api.baseInfo.service.SmsCaptchaService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SmsCaptchaFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-baseInfo.xml");

    public static PagedList<SmsCaptcha> getPagingList(SmsCaptchaCondition smsCaptchaCondition) {
        SmsCaptchaService smsCaptchaService = (SmsCaptchaService) context.getBean("smsCaptchaService");

        return  smsCaptchaService.getPagingList(smsCaptchaCondition);
    }

    public static int add(SmsCaptcha smsCaptcha){
        SmsCaptchaService smsCaptchaService = (SmsCaptchaService) context.getBean("smsCaptchaService");

        return smsCaptchaService.add(smsCaptcha);
    }

    public static int update(SmsCaptcha smsCaptcha){
        SmsCaptchaService smsCaptchaService = (SmsCaptchaService) context.getBean("smsCaptchaService");

        return smsCaptchaService.update(smsCaptcha);
    }

    public static List<SmsCaptcha> getList(){
        SmsCaptchaService smsCaptchaService = (SmsCaptchaService) context.getBean("smsCaptchaService");

        return smsCaptchaService.getList();
    }

    public static SmsCaptcha getInfo(int id){
        SmsCaptchaService smsCaptchaService = (SmsCaptchaService) context.getBean("smsCaptchaService");

        return smsCaptchaService.getInfo(id);
    }
}
