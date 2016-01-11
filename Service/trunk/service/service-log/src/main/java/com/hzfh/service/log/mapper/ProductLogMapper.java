package com.hzfh.service.log.mapper;

import com.hzfh.api.log.model.ProductLog;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2015/12/25.
 */
@Service("productLogMapper")
public interface ProductLogMapper {
    int add(ProductLog productLog);
}
