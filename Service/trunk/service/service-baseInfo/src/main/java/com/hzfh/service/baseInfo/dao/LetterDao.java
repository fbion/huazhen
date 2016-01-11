package com.hzfh.service.baseInfo.dao;

import com.hzfh.api.baseInfo.model.Letter;
import com.hzfh.api.baseInfo.model.query.LetterCondition;
import com.hzframework.data.dao.BaseDao;

import java.util.List;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/4/7 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public interface LetterDao extends BaseDao<Letter, LetterCondition> {
    public List<Letter> getListLimitByEmpId(int empId);

    public int updateSolve(Letter info);
    public int updateClose(Letter info);
    public List<Letter> getListByTime();

}