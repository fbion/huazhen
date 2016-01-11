package com.hzfh.weixin.model.common.properties;

import com.hzframework.helper.PropertyHelper;

/**
 * Created by paul on 15-3-12.
 */
public class RegexHelper {
    public static final String REGEX_CUSTOMER_NAME =PropertyHelper.getContextProperty("regex_customer_name").toString();
    public static final String REGEX_EMAIL =PropertyHelper.getContextProperty("regex_email").toString();
    public static final String REGEX_PWD =PropertyHelper.getContextProperty("regex_pwd").toString();
    public static final String REGEX_VERIFY_CODE =PropertyHelper.getContextProperty("regex_verify_code").toString();
    public static final String REGEX_CELLPHONE =PropertyHelper.getContextProperty("regex_cellphone").toString();
    public static final String SUBSCRIBE_CALLNAME =PropertyHelper.getContextProperty("subscribe_callName").toString();
    public static final String REGEX_SMS_CAPTCHA =PropertyHelper.getContextProperty("regex_sms_captcha").toString();
}
