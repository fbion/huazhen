package com.hzfh.service.workFlow.serviceImpl;

import java.util.List;
import java.util.Map;

import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricTaskInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzfh.api.workFlow.service.ApprovalHistoriaService;
import com.hzframework.helper.StringHelper;
@Service("approvalHistoriaService")
public class ApprovalHistoriaServiceImpl implements ApprovalHistoriaService {
	@Autowired
	private HistoryService historyService;
	@Autowired
	private RepositoryService repositoryService;
	@Autowired
	private TaskService taskService;
	@Autowired
	private IdentityService identityService;
	@Autowired
	private RuntimeService runtimeService;
	@Override
	public List<HistoricTaskInstance> getHiTaskPagedListbyUserNo(Map<String, Object> paramMap) {
		String userNo = (String) paramMap.get("userNo");
		int startIndex = (int) paramMap.get("startIndex");
		int pageSize = (int) paramMap.get("pageSize");
		String processType = (String) paramMap.get("type");
		String status = (String) paramMap.get("status");
		if(!StringHelper.isNullOrEmpty(processType)&&!StringHelper.isNullOrEmpty(status)){//类型
			if("finish".equalsIgnoreCase(status)){
				return historyService.createHistoricTaskInstanceQuery()
						.taskAssignee(userNo)
						.processDefinitionKeyLikeIgnoreCase(processType)
						.orderByHistoricTaskInstanceStartTime()
						.desc().processFinished().finished().listPage(startIndex, pageSize);
			}
			
			if("nuFinish".equalsIgnoreCase(status)){
				return historyService.createHistoricTaskInstanceQuery()
						.taskAssignee(userNo)
						.processDefinitionKeyLikeIgnoreCase(processType)
						.orderByHistoricTaskInstanceStartTime()
						.desc().processUnfinished().finished().listPage(startIndex, pageSize);
			}
		}
		if(!StringHelper.isNullOrEmpty(status)){
			if("finish".equalsIgnoreCase(status)){
				return historyService.createHistoricTaskInstanceQuery()
						.taskAssignee(userNo)
						.orderByHistoricTaskInstanceStartTime()
						.desc().processFinished().finished().listPage(startIndex, pageSize);
			}
			
			if("nuFinish".equalsIgnoreCase(status)){
				return historyService.createHistoricTaskInstanceQuery()
						.taskAssignee(userNo)
						.orderByHistoricTaskInstanceStartTime()
						.desc().processUnfinished().finished().listPage(startIndex, pageSize);
			}
		}
		if(!StringHelper.isNullOrEmpty(processType)){//类型
			return historyService.createHistoricTaskInstanceQuery()
					.taskAssignee(userNo)
					.processDefinitionKeyLikeIgnoreCase(processType)
					.orderByHistoricTaskInstanceStartTime()
					.desc().finished().listPage(startIndex, pageSize);
		}
		return	historyService.createHistoricTaskInstanceQuery()
					.taskAssignee(userNo)
					.orderByHistoricTaskInstanceStartTime()
					.desc().finished().listPage(startIndex, pageSize);
	}

	@Override
	public int getApprovalHistoriaTotalCount(Map<String, Object> paramMap) {
		String userNo = (String) paramMap.get("userNo");
		String processType = (String) paramMap.get("type");
		String status = (String) paramMap.get("status");
		if(!StringHelper.isNullOrEmpty(processType)&&!StringHelper.isNullOrEmpty(status)){//类型
			if("finish".equalsIgnoreCase(status)){
				return historyService.createHistoricTaskInstanceQuery()
						.taskAssignee(userNo)
						.processDefinitionKeyLikeIgnoreCase(processType)
						.orderByHistoricTaskInstanceStartTime()
						.desc().processFinished().finished().list().size();
			}
			
			if("nuFinish".equalsIgnoreCase(status)){
				return historyService.createHistoricTaskInstanceQuery()
						.taskAssignee(userNo)
						.processDefinitionKeyLikeIgnoreCase(processType)
						.orderByHistoricTaskInstanceStartTime()
						.desc().processUnfinished().finished().list().size();
			}
		}
		if(!StringHelper.isNullOrEmpty(status)){
			if("finish".equalsIgnoreCase(status)){
				return historyService.createHistoricTaskInstanceQuery()
						.taskAssignee(userNo)
						.orderByHistoricTaskInstanceStartTime()
						.desc().processFinished().finished().list().size();
			}
			
			if("nuFinish".equalsIgnoreCase(status)){
				return historyService.createHistoricTaskInstanceQuery()
						.taskAssignee(userNo)
						.orderByHistoricTaskInstanceStartTime()
						.desc().processUnfinished().finished().list().size();
			}
		}
		if(!StringHelper.isNullOrEmpty(processType)){//类型
			return historyService.createHistoricTaskInstanceQuery()
					.taskAssignee(userNo)
					.processDefinitionKeyLikeIgnoreCase(processType)
					.orderByHistoricTaskInstanceStartTime()
					.desc().finished().list().size();
		}
		return	historyService.createHistoricTaskInstanceQuery()
					.taskAssignee(userNo)
					.orderByHistoricTaskInstanceStartTime()
					.desc().finished().list().size();
	}

}
