package com.hzfh.weixin.facade.sales;

import com.hzfh.api.sales.model.P2pInvestment;
import com.hzfh.api.sales.model.query.P2pInvestmentCondition;
import com.hzfh.api.sales.service.P2pInvestmentService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class P2pInvestmentFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-sales.xml");

    public static PagedList<P2pInvestment> getPagingList(P2pInvestmentCondition p2pInvestmentCondition) {
        P2pInvestmentService p2pInvestmentService = (P2pInvestmentService) context.getBean("p2pInvestmentService");

        return  p2pInvestmentService.getPagingList(p2pInvestmentCondition);
    }

    public static int add(P2pInvestment p2pInvestment){
        P2pInvestmentService p2pInvestmentService = (P2pInvestmentService) context.getBean("p2pInvestmentService");

        return p2pInvestmentService.add(p2pInvestment);
    }

    public static int update(P2pInvestment p2pInvestment){
        P2pInvestmentService p2pInvestmentService = (P2pInvestmentService) context.getBean("p2pInvestmentService");

        return p2pInvestmentService.update(p2pInvestment);
    }

    public static List<P2pInvestment> getList(){
        P2pInvestmentService p2pInvestmentService = (P2pInvestmentService) context.getBean("p2pInvestmentService");

        return p2pInvestmentService.getList();
    }

    public static P2pInvestment getInfo(int id){
        P2pInvestmentService p2pInvestmentService = (P2pInvestmentService) context.getBean("p2pInvestmentService");

        return p2pInvestmentService.getInfo(id);
    }
}
