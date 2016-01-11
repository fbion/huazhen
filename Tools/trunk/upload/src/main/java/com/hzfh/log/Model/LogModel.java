package com.hzfh.log.Model;

import com.hzfh.api.log.model.Log;
import com.hzfh.log.Facade.LogFacade;

public class LogModel {

    public static int add(Log log) {
        return LogFacade.add(log);
    }

}
