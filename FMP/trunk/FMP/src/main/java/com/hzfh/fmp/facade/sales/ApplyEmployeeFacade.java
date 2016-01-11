package com.hzfh.fmp.facade.sales;

import com.hzfh.api.sales.model.ApplyEmployee;
import com.hzfh.api.sales.model.query.ApplyEmployeeCondition;
import com.hzfh.api.sales.service.ApplyEmployeeService;
import com.hzfh.fmp.model.sales.view.ApplyEmployeeView;
import com.hzframework.contract.PagedList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ApplyEmployeeFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-sales.xml");

    public static PagedList<ApplyEmployee> getPagingList(ApplyEmployeeCondition applyEmployeeCondition) {
        ApplyEmployeeService applyEmployeeService = (ApplyEmployeeService) context.getBean("applyEmployeeService");

        return  applyEmployeeService.getPagingList(applyEmployeeCondition);
    }

    public static int add(ApplyEmployee applyEmployee){
        ApplyEmployeeService applyEmployeeService = (ApplyEmployeeService) context.getBean("applyEmployeeService");

        return applyEmployeeService.add(applyEmployee);
    }

    public static int update(ApplyEmployee applyEmployee){
        ApplyEmployeeService applyEmployeeService = (ApplyEmployeeService) context.getBean("applyEmployeeService");

        return applyEmployeeService.update(applyEmployee);
    }

    public static List<ApplyEmployee> getList(){
        ApplyEmployeeService applyEmployeeService = (ApplyEmployeeService) context.getBean("applyEmployeeService");

        return applyEmployeeService.getList();
    }
    public static List<ApplyEmployee> getListForExcel(ApplyEmployeeCondition applyEmployeeCondition){
        ApplyEmployeeService applyEmployeeService = (ApplyEmployeeService) context.getBean("applyEmployeeService");

        return applyEmployeeService.getListForExcel(applyEmployeeCondition);
    }
    public static ApplyEmployee getInfo(int id){
        ApplyEmployeeService applyEmployeeService = (ApplyEmployeeService) context.getBean("applyEmployeeService");

        return applyEmployeeService.getInfo(id);
    }

	public static ApplyEmployee getInfoByAnoEno(ApplyEmployee applyEmployee) {
		ApplyEmployeeService applyEmployeeService = (ApplyEmployeeService) context.getBean("applyEmployeeService");
		return applyEmployeeService.getInfoByAnoEno(applyEmployee);
	}

	public static List<ApplyEmployee> getCustomerListForExcel(ApplyEmployeeCondition applyEmployeeCondition) {
		ApplyEmployeeService applyEmployeeService = (ApplyEmployeeService) context.getBean("applyEmployeeService");
        return applyEmployeeService.getCustomerListForExcel(applyEmployeeCondition);
	}
}
