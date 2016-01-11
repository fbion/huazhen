package com.hzfh.service.customer.daoImpl;

import com.hzfh.api.customer.model.CustomerCompany;
import com.hzfh.api.customer.model.query.CustomerCompanyCondition;
import com.hzfh.service.customer.dao.CustomerCompanyDao;
import com.hzfh.service.customer.mapper.CustomerCompanyMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
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


@Service("customerCompanyDao")
public class CustomerCompanyDaoImpl extends BaseDaoImpl<CustomerCompany, CustomerCompanyCondition, CustomerCompanyMapper> implements CustomerCompanyDao {
    @Autowired
    private CustomerCompanyMapper customerCompanyMapper;
    @Override
    public List<CustomerCompany> getMyCustomerCompanyList(String workMateString) {
        return customerCompanyMapper.getMyCustomerCompanyList(workMateString);
    }
	@Override
	public List<CustomerCompany> cardCheck(String cardNumber, int id) {
		return customerCompanyMapper.cardCheck(cardNumber,id);
	}
	@Override
	public List<CustomerCompany> getNoPagingList(CustomerCompanyCondition customerCompanyCondition) {
		return customerCompanyMapper.getNoPagingList(customerCompanyCondition);
	}
	@Override
	public int updateCustomerNoById(int customerNo, int id) {
		return customerCompanyMapper.updateCustomerNoById(customerNo, id);
	}

	@Override
	public int updateTradeTotalById(int id, double tradeTotal) {
		return customerCompanyMapper.updateTradeTotalById(id, tradeTotal);
	}

	@Override
	public CustomerCompany getInfoByP2pCustomerNo(int p2pCustomerNo) {
		return customerCompanyMapper.getInfoByP2pCustomerNo(p2pCustomerNo);
	}

    @Override
    public List<CustomerCompany> getListForExcel(CustomerCompanyCondition customerCompanyCondition){
        return customerCompanyMapper.getListForExcel(customerCompanyCondition);
    }
}