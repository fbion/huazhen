package com.hzfh.service.product.dao;

import com.hzfh.api.product.model.P2pProduct;
import com.hzfh.api.product.model.Product;
import com.hzfh.api.product.model.query.P2pProductCondition;
import com.hzframework.data.dao.BaseDao;

import java.util.List;

/*******************************************************************************
 * Copyright 2015 HZFH. All rights reserved.
 * Author: GuoZhenYu
 * Create Date: 2015/3/5
 * Description:
 * <p/>
 * Revision History:
 * Date         Author               Description
 ******************************************************************************/


public interface P2pProductDao extends BaseDao<P2pProduct, P2pProductCondition> {

    List<P2pProduct> selectByStatus(byte status);

    P2pProduct getP2pByProductNo(int productNo);

    int addP2pVideo(P2pProduct p2pVideo);

    List<P2pProduct> getP2pProductByStatus(byte status);

    int updateRemainAmountByProductNo(int productNo, long money);

    int updateOrderCountByProductNo(int productNo, int count);
    
    int updateLogpPathById(int id, String logoPath);

    int updateStatusById(int id,byte status);
}