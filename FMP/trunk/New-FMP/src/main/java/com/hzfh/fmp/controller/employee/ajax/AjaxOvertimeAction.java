package com.hzfh.fmp.controller.employee.ajax;

import com.hzfh.api.employee.model.Overtime;
import com.hzfh.api.employee.model.query.OvertimeCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.employee.OvertimeModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


public class AjaxOvertimeAction extends JqGridBaseAction<Overtime> {
    
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
	private String reason;
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
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
    	OvertimeCondition overtimeCondition = new OvertimeCondition();
        overtimeCondition.setPageSize(this.getPageSize());
        overtimeCondition.setPageIndex(this.getPageIndex());

        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        overtimeCondition.setSortItemList(sortItemList);

        PagedList<Overtime> overtimePagedList= OvertimeModel.getPagingList(overtimeCondition);
        this.setResultList(overtimePagedList.getResultList());
        this.setPageCount(overtimePagedList.getPagingInfo().getPageCount());
        this.setPageIndex(overtimePagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(overtimePagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }

    public String edit(){
        Overtime overtime = new Overtime();
        
		overtime.setEmpNo(Integer.parseInt(this.empNo));
		overtime.setApply(Timestamp.valueOf(this.apply));
		overtime.setBegin(Timestamp.valueOf(this.begin));
		overtime.setEnd(Timestamp.valueOf(this.end));
		overtime.setReason(this.reason);
		overtime.setCheckEmpNo(Integer.parseInt(this.checkEmpNo));
		overtime.setCheckOk(Byte.parseByte(this.checkOk));
		overtime.setEditComment(this.getEditComment());
		overtime.setEditUserNo(UserHelper.getEditUserNo());

        if (this.getOper().equalsIgnoreCase("add")) {
        	overtime.setInUserNo(UserHelper.getEditUserNo());
            if (OvertimeModel.add(overtime )<=0){
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
                    overtime.setId(Integer.parseInt(this.getId()));
                    if (OvertimeModel.update(overtime) <= 0){
                        this.setErrCode("update failed");
                        this.setErrDesc("update failed");
                    }
                }
            }
        }

        return SUCCESS;
    }

}
