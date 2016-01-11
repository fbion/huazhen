package com.hzfh.service.workFlow.model.common.helper;

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
    public static final String MAIL_SENDER_NAME1 = PropertyHelper.getContextProperty("mail.sender.name1").toString();
    public static final String MAIL_SENDER_NAME2 = PropertyHelper.getContextProperty("mail.sender.name2").toString();
    public static final String MAIL_POSITIVE_SUBJECT = PropertyHelper.getContextProperty("mail.sales.subject").toString();
    public static final String MAIL_SALESAUDITBACK_BODY = PropertyHelper.getContextProperty("mail.salesAuditBack.body").toString();
    public static final String MAIL_SALESAUDITNEXT_BODY = PropertyHelper.getContextProperty("mail.salesAuditNext.body").toString();
    public static final String MAIL_SALESAUDITSUCCESS_BODY = PropertyHelper.getContextProperty("mail.salesAuditSuccess.body").toString();
    public static final String MAIL_PRODUCTAUDITNEXT_BODY = PropertyHelper.getContextProperty("mail.productAuditNext.body").toString();
}

