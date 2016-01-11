package com.hzfh.service.payment.serviceImpl;

import java.util.List;

import com.hzfh.api.payment.model.ExamineCallbackRecord;
import com.hzfh.api.payment.model.query.ExamineCallbackRecordCondition;
import com.hzfh.api.payment.service.ExamineCallbackRecordService;
import com.hzfh.service.payment.dao.ExamineCallbackRecordDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/10/19 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("examineCallbackRecordService")
public class ExamineCallbackRecordServiceImpl extends BaseServiceImpl<ExamineCallbackRecord, ExamineCallbackRecordCondition, ExamineCallbackRecordDao> implements ExamineCallbackRecordService {
	@Autowired
	ExamineCallbackRecordDao  examineCallbackRecordDao;
	@Override
	public List<ExamineCallbackRecord> getListByStatus(byte status) {
		return examineCallbackRecordDao.getListByStatus(status);
	}
	@Override
	public int updateStatusById(byte status, int id) {
		return examineCallbackRecordDao.updateStatusById(status,id);
	}
	@Override
	public ExamineCallbackRecord getinfoByoperationTypeAndSn(String operationType, String sn) {
		return examineCallbackRecordDao.getinfoByoperationTypeAndSn(operationType,sn);
	}
	@Override
	public int updateStatusByoperationTypeAndSn(byte status,String operationType, String sn) {
		return examineCallbackRecordDao.updateStatusByoperationTypeAndSn(status,operationType,sn);
	}
}