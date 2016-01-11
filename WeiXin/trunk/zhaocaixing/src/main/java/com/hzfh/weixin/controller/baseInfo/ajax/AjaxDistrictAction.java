package com.hzfh.weixin.controller.baseInfo.ajax;

import com.hzfh.weixin.controller.common.BaseAction;
import com.hzfh.weixin.model.baseInfo.DistrictModel;

import java.util.List;


public class AjaxDistrictAction extends BaseAction {
	private List  resultList;
    private int param;
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
			resultList = DistrictModel.getDistrictListByCityNoAndEnabled(param,(byte) enabled);
		}else{
			resultList = DistrictModel.getDistrictListByCityNo(param);
		}
		return SUCCESS;
	}
    
	

}
