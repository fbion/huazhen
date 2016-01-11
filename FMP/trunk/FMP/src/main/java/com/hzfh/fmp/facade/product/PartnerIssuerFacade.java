package com.hzfh.fmp.facade.product;

import com.hzfh.api.product.model.PartnerIssuer;
import com.hzfh.api.product.model.query.PartnerIssuerCondition;
import com.hzfh.api.product.service.PartnerIssuerService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class PartnerIssuerFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-product.xml");

    public static PagedList<PartnerIssuer> getPagingList(PartnerIssuerCondition partnerIssuerCondition) {
        PartnerIssuerService partnerIssuerService = (PartnerIssuerService) context.getBean("partnerIssuerService");

        return  partnerIssuerService.getPagingList(partnerIssuerCondition);
    }

    public static int add(PartnerIssuer partnerIssuer){
        PartnerIssuerService partnerIssuerService = (PartnerIssuerService) context.getBean("partnerIssuerService");

        return partnerIssuerService.add(partnerIssuer);
    }

    public static int update(PartnerIssuer partnerIssuer){
        PartnerIssuerService partnerIssuerService = (PartnerIssuerService) context.getBean("partnerIssuerService");

        return partnerIssuerService.update(partnerIssuer);
    }

    public static List<PartnerIssuer> getList(){
        PartnerIssuerService partnerIssuerService = (PartnerIssuerService) context.getBean("partnerIssuerService");

        return partnerIssuerService.getList();
    }

    public static PartnerIssuer getInfo(int id){
        PartnerIssuerService partnerIssuerService = (PartnerIssuerService) context.getBean("partnerIssuerService");

        return partnerIssuerService.getInfo(id);
    }
}
