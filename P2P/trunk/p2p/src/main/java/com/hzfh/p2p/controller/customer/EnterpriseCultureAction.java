package com.hzfh.p2p.controller.customer;

import com.hzfh.p2p.controller.common.CommonAction;
import com.hzfh.p2p.model.common.PageAlias;

public class EnterpriseCultureAction extends CommonAction {
	private String oper;
	public String getOper() {
		return oper;
	}
	public void setOper(String oper) {
		this.oper = oper;
	}


	@Override
	public String execute() {
		this.setPageAlias(PageAlias.enterpriseCulture);
		String ret = super.execute();
		if (!ret.equals(SUCCESS))
			return ret;
		return SUCCESS;
	}
}
