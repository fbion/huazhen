package com.hzfh.p2p.model.common.properties;

import com.hzframework.helper.PropertyHelper;

/**
 * Created by paul on 15-1-16.
 */
public class ParamHelper {
    public static final int LOGIN_FAILED_COUNT = Integer.parseInt(PropertyHelper.getContextProperty("login.failed.count").toString());
    public static final int AUTO_LOGIN_DAYS =Integer.parseInt(PropertyHelper.getContextProperty("auto.login.days").toString());
    public static final int DEFAULT_LOGIN_HOURS =Integer.parseInt(PropertyHelper.getContextProperty("default.login.hours").toString());
    public static final int ACTIVATE_EMAIL_EXPIRE_DAY =Integer.parseInt(PropertyHelper.getContextProperty("activate.email.expire.day").toString());
    public static final int RESET_EMAIL_EXPIRE_HOUR =Integer.parseInt(PropertyHelper.getContextProperty("reset.email.expire.hour").toString());
    public static final int RESET_PWD_EXPIRE_MINUTE =Integer.parseInt(PropertyHelper.getContextProperty("reset.pwd.expire.minute").toString());
   /* public static final int PRODUCT_NUMBER =Integer.parseInt(PropertyHelper.getContextProperty("product.number").toString());*/
//    public static final int PRODUCT_TYPE_PARTNER_QUATA=Integer.parseInt(PropertyHelper.getContextProperty("product.type.Partner.quota").toString());
//    public static final int PRODUCT_TYPE_OTHER_QUATA=Integer.parseInt(PropertyHelper.getContextProperty("product.type.other.quota").toString());
    public static final int SMS_CODE_EXPIRE_MINUTE=Integer.parseInt(PropertyHelper.getContextProperty("sms.code.expire.minute").toString());
    
    public static final int SMS_CODE_IP_EXPIRE_TIME=Integer.parseInt(PropertyHelper.getContextProperty("sms.code.ip.expire.time").toString());
    public static final int SMS_CODE_TEL_EXPIRE_TIME=Integer.parseInt(PropertyHelper.getContextProperty("sms.code.tel.expire.time").toString());
    public static final int SMS_CODE_IP_NUMBER=Integer.parseInt(PropertyHelper.getContextProperty("sms.code.ip.number").toString());
    public static final int SMS_CODE_TEL_NUMBER=Integer.parseInt(PropertyHelper.getContextProperty("sms.code.tel.number").toString());
    public static final int BANNER_EXPIRATION_TIME=Integer.parseInt(PropertyHelper.getContextProperty("banner.expiration.time").toString());
    public static final int EMAIL_SEND_LIMIT_TIME=Integer.parseInt(PropertyHelper.getContextProperty("email.send.limit.time").toString());
    
    public static final int PAY_RECHARGE_TYPE=Integer.parseInt(PropertyHelper.getContextProperty("pay.recharge.type").toString());
    public static final int PAY_WITHDRAW_TYPE=Integer.parseInt(PropertyHelper.getContextProperty("pay.withdraw.type").toString());
    
    public static final String LEGAL_FILE_TYPE=PropertyHelper.getContextProperty("legal.file.type").toString();
    
    //qq login
    public static final String APP_ID = PropertyHelper.getContextProperty("app_ID").toString();
    public static final String APP_KEY = PropertyHelper.getContextProperty("app_KEY").toString();
    public static final String REDIRECT_URI = PropertyHelper.getContextProperty("redirect_URI").toString();
    public static final String SCOPE = PropertyHelper.getContextProperty("scope").toString();
}

