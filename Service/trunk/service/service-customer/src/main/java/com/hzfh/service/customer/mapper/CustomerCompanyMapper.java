package com.hzfh.service.customer.mapper;

import com.hzfh.api.customer.model.CustomerCompany;
import com.hzfh.api.customer.model.query.CustomerCompanyCondition;
import com.hzframework.data.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

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


@Service("customerCompanyMapper")
public interface CustomerCompanyMapper extends BaseMapper<CustomerCompany, CustomerCompanyCondition> {
    public List<CustomerCompany> getMyCustomerCompanyList(@Param("workMateString") String workMateString);

    public List<CustomerCompany> cardCheck(String cardNumber, int id);

    public List<CustomerCompany> getNoPagingList(CustomerCompanyCondition customerCompanyCondition);

    public int updateCustomerNoById(@Param("customerNo") int customerNo, @Param("id") int id);

    int updateTradeTotalById(@Param("id")int id, @Param("tradeTotal")double tradeTotal);

    CustomerCompany getInfoByP2pCustomerNo(@Param("p2pCustomerNo")int p2pCustomerNo);

    List<CustomerCompany> getListForExcel(CustomerCompanyCondition customerCompanyCondition);
}
