package com.hzfh.p2p.model.customer;

import com.hzfh.api.customer.model.CustomerPersonal;
import com.hzfh.p2p.facade.customer.CustomerFacade;

public class CustomerModel {
    
	public static CustomerPersonal getCustomerByCardNumber(String  CardNumber) {
        return CustomerFacade.getCustomerByCardNumber(CardNumber);
    }

	/**
	 * 更新 自然人 累计购买金额
	 * liyh
	 * @param customerNo
	 * @param money
	 * 上午10:32:15
	 */
	public static int updatePersonalTradeTotalById(int id, double tradeTotal) {
		return CustomerFacade.updatePersonalTradeTotalById(id, tradeTotal);
	}

	/**
	 * 更新 法人 累计购买金额
	 * liyh
	 * @param customerNo
	 * @param money
	 * 上午10:32:15
	 */
	public static int updateCompanyTradeTotalById(int id, double tradeTotal) {
		return CustomerFacade.updateCompanyTradeTotalById(id, tradeTotal);
	}

}
