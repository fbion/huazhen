package com.hzfh.fmp.facade.baseInfo;

import com.hzfh.api.baseInfo.model.Email;
import com.hzfh.api.baseInfo.model.query.EmailCondition;
import com.hzfh.api.baseInfo.service.EmailService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class EmailFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-baseInfo.xml");

    public static PagedList<Email> getPagingList(EmailCondition emailCondition) {
        EmailService emailService = (EmailService) context.getBean("emailService");

        return  emailService.getPagingList(emailCondition);
    }

    public static int add(Email email){
        EmailService emailService = (EmailService) context.getBean("emailService");

        return emailService.add(email);
    }

    public static int update(Email email){
        EmailService emailService = (EmailService) context.getBean("emailService");

        return emailService.update(email);
    }

    public static List<Email> getList(){
        EmailService emailService = (EmailService) context.getBean("emailService");

        return emailService.getList();
    }

    public static Email getInfo(int id){
        EmailService emailService = (EmailService) context.getBean("emailService");

        return emailService.getInfo(id);
    }
}
