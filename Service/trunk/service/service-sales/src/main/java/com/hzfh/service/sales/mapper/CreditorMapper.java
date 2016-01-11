package com.hzfh.service.sales.mapper;

import com.hzfh.api.sales.model.Creditor;
import com.hzfh.api.sales.model.query.CreditorCondition;
import com.hzframework.data.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/*******************************************************************************
 * Copyright 2015 HZFH. All rights reserved.
 * Author: GuoZhenYu
 * Create Date: 2015/8/25
 * Description:
 * <p/>
 * Revision History:
 * Date         Author               Description
 ******************************************************************************/


@Service("creditorMapper")
public interface CreditorMapper extends BaseMapper<Creditor, CreditorCondition> {
    public int updateRemainAmountById(@Param("id") int id, @Param("money") double money);

    public Creditor getInfoEffectiveByProductNo(@Param("productNo") int productNo);

    public List<Creditor> getListByPrductNo(@Param("productNo") int productNo);

    double getRemainAmountByProductNo(int productNo);
}