package com.hzfh.fmp.model.customer;

import com.hzfh.api.customer.model.PaymentAccountInformation;
import com.hzfh.api.customer.model.query.PaymentAccountInformationCondition;
import com.hzfh.fmp.facade.customer.PaymentAccountInformationFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class PaymentAccountInformationModel {
    public static PagedList<PaymentAccountInformation> getPagingList(PaymentAccountInformationCondition paymentAccountInformationCondition) {
        return PaymentAccountInformationFacade.getPagingList(paymentAccountInformationCondition);
    }

    public static int add(PaymentAccountInformation paymentAccountInformation) {
        return PaymentAccountInformationFacade.add(paymentAccountInformation);
    }

    public static int update(PaymentAccountInformation paymentAccountInformation) {
        return PaymentAccountInformationFacade.update(paymentAccountInformation);
    }

    public static List<PaymentAccountInformation> getList() {
        return PaymentAccountInformationFacade.getList();
    }

    public static PaymentAccountInformation getInfo(int id) {
        return PaymentAccountInformationFacade.getInfo(id);
    }

    public static PaymentAccountInformation getInfoByCustomerNo(int id) {
    	return PaymentAccountInformationFacade.getInfoByCustomerNo(id);
    	/*List<PaymentAccountInformation> p = PaymentAccountInformationModel.getList();
    	PaymentAccountInformation pNew = new PaymentAccountInformation();
    	if (p!=null&&p.size()>0) {
    		for (PaymentAccountInformation paymentAccountInformation : p) {
    			if (paymentAccountInformation.getCustomerNo()==id) {
    				pNew = paymentAccountInformation;
				}
    		}
		}
    	return pNew;*/
    }

	public static int updateAuthenticationTelByCustomerNo(int authenticationTel, int customerId) {
		return PaymentAccountInformationFacade.updateAuthenticationTelByCustomerNo(authenticationTel, customerId);
	}

    public static int updateMoneyAmount(double money,int customerNo){
        return PaymentAccountInformationFacade.updateMoneyAmount(money, customerNo);
    }

    public static int updateMoneyWithDarw(double money,int customerNo){
        return PaymentAccountInformationFacade.updateMoneyWithDarw(money, customerNo);
    }

    public static int updateMoneyFreeze(double money,int customerNo){
        return  PaymentAccountInformationFacade.updateMoneyFreeze(money, customerNo);
    }

}
