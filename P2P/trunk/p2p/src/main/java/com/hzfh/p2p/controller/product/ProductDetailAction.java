package com.hzfh.p2p.controller.product;


import java.util.List;

import javax.xml.crypto.Data;

import com.hzfh.api.baseInfo.model.DicData;
import com.hzfh.api.customer.model.PaymentAccountInformation;
import com.hzfh.api.product.model.P2pProduct;
import com.hzfh.api.product.model.Product;
import com.hzfh.p2p.controller.common.CommonAction;
import com.hzfh.p2p.model.baseInfo.DicDataModel;
import com.hzfh.p2p.model.common.AuthenticationModel;
import com.hzfh.p2p.model.common.PageAlias;
import com.hzfh.p2p.model.common.helper.MoneyHelper;
import com.hzfh.p2p.model.common.helper.UrlHelper;
import com.hzfh.p2p.model.common.properties.WebInfoHelper;
import com.hzfh.p2p.model.customer.PaymentAccountInformationModel;
import com.hzfh.p2p.model.product.FinancierBusinessModel;
import com.hzfh.p2p.model.product.FinancierPersonalModel;
import com.hzfh.p2p.model.product.P2pProductModel;
import com.hzfh.p2p.model.product.ProductModel;
import com.hzframework.helper.DateHelper;
import com.hzframework.helper.MathHelper;
import com.hzframework.helper.StringHelper;

/**
 * Created by paul on 15-2-5.
 */
public class ProductDetailAction extends CommonAction {
    private String captchaUrl;

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
	//private Product product;
	private String payType;
	private String financier;
	private String startTime;
	public String getPayType() {
		return payType;
	}
	public String getFinancier() {
		return financier;
	}
	public String getStartTime() {
		return startTime;
	}
	
	
	public boolean showLogin = true;
	public boolean isShowLogin() {
		return showLogin;
	}
	public void setShowLogin(boolean showLogin) {
		this.showLogin = showLogin;
	}
	public PaymentAccountInformation paymentAccountInformation;
	public PaymentAccountInformation getPaymentAccountInformation() {
		return paymentAccountInformation;
	}
	@Override
	public String execute() {
		
		this.setPageAlias(PageAlias.productDetails);
		String ret = super.execute();
		if (!ret.equals(SUCCESS))
			return ret;
		int userId = AuthenticationModel.getCustomerId();
		if(userId>0){
			showLogin = false;//false不显示登录框
			paymentAccountInformation = PaymentAccountInformationModel.getInfoByCustomerNo(userId);
		} 
		
        this.captchaUrl = this.buildWWWSiteUrl(PageAlias.captcha);
		p2pProduct = P2pProductModel.getInfo(p2pProductId);
		if(p2pProduct==null){
			return ERROR;
		}
		double salesMoney = p2pProduct.getTotalAmout()-p2pProduct.getRemainAmout();
        double progress = MathHelper.divide(salesMoney,p2pProduct.getTotalAmout(),2)*100;
        progress = MathHelper.round(progress,2);
        p2pProduct.setProgress(progress);
		p2pProduct.setSwitchTotalAmout(MoneyHelper.getMoney(p2pProduct.getTotalAmout()));
		p2pProduct.setSwitchRemainAmout(MoneyHelper.getMoney(p2pProduct.getRemainAmout()));
		p2pProduct.setLogoPath(UrlHelper.bulidBannerImg(p2pProduct.getLogoPath()));
		
		p2pProduct.setMaxIncome(MathHelper.round(p2pProduct.getIncome()+p2pProduct.getFloatingIncome(),2));			
		
		Product product = ProductModel.getInfo(p2pProduct.getProductNo());
		List<DicData> dicDataList = DicDataModel.getDicDataListByType(2);//2 付息类型
		
		for (DicData dicData : dicDataList) {
			if(dicData.getCode()==product.getPayType()){
				payType = dicData.getValue();
			}
		}
		
		//dicDataList = DicDataModel.getDicDataListByType(19);//19	融资方类型融资方类型
		//for (DicData dicData : dicDataList) {
		if(product.getFinancierType()==1){//企业
			financier = FinancierBusinessModel.getInfo(product.getFinancierNo()).getName();
		}
		if(product.getFinancierType()==2){//个人
			financier = FinancierPersonalModel.getInfo(product.getFinancierNo()).getName();
		}
		startTime = DateHelper.format(new java.sql.Date(p2pProduct.getInTime().getTime()));
		if(!StringHelper.isNullOrEmpty(p2pProduct.getVideoUrl())){
			this.video=true;
		}
		
		p2pProduct.setVideoUrl(WebInfoHelper.WEB_UPLOAD + p2pProduct.getVideoUrl());
		this.currentUrl = WebInfoHelper.WEB_P2P_WWW;
		return SUCCESS;
	} 
}
