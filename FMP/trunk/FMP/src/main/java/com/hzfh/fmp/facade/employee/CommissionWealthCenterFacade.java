package com.hzfh.fmp.facade.employee;

import com.hzfh.api.employee.model.CommissionWealthCenter;
import com.hzfh.api.employee.model.query.CommissionWealthCenterCondition;
import com.hzfh.api.employee.service.CommissionWealthCenterService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class CommissionWealthCenterFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-employee.xml");

    public static PagedList<CommissionWealthCenter> getPagingList(CommissionWealthCenterCondition commissionWealthCenterCondition) {
        CommissionWealthCenterService commissionWealthCenterService = (CommissionWealthCenterService) context.getBean("commissionWealthCenterService");

        return  commissionWealthCenterService.getPagingList(commissionWealthCenterCondition);
    }

    public static int add(CommissionWealthCenter commissionWealthCenter){
        CommissionWealthCenterService commissionWealthCenterService = (CommissionWealthCenterService) context.getBean("commissionWealthCenterService");

        return commissionWealthCenterService.add(commissionWealthCenter);
    }

    public static int update(CommissionWealthCenter commissionWealthCenter){
        CommissionWealthCenterService commissionWealthCenterService = (CommissionWealthCenterService) context.getBean("commissionWealthCenterService");

        return commissionWealthCenterService.update(commissionWealthCenter);
    }

    public static List<CommissionWealthCenter> getList(){
        CommissionWealthCenterService commissionWealthCenterService = (CommissionWealthCenterService) context.getBean("commissionWealthCenterService");

        return commissionWealthCenterService.getList();
    }

    public static CommissionWealthCenter getInfo(int id){
        CommissionWealthCenterService commissionWealthCenterService = (CommissionWealthCenterService) context.getBean("commissionWealthCenterService");

        return commissionWealthCenterService.getInfo(id);
    }

    public static List<CommissionWealthCenter> getListForExcel(CommissionWealthCenterCondition commissionWealthCenterCondition){
        CommissionWealthCenterService commissionWealthCenterService = (CommissionWealthCenterService) context.getBean("commissionWealthCenterService");
        return commissionWealthCenterService.getListForExcel(commissionWealthCenterCondition);


    }
}
