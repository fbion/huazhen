package com.hzfh.weixin.model.customer;

import com.hzfh.api.customer.model.P2pCustomer;
import com.hzfh.api.customer.model.query.P2pCustomerCondition;
import com.hzfh.weixin.facade.customer.P2pCustomerFacade;
import com.hzfh.weixin.model.common.cache.CacheManager;
import com.hzfh.weixin.model.common.cache.CachePrefix;
import com.hzfh.weixin.model.common.helper.EncodeHelper;
import com.hzfh.weixin.model.common.properties.ParamHelper;
import com.hzfh.weixin.model.common.state.StateValues;
import com.hzfh.weixin.model.common.view.LoginInfo;
import com.hzframework.contract.PagedList;

import java.sql.Timestamp;
import java.util.List;

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
    public static P2pCustomer getP2pCustomerByWeixin(String weixin) {
		return P2pCustomerFacade.getP2pCustomerByWeixin(weixin);
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
    public static P2pCustomer selectByEmailAndStatus(String email,byte status){
    	return P2pCustomerFacade.selectByEmailAndStatus(email,status);
    }


    public static void SetLoginInfo(P2pCustomer p2pCustomer, boolean isAutoLogin) {
    	long timestamp= System.currentTimeMillis();
        String loginKey = EncodeHelper.encryptPWD(String.valueOf(p2pCustomer.getId()),p2pCustomer.getUserName(),String.valueOf(timestamp));
        
        if (isAutoLogin) {
            StateValues.setCustomerId(p2pCustomer.getId());
            StateValues.setUserName(p2pCustomer.getUserName());
            StateValues.setLoginTime(timestamp);
            StateValues.setLoginKey(loginKey);
        }

        LoginInfo loginInfo = new LoginInfo();

        loginInfo.setUserName(p2pCustomer.getUserName());
        loginInfo.setP2pCustomerId(p2pCustomer.getId());
        loginInfo.setP2pCustomer(p2pCustomer);

        if (isAutoLogin) {
            CacheManager.set(CachePrefix.LOGIN_INFO_PREFIX,loginKey, ParamHelper.AUTO_LOGIN_DAYS * 24 * 60 * 60,loginInfo);
        } else{
            CacheManager.set(CachePrefix.LOGIN_INFO_PREFIX,loginKey, ParamHelper.DEFAULT_LOGIN_HOURS * 60 * 60,loginInfo);
        }
    }

    public static void Logout() {
        CacheManager.remove(CachePrefix.LOGIN_INFO_PREFIX, StateValues.getLoginKey());
        StateValues.cleanLoginCookie();
    }
    public static int  updateNotWithCardNumber(P2pCustomer p2pCustomer){
    	return P2pCustomerFacade.updateNotWithCardNumber(p2pCustomer);
    }
    public static int  updateWithCardNumber(P2pCustomer p2pCustomer){
    	return P2pCustomerFacade.updateWithCardNumber(p2pCustomer);
    }

	public static P2pCustomer getInfoByCellphone(String callPhone) {
		return P2pCustomerFacade.getInfoByCellphone(callPhone);
	}
	
	public static int updateCellphoneByCustomerNo(String cellphone,
			int customerId) {
		return P2pCustomerFacade.updateCellphoneByCustomerNo(cellphone,customerId);
	}

	public static P2pCustomer checkTelephoneById(int id, String telephone) {
		return P2pCustomerFacade.checkTelephoneById(id,telephone);
	}

	public static int updateWeiXin(int id, String openId) {
		return P2pCustomerFacade.updateWeiXin(id,openId);
	}

	
}
