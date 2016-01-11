package com.hzfh.api.sales.service;

import com.hzfh.api.sales.model.P2pSubscribe;
import com.hzfh.api.sales.model.query.P2pSubscribeCondition;
import com.hzframework.data.service.BaseService;

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


public interface P2pSubscribeService extends BaseService<P2pSubscribe, P2pSubscribeCondition> {
	public int updateEmpNoById(int id,int deptNo,int empNo);
	public int updateVisitTimeAndVisitTimeAndStatus(int id,Date visitTime,String result,byte status);
    public int updateP2pSubScribeStatus(int id,int status);
    public int updateP2pSubscribeById(int id,int customerNo);
    public int updateP2pSubscribeByP2pCustomerNo(int p2pCustomerNo, int customerNo);
    int updateEmpNoByP2pCustomerNo(int p2pCustomerNo, int deptNo, int userNo);
	public List<P2pSubscribe> getListByP2pCustomerNo(int customerNo);
}