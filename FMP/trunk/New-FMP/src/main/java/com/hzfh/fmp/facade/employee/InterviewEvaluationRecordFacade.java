package com.hzfh.fmp.facade.employee;

import com.hzfh.api.employee.model.InterviewEvaluationRecord;
import com.hzfh.api.employee.model.query.InterviewEvaluationRecordCondition;
import com.hzfh.api.employee.service.InterviewEvaluationRecordService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class InterviewEvaluationRecordFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-employee.xml");

    public static PagedList<InterviewEvaluationRecord> getPagingList(InterviewEvaluationRecordCondition interviewEvaluationRecordCondition) {
        InterviewEvaluationRecordService interviewEvaluationRecordService = (InterviewEvaluationRecordService) context.getBean("interviewEvaluationRecordService");

        return  interviewEvaluationRecordService.getPagingList(interviewEvaluationRecordCondition);
    }

    public static int add(InterviewEvaluationRecord interviewEvaluationRecord){
        InterviewEvaluationRecordService interviewEvaluationRecordService = (InterviewEvaluationRecordService) context.getBean("interviewEvaluationRecordService");

        return interviewEvaluationRecordService.add(interviewEvaluationRecord);
    }

    public static int update(InterviewEvaluationRecord interviewEvaluationRecord){
        InterviewEvaluationRecordService interviewEvaluationRecordService = (InterviewEvaluationRecordService) context.getBean("interviewEvaluationRecordService");

        return interviewEvaluationRecordService.update(interviewEvaluationRecord);
    }

    public static List<InterviewEvaluationRecord> getList(){
        InterviewEvaluationRecordService interviewEvaluationRecordService = (InterviewEvaluationRecordService) context.getBean("interviewEvaluationRecordService");

        return interviewEvaluationRecordService.getList();
    }

    public static InterviewEvaluationRecord getInfo(int id){
        InterviewEvaluationRecordService interviewEvaluationRecordService = (InterviewEvaluationRecordService) context.getBean("interviewEvaluationRecordService");

        return interviewEvaluationRecordService.getInfo(id);
    }

	public static List<InterviewEvaluationRecord> getInfoListByName(String name) {
		InterviewEvaluationRecordService interviewEvaluationRecordService = (InterviewEvaluationRecordService) context.getBean("interviewEvaluationRecordService");

        return interviewEvaluationRecordService.getInfoListByName(name);
	}
}
