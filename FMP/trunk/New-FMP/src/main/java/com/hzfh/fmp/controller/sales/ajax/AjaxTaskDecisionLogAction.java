package com.hzfh.fmp.controller.sales.ajax;

import com.hzfh.api.sales.model.TaskDecisionLog;
import com.hzfh.api.sales.model.query.TaskDecisionLogCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.sales.TaskDecisionLogModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


public class AjaxTaskDecisionLogAction extends JqGridBaseAction<TaskDecisionLog> {
    
	private String depNo;
	public String getDepNo() {
		return depNo;
	}
	public void setDepNo(String depNo) {
		this.depNo = depNo;
	}
	private String userNo;
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	private String isOk;
	public String getIsOk() {
		return isOk;
	}
	public void setIsOk(String isOk) {
		this.isOk = isOk;
	}
	private String checkTime;
	public String getCheckTime() {
		return checkTime;
	}
	public void setCheckTime(String checkTime) {
		this.checkTime = checkTime;
	}

    @Override
    public String execute() throws Exception{
    	TaskDecisionLogCondition taskDecisionLogCondition = new TaskDecisionLogCondition();
        taskDecisionLogCondition.setPageSize(this.getPageSize());
        taskDecisionLogCondition.setPageIndex(this.getPageIndex());

        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        taskDecisionLogCondition.setSortItemList(sortItemList);

        PagedList<TaskDecisionLog> taskDecisionLogPagedList= TaskDecisionLogModel.getPagingList(taskDecisionLogCondition);
        this.setResultList(taskDecisionLogPagedList.getResultList());
        this.setPageCount(taskDecisionLogPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(taskDecisionLogPagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(taskDecisionLogPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }

    public String edit(){
        TaskDecisionLog taskDecisionLog = new TaskDecisionLog();
        
		taskDecisionLog.setDepNo(Integer.parseInt(this.depNo));
		taskDecisionLog.setUserNo(Integer.parseInt(this.userNo));
		taskDecisionLog.setIsOk(Byte.valueOf(this.isOk));
		taskDecisionLog.setEditComment(this.getEditComment());
		taskDecisionLog.setCheckTime(Timestamp.valueOf(this.checkTime));
		taskDecisionLog.setEditUserNo(UserHelper.getEditUserNo());

        if (this.getOper().equalsIgnoreCase("add")) {
        	taskDecisionLog.setInUserNo(UserHelper.getEditUserNo());
            if (TaskDecisionLogModel.add(taskDecisionLog )<=0){
                this.setErrCode("add failed");
                this.setErrDesc("add failed");
            }
        }
        else
        {
            if (this.getId().isEmpty()) {
                this.setErrCode("NoID");
                this.setErrDesc("NoID");
            }
            else{
                if (this.getOper().equalsIgnoreCase("edit")) {
                    taskDecisionLog.setId(Integer.parseInt(this.getId()));
                    if (TaskDecisionLogModel.update(taskDecisionLog) <= 0){
                        this.setErrCode("update failed");
                        this.setErrDesc("update failed");
                    }
                }
            }
        }

        return SUCCESS;
    }

}
