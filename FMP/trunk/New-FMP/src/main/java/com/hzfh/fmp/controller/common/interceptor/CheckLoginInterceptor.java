package com.hzfh.fmp.controller.common.interceptor;

import com.hzfh.fmp.model.common.cache.CacheManager;
import com.hzfh.fmp.model.common.cache.CachePrefix;
import com.hzfh.fmp.model.common.enumeration.StatusType;
import com.hzfh.fmp.model.common.helper.EncodeHelper;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.common.state.StateValues;
import com.hzfh.fmp.model.employee.EmployeeModel;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.Interceptor;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CheckLoginInterceptor extends ActionSupport implements Interceptor {
    private static final long serialVersionUID = 1L;
    public static final String GOTOEMPLOYEE = "goToEmployee";

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        String namespace = invocation.getProxy().getNamespace();
        String actionName = invocation.getProxy().getActionName();
        ActionContext actionContext = invocation.getInvocationContext();
        Map<String, Object> session = actionContext.getSession();
        if ("/".equals(namespace) && ("login".equals(actionName) || "loginSubmit".equals(actionName))) {
            return invocation.invoke();
        }
        if (this.isLogin()) {
            if ("/".equals(namespace) && "goToEmployee".equals(actionName)) {
                int empId = UserHelper.getUserCache().getEmpId();
                session.put("empId",empId);
                return invocation.invoke();
            }
            if(EmployeeModel.getInfo(UserHelper.getUserCache().getEmpId()).getVerify() != StatusType.CHECK_SUCCESS){
                return GOTOEMPLOYEE;
            }
            return invocation.invoke();
        }
        HttpServletRequest request = (HttpServletRequest) actionContext.get(ServletActionContext.HTTP_REQUEST);
        String basePath = request.getRequestURL().toString();
        Map params = request.getParameterMap();
        if (!params.isEmpty()) {
            basePath += "?";
            Set keySet = params.entrySet();
            for (Iterator iterator = keySet.iterator(); iterator.hasNext(); ) {
                Map.Entry me = (Map.Entry) iterator.next();
                Object key = me.getKey();
                Object value = me.getValue();
                String[] valueStr = new String[0];
                if (value != null) {
                    valueStr = (String[]) value;
                }
                basePath += "&" + String.valueOf(key) + "=" + valueStr[0];
            }
        }
        session.put("returnUrl", basePath);
        return "login";
    }

    private boolean isLogin() {
        if (StateValues.getUserId() == 0 || StateValues.getLastLogin() == null) {
            return false;
        }
        String cacheKey = EncodeHelper.encryptPWD(String.valueOf(StateValues.getUserId()), StateValues.getLastLogin());
        if (CacheManager.get(CachePrefix.LOGIN_INFO_PREFIX, cacheKey) == null) {
            return false;
        }
        return true;

    }

    @Override
    public void destroy() {

    }

    @Override
    public void init() {

    }
}
