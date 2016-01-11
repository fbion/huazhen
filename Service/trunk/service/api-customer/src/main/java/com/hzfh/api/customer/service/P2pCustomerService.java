package com.hzfh.api.customer.service;

import java.sql.Timestamp;

import com.hzfh.api.customer.model.P2pCustomer;
import com.hzfh.api.customer.model.query.P2pCustomerCondition;
import com.hzframework.data.service.BaseService;

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


public interface P2pCustomerService extends BaseService<P2pCustomer, P2pCustomerCondition> {
	public  P2pCustomer selectByUserName(String userName);
	public  P2pCustomer selectByEmail(String email);
	public  P2pCustomer selectByEmailAndStatus(String email,byte status);
	public  String selectPswd(int id);
    public  int updateLastLoginTime(int id,Timestamp lastLoginTime);
    public  int updatePswdById(int id,String password);
    public  int updateEmpNoById(int id,int empNo);
    public  int updateStatusById(int id,byte status);
	public String selectSecretKey(int id);
	public P2pCustomer getP2pCustomerByCardNubmer(String cardNumber);

    public int updateP2pCustomerById(int id,int customerNo);

	public int updateNotWithCardNumber(P2pCustomer p2pCustomer);
	public int updateWithCardNumber(P2pCustomer p2pCustomer);

    public P2pCustomer getP2pCustomerByCustomerNo(int custoemrNo);

    public int updateDeptNoAndEmpNoById(int id,int deptNo,int empNo);
	public P2pCustomer getP2pCustomerByWeixin(String weixin);
	public int updateCellphoneByCustomerNo(String cellphone, int customerId);
	public P2pCustomer checkTelephoneById(int id, String telephone);
	public int updateRealNameCustomerNo(P2pCustomer p2pCustomer);
	public P2pCustomer getInfoByCellphone(String cellphone);
	public P2pCustomer getInfoByQq(String openid);
	public P2pCustomer getInfoByWeibo(String weibo);
	public int updateWeiXin(int id, String openId);


}