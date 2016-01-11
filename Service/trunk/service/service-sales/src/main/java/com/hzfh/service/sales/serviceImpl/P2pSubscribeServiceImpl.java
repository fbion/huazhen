package com.hzfh.service.sales.serviceImpl;

import com.hzfh.api.sales.model.P2pSubscribe;
import com.hzfh.api.sales.model.query.P2pSubscribeCondition;
import com.hzfh.api.sales.service.P2pSubscribeService;
import com.hzfh.service.sales.dao.P2pSubscribeDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;

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


@Service("p2pSubscribeService")
public class P2pSubscribeServiceImpl extends BaseServiceImpl<P2pSubscribe, P2pSubscribeCondition, P2pSubscribeDao> implements P2pSubscribeService {
	@Autowired
    private P2pSubscribeDao p2pSubscribeDao;
	@Override
	public int updateEmpNoById(int id,int deptNo, int empNo) {
		return p2pSubscribeDao.updateEmpNoById(id,deptNo, empNo);
	}
	@Override
	public int updateVisitTimeAndVisitTimeAndStatus(int id, Date visitTime,String result, byte status) {
		return p2pSubscribeDao.updateVisitTimeAndVisitTimeAndStatus(id,visitTime,result,status);
	}
    @Override
    public int updateP2pSubScribeStatus(int id,int status){
        return p2pSubscribeDao.updateP2pSubScribeStatus(id,status);
    }

    public int updateP2pSubscribeById(int id,int custoemrNo){
        return p2pSubscribeDao.updateP2pSubscribeById(id,custoemrNo);

    }

    @Override
    public int updateP2pSubscribeByP2pCustomerNo(int p2pCustomerNo, int customerNo) {
        return  p2pSubscribeDao.updateP2pSubscribeByP2pCustomerNo(p2pCustomerNo,customerNo);
    }

    @Override
    public int updateEmpNoByP2pCustomerNo(int p2pCustomerNo, int deptNo, int userNo) {
        return p2pSubscribeDao.updateEmpNoByP2pCustomerNo(p2pCustomerNo,deptNo,userNo);
    }
	@Override
	public List<P2pSubscribe> getListByP2pCustomerNo(int customerNo) {
		return p2pSubscribeDao.getListByP2pCustomerNo(customerNo);
	}
	

}