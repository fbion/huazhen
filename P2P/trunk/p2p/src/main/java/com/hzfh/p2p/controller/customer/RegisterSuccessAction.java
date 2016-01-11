package com.hzfh.p2p.controller.customer;

import com.hzfh.p2p.controller.common.CommonAction;
import com.hzfh.p2p.model.common.PageAlias;
import com.hzfh.p2p.model.common.helper.UrlHelper;

/**
 * Created by paul on 15-3-12.
 */
public class RegisterSuccessAction extends CommonAction {

	private String loginUrl;
    public String getLoginUrl() {
		return loginUrl;
	}

	@Override
    public String execute(){
        this.setPageAlias(PageAlias.registerSuccess);

        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;
         
        this.loginUrl = UrlHelper.buildWWWSiteUrl(PageAlias.login);
        return SUCCESS;
    }
}
