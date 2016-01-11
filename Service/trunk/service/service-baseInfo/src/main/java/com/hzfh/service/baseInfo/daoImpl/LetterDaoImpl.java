package com.hzfh.service.baseInfo.daoImpl;

import com.hzfh.api.baseInfo.model.Letter;
import com.hzfh.api.baseInfo.model.query.LetterCondition;
import com.hzfh.service.baseInfo.dao.LetterDao;
import com.hzfh.service.baseInfo.mapper.LetterMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
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


@Service("letterDao")
public class LetterDaoImpl extends BaseDaoImpl<Letter, LetterCondition, LetterMapper> implements LetterDao {
    @Autowired
    private LetterMapper letterMapper;
    @Override
    public List<Letter> getListLimitByEmpId(int empId){
        return letterMapper.getListLimitByEmpId(empId);
    }

    @Override
    public int updateSolve(Letter info){ return letterMapper.updateSolve(info);}
    @Override
    public int updateClose(Letter info){ return letterMapper.updateClose(info);}
    public List<Letter> getListByTime(){
       return letterMapper.getListByTime();
    }

}