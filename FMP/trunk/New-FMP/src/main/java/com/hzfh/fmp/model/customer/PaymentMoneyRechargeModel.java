package com.hzfh.fmp.model.customer;

import com.hzfh.api.customer.model.PaymentMoneyRecharge;
import com.hzfh.api.customer.model.query.PaymentMoneyRechargeCondition;
import com.hzfh.fmp.facade.customer.PaymentMoneyRechargeFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class PaymentMoneyRechargeModel {
    public static PagedList<PaymentMoneyRecharge> getPagingList(PaymentMoneyRechargeCondition paymentMoneyRechargeCondition) {
        return PaymentMoneyRechargeFacade.getPagingList(paymentMoneyRechargeCondition);
    }

    public static int add(PaymentMoneyRecharge paymentMoneyRecharge) {
        return PaymentMoneyRechargeFacade.add(paymentMoneyRecharge);
    }

    public static int update(PaymentMoneyRecharge paymentMoneyRecharge) {
        return PaymentMoneyRechargeFacade.update(paymentMoneyRecharge);
    }

    public static List<PaymentMoneyRecharge> getList() {
        return PaymentMoneyRechargeFacade.getList();
    }

    public static PaymentMoneyRecharge getInfo(int id) {
        return PaymentMoneyRechargeFacade.getInfo(id);
    }
}
