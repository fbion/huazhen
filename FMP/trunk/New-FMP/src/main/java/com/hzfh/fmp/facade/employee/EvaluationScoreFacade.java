package com.hzfh.fmp.facade.employee;

import com.hzfh.api.employee.model.EvaluationScore;
import com.hzfh.api.employee.model.query.EvaluationScoreCondition;
import com.hzfh.api.employee.service.EvaluationScoreService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class EvaluationScoreFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-employee.xml");

    public static PagedList<EvaluationScore> getPagingList(EvaluationScoreCondition evaluationScoreCondition) {
        EvaluationScoreService evaluationScoreService = (EvaluationScoreService) context.getBean("evaluationScoreService");

        return  evaluationScoreService.getPagingList(evaluationScoreCondition);
    }

    public static int add(EvaluationScore evaluationScore){
        EvaluationScoreService evaluationScoreService = (EvaluationScoreService) context.getBean("evaluationScoreService");

        return evaluationScoreService.add(evaluationScore);
    }

    public static int update(EvaluationScore evaluationScore){
        EvaluationScoreService evaluationScoreService = (EvaluationScoreService) context.getBean("evaluationScoreService");

        return evaluationScoreService.update(evaluationScore);
    }

    public static List<EvaluationScore> getList(){
        EvaluationScoreService evaluationScoreService = (EvaluationScoreService) context.getBean("evaluationScoreService");

        return evaluationScoreService.getList();
    }

    public static EvaluationScore getInfo(int id){
        EvaluationScoreService evaluationScoreService = (EvaluationScoreService) context.getBean("evaluationScoreService");

        return evaluationScoreService.getInfo(id);
    }

	public static List<EvaluationScore> getListByEvaluationRecordNo(int id) {
		EvaluationScoreService evaluationScoreService = (EvaluationScoreService) context.getBean("evaluationScoreService");

        return evaluationScoreService.getListByEvaluationRecordNo(id);
	}
}
