package com.hzfh.api.sales.service;

import com.hzfh.api.sales.model.Creditor;
import com.hzfh.api.sales.model.query.CreditorCondition;
import com.hzframework.data.service.BaseService;

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


public interface CreditorService extends BaseService<Creditor, CreditorCondition> {
    int updateRemainAmountById(int id,double money);

    Creditor getInfoEffectiveByProductNo(int productNo);

    List<Creditor> getListByPrductNo(int productNo);

    double getRemainAmountByProductNo(int productNo);

}