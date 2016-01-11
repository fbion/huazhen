package com.hzfh.market.controller;

import com.hzfh.market.controller.common.CommonAction;
import com.hzfh.market.model.common.PageAlias;


public class IndexAction extends CommonAction{
	
	@Override
	public String execute() {
		
		this.setPageAlias(PageAlias.index);

		String ret = super.execute();
		if (!ret.equals(SUCCESS))
			return ret;
		return SUCCESS;
	}
}
