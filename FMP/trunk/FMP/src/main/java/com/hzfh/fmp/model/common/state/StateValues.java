package com.hzfh.fmp.model.common.state;

import com.hzframework.helper.StringHelper;
import com.hzframework.web.cookie.CookieManager;
import org.apache.struts2.ServletActionContext;

import java.sql.Timestamp;

/**
 * Created by paul on 15-4-20.
 */
public class StateValues {
    private static StateValues instance;
    public void init(){
        instance = this;
    }

    private CookieManager cookieManager;
    public void setCookieManager(CookieManager cookieManager) {
        this.cookieManager = cookieManager;
    }

    public static String getLastLogin() {
        return instance.cookieManager.getCookieValues(ServletActionContext.getRequest(), StateName.FMP_LAST_LOGIN);
    }

    public static void setLastLogin(Timestamp lastLogin) {
        instance.cookieManager.setCookie(ServletActionContext.getResponse(), StateName.FMP_LAST_LOGIN, String.valueOf(lastLogin));
    }

    public static int getUserId() {
        String strUserId = instance.cookieManager.getCookieValues(ServletActionContext.getRequest(), StateName.FMP_USER_ID);
        if (StringHelper.canConvertToNumber(strUserId))
            return Integer.parseInt(strUserId);
        else
            return 0;
    }

    public static void setUserId(int userId) {
        instance.cookieManager.setCookie(ServletActionContext.getResponse(), StateName.FMP_USER_ID, String.valueOf(userId));
    }

    public static void cleanAll(){
        instance.cookieManager.deleteAllCookie(ServletActionContext.getRequest(),ServletActionContext.getResponse());
    }

    public static void cleanLoginCookie(){
        instance.cookieManager.deleteCookie(ServletActionContext.getResponse(),StateName.FMP_USER_ID);
        instance.cookieManager.deleteCookie(ServletActionContext.getResponse(),StateName.FMP_LAST_LOGIN);
    }
    
    public static String getIsTest() {
        return instance.cookieManager.getCookieValues(ServletActionContext.getRequest(), StateName.FMP_IS_TEST);
    }

    public static void setIsTest(String isTest) {
        instance.cookieManager.setCookie(ServletActionContext.getResponse(), StateName.FMP_IS_TEST, isTest);
    }
}
