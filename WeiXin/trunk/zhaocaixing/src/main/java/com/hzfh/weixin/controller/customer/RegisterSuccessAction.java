package com.hzfh.weixin.controller.customer;

import com.hzfh.weixin.controller.common.CommonAction;
import com.hzfh.weixin.model.common.PageAlias;

/**
 * Created by paul on 15-3-12.
 */
public class RegisterSuccessAction extends CommonAction {

	private int newRegister;
	public int getNewRegister() {
		return newRegister;
	}
	public void setNewRegister(int newRegister) {
		this.newRegister = newRegister;
	}

	@Override
    public String execute(){
	    this.setPageAlias(PageAlias.registerSuccess);
        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;
        return SUCCESS;
    }
}
