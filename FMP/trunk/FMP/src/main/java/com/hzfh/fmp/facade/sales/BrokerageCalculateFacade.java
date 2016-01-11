package com.hzfh.fmp.facade.sales;

import com.hzfh.api.sales.model.BrokerageCalculate;
import com.hzfh.api.sales.model.query.BrokerageCalculateCondition;
import com.hzfh.api.sales.service.BrokerageCalculateService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class BrokerageCalculateFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-sales.xml");

    public static PagedList<BrokerageCalculate> getPagingList(BrokerageCalculateCondition brokerageCalculateCondition) {
        BrokerageCalculateService brokerageCalculateService = (BrokerageCalculateService) context.getBean("brokerageCalculateService");

        return  brokerageCalculateService.getPagingList(brokerageCalculateCondition);
    }

    public static int add(BrokerageCalculate brokerageCalculate){
        BrokerageCalculateService brokerageCalculateService = (BrokerageCalculateService) context.getBean("brokerageCalculateService");

        return brokerageCalculateService.add(brokerageCalculate);
    }

    public static int update(BrokerageCalculate brokerageCalculate){
        BrokerageCalculateService brokerageCalculateService = (BrokerageCalculateService) context.getBean("brokerageCalculateService");

        return brokerageCalculateService.update(brokerageCalculate);
    }

    public static List<BrokerageCalculate> getList(){
        BrokerageCalculateService brokerageCalculateService = (BrokerageCalculateService) context.getBean("brokerageCalculateService");

        return brokerageCalculateService.getList();
    }

    public static BrokerageCalculate getInfo(int id){
        BrokerageCalculateService brokerageCalculateService = (BrokerageCalculateService) context.getBean("brokerageCalculateService");

        return brokerageCalculateService.getInfo(id);
    }
}
