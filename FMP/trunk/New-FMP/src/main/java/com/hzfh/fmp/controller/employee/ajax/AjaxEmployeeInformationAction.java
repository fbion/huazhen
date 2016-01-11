package com.hzfh.fmp.controller.employee.ajax;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.employee.model.EmployeeInformation;
import com.hzfh.api.employee.model.query.EmployeeCondition;
import com.hzfh.api.sales.model.query.ApplyEmployeeCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.common.helper.ExcelHelper;
import com.hzfh.fmp.model.employee.EmployeeInformationModel;
import com.hzframework.contract.SortItem;
import com.hzframework.contract.SortType;
import com.hzframework.helper.StringHelper;


public class AjaxEmployeeInformationAction extends JqGridBaseAction<EmployeeInformation> {
    private EmployeeInformation info;
    private EmployeeInformation employeeInformation;
    private String id;
    private String dept;
    
    
	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public EmployeeInformation getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = JSON.parseObject(info, EmployeeInformation.class);
    }
    
    public EmployeeInformation getEmployeeInformation() {
		return employeeInformation;
	}

	public void setEmployeeInformation(EmployeeInformation employeeInformation) {
		this.employeeInformation = employeeInformation;
	}
    public String exportExcel(){
        ExcelHelper excelHelper =  new ExcelHelper();
        excelHelper.getExcelForEmployeeInformation();
        return null;
    }
    private EmployeeCondition getCondition() {
    	EmployeeCondition employeeCondition = new EmployeeCondition();
         if (!StringHelper.isNullOrEmpty(this.dept)) {
             employeeCondition.setDept(this.dept);
         }
        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItemList.add(sortItem);
        employeeCondition.setSortItemList(sortItemList);
		return employeeCondition;
	}
    //导出微信通讯录
    public String wxExportExcel(){
        ExcelHelper excelHelper =  new ExcelHelper();
        excelHelper.getWxExcelForEmployeeInformation(this.getCondition());
        return null;
    }
    public String extendEmpStartTime(){
    	int id1=Integer.parseInt(id);
    	this.employeeInformation=EmployeeInformationModel.getInfo(id1);
    	return SUCCESS;
    }
   
}
