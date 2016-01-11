package com.hzfh.p2p.controller.baseInfo.ajax;

import com.hzfh.api.employee.model.Employee;
import com.hzfh.p2p.controller.common.BaseAction;
import com.hzfh.p2p.controller.common.CommonAction;
import com.hzfh.p2p.model.baseInfo.EmployeeModel;
import com.hzfh.p2p.model.common.PageAlias;
import com.hzfh.p2p.model.common.helper.UrlHelper;
import com.hzfh.p2p.model.common.parameter.StatusType;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;


public class AjaxEmlopyeeAction extends CommonAction {
	private List<Employee>  employeeList;
	private int param;
	   

	public List<Employee> getEmployeeList() {
		return employeeList;
	}


	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}


	public int getParam() {
		return param;
	}


	public void setParam(String param) {
		if(!StringHelper.isNullOrEmpty(param)){
			this.param = Integer.valueOf(param);
		}
	}


	@Override
	public String execute() {
		 this.setPageAlias(PageAlias.employeePhoto);
	     String ret = super.execute();
	     if (!ret.equals(SUCCESS))
	           return ret;
        //int status = 1;//先默认1为在职状态
		List<Integer>  statusList= new ArrayList<Integer>();
		statusList.add(StatusType.ON_THE_JOB_EMPLOYEES);
		statusList.add(StatusType.PROBATIONARY_EMPLOYEES);
		statusList.add(StatusType.INTERNSHIP_EMPLOYEES);
		
		employeeList = EmployeeModel.getEmpListByDeptAndStatusList(param, statusList);
        //employeeList = EmployeeModel.getEmpListByDeptAndStatus(param, "1,4,5");
        for (Employee e : employeeList) {
 			String path = e.getPortraitPath();
			if(path!=null){
				path = UrlHelper.bulidWebUploadPath(path);
				e.setPortraitPath(path);
			}
		}
		return SUCCESS;
	}
    

}
