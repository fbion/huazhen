package com.hzfh.p2p.controller.customer;

import com.hzfh.api.customer.model.P2pCustomer;
import com.hzfh.p2p.controller.common.CommonAction;
import com.hzfh.p2p.model.common.PageAlias;
import com.hzfh.p2p.model.common.helper.EncodeHelper;
import com.hzfh.p2p.model.customer.P2pCustomerModel;
import com.hzframework.helper.StringHelper;

/**
 * Created by paul on 15-3-19.
 */
public class ForgetPassword5Action extends CommonAction {
	
    @Override
    public String execute(){
    	this.setPageAlias(PageAlias.resetSuccess);
    	String ret = super.execute();
    	if (!ret.equals(SUCCESS))
    		return ret;
    	return SUCCESS;
    }
}