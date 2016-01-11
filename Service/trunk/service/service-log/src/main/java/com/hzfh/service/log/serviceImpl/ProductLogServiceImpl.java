package com.hzfh.service.log.serviceImpl;

import com.hzfh.api.log.model.ProductLog;
import com.hzfh.api.log.model.SalesLog;
import com.hzfh.api.log.service.ProductLogService;
import com.hzfh.service.log.dao.ProductLogDao;
import com.hzfh.service.log.dao.SalesLogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2015/12/25.
 */
@Service("productLogService")
public class ProductLogServiceImpl implements ProductLogService {
    @Autowired
    ProductLogDao productLogDao;
    @Override
    public int add(ProductLog productLog) {
        return productLogDao.add(productLog);
    }
}
