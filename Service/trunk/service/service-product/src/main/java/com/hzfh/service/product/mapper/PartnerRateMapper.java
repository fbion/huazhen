package com.hzfh.service.product.mapper;

import com.hzfh.api.product.model.PartnerRate;
import com.hzfh.api.product.model.query.PartnerRateCondition;
import com.hzframework.data.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/1/16 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("partnerRateMapper")
public interface PartnerRateMapper extends BaseMapper<PartnerRate, PartnerRateCondition> {

	PartnerRate getPartnerRate(@Param("productNo")int productNo,@Param("money") Long money);

	List<PartnerRate> getListByProductNo(int productNo);
}