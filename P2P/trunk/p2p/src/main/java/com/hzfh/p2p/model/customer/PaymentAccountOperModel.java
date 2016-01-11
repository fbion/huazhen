package com.hzfh.p2p.model.customer;

import java.util.List;

import com.hzfh.api.customer.model.PaymentAccountOper;
import com.hzfh.api.customer.model.query.PaymentAccountOperCondition;
import com.hzfh.p2p.facade.customer.PaymentAccountOperFacade;
import com.hzframework.contract.PagedList;

public class PaymentAccountOperModel {
    public static PagedList<PaymentAccountOper> getPagingList(PaymentAccountOperCondition paymentAccountOperCondition) {
        return PaymentAccountOperFacade.getPagingList(paymentAccountOperCondition);
    }

    public static int add(PaymentAccountOper paymentAccountOper) {
        return PaymentAccountOperFacade.add(paymentAccountOper);
    }

    public static int update(PaymentAccountOper paymentAccountOper) {
        return PaymentAccountOperFacade.update(paymentAccountOper);
    }

    public static List<PaymentAccountOper> getList() {
        return PaymentAccountOperFacade.getList();
    }

    public static PaymentAccountOper getInfo(int id) {
        return PaymentAccountOperFacade.getInfo(id);
    }
}
