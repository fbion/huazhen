package com.hzfh.p2p.model.customer;

import com.hzfh.api.customer.model.PaymentCustomerBank;
import com.hzfh.api.customer.model.query.PaymentCustomerBankCondition;
import com.hzfh.p2p.facade.customer.PaymentCustomerBankFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class PaymentCustomerBankModel {
    public static PagedList<PaymentCustomerBank> getPagingList(PaymentCustomerBankCondition paymentCustomerBankCondition) {
        return PaymentCustomerBankFacade.getPagingList(paymentCustomerBankCondition);
    }

    public static int add(PaymentCustomerBank paymentCustomerBank) {
        return PaymentCustomerBankFacade.add(paymentCustomerBank);
    }

    public static int update(PaymentCustomerBank paymentCustomerBank) {
        return PaymentCustomerBankFacade.update(paymentCustomerBank);
    }

    public static List<PaymentCustomerBank> getList() {
        return PaymentCustomerBankFacade.getList();
    }

    public static PaymentCustomerBank getInfo(int id) {
        return PaymentCustomerBankFacade.getInfo(id);
    }


	public static List<PaymentCustomerBank> getListByCustomerNo(int customerNo) {
		return PaymentCustomerBankFacade.getListByCustomerNo(customerNo);
	}

    public static int unBindCardBank(int customerNo){
        return PaymentCustomerBankFacade.unBindCardBank(customerNo);
    }


	public static List<PaymentCustomerBank> getBankByCustomerNoAndStatus(int customerNo, int status) {
		 return PaymentCustomerBankFacade.getBankByCustomerNoAndStatus(customerNo,status);
	}
}
