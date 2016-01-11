package com.hzfh.api.sales.service;

import com.hzfh.api.sales.model.SalesCreditor;
import com.hzfh.api.sales.model.query.SalesCreditorCondition;
import com.hzframework.data.service.BaseService;

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


public interface SalesCreditorService extends BaseService<SalesCreditor, SalesCreditorCondition> {
    public List<SalesCreditor> getListBySalesNo(int salesNo);

    public List<SalesCreditor> getListBySalesNoNotRepeat(int salesNo);

    int deleteBySalesId(int salesNo);

}