package com.hzfh.service.product.daoImpl;

import com.hzfh.api.product.model.ProductAttachment;
import com.hzfh.api.product.model.query.ProductAttachmentCondition;
import com.hzfh.service.product.dao.ProductAttachmentDao;
import com.hzfh.service.product.mapper.ProductAttachmentMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
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


@Service("productAttachmentDao")
public class ProductAttachmentDaoImpl extends BaseDaoImpl<ProductAttachment, ProductAttachmentCondition, ProductAttachmentMapper> implements ProductAttachmentDao {
	
	@Autowired
	private ProductAttachmentMapper productAttachmentMapper;
	
	@Override
	public List<ProductAttachment> getListByProductNo(int productNo) {
		return productAttachmentMapper.getListByProductNo(productNo);
	}
	@Override
	public int updateStatus(int id, byte status) {
		return productAttachmentMapper.updateStatus(id,status);
	}
}