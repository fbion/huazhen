package com.hzfh.service.employee.daoImpl;

import com.hzfh.api.employee.model.EmployeeInformation;
import com.hzfh.api.employee.model.query.EmployeeInformationCondition;
import com.hzfh.service.employee.dao.EmployeeInformationDao;
import com.hzfh.service.employee.mapper.EmployeeInformationMapper;
import com.hzfh.service.employee.mapper.EmployeeMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2015/5/20.
 */
@Service("employeeInformationDao")
public class EmployeeInformationDaoImpl  extends BaseDaoImpl<EmployeeInformation, EmployeeInformationCondition, EmployeeMapper> implements EmployeeInformationDao {
    @Autowired
    private EmployeeInformationMapper employeeInformationMapper;
    @Override
    public List<EmployeeInformation> getListForExcel(EmployeeInformationCondition employeeInformationCondition){
        return employeeInformationMapper.getListForExcel(employeeInformationCondition);
    }
    @Override
    public List<EmployeeInformation> getListForExcelByType(int type){
        return employeeInformationMapper.getListForExcelByType(type);
    }
	@Override
	public List<EmployeeInformation> getExtendEmp() {
		return employeeInformationMapper.getExtendEmp();
	}
	@Override
	public EmployeeInformation getInfo(int id1) {
		// TODO Auto-generated method stub
		return employeeInformationMapper.getInfo(id1);
	}


}
