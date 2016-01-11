package com.hzfh.api.employee.service;

import com.hzfh.api.employee.model.AttendanceApplication;
import com.hzfh.api.employee.model.query.AttendanceApplicationCondition;
import com.hzframework.data.service.BaseService;

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


public interface AttendanceApplicationService extends BaseService<AttendanceApplication, AttendanceApplicationCondition> {
    List<AttendanceApplication> getListForExcel(AttendanceApplicationCondition attendanceApplicationCondition);
    int updateStatusByActivitiNo(String activitiNo);
}