package com.hzfh.weixin.model.common.state;

import com.hzfh.weixin.model.common.helper.EncodeHelper;
import com.hzframework.helper.StringHelper;
import com.hzframework.web.cookie.CookieManager;
import org.apache.struts2.ServletActionContext;

/**
 * Created by paul on 15-3-11.
 */
public class StateValues {// 这个类 帮助我们 获取各种写入到 cookie 的key 的值 。也可以帮我们写入key的值
    private static StateValues instance;

    public void init() {
        instance = this;
    }

    private CookieManager cookieManager;

    public void setCookieManager(CookieManager cookieManager) {
        this.cookieManager = cookieManager;
    }

    public static String getLoginTime() {
        return instance.cookieManager.getCookieValues(
                ServletActionContext.getRequest(), StateName.XFB_LOGIN_TIME);
    }

    public static void setLoginTime(long loginTime) {
        instance.cookieManager.setCookie(ServletActionContext.getResponse(), StateName.XFB_LOGIN_TIME, String.valueOf(loginTime));
    }

    public static int getCustomerId() {
        String strCustomerId = instance.cookieManager.getCookieValues(
                ServletActionContext.getRequest(), StateName.XFB_CUSTOMER_ID);
        if (StringHelper.canConvertToNumber(strCustomerId))
            return Integer.parseInt(EncodeHelper.extractRandomCustomerId(strCustomerId));
        else
            return 0;
    }

    public static void setCustomerId(int customerId) {
        instance.cookieManager.setCookie(ServletActionContext.getResponse(), StateName.XFB_CUSTOMER_ID, String.valueOf(EncodeHelper.generateRandomCustomerId(customerId)));
    }

    public static String getUserName() {// 获取客户name 到cookie
        return instance.cookieManager.getCookieValues(
                ServletActionContext.getRequest(), StateName.XFB_USER_NAME);
    }

    public static void setUserName(String userName) {// 设置客户name 到cookie
        instance.cookieManager.setCookie(ServletActionContext.getResponse(), StateName.XFB_USER_NAME, userName);
    }

    public static String getLoginKey() {// 获取用户登录 key
        return instance.cookieManager.getCookieValues(ServletActionContext.getRequest(), StateName.XFB_LOGIN_KEY);
    }

    public static void setLoginKey(String loginKey) {// 设置用户登录 key
        instance.cookieManager.setCookie(ServletActionContext.getResponse(), StateName.XFB_LOGIN_KEY, loginKey);
    }

    public static int getCaptchaKey() {//获取验证码的key 从cookie里
        String captchaKey = instance.cookieManager.getCookieValues(ServletActionContext.getRequest(), StateName.CAPTCHA_KEY);
        if (StringHelper.isNullOrEmpty(captchaKey))
            return 0;

        return Integer.parseInt(captchaKey);
    }

    public static void setCaptchaKey(int captchaKey) {//设置验证啊的key 到cookie 中
        instance.cookieManager.setCookie(ServletActionContext.getResponse(), StateName.CAPTCHA_KEY, String.valueOf(captchaKey));
    }
    
    public static String getWXOpenId() {// 获取客户name 到cookie
        return instance.cookieManager.getCookieValues(
                ServletActionContext.getRequest(), StateName.XFB_WEIXIN_OPENID);
    }

    public static void setWXOpenId(String openId) {// 设置客户name 到cookie
        instance.cookieManager.setCookie(ServletActionContext.getResponse(), StateName.XFB_WEIXIN_OPENID, openId);
    }

    public static void cleanLoginCookie() {
        instance.cookieManager.deleteCookie(ServletActionContext.getResponse(), StateName.XFB_CUSTOMER_ID);
        instance.cookieManager.deleteCookie(ServletActionContext.getResponse(), StateName.XFB_LOGIN_TIME);
        instance.cookieManager.deleteCookie(ServletActionContext.getResponse(), StateName.XFB_USER_NAME);
        instance.cookieManager.deleteCookie(ServletActionContext.getResponse(), StateName.XFB_WEIXIN_OPENID);
    }

    
}
