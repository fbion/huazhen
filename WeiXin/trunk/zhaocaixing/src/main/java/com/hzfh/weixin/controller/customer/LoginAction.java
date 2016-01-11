package com.hzfh.weixin.controller.customer;

import com.hzfh.weixin.controller.common.CommonAction;
import com.hzfh.weixin.model.common.PageAlias;
import com.hzfh.weixin.model.common.state.StateValues;
import com.hzframework.helper.StringHelper;
import com.hzframework.web.cookie.CookieManager;
import com.hzframework.web.cookie.config.Cookie;
import com.opensymphony.xwork2.ActionContext;

/**
 * Created by paul on 15-2-5.
 */
public class LoginAction extends CommonAction {
    private String captchaUrl;
    
    public String getCaptchaUrl() {
        return captchaUrl;
    }
    private String redirectUrl;

    public String getRedirectUrl() {
        return redirectUrl;
    }

    private String returnUrl;

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }
    private boolean landedStatus;
    
    public boolean getLandedStatus() {
		return landedStatus;
	}
    private String landedUrl;
    
	public String getLandedUrl() {
		return landedUrl;
	}
	
	@Override
    public String execute(){
		
        this.setPageAlias(PageAlias.login);
        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;
        this.captchaUrl = this.buildWWWSiteUrl(PageAlias.captcha);
	    this.returnUrl = (String) ActionContext.getContext().getSession().get("returnUrl");
        ActionContext.getContext().getSession().remove("returnUrl");
        if (StringHelper.isNullOrEmpty(returnUrl ))
            this.returnUrl = this.buildWWWSiteUrl(PageAlias.index);
        if (!StringHelper.isNullOrEmpty(StateValues.getUserName())){
        	
        	this.landedUrl = this.buildWWWSiteUrl(PageAlias.index);
        	this.landedStatus = true;
        }
        this.redirectUrl = returnUrl;
        return SUCCESS;
    }
}
