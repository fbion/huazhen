package com.hzfh.fmp.facade.customer;

import com.hzfh.api.customer.model.ChangeManagerLog;
import com.hzfh.api.customer.model.query.ChangeManagerLogCondition;
import com.hzfh.api.customer.service.ChangeManagerLogService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ChangeManagerLogFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-customer.xml");

    public static PagedList<ChangeManagerLog> getPagingList(ChangeManagerLogCondition changeManagerLogCondition) {
        ChangeManagerLogService changeManagerLogService = (ChangeManagerLogService) context.getBean("changeManagerLogService");

        return  changeManagerLogService.getPagingList(changeManagerLogCondition);
    }

    public static int add(ChangeManagerLog changeManagerLog){
        ChangeManagerLogService changeManagerLogService = (ChangeManagerLogService) context.getBean("changeManagerLogService");

        return changeManagerLogService.add(changeManagerLog);
    }

    public static int update(ChangeManagerLog changeManagerLog){
        ChangeManagerLogService changeManagerLogService = (ChangeManagerLogService) context.getBean("changeManagerLogService");

        return changeManagerLogService.update(changeManagerLog);
    }

    public static List<ChangeManagerLog> getList(){
        ChangeManagerLogService changeManagerLogService = (ChangeManagerLogService) context.getBean("changeManagerLogService");

        return changeManagerLogService.getList();
    }

    public static ChangeManagerLog getInfo(int id){
        ChangeManagerLogService changeManagerLogService = (ChangeManagerLogService) context.getBean("changeManagerLogService");

        return changeManagerLogService.getInfo(id);
    }
}
