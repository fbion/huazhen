package com.hzfh.weixin.controller;

import com.hzfh.api.product.model.P2pProduct;
import com.hzfh.weixin.controller.common.CommonAction;
import com.hzfh.weixin.model.common.PageAlias;
import com.hzframework.contract.PagedList;

/**
 * Created by paul on 15-2-5.
 */
public class IndexAction extends CommonAction {
    private String captchaUrl;
    private String productLineUrl;
    
    
	public String getProductLineUrl() {
		return productLineUrl;
	}

	public void setProductLineUrl(String productLineUrl) {
		this.productLineUrl = productLineUrl;
	}

	public String getCaptchaUrl() {
        return captchaUrl;
    }

    private PagedList<P2pProduct> p2pProductList;
    private String productDetailsUrl;

  

     public PagedList<P2pProduct> getP2pProductList() {
		return p2pProductList;
	}

	public void setP2pProductList(PagedList<P2pProduct> p2pProductList) {
		this.p2pProductList = p2pProductList;
	}

	public String getProductDetailsUrl() {
        return productDetailsUrl;
    }

    public void setProductDetailsUrl(String productDetailsUrl) {
        this.productDetailsUrl = productDetailsUrl;
    }
    private int size;
    public int getSize() {
		return size;
	}
    private int count;
    public int getCount() {
		return count;
	}
    
	public void setCount(int count) {
		this.count = count;
	}

	@Override
    public String execute() {
        this.setPageAlias(PageAlias.index);

        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;

        this.captchaUrl = this.buildWWWSiteUrl(PageAlias.captcha);
        this.productLineUrl=this.buildImg("line03.jpg");
    
        return SUCCESS;
    }

	
	public String error(){
		this.setPageAlias(PageAlias.errorPage);
		
		String ret = super.execute();
		if(!ret.equals(SUCCESS)){
			return ret;
		}
		return ERROR;
	}
}