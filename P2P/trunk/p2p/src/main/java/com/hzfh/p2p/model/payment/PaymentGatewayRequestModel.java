package com.hzfh.p2p.model.payment;

import java.util.List;

import com.hzfh.api.payment.model.PaymentGatewayRequest;
import com.hzfh.api.payment.model.query.PaymentGatewayRequestCondition;
import com.hzfh.p2p.facade.payment.PaymentGatewayRequestFacade;
import com.hzframework.contract.PagedList;

public class PaymentGatewayRequestModel {
    public static PagedList<PaymentGatewayRequest> getPagingList(PaymentGatewayRequestCondition paymentGatewayRequestCondition) {
        return PaymentGatewayRequestFacade.getPagingList(paymentGatewayRequestCondition);
    }

    public static int add(PaymentGatewayRequest paymentGatewayRequest) {
        return PaymentGatewayRequestFacade.add(paymentGatewayRequest);
    }

    public static int update(PaymentGatewayRequest paymentGatewayRequest) {
        return PaymentGatewayRequestFacade.update(paymentGatewayRequest);
    }

    public static List<PaymentGatewayRequest> getList() {
        return PaymentGatewayRequestFacade.getList();
    }

    public static PaymentGatewayRequest getInfo(int id) {
        return PaymentGatewayRequestFacade.getInfo(id);
    }
}
