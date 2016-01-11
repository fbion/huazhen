package com.hzfh.service.baseInfo.mapper;

import com.hzfh.api.baseInfo.model.Letter;
import com.hzfh.api.baseInfo.model.query.LetterCondition;
import com.hzframework.data.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

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


@Service("letterMapper")
public interface LetterMapper extends BaseMapper<Letter, LetterCondition> {
    public List<Letter> getListLimitByEmpId(@Param("empId")int empId);


    public int updateSolve(Letter info);

    public int updateClose(Letter info);
    public List<Letter> getListByTime();
}