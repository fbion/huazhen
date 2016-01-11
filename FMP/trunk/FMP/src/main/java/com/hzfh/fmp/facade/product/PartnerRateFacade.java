package com.hzfh.fmp.facade.product;

import com.hzfh.api.product.model.PartnerRate;
import com.hzfh.api.product.model.query.PartnerRateCondition;
import com.hzfh.api.product.service.PartnerRateService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class PartnerRateFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-product.xml");

    public static PagedList<PartnerRate> getPagingList(PartnerRateCondition partnerRateCondition) {
        PartnerRateService partnerRateService = (PartnerRateService) context.getBean("partnerRateService");

        return  partnerRateService.getPagingList(partnerRateCondition);
    }

    public static int add(PartnerRate partnerRate){
        PartnerRateService partnerRateService = (PartnerRateService) context.getBean("partnerRateService");

        return partnerRateService.add(partnerRate);
    }

    public static int update(PartnerRate partnerRate){
        PartnerRateService partnerRateService = (PartnerRateService) context.getBean("partnerRateService");

        return partnerRateService.update(partnerRate);
    }

    public static List<PartnerRate> getList(){
        PartnerRateService partnerRateService = (PartnerRateService) context.getBean("partnerRateService");

        return partnerRateService.getList();
    }

    public static PartnerRate getInfo(int id){
        PartnerRateService partnerRateService = (PartnerRateService) context.getBean("partnerRateService");

        return partnerRateService.getInfo(id);
    }

	public static PartnerRate getPartnerRate(int productNo, Long money) {
		PartnerRateService partnerRateService = (PartnerRateService) context.getBean("partnerRateService");
		
		return partnerRateService.getPartnerRate(productNo, money);
	}

	public static List<PartnerRate> getListByProductNo(int productNo) {
		PartnerRateService partnerRateService = (PartnerRateService) context.getBean("partnerRateService");
		return partnerRateService.getListByProductNo(productNo);
	}

    public static int delete(int id) {
        PartnerRateService partnerRateService = (PartnerRateService) context.getBean("partnerRateService");
        return partnerRateService.delete(id);
    }
}
