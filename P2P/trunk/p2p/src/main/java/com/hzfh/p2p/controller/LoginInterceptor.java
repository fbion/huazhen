package com.hzfh.p2p.controller;

import com.hzfh.p2p.model.common.AuthenticationModel;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by paul on 15-3-19.
 */
public class LoginInterceptor extends AbstractInterceptor {

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        if (AuthenticationModel.isLogin()){
            return invocation.invoke();
        }

        ActionContext actionContext = invocation.getInvocationContext();
        HttpServletRequest request = (HttpServletRequest)actionContext.getContext().get(ServletActionContext.HTTP_REQUEST);

        Map<String, Object> session = actionContext.getSession();
        session.put("returnUrl",request.getRequestURL().toString());

        return Action.LOGIN;
    }
}
