package com.hzfh.fmp.controller.baseInfo.ajax;

import com.hzfh.api.baseInfo.model.City;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.baseInfo.CityModel;
import com.hzfh.fmp.model.common.enumeration.StatusType;

import java.util.List;


public class AjaxCityAction extends JqGridBaseAction<City> {
	private List  resultList;
    private int param;//provinceNo	

	public List getResultList() {
		return resultList;
	}

	public void setResultList(List resultList) {
		this.resultList = resultList;
	}

	public int getParam() {
		return param;
	}

	public void setParam(int param) {
		this.param = param;
	}

	@Override
	public String execute() throws Exception {
		resultList = CityModel.getCityListByProvinceNoAndEnabled(param, StatusType.ENABLED);
		return super.execute();
	}
    
}
