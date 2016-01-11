package com.hzfh.service.customer.mapper;

import java.util.List;

import com.hzfh.api.customer.model.PaymentAccountInformation;
import com.hzfh.api.customer.model.query.PaymentAccountInformationCondition;
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


@Service("paymentAccountInformationMapper")
public interface PaymentAccountInformationMapper extends BaseMapper<PaymentAccountInformation, PaymentAccountInformationCondition> {

	int updateAuthenticationTelByCustomerNo(@Param("authenticationTel")int authenticationTel, @Param("customerId")int customerId);

	PaymentAccountInformation getInfoByCustomerNo(@Param("customerId")int customerId);

	int updateMoneyAmount(@Param("money")double money,  @Param("customerNo")int customerNo);

	int updateMoneyWithDarw(@Param("money")double money, @Param("customerNo")int customerNo);

	int updateMoneyFreeze(@Param("money")double money, @Param("customerNo")int customerNo);

	int updateIntegralAmount(@Param("money")double money,@Param("customerNo")int customerNo);
	
	int updateProperty(@Param("property")int property, @Param("customerNo")int customerNo);

	int updateIntegralWithDraw(@Param("money")double money, @Param("customerNo")int customerNo);

	int updateState(@Param("state")int state,@Param("customerNo") int customerNo);

	int updateAuthenticationName(@Param("authenticationNo")int authenticationNo, @Param("customerNo")int customerNo);

	int updateAuthenticationEmail(@Param("authenticationNo")int authenticationNo,@Param("customerNo")int customerNo);

	int updateAuthenticationBankCard(@Param("authenticationNo")int authenticationNo,@Param("customerNo")int customerNo);

	int updateAuthenticationIdcard(@Param("authenticationNo")int authenticationNo,@Param("customerNo")int customerNo);

	List<PaymentAccountInformation> getListByAuthenticationName(@Param("status")int status);

}