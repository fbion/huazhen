package com.hzfh.service.sales.serviceImpl;

import com.hzfh.api.sales.model.Creditor;
import com.hzfh.api.sales.model.query.CreditorCondition;
import com.hzfh.api.sales.service.CreditorService;
import com.hzfh.service.sales.dao.CreditorDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*******************************************************************************
 * Copyright 2015 HZFH. All rights reserved.
 * Author: GuoZhenYu
 * Create Date: 2015/8/25
 * Description:
 * <p/>
 * Revision History:
 * Date         Author               Description
 ******************************************************************************/


@Service("creditorService")
public class CreditorServiceImpl extends BaseServiceImpl<Creditor, CreditorCondition, CreditorDao> implements CreditorService {
    @Autowired
    CreditorDao creditorDao;

    @Override
    public int updateRemainAmountById(int id, double money) {
        return creditorDao.updateRemainAmountById(id, money);
    }

    @Override
    public Creditor getInfoEffectiveByProductNo(int productNo) {
        return creditorDao.getInfoEffectiveByProductNo(productNo);
    }

    @Override
    public List<Creditor> getListByPrductNo(int productNo) {
        return creditorDao.getListByPrductNo(productNo);
    }

    @Override
    public double getRemainAmountByProductNo(int productNo) {
        return creditorDao.getRemainAmountByProductNo(productNo);
    }
}