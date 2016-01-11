package com.hzfh.mobile.controller.baseInfo;

import com.hzfh.mobile.controller.common.CommonAction;
import com.hzfh.mobile.model.common.PageAlias;

public class CalculationInvestmentAction extends CommonAction {
	private String carHeaderUrl;
	public String getCarHeaderUrl() {
		return carHeaderUrl;
	}
	public void setCarHeaderUrl(String carHeaderUrl) {
		this.carHeaderUrl = carHeaderUrl;
	}
	@Override
	public String execute() {
		this.setPageAlias(PageAlias.calculationInvestment);
		String ret = super.execute();
		if (!ret.equals(SUCCESS))
			return ret;
		this.carHeaderUrl = this.buildImg("car.jpg");
		return SUCCESS;
	}
	
}
