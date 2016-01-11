package com.hzfh.service.baseInfo.serviceImpl;

import com.hzfh.api.baseInfo.model.Letter;
import com.hzfh.api.baseInfo.model.query.LetterCondition;
import com.hzfh.api.baseInfo.service.LetterService;
import com.hzfh.service.baseInfo.dao.LetterDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
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


@Service("letterService")
public class LetterServiceImpl extends BaseServiceImpl<Letter, LetterCondition, LetterDao> implements LetterService {
    @Autowired
    private LetterDao letterDao;
    @Override
    public List<Letter> getListLimitByEmpId(int empId){

        return letterDao.getListLimitByEmpId(empId);
    }

    @Override
    public int updateSolve(Letter info){return letterDao.updateSolve(info);}
    @Override
    public int updateClose(Letter info){return letterDao.updateClose(info);}

    @Override
    public List<Letter> getListByTime(){
        return letterDao.getListByTime();
    }


}