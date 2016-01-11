package com.hzfh.p2p.controller.customer;

import com.hzfh.p2p.controller.common.CommonAction;
import com.hzfh.p2p.model.common.AuthenticationModel;
import com.hzfh.p2p.model.common.PageAlias;
import com.hzframework.helper.StringHelper;
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
    
    private boolean showLogin = true;
    public boolean isShowLogin() {
		return showLogin;
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
        this.redirectUrl = returnUrl;


        if(AuthenticationModel.getCustomerId()!=0){
        	showLogin = false;
        }
        return SUCCESS;
    }
}
