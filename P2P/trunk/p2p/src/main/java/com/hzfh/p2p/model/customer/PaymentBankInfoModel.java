package com.hzfh.p2p.model.customer;

import java.util.List;

import com.hzfh.api.customer.model.PaymentBankInfo;
import com.hzfh.api.customer.model.query.PaymentBankInfoCondition;
import com.hzfh.p2p.facade.customer.PaymentBankInfoFacade;
import com.hzframework.contract.PagedList;

public class PaymentBankInfoModel {
    public static PagedList<PaymentBankInfo> getPagingList(PaymentBankInfoCondition paymentBankInfoCondition) {
        return PaymentBankInfoFacade.getPagingList(paymentBankInfoCondition);
    }

    public static int add(PaymentBankInfo paymentBankInfo) {
        return PaymentBankInfoFacade.add(paymentBankInfo);
    }

    public static int update(PaymentBankInfo paymentBankInfo) {
        return PaymentBankInfoFacade.update(paymentBankInfo);
    }

    public static List<PaymentBankInfo> getList() {
        return PaymentBankInfoFacade.getList();
    }

    public static PaymentBankInfo getInfo(int id) {
        return PaymentBankInfoFacade.getInfo(id);
    }

	public static PaymentBankInfo getBankByBankCode(String code) {
		return PaymentBankInfoFacade.getBankByBankCode(code);
	}

	public static List<PaymentBankInfo> getListByStatus(int enable) {
		return PaymentBankInfoFacade.getListByStatus(enable);
	}
}
