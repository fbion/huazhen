package com.hzfh.p2p.facade.baseInfo;

import com.hzfh.api.baseInfo.model.Sms;
import com.hzfh.api.baseInfo.model.query.SmsCondition;
import com.hzfh.api.baseInfo.service.SmsService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SmsFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-baseInfo.xml");

    public static PagedList<Sms> getPagingList(SmsCondition smsCondition) {
        SmsService smsService = (SmsService) context.getBean("smsService");

        return  smsService.getPagingList(smsCondition);
    }

    public static int add(Sms sms){
        SmsService smsService = (SmsService) context.getBean("smsService");

        return smsService.add(sms);
    }

    public static int update(Sms sms){
        SmsService smsService = (SmsService) context.getBean("smsService");

        return smsService.update(sms);
    }

    public static List<Sms> getList(){
        SmsService smsService = (SmsService) context.getBean("smsService");

        return smsService.getList();
    }

    public static Sms getInfo(int id){
        SmsService smsService = (SmsService) context.getBean("smsService");

        return smsService.getInfo(id);
    }
    public static String verification(String telephone){
        SmsService smsService = (SmsService) context.getBean("smsService");

        return smsService.verification(telephone);
    }
}
