package com.hzfh.api.workFlow.service;

import java.util.List;
import java.util.Map;

import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;

import com.hzfh.api.workFlow.model.CommentVO;

public interface ProcessingService {
	/**
	 * 通过用户NO获取历史流程实例
	 * @param userNo 用户NO
	 * @param startIndex 起始位置
	 * @param pageSize 每页个数
	 * @return 该用户所有申请的历史流程实例
	 */
	List<HistoricProcessInstance> getHistoricProcessInstanceListByUserNo(String userNo, int startIndex, int pageSize);

	/**
	 * 通过流程定义ID获取流程定义
	 * @param proDefId 流程定义ID
	 * @return 流程定义
	 */
	ProcessDefinition getProcessDefinitionByProDefId(String proDefId);

	/**
	 * 通过用户No获取个人申请的总个数
	 * @param userNo 用户No
	 * @return 个人申请的总个数
	 */
	int getProcessingTotalCountByUserNo(String userNo);

	/**
	 * 开始流程实例
	 * @param type 类型
	 * @param userNo 申请人的No
	 * @param variables  参数（审批人）
	 * @param comment 意见 评论内容
	 * @param uri 与实际业务关联的URI 用于跳转
	 * @return
	 */
	String startFlowProcess(String type, String userNo,
			Map<String, Object> variables, String comment, String uri);

	/**
	 * 去掉申请人的流程实例
	 * @param type
	 * @param userNo
	 * @param variables
	 * @param comment
	 * @param uri
	 * @return
	 */
	String startFlowProcessForNoApplicant(String type, String userNo,Map<String, Object> variables, String comment, String uri);

	/**
	 * 加邮件的流程实例
	 * @param type
	 * @param userNo
	 * @param variables
	 * @param comment
	 * @param uri
	 * @return
	 */
	String startFlowProcessWithEmail(String type, String userNo,Map<String, Object> variables, String comment, String uri);

	/**
	 * 获取单个流程所有的评论
	 * @param avtiviNo
	 * @return 相对应的所有的评论
	 */
	List<Comment> getCommnetsByProcessInsId(String avtiviNo);

	/**
	 * 通过任务No，获取历史任务
	 * @param taskNo 任务No
	 * @return 相对应的历史任务
	 */
	HistoricTaskInstance getHistoricTaskInstanceByTaskId(String taskNo);

	/**
	 * 获取自己申请的任务
	 * @param proId
	 * @param userNo
	 * @return
	 */
	Task getBackTask(String proId, String userNo);

}
