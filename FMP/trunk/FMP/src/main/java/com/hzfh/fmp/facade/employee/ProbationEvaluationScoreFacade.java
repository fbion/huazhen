package com.hzfh.fmp.facade.employee;

import com.hzfh.api.employee.model.ProbationEvaluationScore;
import com.hzfh.api.employee.model.query.ProbationEvaluationScoreCondition;
import com.hzfh.api.employee.service.ProbationEvaluationScoreService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ProbationEvaluationScoreFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-employee.xml");

    public static PagedList<ProbationEvaluationScore> getPagingList(ProbationEvaluationScoreCondition probationEvaluationScoreCondition) {
        ProbationEvaluationScoreService probationEvaluationScoreService = (ProbationEvaluationScoreService) context.getBean("probationEvaluationScoreService");

        return  probationEvaluationScoreService.getPagingList(probationEvaluationScoreCondition);
    }

    public static int add(ProbationEvaluationScore probationEvaluationScore){
        ProbationEvaluationScoreService probationEvaluationScoreService = (ProbationEvaluationScoreService) context.getBean("probationEvaluationScoreService");

        return probationEvaluationScoreService.add(probationEvaluationScore);
    }

    public static int update(ProbationEvaluationScore probationEvaluationScore){
        ProbationEvaluationScoreService probationEvaluationScoreService = (ProbationEvaluationScoreService) context.getBean("probationEvaluationScoreService");

        return probationEvaluationScoreService.update(probationEvaluationScore);
    }

    public static List<ProbationEvaluationScore> getList(){
        ProbationEvaluationScoreService probationEvaluationScoreService = (ProbationEvaluationScoreService) context.getBean("probationEvaluationScoreService");

        return probationEvaluationScoreService.getList();
    }

    public static ProbationEvaluationScore getInfo(int id){
        ProbationEvaluationScoreService probationEvaluationScoreService = (ProbationEvaluationScoreService) context.getBean("probationEvaluationScoreService");

        return probationEvaluationScoreService.getInfo(id);
    }

	public static List<ProbationEvaluationScore> getListByRecordNo(int recordNo) {
		ProbationEvaluationScoreService probationEvaluationScoreService = (ProbationEvaluationScoreService) context.getBean("probationEvaluationScoreService");

        return probationEvaluationScoreService.getListByRecordNo(recordNo);
	}
}
