package com.hzfh.weixin.controller.customer.ajax;

import java.sql.Timestamp;
import java.util.Date;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.baseInfo.model.LoginFailed;
import com.hzfh.api.customer.model.P2pCustomer;
import com.hzfh.weixin.controller.common.JsonBaseAction;
import com.hzfh.weixin.model.baseInfo.CaptchaModel;
import com.hzfh.weixin.model.baseInfo.SmsModel;
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
public class AjaxLoginWithCellphoneAction extends JsonBaseAction {
    private String verifyCode2;
    public String getVerifyCode2() {
		return verifyCode2;
	}

	public void setVerifyCode2(String verifyCode2) {
		this.verifyCode2 = verifyCode2;
	}

	private String isAutoLogin;
    private String telephone;
    private String smsCaptcha;
    public String getSmsCaptcha() {
		return smsCaptcha;
	}

	public void setSmsCaptcha(String smsCaptcha) {
		this.smsCaptcha = smsCaptcha;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

    public void setIsAutoLogin(String isAutoLogin) {
        this.isAutoLogin = isAutoLogin;
    }

    public String execute() {
		this.message = new Message();
    	
        if (!CharacterFilter.isVaildCellphone(telephone)){
            this.message.setType(MessageType.Error);
            this.message.setDescription("cellphoneError:" + "请填写合法的手机号");
            return SUCCESS;
        }
        
        if (!CharacterFilter.isVaildVerifyCode(verifyCode2)){
            this.message.setType(MessageType.Error);
            this.message.setDescription("validateError:" + "验证码错误，请重新输入");
            return SUCCESS;
        }
        
        if(!CharacterFilter.isVaildSmsCaptcha(this.smsCaptcha)){
        	this.message.setType(MessageType.Error);
        	this.message.setDescription("smsCaptchaError:" + "请输入6位数字的手机验证码");
        	return SUCCESS;
        }

        P2pCustomer p2pCustomer = P2pCustomerModel.getInfoByCellphone(this.telephone);
		if(p2pCustomer == null){
            this.message.setType(MessageType.Error);
            this.message.setDescription("cellphoneError:" + "您输入的手机号有误，请重新输入");
            return SUCCESS;
		}
		
		if (CaptchaModel.selectByIdAndCode(StateValues.getCaptchaKey(), verifyCode2) == null){
            this.message.setType(MessageType.Error);
            this.message.setDescription("validateError:" + "验证码错误，请重新输入");
            return SUCCESS;
        }
        CaptchaModel.delete(StateValues.getCaptchaKey());
        
		String vfCode = SmsModel.getCaptchaFromMenCache("captcha", p2pCustomer.getCellphone());
		if(StringHelper.isNullOrEmpty(vfCode)){
			this.message.setType(MessageType.Error);
        	this.message.setDescription("smsCaptchaError:" + "请重新获取手机验证码（可能已过期）");
			return SUCCESS;
		}
		if(!vfCode.equals(this.smsCaptcha)){
			this.message.setType(MessageType.Error);
        	this.message.setDescription("smsCaptchaError:" + "手机验证码不正确");
			return SUCCESS;
		}    

        if (p2pCustomer.getStatus() == 0){
            this.message.setType(MessageType.Error);
            this.message.setDescription("userError:" + "您的账号尚未激活，请联系管理员");
            return SUCCESS;
        }

        P2pCustomerModel.SetLoginInfo(p2pCustomer, Integer.valueOf(isAutoLogin) == 1);
        P2pCustomerModel.SetLoginInfo(p2pCustomer, true);

        this.message.setType(MessageType.Info);
        
        
        Date lastLoginTime = null;
        if(p2pCustomer.getCurrentLoginTime()!=null){
        	lastLoginTime = p2pCustomer.getCurrentLoginTime();
        }else{
        	lastLoginTime = DateHelper.getCurrentTime();
        }
        P2pCustomerModel.updateLastLoginTime(p2pCustomer.getId(),new Timestamp(lastLoginTime.getTime()));
    	return SUCCESS;
    }
} 
    


