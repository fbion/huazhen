package com.hzfh.weixin.controller.product.ajax;

import com.hzfh.api.product.model.P2pProduct;
import com.hzfh.weixin.controller.common.JsonBaseAction;
import com.hzfh.weixin.model.product.P2pProductModel;

import java.util.List;


public class AjaxP2pProductAction extends JsonBaseAction<P2pProduct> {
	
	private List<P2pProduct> p2pProductList;
	
	public List<P2pProduct> getP2pProductList() {
		return p2pProductList;
	}

	public void setP2pProductList(List<P2pProduct> p2pProductList) {
		this.p2pProductList = p2pProductList;
	}

	private String getList(){
		p2pProductList = P2pProductModel.getList();
		return SUCCESS;
	} 
	
}

