package com.hzfh.service.customer.mapper;

import com.hzfh.api.customer.model.PaymentMoneyRecharge;
import com.hzfh.api.customer.model.query.PaymentMoneyRechargeCondition;
import com.hzframework.data.mapper.BaseMapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

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


@Service("paymentMoneyRechargeMapper")
public interface PaymentMoneyRechargeMapper extends BaseMapper<PaymentMoneyRecharge, PaymentMoneyRechargeCondition> {

	List<PaymentMoneyRecharge> getListByCustomerNo(@Param("customerNo")int customerNo);

	int updateRechargeType(@Param("typeNo")int typeNo, @Param("customerNo")int customerNo,@Param("snNo")String snNo);

	int updatePayType(@Param("typeNo")int typeNo, @Param("customerNo")int customerNo,@Param("snNo")String snNo);

	int updateMoneyAmount(@Param("money")double money, @Param("customerNo")int customerNo,@Param("snNo")String snNo);

	int updateState(@Param("stateNo")String stateNo, @Param("customerNo")int customerNo,@Param("snNo")String snNo);

	PaymentMoneyRecharge getbySn(@Param("sn")String sn);

	int updateRecharge(PaymentMoneyRecharge paymentMoneyRecharge);

	Double getRechargeMoneyByCustomerNoAndStatusAndToday(@Param("customerNo")int customerNo,
			@Param("status")String status);
	PaymentMoneyRecharge getInfoByStateAndSn(@Param("status")String status,@Param("sn")String sn);

	int updateStateBySn(@Param("sn")String sn,@Param("state") String state);
}