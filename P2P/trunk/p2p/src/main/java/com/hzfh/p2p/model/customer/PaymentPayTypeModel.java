package com.hzfh.p2p.model.customer;

import java.util.List;

import com.hzfh.api.customer.model.PaymentPayType;
import com.hzfh.api.customer.model.query.PaymentPayTypeCondition;
import com.hzfh.p2p.facade.customer.PaymentPayTypeFacade;
import com.hzframework.contract.PagedList;

public class PaymentPayTypeModel {
    public static PagedList<PaymentPayType> getPagingList(PaymentPayTypeCondition paymentPayTypeCondition) {
        return PaymentPayTypeFacade.getPagingList(paymentPayTypeCondition);
    }

    public static int add(PaymentPayType paymentPayType) {
        return PaymentPayTypeFacade.add(paymentPayType);
    }

    public static int update(PaymentPayType paymentPayType) {
        return PaymentPayTypeFacade.update(paymentPayType);
    }

    public static List<PaymentPayType> getList() {
        return PaymentPayTypeFacade.getList();
    }

    public static PaymentPayType getInfo(int id) {
        return PaymentPayTypeFacade.getInfo(id);
    }
}
