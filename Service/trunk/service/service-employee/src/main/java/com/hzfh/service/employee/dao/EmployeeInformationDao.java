package com.hzfh.service.employee.dao;

import com.hzfh.api.employee.model.EmployeeInformation;
import com.hzfh.api.employee.model.query.EmployeeInformationCondition;
import com.hzframework.data.dao.BaseDao;

import java.util.List;

/**
 * Created by Administrator on 2015/5/20.
 */
public interface EmployeeInformationDao extends BaseDao<EmployeeInformation,EmployeeInformationCondition> {
    public List<EmployeeInformation> getListForExcel(EmployeeInformationCondition employeeInformationCondition);
    public List<EmployeeInformation> getListForExcelByType(int type);
	public List<EmployeeInformation> getExtendEmp();

	public EmployeeInformation getInfo(int id);
}
