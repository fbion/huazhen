package com.hzfh.fmp.facade.employee;

import com.hzfh.api.employee.model.ManagerEvaluation;
import com.hzfh.api.employee.model.query.ManagerEvaluationCondition;
import com.hzfh.api.employee.service.ManagerEvaluationService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ManagerEvaluationFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-employee.xml");

    public static PagedList<ManagerEvaluation> getPagingList(ManagerEvaluationCondition managerEvaluationCondition) {
        ManagerEvaluationService managerEvaluationService = (ManagerEvaluationService) context.getBean("managerEvaluationService");

        return  managerEvaluationService.getPagingList(managerEvaluationCondition);
    }

    public static int add(ManagerEvaluation managerEvaluation){
        ManagerEvaluationService managerEvaluationService = (ManagerEvaluationService) context.getBean("managerEvaluationService");

        return managerEvaluationService.add(managerEvaluation);
    }

    public static int update(ManagerEvaluation managerEvaluation){
        ManagerEvaluationService managerEvaluationService = (ManagerEvaluationService) context.getBean("managerEvaluationService");

        return managerEvaluationService.update(managerEvaluation);
    }

    public static List<ManagerEvaluation> getList(){
        ManagerEvaluationService managerEvaluationService = (ManagerEvaluationService) context.getBean("managerEvaluationService");

        return managerEvaluationService.getList();
    }

    public static ManagerEvaluation getInfo(int id){
        ManagerEvaluationService managerEvaluationService = (ManagerEvaluationService) context.getBean("managerEvaluationService");

        return managerEvaluationService.getInfo(id);
    }

	public static int updateActivitiStatusByActivitiNo(String activitiNo) {
		ManagerEvaluationService managerEvaluationService = (ManagerEvaluationService) context.getBean("managerEvaluationService");

        return managerEvaluationService.updateActivitiStatusByActivitiNo(activitiNo);
	}
}
