package com.hzfh.p2p.model.customer;

import java.util.List;

import com.hzfh.api.customer.model.PaymentPlatform;
import com.hzfh.api.customer.model.query.PaymentPlatformCondition;
import com.hzfh.p2p.facade.customer.PaymentPlatformFacade;
import com.hzframework.contract.PagedList;

public class PaymentPlatformModel {
    public static PagedList<PaymentPlatform> getPagingList(PaymentPlatformCondition paymentPlatformCondition) {
        return PaymentPlatformFacade.getPagingList(paymentPlatformCondition);
    }

    public static int add(PaymentPlatform paymentPlatform) {
        return PaymentPlatformFacade.add(paymentPlatform);
    }

    public static int update(PaymentPlatform paymentPlatform) {
        return PaymentPlatformFacade.update(paymentPlatform);
    }

    public static List<PaymentPlatform> getList() {
        return PaymentPlatformFacade.getList();
    }

    public static PaymentPlatform getInfo(int id) {
        return PaymentPlatformFacade.getInfo(id);
    }
}
