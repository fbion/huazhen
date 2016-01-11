package com.hzfh.fmp.facade.log;

import com.hzfh.api.log.model.Log;
import com.hzfh.api.log.service.LogService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LogFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-log.xml");

    public static int add(Log log){
        LogService logService = (LogService) context.getBean("logService");

        return logService.add(log);
    }

}
