package com.hzfh.service.sales.mapper;

import java.util.List;

import com.hzfh.api.sales.model.P2pInvestment;
import com.hzfh.api.sales.model.query.P2pInvestmentCondition;
import com.hzframework.data.mapper.BaseMapper;

import org.apache.ibatis.annotations.Param;
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


@Service("p2pInvestmentMapper")
public interface P2pInvestmentMapper extends BaseMapper<P2pInvestment, P2pInvestmentCondition> {

	P2pInvestment getP2pInvestmentBySalesId(int salesNo);
    int updateStatusBySalesNo(@Param("salesNo")int salesNo,@Param("status")int status);

    int updateStatusByProductNoAndStatus(@Param("productNo")int productNo, @Param("status")byte status);
	List<P2pInvestment> getListByP2pCustomerNo(@Param("customerNo")int customerNo);
}