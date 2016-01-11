package com.hzfh.service.employee.mapper;

import com.hzfh.api.employee.model.DeptYearNeed;
import com.hzfh.api.employee.model.Employee;
import com.hzfh.api.employee.model.query.EmployeeCondition;
import com.hzframework.data.mapper.BaseMapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ****************************************************************************
 * <p/>
 * Copyright 2015 HZFH. All rights reserved.
 * Author: GuoZhenYu
 * Create Date: 2015/1/16
 * Description:
 * <p/>
 * Revision History:
 * Date         Author               Description
 * <p/>
 * ****************************************************************************
 */


@Service("employeeMapper")
public interface EmployeeMapper extends BaseMapper<Employee, EmployeeCondition> {

    public Employee getEmpByUserId(int userId);

    public List<Employee> getEmpListByDept(int deptNo);

    public List<Employee> getEmpListNoTest();
    public List<Employee>  getInfoByCondition(EmployeeCondition employeeCondition);

    public List<Employee> getEmpListByDeptAndStatus(@Param("deptNo") int deptNo, @Param("statusString") String statusString);//新添 liyh

    public List<Employee> getEmpListByEmpId(int empId);

    public List<Employee> getEmpListByParentNo(int id);

    public List<Employee> getEmpByPositionNoAndStoreNo(@Param("positionNo") int positionNo, @Param("storeNo") int storeNo);
    
    public List<Employee> getEmpByPositionNoAndStoreNoIsUse(@Param("positionNo") int positionNo, @Param("storeNo") int storeNo,@Param("status") int status);

    public int addFilePath(Employee employeeFile);

    public List<Employee> getEmpListByPositionNo(@Param("positionNo") int positionNo);

    public List<DeptYearNeed> getFinancialYear();

    int updateEmpByEmpDetail(Employee employee);

    public Employee getEmpByEmpName(@Param("byName") String byName);

    public int updateIsSendEmailById(@Param("id") int id);

    public List<Employee> getNowEmpListByPositionNo(@Param("positionNo") int positionNo);

    public List<Employee> getEmpListByStatus(@Param("status") int status);

    public List<Employee> getEmpListIsTest(@Param("isTest") byte isTest);

    int updateCheckById(@Param("id")int id,@Param("status")byte status);

	public int updateStatusByEmpNo(@Param("empNo")int empNo);

	public List<Employee> getListForExcel(EmployeeCondition employeeCondition);

	public List<Employee> getEmpListByDeptAndStatusList(@Param("deptNo")int deptNo,@Param("statusList")List<Integer> statusList);//MengChong  2015-09-15

}