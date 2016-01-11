package com.hzfh.fmp.model.log;

import com.hzfh.api.log.model.SalesLog;
import com.hzfh.fmp.facade.log.SalesLogFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class SalesLogModel {
    public static int add(SalesLog salesLog){
        return SalesLogFacade.add(salesLog);
    }

}
