package com.hzfh.service.customer.mapper;

import com.hzfh.api.customer.model.PaymentCustomerBank;
import com.hzfh.api.customer.model.query.PaymentCustomerBankCondition;
import com.hzframework.data.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/*******************************************************************************
 *
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/6/10 
 * Description:
 *
 * Revision History:
 *      Date         Author               Description
 *
 ******************************************************************************/


@Service("paymentCustomerBankMapper")
public interface PaymentCustomerBankMapper extends BaseMapper<PaymentCustomerBank, PaymentCustomerBankCondition> {

	List<PaymentCustomerBank> getListByCustomerNo(@Param("customerNo")int customerNo);

	List<PaymentCustomerBank> getBankByCustomerNoAndStatus(@Param("customerNo")int customerNo,
			@Param("status")int status);

    int unBindCardBank(@Param("customerNo")int customerNo);
	
}