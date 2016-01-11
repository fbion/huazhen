package com.hzfh.service.sales;

import java.sql.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hzfh.api.sales.model.TaskDecision;
import com.hzfh.api.sales.service.TaskDecisionService;

public class TaskDecisionTest {
	@Test
	public void add() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		TaskDecisionService agentService = (TaskDecisionService) context
				.getBean("taskDecisionService");
		TaskDecision taskDecision = new TaskDecision();

		taskDecision.setIsOk((byte) 1);
		taskDecision.setEditComment("审核1");
		taskDecision.setCheckTime(new Date(0));
		taskDecision.setProductTaskNo(1);
		int id = agentService.add(taskDecision);
		System.out.println(id);
	}

	@Test
	public void getInfo() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		TaskDecisionService taskDecisionService = (TaskDecisionService) context
				.getBean("taskDecisionService");
		int id = 35;
		TaskDecision taskDecision = taskDecisionService.getInfo(id);
		System.out.println(taskDecision.getId() + "============>>"
				+ taskDecision.getEditComment() + "============>>"
				+ taskDecision.getIsOk() + "============>>"
				+ taskDecision.getEditComment() + "============>>"
				+ taskDecision.getProductTaskNo());
	}

	@Test
	public void getList() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		TaskDecisionService taskDecisionService = (TaskDecisionService) context
				.getBean("taskDecisionService");
		List<TaskDecision> taskDecisionsList = taskDecisionService.getList();
		for (TaskDecision taskDecision : taskDecisionsList) {
			System.out.println(taskDecision.getId() + "============>>"
					+ taskDecision.getEditComment() + "============>>"
					+ taskDecision.getEditTime() + "============>>"
					+ taskDecision.getCheckTime() + "============>>"
					+ taskDecision.getIsOk() + "============>>"
					+ taskDecision.getEditComment() + "============>>"
					+ taskDecision.getProductTaskNo());
		}

	}

	@Test
	public void update() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		TaskDecisionService taskDecisionService = (TaskDecisionService) context
				.getBean("taskDecisionService");
		TaskDecision taskDecision = new TaskDecision();
		taskDecision.setId(40);
		taskDecision.setIsOk((byte) 1);
		taskDecision.setEditComment("审核1");
		taskDecision.setCheckTime(new Date(0, 0, 0));
		taskDecision.setProductTaskNo(1);
		int result = taskDecisionService.update(taskDecision);
		System.out.println(result);
	}

	@Test
	public void getListByProductTaskNo() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		TaskDecisionService taskDecisionService = (TaskDecisionService) context
				.getBean("taskDecisionService");

		int ProductTaskNo =2;
		List<TaskDecision> result = taskDecisionService
				.getListByProductTaskNo(ProductTaskNo);

		for (TaskDecision taskDecision : result) {
			System.out.println(taskDecision.getId() + "============>>"
					+ taskDecision.getEditComment() + "============>>"
					+ taskDecision.getEditTime() + "============>>"
					+ taskDecision.getCheckTime() + "============>>"
					+ taskDecision.getIsOk() + "============>>"
					+ taskDecision.getEditComment() + "============>>"
					+ taskDecision.getProductTaskNo());
		}

	}

}
