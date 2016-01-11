package com.hzfh.fmp.controller.employee.ajax;

import com.hzfh.api.employee.model.Other;
import com.hzfh.api.employee.model.query.OtherCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.employee.OtherModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


public class AjaxOtherAction extends JqGridBaseAction<Other> {
    
	private String type;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	private String empNo;
	public String getEmpNo() {
		return empNo;
	}
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	private String apply;
	public String getApply() {
		return apply;
	}
	public void setApply(String apply) {
		this.apply = apply;
	}
	private String begin;
	public String getBegin() {
		return begin;
	}
	public void setBegin(String begin) {
		this.begin = begin;
	}
	private String end;
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	private String days;
	public String getDays() {
		return days;
	}
	public void setDays(String days) {
		this.days = days;
	}
	private String reason;
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	private String leavetypeNo;
	public String getLeavetypeNo() {
		return leavetypeNo;
	}
	public void setLeavetypeNo(String leavetypeNo) {
		this.leavetypeNo = leavetypeNo;
	}
	private String checkEmpNo;
	public String getCheckEmpNo() {
		return checkEmpNo;
	}
	public void setCheckEmpNo(String checkEmpNo) {
		this.checkEmpNo = checkEmpNo;
	}
	private String checkOk;
	public String getCheckOk() {
		return checkOk;
	}
	public void setCheckOk(String checkOk) {
		this.checkOk = checkOk;
	}

    @Override
    public String execute() throws Exception{
    	OtherCondition otherCondition = new OtherCondition();
        otherCondition.setPageSize(this.getPageSize());
        otherCondition.setPageIndex(this.getPageIndex());

        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        otherCondition.setSortItemList(sortItemList);

        PagedList<Other> otherPagedList= OtherModel.getPagingList(otherCondition);
        this.setResultList(otherPagedList.getResultList());
        this.setPageCount(otherPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(otherPagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(otherPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }

    public String edit(){
        Other other = new Other();
        
		other.setType(Byte.parseByte(this.type));
		other.setEmpNo(Integer.parseInt(this.empNo));
		other.setApply(Timestamp.valueOf(this.apply));
		other.setBegin(Timestamp.valueOf(this.begin));
		other.setEnd(Timestamp.valueOf(this.end));
		other.setDays(Integer.parseInt(this.days));
		other.setReason(this.reason);
		other.setLeavetypeNo(Byte.parseByte(this.leavetypeNo));
		other.setCheckEmpNo(Integer.parseInt(this.checkEmpNo));
		other.setCheckOk(Byte.parseByte(this.checkOk));
		other.setEditComment(this.getEditComment());
		other.setEditUserNo(UserHelper.getEditUserNo());

        if (this.getOper().equalsIgnoreCase("add")) {
        	other.setInUserNo(UserHelper.getEditUserNo());
            if (OtherModel.add(other )<=0){
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
                    other.setId(Integer.parseInt(this.getId()));
                    if (OtherModel.update(other) <= 0){
                        this.setErrCode("update failed");
                        this.setErrDesc("update failed");
                    }
                }
            }
        }

        return SUCCESS;
    }

}
