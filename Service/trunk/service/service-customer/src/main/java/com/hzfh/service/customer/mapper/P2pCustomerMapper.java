package com.hzfh.service.customer.mapper;

import java.sql.Timestamp;

import com.hzfh.api.customer.model.P2pCustomer;
import com.hzfh.api.customer.model.query.P2pCustomerCondition;
import com.hzframework.data.mapper.BaseMapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/3/5 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("p2pCustomerMapper")
public interface P2pCustomerMapper extends BaseMapper<P2pCustomer, P2pCustomerCondition> {
	public  P2pCustomer selectByUserName(String userName);
	public  P2pCustomer selectByEmail(String email);
	public  P2pCustomer selectByEmailAndStatus(@Param("email")String email,@Param("status")byte status);
	public  String selectPswd(int id);
    public  int updateLastLoginTime(@Param("id")int id,@Param("lastLoginTime")Timestamp lastLoginTime);
    public  int updatePswdById(@Param("id")int id,@Param("password")String password);
    public  int updateEmpNoById(@Param("id")int id,@Param("empNo")int empNo);
    public  int updateStatusById(@Param("id")int id,@Param("status")byte status);
	public String selectSecretKey(int id);
	public P2pCustomer getP2pCustomerByCardNubmer(@Param("cardNumber")String cardNumber);


    public int updateP2pCustomerById(@Param("id")int id,@Param("customerNo")int customerNo);

	public int updateNotWithCardNumber(P2pCustomer p2pCustomer);
	public int updateWithCardNumber(P2pCustomer p2pCustomer);

    public P2pCustomer getP2pCustomerByCustomerNo(@Param("customerNo")int customerNo);

    public int updateDeptNoAndEmpNoById(@Param("id")int id,@Param("deptNo")int deptNo,@Param("empNo")int empNo);
	public P2pCustomer getP2pCustomerByWeixin(@Param("weixin")String  weixin);
	public int updateCellphoneByCustomerNo(@Param("cellphone")String cellphone, @Param("customerId")int customerId);
	public P2pCustomer checkTelephoneById(@Param("id")int id, @Param("telephone")String telephone);
	public int updateRealNameCustomerNo(P2pCustomer p2pCustomer);
	public P2pCustomer getInfoByCellphone(@Param("cellphone")String cellphone);
	public P2pCustomer getInfoByQq(@Param("openid")String openid);
	public P2pCustomer getInfoByWeibo(@Param("weibo")String weibo);
	public int updateWeiXin(@Param("id")int id, @Param("openId")String openId);
	
}