package com.hzfh.service.sales.dao;

import com.hzfh.api.sales.model.P2pSubscribe;
import com.hzfh.api.sales.model.query.P2pSubscribeCondition;
import com.hzframework.data.dao.BaseDao;

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


public interface P2pSubscribeDao extends BaseDao<P2pSubscribe, P2pSubscribeCondition> {

	int updateEmpNoById(int id,int deptNo, int empNo);
	int updateVisitTimeAndVisitTimeAndStatus(int id, Date visitTime,String result, byte status);
    int updateP2pSubScribeStatus(int id,int status);
    int updateP2pSubscribeById(int id,int customerNo);
    int updateP2pSubscribeByP2pCustomerNo(int p2pCustomerNo, int customerNo);
    int updateEmpNoByP2pCustomerNo(int p2pCustomerNo, int deptNo, int userNo);
	List<P2pSubscribe> getListByP2pCustomerNo(int customerNo);
}