package com.hzfh.p2p.model.customer;

import java.util.ArrayList;
import java.util.List;

import com.hzfh.api.customer.model.PaymentMoneyChange;
import com.hzfh.api.customer.model.PaymentMoneyWithdraw;
import com.hzfh.api.customer.model.query.PaymentMoneyChangeCondition;
import com.hzfh.p2p.facade.customer.PaymentMoneyChangeFacade;
import com.hzframework.contract.PagedList;

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

	public static List<PaymentMoneyChange> getListByCustomerNo(int customerNo) {
		List<PaymentMoneyChange> paymentMoneyChanges = getList();
    	if (paymentMoneyChanges==null||paymentMoneyChanges.size()<=0) {
			return null;
		}

    	List<PaymentMoneyChange> paymentMoneyChangesByCustomerNo = new ArrayList<PaymentMoneyChange>();
    	for (PaymentMoneyChange PaymentMoneyChange : paymentMoneyChanges) {
			if (PaymentMoneyChange.getP2pCustomerNo()==customerNo){
				paymentMoneyChangesByCustomerNo.add(PaymentMoneyChange);
			}
		}
    	return paymentMoneyChangesByCustomerNo;
	}

	public static PaymentMoneyChange getInfoByMoneyChangeTypeAndRefSn(
			byte moneyChangeType, String requestNo) {
		return PaymentMoneyChangeFacade.getInfoByMoneyChangeTypeAndRefSn(moneyChangeType,requestNo);
	}
}
