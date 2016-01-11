package com.hzfh.fmp.controller.sales.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.employee.model.Department;
import com.hzfh.api.employee.model.Employee;
import com.hzfh.api.employee.model.ExtendProbationApplication;
import com.hzfh.api.employee.model.query.ExtendProbationApplicationCondition;
import com.hzfh.api.payment.model.response.controller.CompleteTransactionNotify;
import com.hzfh.api.sales.model.ApplyEmployee;
import com.hzfh.api.sales.model.Sales;
import com.hzfh.api.sales.model.query.ApplyEmployeeCondition;
import com.hzfh.api.sales.model.query.SalesCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.sales.ApplyEmployeeModel;
import com.hzfh.fmp.model.sales.SalesModel;
import com.hzfh.fmp.model.common.helper.ExcelHelper;
import com.hzfh.fmp.model.common.helper.LogHelper;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.common.properties.DeptHelper;
import com.hzfh.fmp.model.employee.DepartmentModel;
import com.hzfh.fmp.model.employee.EmployeeModel;
import com.hzfh.fmp.model.employee.ExtendProbationApplicationModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.contract.SortType;
import com.hzframework.helper.ArrayHelper;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;


public class AjaxApplyEmployeeAction extends JqGridBaseAction<ApplyEmployee> {
	private int empId;
	private ApplyEmployee info;
	public ApplyEmployee getInfo() {
        return info;
    }
    public void setInfo(String info) {
        this.info = JSON.parseObject(info, ApplyEmployee.class);
    }
    private int activityNo;
    public int getActivityNo() {
		return activityNo;
	}
	public void setActivityNo(int activityNo) {
		this.activityNo = activityNo;
	}
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	private ApplyEmployeeCondition getCondition() {
		ApplyEmployeeCondition applyEmployeeCondition = new ApplyEmployeeCondition();
		applyEmployeeCondition.setPageSize(this.getPageSize());
		applyEmployeeCondition.setPageIndex(this.getPageIndex());
        if(!StringHelper.isNullOrEmpty(Integer.toString(this.activityNo))){
        	applyEmployeeCondition.setActivityNo(this.activityNo);
        }
        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        try {
        	sortItem.setSortFeild("id");
            sortItem.setSortType(SortType.ASC);
		} catch (Exception e) {
			e.printStackTrace();
		}
        sortItemList.add(sortItem);
        applyEmployeeCondition.setSortItemList(sortItemList);
		return applyEmployeeCondition;
	}

    public String execute() throws Exception{
		PagedList<ApplyEmployee> applyEmployeePagedList= ApplyEmployeeModel.getPagingList(this.getCondition());
        this.setResultList(applyEmployeePagedList.getResultList());
        this.setPageCount(applyEmployeePagedList.getPagingInfo().getPageCount());
        this.setPageIndex(applyEmployeePagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(applyEmployeePagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }
    public String sign(){
    	 //报名
    	 ApplyEmployee applyEmployee=new ApplyEmployee();
    	 int id = 0;
    	 Employee employee=EmployeeModel.getEmpByUserId(UserHelper.getEditUserNo());
    	 applyEmployee.setActivityNo(activityNo);
    	 applyEmployee.setCompanyNo(employee.getCompanyNo());
    	 applyEmployee.setDeptNo(employee.getDeptNo());
    	 applyEmployee.setParentNo(employee.getParentNo());
    	 applyEmployee.setPositionNo(employee.getPositionNo());
    	 applyEmployee.setInUserNo(UserHelper.getEditUserNo());
    	 applyEmployee.setEmpNo(UserHelper.getEditUserNo());
    	 applyEmployee.setName(employee.getName());
    	 //applyEmployee.setTel(employee.getTelephone());
    	 applyEmployee.setTel(employee.getCellphone1());
    	 applyEmployee.setSex(employee.getSex());
		 id = ApplyEmployeeModel.add(applyEmployee);
    	return SUCCESS;
    }
    public String arrive(){
    	//签到
    	ApplyEmployee applyEmployee=ApplyEmployeeModel.getInfo(empId);
    	applyEmployee.setIsSign(1);
    	ApplyEmployeeModel.update(applyEmployee);
    	return SUCCESS;
    }
    public String edit(){
		info.setEditUserNo(UserHelper.getEditUserNo());
		int id = 0;
		if (this.getOper().equalsIgnoreCase("add")) {
            info.setInUserNo(UserHelper.getEditUserNo());
			id = ApplyEmployeeModel.add(info);
            if (id > 0){
				this.setErrDesc(String.valueOf(id));                
            }else{
				this.setErrCode("add failed");
                this.setErrDesc("add failed");
			}
                
        }
        else
        {
            if (info.getId() == 0) {
                this.setErrCode("NoID");
                this.setErrDesc("NoID");
            }
            else{
                if (this.getOper().equalsIgnoreCase("edit")) {                    
                    if (ApplyEmployeeModel.update(info) > 0){
						this.setErrDesc(String.valueOf(info.getId()));
                    }else{
						this.setErrCode("update failed");
                        this.setErrDesc("update failed");
					}
                        
                }
            }
        }

        return SUCCESS;
    }

	public String getInfoById() {
        if (StringHelper.isNullOrEmpty(this.getId())) {
            this.setErrCode("NoID");
            this.setErrDesc("NoID");
        } else {
            this.info = ApplyEmployeeModel.getInfo(Integer.parseInt(this.getId()));
            if (this.info == null) {
                this.setErrCode("No Info");
                this.setErrDesc("No Info");
            }
        }

        return SUCCESS;
    }
	public String exportExcel() {
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.getExcelForApplyEmployeeList(this.getCondition());
        return null;
    }

}
