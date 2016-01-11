package com.hzfh.fmp.model.employee;

import com.hzfh.api.employee.model.AttendanceApplication;
import com.hzfh.api.employee.model.query.AttendanceApplicationCondition;
import com.hzfh.fmp.facade.employee.AttendanceApplicationFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class AttendanceApplicationModel {
    public static PagedList<AttendanceApplication> getPagingList(AttendanceApplicationCondition attendanceApplicationCondition) {
        return AttendanceApplicationFacade.getPagingList(attendanceApplicationCondition);
    }

    public static int add(AttendanceApplication attendanceApplication) {
        return AttendanceApplicationFacade.add(attendanceApplication);
    }

    public static int update(AttendanceApplication attendanceApplication) {
        return AttendanceApplicationFacade.update(attendanceApplication);
    }

    public static List<AttendanceApplication> getList() {
        return AttendanceApplicationFacade.getList();
    }

    public static AttendanceApplication getInfo(int id) {
        return AttendanceApplicationFacade.getInfo(id);
    }
    public static List<AttendanceApplication> getListForExcel(AttendanceApplicationCondition attendanceApplicationCondition){
        return AttendanceApplicationFacade.getListForExcel(attendanceApplicationCondition);
    }
    public static int updateStatusByActivitiNo(String activitiNo){
        return AttendanceApplicationFacade.updateStatusByActivitiNo(activitiNo);
    }
}
