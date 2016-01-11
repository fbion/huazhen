package com.hzfh.p2p.facade.baseInfo;

import com.hzfh.api.baseInfo.model.LoginFailed;
import com.hzfh.api.baseInfo.model.query.LoginFailedCondition;
import com.hzfh.api.baseInfo.service.LoginFailedService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import java.util.List;

public class LoginFailedFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-baseInfo.xml");

    public static PagedList<LoginFailed> getPagingList(LoginFailedCondition loginFailedCondition) {
        LoginFailedService loginFailedService = (LoginFailedService) context.getBean("loginFailedService");

        return  loginFailedService.getPagingList(loginFailedCondition);
    }

    public static int add(LoginFailed loginFailed){
        LoginFailedService loginFailedService = (LoginFailedService) context.getBean("loginFailedService");

        return loginFailedService.add(loginFailed);
    }

    public static int update(LoginFailed loginFailed){
        LoginFailedService loginFailedService = (LoginFailedService) context.getBean("loginFailedService");
        return loginFailedService.update(loginFailed);
    }

    public static List<LoginFailed> getList(){
        LoginFailedService loginFailedService = (LoginFailedService) context.getBean("loginFailedService");

        return loginFailedService.getList();
    }

    public static LoginFailed getInfo(int id){
        LoginFailedService loginFailedService = (LoginFailedService) context.getBean("loginFailedService");

        return loginFailedService.getInfo(id);
    }
}
