package com.hzfh.p2p.model.payment;

import java.util.List;

import com.hzfh.api.payment.model.PaymentConnectionRequest;
import com.hzfh.api.payment.model.query.PaymentConnectionRequestCondition;
import com.hzfh.p2p.facade.payment.PaymentConnectionRequestFacade;
import com.hzframework.contract.PagedList;

public class PaymentConnectionRequestModel {
    public static PagedList<PaymentConnectionRequest> getPagingList(PaymentConnectionRequestCondition paymentConnectionRequestCondition) {
        return PaymentConnectionRequestFacade.getPagingList(paymentConnectionRequestCondition);
    }

    public static int add(PaymentConnectionRequest paymentConnectionRequest) {
        return PaymentConnectionRequestFacade.add(paymentConnectionRequest);
    }

    public static int update(PaymentConnectionRequest paymentConnectionRequest) {
        return PaymentConnectionRequestFacade.update(paymentConnectionRequest);
    }

    public static List<PaymentConnectionRequest> getList() {
        return PaymentConnectionRequestFacade.getList();
    }

    public static PaymentConnectionRequest getInfo(int id) {
        return PaymentConnectionRequestFacade.getInfo(id);
    }
}
