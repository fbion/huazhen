package com.hzfh.service.sales.mapper;

import com.hzfh.api.sales.model.P2pSubscribe;
import com.hzfh.api.sales.model.query.P2pSubscribeCondition;
import com.hzframework.data.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
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


@Service("p2pSubscribeMapper")
public interface P2pSubscribeMapper extends BaseMapper<P2pSubscribe, P2pSubscribeCondition> {

	int updateEmpNoById(@Param("id")int id,@Param("deptNo")int deptNo, @Param("empNo")int empNo);

	int updateVisitTimeAndVisitTimeAndStatus(@Param("id")int id, @Param("visitTime")Date visitTime,
			@Param("result")String result,@Param("status") byte status);

	List<P2pSubscribe> getPagedListByCustomerIdAndStatus(int customerNo,int status);

    int updateP2pSubScribeStatus(@Param("id")int id,@Param("status")int status);

    int updateP2pSubscribeById(@Param("id")int id,@Param("customerNo")int customerNo);

    int updateP2pSubscribeByP2pCustomerNo(@Param("p2pCustomerNo")int p2pCustomerNo, @Param("customerNo")int customerNo);

    int updateEmpNoByP2pCustomerNo(@Param("p2pCustomerNo")int p2pCustomerNo,@Param("deptNo")int deptNo,@Param("userNo") int userNo);

	List<P2pSubscribe> getListByP2pCustomerNo(@Param("customerNo")int customerNo);
}