package com.hzfh.fmp.controller;

import com.hzfh.fmp.controller.common.CommonAction;
import com.hzfh.fmp.model.common.PageAlias;
import com.hzfh.fmp.model.common.cache.CacheManager;
import com.hzfh.fmp.model.common.cache.CachePrefix;
import com.hzfh.fmp.model.common.helper.EncodeHelper;
import com.hzfh.fmp.model.common.helper.LogHelper;
import com.hzfh.fmp.model.common.state.StateValues;
import com.opensymphony.xwork2.ActionContext;

/**
 * Created by paul on 14-10-31.
 */

public class LoginAction extends CommonAction {

    private String returnUrl;
    private String redirectUrl;

    public String getReturnUrl() {
        return returnUrl;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public String load() throws Exception{
		this.setPageAlias(PageAlias.login);
		String ret = super.execute();
		if (!ret.equals(SUCCESS))
			return ret;
		if (StateValues.getUserId() != 0 && StateValues.getLastLogin() != null) {
			String cacheKey = EncodeHelper.encryptPWD(String.valueOf(StateValues.getUserId()), StateValues.getLastLogin());
			if (CacheManager.get(CachePrefix.LOGIN_INFO_PREFIX,cacheKey) != null) {
				return SUCCESS;
			}
		}
		this.returnUrl = (String) ActionContext.getContext().getSession().get("returnUrl");
		ActionContext.getContext().getSession().remove("returnUrl");
		this.redirectUrl = returnUrl;
		return INPUT;
	}

	public String logout() {
		System.out.println("退出登录");
		StateValues.cleanLoginCookie();
		return SUCCESS;
	}

	public String updatePwd() throws Exception{
		System.out.println("跳修改密码页面");
		this.setPageAlias(PageAlias.updatePwd);

		String ret = super.execute();
		if (!ret.equals(SUCCESS))
			return ret;

		return SUCCESS;
	}

}
