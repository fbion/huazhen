package com.hzfh.fmp.facade.product;

import com.hzfh.api.product.model.PartnerIssuerFollow;
import com.hzfh.api.product.model.query.PartnerIssuerFollowCondition;
import com.hzfh.api.product.service.PartnerIssuerFollowService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class PartnerIssuerFollowFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-product.xml");

    public static PagedList<PartnerIssuerFollow> getPagingList(PartnerIssuerFollowCondition partnerIssuerFollowCondition) {
        PartnerIssuerFollowService partnerIssuerFollowService = (PartnerIssuerFollowService) context.getBean("partnerIssuerFollowService");

        return  partnerIssuerFollowService.getPagingList(partnerIssuerFollowCondition);
    }

    public static int add(PartnerIssuerFollow partnerIssuerFollow){
        PartnerIssuerFollowService partnerIssuerFollowService = (PartnerIssuerFollowService) context.getBean("partnerIssuerFollowService");

        return partnerIssuerFollowService.add(partnerIssuerFollow);
    }

    public static int update(PartnerIssuerFollow partnerIssuerFollow){
        PartnerIssuerFollowService partnerIssuerFollowService = (PartnerIssuerFollowService) context.getBean("partnerIssuerFollowService");

        return partnerIssuerFollowService.update(partnerIssuerFollow);
    }

    public static List<PartnerIssuerFollow> getList(){
        PartnerIssuerFollowService partnerIssuerFollowService = (PartnerIssuerFollowService) context.getBean("partnerIssuerFollowService");

        return partnerIssuerFollowService.getList();
    }

    public static PartnerIssuerFollow getInfo(int id){
        PartnerIssuerFollowService partnerIssuerFollowService = (PartnerIssuerFollowService) context.getBean("partnerIssuerFollowService");

        return partnerIssuerFollowService.getInfo(id);
    }
}
