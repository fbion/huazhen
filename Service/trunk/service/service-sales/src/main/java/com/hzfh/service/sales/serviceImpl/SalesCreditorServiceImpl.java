package com.hzfh.service.sales.serviceImpl;

import com.hzfh.api.sales.model.SalesCreditor;
import com.hzfh.api.sales.model.query.SalesCreditorCondition;
import com.hzfh.api.sales.service.SalesCreditorService;
import com.hzfh.service.sales.dao.SalesCreditorDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*******************************************************************************
 *
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/8/24 
 * Description:
 *
 * Revision History:
 *      Date         Author               Description
 *
 ******************************************************************************/


@Service("salesCreditorService")
public class SalesCreditorServiceImpl extends BaseServiceImpl<SalesCreditor, SalesCreditorCondition, SalesCreditorDao> implements SalesCreditorService {
    @Autowired
    SalesCreditorDao salesCreditorDao;
    @Override
    public List<SalesCreditor> getListBySalesNoNotRepeat(int salesNo){
        return salesCreditorDao.getListBySalesNoNotRepeat(salesNo);
    }
    @Override
    public List<SalesCreditor> getListBySalesNo(int salesNo){
        return salesCreditorDao.getListBySalesNo(salesNo);
    }

    @Override
    public int deleteBySalesId(int salesNo) {
        return salesCreditorDao.deleteBySalesId(salesNo);
    }
}