package com.hzfh.fmp.controller.product.ajax;

import com.hzfh.api.product.model.DecisionLog;
import com.hzfh.api.product.model.query.DecisionLogCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.product.DecisionLogModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


public class AjaxDecisionLogAction extends JqGridBaseAction<DecisionLog> {
    
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
    	DecisionLogCondition decisionLogCondition = new DecisionLogCondition();
        decisionLogCondition.setPageSize(this.getPageSize());
        decisionLogCondition.setPageIndex(this.getPageIndex());

        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        decisionLogCondition.setSortItemList(sortItemList);

        PagedList<DecisionLog> decisionLogPagedList= DecisionLogModel.getPagingList(decisionLogCondition);
        this.setResultList(decisionLogPagedList.getResultList());
        this.setPageCount(decisionLogPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(decisionLogPagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(decisionLogPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }

    public String edit(){
        DecisionLog decisionLog = new DecisionLog();
        
		decisionLog.setDepNo(Integer.parseInt(this.depNo));
		decisionLog.setUserNo(Integer.parseInt(this.userNo));
		decisionLog.setIsOk(Byte.parseByte(this.isOk));
		decisionLog.setEditComment(this.getEditComment());
		decisionLog.setCheckTime(Timestamp.valueOf(this.checkTime));
		decisionLog.setEditUserNo(UserHelper.getEditUserNo());

        if (this.getOper().equalsIgnoreCase("add")) {
        	decisionLog.setInUserNo(UserHelper.getEditUserNo());
            if (DecisionLogModel.add(decisionLog )<=0){
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
                    decisionLog.setId(Integer.parseInt(this.getId()));
                    if (DecisionLogModel.update(decisionLog) <= 0){
                        this.setErrCode("update failed");
                        this.setErrDesc("update failed");
                    }
                }
            }
        }

        return SUCCESS;
    }

}
