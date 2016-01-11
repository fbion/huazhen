package com.hzfh.service.sales;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hzfh.api.sales.model.TaskDecisionLog;
import com.hzfh.api.sales.service.TaskDecisionLogService;

public class TasDecisionLogTest {
	@Test
	public void add(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		TaskDecisionLogService taskDecisionLogService =(TaskDecisionLogService) context.getBean("taskDecisionLogService");
		TaskDecisionLog taskDecisionLog = new TaskDecisionLog();
		taskDecisionLog.setId(1);
		taskDecisionLog.setIsOk((byte) 1);
		taskDecisionLog.setEditComment("审核1");
		taskDecisionLog.setUserNo(1);
		int id=taskDecisionLogService.add(taskDecisionLog);
		System.out.println(id);
	}
	
	
	@Test
	public void getInfo(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		TaskDecisionLogService taskDecisionLogService =(TaskDecisionLogService) context.getBean("taskDecisionLogService");
		int id=35;
		TaskDecisionLog taskDecisionLog=taskDecisionLogService.getInfo(id);
		System.out.println(taskDecisionLog.getId()+"============>>"+
				taskDecisionLog.getEditComment()+"============>>"+
				taskDecisionLog.getIsOk()+"============>>"+
				taskDecisionLog.getEditComment()+"============>>"+
				taskDecisionLog.getUserNo());
	}
	
	
	@Test
	public void getList(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		TaskDecisionLogService taskDecisionLogService =(TaskDecisionLogService) context.getBean("taskDecisionLogService");
		List<TaskDecisionLog> taskDecisionsList = taskDecisionLogService.getList();
		for (TaskDecisionLog taskDecision : taskDecisionsList) {
			System.out.println(taskDecision.getId()+"============>>"+
							taskDecision.getEditComment()+"============>>"+
							taskDecision.getIsOk()+"============>>"+
							taskDecision.getEditComment()+"============>>"+
							taskDecision.getUserNo());
		}
		
	}
	

	
}
