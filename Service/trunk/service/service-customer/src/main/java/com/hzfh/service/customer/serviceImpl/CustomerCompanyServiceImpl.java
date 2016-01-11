package com.hzfh.service.customer.serviceImpl;

import com.hzfh.api.customer.model.CustomerCompany;
import com.hzfh.api.customer.model.query.CustomerCompanyCondition;
import com.hzfh.api.customer.service.CustomerCompanyService;
import com.hzfh.service.customer.dao.CustomerCompanyDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*******************************************************************************
 * 
 * Copyright 2014 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2014/12/29 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("customerCompanyService")
public class CustomerCompanyServiceImpl extends BaseServiceImpl<CustomerCompany, CustomerCompanyCondition, CustomerCompanyDao> implements CustomerCompanyService {
    @Autowired
    private CustomerCompanyDao customerCompanyDao;
    @Override
    public List<CustomerCompany> getMyCustomerCompanyList(String workMateString) {
        return customerCompanyDao.getMyCustomerCompanyList(workMateString);
    }
	@Override
	public List<CustomerCompany> cardCheck(String cardNumber,int id) {
		return customerCompanyDao.cardCheck(cardNumber,id);
	}
	@Override
	public List<CustomerCompany> getNoPagingList(CustomerCompanyCondition customerCompanyCondition) {
		return customerCompanyDao.getNoPagingList(customerCompanyCondition);
	}
	@Override
	public int updateCustomerNoById(int customerNo, int id) {
		return customerCompanyDao.updateCustomerNoById(customerNo,id);
	}

	@Override
	public int updateTradeTotalById(int id, double tradeTotal) {
		return customerCompanyDao.updateTradeTotalById(id, tradeTotal);
	}

	@Override
	public CustomerCompany getInfoByP2pCustomerNo(int p2pCustomerNo) {
		return customerCompanyDao.getInfoByP2pCustomerNo(p2pCustomerNo);
	}

    @Override
    public List<CustomerCompany> getListForExcel(CustomerCompanyCondition customerCompanyCondition){
        return customerCompanyDao.getListForExcel(customerCompanyCondition);
    }
}
