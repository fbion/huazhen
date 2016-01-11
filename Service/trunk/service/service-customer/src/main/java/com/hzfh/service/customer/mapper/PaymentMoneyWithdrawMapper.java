package com.hzfh.service.customer.mapper;

import com.hzfh.api.customer.model.PaymentMoneyWithdraw;
import com.hzfh.api.customer.model.query.PaymentMoneyWithdrawCondition;
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


@Service("paymentMoneyWithdrawMapper")
public interface PaymentMoneyWithdrawMapper extends BaseMapper<PaymentMoneyWithdraw, PaymentMoneyWithdrawCondition> {

	int updateMoneyAmount(@Param("amount")double money, @Param("sn")String sn);

	int updateState(@Param("stateNo")String stateNo,@Param("sn") String sn);

	PaymentMoneyWithdraw getbySn(@Param("sn")String sn);

	int updateWithdraw(PaymentMoneyWithdraw paymentMoneyWithdraw);

	PaymentMoneyWithdraw getInfoBystateAndSn(@Param("status")String status, @Param("sn")String sn);
}