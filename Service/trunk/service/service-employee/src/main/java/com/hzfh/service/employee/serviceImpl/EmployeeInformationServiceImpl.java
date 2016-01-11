package com.hzfh.service.employee.serviceImpl;

import com.hzfh.api.employee.model.EmployeeInformation;
import com.hzfh.api.employee.model.query.EmployeeInformationCondition;
import com.hzfh.api.employee.service.EmployeeInformationService;
import com.hzfh.service.employee.dao.EmployeeDao;
import com.hzfh.service.employee.dao.EmployeeInformationDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2015/5/20.
 */
@Service("employeeInformationService")
public class EmployeeInformationServiceImpl extends BaseServiceImpl<EmployeeInformation, EmployeeInformationCondition, EmployeeDao> implements EmployeeInformationService {
    @Autowired
    private EmployeeInformationDao employeeInformationDao;
    @Override
    public List<EmployeeInformation> getListForExcel(EmployeeInformationCondition employeeInformationCondition){
        return employeeInformationDao.getListForExcel(employeeInformationCondition);
    }
    @Override
    public List<EmployeeInformation> getListForExcelByType(int type){
        return employeeInformationDao.getListForExcelByType(type);
    }
	@Override
	public List<EmployeeInformation> getExtendEmp() {
		 return employeeInformationDao.getExtendEmp();
	}
	@Override
	public EmployeeInformation getInfo(int id1) {
		// TODO Auto-generated method stub
		return employeeInformationDao.getInfo(id1);
	}

}
