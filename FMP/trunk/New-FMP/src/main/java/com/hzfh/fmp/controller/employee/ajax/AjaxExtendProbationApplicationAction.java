package com.hzfh.fmp.controller.employee.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.employee.model.Department;
import com.hzfh.api.employee.model.Employee;
import com.hzfh.api.employee.model.ExtendProbationApplication;
import com.hzfh.api.employee.model.query.ExtendProbationApplicationCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.employee.DepartmentModel;
import com.hzfh.fmp.model.employee.EmployeeModel;
import com.hzfh.fmp.model.employee.ExtendProbationApplicationModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;


public class AjaxExtendProbationApplicationAction extends JqGridBaseAction<ExtendProbationApplication> {
	private ExtendProbationApplication info;
    private int byEmpNo;
    private String bySelectDepartment;
    private String bySelectPositionNo;
	public ExtendProbationApplication getInfo() {
        return info;
    }

    public int getByEmpNo() {
		return byEmpNo;
	}

	public void setByEmpNo(int byEmpNo) {
		this.byEmpNo = byEmpNo;
	}

	public void setInfo(String info) {
        this.info = JSON.parseObject(info, ExtendProbationApplication.class);
    }

      
	public String getBySelectDepartment() {
		return bySelectDepartment;
	}

	public void setBySelectDepartment(String bySelectDepartment) {
		this.bySelectDepartment = bySelectDepartment;
	}

	public String getBySelectPositionNo() {
		return bySelectPositionNo;
	}

	public void setBySelectPositionNo(String bySelectPositionNo) {
		this.bySelectPositionNo = bySelectPositionNo;
	}
	private String showAllList;
	public String getShowAllList() {
		return showAllList;
	}
	public void setShowAllList(String showAllList) {
		this.showAllList = showAllList;
	}
	private String firstShowAllList;
	public String getFirstShowAllList() {
		return firstShowAllList;
	}
	public void setFirstShowAllList(String firstShowAllList) {
		this.firstShowAllList = firstShowAllList;
	}
	
	private String empName;
    public String getEmpName() {
		return empName;
	}
    private String activitiID;
    
    public void setActivitiID(String activitiID) {
		this.activitiID = activitiID;
	}

	private ExtendProbationApplicationCondition getCondition() {
		ExtendProbationApplicationCondition extendProbationApplicationCondition = new ExtendProbationApplicationCondition();
		extendProbationApplicationCondition.setPageSize(this.getPageSize());
		extendProbationApplicationCondition.setPageIndex(this.getPageIndex());
	    
        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        extendProbationApplicationCondition.setSortItemList(sortItemList);
        if ("query".equals(this.showAllList)||"query".equals(this.firstShowAllList)) {
        	extendProbationApplicationCondition.setWorkMateString(null);
        }else{
	        List<Integer> workmate = UserHelper.getUserCache().getWorkMate();
	        if (workmate != null) {
	        	List<Integer> workmateEmpNoList = new ArrayList<Integer>();
	        	for(int i=0;i<workmate.size();i++){
	        		int empNo = EmployeeModel.getEmpByUserId(workmate.get(i)).getId(); 
	        		workmateEmpNoList.add(empNo);
	        	}
	        	workmateEmpNoList.add(EmployeeModel.getEmpByUserId(UserHelper.getUserCache().getUserId()).getId());
	            String workMateString = StringHelper.listToString(workmateEmpNoList);
	            extendProbationApplicationCondition.setWorkMateString(workMateString);
	        } else {
	        	extendProbationApplicationCondition.setWorkMateString(String.valueOf(EmployeeModel.getEmpByUserId(UserHelper.getUserCache().getUserId()).getId()));
        }
	    if(!StringHelper.isNullOrEmpty(Integer.toString(this.byEmpNo))){
	    	extendProbationApplicationCondition.setEmpNo(this.byEmpNo);
	    }
	    if(!StringHelper.isNullOrEmpty(this.bySelectDepartment)){
			extendProbationApplicationCondition.setDeptNo(Byte.valueOf(this.bySelectDepartment));
	    }
	    if(!StringHelper.isNullOrEmpty(this.bySelectPositionNo)){
	    	extendProbationApplicationCondition.setPositionNo(Byte.valueOf(this.bySelectPositionNo));
	    }    
       }
		return extendProbationApplicationCondition;
	}
	@Override
    public String execute() throws Exception{
        PagedList<ExtendProbationApplication> extendProbationApplicationPagedList= ExtendProbationApplicationModel.getPagingList(this.getCondition());
        this.setResultList(extendProbationApplicationPagedList.getResultList());
        this.setPageCount(extendProbationApplicationPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(extendProbationApplicationPagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(extendProbationApplicationPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }
    public String edit(){
		info.setEditUserNo(UserHelper.getEditUserNo());
		int id = 0;
		if (this.getOper().equalsIgnoreCase("add")) {
			if(!StringHelper.isNullOrEmpty(this.activitiID)){
        		info.setActivitiNo(this.activitiID);
        	}
            info.setInUserNo(UserHelper.getEditUserNo());
            try {
            	Department department = DepartmentModel.getInfo(info.getDeptNo());
    			info.setCompanyNo(department.getCompanyNo());
            	id = ExtendProbationApplicationModel.add(info);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
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
                	Department department = DepartmentModel.getInfo(info.getDeptNo());
					info.setCompanyNo(department.getCompanyNo());
                    if (ExtendProbationApplicationModel.update(info) > 0){
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
            this.info = ExtendProbationApplicationModel.getInfo(Integer.parseInt(this.getId()));
            Employee employee=EmployeeModel.getInfo(info.getEmpNo());
            info.setEmpName(employee.getName());
            if (this.info == null) {
                this.setErrCode("No Info");
                this.setErrDesc("No Info");
            }
        }
        this.empName = UserHelper.getUserCache().getEmpName();
        return SUCCESS;
    }

}
