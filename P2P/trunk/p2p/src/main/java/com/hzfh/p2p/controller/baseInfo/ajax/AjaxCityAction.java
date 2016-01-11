package com.hzfh.p2p.controller.baseInfo.ajax;

import com.hzfh.p2p.controller.common.BaseAction;
import com.hzfh.p2p.model.baseInfo.CityModel;

import java.util.List;


public class AjaxCityAction extends BaseAction {
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
	private int enabled;
	

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	@Override
	public String execute() {
		if(enabled==1){
			resultList = CityModel.getCityListByProvinceNoAndEnabled(param, (byte)enabled);
		}else{
			resultList = CityModel.getCityListByProvinceNo(param);
			
		}
		return SUCCESS;
	}
    
}
