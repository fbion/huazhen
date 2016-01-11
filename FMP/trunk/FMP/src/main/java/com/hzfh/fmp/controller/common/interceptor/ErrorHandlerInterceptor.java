package com.hzfh.fmp.controller.common.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.Interceptor;

import java.util.Map;

/**
 * Created by Administrator on 2015/7/21.
 */
public class ErrorHandlerInterceptor extends ActionSupport implements Interceptor {
    public static final String ERRORHANDLER = "error";
    @Override
    public void destroy() {

    }

    @Override
    public void init() {

    }

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        try {
            invocation.invoke();
        }catch (Exception e){
            ActionContext actionContext = invocation.getInvocationContext();
            Map<String, Object> session = actionContext.getSession();
            session.put("exception","系统出现异常，请重新操作或联系系统管理员。");
            session.put("exceptionStack",e.toString());
        }
        return ERRORHANDLER;
    }
}
