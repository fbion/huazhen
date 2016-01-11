package com.hzfh.p2p.facade.payment;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hzfh.api.payment.model.ExamineCallbackRecord;
import com.hzfh.api.payment.model.query.ExamineCallbackRecordCondition;
import com.hzfh.api.payment.service.ExamineCallbackRecordService;
import com.hzframework.contract.PagedList;

public class ExamineCallbackRecordFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-payment.xml");

    public static PagedList<ExamineCallbackRecord> getPagingList(ExamineCallbackRecordCondition examineCallbackRecordCondition) {
        ExamineCallbackRecordService examineCallbackRecordService = (ExamineCallbackRecordService) context.getBean("examineCallbackRecordService");

        return  examineCallbackRecordService.getPagingList(examineCallbackRecordCondition);
    }

    public static int add(ExamineCallbackRecord examineCallbackRecord){
        ExamineCallbackRecordService examineCallbackRecordService = (ExamineCallbackRecordService) context.getBean("examineCallbackRecordService");

        return examineCallbackRecordService.add(examineCallbackRecord);
    }

    public static int update(ExamineCallbackRecord examineCallbackRecord){
        ExamineCallbackRecordService examineCallbackRecordService = (ExamineCallbackRecordService) context.getBean("examineCallbackRecordService");

        return examineCallbackRecordService.update(examineCallbackRecord);
    }

    public static List<ExamineCallbackRecord> getList(){
        ExamineCallbackRecordService examineCallbackRecordService = (ExamineCallbackRecordService) context.getBean("examineCallbackRecordService");

        return examineCallbackRecordService.getList();
    }

    public static ExamineCallbackRecord getInfo(int id){
        ExamineCallbackRecordService examineCallbackRecordService = (ExamineCallbackRecordService) context.getBean("examineCallbackRecordService");

        return examineCallbackRecordService.getInfo(id);
    }

	public static ExamineCallbackRecord getinfoByoperationTypeAndSn(String operationType, String sn) {
		 ExamineCallbackRecordService examineCallbackRecordService = (ExamineCallbackRecordService) context.getBean("examineCallbackRecordService");
		 return examineCallbackRecordService.getinfoByoperationTypeAndSn(operationType,sn);
	}
	public static int updateStatusById(byte status, int id) {
		ExamineCallbackRecordService examineCallbackRecordService = (ExamineCallbackRecordService) context.getBean("examineCallbackRecordService");
		return examineCallbackRecordService.updateStatusById(status, id);
	}

	public static int updateStatusByoperationTypeAndSn(byte status,String operationType, String sn) {
		ExamineCallbackRecordService examineCallbackRecordService = (ExamineCallbackRecordService) context.getBean("examineCallbackRecordService");
		return examineCallbackRecordService.updateStatusByoperationTypeAndSn(status,operationType,sn);
	}
}
