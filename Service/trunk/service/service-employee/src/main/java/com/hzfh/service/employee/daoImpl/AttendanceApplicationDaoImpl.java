package com.hzfh.service.employee.daoImpl;

import com.hzfh.api.employee.model.AttendanceApplication;
import com.hzfh.api.employee.model.query.AttendanceApplicationCondition;
import com.hzfh.service.employee.dao.AttendanceApplicationDao;
import com.hzfh.service.employee.mapper.AttendanceApplicationMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
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


@Service("attendanceApplicationDao")
public class AttendanceApplicationDaoImpl extends BaseDaoImpl<AttendanceApplication, AttendanceApplicationCondition, AttendanceApplicationMapper> implements AttendanceApplicationDao {
    @Autowired
    private AttendanceApplicationMapper attendanceApplicationMapper;
    @Override
    public List<AttendanceApplication> getListForExcel(AttendanceApplicationCondition attendanceApplicationCondition){
        return attendanceApplicationMapper.getListForExcel(attendanceApplicationCondition);
    }
    @Override
    public int updateStatusByActivitiNo(String activitiNo){
        return attendanceApplicationMapper.updateStatusByActivitiNo(activitiNo);
    }
}