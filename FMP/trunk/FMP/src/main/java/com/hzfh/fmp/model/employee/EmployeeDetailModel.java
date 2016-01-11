package com.hzfh.fmp.model.employee;

import com.hzfh.api.employee.model.EmployeeDetail;
import com.hzfh.api.employee.model.query.EmployeeDetailCondition;
import com.hzfh.fmp.facade.employee.EmployeeDetailFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class EmployeeDetailModel {
    public static PagedList<EmployeeDetail> getPagingList(EmployeeDetailCondition employeeDetailCondition) {
        return EmployeeDetailFacade.getPagingList(employeeDetailCondition);
    }

    public static int add(EmployeeDetail employeeDetail) {
        return EmployeeDetailFacade.add(employeeDetail);
    }

    public static int update(EmployeeDetail employeeDetail) {
        return EmployeeDetailFacade.update(employeeDetail);
    }

    public static List<EmployeeDetail> getList() {
        return EmployeeDetailFacade.getList();
    }

    public static EmployeeDetail getInfo(int id) {
        return EmployeeDetailFacade.getInfo(id);
    }

    public static EmployeeDetail getEmpDetailByEmpNo(int empNo) {
        return EmployeeDetailFacade.getEmpDetailByEmpNo(empNo);
    }

    public static int updateEmpDetailByEmpNo(EmployeeDetail employeeDetail){
        return EmployeeDetailFacade.updateEmpDetailByEmpNo(employeeDetail);
    }


    public static int updateEmpDetailByOtherInfo(EmployeeDetail empDetailInfo) {
        return EmployeeDetailFacade.updateEmpDetailByOtherInfo(empDetailInfo);
    }
}
