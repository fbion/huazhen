package com.hzfh.service.sales.daoImpl;

import com.hzfh.api.sales.model.P2pSubscribe;
import com.hzfh.api.sales.model.query.P2pSubscribeCondition;
import com.hzfh.service.sales.dao.P2pSubscribeDao;
import com.hzfh.service.sales.mapper.P2pSubscribeMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/3/5 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("p2pSubscribeDao")
public class P2pSubscribeDaoImpl extends BaseDaoImpl<P2pSubscribe, P2pSubscribeCondition, P2pSubscribeMapper> implements P2pSubscribeDao {

	@Autowired
	private P2pSubscribeMapper p2pSubscribeMapper;
	@Override
	public int updateEmpNoById(int id,int deptNo, int empNo) {
		return p2pSubscribeMapper.updateEmpNoById(id,deptNo,empNo);
	}

	@Override
	public int updateVisitTimeAndVisitTimeAndStatus(int id, Date visitTime,
			String result, byte status) {
		return p2pSubscribeMapper.updateVisitTimeAndVisitTimeAndStatus(id,visitTime,result,status);
	}

    @Override
    public int updateP2pSubScribeStatus(int id,int status){
        return p2pSubscribeMapper.updateP2pSubScribeStatus(id,status);
    }
    @Override
    public int updateP2pSubscribeById(int id,int customerNo){
        return p2pSubscribeMapper.updateP2pSubscribeById(id,customerNo);
    }

    @Override
    public int updateP2pSubscribeByP2pCustomerNo(int p2pCustomerNo, int customerNo) {
        return p2pSubscribeMapper.updateP2pSubscribeByP2pCustomerNo(p2pCustomerNo,customerNo);
    }

    @Override
    public int updateEmpNoByP2pCustomerNo(int p2pCustomerNo, int deptNo, int userNo) {
        return p2pSubscribeMapper.updateEmpNoByP2pCustomerNo(p2pCustomerNo,deptNo,userNo);
    }

	@Override
	public List<P2pSubscribe> getListByP2pCustomerNo(int customerNo) {
		return p2pSubscribeMapper.getListByP2pCustomerNo(customerNo);
	}
}