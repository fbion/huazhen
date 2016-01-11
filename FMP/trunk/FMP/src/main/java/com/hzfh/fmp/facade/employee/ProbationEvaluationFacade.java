package com.hzfh.fmp.facade.employee;

import com.hzfh.api.employee.model.ProbationEvaluation;
import com.hzfh.api.employee.model.query.ProbationEvaluationCondition;
import com.hzfh.api.employee.service.ProbationEvaluationService;
import com.hzframework.contract.PagedList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ProbationEvaluationFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-employee.xml");

    public static PagedList<ProbationEvaluation> getPagingList(ProbationEvaluationCondition probationEvaluationCondition) {
        ProbationEvaluationService probationEvaluationService = (ProbationEvaluationService) context.getBean("probationEvaluationService");

        return  probationEvaluationService.getPagingList(probationEvaluationCondition);
    }

    public static int add(ProbationEvaluation probationEvaluation){
        ProbationEvaluationService probationEvaluationService = (ProbationEvaluationService) context.getBean("probationEvaluationService");

        return probationEvaluationService.add(probationEvaluation);
    }

    public static int update(ProbationEvaluation probationEvaluation){
        ProbationEvaluationService probationEvaluationService = (ProbationEvaluationService) context.getBean("probationEvaluationService");

        return probationEvaluationService.update(probationEvaluation);
    }

    public static List<ProbationEvaluation> getList(){
        ProbationEvaluationService probationEvaluationService = (ProbationEvaluationService) context.getBean("probationEvaluationService");

        return probationEvaluationService.getList();
    }

    public static ProbationEvaluation getInfo(int id){
        ProbationEvaluationService probationEvaluationService = (ProbationEvaluationService) context.getBean("probationEvaluationService");

        return probationEvaluationService.getInfo(id);
    }

	public static int updateActivitiStatusByActivitiNo(String activitiNo) {
		ProbationEvaluationService probationEvaluationService = (ProbationEvaluationService) context.getBean("probationEvaluationService");

        return probationEvaluationService.updateActivitiStatusByActivitiNo(activitiNo);
	}

	public static ProbationEvaluation getInfoByActivitiNo(String activitiNo) {
		ProbationEvaluationService probationEvaluationService = (ProbationEvaluationService) context.getBean("probationEvaluationService");

        return probationEvaluationService.getInfoByActivitiNo(activitiNo);
	}

    public static ProbationEvaluation getinfoByEmpNo(int empNo) {
        ProbationEvaluationService probationEvaluationService = (ProbationEvaluationService) context.getBean("probationEvaluationService");
        return  probationEvaluationService.getInfoByEmpNo(empNo);

    }
}
