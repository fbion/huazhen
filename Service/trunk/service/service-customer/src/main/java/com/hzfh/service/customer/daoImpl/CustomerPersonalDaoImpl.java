package com.hzfh.service.customer.daoImpl;

import com.hzfh.api.customer.model.CustomerPersonal;
import com.hzfh.api.customer.model.query.CustomerPersonalCondition;
import com.hzfh.service.customer.dao.CustomerPersonalDao;
import com.hzfh.service.customer.mapper.CustomerPersonalMapper;
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


@Service("customerPersonalDao")
public class CustomerPersonalDaoImpl extends BaseDaoImpl<CustomerPersonal, CustomerPersonalCondition, CustomerPersonalMapper> implements CustomerPersonalDao {
    @Autowired
    private CustomerPersonalMapper customerPersonalMapper;
    @Override
    public List<CustomerPersonal> getMyCustomerPersonalList(String workMateString) {
        return customerPersonalMapper.getMyCustomerPersonalList(workMateString);
    }
	@Override
	public List<CustomerPersonal> cardCheck(String cardNumber, int id,String desCardNumber) {
		return customerPersonalMapper.cardCheck(cardNumber, id,desCardNumber);
	}
	@Override
	public CustomerPersonal getCustomerByCardNumber(String cardNumber) {
		return customerPersonalMapper.getCustomerByCardNumber(cardNumber);
	}
	@Override
	public List<CustomerPersonal> getNoPagingList(CustomerPersonalCondition customerPersonalCondition) {
		return customerPersonalMapper.getNoPagingList(customerPersonalCondition);
	}

	@Override
	public List<CustomerPersonal> checkCustomerPersonalByNameAndCellphone(int id,String name, String cellPhone,String desCellPhone) {
		return customerPersonalMapper.checkCustomerPersonalByNameAndCellphone(id, name, cellPhone,desCellPhone);
	}
	@Override
	public List<CustomerPersonal> getCustomerPersonalListByManagerNo(int managerNo) {
		return customerPersonalMapper.getCustomerPersonalListByManagerNo(managerNo);
	}

	@Override
	public int updateTradeTotalById(int id, double tradeTotal) {
		return customerPersonalMapper.updateTradeTotalById(id, tradeTotal);
	}
    @Override
    public int updateLoginByP2pCustoemrNo(int p2pCustomerNo) {
        return customerPersonalMapper.updateLoginByP2pCustoemrNo(p2pCustomerNo);
    }
    @Override
    public List<CustomerPersonal> getListForExcel(CustomerPersonalCondition customerPersonalCondition){
        return customerPersonalMapper.getListForExcel(customerPersonalCondition);
    }

	@Override
	public CustomerPersonal getInfoByP2pCustsomerNo(int p2pCustomerNo) {
		return customerPersonalMapper.getInfoByP2pCustsomerNo(p2pCustomerNo);
	}

	@Override
	public List<CustomerPersonal> getCurrentWeekCustomerPerson(CustomerPersonalCondition customerPersonalCondition) {
		return customerPersonalMapper.getCurrentWeekCustomerPerson(customerPersonalCondition);
	}
}
