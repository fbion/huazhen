package com.hzfh.weixin.controller.customer.ajax;

import java.sql.Timestamp;
import java.util.Date;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.baseInfo.model.LoginFailed;
import com.hzfh.api.customer.model.P2pCustomer;
import com.hzfh.weixin.controller.common.JsonBaseAction;
import com.hzfh.weixin.model.baseInfo.CaptchaModel;
import com.hzfh.weixin.model.common.cache.CacheManager;
import com.hzfh.weixin.model.common.cache.CachePrefix;
import com.hzfh.weixin.model.common.helper.CharacterFilter;
import com.hzfh.weixin.model.common.helper.EncodeHelper;
import com.hzfh.weixin.model.common.properties.ParamHelper;
import com.hzfh.weixin.model.common.properties.WebInfoHelper;
import com.hzfh.weixin.model.common.state.StateValues;
import com.hzfh.weixin.model.customer.P2pCustomerModel;
import com.hzframework.helper.DateHelper;
import com.hzframework.helper.StringHelper;

/**
 * Created by paul on 15-3-14.
 */
public class AjaxLoginAction extends JsonBaseAction {
    private String verifyCode;
    private String userName;
    private String password;
    private String isAutoLogin;
    private String code;

	public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setIsAutoLogin(String isAutoLogin) {
        this.isAutoLogin = isAutoLogin;
    }

    public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	private P2pCustomer p2pCustomer;//p2p客户对象
    public void setP2pCustomer(String p2pCustomer) {
        this.p2pCustomer = JSON.parseObject(p2pCustomer, P2pCustomer.class);
    }
    
	public P2pCustomer getP2pCustomer() {
		return p2pCustomer;
	}
	@Override
    public String execute() {
        this.message = new Message();
        this.password = EncodeHelper.decryptBASE64(this.password);
        int needVerifyCode = 0;
        Object obj = CacheManager.get(CachePrefix.LOGIN_FAILED_COUNT_PREFIX, userName);

        int loginCount = 0;
        if (obj != null)
            loginCount = (Integer)obj;
 
        if (loginCount >= ParamHelper.LOGIN_FAILED_COUNT) {
            if (!CharacterFilter.isVaildVerifyCode(verifyCode)) {
                needVerifyCode = setLoginFailedCount(userName, ++loginCount);
                this.message.setType(MessageType.Error);
                this.message.setDescription("validateError:" + "验证码错误，请重新输入" + ":"+ String.valueOf(needVerifyCode));
                return SUCCESS;
            }

            if (CaptchaModel.selectByIdAndCode(StateValues.getCaptchaKey(), verifyCode) == null) {
                needVerifyCode = setLoginFailedCount(userName, ++loginCount);
                this.message.setType(MessageType.Error);
                this.message.setDescription("validateError:" + "验证码错误，请重新输入" + ":"+ String.valueOf(needVerifyCode));
                return SUCCESS;
            }

            CaptchaModel.delete(StateValues.getCaptchaKey());
        }

        if (!CharacterFilter.isVaildLoginName(userName))//正则验证
        {
            needVerifyCode = setLoginFailedCount(userName, ++loginCount);
            this.message.setType(MessageType.Error);
            this.message.setDescription("userError:" + "请填写合法的用户名，4-20位字符（限字母、数字的组合）" + ":" + String.valueOf(needVerifyCode));
            insertLoginFailedCount(this.userName, this.password);
            return SUCCESS;
        }

        P2pCustomer p2pCustomer = P2pCustomerModel.selectByUserName(this.userName);

       //可使用用户名，手机号，邮箱登陆
        if (p2pCustomer == null) {
        	p2pCustomer = P2pCustomerModel.selectByEmail(this.userName);
        	if(p2pCustomer == null){
        		p2pCustomer = P2pCustomerModel.getInfoByCellphone(this.userName);
        		if(p2pCustomer == null){
        			needVerifyCode = setLoginFailedCount(userName, ++loginCount);
        			
        			this.message.setType(MessageType.Error);
        			this.message.setDescription("userError:" + "您输入的用户名有误，请确认后再次输入" + ":" + String.valueOf(needVerifyCode));
        			insertLoginFailedCount(this.userName, this.password);
        			return SUCCESS;
        		}
        	}
        }
        if(StringHelper.isNullOrEmpty(p2pCustomer.getPassword())){
        	this.message.setType(MessageType.Error);
            this.message.setDescription("userError:" + "用户未设置密码，请用手机号与验证码登陆" + ":" + String.valueOf(needVerifyCode));
            insertLoginFailedCount(this.userName, this.password);
            return SUCCESS;
        }
        /*if (p2pCustomer.getStatus() == 0){
            needVerifyCode = setLoginFailedCount(userName, ++loginCount);

            this.message.setType(MessageType.Error);
            this.message.setDescription("userError:" + "您的账号还未进行邮箱验证，请登录您注册时使用的邮箱验证后再次登录" + ":" + String.valueOf(needVerifyCode));

            return SUCCESS;
        }*/


        String pwd = EncodeHelper.encryptPWD(p2pCustomer.getUserName(),this.password,p2pCustomer.getSecretKey());

        if (!p2pCustomer.getPassword().equals(pwd)) {
            needVerifyCode = setLoginFailedCount(userName, ++loginCount);

            this.message.setType(MessageType.Error);
            this.message.setDescription("userError:" + "您输入的用户名或密码有误，请确认后再次输入" + ":" + String.valueOf(needVerifyCode));
            insertLoginFailedCount(this.userName, this.password);
            return SUCCESS;
        }
        
        setLoginFailedCount(userName, 0);

        P2pCustomerModel.SetLoginInfo(p2pCustomer, Integer.valueOf(isAutoLogin) == 1);

        this.message.setType(MessageType.Info);

        /*P2pCustomerModel.updateLastLoginTime(p2pCustomer.getId());*/

        Date lastLoginTime = null;
        if(p2pCustomer.getCurrentLoginTime()!=null){
        	lastLoginTime = p2pCustomer.getCurrentLoginTime();
        }else{
        	lastLoginTime = DateHelper.getCurrentTime();
        }
        P2pCustomerModel.updateLastLoginTime(p2pCustomer.getId(),new Timestamp(lastLoginTime.getTime()));
        return SUCCESS;
    }
	private int setLoginFailedCount(String userName, int loginCount) {
    	int needVerifyCode = loginCount >= ParamHelper.LOGIN_FAILED_COUNT ? 1 : 0;
        CacheManager.set(CachePrefix.LOGIN_FAILED_COUNT_PREFIX, userName, 60 * 3, loginCount);
        return needVerifyCode;
    }

    private void insertLoginFailedCount(String userName, String password) {
        LoginFailed loginFailed = new LoginFailed();
        loginFailed.setSite(WebInfoHelper.WEB_P2P_WWW);
        loginFailed.setUserName(userName);
        loginFailed.setPassword(password);
        loginFailed.setIp(this.getIp());
    }
    
}


