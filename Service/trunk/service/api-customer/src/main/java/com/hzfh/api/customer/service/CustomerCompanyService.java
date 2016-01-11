package com.hzfh.api.customer.service;

import com.hzfh.api.customer.model.CustomerCompany;
import com.hzfh.api.customer.model.query.CustomerCompanyCondition;
import com.hzframework.data.service.BaseService;

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


public interface CustomerCompanyService extends BaseService<CustomerCompany, CustomerCompanyCondition> {
    public List<CustomerCompany> getMyCustomerCompanyList(String workMateString);

    public List<CustomerCompany> cardCheck(String cardNumber, int id);

    public List<CustomerCompany> getNoPagingList(CustomerCompanyCondition customerCompanyCondition);

    public int updateCustomerNoById(int customerNo, int id);

    int updateTradeTotalById(int id, double tradeTotal);

    CustomerCompany getInfoByP2pCustomerNo(int p2pCustomerNo);

    public List<CustomerCompany> getListForExcel(CustomerCompanyCondition customerCompanyCondition);
}