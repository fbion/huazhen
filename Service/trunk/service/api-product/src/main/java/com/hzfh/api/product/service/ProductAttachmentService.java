package com.hzfh.api.product.service;

import com.hzfh.api.product.model.ProductAttachment;
import com.hzfh.api.product.model.query.ProductAttachmentCondition;
import com.hzframework.data.service.BaseService;

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


public interface ProductAttachmentService extends BaseService<ProductAttachment, ProductAttachmentCondition> {
	//根据产品编号查询所有相关附件（前提是状态为有效的）
	public List<ProductAttachment> getListByProductNo(int productNo);
	//修改附件的状态(根据id 修改 status)
	public int updateStatus(int id,byte status);
	
}