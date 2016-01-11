package com.hzfh.fmp.facade.employee;

import com.hzfh.api.employee.model.Subsidy;
import com.hzfh.api.employee.model.query.SubsidyCondition;
import com.hzfh.api.employee.service.SubsidyService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SubsidyFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-employee.xml");

    public static PagedList<Subsidy> getPagingList(SubsidyCondition subsidyCondition) {
        SubsidyService subsidyService = (SubsidyService) context.getBean("subsidyService");

        return  subsidyService.getPagingList(subsidyCondition);
    }

    public static int add(Subsidy subsidy){
        SubsidyService subsidyService = (SubsidyService) context.getBean("subsidyService");

        return subsidyService.add(subsidy);
    }

    public static int update(Subsidy subsidy){
        SubsidyService subsidyService = (SubsidyService) context.getBean("subsidyService");

        return subsidyService.update(subsidy);
    }

    public static List<Subsidy> getList(){
        SubsidyService subsidyService = (SubsidyService) context.getBean("subsidyService");

        return subsidyService.getList();
    }

    public static Subsidy getInfo(int id){
        SubsidyService subsidyService = (SubsidyService) context.getBean("subsidyService");

        return subsidyService.getInfo(id);
    }

	public static List<Subsidy> getListForExcel(
			SubsidyCondition subsidyCondition) {
		 SubsidyService subsidyService = (SubsidyService) context.getBean("subsidyService");
		return subsidyService.getListForExcel(subsidyCondition);
	}

	public static List<Subsidy> getInfoByEmpNoAndSendTime(SubsidyCondition subsidyCondition) {
		 SubsidyService subsidyService = (SubsidyService) context.getBean("subsidyService");
			return subsidyService.getInfoByEmpNoAndSendTime(subsidyCondition);
	}

	public static List<Subsidy> getListByEmpNo(int empNo) {
		SubsidyService subsidyService = (SubsidyService) context.getBean("subsidyService");
		return subsidyService.getListByEmpNo(empNo);
	}

}
