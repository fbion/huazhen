package com.hzfh.p2p.controller.customer;

import com.hzfh.p2p.controller.common.CommonAction;
import com.hzfh.p2p.model.common.PageAlias;

public class NoviceAreaAction extends CommonAction {
	private int scroll;
	
	public int getScroll() {
		return scroll;
	}

	public void setScroll(int scroll) {
		this.scroll = scroll;
	}

	public String execute() {
		this.setPageAlias(PageAlias.noviceArea);
		String ret = super.execute();
		if (!ret.equals(SUCCESS))
			return ret;
		return SUCCESS;
	}
}
