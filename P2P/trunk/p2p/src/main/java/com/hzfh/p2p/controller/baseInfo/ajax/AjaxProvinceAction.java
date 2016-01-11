package com.hzfh.p2p.controller.baseInfo.ajax;

import com.hzfh.p2p.controller.common.BaseAction;
import com.hzfh.p2p.model.baseInfo.ProvinceModel;

import java.util.List;


public class AjaxProvinceAction extends BaseAction {
    private List  resultList;
//    private int param;

	public List getResultList() {
		return resultList;
	}


	public void setResultList(List resultList) {
		this.resultList = resultList;
	}

	private int enabled;

	
/*	public int getParam() {
		return param;
	}


	public void setParam(int param) {
		this.param = param;
	}
*/

	public int getEnabled() {
		return enabled;
	}


	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}


	@Override
	public String execute() {
		if(enabled==1){
            resultList = ProvinceModel.getListByEnabled((byte)enabled);
        }else{
            resultList = ProvinceModel.getList();
        }
		return SUCCESS;
	}
    

}
