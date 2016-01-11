package com.hzfh.p2p.controller.customer;

import java.util.ArrayList;
import java.util.List;

import com.hzfh.api.baseInfo.model.DicData;
import com.hzfh.api.product.model.P2pProduct;
import com.hzfh.api.product.model.Product;
import com.hzfh.api.sales.model.P2pInvestment;
import com.hzfh.api.sales.model.Sales;
import com.hzfh.p2p.controller.common.CommonAction;
import com.hzfh.p2p.model.baseInfo.DicDataModel;
import com.hzfh.p2p.model.common.AuthenticationModel;
import com.hzfh.p2p.model.common.PageAlias;
import com.hzfh.p2p.model.common.helper.UrlHelper;
import com.hzfh.p2p.model.common.parameter.StatusType;
import com.hzfh.p2p.model.product.P2pProductModel;
import com.hzfh.p2p.model.product.ProductModel;
import com.hzfh.p2p.model.sales.P2pInvestmentModel;
import com.hzfh.p2p.model.sales.SalesModel;

/**
 * Created by paul on 15-2-5.
 */
public class InvestmentAction extends CommonAction{
	private List<DicData> productTypeDicDataList;//4 产品类型
	private List<Product> productList = new ArrayList<Product>();//除线上的线下产品
	private List<P2pProduct> p2pProductList = new ArrayList<P2pProduct>();//线上
	private List<DicData> investmentStatusList;//7 订单状态


	private String productType = "0";
	private String productTypeUrl;
	
	public String getProductType() {
		return productType;
	}


	public void setProductType(String productType) {
		this.productType = productType;
	}


	public List<DicData> getProductTypeDicDataList() {
		return productTypeDicDataList;
	}


	public List<Product> getProductList() {
		return productList;
	}


	public List<P2pProduct> getP2pProductList() {
		return p2pProductList;
	}


	public List<DicData> getInvestmentStatusList() {
		return investmentStatusList;
	}


	public String getProductTypeUrl() {
		return productTypeUrl;
	}


	@Override
	public String execute(){
        this.setPageAlias(PageAlias.myInvestment);
        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;
        productTypeDicDataList = DicDataModel.getDicDataListByType(StatusType.PRODUCTTYPE);
        //investmentStatusList = DicDataModel.getDicDataListByType(7);
        /*List<Sales> salesList = SalesModel.getListByP2pCustomerNoAndProductType(AuthenticationModel.getCustomerId(),Integer.valueOf(productType));
        for(Sales ps:salesList){
			P2pProduct pp = P2pProductModel.getInfo(ps.getP2pProductNo());
			if(pp!=null){
				boolean flag = true;
				for(int i=0;i<p2pProductList.size();i++){
					if(p2pProductList.get(i).getId()==pp.getId()){
						flag = false;
						break;
					}
				}
				if(flag){
					p2pProductList.add(pp);
				}
			}
		}
        for(Sales ps:salesList){
        	Product pp = ProductModel.getInfo(ps.getProductNo());
        	if(pp!=null){
        		boolean flag = true;
        		for(int i=0;i<productList.size();i++){
        			if(productList.get(i).getId()==pp.getId()){
        				flag = false;
        				break;
        			}
        		}
        		if(flag){
        			boolean flag1 = true;
        			for(P2pProduct p2p:p2pProductList){
        				if(p2p.getProductNo()==pp.getId()){//p2p产品是由线下产品转换来的
        					flag1 = false;
        				}
        			}
        			if(flag1){
        				productList.add(pp);
        			}
        		}
			}
        }*/
        productTypeUrl = UrlHelper.buildWWWSiteUrl(PageAlias.myInvestment);
        return SUCCESS;
	}
}
