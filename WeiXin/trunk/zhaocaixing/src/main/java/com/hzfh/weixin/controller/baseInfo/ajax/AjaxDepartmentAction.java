package com.hzfh.weixin.controller.baseInfo.ajax;

import com.hzfh.weixin.controller.common.BaseAction;
import com.hzfh.weixin.model.baseInfo.DepartmentModel;

import java.util.List;


public class AjaxDepartmentAction extends BaseAction {
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


	@Override
	public String execute() {

		resultList = DepartmentModel.getListByDistrictNo(param);
		return SUCCESS;
	}
    

}
