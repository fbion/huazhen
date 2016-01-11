package com.hzfh.service.customer.serviceImpl;

import java.sql.Timestamp;

import com.hzfh.api.customer.model.P2pCustomer;
import com.hzfh.api.customer.model.query.P2pCustomerCondition;
import com.hzfh.api.customer.service.P2pCustomerService;
import com.hzfh.service.customer.dao.P2pCustomerDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
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


@Service("p2pCustomerService")
public class P2pCustomerServiceImpl extends BaseServiceImpl<P2pCustomer, P2pCustomerCondition, P2pCustomerDao> implements P2pCustomerService {
	@Autowired
    private P2pCustomerDao p2pCustomerDao;
	@Override
	public P2pCustomer selectByUserName(String userName) {
		return p2pCustomerDao.selectByUserName(userName);
	}
	@Override
	public P2pCustomer selectByEmail(String email) {
		return p2pCustomerDao.selectByEmail(email);
	}
	@Override
	public P2pCustomer selectByEmailAndStatus(String email, byte status) {
		return p2pCustomerDao.selectByEmailAndStatus(email, status);
	}
	@Override
	public String selectPswd(int id) {
		return p2pCustomerDao.selectPswd(id);
	}
	@Override
	public int updateLastLoginTime(int id,Timestamp lastLoginTime) {
		return p2pCustomerDao.updateLastLoginTime(id,lastLoginTime);
	}
	@Override
	public int updatePswdById(int id, String password) {
		return p2pCustomerDao.updatePswdById(id, password);
	}
	@Override
	public int updateEmpNoById(int id, int empNo) {
		return p2pCustomerDao.updateEmpNoById(id, empNo);
	}
	@Override
	public int updateStatusById(int id, byte status) {
		return p2pCustomerDao.updateStatusById(id, status);
	}
	@Override
	public String selectSecretKey(int id) {
		return p2pCustomerDao.selectSecretKey(id);
	}

	public P2pCustomer getP2pCustomerByCardNubmer(String cardNumber) {
		return p2pCustomerDao.getP2pCustomerByCardNubmer(cardNumber);
	}


    public int updateP2pCustomerById(int id,int customerNo){
        return p2pCustomerDao.updateP2pCustomerById(id,customerNo);
    }


	public int updateNotWithCardNumber(P2pCustomer p2pCustomer) {
		return p2pCustomerDao.updateNotWithCardNumber(p2pCustomer);
	}

	public int updateWithCardNumber(P2pCustomer p2pCustomer) {
        return p2pCustomerDao.updateWithCardNumber(p2pCustomer);
    }

    public P2pCustomer getP2pCustomerByCustomerNo(int custoemrNo){
        return p2pCustomerDao.getP2pCustomerByCustomerNo(custoemrNo);
    }

    public int updateDeptNoAndEmpNoById(int id,int deptNo,int empNo){
        return p2pCustomerDao.updateDeptNoAndEmpNoById(id,deptNo,empNo);
    }
	public P2pCustomer getP2pCustomerByWeixin(String weixin) {
		return p2pCustomerDao.getP2pCustomerByWeixin(weixin);
	}
	@Override
	public int updateCellphoneByCustomerNo(String cellphone, int customerId) {
		return p2pCustomerDao.updateCellphoneByCustomerNo( cellphone, customerId);
	}
	@Override
	public P2pCustomer checkTelephoneById(int id, String telephone) {
		return p2pCustomerDao.checkTelephoneById(id, telephone);
	}
	@Override
	public int updateRealNameCustomerNo(P2pCustomer p2pCustomer) {
		return p2pCustomerDao.updateRealNameCustomerNo(p2pCustomer);
	}
	@Override
	public P2pCustomer getInfoByCellphone(String cellphone) {
		return p2pCustomerDao.getInfoByCellphone(cellphone);
	}
	@Override
	public P2pCustomer getInfoByQq(String openid) {
		return p2pCustomerDao.getInfoByQq(openid);
	}
	@Override
	public P2pCustomer getInfoByWeibo(String weibo) {
		return p2pCustomerDao.getInfoByWeibo(weibo);
	}
	@Override
	public int updateWeiXin(int id, String openId) {
		return p2pCustomerDao.updateWeiXin(id,openId);
	}
}