package com.hzfh.fmp.model.workFlow;

import com.hzfh.api.workFlow.model.ActRuTask;
import com.hzfh.api.workFlow.model.query.ActRuTaskCondition;
import com.hzfh.fmp.facade.workFlow.ActRuTaskFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class ActRuTaskModel {
    public static PagedList<ActRuTask> getPagingList(ActRuTaskCondition ActRuTaskCondition) {
        return ActRuTaskFacade.getPagingList(ActRuTaskCondition);
    }

    public static int add(ActRuTask ActRuTask) {
        return ActRuTaskFacade.add(ActRuTask);
    }

    public static int update(ActRuTask ActRuTask) {
        return ActRuTaskFacade.update(ActRuTask);
    }

    public static List<ActRuTask> getList() {
        return ActRuTaskFacade.getList();
    }

    public static ActRuTask getInfo(int id) {
        return ActRuTaskFacade.getInfo(id);
    }

	public static int getAcceptTaskTotalCountByUserNo(String userNo) {
		return ActRuTaskFacade.getAcceptTaskTotalCountByUserNo(userNo);
	}

    public static ActRuTask getInfoByAciIdAndUserId(String activityNo, int userId) {
        return ActRuTaskFacade.getInfoByAciIdAndUserId(activityNo,userId);
    }

    public static int deleteByActivitiNo(String activitiNo){
        return ActRuTaskFacade.deleteByActivitiNo(activitiNo);
    }

    public static List<ActRuTask> getListByActivitiNo(String activitiNo){
        return ActRuTaskFacade.getListByActivitiNo(activitiNo);
    }
    public static int updateAssigneeByActivitiNo(String activitiNo,String assignee) {
        return ActRuTaskFacade.updateAssigneeByActivitiNo(activitiNo,assignee);
    }
}
