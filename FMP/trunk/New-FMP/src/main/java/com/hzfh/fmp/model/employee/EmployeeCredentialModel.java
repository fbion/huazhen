package com.hzfh.fmp.model.employee;

import com.hzfh.api.employee.model.EmployeeCredential;
import com.hzfh.api.employee.model.query.EmployeeCredentialCondition;
import com.hzfh.fmp.facade.employee.EmployeeCredentialFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class EmployeeCredentialModel {
    public static PagedList<EmployeeCredential> getPagingList(EmployeeCredentialCondition employeeCredentialCondition) {
        return EmployeeCredentialFacade.getPagingList(employeeCredentialCondition);
    }

    public static int add(EmployeeCredential employeeCredential) {
        return EmployeeCredentialFacade.add(employeeCredential);
    }

    public static int update(EmployeeCredential employeeCredential) {
        return EmployeeCredentialFacade.update(employeeCredential);
    }

    public static List<EmployeeCredential> getList() {
        return EmployeeCredentialFacade.getList();
    }

    public static EmployeeCredential getInfo(int id) {
        return EmployeeCredentialFacade.getInfo(id);
    }

    public static List<EmployeeCredential> getEmpCredentialByEmpNo(int empNo) {
        return EmployeeCredentialFacade.getEmpCredentialByEmpNo(empNo);
    }
}
