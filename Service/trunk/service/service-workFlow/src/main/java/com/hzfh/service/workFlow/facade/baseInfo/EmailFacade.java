package com.hzfh.service.workFlow.facade.baseInfo;


import com.hzfh.api.baseInfo.model.Email;
import com.hzfh.api.baseInfo.service.EmailService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by paul on 15-6-16.
 */
public class EmailFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-serviceTask.xml");

    public static int add(Email email){
        EmailService emailService = (EmailService) context.getBean("emailService");
        return emailService.add(email);
    }

}
