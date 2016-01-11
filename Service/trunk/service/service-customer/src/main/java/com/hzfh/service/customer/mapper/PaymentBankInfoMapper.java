package com.hzfh.service.customer.mapper;

import java.util.List;

import com.hzfh.api.customer.model.PaymentBankInfo;
import com.hzfh.api.customer.model.query.PaymentBankInfoCondition;
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


@Service("paymentBankInfoMapper")
public interface PaymentBankInfoMapper extends BaseMapper<PaymentBankInfo, PaymentBankInfoCondition> {

	PaymentBankInfo getBankByBankCode(@Param("code")String code);

	List<PaymentBankInfo> getListByStatus(@Param("enable")int enable);
}