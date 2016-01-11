package com.hzfh.api.workFlow.service;

import java.util.List;
import java.util.Map;

import org.activiti.engine.history.HistoricTaskInstance;

public interface ApprovalHistoriaService {

	/**
	 * 通过userNo,获取所有历史任务
	 * @param paramMap
	 * @return 自己的所有审批过的任务
	 */
	List<HistoricTaskInstance> getHiTaskPagedListbyUserNo(
			Map<String, Object> paramMap);

	/**
	 * 获取历史任务数量
	 * @param paramMap
	 * @return
	 */
	int getApprovalHistoriaTotalCount(Map<String, Object> paramMap);

}
