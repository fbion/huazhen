package com.hzfh.weixin.controller.customer;

import com.hzfh.api.customer.model.P2pCustomer;
import com.hzfh.weixin.controller.common.CommonAction;
import com.hzfh.weixin.model.common.AuthenticationModel;
import com.hzfh.weixin.model.common.PageAlias;
import com.hzfh.weixin.model.customer.P2pCustomerModel;

/**
 * Created by paul on 15-2-5.
 */
public class PersonalInfoAction extends CommonAction{
 
	private P2pCustomer p2pCustomer;
	private String returnUrl;
	
    public String getReturnUrl() {
		return returnUrl;
	}
	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}
	public P2pCustomer getP2pCustomer() {
		return p2pCustomer;
	}
	public void setP2pCustomer(P2pCustomer p2pCustomer) {
		this.p2pCustomer = p2pCustomer;
	}

	@Override
	public String execute(){
        this.setPageAlias(PageAlias.personalInfo);
        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;
        
        int id = AuthenticationModel.getCustomerId();
        p2pCustomer  =  P2pCustomerModel.getInfo(id);
        return SUCCESS;
	}
}
