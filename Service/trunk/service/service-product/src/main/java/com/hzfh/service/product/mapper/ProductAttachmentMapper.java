package com.hzfh.service.product.mapper;

import com.hzfh.api.product.model.ProductAttachment;
import com.hzfh.api.product.model.query.ProductAttachmentCondition;
import com.hzframework.data.mapper.BaseMapper;
import org.springframework.stereotype.Service;

import java.util.List;

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


@Service("productAttachmentMapper")
public interface ProductAttachmentMapper extends BaseMapper<ProductAttachment, ProductAttachmentCondition> {

	List<ProductAttachment> getListByProductNo(int productNo);

	int updateStatus(int id, byte status);
}