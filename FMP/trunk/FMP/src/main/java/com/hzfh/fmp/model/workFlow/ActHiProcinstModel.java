package com.hzfh.fmp.model.workFlow;

import com.hzfh.api.workFlow.model.ActHiProcinst;
import com.hzfh.api.workFlow.model.query.ActHiProcinstCondition;
import com.hzfh.fmp.facade.workFlow.ActHiProcinstFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class ActHiProcinstModel {
    public static PagedList<ActHiProcinst> getPagingList(ActHiProcinstCondition actHiProcinstCondition) {
        return ActHiProcinstFacade.getPagingList(actHiProcinstCondition);
    }

    public static int add(ActHiProcinst actHiProcinst) {
        return ActHiProcinstFacade.add(actHiProcinst);
    }

    public static int update(ActHiProcinst actHiProcinst) {
        return ActHiProcinstFacade.update(actHiProcinst);
    }

    public static List<ActHiProcinst> getList() {
        return ActHiProcinstFacade.getList();
    }

    public static ActHiProcinst getInfo(int id) {
        return ActHiProcinstFacade.getInfo(id);
    }

	public static ActHiProcinst getInfoByProcDefId(String procDefId) {
		return ActHiProcinstFacade.getInfoByProcDefId(procDefId);
	}

	public static ActHiProcinst getInfoByProInsId(String processInstanceId) {
		return ActHiProcinstFacade.getInfoByProInsId(processInstanceId);
	}

    public static int completeHistoryTaskByActivitiNo(String activitiNo){
        return ActHiProcinstFacade.completeHistoryTaskByActivitiNo(activitiNo);
    }

	public static ActHiProcinst getInfoString(String id) {
		return ActHiProcinstFacade.getInfoString(id);
	}
}
