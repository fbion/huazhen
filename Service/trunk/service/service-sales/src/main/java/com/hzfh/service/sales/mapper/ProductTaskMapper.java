package com.hzfh.service.sales.mapper;

import com.hzfh.api.sales.model.ProductTask;
import com.hzfh.api.sales.model.query.ProductTaskCondition;
import com.hzframework.data.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/1/22 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("productTaskMapper")
public interface ProductTaskMapper extends BaseMapper<ProductTask, ProductTaskCondition> {

	List<ProductTask> getListByProductNo(int product);

    int updateStatus(ProductTask productTask);

	int updateAmount(ProductTask productTask);

	int updateReAmount(ProductTask productTask);

    int updateAddCurrentAmount(@Param("productNo") int productNo, @Param("currentAmount") Long currentAmount,@Param("deptNo")int deptNo);

    int updateReduceCurrentAmount(@Param("productNo") int productNo, @Param("currentAmount") Long currentAmount,@Param("deptNo") int deptNo);
}