package com.hzfh.service.sales.dao;

import com.hzfh.api.sales.model.Creditor;
import com.hzfh.api.sales.model.query.CreditorCondition;
import com.hzframework.data.dao.BaseDao;

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


public interface CreditorDao extends BaseDao<Creditor, CreditorCondition> {
    int updateRemainAmountById(int id, double money);

    Creditor getInfoEffectiveByProductNo(int productNo);

    List<Creditor> getListByPrductNo(int productNo);

    double getRemainAmountByProductNo(int productNo);
}