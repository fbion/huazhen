package com.hzfh.fmp.model.workFlow;

import java.util.List;
import java.util.Map;

import org.activiti.engine.history.HistoricTaskInstance;

import com.hzfh.fmp.facade.workFlow.ApprovalHistoriaFacade;

public class ApprovalHistoriaModel {

	public static List<HistoricTaskInstance> getHiTaskPagedListbyUserNo(Map<String, Object> paramMap) {
		return ApprovalHistoriaFacade.getHiTaskPagedListbyUserNo(paramMap);
	}

	public static int getApprovalHistoriaTotalCount(Map<String, Object> paramMap) {
		return ApprovalHistoriaFacade.getApprovalHistoriaTotalCount(paramMap);
	}	
}
