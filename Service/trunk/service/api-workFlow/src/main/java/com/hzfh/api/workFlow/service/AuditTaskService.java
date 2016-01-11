package com.hzfh.api.workFlow.service;

import java.util.List;

import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

public interface AuditTaskService {

	/**
	 * Get the current user's own tasks
	 * @param userNo 
	 * @param startIndex
	 * @param pageSize
	 * @return After the paging  List<Task>
	 */
	List<Task> getAcceptTaskPagedListByUserNo(String userNo, int startIndex,int pageSize);

	/**
	 * Get the total number of own tasks
	 * @param userNo
	 * @return the total number 
	 */
	int getAcceptTaskTotalCountByUserNo(String userNo);

	/**
	 * 通过实例ID获取, 历史流程实例
	 * @param activitiNo
	 * @return
	 */
	//HistoricProcessInstance getHiProInsByProInsId(String processInstanceId);
	HistoricProcessInstance getHistoricProcessInstanceByProInsId(String activitiNo);

	/**
	 * 审批通过
	 * @param activitiNo
	 * @param comment
	 * @param userNo
	 */
	void addComplete(String activitiNo, String comment, String userNo);
	/**
	 * 审批不通过
	 * @param activitiNo
	 * @param comment
	 * @param userNo
	 */
	void addCancelComplete(String activitiNo, String comment, String userNo);

	/**
	 * 通过实例ID,获取当前流程实例
	 * @param processInstanceId
	 * @return 
	 */
	ProcessInstance getProcessInstanceByProInsId(String processInstanceId);

	/**
	 *
	 * @param activitiNo
	 * @param comment
	 * @param userNo
	 * @param oper 下一步||驳回
	 */
	void addExamineWithEmail(String activitiNo, String comment, String userNo, boolean oper);
}
