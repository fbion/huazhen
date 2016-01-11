package com.hzfh.p2p.model.customer;

import java.util.List;

import com.hzfh.api.customer.model.PaymentBankCode;
import com.hzfh.api.customer.model.query.PaymentBankCodeCondition;
import com.hzfh.p2p.facade.customer.PaymentBankCodeFacade;
import com.hzframework.contract.PagedList;

public class PaymentBankCodeModel {
    public static PagedList<PaymentBankCode> getPagingList(PaymentBankCodeCondition paymentBankCodeCondition) {
        return PaymentBankCodeFacade.getPagingList(paymentBankCodeCondition);
    }

    public static int add(PaymentBankCode paymentBankCode) {
        return PaymentBankCodeFacade.add(paymentBankCode);
    }

    public static int update(PaymentBankCode paymentBankCode) {
        return PaymentBankCodeFacade.update(paymentBankCode);
    }

    public static List<PaymentBankCode> getList() {
        return PaymentBankCodeFacade.getList();
    }

    public static PaymentBankCode getInfo(int id) {
        return PaymentBankCodeFacade.getInfo(id);
    }
}
