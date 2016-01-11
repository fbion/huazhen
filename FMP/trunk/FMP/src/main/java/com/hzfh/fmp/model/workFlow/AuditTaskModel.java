package com.hzfh.fmp.model.workFlow;

import java.util.List;

import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

import com.hzfh.fmp.facade.workFlow.AuditTaskFacade;
import com.hzfh.fmp.model.common.helper.WorkFlowHelper;


public class AuditTaskModel {
	/*public static BpmnModel getBpmnModel(String pdid) {
		return ActRepositoryFacade.getBpmnModel(pdid);
	}*/

	/*public static InputStream getAuditImgIntStream(String taskNo) throws Exception {
		return ActTaskFacade.getAuditImgIntStream(taskNo);
	}
*/
	//incremental methods 2015-07-23 by MengChong
	
	public static HistoricProcessInstance getHistoricProcessInstanceByProInsId(
			String processInstanceId) {
		return AuditTaskFacade.getHistoricProcessInstanceByProInsId(processInstanceId);
	}
	
	public static ProcessInstance getProcessInstance(String processInstanceId) {
		return AuditTaskFacade.getProcessInstanceByProInsId(processInstanceId);
	}
	
	public static void addComplete(String activitiNo, String comment,String userNo) {
		AuditTaskFacade.addComplete(activitiNo,comment,userNo);
		HistoricProcessInstance hpi = AuditTaskFacade.getHistoricProcessInstanceByProInsId(activitiNo);
		if(hpi.getEndTime()!=null){
			String[] strarray=hpi.getProcessDefinitionId().split(":");
			WorkFlowHelper.updateActivitiStatuts(strarray[0],activitiNo);
		}
	}

	public static void addCancelComplete(String activitiNo, String comment,String userNo) {
		AuditTaskFacade.addCancelComplete(activitiNo,comment,userNo);
	}
	
	public static List<Task> getAcceptTaskPagedListByUserNo(String userNo,int startIndex, int pageSize) {
		return AuditTaskFacade.getAcceptTaskPagedListByUserNo(userNo, startIndex, pageSize);
	}

	public static int getAcceptTaskTotalCountByUserNo(String userNo) {
		return AuditTaskFacade.getAcceptTaskTotalCountByUserNo(userNo);
	}

	public static void addExamineWithEmail(String activitiNo, String comment, String userNo, boolean oper) {
		AuditTaskFacade.addExamineWithEmail(activitiNo,comment,userNo,oper);
	}

	public static void finishAuditProcess(String activitiNo){
		ActRuTaskModel.deleteByActivitiNo(activitiNo);
		ActHiProcinstModel.completeHistoryTaskByActivitiNo(activitiNo);
	}
}
