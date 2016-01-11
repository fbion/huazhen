package com.hzfh.fmp.facade.baseInfo;

import com.hzfh.api.baseInfo.model.EmailFiles;
import com.hzfh.api.baseInfo.model.query.EmailFilesCondition;
import com.hzfh.api.baseInfo.service.EmailFilesService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class EmailFilesFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-baseInfo.xml");

    public static PagedList<EmailFiles> getPagingList(EmailFilesCondition emailFilesCondition) {
        EmailFilesService emailFilesService = (EmailFilesService) context.getBean("emailFilesService");

        return  emailFilesService.getPagingList(emailFilesCondition);
    }

    public static int add(EmailFiles emailFiles){
        EmailFilesService emailFilesService = (EmailFilesService) context.getBean("emailFilesService");

        return emailFilesService.add(emailFiles);
    }

    public static int update(EmailFiles emailFiles){
        EmailFilesService emailFilesService = (EmailFilesService) context.getBean("emailFilesService");

        return emailFilesService.update(emailFiles);
    }

    public static List<EmailFiles> getList(){
        EmailFilesService emailFilesService = (EmailFilesService) context.getBean("emailFilesService");

        return emailFilesService.getList();
    }

    public static EmailFiles getInfo(int id){
        EmailFilesService emailFilesService = (EmailFilesService) context.getBean("emailFilesService");

        return emailFilesService.getInfo(id);
    }
}
