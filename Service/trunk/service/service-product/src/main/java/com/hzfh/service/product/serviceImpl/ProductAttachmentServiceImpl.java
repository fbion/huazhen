package com.hzfh.service.product.serviceImpl;

import com.hzfh.api.product.model.ProductAttachment;
import com.hzfh.api.product.model.query.ProductAttachmentCondition;
import com.hzfh.api.product.service.ProductAttachmentService;
import com.hzfh.service.product.dao.ProductAttachmentDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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


@Service("productAttachmentService")
public class ProductAttachmentServiceImpl extends BaseServiceImpl<ProductAttachment, ProductAttachmentCondition, ProductAttachmentDao> implements ProductAttachmentService {
	@Autowired
	private ProductAttachmentDao productAttachmentDao;
	
	@Override
	public List<ProductAttachment> getListByProductNo(int productNo) {
		return productAttachmentDao.getListByProductNo(productNo);
	}

	@Override
	public int updateStatus(int id, byte status) {
		return productAttachmentDao.updateStatus(id,status);
	}
}