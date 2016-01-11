package com.hzfh.p2p.model.customer;

import java.util.ArrayList;
import java.util.List;

import com.hzfh.api.customer.model.PaymentMoneyRecharge;
import com.hzfh.api.customer.model.query.PaymentMoneyRechargeCondition;
import com.hzfh.p2p.facade.customer.PaymentMoneyRechargeFacade;
import com.hzframework.contract.PagedList;

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
    public static PaymentMoneyRecharge getbySn(String sn) {
    	return PaymentMoneyRechargeFacade.getbySn(sn);
    }
    
    public static List<PaymentMoneyRecharge> getListByCustomerNo(int customerNo){
    	return PaymentMoneyRechargeFacade.getListByCustomerNo(customerNo);
    }

	public static int updateRecharge(PaymentMoneyRecharge paymentMoneyRecharge) {
		return PaymentMoneyRechargeFacade.updateRecharge(paymentMoneyRecharge);
		
	}

	

	public static double getRechargeMoneyByCustomerNoAndStatusAndToday(
			int customerNo, String status) {
		Double rechargeMoney = PaymentMoneyRechargeFacade.getRechargeMoneyByCustomerNoAndStatusAndToday(customerNo,status);
		if(rechargeMoney!=null){
			return rechargeMoney;
		}else{
			return 0;
		}
	}

	public static PaymentMoneyRecharge getInfoByStateAndSn(String status, String sn) {
		return PaymentMoneyRechargeFacade.getInfoByStateAndSn(status,sn);
	}

	public static int updateStateBySn(String sn, String state) {
		return PaymentMoneyRechargeFacade.updateStateBySn(sn,state);
	}
}
