package com.hzfh.service.customer.mapper;

import com.hzfh.api.customer.model.TradeReqnoInfo;
import com.hzfh.api.customer.model.query.TradeReqnoInfoCondition;
import com.hzframework.data.mapper.BaseMapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/*******************************************************************************
 *
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/6/18 
 * Description:
 *
 * Revision History:
 *      Date         Author               Description
 *
 ******************************************************************************/


@Service("tradeReqnoInfoMapper")
public interface TradeReqnoInfoMapper extends BaseMapper<TradeReqnoInfo, TradeReqnoInfoCondition> {

	TradeReqnoInfo getInfoBySnAndIsOk(@Param("sn")String requestNo,@Param("isOk")int isOk);
}