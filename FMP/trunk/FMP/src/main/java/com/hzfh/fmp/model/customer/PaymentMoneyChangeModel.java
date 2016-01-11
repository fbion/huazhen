package com.hzfh.fmp.model.customer;

import com.hzfh.api.customer.model.PaymentMoneyChange;
import com.hzfh.api.customer.model.query.PaymentMoneyChangeCondition;
import com.hzfh.api.payment.model.query.PaymentRefundCondition;
import com.hzfh.fmp.facade.customer.PaymentMoneyChangeFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class PaymentMoneyChangeModel {
    public static PagedList<PaymentMoneyChange> getPagingList(PaymentMoneyChangeCondition paymentMoneyChangeCondition) {
        return PaymentMoneyChangeFacade.getPagingList(paymentMoneyChangeCondition);
    }

    public static int add(PaymentMoneyChange paymentMoneyChange) {
        return PaymentMoneyChangeFacade.add(paymentMoneyChange);
    }



    public static int update(PaymentMoneyChange paymentMoneyChange) {
        return PaymentMoneyChangeFacade.update(paymentMoneyChange);
    }

    public static List<PaymentMoneyChange> getList() {
        return PaymentMoneyChangeFacade.getList();
    }

    public static PaymentMoneyChange getInfo(int id) {
        return PaymentMoneyChangeFacade.getInfo(id);
    }

    public static PaymentMoneyChange getInfoByMoneyChangeTypeAndRefSn(byte moneyChangeType, String requestNo) {
        return PaymentMoneyChangeFacade.getInfoByMoneyChangeTypeAndRefSn(moneyChangeType, requestNo);
    }
}
