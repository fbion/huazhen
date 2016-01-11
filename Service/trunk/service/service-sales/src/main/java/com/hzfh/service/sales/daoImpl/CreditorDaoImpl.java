package com.hzfh.service.sales.daoImpl;

import com.hzfh.api.sales.model.Creditor;
import com.hzfh.api.sales.model.query.CreditorCondition;
import com.hzfh.service.sales.dao.CreditorDao;
import com.hzfh.service.sales.mapper.CreditorMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*******************************************************************************
 *
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/8/25 
 * Description:
 *
 * Revision History:
 *      Date         Author               Description
 *
 ******************************************************************************/


@Service("creditorDao")
public class CreditorDaoImpl extends BaseDaoImpl<Creditor, CreditorCondition, CreditorMapper> implements CreditorDao {
    @Autowired
    CreditorMapper creditorMapper;
    @Override
    public int updateRemainAmountById(int id,double money){
        return creditorMapper.updateRemainAmountById(id,money);
    }
    @Override
    public Creditor getInfoEffectiveByProductNo(int productNo){
        return creditorMapper.getInfoEffectiveByProductNo(productNo);
    }
    @Override
    public List<Creditor> getListByPrductNo(int productNo){
        return creditorMapper.getListByPrductNo(productNo);
    }

    @Override
    public double getRemainAmountByProductNo(int productNo) {
        return creditorMapper.getRemainAmountByProductNo(productNo);
    }
}