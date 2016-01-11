package com.hzfh.weixin.controller.customer;

import weixin.pojo.WeiXinOauth2Token;
import weixin.util.AdvancedUtil;
import weixin.util.Constant;

import com.hzfh.weixin.controller.common.CommonAction;
import com.hzfh.weixin.model.common.AuthenticationModel;
import com.hzfh.weixin.model.common.PageAlias;
import com.hzfh.weixin.model.common.cache.CacheManager;
import com.hzfh.weixin.model.common.cache.CachePrefix;
import com.hzfh.weixin.model.common.state.StateValues;
import com.hzfh.weixin.model.customer.P2pCustomerModel;
import com.hzframework.helper.StringHelper;

/**
 * Created by paul on 15-2-5.
 */
public class RegisterAction extends CommonAction{
    private String captchaUrl;
    public String getCaptchaUrl() {
        return captchaUrl;
    }


	private String inviterNo;
    public String getInviterNo() {
		return inviterNo;
	}

	public void setInviterNo(String inviterNo) {
		this.inviterNo = inviterNo;
	}
	private String redirectUrl;

    public String getRedirectUrl() {
        return redirectUrl;
    }
	private String phoneNo;
	
	public String getPhoneNo() {
		return phoneNo;
	}
    private String activityId;

	public String getActivityId() {
		return activityId;
	}

	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}

	private String code;
	
    public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String execute(){
        this.setPageAlias(PageAlias.register);
        if(!StringHelper.isNullOrEmpty(inviterNo)){
        	String [] arrparam = inviterNo.split(",");
        	inviterNo = arrparam[0];
        	activityId = arrparam[1];
            //根据用户id查询用户信息 inviterNo
            if(inviterNo !=null){
            	phoneNo = P2pCustomerModel.getInfo(Integer.parseInt(inviterNo)).getCellphone();
            }
        }
        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;
        this.captchaUrl = this.buildWWWSiteUrl(PageAlias.captcha);
        this.redirectUrl = this.buildWWWSiteUrl(PageAlias.registerSuccess);
        //this.showLoginUrl = false;
        return SUCCESS;
	}
    
    public String newRegister(){
    	this.setPageAlias(PageAlias.newRegister);
    	String ret = super.execute();
    	if (!ret.equals(SUCCESS))
            return ret;
    	
    	
    	this.captchaUrl = this.buildWWWSiteUrl(PageAlias.captcha);
    	this.redirectUrl = this.buildWWWSiteUrl(PageAlias.registerSuccess);
    	if(!StringHelper.isNullOrEmpty(code)){
    		WeiXinOauth2Token weiXinOauth2Token = AdvancedUtil.getOauthAccessToken(Constant.APPID,Constant.APPSECRET, code);
    		String openId = weiXinOauth2Token.getOpenId();
			String number = StateValues.getWXOpenId();
			if(!StringHelper.isNullOrEmpty(openId)){
				if(!openId.equals(number)){
					StateValues.setWXOpenId(openId);
				}
			}
			/*if(!StringHelper.isNullOrEmpty(openId)&&!StringHelper.isNullOrEmpty(number)){
				if(!openId.equals(number)){
					StateValues.setWXOpenId(openId);
				}
			}*/
    		System.out.println(openId);////////////////////
    	}
    	if(AuthenticationModel.getCustomerId()!=0){
    		return "INDEX";
    	}
    	return SUCCESS;
    }
}
