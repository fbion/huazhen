package com.hzfh.fmp.facade.employee;

import com.hzfh.api.employee.model.RecruitAskRecord;
import com.hzfh.api.employee.model.query.RecruitAskRecordCondition;
import com.hzfh.api.employee.service.RecruitAskRecordService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class RecruitAskRecordFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-employee.xml");

    public static PagedList<RecruitAskRecord> getPagingList(RecruitAskRecordCondition recruitAskRecordCondition) {
        RecruitAskRecordService recruitAskRecordService = (RecruitAskRecordService) context.getBean("recruitAskRecordService");

        return  recruitAskRecordService.getPagingList(recruitAskRecordCondition);
    }

    public static int add(RecruitAskRecord recruitAskRecord){
        RecruitAskRecordService recruitAskRecordService = (RecruitAskRecordService) context.getBean("recruitAskRecordService");

        return recruitAskRecordService.add(recruitAskRecord);
    }

    public static int update(RecruitAskRecord recruitAskRecord){
        RecruitAskRecordService recruitAskRecordService = (RecruitAskRecordService) context.getBean("recruitAskRecordService");

        return recruitAskRecordService.update(recruitAskRecord);
    }

    public static List<RecruitAskRecord> getList(){
        RecruitAskRecordService recruitAskRecordService = (RecruitAskRecordService) context.getBean("recruitAskRecordService");

        return recruitAskRecordService.getList();
    }

    public static RecruitAskRecord getInfo(int id){
        RecruitAskRecordService recruitAskRecordService = (RecruitAskRecordService) context.getBean("recruitAskRecordService");

        return recruitAskRecordService.getInfo(id);
    }

	public static List<RecruitAskRecord> getListForExcel(
			RecruitAskRecordCondition recruitAskRecordCondition) {
		RecruitAskRecordService recruitAskRecordService = (RecruitAskRecordService) context.getBean("recruitAskRecordService");

        return recruitAskRecordService.getListForExcel(recruitAskRecordCondition);
	}

	public static int updateResumeAttachmentById(String filePath, int id) {
		RecruitAskRecordService recruitAskRecordService = (RecruitAskRecordService) context.getBean("recruitAskRecordService");
        return recruitAskRecordService.updateResumeAttachmentById(filePath,id);
	}
}
