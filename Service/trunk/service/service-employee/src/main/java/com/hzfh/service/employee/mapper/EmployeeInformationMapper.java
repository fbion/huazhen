package com.hzfh.service.employee.mapper;

import com.hzfh.api.employee.model.EmployeeInformation;
import com.hzfh.api.employee.model.query.EmployeeInformationCondition;
import com.hzframework.data.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2015/5/20.
 */
@Service("employeeInformationMapper")
public interface EmployeeInformationMapper  extends BaseMapper<EmployeeInformation, EmployeeInformationCondition> {
    public List<EmployeeInformation> getListForExcel(EmployeeInformationCondition employeeInformationCondition);
    public List<EmployeeInformation> getListForExcelByType(@Param("type")int type);

	public List<EmployeeInformation> getExtendEmp();

	public EmployeeInformation getInfo(int id1);
}
