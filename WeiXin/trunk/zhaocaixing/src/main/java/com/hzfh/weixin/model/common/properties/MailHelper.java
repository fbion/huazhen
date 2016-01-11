package com.hzfh.weixin.model.common.properties;

import com.hzframework.helper.PropertyHelper;

/**
 * Created by paul on 15-3-17.
 */
public class MailHelper {
    public static final String MAIL_HOST = PropertyHelper.getContextProperty("mail.host").toString();
    public static final String MAIL_USER = PropertyHelper.getContextProperty("mail.user").toString();
    public static final String MAIL_PASS = PropertyHelper.getContextProperty("mail.pass").toString();
    public static final String MAIL_POSTFIX = PropertyHelper.getContextProperty("mail.postfix").toString();
    public static final String MAIL_SENDER_NAME = PropertyHelper.getContextProperty("mail.sender.name").toString();
    public static final String MAIL_ACTIVATE_SUBJECT = PropertyHelper.getContextProperty("mail.activate.subject").toString();
    public static final String MAIL_ACTIVATE_BODY = PropertyHelper.getContextProperty("mail.activate.body").toString();
    public static final String MAIL_RESET_SUBJECT = PropertyHelper.getContextProperty("mail.reset.subject").toString();
    public static final String MAIL_RESET_BODY = PropertyHelper.getContextProperty("mail.reset.body").toString();
    public static final String MAIL_SUBSCRIBE_BODY = PropertyHelper.getContextProperty("mail.subscribe.body").toString();
    public static final String MAIL_SUBSCRIBE_SUBJECT = PropertyHelper.getContextProperty("mail.subscribe.subject").toString();
    public static final String MAIL_SUBSCRIBE_RECEIVER = PropertyHelper.getContextProperty("mail.subscribe.receiver").toString();
}
