package com.hzfh.weixin.controller.baseInfo.ajax;

import java.util.ArrayList;
import java.util.List;

import com.hzfh.api.employee.model.Employee;
import com.hzfh.weixin.controller.common.CommonAction;
import com.hzfh.weixin.model.baseInfo.EmployeeModel;
import com.hzfh.weixin.model.common.PageAlias;
import com.hzfh.weixin.model.common.helper.UrlHelper;
import com.hzfh.weixin.model.common.paramter.StatusType;
import com.hzframework.helper.StringHelper;


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
		 this.setPageAlias(PageAlias.newRegister);
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
				String[] value = path.split("\\.");
				path = path.replace("."+value[value.length-1], "_weixin."+value[value.length-1]);
				path = UrlHelper.bulidWebUploadPath(path);
				e.setPortraitPath(path);
			}
		}
		return SUCCESS;
	}
    

}
