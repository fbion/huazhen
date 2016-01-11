package com.hzfh.p2p.controller.product;

import org.springframework.beans.factory.annotation.Autowired;

import com.hzfh.p2p.controller.common.CommonAction;
import com.hzfh.p2p.model.common.PageAlias;

public class LawsRegulationsContentAction extends CommonAction {
	
	@Autowired
	private String pageType;
	
	public void setPageType(String pageType) {
		this.pageType = pageType;
	}

	@Override
	public String execute() {
		this.setPageAlias(PageAlias.lawsRegulationsContent);
		String ret = super.execute();
		if (!ret.equals(SUCCESS))
			return ret;
		return pageType;
	}
	

}
