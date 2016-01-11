package com.hzfh.fmp.facade.employee;

import com.hzfh.api.employee.model.ProbationWorkSummary;
import com.hzfh.api.employee.model.query.ProbationWorkSummaryCondition;
import com.hzfh.api.employee.service.ProbationWorkSummaryService;
import com.hzframework.contract.PagedList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ProbationWorkSummaryFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-employee.xml");

    public static PagedList<ProbationWorkSummary> getPagingList(ProbationWorkSummaryCondition probationWorkSummaryCondition) {
        ProbationWorkSummaryService probationWorkSummaryService = (ProbationWorkSummaryService) context.getBean("probationWorkSummaryService");

        return  probationWorkSummaryService.getPagingList(probationWorkSummaryCondition);
    }

    public static int add(ProbationWorkSummary probationWorkSummary){
        ProbationWorkSummaryService probationWorkSummaryService = (ProbationWorkSummaryService) context.getBean("probationWorkSummaryService");

        return probationWorkSummaryService.add(probationWorkSummary);
    }

    public static int update(ProbationWorkSummary probationWorkSummary){
        ProbationWorkSummaryService probationWorkSummaryService = (ProbationWorkSummaryService) context.getBean("probationWorkSummaryService");

        return probationWorkSummaryService.update(probationWorkSummary);
    }

    public static List<ProbationWorkSummary> getList(){
        ProbationWorkSummaryService probationWorkSummaryService = (ProbationWorkSummaryService) context.getBean("probationWorkSummaryService");

        return probationWorkSummaryService.getList();
    }

    public static ProbationWorkSummary getInfo(int id){
        ProbationWorkSummaryService probationWorkSummaryService = (ProbationWorkSummaryService) context.getBean("probationWorkSummaryService");

        return probationWorkSummaryService.getInfo(id);
    }
    public static ProbationWorkSummary getInfoByEmpNo(int empNo){
        ProbationWorkSummaryService probationWorkSummaryService = (ProbationWorkSummaryService) context.getBean("probationWorkSummaryService");

        return probationWorkSummaryService.getInfoByEmpNo(empNo);
    }

	public static ProbationWorkSummary getInfoByActivitiNo(String activitiNo) {
		ProbationWorkSummaryService probationWorkSummaryService = (ProbationWorkSummaryService) context.getBean("probationWorkSummaryService");

        return probationWorkSummaryService.getInfoByActivitiNo(activitiNo);
	}


}
