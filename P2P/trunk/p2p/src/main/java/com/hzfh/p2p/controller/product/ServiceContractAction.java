package com.hzfh.p2p.controller.product;

import com.hzfh.p2p.controller.common.CommonAction;
import com.hzfh.p2p.model.common.PageAlias;

public class ServiceContractAction extends CommonAction {
	@Override
	public String execute() {
		this.setPageAlias(PageAlias.serviceContract);
		String ret = super.execute();
		if (!ret.equals(SUCCESS))
			return ret;
		return SUCCESS;
	}
}
