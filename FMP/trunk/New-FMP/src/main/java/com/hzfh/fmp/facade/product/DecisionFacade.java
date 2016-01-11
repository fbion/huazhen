package com.hzfh.fmp.facade.product;

import com.hzfh.api.product.model.Decision;
import com.hzfh.api.product.model.query.DecisionCondition;
import com.hzfh.api.product.service.DecisionService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class DecisionFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-product.xml");

    public static PagedList<Decision> getPagingList(DecisionCondition decisionCondition) {
        DecisionService decisionService = (DecisionService) context.getBean("decisionService");

        return  decisionService.getPagingList(decisionCondition);
    }

    public static int add(Decision decision){
        DecisionService decisionService = (DecisionService) context.getBean("decisionService");

        return decisionService.add(decision);
    }

    public static int update(Decision decision){
        DecisionService decisionService = (DecisionService) context.getBean("decisionService");

        return decisionService.update(decision);
    }

    public static List<Decision> getList(){
        DecisionService decisionService = (DecisionService) context.getBean("decisionService");

        return decisionService.getList();
    }

    public static Decision getInfo(int id){
        DecisionService decisionService = (DecisionService) context.getBean("decisionService");

        return decisionService.getInfo(id);
    }

    public static List<Decision> getListByProductNo(int productNo){
        DecisionService decisionService = (DecisionService) context.getBean("decisionService");

        return decisionService.getListByProductNo(productNo);
    }
}
