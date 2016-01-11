package com.hzfh.weixin.controller.product;

import com.hzfh.weixin.controller.common.CommonAction;
import com.hzfh.weixin.model.common.PageAlias;

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
