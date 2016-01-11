package com.hzfh.fmp.facade.report;

import com.hzfh.api.report.model.CompanySalesDaily;
import com.hzfh.api.report.model.CompanySalesTotal;
import com.hzfh.api.report.model.query.CompanySalesTotalCondition;
import com.hzfh.api.report.service.CompanySalesTotalService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class CompanySalesTotalFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-report.xml");

    public static PagedList<CompanySalesTotal> getPagingList(CompanySalesTotalCondition companySalesTotalCondition) {
        CompanySalesTotalService companySalesTotalService = (CompanySalesTotalService) context.getBean("companySalesTotalService");

        return  companySalesTotalService.getPagingList(companySalesTotalCondition);
    }

    public static int add(CompanySalesTotal companySalesTotal){
        CompanySalesTotalService companySalesTotalService = (CompanySalesTotalService) context.getBean("companySalesTotalService");

        return companySalesTotalService.add(companySalesTotal);
    }

    public static int update(CompanySalesTotal companySalesTotal){
        CompanySalesTotalService companySalesTotalService = (CompanySalesTotalService) context.getBean("companySalesTotalService");

        return companySalesTotalService.update(companySalesTotal);
    }

    public static List<CompanySalesTotal> getList(){
        CompanySalesTotalService companySalesTotalService = (CompanySalesTotalService) context.getBean("companySalesTotalService");

        return companySalesTotalService.getList();
    }

    public static CompanySalesTotal getInfo(int id){
        CompanySalesTotalService companySalesTotalService = (CompanySalesTotalService) context.getBean("companySalesTotalService");

        return companySalesTotalService.getInfo(id);
    }

	public static List<CompanySalesDaily> getListByProductNo(String productID) {
		CompanySalesTotalService companySalesTotalService = (CompanySalesTotalService) context.getBean("companySalesTotalService");
		return companySalesTotalService.getListByProductNo(productID);
	}
}
