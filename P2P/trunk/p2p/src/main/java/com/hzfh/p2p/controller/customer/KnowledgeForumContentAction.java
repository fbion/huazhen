package com.hzfh.p2p.controller.customer;

import com.hzfh.p2p.controller.common.CommonAction;
import com.hzfh.p2p.model.common.PageAlias;

public class KnowledgeForumContentAction extends CommonAction {
	private String pageType;
	
	public void setPageType(String pageType) {
		this.pageType = pageType;
	}
	@Override
	public String execute() {
		this.setPageAlias(PageAlias.knowledgeForum);
		String ret = super.execute();
		if (!ret.equals(SUCCESS))
			return ret;
		return pageType;
	}
}
