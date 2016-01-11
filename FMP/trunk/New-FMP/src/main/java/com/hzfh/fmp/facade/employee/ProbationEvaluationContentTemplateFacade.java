package com.hzfh.fmp.facade.employee;

import com.hzfh.api.employee.model.ProbationEvaluationContentTemplate;
import com.hzfh.api.employee.model.query.ProbationEvaluationContentTemplateCondition;
import com.hzfh.api.employee.service.ProbationEvaluationContentTemplateService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ProbationEvaluationContentTemplateFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-employee.xml");

    public static PagedList<ProbationEvaluationContentTemplate> getPagingList(ProbationEvaluationContentTemplateCondition probationEvaluationContentTemplateCondition) {
        ProbationEvaluationContentTemplateService probationEvaluationContentTemplateService = (ProbationEvaluationContentTemplateService) context.getBean("probationEvaluationContentTemplateService");

        return  probationEvaluationContentTemplateService.getPagingList(probationEvaluationContentTemplateCondition);
    }

    public static int add(ProbationEvaluationContentTemplate probationEvaluationContentTemplate){
        ProbationEvaluationContentTemplateService probationEvaluationContentTemplateService = (ProbationEvaluationContentTemplateService) context.getBean("probationEvaluationContentTemplateService");

        return probationEvaluationContentTemplateService.add(probationEvaluationContentTemplate);
    }

    public static int update(ProbationEvaluationContentTemplate probationEvaluationContentTemplate){
        ProbationEvaluationContentTemplateService probationEvaluationContentTemplateService = (ProbationEvaluationContentTemplateService) context.getBean("probationEvaluationContentTemplateService");

        return probationEvaluationContentTemplateService.update(probationEvaluationContentTemplate);
    }

    public static List<ProbationEvaluationContentTemplate> getList(){
        ProbationEvaluationContentTemplateService probationEvaluationContentTemplateService = (ProbationEvaluationContentTemplateService) context.getBean("probationEvaluationContentTemplateService");

        return probationEvaluationContentTemplateService.getList();
    }

    public static ProbationEvaluationContentTemplate getInfo(int id){
        ProbationEvaluationContentTemplateService probationEvaluationContentTemplateService = (ProbationEvaluationContentTemplateService) context.getBean("probationEvaluationContentTemplateService");

        return probationEvaluationContentTemplateService.getInfo(id);
    }
}
