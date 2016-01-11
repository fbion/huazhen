package com.hzfh.fmp.model.common.helper;

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
    public static final String MAIL_POSITIVE_BODY = PropertyHelper.getContextProperty("mail.positive.body").toString();
    public static final String MAIL_DELAY_BODY = PropertyHelper.getContextProperty("mail.delay.body").toString();
    public static final String MAIL_POSITIVE_SUBJECT = PropertyHelper.getContextProperty("mail.positive.subject").toString();
    public static final String MAIL_DELAY_SUBJCET = PropertyHelper.getContextProperty("mail.delay.subject").toString();
    public static final String MAIL_EXAMINEREMIND_SUBJCET = PropertyHelper.getContextProperty("mail.examineRemind.subject").toString();
    public static final String MAIL_EXAMINEREMIND_BODY = PropertyHelper.getContextProperty("mail.examineRemind.body").toString();
    public static final String MAIL_POSITIVEEVALUATION_SUBJCET = PropertyHelper.getContextProperty("mail.positiveEvaluation.subject").toString();
    public static final String MAIL_POSITIVEEVALUATION_BODY = PropertyHelper.getContextProperty("mail.positiveEvaluation.body").toString();
}

