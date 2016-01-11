package com.hzfh.weixin.controller.customer;

import com.hzfh.weixin.controller.common.CommonAction;
import com.hzfh.weixin.model.common.PageAlias;

/**
 * Created by paul on 15-3-19.
 */
public class ForgetPassword1Action extends CommonAction {
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    private String redirectUrl;

    public String getRedirectUrl() {
        return redirectUrl;
    }

    @Override
    public String execute(){
        this.setPageAlias(PageAlias.resetPassword);
        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;
        redirectUrl = this.buildWWWSiteUrl(PageAlias.resetSuccess);

        return SUCCESS;
    }
}