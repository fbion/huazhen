package com.hzfh.fmp.model.log;

import com.hzfh.api.log.model.ProductLog;
import com.hzfh.fmp.facade.log.ProductLogFacade;

public class ProductLogModel {

    public static int add(ProductLog productLog) {
        return ProductLogFacade.add(productLog);
    }


}
