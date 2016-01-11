package com.hzfh.fmp.facade.employee;

import com.hzfh.api.employee.model.SubsidyTotal;
import com.hzfh.api.employee.model.query.SubsidyTotalCondition;
import com.hzfh.api.employee.service.SubsidyTotalService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SubsidyTotalFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-employee.xml");

    public static PagedList<SubsidyTotal> getPagingList(SubsidyTotalCondition subsidyTotalCondition) {
        SubsidyTotalService subsidyTotalService = (SubsidyTotalService) context.getBean("subsidyTotalService");

        return  subsidyTotalService.getPagingList(subsidyTotalCondition);
    }

    public static int add(SubsidyTotal subsidyTotal){
        SubsidyTotalService subsidyTotalService = (SubsidyTotalService) context.getBean("subsidyTotalService");

        return subsidyTotalService.add(subsidyTotal);
    }

    public static int update(SubsidyTotal subsidyTotal){
        SubsidyTotalService subsidyTotalService = (SubsidyTotalService) context.getBean("subsidyTotalService");

        return subsidyTotalService.update(subsidyTotal);
    }

    public static List<SubsidyTotal> getList(){
        SubsidyTotalService subsidyTotalService = (SubsidyTotalService) context.getBean("subsidyTotalService");

        return subsidyTotalService.getList();
    }

    public static SubsidyTotal getInfo(int id){
        SubsidyTotalService subsidyTotalService = (SubsidyTotalService) context.getBean("subsidyTotalService");

        return subsidyTotalService.getInfo(id);
    }

    public static int updateIsExamineById(int id){
        SubsidyTotalService subsidyTotalService = (SubsidyTotalService) context.getBean("subsidyTotalService");
        return subsidyTotalService.updateIsExamineById(id);
    }

	public static List<SubsidyTotal> getListForExcel(
			SubsidyTotalCondition subsidyTotalCondition) {
		SubsidyTotalService subsidyTotalService = (SubsidyTotalService) context.getBean("subsidyTotalService");
		return subsidyTotalService.getListForExcel(subsidyTotalCondition);
	}
}
