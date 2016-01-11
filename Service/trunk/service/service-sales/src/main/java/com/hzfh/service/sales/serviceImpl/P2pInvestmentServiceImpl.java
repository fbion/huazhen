package com.hzfh.service.sales.serviceImpl;

import java.util.List;

import com.hzfh.api.sales.model.P2pInvestment;
import com.hzfh.api.sales.model.query.P2pInvestmentCondition;
import com.hzfh.api.sales.service.P2pInvestmentService;
import com.hzfh.service.sales.dao.P2pInvestmentDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


@Service("p2pInvestmentService")
public class P2pInvestmentServiceImpl extends BaseServiceImpl<P2pInvestment, P2pInvestmentCondition, P2pInvestmentDao> implements P2pInvestmentService {

	@Autowired
	private P2pInvestmentDao p2pInvestmentDao;
	@Override
	public P2pInvestment getP2pInvestmentBySalesId(int salesNo) {
		return p2pInvestmentDao.getP2pInvestmentBySalesId(salesNo);
	}
    @Override
    public int updateStatusBySalesNo(int salesNo,int status){
        return p2pInvestmentDao.updateStatusBySalesNo(salesNo,status);
    }

    @Override
    public int updateStatusByProductNoAndStatus(int productNo, byte status) {
        return p2pInvestmentDao.updateStatusByProductNoAndStatus(productNo,status);
    }
	@Override
	public List<P2pInvestment> getListByP2pCustomerNo(int customerNo) {
		return p2pInvestmentDao.getListByP2pCustomerNo(customerNo);
	}
}