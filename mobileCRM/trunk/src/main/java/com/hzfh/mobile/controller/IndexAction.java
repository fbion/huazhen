package com.hzfh.mobile.controller;

import com.hzfh.mobile.controller.common.CommonAction;
import com.hzfh.mobile.model.common.PageAlias;

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
