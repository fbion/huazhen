package com.hzfh.fmp.model.sales;

import com.hzfh.api.sales.model.TaskDecision;
import com.hzfh.api.sales.model.query.TaskDecisionCondition;
import com.hzfh.fmp.facade.sales.TaskDecisionFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class TaskDecisionModel {
    public static PagedList<TaskDecision> getPagingList(TaskDecisionCondition taskDecisionCondition) {
        return TaskDecisionFacade.getPagingList(taskDecisionCondition);
    }

    public static int add(TaskDecision taskDecision) {
        return TaskDecisionFacade.add(taskDecision);
    }

    public static int update(TaskDecision taskDecision) {
        return TaskDecisionFacade.update(taskDecision);
    }

    public static List<TaskDecision> getList() {
        return TaskDecisionFacade.getList();
    }

    public static TaskDecision getInfo(int id) {
        return TaskDecisionFacade.getInfo(id);
    }

    public static List<TaskDecision> getListByTaskNo(int taskNo){
    	return TaskDecisionFacade.getListByTaskNo(taskNo);
   	}
	
}
