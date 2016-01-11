package com.hzfh.service.payment.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzfh.api.payment.model.ExamineCallbackRecord;
import com.hzfh.api.payment.model.query.ExamineCallbackRecordCondition;
import com.hzfh.service.payment.dao.ExamineCallbackRecordDao;
import com.hzfh.service.payment.mapper.ExamineCallbackRecordMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;

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


@Service("examineCallbackRecordDao")
public class ExamineCallbackRecordDaoImpl extends BaseDaoImpl<ExamineCallbackRecord, ExamineCallbackRecordCondition, ExamineCallbackRecordMapper> implements ExamineCallbackRecordDao {
	@Autowired
	ExamineCallbackRecordMapper examineCallbackRecordMapper;
	@Override
	public List<ExamineCallbackRecord> getListByStatus(byte status) {
		return examineCallbackRecordMapper.getListByStatus(status);
	}
	@Override
	public int updateStatusById(byte status, int id) {
		return examineCallbackRecordMapper.updateStatusById(status,id);
	}
	@Override
	public ExamineCallbackRecord getinfoByoperationTypeAndSn(String operationType, String sn) {
		return examineCallbackRecordMapper.getinfoByoperationTypeAndSn(operationType,sn);
	}
	@Override
	public int updateStatusByoperationTypeAndSn(byte status,
			String operationType, String sn) {
		return examineCallbackRecordMapper.updateStatusByoperationTypeAndSn(status,operationType,sn);
	}
}