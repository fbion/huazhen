package com.hzfh.fmp.model.customer;

import com.hzfh.api.customer.model.PaymentMoneyWithdraw;
import com.hzfh.api.customer.model.query.PaymentMoneyWithdrawCondition;
import com.hzfh.fmp.facade.customer.PaymentMoneyWithdrawFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class PaymentMoneyWithdrawModel {
    public static PagedList<PaymentMoneyWithdraw> getPagingList(PaymentMoneyWithdrawCondition paymentMoneyWithdrawCondition) {
        return PaymentMoneyWithdrawFacade.getPagingList(paymentMoneyWithdrawCondition);
    }

    public static int add(PaymentMoneyWithdraw paymentMoneyWithdraw) {
        return PaymentMoneyWithdrawFacade.add(paymentMoneyWithdraw);
    }

    public static int update(PaymentMoneyWithdraw paymentMoneyWithdraw) {
        return PaymentMoneyWithdrawFacade.update(paymentMoneyWithdraw);
    }

    public static List<PaymentMoneyWithdraw> getList() {
        return PaymentMoneyWithdrawFacade.getList();
    }

    public static PaymentMoneyWithdraw getInfo(int id) {
        return PaymentMoneyWithdrawFacade.getInfo(id);
    }
}
