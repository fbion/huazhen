package com.hzfh.service.workFlow.model.customer;

import com.hzfh.api.customer.model.CustomerCompany;
import com.hzfh.api.customer.model.query.CustomerCompanyCondition;
import com.hzfh.service.workFlow.facade.customer.CustomerCompanyFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class CustomerCompanyModel {
    public static PagedList<CustomerCompany> getPagingList(CustomerCompanyCondition customerCompanyCondition) {
        return CustomerCompanyFacade.getPagingList(customerCompanyCondition);
    }

    public static int add(CustomerCompany customerCompany) {
        return CustomerCompanyFacade.add(customerCompany);
    }

    public static int update(CustomerCompany customerCompany) {
        return CustomerCompanyFacade.update(customerCompany);
    }

    public static List<CustomerCompany> getList() {
        return CustomerCompanyFacade.getList();
    }

    public static CustomerCompany getInfo(int id) {
        return CustomerCompanyFacade.getInfo(id);
    }

    public static List<CustomerCompany> getMyCustomerCompanyList(String workMateString){
        return CustomerCompanyFacade.getMyCustomerCompanyList(workMateString);
    }

	public static List<CustomerCompany> cardCheck(String cardNumber,int id) {
		return CustomerCompanyFacade.cardCheck(cardNumber, id);
	}
	
	//create by Zorro 2014/4/30
	public static List<CustomerCompany> getNoPagingList(CustomerCompanyCondition customerCompanyCondition) {
        return CustomerCompanyFacade.getNoPagingList(customerCompanyCondition);
    }


	public static int updateCustomerNoById(int customerNo, int id) {
		return CustomerCompanyFacade.updateCustomerNoById(customerNo, id);
	}

    public static int updateTradeTotalById(int id, double tradeTotal){
        return CustomerCompanyFacade.updateTradeTotalById(id, tradeTotal);
    }

    public static CustomerCompany getInfoByP2pCustomerNo(int p2pCustomerNo){
        return CustomerCompanyFacade.getInfoByP2pCustomerNo(p2pCustomerNo);
    }
	
	
	
	
	
	
	
}
