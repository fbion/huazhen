package com.hzfh.fmp.facade.sales;

import com.hzfh.api.sales.model.Creditor;
import com.hzfh.api.sales.model.query.CreditorCondition;
import com.hzfh.api.sales.service.CreditorService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class CreditorFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-sales.xml");

    public static PagedList<Creditor> getPagingList(CreditorCondition creditorCondition) {
        CreditorService creditorService = (CreditorService) context.getBean("creditorService");

        return creditorService.getPagingList(creditorCondition);
    }

    public static int add(Creditor creditor) {
        CreditorService creditorService = (CreditorService) context.getBean("creditorService");

        return creditorService.add(creditor);
    }

    public static int update(Creditor creditor) {
        CreditorService creditorService = (CreditorService) context.getBean("creditorService");

        return creditorService.update(creditor);
    }

    public static List<Creditor> getListByPrductNo(int productNo) {
        CreditorService creditorService = (CreditorService) context.getBean("creditorService");

        return creditorService.getListByPrductNo(productNo);
    }

    public static List<Creditor> getList() {
        CreditorService creditorService = (CreditorService) context.getBean("creditorService");

        return creditorService.getList();
    }

    public static Creditor getInfo(int id) {
        CreditorService creditorService = (CreditorService) context.getBean("creditorService");

        return creditorService.getInfo(id);
    }

    public static int updateRemainAmountById(int id, double money) {
        CreditorService creditorService = (CreditorService) context.getBean("creditorService");

        return creditorService.updateRemainAmountById(id, money);
    }

    public static Creditor getInfoEffectiveByProductNo(int productNo) {
        CreditorService creditorService = (CreditorService) context.getBean("creditorService");

        return creditorService.getInfoEffectiveByProductNo(productNo);
    }

    public static double getRemainAmountByProductNo(int productNo) {
        CreditorService creditorService = (CreditorService) context.getBean("creditorService");
        return creditorService.getRemainAmountByProductNo(productNo);
    }

}
