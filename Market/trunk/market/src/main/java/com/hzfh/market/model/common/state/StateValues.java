package com.hzfh.market.model.common.state;

import org.apache.struts2.ServletActionContext;

import com.hzfh.market.model.common.helper.EncodeHelper;
import com.hzframework.helper.StringHelper;
import com.hzframework.web.cookie.CookieManager;

/**
 * Created by paul on 15-3-11.
 */
public class StateValues {
	private static StateValues instance;
    public void init() {
        instance = this;
    }
    private CookieManager cookieManager;
    
    public void setCookieManager(CookieManager cookieManager) {
        this.cookieManager = cookieManager;
    }

    public static int getCaptchaKey() {
        String captchaKey =instance.cookieManager.getCookieValues(ServletActionContext.getRequest(),StateName.CAPTCHA_KEY);
        if (StringHelper.isNullOrEmpty(captchaKey))
            return 0;

        return Integer.parseInt(captchaKey);
    }

    public static void setCaptchaKey(int captchaKey) {
        instance.cookieManager.setCookie(ServletActionContext.getResponse(), StateName.CAPTCHA_KEY, String.valueOf(captchaKey));
    }

    public static int getCustomerId() { 
    	 String strCustomerId = instance.cookieManager.getCookieValues(ServletActionContext.getRequest(), StateName.P2P_CUSTOMER_ID);
         if (StringHelper.canConvertToNumber(strCustomerId))
             return Integer.parseInt(EncodeHelper.extractRandomCustomerId(strCustomerId));
         else
             return 0;
    }

    public static void setCustomerId(int customerId) {
    	 instance.cookieManager.setCookie(ServletActionContext.getResponse(), StateName.P2P_CUSTOMER_ID, String.valueOf(EncodeHelper.generateRandomCustomerId(customerId)));
    }

    /*public static void setCustomerId(int customerId, int maxAge) { 
    	instance.cookieManager.setCookie(StateName.P2P_CUSTOMER_ID, EncodeHelper.generateRandomCustomerId(customerId), maxAge);
    }*/

    public static String getUserName() {
        return instance.cookieManager.getCookieValues(ServletActionContext.getRequest(),StateName.P2P_USERNAME);
    }

    public static void setUserName(String userName) {
    	instance.cookieManager.setCookie(ServletActionContext.getResponse(),StateName.P2P_USERNAME, userName);
    }

   /* public static void setUserName(String userName, int maxAge) {//设置客户name 到cookie 根据用户name maxAge 生成随机key
        CookieManager.getInstance().setCookie(StateName.P2P_USERNAME, userName, maxAge);
    }*/

    public static String getLoginTime() {
        return instance.cookieManager.getCookieValues(
                ServletActionContext.getRequest(),StateName.P2P_LOGIN_TIME);
    }

    public static void setLoginTime(Long loginTime) {
    	instance.cookieManager.setCookie(ServletActionContext.getResponse(),StateName.P2P_LOGIN_TIME, String.valueOf(loginTime));
    }

   /* public static void setLoginTime(String loginTime, int maxAge) {
        CookieManager.getInstance().setCookie(StateName.P2P_LOGIN_TIME, loginTime, maxAge);
    }*/

    public static String getLoginKey() {
        return instance.cookieManager.getCookieValues(ServletActionContext.getRequest(), StateName.P2P_LOGIN_KEY);
    }

    public static void setLoginKey(String loginKey) {
        instance.cookieManager.setCookie(ServletActionContext.getResponse(), StateName.P2P_LOGIN_KEY, loginKey);
    }

    /*public static void setLoginKey(String loginKey, int maxAge) {
        CookieManager.getInstance().setCookie(StateName.P2P_LOGIN_KEY, loginKey, maxAge);
    }*/
    public static void cleanLoginCookie() {
        instance.cookieManager.deleteCookie(ServletActionContext.getResponse(), StateName.P2P_CUSTOMER_ID);
        instance.cookieManager.deleteCookie(ServletActionContext.getResponse(), StateName.P2P_LOGIN_TIME);
        instance.cookieManager.deleteCookie(ServletActionContext.getResponse(), StateName.P2P_LOGIN_KEY);
    }
    public static void cleanAllLoginCookie() {
    	instance.cookieManager.deleteAllCookie(ServletActionContext.getRequest(), ServletActionContext.getResponse());
    }
}
