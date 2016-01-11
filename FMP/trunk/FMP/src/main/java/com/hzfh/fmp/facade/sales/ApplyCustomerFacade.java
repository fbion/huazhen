package com.hzfh.fmp.facade.sales;

import com.hzfh.api.sales.model.ApplyCustomer;
import com.hzfh.api.sales.model.query.ApplyCustomerCondition;
import com.hzfh.api.sales.service.ApplyCustomerService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ApplyCustomerFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-sales.xml");

    public static PagedList<ApplyCustomer> getPagingList(ApplyCustomerCondition applyCustomerCondition) {
        ApplyCustomerService applyCustomerService = (ApplyCustomerService) context.getBean("applyCustomerService");

        return  applyCustomerService.getPagingList(applyCustomerCondition);
    }

    public static int add(ApplyCustomer applyCustomer){
        ApplyCustomerService applyCustomerService = (ApplyCustomerService) context.getBean("applyCustomerService");

        return applyCustomerService.add(applyCustomer);
    }

    public static int update(ApplyCustomer applyCustomer){
        ApplyCustomerService applyCustomerService = (ApplyCustomerService) context.getBean("applyCustomerService");

        return applyCustomerService.update(applyCustomer);
    }

    public static List<ApplyCustomer> getList(){
        ApplyCustomerService applyCustomerService = (ApplyCustomerService) context.getBean("applyCustomerService");

        return applyCustomerService.getList();
    }

    public static ApplyCustomer getInfo(int id){
        ApplyCustomerService applyCustomerService = (ApplyCustomerService) context.getBean("applyCustomerService");

        return applyCustomerService.getInfo(id);
    }

	public static List<ApplyCustomer> getListByEmpNo(ApplyCustomer applyCustomer) {
		ApplyCustomerService applyCustomerService = (ApplyCustomerService) context.getBean("applyCustomerService");

        return applyCustomerService.getListByEmpNo(applyCustomer);
	}

	public static ApplyCustomer getInfoByCus(ApplyCustomer applyCustomer) {
		ApplyCustomerService applyCustomerService = (ApplyCustomerService) context.getBean("applyCustomerService");

        return applyCustomerService.getInfoByCus(applyCustomer);
	}
}
