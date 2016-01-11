package com.hzfh.p2p.controller.customer;

import com.hzfh.p2p.controller.common.CommonAction;
import com.hzfh.p2p.model.common.PageAlias;

public class AccountCentralAction extends CommonAction {
	public String execute() {
		this.setPageAlias(PageAlias.accountCentral);
		String ret = super.execute();
		if (!ret.equals(SUCCESS))
			return ret;
		return SUCCESS;
	}
}
