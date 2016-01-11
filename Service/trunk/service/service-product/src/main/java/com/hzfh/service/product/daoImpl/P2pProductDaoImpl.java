package com.hzfh.service.product.daoImpl;

import com.hzfh.api.product.model.P2pProduct;
import com.hzfh.api.product.model.Product;
import com.hzfh.api.product.model.query.P2pProductCondition;
import com.hzfh.service.product.dao.P2pProductDao;
import com.hzfh.service.product.mapper.P2pProductMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;

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


@Service("p2pProductDao")
public class P2pProductDaoImpl extends BaseDaoImpl<P2pProduct, P2pProductCondition, P2pProductMapper> implements P2pProductDao {

	@Autowired
	private P2pProductMapper p2pProductMapper;
	@Override
	public List<P2pProduct> selectByStatus(byte status) {
		return p2pProductMapper.selectByStatus(status) ;
	}

    @Override
    public P2pProduct getP2pByProductNo(int productNo) {
        return p2pProductMapper.getP2pByProductNo(productNo);
    }

    @Override
    public int addP2pVideo(P2pProduct p2pVideo) {
        return p2pProductMapper.addP2pVideo(p2pVideo);
    }

    @Override
    public List<P2pProduct> getP2pProductByStatus(byte status) {
        return p2pProductMapper.getP2pProductByStatus(status);
    }

    @Override
    public int updateRemainAmountByProductNo(int productNo, long money) {
        return p2pProductMapper.updateRemainAmountByProductNo(productNo, money);
    }
    @Override
    public int updateOrderCountByProductNo(int productNo,int count) {
        return p2pProductMapper.updateOrderCountByProductNo(productNo,count);
    }

	@Override
	public int updateLogpPathById(int id, String logoPath) {
        return p2pProductMapper.updateLogpPathById(id,logoPath);
	}

    @Override
    public int updateStatusById(int id, byte status) {
        return p2pProductMapper.updateStatusById(id, status);
    }
}