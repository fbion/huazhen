package com.hzfh.fmp.facade.product;

import com.hzfh.api.product.model.DecisionLog;
import com.hzfh.api.product.model.query.DecisionLogCondition;
import com.hzfh.api.product.service.DecisionLogService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class DecisionLogFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-product.xml");

    public static PagedList<DecisionLog> getPagingList(DecisionLogCondition decisionLogCondition) {
        DecisionLogService decisionLogService = (DecisionLogService) context.getBean("decisionLogService");

        return  decisionLogService.getPagingList(decisionLogCondition);
    }

    public static int add(DecisionLog decisionLog){
        DecisionLogService decisionLogService = (DecisionLogService) context.getBean("decisionLogService");

        return decisionLogService.add(decisionLog);
    }

    public static int update(DecisionLog decisionLog){
        DecisionLogService decisionLogService = (DecisionLogService) context.getBean("decisionLogService");

        return decisionLogService.update(decisionLog);
    }

    public static List<DecisionLog> getList(){
        DecisionLogService decisionLogService = (DecisionLogService) context.getBean("decisionLogService");

        return decisionLogService.getList();
    }

    public static DecisionLog getInfo(int id){
        DecisionLogService decisionLogService = (DecisionLogService) context.getBean("decisionLogService");

        return decisionLogService.getInfo(id);
    }
}
