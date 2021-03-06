package com.hzfh.service.customer.dao;

import com.hzfh.api.customer.model.CustomerPersonal;
import com.hzfh.api.customer.model.query.CustomerPersonalCondition;
import com.hzframework.data.dao.BaseDao;

import java.util.List;

/*******************************************************************************
 * Copyright 2014 HZFH. All rights reserved.
 * Author: GuoZhenYu
 * Create Date: 2014/12/29
 * Description:
 * <p/>
 * Revision History:
 * Date         Author               Description
 ******************************************************************************/


public interface CustomerPersonalDao extends BaseDao<CustomerPersonal, CustomerPersonalCondition> {
    public List<CustomerPersonal> getMyCustomerPersonalList(String workMateString);

    public List<CustomerPersonal> cardCheck(String cardNumber, int id, String desCardNumber);

    public CustomerPersonal getCustomerByCardNumber(String cardNumber);

    public List<CustomerPersonal> getNoPagingList(CustomerPersonalCondition customerPersonalCondition);

    List<CustomerPersonal> checkCustomerPersonalByNameAndCellphone(int id, String name, String cellPhone, String desCellPhone);

    public List<CustomerPersonal> getCustomerPersonalListByManagerNo(int managerNo);

    int updateTradeTotalById(int id, double tradeTotal);

    int updateLoginByP2pCustoemrNo(int p2pCustomerNo);

    List<CustomerPersonal> getListForExcel(CustomerPersonalCondition customerPersonalCondition);

    CustomerPersonal getInfoByP2pCustsomerNo(int p2pCustomerNo);

    List<CustomerPersonal> getCurrentWeekCustomerPerson(CustomerPersonalCondition customerPersonalCondition);
}