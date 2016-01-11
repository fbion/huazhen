package com.hzfh.fmp.model.employee;

import com.hzfh.api.employee.model.EmployeeInformation;
import com.hzfh.api.employee.model.query.EmployeeInformationCondition;
import com.hzfh.fmp.facade.employee.EmployeeInformationFacade;

import java.util.List;

/**
 * Created by Administrator on 2015/5/20.
 */
public class EmployeeInformationModel {
    public static List<EmployeeInformation> getListForExcel(EmployeeInformationCondition employeeInformationCondition){
        return EmployeeInformationFacade.getListForExcel(employeeInformationCondition);
    }

    public static List<EmployeeInformation> getListForExcelByType(int type){
        return EmployeeInformationFacade.getListForExcelByType(type);
    }

	public static List<EmployeeInformation> getExtendEmp() {
		 return EmployeeInformationFacade.getExtendEmp();
	}

	public static EmployeeInformation getInfo(int id1) {
		// TODO Auto-generated method stub
		return EmployeeInformationFacade.getInfo(id1);
	}
 }
