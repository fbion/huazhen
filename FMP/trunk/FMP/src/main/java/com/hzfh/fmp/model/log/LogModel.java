package com.hzfh.fmp.model.log;

import com.hzfh.api.log.model.Log;
import com.hzfh.fmp.facade.log.LogFacade;

public class LogModel {

    public static int add(Log log) {
        return LogFacade.add(log);
    }

}
