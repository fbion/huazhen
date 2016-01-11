package com.hzfh.fmp.facade.employee;

import com.hzfh.api.employee.model.EvaluationContent;
import com.hzfh.api.employee.model.query.EvaluationContentCondition;
import com.hzfh.api.employee.service.EvaluationContentService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class EvaluationContentFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-employee.xml");

    public static PagedList<EvaluationContent> getPagingList(EvaluationContentCondition evaluationContentCondition) {
        EvaluationContentService evaluationContentService = (EvaluationContentService) context.getBean("evaluationContentService");

        return  evaluationContentService.getPagingList(evaluationContentCondition);
    }

    public static int add(EvaluationContent evaluationContent){
        EvaluationContentService evaluationContentService = (EvaluationContentService) context.getBean("evaluationContentService");

        return evaluationContentService.add(evaluationContent);
    }

    public static int update(EvaluationContent evaluationContent){
        EvaluationContentService evaluationContentService = (EvaluationContentService) context.getBean("evaluationContentService");

        return evaluationContentService.update(evaluationContent);
    }

    public static List<EvaluationContent> getList(){
        EvaluationContentService evaluationContentService = (EvaluationContentService) context.getBean("evaluationContentService");

        return evaluationContentService.getList();
    }

    public static EvaluationContent getInfo(int id){
        EvaluationContentService evaluationContentService = (EvaluationContentService) context.getBean("evaluationContentService");

        return evaluationContentService.getInfo(id);
    }

	public static EvaluationContent getInfoByIdAndEvaluationRecordNo(
			int evaluationRecordNo, int evaluationContentNo) {
		EvaluationContentService evaluationContentService = (EvaluationContentService) context.getBean("evaluationContentService");

        return evaluationContentService.getInfoByIdAndEvaluationRecordNo(
    			evaluationRecordNo,evaluationContentNo);
	}

	public static List<EvaluationContent> getListByTypeAndParentNo(byte type,
			int parentNo) {
		EvaluationContentService evaluationContentService = (EvaluationContentService) context.getBean("evaluationContentService");
		return evaluationContentService.getListByTypeAndParentNo(type,parentNo);
	}
}
