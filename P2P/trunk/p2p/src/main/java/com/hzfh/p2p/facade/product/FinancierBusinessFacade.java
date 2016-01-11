package com.hzfh.p2p.facade.product;

import com.hzfh.api.product.model.FinancierBusiness;
import com.hzfh.api.product.model.query.FinancierBusinessCondition;
import com.hzfh.api.product.service.FinancierBusinessService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class FinancierBusinessFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-product.xml");

    public static PagedList<FinancierBusiness> getPagingList(FinancierBusinessCondition financierBusinessCondition) {
        FinancierBusinessService financierBusinessService = (FinancierBusinessService) context.getBean("financierBusinessService");

        return  financierBusinessService.getPagingList(financierBusinessCondition);
    }

    public static int add(FinancierBusiness financierBusiness){
        FinancierBusinessService financierBusinessService = (FinancierBusinessService) context.getBean("financierBusinessService");

        return financierBusinessService.add(financierBusiness);
    }

    public static int update(FinancierBusiness financierBusiness){
        FinancierBusinessService financierBusinessService = (FinancierBusinessService) context.getBean("financierBusinessService");

        return financierBusinessService.update(financierBusiness);
    }

    public static List<FinancierBusiness> getList(){
        FinancierBusinessService financierBusinessService = (FinancierBusinessService) context.getBean("financierBusinessService");

        return financierBusinessService.getList();
    }

    public static FinancierBusiness getInfo(int id){
        FinancierBusinessService financierBusinessService = (FinancierBusinessService) context.getBean("financierBusinessService");

        return financierBusinessService.getInfo(id);
    }
}
