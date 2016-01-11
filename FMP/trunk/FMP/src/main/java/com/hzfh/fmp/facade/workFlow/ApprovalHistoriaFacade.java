package com.hzfh.fmp.facade.workFlow;

import java.util.List;
import java.util.Map;

import org.activiti.engine.history.HistoricTaskInstance;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hzfh.api.workFlow.service.ApprovalHistoriaService;

public class ApprovalHistoriaFacade {

	private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-workFlow.xml");
	
	public static List<HistoricTaskInstance> getHiTaskPagedListbyUserNo(Map<String, Object> paramMap) {
		ApprovalHistoriaService approvalHistoriaService = (ApprovalHistoriaService) context.getBean("approvalHistoriaService");
		return approvalHistoriaService.getHiTaskPagedListbyUserNo(paramMap);
	}

	public static int getApprovalHistoriaTotalCount(Map<String, Object> paramMap) {
		ApprovalHistoriaService approvalHistoriaService = (ApprovalHistoriaService) context.getBean("approvalHistoriaService");
		return approvalHistoriaService.getApprovalHistoriaTotalCount(paramMap);
	}	
}
