package com.hzfh.fmp.facade.workFlow;

import java.util.List;
import java.util.Map;

import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hzfh.api.workFlow.service.ProcessingService;

public class ProcessingFacade {
	private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-workFlow.xml");
	
	public static List<HistoricProcessInstance> getHistoricProcessInstanceListByUserNo(String userNo, int startIndex, int pageSize) {
		ProcessingService processingService = (ProcessingService) context.getBean("processingService");
		return processingService.getHistoricProcessInstanceListByUserNo(userNo,startIndex,pageSize);
	}
	public static ProcessDefinition getProcessDefinitionByProDefId(String proDefId) {
		ProcessingService processingService = (ProcessingService) context.getBean("processingService");
		return processingService.getProcessDefinitionByProDefId(proDefId);
	}
	public static int getProcessingTotalCountByUserNo(String userNo) {
		ProcessingService processingService = (ProcessingService) context.getBean("processingService");
		return processingService.getProcessingTotalCountByUserNo(userNo);
	}
	public static String startFlowProcess(String type, String userNo,
			Map<String, Object> variables, String comment, String uri) {
		ProcessingService processingService = (ProcessingService) context.getBean("processingService");
		return processingService.startFlowProcess(type,userNo,variables,comment,uri);
	}
	public static String startFlowProcessForNoApplicant(String type, String userNo,Map<String, Object> variables, String comment, String uri) {
		ProcessingService processingService = (ProcessingService) context.getBean("processingService");
		return processingService.startFlowProcessForNoApplicant(type,userNo,variables,comment,uri);
	}
	public static String startFlowProcessWithEmail(String type, String userNo,Map<String, Object> variables, String comment, String uri) {
		ProcessingService processingService = (ProcessingService) context.getBean("processingService");
		return processingService.startFlowProcessWithEmail(type,userNo,variables,comment,uri);
	}
	public static List<Comment> getCommnetsByProcessInsId(String avtiviNo) {
		ProcessingService processingService = (ProcessingService) context.getBean("processingService");
		return processingService.getCommnetsByProcessInsId(avtiviNo);
	}
	public static HistoricTaskInstance getHistoricTaskInstanceByTaskId(String taskNo) {
		ProcessingService processingService = (ProcessingService) context.getBean("processingService");
		return processingService.getHistoricTaskInstanceByTaskId(taskNo);
	}
	public static Task getBackTask(String proId, String userNo) {
		ProcessingService processingService = (ProcessingService) context.getBean("processingService");
		return processingService.getBackTask(proId,userNo);
	}
}
