package com.hzfh.service.log.daoImpl;

import com.hzfh.api.log.model.ProductLog;
import com.hzfh.api.log.model.SalesLog;
import com.hzfh.service.log.dao.ProductLogDao;
import com.hzfh.service.log.mapper.ProductLogMapper;
import com.hzfh.service.log.mapper.SalesLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2015/12/25.
 */
@Service("productLogDao")
public class ProductLogDaoImpl implements ProductLogDao{
    @Autowired
    private ProductLogMapper productLogMapper;
    @Override
    public int add(ProductLog productLog) {
        return productLogMapper.add(productLog);
    }
}
