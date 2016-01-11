package com.hzfh.service.customer.mapper;

import com.hzfh.api.customer.model.CustomerPersonal;
import com.hzfh.api.customer.model.query.CustomerPersonalCondition;
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


@Service("customerPersonalMapper")
public interface CustomerPersonalMapper extends BaseMapper<CustomerPersonal, CustomerPersonalCondition> {
    public List<CustomerPersonal> getMyCustomerPersonalList(@Param("workMateString") String workMateString);

    public List<CustomerPersonal> cardCheck(@Param("cardNumber")String cardNumber,@Param("id") int id,@Param("desCardNumber")String desCardNumber);

    public CustomerPersonal getCustomerByCardNumber(@Param("cardNumber") String cardNumber);

    public List<CustomerPersonal> getNoPagingList(CustomerPersonalCondition customerPersonalCondition);

    List<CustomerPersonal> checkCustomerPersonalByNameAndCellphone(@Param("id") int id, @Param("name") String name, @Param("cellPhone") String cellPhone,@Param("desCellPhone")String desCellPhone);

    public List<CustomerPersonal> getCustomerPersonalListByManagerNo(int managerNo);

    int updateTradeTotalById(@Param("id")int id, @Param("tradeTotal")double tradeTotal);

    int updateLoginByP2pCustoemrNo(@Param("p2pCustomerNo") int p2pCustomerNo);

    List<CustomerPersonal> getListForExcel(CustomerPersonalCondition customerPersonalCondition);

    CustomerPersonal getInfoByP2pCustsomerNo(@Param("p2pCustomerNo")int p2pCustomerNo);

    List<CustomerPersonal> getCurrentWeekCustomerPerson(CustomerPersonalCondition customerPersonalCondition);
}