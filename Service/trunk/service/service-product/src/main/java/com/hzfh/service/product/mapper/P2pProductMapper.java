package com.hzfh.service.product.mapper;

import com.hzfh.api.product.model.P2pProduct;
import com.hzfh.api.product.model.Product;
import com.hzfh.api.product.model.query.P2pProductCondition;
import com.hzframework.data.mapper.BaseMapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

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


@Service("p2pProductMapper")
public interface P2pProductMapper extends BaseMapper<P2pProduct, P2pProductCondition> {

    List<P2pProduct> selectByStatus(@Param("status") byte status);

    P2pProduct getP2pByProductNo(int productNo);

    int addP2pVideo(P2pProduct p2pVideo);

    List<P2pProduct> getP2pProductByStatus(@Param("status") byte status);

    int updateRemainAmountByProductNo(@Param("productNo") int productNo, @Param("money") long money);

    int updateOrderCountByProductNo(@Param("productNo") int productNo,@Param("count")int count);
    
    int updateLogpPathById(@Param("id")int id, @Param("logoPath")String logoPath);

    int updateStatusById(@Param("id")int id,@Param("status")byte status);
}