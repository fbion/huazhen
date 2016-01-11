package com.hzfh.service.customer.mapper;

import com.hzfh.api.customer.model.PaymentMoneyFreeze;
import com.hzfh.api.customer.model.query.PaymentMoneyFreezeCondition;
import com.hzframework.data.mapper.BaseMapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/6/8 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("paymentMoneyFreezeMapper")
public interface PaymentMoneyFreezeMapper extends BaseMapper<PaymentMoneyFreeze, PaymentMoneyFreezeCondition> {

	PaymentMoneyFreeze getInfoBySnAndType(@Param("refSn")String refSn,@Param("type")byte type);
}