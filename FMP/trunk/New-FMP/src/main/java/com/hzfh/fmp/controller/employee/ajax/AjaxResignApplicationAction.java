package com.hzfh.fmp.controller.employee.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.employee.model.Employee;
import com.hzfh.api.employee.model.EmployeeDetail;
import com.hzfh.api.employee.model.ResignApplication;
import com.hzfh.api.employee.model.query.ResignApplicationCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.employee.EmployeeDetailModel;
import com.hzfh.fmp.model.employee.EmployeeModel;
import com.hzfh.fmp.model.employee.ResignApplicationModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;


public class AjaxResignApplicationAction extends JqGridBaseAction<ResignApplication> {
	private ResignApplication info;
	public ResignApplication getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = JSON.parseObject(info, ResignApplication.class);
    }
    
    private String empName;
    public String getEmpName() {
		return empName;
	}
    private String activitiID;
    
    public void setActivitiID(String activitiID) {
		this.activitiID = activitiID;
	}
	@Override
    public String execute() throws Exception{
    	ResignApplicationCondition resignApplicationCondition = new ResignApplicationCondition();
        resignApplicationCondition.setPageSize(this.getPageSize());
        resignApplicationCondition.setPageIndex(this.getPageIndex());

        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        resignApplicationCondition.setSortItemList(sortItemList);

        PagedList<ResignApplication> resignApplicationPagedList= ResignApplicationModel.getPagingList(resignApplicationCondition);
        this.setResultList(resignApplicationPagedList.getResultList());
        this.setPageCount(resignApplicationPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(resignApplicationPagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(resignApplicationPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }

    public String edit(){
		info.setEditUserNo(UserHelper.getEditUserNo());
		int id = 0;
		if (this.getOper().equalsIgnoreCase("add")) {
            info.setInUserNo(UserHelper.getEditUserNo());
			id = ResignApplicationModel.add(info);
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
            	if(!StringHelper.isNullOrEmpty(this.activitiID)){
            		info.setActivitiNo(this.activitiID);
            	}
                if (this.getOper().equalsIgnoreCase("edit")) {                    
                    if (ResignApplicationModel.update(info) > 0){
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
        	
        	if (Integer.valueOf(this.getId())!=0) {
        		this.info = ResignApplicationModel.getInfo(Integer.parseInt(this.getId()));
			}else{
				ResignApplication resignApplication = new ResignApplication();
          		Employee employee = EmployeeModel.getInfo(UserHelper.getUserCache().getEmpId());
          		EmployeeDetail employeeDetail = EmployeeDetailModel.getEmpDetailByEmpNo(UserHelper.getUserCache().getEmpId());
           		if (employeeDetail!=null&&employeeDetail.getStartTime()!=null) {
           			resignApplication.setHireTime(employeeDetail.getStartTime());
           		}
       			if (employee!=null) {
       				resignApplication.setDeptNo(employee.getDeptNo());
           			resignApplication.setPositionNo(employee.getPositionNo());
           			resignApplication.setEmpNo(employee.getId());
				}
				this.info = resignApplication;
			}
	            if (this.info == null) {
	                this.setErrCode("No Info");
	                this.setErrDesc("No Info");
	            }
        }
        this.empName = UserHelper.getUserCache().getEmpName();
        return SUCCESS;
    }

}
