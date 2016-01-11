package com.hzfh.service.sales.daoImpl;

import java.util.List;

import com.hzfh.api.sales.model.P2pInvestment;
import com.hzfh.api.sales.model.query.P2pInvestmentCondition;
import com.hzfh.service.sales.dao.P2pInvestmentDao;
import com.hzfh.service.sales.mapper.P2pInvestmentMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;

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


@Service("p2pInvestmentDao")
public class P2pInvestmentDaoImpl extends BaseDaoImpl<P2pInvestment, P2pInvestmentCondition, P2pInvestmentMapper> implements P2pInvestmentDao {
	@Autowired
	private P2pInvestmentMapper p2pInvestmentMapper;
	@Override
	public P2pInvestment getP2pInvestmentBySalesId(int salesNo) {
		return p2pInvestmentMapper.getP2pInvestmentBySalesId(salesNo);
	}
    @Override
    public int updateStatusBySalesNo(int salesNo,int status){
        return p2pInvestmentMapper.updateStatusBySalesNo(salesNo,status);
    }

    @Override
    public int updateStatusByProductNoAndStatus(int productNo, byte status) {
        return p2pInvestmentMapper.updateStatusByProductNoAndStatus(productNo,status);
    }
	@Override
	public List<P2pInvestment> getListByP2pCustomerNo(int customerNo) {
		return p2pInvestmentMapper.getListByP2pCustomerNo(customerNo);
	}
}