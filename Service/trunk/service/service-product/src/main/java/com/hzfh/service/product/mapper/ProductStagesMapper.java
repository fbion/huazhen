package com.hzfh.service.product.mapper;

import com.hzfh.api.product.model.ProductStages;
import com.hzfh.api.product.model.query.ProductStagesCondition;
import com.hzframework.data.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/1/20 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("productStagesMapper")
public interface ProductStagesMapper extends BaseMapper<ProductStages, ProductStagesCondition> {

	Integer getProductMaxStage(int product_no);

	int getProductStageId(@Param("product_no")int product_no,@Param("stagesNumber") int stagesNumber);
}