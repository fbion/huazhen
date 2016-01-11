package com.hzfh.p2p.model.payment;

import java.util.List;

import com.hzfh.api.payment.model.PaymentyCallbackNotify;
import com.hzfh.api.payment.model.query.PaymentyCallbackNotifyCondition;
import com.hzfh.p2p.facade.payment.PaymentyCallbackNotifyFacade;
import com.hzframework.contract.PagedList;

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
