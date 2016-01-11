package com.hzfh.service.sales.daoImpl;

import com.hzfh.api.sales.model.SalesCreditor;
import com.hzfh.api.sales.model.query.SalesCreditorCondition;
import com.hzfh.service.sales.dao.SalesCreditorDao;
import com.hzfh.service.sales.mapper.SalesCreditorMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*******************************************************************************
 *
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/8/25 
 * Description:
 *
 * Revision History:
 *      Date         Author               Description
 *
 ******************************************************************************/


@Service("salesCreditorDao")
public class SalesCreditorDaoImpl extends BaseDaoImpl<SalesCreditor, SalesCreditorCondition, SalesCreditorMapper> implements SalesCreditorDao {
    @Autowired
    SalesCreditorMapper salesCreditorMapper;

    @Override
    public List<SalesCreditor> getListBySalesNo(int salesNo){
        return salesCreditorMapper.getListBySalesNo(salesNo);
    }
    @Override
    public List<SalesCreditor> getListBySalesNoNotRepeat(int salesNo){
        return salesCreditorMapper.getListBySalesNoNotRepeat(salesNo);
    }

    @Override
    public int deleteBySalesId(int salesNo) {
        return salesCreditorMapper.deleteBySalesId(salesNo);
    }
}