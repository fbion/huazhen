package com.hzfh.fmp.controller.employee.ajax;

import com.hzfh.api.employee.model.EmpBrokerageLadder;
import com.hzfh.api.employee.model.query.EmpBrokerageLadderCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.employee.EmpBrokerageLadderModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;

import java.util.ArrayList;
import java.util.List;


public class AjaxEmpBrokerageLadderAction extends JqGridBaseAction<EmpBrokerageLadder> {
    
	private String code;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	private String empNo;
	public String getEmpNo() {
		return empNo;
	}
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private String upperLimit;
	public String getUpperLimit() {
		return upperLimit;
	}
	public void setUpperLimit(String upperLimit) {
		this.upperLimit = upperLimit;
	}
	private String lowerLimit;
	public String getLowerLimit() {
		return lowerLimit;
	}
	public void setLowerLimit(String lowerLimit) {
		this.lowerLimit = lowerLimit;
	}
	private String moneyAdd;
	public String getMoneyAdd() {
		return moneyAdd;
	}
	public void setMoneyAdd(String moneyAdd) {
		this.moneyAdd = moneyAdd;
	}
	private String rate;
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}

    @Override
    public String execute() throws Exception{
    	EmpBrokerageLadderCondition empBrokerageLadderCondition = new EmpBrokerageLadderCondition();
        empBrokerageLadderCondition.setPageSize(this.getPageSize());
        empBrokerageLadderCondition.setPageIndex(this.getPageIndex());

        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        empBrokerageLadderCondition.setSortItemList(sortItemList);

        PagedList<EmpBrokerageLadder> empBrokerageLadderPagedList= EmpBrokerageLadderModel.getPagingList(empBrokerageLadderCondition);
        this.setResultList(empBrokerageLadderPagedList.getResultList());
        this.setPageCount(empBrokerageLadderPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(empBrokerageLadderPagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(empBrokerageLadderPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }

    public String edit(){
        EmpBrokerageLadder empBrokerageLadder = new EmpBrokerageLadder();
        
		empBrokerageLadder.setCode(this.code);
		empBrokerageLadder.setEmpNo(Integer.parseInt(this.empNo));
		empBrokerageLadder.setName(this.name);
		empBrokerageLadder.setUpperLimit(Long.parseLong(this.upperLimit));
		empBrokerageLadder.setLowerLimit(Long.parseLong(this.lowerLimit));
		empBrokerageLadder.setMoneyAdd(Double.parseDouble(this.moneyAdd));
		empBrokerageLadder.setRate(Double.parseDouble(this.rate));
		empBrokerageLadder.setEditComment(this.getEditComment());
		empBrokerageLadder.setEditUserNo(UserHelper.getEditUserNo());

        if (this.getOper().equalsIgnoreCase("add")) {
        	empBrokerageLadder.setInUserNo(UserHelper.getEditUserNo());
            if (EmpBrokerageLadderModel.add(empBrokerageLadder )<=0){
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
                    empBrokerageLadder.setId(Integer.parseInt(this.getId()));
                    if (EmpBrokerageLadderModel.update(empBrokerageLadder) <= 0){
                        this.setErrCode("update failed");
                        this.setErrDesc("update failed");
                    }
                }
            }
        }

        return SUCCESS;
    }

}
