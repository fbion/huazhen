package com.hzfh.fmp.model.payment;

import com.hzfh.api.payment.model.PaymentyCallbackNotify;
import com.hzfh.api.payment.model.query.PaymentyCallbackNotifyCondition;
import com.hzfh.fmp.facade.payment.PaymentyCallbackNotifyFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class PaymentyCallbackNotifyModel {
    public static PagedList<PaymentyCallbackNotify> getPagingList(PaymentyCallbackNotifyCondition paymentyCallbackNotifyCondition) {
        return PaymentyCallbackNotifyFacade.getPagingList(paymentyCallbackNotifyCondition);
    }

    public static int add(PaymentyCallbackNotify paymentyCallbackNotify) {
        return PaymentyCallbackNotifyFacade.add(paymentyCallbackNotify);
    }

    public static int update(PaymentyCallbackNotify paymentyCallbackNotify) {
        return PaymentyCallbackNotifyFacade.update(paymentyCallbackNotify);
    }

    public static List<PaymentyCallbackNotify> getList() {
        return PaymentyCallbackNotifyFacade.getList();
    }

    public static PaymentyCallbackNotify getInfo(int id) {
        return PaymentyCallbackNotifyFacade.getInfo(id);
    }
}
