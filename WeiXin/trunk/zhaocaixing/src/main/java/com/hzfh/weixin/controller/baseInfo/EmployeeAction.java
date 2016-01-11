package com.hzfh.weixin.controller.baseInfo;

import com.hzfh.api.employee.model.Employee;
import com.hzfh.weixin.controller.common.CommonAction;
import com.hzfh.weixin.model.baseInfo.EmployeeModel;
import com.hzfh.weixin.model.common.helper.UrlHelper;

import java.util.List;

public class EmployeeAction extends CommonAction {

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



	public void setParam(int param) {
		this.param = param;
	}



		@Override
		public String execute() {
	        String status = "1";//先默认1为在职状态
	        employeeList = EmployeeModel.getEmpListByDeptAndStatus(param, status);
	        for (Employee e : employeeList) {
				String path = e.getPortraitPath();
				if(path!=null){
					path = UrlHelper.buildWebImg(path);
					e.setPortraitPath(path);
				}
			}
			return SUCCESS;
		}
	    
}
