package com.hzfh.fmp.facade.workFlow;

import java.util.List;

import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hzfh.api.workFlow.service.AuditTaskService;


public class AuditTaskFacade {
	private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-workFlow.xml");
	
	
	
	//incremental methods 2015-07-23 by MengChong
	public static List<Task> getAcceptTaskPagedListByUserNo(String userNo,int startIndex, int pageSize) {
		AuditTaskService auditTaskService = (AuditTaskService)context.getBean("auditTaskService");
		return auditTaskService.getAcceptTaskPagedListByUserNo(userNo,startIndex,pageSize);
	}

	public static int getAcceptTaskTotalCountByUserNo(String userNo) {
		AuditTaskService auditTaskService = (AuditTaskService)context.getBean("auditTaskService");
		return auditTaskService.getAcceptTaskTotalCountByUserNo(userNo);
	}

	
	
	/*public static HistoricProcessInstance getHiProInsByProInsId(String processInstanceId) {
		AuditTaskService auditTaskService = (AuditTaskService)context.getBean("auditTaskService");
		return auditTaskService.getHiProInsByProInsId(processInstanceId);
	}*/

	public static void addComplete(String activitiNo, String comment,String userNo) {
		AuditTaskService auditTaskService = (AuditTaskService)context.getBean("auditTaskService");
		auditTaskService.addComplete(activitiNo, comment,userNo);
		
	}

	public static HistoricProcessInstance getHistoricProcessInstanceByProInsId(String activitiNo) {
		AuditTaskService auditTaskService = (AuditTaskService)context.getBean("auditTaskService");
		return auditTaskService.getHistoricProcessInstanceByProInsId(activitiNo);
	}

	public static void addCancelComplete(String activitiNo, String comment,String userNo) {
		AuditTaskService auditTaskService = (AuditTaskService)context.getBean("auditTaskService");
		auditTaskService.addCancelComplete(activitiNo,comment,userNo);
		
	}

	public static ProcessInstance getProcessInstanceByProInsId(String processInstanceId) {
		AuditTaskService auditTaskService = (AuditTaskService)context.getBean("auditTaskService");
		return auditTaskService.getProcessInstanceByProInsId(processInstanceId);
	}


	public static void addExamineWithEmail(String activitiNo, String comment, String userNo, boolean oper) {
		AuditTaskService auditTaskService = (AuditTaskService)context.getBean("auditTaskService");
		auditTaskService.addExamineWithEmail(activitiNo,comment,userNo,oper);
	}
}
