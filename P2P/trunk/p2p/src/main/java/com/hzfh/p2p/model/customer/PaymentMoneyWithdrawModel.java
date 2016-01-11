package com.hzfh.p2p.model.customer;

import java.util.ArrayList;
import java.util.List;

import com.hzfh.api.customer.model.PaymentMoneyRecharge;
import com.hzfh.api.customer.model.PaymentMoneyWithdraw;
import com.hzfh.api.customer.model.query.PaymentMoneyWithdrawCondition;
import com.hzfh.p2p.facade.customer.PaymentMoneyWithdrawFacade;
import com.hzframework.contract.PagedList;

public class PaymentMoneyWithdrawModel {
    public static PagedList<PaymentMoneyWithdraw> getPagingList(PaymentMoneyWithdrawCondition paymentMoneyWithdrawCondition) {
        return PaymentMoneyWithdrawFacade.getPagingList(paymentMoneyWithdrawCondition);
    }

    public static int add(PaymentMoneyWithdraw paymentMoneyWithdraw) {
        return PaymentMoneyWithdrawFacade.add(paymentMoneyWithdraw);
    }

    public static int update(PaymentMoneyWithdraw paymentMoneyWithdraw) {
        return PaymentMoneyWithdrawFacade.update(paymentMoneyWithdraw);
    }

    public static List<PaymentMoneyWithdraw> getList() {
        return PaymentMoneyWithdrawFacade.getList();
    }

    public static PaymentMoneyWithdraw getInfo(int id) {
        return PaymentMoneyWithdrawFacade.getInfo(id);
    }

	public static List<PaymentMoneyWithdraw> getListByCustomerNo(int customerNo) {
		List<PaymentMoneyWithdraw> paymentMoneyWithdraws = getList();
    	if (paymentMoneyWithdraws==null||paymentMoneyWithdraws.size()<=0) {
			return null;
		}

    	List<PaymentMoneyWithdraw> paymentMoneyWithdrawsByCustomerNo = new ArrayList<PaymentMoneyWithdraw>();
    	for (PaymentMoneyWithdraw paymentMoneyWithdraw : paymentMoneyWithdraws) {
			if (paymentMoneyWithdraw.getCustomerNo().equals(String.valueOf(customerNo))) {
				paymentMoneyWithdrawsByCustomerNo.add(paymentMoneyWithdraw);
			}
		}
    	return paymentMoneyWithdrawsByCustomerNo;
	}

	public static PaymentMoneyWithdraw getbySn(String sn) {
		return PaymentMoneyWithdrawFacade.getbySn(sn);
	}

	public static int updateWithdraw(PaymentMoneyWithdraw paymentMoneyWithdraw) {
		return PaymentMoneyWithdrawFacade.updateWithdraw(paymentMoneyWithdraw);
		
	}

	public static PaymentMoneyWithdraw getInfoBystateAndSn(String status, String sn) {
		return PaymentMoneyWithdrawFacade.getInfoBystateAndSn(status,sn);
	}

	public static int updateState(String state, String sn) {
		return PaymentMoneyWithdrawFacade.updateState(state,sn);
	}
}
