package com.hzfh.p2p.facade.customer;

import com.hzfh.api.customer.model.EmailChange;
import com.hzfh.api.customer.model.query.EmailChangeCondition;
import com.hzfh.api.customer.service.EmailChangeService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class EmailChangeFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-customer.xml");

    public static PagedList<EmailChange> getPagingList(EmailChangeCondition emailChangeCondition) {
        EmailChangeService emailChangeService = (EmailChangeService) context.getBean("emailChangeService");

        return  emailChangeService.getPagingList(emailChangeCondition);
    }

    public static int add(EmailChange emailChange){
        EmailChangeService emailChangeService = (EmailChangeService) context.getBean("emailChangeService");

        return emailChangeService.add(emailChange);
    }

    public static int update(EmailChange emailChange){
        EmailChangeService emailChangeService = (EmailChangeService) context.getBean("emailChangeService");

        return emailChangeService.update(emailChange);
    }

    public static List<EmailChange> getList(){
        EmailChangeService emailChangeService = (EmailChangeService) context.getBean("emailChangeService");

        return emailChangeService.getList();
    }

    public static EmailChange getInfo(int id){
        EmailChangeService emailChangeService = (EmailChangeService) context.getBean("emailChangeService");

        return emailChangeService.getInfo(id);
    }

	public static List<EmailChange> getListByCondition(EmailChangeCondition emailChangeCondition) {
		EmailChangeService emailChangeService = (EmailChangeService) context.getBean("emailChangeService");

        return emailChangeService.getListByCondition(emailChangeCondition);
	}
}
