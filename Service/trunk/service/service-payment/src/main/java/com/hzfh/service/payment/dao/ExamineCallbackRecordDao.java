package com.hzfh.service.payment.dao;

import java.util.List;

import com.hzfh.api.payment.model.ExamineCallbackRecord;
import com.hzfh.api.payment.model.query.ExamineCallbackRecordCondition;
import com.hzframework.data.dao.BaseDao;

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


public interface ExamineCallbackRecordDao extends BaseDao<ExamineCallbackRecord, ExamineCallbackRecordCondition> {
	List<ExamineCallbackRecord> getListByStatus(byte status);

	int updateStatusById(byte status, int id);

	ExamineCallbackRecord getinfoByoperationTypeAndSn(String operationType, String sn);

	int updateStatusByoperationTypeAndSn(byte status, String operationType,
			String sn);
}