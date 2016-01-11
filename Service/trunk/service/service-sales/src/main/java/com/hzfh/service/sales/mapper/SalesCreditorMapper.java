package com.hzfh.service.sales.mapper;

import com.hzfh.api.sales.model.SalesCreditor;
import com.hzfh.api.sales.model.query.SalesCreditorCondition;
import com.hzframework.data.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/*******************************************************************************
 * Copyright 2015 HZFH. All rights reserved.
 * Author: GuoZhenYu
 * Create Date: 2015/8/24
 * Description:
 * <p/>
 * Revision History:
 * Date         Author               Description
 ******************************************************************************/


@Service("salesCreditorMapper")
public interface SalesCreditorMapper extends BaseMapper<SalesCreditor, SalesCreditorCondition> {
    public List<SalesCreditor> getListBySalesNo(@Param("salesNo") int salesNo);

    public List<SalesCreditor> getListBySalesNoNotRepeat(@Param("salesNo") int salesNo);

    int deleteBySalesId(@Param("salesNo")int salesNo);

}