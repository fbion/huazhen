package com.hzfh.p2p.controller.baseInfo.ajax;

import com.hzfh.p2p.controller.common.BaseAction;
import com.hzfh.p2p.model.baseInfo.DepartmentModel;

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
