package com.hzfh.o2o.model.common.cookie;

import com.hzframework.web.cookie.CookieManager;
import org.apache.struts2.ServletActionContext;

/**
 * Created by paul on 15-3-11.
 */
public class CookieValue {
	private static CookieValue instance;
    public void init() {
        instance = this;
    }
    private CookieManager cookieManager;
    
    public void setCookieManager(CookieManager cookieManager) {
        this.cookieManager = cookieManager;
    }

    public static String getUserName() {
        return instance.cookieManager.getCookieValues(ServletActionContext.getRequest(), CookieKey.O2O_USERNAME);
    }

    public static void setUserName(String userName) {
    	instance.cookieManager.setCookie(ServletActionContext.getResponse(), CookieKey.O2O_USERNAME, userName);
    }

    public static void cleanLoginCookie() {
        instance.cookieManager.deleteCookie(ServletActionContext.getResponse(), CookieKey.O2O_USERNAME);
    }
    public static void cleanAllLoginCookie() {
    	instance.cookieManager.deleteAllCookie(ServletActionContext.getRequest(), ServletActionContext.getResponse());
    }
}
