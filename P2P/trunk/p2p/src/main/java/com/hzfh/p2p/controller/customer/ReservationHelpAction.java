package com.hzfh.p2p.controller.customer;

import com.hzfh.p2p.controller.common.CommonAction;
import com.hzfh.p2p.model.common.PageAlias;

public class ReservationHelpAction extends CommonAction {
	public String execute() {
		this.setPageAlias(PageAlias.reservationHelp);
		String ret = super.execute();
		if (!ret.equals(SUCCESS))
			return ret;
		return SUCCESS;
	}
}
