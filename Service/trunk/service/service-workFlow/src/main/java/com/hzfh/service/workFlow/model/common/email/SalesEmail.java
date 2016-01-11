package com.hzfh.service.workFlow.model.common.email;

import com.hzfh.api.sales.model.Sales;
import com.hzfh.service.workFlow.model.common.helper.MailHelper;

/**
 * Created by ulei0 on 2015/9/12.
 */
public class SalesEmail {
    public static String sendEmail(Sales sales, String link) {
        String body = String.format(MailHelper.MAIL_SALESAUDITNEXT_BODY,sales.getEmpName(),sales.getCustomerName(),sales.getPurchaseDate(),sales.getMoney(),link);
        return body;
    }

    public static String sendEmailNoLink(Sales sales) {
        String body = String.format(MailHelper.MAIL_SALESAUDITBACK_BODY,sales.getEmpName(),sales.getCustomerName(),sales.getPurchaseDate(),sales.getMoney());
        return body;
    }

    public static String sendSuccessEmailNoLink(Sales sales) {
        String body = String.format(MailHelper.MAIL_SALESAUDITSUCCESS_BODY,sales.getEmpName(),sales.getCustomerName(),sales.getPurchaseDate(),sales.getMoney());
        return body;
    }

}
