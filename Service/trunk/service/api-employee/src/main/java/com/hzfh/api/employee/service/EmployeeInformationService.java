package com.hzfh.api.employee.service;

import com.hzfh.api.employee.model.EmployeeInformation;
import com.hzfh.api.employee.model.query.EmployeeInformationCondition;
import com.hzframework.data.service.BaseService;

import java.util.List;

/**
 * Created by Administrator on 2015/5/20.
 */
public interface EmployeeInformationService  extends BaseService<EmployeeInformation, EmployeeInformationCondition> {
    List<EmployeeInformation> getListForExcel(EmployeeInformationCondition employeeInformationCondition);
    List<EmployeeInformation> getListForExcelByType(int type);
	List<EmployeeInformation> getExtendEmp();

	EmployeeInformation getInfo(int id);

}
