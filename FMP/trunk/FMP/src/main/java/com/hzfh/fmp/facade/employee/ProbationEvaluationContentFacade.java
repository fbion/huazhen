package com.hzfh.fmp.facade.employee;

import com.hzfh.api.employee.model.ProbationEvaluationContent;
import com.hzfh.api.employee.model.query.ProbationEvaluationContentCondition;
import com.hzfh.api.employee.service.ProbationEvaluationContentService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ProbationEvaluationContentFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-employee.xml");

    public static PagedList<ProbationEvaluationContent> getPagingList(ProbationEvaluationContentCondition probationEvaluationContentCondition) {
        ProbationEvaluationContentService probationEvaluationContentService = (ProbationEvaluationContentService) context.getBean("probationEvaluationContentService");

        return  probationEvaluationContentService.getPagingList(probationEvaluationContentCondition);
    }

    public static int add(ProbationEvaluationContent probationEvaluationContent){
        ProbationEvaluationContentService probationEvaluationContentService = (ProbationEvaluationContentService) context.getBean("probationEvaluationContentService");

        return probationEvaluationContentService.add(probationEvaluationContent);
    }

    public static int update(ProbationEvaluationContent probationEvaluationContent){
        ProbationEvaluationContentService probationEvaluationContentService = (ProbationEvaluationContentService) context.getBean("probationEvaluationContentService");

        return probationEvaluationContentService.update(probationEvaluationContent);
    }

    public static List<ProbationEvaluationContent> getList(){
        ProbationEvaluationContentService probationEvaluationContentService = (ProbationEvaluationContentService) context.getBean("probationEvaluationContentService");

        return probationEvaluationContentService.getList();
    }

    public static ProbationEvaluationContent getInfo(int id){
        ProbationEvaluationContentService probationEvaluationContentService = (ProbationEvaluationContentService) context.getBean("probationEvaluationContentService");

        return probationEvaluationContentService.getInfo(id);
    }

	public static List<ProbationEvaluationContent> getListByRecordNo(int id) {
		ProbationEvaluationContentService probationEvaluationContentService = (ProbationEvaluationContentService) context.getBean("probationEvaluationContentService");

        return probationEvaluationContentService.getListByRecordNo(id);
	}
}
