package com.hzfh.fmp.controller.employee.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.employee.model.Employee;
import com.hzfh.api.employee.model.EmployeeDetail;
import com.hzfh.api.employee.model.PersonalChange;
import com.hzfh.api.employee.model.query.PersonalChangeCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.employee.EmployeeDetailModel;
import com.hzfh.fmp.model.employee.EmployeeModel;
import com.hzfh.fmp.model.employee.PersonalChangeModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;


public class AjaxPersonalChangeAction extends JqGridBaseAction<PersonalChange> {
	private PersonalChange info;
	public PersonalChange getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = JSON.parseObject(info, PersonalChange.class);
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
    	PersonalChangeCondition personalChangeCondition = new PersonalChangeCondition();
        personalChangeCondition.setPageSize(this.getPageSize());
        personalChangeCondition.setPageIndex(this.getPageIndex());
        
       
        
        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        personalChangeCondition.setSortItemList(sortItemList);

        PagedList<PersonalChange> personalChangePagedList= PersonalChangeModel.getPagingList(personalChangeCondition);
        this.setResultList(personalChangePagedList.getResultList());
        this.setPageCount(personalChangePagedList.getPagingInfo().getPageCount());
        this.setPageIndex(personalChangePagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(personalChangePagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }

    public String edit(){
		info.setEditUserNo(UserHelper.getEditUserNo());
		int id = 0;
		if (this.getOper().equalsIgnoreCase("add")) {
            info.setInUserNo(UserHelper.getEditUserNo());
			id = PersonalChangeModel.add(info);
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
                    if (PersonalChangeModel.update(info) > 0){
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
        		 this.info  = PersonalChangeModel.getInfo(Integer.parseInt(this.getId()));
			}else{
				PersonalChange personalChange = new PersonalChange();
           		Employee employee = EmployeeModel.getInfo(UserHelper.getUserCache().getEmpId());
           		EmployeeDetail employeeDetail = EmployeeDetailModel.getEmpDetailByEmpNo(UserHelper.getUserCache().getEmpId());
            		if (employeeDetail!=null&&employeeDetail.getStartTime()!=null) {
            			personalChange.setStartTime(employeeDetail.getStartTime());	
            		}	
            		if (employee!=null) {	
            			personalChange.setDeptNo(employee.getDeptNo());
                   		personalChange.setPositionNo(employee.getPositionNo());
                   		personalChange.setEmpNo(employee.getId());
            		}
				this.info = personalChange;
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
