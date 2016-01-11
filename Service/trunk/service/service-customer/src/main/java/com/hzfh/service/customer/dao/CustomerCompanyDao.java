package com.hzfh.service.customer.dao;

import com.hzfh.api.customer.model.CustomerCompany;
import com.hzfh.api.customer.model.query.CustomerCompanyCondition;
import com.hzframework.data.dao.BaseDao;

import java.util.List;

/**
 * ****************************************************************************
 * <p/>
 * Copyright 2014 HZFH. All rights reserved.
 * Author: GuoZhenYu
 * Create Date: 2014/12/29
 * Description:
 * <p/>
 * Revision History:
 * Date         Author               Description
 * <p/>
 * ****************************************************************************
 */


public interface CustomerCompanyDao extends BaseDao<CustomerCompany, CustomerCompanyCondition> {
    public List<CustomerCompany> getMyCustomerCompanyList(String workMateString);

    public List<CustomerCompany> cardCheck(String cardNumber, int id);

    public List<CustomerCompany> getNoPagingList(CustomerCompanyCondition customerCompanyCondition);

    public int updateCustomerNoById(int customerNo, int id);

    int updateTradeTotalById(int id, double tradeTotal);

    CustomerCompany getInfoByP2pCustomerNo(int p2pCustomerNo);

    List<CustomerCompany> getListForExcel(CustomerCompanyCondition customerCompanyCondition);
}