package com.hzfh.fmp.model.sales;

import com.hzfh.api.sales.model.TaskDecisionLog;
import com.hzfh.api.sales.model.query.TaskDecisionLogCondition;
import com.hzfh.fmp.facade.sales.TaskDecisionLogFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class TaskDecisionLogModel {
    public static PagedList<TaskDecisionLog> getPagingList(TaskDecisionLogCondition taskDecisionLogCondition) {
        return TaskDecisionLogFacade.getPagingList(taskDecisionLogCondition);
    }

    public static int add(TaskDecisionLog taskDecisionLog) {
        return TaskDecisionLogFacade.add(taskDecisionLog);
    }

    public static int update(TaskDecisionLog taskDecisionLog) {
        return TaskDecisionLogFacade.update(taskDecisionLog);
    }

    public static List<TaskDecisionLog> getList() {
        return TaskDecisionLogFacade.getList();
    }

    public static TaskDecisionLog getInfo(int id) {
        return TaskDecisionLogFacade.getInfo(id);
    }
}
