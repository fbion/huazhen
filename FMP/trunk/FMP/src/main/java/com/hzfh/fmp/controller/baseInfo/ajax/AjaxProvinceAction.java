package com.hzfh.fmp.controller.baseInfo.ajax;

import com.hzfh.api.baseInfo.model.Province;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.baseInfo.ProvinceModel;
import com.hzfh.fmp.model.common.enumeration.StatusType;

import java.util.List;


public class AjaxProvinceAction extends JqGridBaseAction<Province> {
    private List  resultList;
//    private int param;

	public List getResultList() {
		return resultList;
	}


	public void setResultList(List resultList) {
		this.resultList = resultList;
	}


/*	public int getParam() {
		return param;
	}


	public void setParam(int param) {
		this.param = param;
	}
*/

	@Override
	public String execute() throws Exception {
		resultList = ProvinceModel.getListByEnabled(StatusType.ENABLED);
		return SUCCESS;
	}

}
