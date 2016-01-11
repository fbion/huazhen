package com.hzfh.p2p.controller.customer;

import com.hzfh.p2p.controller.common.CommonAction;
import com.hzfh.p2p.model.common.PageAlias;

/**
 * Created by paul on 15-2-5.
 */
public class ForgetPasswordAction extends CommonAction {
    private String captchaUrl;

    public String getCaptchaUrl() {
        return captchaUrl;
    }

    @Override
    public String execute() {
        this.setPageAlias(PageAlias.forgetPassword);
        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;

        this.captchaUrl = this.buildWWWSiteUrl(PageAlias.captcha);
        return SUCCESS;
    }
}
