package com.hzfh.weixin.model.customer;

import com.hzfh.api.customer.model.CustomerPersonal;
import com.hzfh.weixin.facade.customer.CustomerFacade;

public class CustomerModel {
    
	public static CustomerPersonal getCustomerByCardNumber(String  CardNumber) {
        return CustomerFacade.getCustomerByCardNumber(CardNumber);
    }
  
}
