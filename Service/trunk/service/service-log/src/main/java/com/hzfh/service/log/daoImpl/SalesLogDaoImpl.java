package com.hzfh.service.log.daoImpl;

import com.hzfh.api.log.model.SalesLog;
import com.hzfh.service.log.dao.SalesLogDao;
import com.hzfh.service.log.mapper.SalesLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2015/11/2.
 */

@Service("salesLogDao")
public class SalesLogDaoImpl implements SalesLogDao{
    @Autowired
    private SalesLogMapper salesLogMapper;
    @Override
    public int add(SalesLog salesLog) {
        return salesLogMapper.add(salesLog);
    }
}
