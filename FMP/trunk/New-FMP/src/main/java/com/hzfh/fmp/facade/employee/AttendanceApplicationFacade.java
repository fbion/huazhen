package com.hzfh.fmp.facade.employee;

import com.hzfh.api.employee.model.AttendanceApplication;
import com.hzfh.api.employee.model.query.AttendanceApplicationCondition;
import com.hzfh.api.employee.service.AttendanceApplicationService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class AttendanceApplicationFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-employee.xml");

    public static PagedList<AttendanceApplication> getPagingList(AttendanceApplicationCondition attendanceApplicationCondition) {
        AttendanceApplicationService attendanceApplicationService = (AttendanceApplicationService) context.getBean("attendanceApplicationService");

        return  attendanceApplicationService.getPagingList(attendanceApplicationCondition);
    }

    public static int add(AttendanceApplication attendanceApplication){
        AttendanceApplicationService attendanceApplicationService = (AttendanceApplicationService) context.getBean("attendanceApplicationService");

        return attendanceApplicationService.add(attendanceApplication);
    }

    public static int update(AttendanceApplication attendanceApplication){
        AttendanceApplicationService attendanceApplicationService = (AttendanceApplicationService) context.getBean("attendanceApplicationService");

        return attendanceApplicationService.update(attendanceApplication);
    }

    public static List<AttendanceApplication> getList(){
        AttendanceApplicationService attendanceApplicationService = (AttendanceApplicationService) context.getBean("attendanceApplicationService");

        return attendanceApplicationService.getList();
    }

    public static AttendanceApplication getInfo(int id){
        AttendanceApplicationService attendanceApplicationService = (AttendanceApplicationService) context.getBean("attendanceApplicationService");

        return attendanceApplicationService.getInfo(id);
    }
    public static List<AttendanceApplication> getListForExcel(AttendanceApplicationCondition attendanceApplicationCondition) {
        AttendanceApplicationService attendanceApplicationService = (AttendanceApplicationService) context.getBean("attendanceApplicationService");

        return  attendanceApplicationService.getListForExcel(attendanceApplicationCondition);
    }
    public static int updateStatusByActivitiNo(String activitiNo){
        AttendanceApplicationService attendanceApplicationService = (AttendanceApplicationService) context.getBean("attendanceApplicationService");
        return attendanceApplicationService.updateStatusByActivitiNo(activitiNo);

    }
}
