package com.hzfh.service.product.dao;

import com.hzfh.api.product.model.ProductAttachment;
import com.hzfh.api.product.model.query.ProductAttachmentCondition;
import com.hzframework.data.dao.BaseDao;

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


public interface ProductAttachmentDao extends BaseDao<ProductAttachment, ProductAttachmentCondition> {

	List<ProductAttachment> getListByProductNo(int productNo);

	int updateStatus(int id, byte status);
}