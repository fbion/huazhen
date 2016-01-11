package com.hzfh.p2p.controller.product;

import com.hzfh.api.product.model.P2pProduct;
import com.hzfh.p2p.controller.common.CommonAction;
import com.hzfh.p2p.model.common.PageAlias;
import com.hzfh.p2p.model.product.P2pProductModel;
import com.hzframework.helper.DateHelper;

/**
 * Created by Administrator on 2015/6/9.
 */
public class ConfirmInfoAction  extends CommonAction{
    private int p2pProductNo;
    private int investmentMoney;

    public int getInvestmentMoney() {
        return investmentMoney;
    }

    public void setInvestmentMoney(int investmentMoney) {
        this.investmentMoney = investmentMoney;
    }

    public int getP2pProductNo() {
        return p2pProductNo;
    }

    public void setP2pProductNo(int p2pProductNo) {
        this.p2pProductNo = p2pProductNo;
    }

    private P2pProduct p2pProduct;

    public P2pProduct getP2pProduct() {
        return p2pProduct;
    }

    public void setP2pProduct(P2pProduct p2pProduct) {
        this.p2pProduct = p2pProduct;
    }

    private String investTime;
    private String productEndTime;
    
    public String getInvestTime() {
		return investTime;
	}

	public String getProductEndTime() {
		return productEndTime;
	}

	@Override
    public String execute(){
    	
        p2pProduct = P2pProductModel.getInfo(this.p2pProductNo);
        this.setPageAlias(PageAlias.productConfirm);
        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;
        
        
        this.investTime = DateHelper.getToday();
        this.productEndTime = DateHelper.format(new java.sql.Date(p2pProduct.getEnd().getTime()));
        return SUCCESS;
    }


}
