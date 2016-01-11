package com.hzfh.api.sales.service;

import com.hzfh.api.sales.model.P2pInvestment;
import com.hzfh.api.sales.model.query.P2pInvestmentCondition;
import com.hzframework.data.service.BaseService;

import java.util.List;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/3/13 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public interface P2pInvestmentService extends BaseService<P2pInvestment, P2pInvestmentCondition> {

	P2pInvestment getP2pInvestmentBySalesId(int salesNo);

    int updateStatusBySalesNo(int salesNo,int status);

    int updateStatusByProductNoAndStatus(int productNo, byte status);

    List<P2pInvestment> getListByP2pCustomerNo(int customerNo);
}