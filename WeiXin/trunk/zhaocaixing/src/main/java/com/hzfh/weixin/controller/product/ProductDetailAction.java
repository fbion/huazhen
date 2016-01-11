package com.hzfh.weixin.controller.product;


import com.hzfh.api.product.model.P2pProduct;
import com.hzfh.weixin.controller.common.CommonAction;
import com.hzfh.weixin.model.common.PageAlias;
import com.hzfh.weixin.model.common.helper.MoneyHelper;
import com.hzfh.weixin.model.common.helper.UrlHelper;
import com.hzfh.weixin.model.common.properties.WebInfoHelper;
import com.hzfh.weixin.model.product.P2pProductModel;
import com.hzframework.helper.MathHelper;

/**
 * Created by paul on 15-2-5.
 */
public class ProductDetailAction extends CommonAction {
	private int p2pProductNo;
	
	
    private String captchaUrl;
    
    private String investInfoUrl;
    
    private String productDetailsUrl;
    private String productDetailsInfoUrl;
    private String productInvestInfoUrl;
    
    
    
    
    public String getProductDetailsInfoUrl() {
		return productDetailsInfoUrl;
	}
	public void setProductDetailsInfoUrl(String productDetailsInfoUrl) {
		this.productDetailsInfoUrl = productDetailsInfoUrl;
	}
	public String getProductInvestInfoUrl() {
		return productInvestInfoUrl;
	}
	public void setProductInvestInfoUrl(String productInvestInfoUrl) {
		this.productInvestInfoUrl = productInvestInfoUrl;
	}
	public String getInvestInfoUrl() {
		return investInfoUrl;
	}
	public void setInvestInfoUrl(String investInfoUrl) {
		this.investInfoUrl = investInfoUrl;
	}
	public int getP2pProductNo() {
		return p2pProductNo;
	}
	public void setP2pProductNo(int p2pProductNo) {
		this.p2pProductNo = p2pProductNo;
	}
	public String getProductDetailsUrl() {
		return productDetailsUrl;
	}
	public void setProductDetailsUrl(String productDetailsUrl) {
		this.productDetailsUrl = productDetailsUrl;
	}
	public String getCaptchaUrl() {
        return captchaUrl;
    }

	private P2pProduct p2pProduct;

	public P2pProduct getP2pProduct() {
		return p2pProduct;
	}
	public void setP2pProduct(P2pProduct p2pProduct) {
		this.p2pProduct = p2pProduct;
	}

	private int p2pProductId;
	
	
	public int getP2pProductId() {
		return p2pProductId;
	}
	public void setP2pProductId(int p2pProductId) {
		this.p2pProductId = p2pProductId;
	}
	
	private String currentUrl;

    public String getCurrentUrl() {
		return currentUrl;
	}
    private boolean video;
    
	
	public boolean isVideo() {
		return video;
	}
	public void setVideo(boolean video) {
		this.video = video;
	}
	@Override
	public String execute() {

		this.setPageAlias(PageAlias.productDetails);
		String ret = super.execute();
		if (!ret.equals(SUCCESS))
			return ret;

        this.captchaUrl = this.buildWWWSiteUrl(PageAlias.captcha);
		p2pProduct = P2pProductModel.getInfo(p2pProductId);
		p2pProduct.setSwitchTotalAmout(MoneyHelper.getMoney(p2pProduct.getTotalAmout()));
		p2pProduct.setSwitchRemainAmout(MoneyHelper.getMoney(p2pProduct.getRemainAmout()));
		
		/*if(!StringHelper.isNullOrEmpty(p2pProduct.getVideoUrl())){
			this.video=true;
		}
		p2pProduct.setVideoUrl(WebInfoHelper.WEB_UPLOAD + p2pProduct.getVideoUrl());*/
		double salesMoney = p2pProduct.getTotalAmout()-p2pProduct.getRemainAmout();
 		double progress = MathHelper.divide(salesMoney, p2pProduct.getTotalAmout(), 2)*100;
 		progress = MathHelper.round(progress,2);
 		p2pProduct.setProgress(progress);
 		this.productDetailsUrl = UrlHelper.buildWWWSiteUrl(PageAlias.productDetailsInfo);
 		this.investInfoUrl = UrlHelper.buildWWWSiteUrl(PageAlias.investInfo);
		this.currentUrl = WebInfoHelper.WEB_P2P_WWW;
		this.productDetailsInfoUrl =  this.buildImg("icon01.jpg");
		this.productInvestInfoUrl =  this.buildImg("icon02.jpg");
		return SUCCESS;
	}
	public String productDetailsInfo() {

		this.setPageAlias(PageAlias.productDetails);
		String ret = super.execute();
		if (!ret.equals(SUCCESS))
			return ret;

        this.captchaUrl = this.buildWWWSiteUrl(PageAlias.captcha);
		p2pProduct = P2pProductModel.getInfo(p2pProductId);
		p2pProduct.setSwitchTotalAmout(MoneyHelper.getMoney(p2pProduct.getTotalAmout()));
		p2pProduct.setSwitchRemainAmout(MoneyHelper.getMoney(p2pProduct.getRemainAmout()));
		double salesMoney = p2pProduct.getTotalAmout()-p2pProduct.getRemainAmout();
 		double progress = MathHelper.divide(salesMoney, p2pProduct.getTotalAmout(), 2)*100;
 		progress = MathHelper.round(progress,2);
 		p2pProduct.setProgress(progress);
		
		this.currentUrl = WebInfoHelper.WEB_P2P_WWW;
		
		return SUCCESS;
	}
	public String toInvestInfo() {

		this.setPageAlias(PageAlias.investInfo);
		String ret = super.execute();
		if (!ret.equals(SUCCESS))
			return ret;
		p2pProduct = P2pProductModel.getInfo(p2pProductNo);
		this.currentUrl = WebInfoHelper.WEB_P2P_WWW;
		
		return SUCCESS;
	}

}
