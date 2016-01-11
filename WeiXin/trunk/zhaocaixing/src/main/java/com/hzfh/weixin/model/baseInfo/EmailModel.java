package com.hzfh.weixin.model.baseInfo;

import com.hzfh.api.baseInfo.model.Email;
import com.hzfh.api.baseInfo.model.query.EmailCondition;
import com.hzfh.weixin.facade.baseInfo.EmailFacade;
import com.hzfh.weixin.model.common.properties.MailHelper;
import com.hzframework.contract.PagedList;

import java.util.List;

public class EmailModel {
    public static PagedList<Email> getPagingList(EmailCondition emailCondition) {
        return EmailFacade.getPagingList(emailCondition);
    }

    public static int add(Email email) {
        return EmailFacade.add(email);
    }

    public static int update(Email email) {
        return EmailFacade.update(email);
    }

    public static List<Email> getList() {
        return EmailFacade.getList();
    }

    public static Email getInfo(int id) {
        return EmailFacade.getInfo(id);
    }

    public static int add(String to,String subject, String Content,int customerId){
        Email email = new Email();
        email.setHost(MailHelper.MAIL_HOST);
        email.setUser(MailHelper.MAIL_USER);
        email.setPassword(MailHelper.MAIL_PASS);
        email.setSuffix(MailHelper.MAIL_POSTFIX);
        email.setSenderName(MailHelper.MAIL_SENDER_NAME);

        email.setTo(to);
        email.setSubject(subject);
        email.setBody(Content);

        email.setInUserNo(customerId);
        email.setStatus((byte)0);

        return EmailFacade.add(email);
    }
    public static int add(String to,String subject,String content){
    	Email email = new Email();
    	email.setHost(MailHelper.MAIL_HOST);
        email.setUser(MailHelper.MAIL_USER);
        email.setPassword(MailHelper.MAIL_PASS);
        email.setSuffix(MailHelper.MAIL_POSTFIX);
        email.setSenderName(MailHelper.MAIL_SENDER_NAME);

        email.setTo(to);
        email.setSubject(subject);
        email.setBody(content);

        email.setStatus((byte)0);
    	return EmailFacade.add(email);
    }
}
