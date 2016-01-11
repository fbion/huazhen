package com.hzfh.fmp.model.employee;

import com.hzfh.api.employee.model.EmployeeEducation;
import com.hzfh.api.employee.model.query.EmployeeEducationCondition;
import com.hzfh.fmp.facade.employee.EmployeeEducationFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class EmployeeEducationModel {
    public static PagedList<EmployeeEducation> getPagingList(EmployeeEducationCondition employeeEducationCondition) {
        return EmployeeEducationFacade.getPagingList(employeeEducationCondition);
    }

    public static int add(EmployeeEducation employeeEducation) {
        return EmployeeEducationFacade.add(employeeEducation);
    }

    public static int update(EmployeeEducation employeeEducation) {
        return EmployeeEducationFacade.update(employeeEducation);
    }

    public static List<EmployeeEducation> getList() {
        return EmployeeEducationFacade.getList();
    }

    public static EmployeeEducation getInfo(int id) {
        return EmployeeEducationFacade.getInfo(id);
    }

    public static List<EmployeeEducation> getEmpEduByEmpNo(int empNo) {
        return EmployeeEducationFacade.getEmpEduByEmpNo(empNo);
    }

}
