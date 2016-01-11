package com.hzfh.p2p.model.customer;

import java.sql.Timestamp;
import java.util.List;

import com.hzfh.api.customer.model.P2pCustomer;
import com.hzfh.api.customer.model.query.P2pCustomerCondition;
import com.hzfh.p2p.facade.customer.P2pCustomerFacade;
import com.hzfh.p2p.model.common.cache.CacheManager;
import com.hzfh.p2p.model.common.cache.CachePrefix;
import com.hzfh.p2p.model.common.helper.EncodeHelper;
import com.hzfh.p2p.model.common.properties.ParamHelper;
import com.hzfh.p2p.model.common.state.StateValues;
import com.hzfh.p2p.model.common.view.LoginInfo;
import com.hzframework.contract.PagedList;

public class P2pCustomerModel {
    public static PagedList<P2pCustomer> getPagingList(P2pCustomerCondition p2pCustomerCondition) {
        return P2pCustomerFacade.getPagingList(p2pCustomerCondition);
    }

    public static int add(P2pCustomer p2pCustomer) {
        return P2pCustomerFacade.add(p2pCustomer);
    }

    public static int update(P2pCustomer p2pCustomer) {
        return P2pCustomerFacade.update(p2pCustomer);
    }

    public static List<P2pCustomer> getList() {
        return P2pCustomerFacade.getList();
    }

    public static P2pCustomer getInfo(int id) {
        return P2pCustomerFacade.getInfo(id);
    }
    public static P2pCustomer getP2pCustomerByCardNubmer(String cardNumber) {
    	return P2pCustomerFacade.getP2pCustomerByCardNubmer(cardNumber);
    }
    
    public static P2pCustomer selectByUserName(String userName){
    	return P2pCustomerFacade.selectByUserName(userName);
    }
    public static int updateLastLoginTime(int id,Timestamp lastLoginTime){
    	return P2pCustomerFacade.updateLastLoginTime(id,lastLoginTime);
    }
    public static int updatePswdById(int id,String password){
    	return P2pCustomerFacade.updatePswdById(id,password);
    }
    public static String selectPswd(int id){
    	return P2pCustomerFacade.selectPswd(id);
    }
    public static String selectSecretKey(int id){
    	return P2pCustomerFacade.selectSecretKey(id);
    }
    public static int updateEmpNoById(int id,int empNo){
    	return P2pCustomerFacade.updateEmpNoById(id,empNo);
    }
    public static int updateStatusById(int id,byte status){
    	return P2pCustomerFacade.updateStatusById(id,status);
    }
    public static P2pCustomer selectByEmail(String email){
    	return P2pCustomerFacade.selectByEmail(email);
    }
    public static P2pCustomer getInfoByCellphone(String cellphone){
    	return P2pCustomerFacade.getInfoByCellphone(cellphone);
    }
    public static P2pCustomer selectByEmailAndStatus(String email,byte status){
    	return P2pCustomerFacade.selectByEmailAndStatus(email,status);
    }


    public static void SetLoginInfo(P2pCustomer p2pCustomer, boolean isAutoLogin) {
        Long timeStamp = System.currentTimeMillis();
        String loginKey = EncodeHelper.encryptPWD(String.valueOf(p2pCustomer.getId()), p2pCustomer.getUserName(),String.valueOf(timeStamp));
        
        //2015-11-17  hujie  以下注释部分意义不明
//        if (isAutoLogin) {
//            StateValues.setCustomerId(p2pCustomer.getId());
//            StateValues.setUserName(p2pCustomer.getUserName());
//            StateValues.setLoginTime(timeStamp);
//            StateValues.setLoginKey(loginKey);
//        } else {
            StateValues.setCustomerId(p2pCustomer.getId());
            StateValues.setUserName(p2pCustomer.getUserName());
            StateValues.setLoginTime(timeStamp);
            StateValues.setLoginKey(loginKey);
//        }

        LoginInfo loginInfo = new LoginInfo();

        loginInfo.setUserName(p2pCustomer.getUserName());
        loginInfo.setP2pCustomerId(p2pCustomer.getId());
        loginInfo.setP2pCustomer(p2pCustomer);

        if (isAutoLogin) {
            CacheManager.set(CachePrefix.LOGIN_INFO_PREFIX,loginKey, ParamHelper.AUTO_LOGIN_DAYS * 24 * 60 * 60,loginInfo);
        } else
            CacheManager.set(CachePrefix.LOGIN_INFO_PREFIX, loginKey, ParamHelper.DEFAULT_LOGIN_HOURS * 60 * 60, loginInfo);
    }

   public static void Logout() {
        CacheManager.remove(CachePrefix.LOGIN_INFO_PREFIX, StateValues.getLoginKey());
        StateValues.cleanLoginCookie();
    }
    /*public static void Logout() {
        CacheManager.remove(CachePrefix.LOGIN_INFO_PREFIX, StateValues.getLoginKey());
        StateValues.cleanAllLoginCookie();
    }*/
    public static int  updateNotWithCardNumber(P2pCustomer p2pCustomer){
    	return P2pCustomerFacade.updateNotWithCardNumber(p2pCustomer);
    }
    public static int  updateWithCardNumber(P2pCustomer p2pCustomer){
    	return P2pCustomerFacade.updateWithCardNumber(p2pCustomer);
    }

	public static int updateCellphoneByCustomerNo(String cellphone,
			int customerId) {
		return P2pCustomerFacade.updateCellphoneByCustomerNo(cellphone,customerId);
	}

	public static P2pCustomer checkTelephoneById(int id, String telephone) {
		return P2pCustomerFacade.checkTelephoneById(id,telephone);
	}

	public static int updateRealNameCustomerNo(P2pCustomer p2pCustomer) {
		return P2pCustomerFacade.updateRealNameCustomerNo(p2pCustomer);
		
	}

	public static P2pCustomer getInfoByQq(String openid) {
		return P2pCustomerFacade.getInfoByQq(openid);
	}

	public static P2pCustomer getInfoByWeibo(String weibo) {
		return P2pCustomerFacade.getInfoByWeibo(weibo);
	}
}
