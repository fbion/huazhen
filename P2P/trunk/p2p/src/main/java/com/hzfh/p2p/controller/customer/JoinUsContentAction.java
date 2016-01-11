package com.hzfh.p2p.controller.customer;

import com.hzfh.p2p.controller.common.CommonAction;
import com.hzfh.p2p.model.common.PageAlias;

public class JoinUsContentAction extends CommonAction {
	
	private String pageType;
	
	public void setPageType(String pageType) {
		this.pageType = pageType;
	}
	@Override
	public String execute() {
		this.setPageAlias(PageAlias.joinUs);
		String ret = super.execute();
		if (!ret.equals(SUCCESS))
			return ret;
		return pageType;
	}
	/*public String joinUsContent1() {
		this.setPageAlias(PageAlias.joinUs);
		String ret = super.execute();
		if (!ret.equals(SUCCESS))
			return ret;
		return "joinUsContent1";
	}
	public String joinUsContent2() {
		this.setPageAlias(PageAlias.joinUs);
		String ret = super.execute();
		if (!ret.equals(SUCCESS))
			return ret;
		return "joinUsContent2";
	}
	public String joinUsContent3() {
		this.setPageAlias(PageAlias.joinUs);
		String ret = super.execute();
		if (!ret.equals(SUCCESS))
			return ret;
		return "joinUsContent3";
	}
	public String joinUsContent4() {
		this.setPageAlias(PageAlias.joinUs);
		String ret = super.execute();
		if (!ret.equals(SUCCESS))
			return ret;
		return "joinUsContent4";
	}
	public String joinUsContent5() {
		this.setPageAlias(PageAlias.joinUs);
		String ret = super.execute();
		if (!ret.equals(SUCCESS))
			return ret;
		return "joinUsContent5";
	}
	public String joinUsContent6() {
		this.setPageAlias(PageAlias.joinUs);
		String ret = super.execute();
		if (!ret.equals(SUCCESS))
			return ret;
		return "joinUsContent6";
	}
	public String joinUsContent7() {
		this.setPageAlias(PageAlias.joinUs);
		String ret = super.execute();
		if (!ret.equals(SUCCESS))
			return ret;
		return "joinUsContent7";
	}
	public String joinUsContent8() {
		this.setPageAlias(PageAlias.joinUs);
		String ret = super.execute();
		if (!ret.equals(SUCCESS))
			return ret;
		return "joinUsContent8";
	}
	public String joinUsContent9() {
		this.setPageAlias(PageAlias.joinUs);
		String ret = super.execute();
		if (!ret.equals(SUCCESS))
			return ret;
		return "joinUsContent9";
	}
	public String joinUsContent10() {
		this.setPageAlias(PageAlias.joinUs);
		String ret = super.execute();
		if (!ret.equals(SUCCESS))
			return ret;
		return "joinUsContent10";
	}
	public String joinUsContent11() {
		this.setPageAlias(PageAlias.joinUs);
		String ret = super.execute();
		if (!ret.equals(SUCCESS))
			return ret;
		return "joinUsContent11";
	}*/
}
