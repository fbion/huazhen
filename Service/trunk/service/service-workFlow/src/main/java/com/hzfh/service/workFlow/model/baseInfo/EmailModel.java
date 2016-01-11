package com.hzfh.service.workFlow.model.baseInfo;

import com.hzfh.api.baseInfo.model.Email;
import com.hzfh.service.workFlow.facade.baseInfo.EmailFacade;
import com.hzfh.service.workFlow.model.common.helper.MailHelper;


/**
 * Created by ulei0 on 2015/9/10.
 */
public class EmailModel {
    public static int add(Email email) {
        return EmailFacade.add(email);
    }

    public static int add(String to,String subject, String Content,int customerId){
        Email email = new Email();
        email.setHost(MailHelper.MAIL_HOST);
        email.setUser(MailHelper.MAIL_USER);
        email.setPassword(MailHelper.MAIL_PASS);
        email.setSuffix(MailHelper.MAIL_POSTFIX);
        email.setSenderName(MailHelper.MAIL_SENDER_NAME2);
        email.setTo(to);
        email.setSubject(subject);
        email.setBody(Content);
        email.setInUserNo(customerId);
        email.setStatus((byte)0);
        email.setFromName("Administrator");
        return EmailFacade.add(email);
    }
}
