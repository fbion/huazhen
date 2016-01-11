package com.hzfh.fmp.facade.product;

import com.hzfh.api.product.model.FinancierPersonal;
import com.hzfh.api.product.model.query.FinancierPersonalCondition;
import com.hzfh.api.product.service.FinancierPersonalService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class FinancierPersonalFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-product.xml");

    public static PagedList<FinancierPersonal> getPagingList(FinancierPersonalCondition financierPersonalCondition) {
        FinancierPersonalService financierPersonalService = (FinancierPersonalService) context.getBean("financierPersonalService");

        return  financierPersonalService.getPagingList(financierPersonalCondition);
    }

    public static int add(FinancierPersonal financierPersonal){
        FinancierPersonalService financierPersonalService = (FinancierPersonalService) context.getBean("financierPersonalService");

        return financierPersonalService.add(financierPersonal);
    }

    public static int update(FinancierPersonal financierPersonal){
        FinancierPersonalService financierPersonalService = (FinancierPersonalService) context.getBean("financierPersonalService");

        return financierPersonalService.update(financierPersonal);
    }

    public static List<FinancierPersonal> getList(){
        FinancierPersonalService financierPersonalService = (FinancierPersonalService) context.getBean("financierPersonalService");

        return financierPersonalService.getList();
    }

    public static FinancierPersonal getInfo(int id){
        FinancierPersonalService financierPersonalService = (FinancierPersonalService) context.getBean("financierPersonalService");

        return financierPersonalService.getInfo(id);
    }
}
