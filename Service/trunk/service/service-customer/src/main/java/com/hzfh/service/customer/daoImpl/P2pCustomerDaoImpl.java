package com.hzfh.service.customer.daoImpl;

import java.sql.Timestamp;

import com.hzfh.api.customer.model.P2pCustomer;
import com.hzfh.api.customer.model.query.P2pCustomerCondition;
import com.hzfh.service.customer.dao.P2pCustomerDao;
import com.hzfh.service.customer.mapper.P2pCustomerMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;

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


@Service("p2pCustomerDao")
public class P2pCustomerDaoImpl extends BaseDaoImpl<P2pCustomer, P2pCustomerCondition, P2pCustomerMapper> implements P2pCustomerDao {
	@Autowired
    private P2pCustomerMapper p2pCustomerMapper;
	
	@Override
	public P2pCustomer selectByUserName(String userName) {
		return p2pCustomerMapper.selectByUserName(userName);
	}

	@Override
	public P2pCustomer selectByEmail(String email) {
		return p2pCustomerMapper.selectByEmail(email);
	}

	@Override
	public P2pCustomer selectByEmailAndStatus(String email, byte status) {
		return p2pCustomerMapper.selectByEmailAndStatus(email, status);
	}

	@Override
	public String selectPswd(int id) {
		return p2pCustomerMapper.selectPswd(id);
	}

	@Override
	public int updateLastLoginTime(int id,Timestamp lastLoginTime) {
		return p2pCustomerMapper.updateLastLoginTime(id,lastLoginTime);
	}

	@Override
	public int updatePswdById(int id, String password) {
		return p2pCustomerMapper.updatePswdById(id, password);
	}

	@Override
	public int updateEmpNoById(int id, int empNo) {
		return p2pCustomerMapper.updateEmpNoById(id, empNo);
	}

	@Override
	public int updateStatusById(int id, byte status) {
		return p2pCustomerMapper.updateStatusById(id, status);
	}

	@Override
	public String selectSecretKey(int id) {
		return p2pCustomerMapper.selectSecretKey(id);
	}

	@Override
	public P2pCustomer getP2pCustomerByCardNubmer(String cardNumber) {
		return p2pCustomerMapper.getP2pCustomerByCardNubmer(cardNumber);
	}
	@Override
	public P2pCustomer getP2pCustomerByWeixin(String weixin) {
		// TODO Auto-generated method stub
		return p2pCustomerMapper.getP2pCustomerByWeixin(weixin);
	}
    @Override
    public int updateP2pCustomerById(int id,int customerNo){

        return p2pCustomerMapper.updateP2pCustomerById(id,customerNo);
    }

	@Override
	public int updateNotWithCardNumber(P2pCustomer p2pCustomer) {
		// TODO Auto-generated method stub
		return p2pCustomerMapper.updateNotWithCardNumber(p2pCustomer);
	}

	@Override
	public int updateWithCardNumber(P2pCustomer p2pCustomer) {
		// TODO Auto-generated method stub
		return p2pCustomerMapper.updateWithCardNumber(p2pCustomer);
	}

    @Override
    public P2pCustomer getP2pCustomerByCustomerNo(int custoemrNo){
        return p2pCustomerMapper.getP2pCustomerByCustomerNo(custoemrNo);
    }

    @Override
    public int updateDeptNoAndEmpNoById(int id,int deptNo,int empNo){
        return p2pCustomerMapper.updateDeptNoAndEmpNoById(id,deptNo,empNo);
    }

	@Override
	public int updateCellphoneByCustomerNo(String cellphone, int customerId) {
		return p2pCustomerMapper.updateCellphoneByCustomerNo( cellphone, customerId);
	}

	@Override
	public P2pCustomer checkTelephoneById(int id, String telephone) {
		return p2pCustomerMapper.checkTelephoneById( id, telephone);
	}

	@Override
	public int updateRealNameCustomerNo(P2pCustomer p2pCustomer) {
		return p2pCustomerMapper.updateRealNameCustomerNo(p2pCustomer);
	}

	@Override
	public P2pCustomer getInfoByCellphone(String cellphone) {
		return p2pCustomerMapper.getInfoByCellphone(cellphone);
	}

	@Override
	public P2pCustomer getInfoByQq(String openid) {
		return p2pCustomerMapper.getInfoByQq(openid);
	}

	@Override
	public P2pCustomer getInfoByWeibo(String weibo) {
		return p2pCustomerMapper.getInfoByWeibo(weibo);
	}

	@Override
	public int updateWeiXin(int id, String openId) {
		return p2pCustomerMapper.updateWeiXin(id, openId);
	}

	
}