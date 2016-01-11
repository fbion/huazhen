package com.hzfh.weixin.controller.customer;

import com.hzfh.weixin.controller.common.CommonAction;
import com.hzfh.weixin.model.common.PageAlias;
import com.hzfh.weixin.model.customer.P2pCustomerModel;

/**
 * Created by paul on 15-3-20.
 */
public class LogoutAction extends CommonAction {
    @Override
    public String execute() {
        this.setPageAlias(PageAlias.logout);

        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;

        P2pCustomerModel.Logout();
        return LOGIN;
    }
}