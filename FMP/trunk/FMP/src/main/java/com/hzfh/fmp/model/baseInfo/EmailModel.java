package com.hzfh.fmp.model.baseInfo;

import com.hzfh.api.baseInfo.model.Email;
import com.hzfh.api.baseInfo.model.query.EmailCondition;
import com.hzfh.api.employee.model.Employee;
import com.hzfh.api.permission.model.UserRole;
import com.hzfh.fmp.facade.baseInfo.EmailFacade;
import com.hzfh.fmp.model.common.PageAlias;
import com.hzfh.fmp.model.common.helper.MailHelper;
import com.hzfh.fmp.model.employee.EmployeeModel;
import com.hzfh.fmp.model.permission.UserModel;
import com.hzfh.fmp.model.permission.UserRoleModel;
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
    public static int addPositiveEvaluationEmail(String to,int inUserNo,String body){
        Email email = new Email();
        email.setBody(body);
        email.setSubject(MailHelper.MAIL_POSITIVEEVALUATION_SUBJCET);
        email.setTo(to);
        email.setInUserNo(inUserNo);
        email.setHost(MailHelper.MAIL_HOST);
        email.setUser(MailHelper.MAIL_USER);
        email.setPassword(MailHelper.MAIL_PASS);
        email.setSuffix(MailHelper.MAIL_POSTFIX);
        email.setSenderName(MailHelper.MAIL_SENDER_NAME2);
        email.setStatus((byte)0);
        return EmailModel.add(email);
    }

    public static int examineRemindEmail(int userNo,String empName){
        int userNo1 = UserRoleModel.getInfoByRoleNo(1040).get(0).getUserNo();
        String to = EmployeeModel.getEmpByUserId(userNo1).getEmail();
        Email email = new Email();
        email.setBody(empName+MailHelper.MAIL_EXAMINEREMIND_BODY);
        email.setSubject(MailHelper.MAIL_EXAMINEREMIND_SUBJCET);
        email.setTo(to);
        email.setInUserNo(userNo);
        email.setHost(MailHelper.MAIL_HOST);
        email.setUser(MailHelper.MAIL_USER);
        email.setPassword(MailHelper.MAIL_PASS);
        email.setSuffix(MailHelper.MAIL_POSTFIX);
        email.setSenderName(MailHelper.MAIL_SENDER_NAME2);
        email.setStatus((byte)0);
        return EmailModel.add(email);
    }
    public static int addpositive(String to,int customerId,int type,String body){
        Email email = new Email();

        if(type==1){
            email.setBody(body);
            email.setSubject(MailHelper.MAIL_POSITIVE_SUBJECT);
        }else if(type==2){
            email.setBody(body);
            email.setSubject(MailHelper.MAIL_DELAY_SUBJCET);
        }
        email.setHost(MailHelper.MAIL_HOST);
        email.setUser(MailHelper.MAIL_USER);
        email.setPassword(MailHelper.MAIL_PASS);
        email.setSuffix(MailHelper.MAIL_POSTFIX);
        email.setSenderName(MailHelper.MAIL_SENDER_NAME2);

        email.setTo(to);
        email.setInUserNo(customerId);
        email.setStatus((byte)0);

        return EmailFacade.add(email);
    }
}
