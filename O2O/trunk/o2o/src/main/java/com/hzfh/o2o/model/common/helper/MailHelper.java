package com.hzfh.o2o.model.common.helper;

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
}

