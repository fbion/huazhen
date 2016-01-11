package com.hzfh.service.product.serviceImpl;

import com.hzfh.api.product.model.P2pProduct;
import com.hzfh.api.product.model.Product;
import com.hzfh.api.product.model.query.P2pProductCondition;
import com.hzfh.api.product.service.P2pProductService;
import com.hzfh.service.product.dao.P2pProductDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/3/5 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("p2pProductService")
public class P2pProductServiceImpl extends BaseServiceImpl<P2pProduct, P2pProductCondition, P2pProductDao> implements P2pProductService {
	@Autowired
	private P2pProductDao p2pProductDao;
	
	@Override
	public List<P2pProduct> selectByStatus(byte status) {
		return p2pProductDao.selectByStatus(status);
	}

    @Override
    public P2pProduct getP2pByProductNo(int productNo) {
        return p2pProductDao.getP2pByProductNo(productNo);
    }

    @Override
    public int addP2pVideo(P2pProduct p2pVideo) {
        return p2pProductDao.addP2pVideo(p2pVideo);
    }

    @Override
    public List<P2pProduct> getP2pProductByStatus(byte status) {
        return p2pProductDao.getP2pProductByStatus(status);
    }

    @Override
    public int updateRemainAmountByProductNo(int productNo, long money) {
        return p2pProductDao.updateRemainAmountByProductNo(productNo, money);
    }
    @Override
    public int updateOrderCountByProductNo(int productNo,int count) {
        return p2pProductDao.updateOrderCountByProductNo(productNo,count);
    }

	@Override
	public int updateLogpPathById(int id, String logoPath) {
        return p2pProductDao.updateLogpPathById(id,logoPath);
	}

    @Override
    public int updateStatusById(int id, byte status) {
        return p2pProductDao.updateStatusById(id, status);
    }
}