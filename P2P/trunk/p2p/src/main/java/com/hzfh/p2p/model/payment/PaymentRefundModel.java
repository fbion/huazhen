package com.hzfh.p2p.model.payment;

import java.util.List;

import com.hzfh.api.payment.model.PaymentRefund;
import com.hzfh.api.payment.model.query.PaymentRefundCondition;
import com.hzfh.p2p.facade.payment.PaymentRefundFacade;
import com.hzframework.contract.PagedList;

public class PaymentRefundModel {
    public static PagedList<PaymentRefund> getPagingList(PaymentRefundCondition paymentRefundCondition) {
        return PaymentRefundFacade.getPagingList(paymentRefundCondition);
    }

    public static int add(PaymentRefund paymentRefund) {
        return PaymentRefundFacade.add(paymentRefund);
    }

    public static int update(PaymentRefund paymentRefund) {
        return PaymentRefundFacade.update(paymentRefund);
    }

    public static List<PaymentRefund> getList() {
        return PaymentRefundFacade.getList();
    }

    public static PaymentRefund getInfo(int id) {
        return PaymentRefundFacade.getInfo(id);
    }

    public static int updateStatusById(int id,byte status){
        return PaymentRefundFacade.updateStatusById(id, status);
    }

    public static List<PaymentRefund> getInfoBySalesId(int salesId) {
        return PaymentRefundFacade.getInfoBySalesId(salesId);
    }

	public static Double getInvestmentIncome(int customerNo, byte status) {
		return PaymentRefundFacade.getInvestmentIncome(customerNo,status);
	}

	public static Double getInvestIncomeingByCustomerNo(int customerNo) {
		return PaymentRefundFacade.getInvestIncomeingByCustomerNo(customerNo);
	}
}
