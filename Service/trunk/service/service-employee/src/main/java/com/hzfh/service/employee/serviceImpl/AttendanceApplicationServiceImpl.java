package com.hzfh.service.employee.serviceImpl;

import com.hzfh.api.employee.model.AttendanceApplication;
import com.hzfh.api.employee.model.query.AttendanceApplicationCondition;
import com.hzfh.api.employee.service.AttendanceApplicationService;
import com.hzfh.service.employee.dao.AttendanceApplicationDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/5/18 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("attendanceApplicationService")
public class AttendanceApplicationServiceImpl extends BaseServiceImpl<AttendanceApplication, AttendanceApplicationCondition, AttendanceApplicationDao> implements AttendanceApplicationService {
    @Autowired
    private AttendanceApplicationDao attendanceApplicationDao;
    @Override
    public List<AttendanceApplication> getListForExcel(AttendanceApplicationCondition attendanceApplicationCondition){
        return attendanceApplicationDao.getListForExcel(attendanceApplicationCondition);
    }
    @Override
    public int updateStatusByActivitiNo(String activitiNo){
        return attendanceApplicationDao.updateStatusByActivitiNo(activitiNo);
    }
}