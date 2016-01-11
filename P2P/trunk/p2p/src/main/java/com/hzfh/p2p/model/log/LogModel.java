package com.hzfh.p2p.model.log;

import com.hzfh.api.log.model.Log;
import com.hzfh.p2p.facade.log.LogFacade;

public class LogModel {

    public static int add(Log log) {
        return LogFacade.add(log);
    }

}
