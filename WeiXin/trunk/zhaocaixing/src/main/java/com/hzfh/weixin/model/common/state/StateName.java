package com.hzfh.weixin.model.common.state;

/**
 * Created by paul on 15-3-11.
 */
public class StateName {//cookie 中的 key 的生成 所依据的 基础字符串
    public static final String CAPTCHA_KEY="captcha"; // 验证码

    public static final String XFB_CUSTOMER_ID="userId";	//客户id

    public static final String XFB_LOGIN_TIME="lastLogin";//最后登录时间

    public static final String XFB_LOGIN_KEY="uk";	//用户登录key

    public static final String XFB_USER_NAME = "userName";//用户名
    
    public static final String XFB_WEIXIN_OPENID = "wxopenId";
}
