package com.hzfh.weixin.controller;

import com.hzfh.api.product.model.P2pProduct;
import com.hzfh.api.product.model.query.P2pProductCondition;
import com.hzfh.weixin.controller.common.JsonBaseAction;
import com.hzfh.weixin.model.common.PageAlias;
import com.hzfh.weixin.model.common.helper.MoneyHelper;
import com.hzfh.weixin.model.common.helper.UrlHelper;
import com.hzfh.weixin.model.product.P2pProductModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.contract.SortType;
import com.hzframework.helper.MathHelper;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by paul on 15-2-5.
 */
public class AjaxIndexAction extends JsonBaseAction<P2pProduct> {
	
	private String tzStatus;
	private String statusUrl;//状态Url
	private PagedList<P2pProduct> p2pProductList;
    private String productDetailsUrl;
	private String productListStateUrl;
	private String productListStateFinshedUrl;
	private String productListStateRepaymentUrl;
	
	private int count;
	
	
	
	


	public String getProductListStateFinshedUrl() {
		return productListStateFinshedUrl;
	}


	public void setProductListStateFinshedUrl(String productListStateFinshedUrl) {
		this.productListStateFinshedUrl = productListStateFinshedUrl;
	}


	public String getProductListStateRepaymentUrl() {
		return productListStateRepaymentUrl;
	}


	public void setProductListStateRepaymentUrl(String productListStateRepaymentUrl) {
		this.productListStateRepaymentUrl = productListStateRepaymentUrl;
	}


	public String getTzStatus() {
		return tzStatus;
	}


	public void setTzStatus(String tzStatus) {
		this.tzStatus = tzStatus;
	}


	public String getStatusUrl() {
		return statusUrl;
	}


	public void setStatusUrl(String statusUrl) {
		this.statusUrl = statusUrl;
	}


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


	public String getProductListStateUrl() {
		return productListStateUrl;
	}


	public void setProductListStateUrl(String productListStateUrl) {
		this.productListStateUrl = productListStateUrl;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	@Override
    public String execute() {
       
		
		this.statusUrl =  this.buildWWWSiteUrl(PageAlias.index);
        P2pProductCondition p2pProductCondition = new P2pProductCondition();
        p2pProductCondition.setPageIndex(count);
        p2pProductCondition.setPageSize(3);
        p2pProductCondition.getStartIndex();
        
        if(!StringHelper.isNullOrEmpty(this.tzStatus)){
			if("20".equals(this.tzStatus)){
				p2pProductCondition.setStatus1(20);
				p2pProductCondition.setStatus2(30);
			}else{
				 p2pProductCondition.setStatus1(40);
			     p2pProductCondition.setStatus2(50);
			}
		}else{
			p2pProductCondition.setStatus1(20);
			p2pProductCondition.setStatus2(30);
		}
        
        p2pProductCondition.setIsTest((byte)0);
        
        List<SortItem> sortItemList = new ArrayList<SortItem>();
		SortItem sortItem = new SortItem();
		sortItem.setSortFeild("level");
		sortItem.setSortType(SortType.DESC);
		sortItemList.add(sortItem);

		p2pProductCondition.setSortItemList(sortItemList);
        p2pProductList = P2pProductModel.getPagingList(p2pProductCondition);
        
        if(p2pProductList.getResultList().size()>0&&p2pProductList!=null){
        
        	 for(int i=1;i<=p2pProductList.getResultList().size();i++){
             	P2pProduct p2pProduct = p2pProductList.getResultList().get(i-1);
             	p2pProduct.setSwitchTotalAmout(MoneyHelper.getMoney(p2pProduct.getTotalAmout()));
         		p2pProduct.setSwitchRemainAmout(MoneyHelper.getMoney(p2pProduct.getRemainAmout()));
         		p2pProduct.setRowIndex(i+3*(count-1));
         		
         		double salesMoney = p2pProduct.getTotalAmout()-p2pProduct.getRemainAmout();
         		double progress = MathHelper.divide(salesMoney, p2pProduct.getTotalAmout(), 2)*100;
         		progress = MathHelper.round(progress,2);
         		p2pProduct.setProgress(progress);
             }
        }
        
        this.productDetailsUrl = UrlHelper.buildWWWSiteUrl(PageAlias.productDetails);
        this.productListStateUrl = this.buildImg("productList_state.jpg");
        this.productListStateFinshedUrl = this.buildImg("productList_state2.jpg");
        this.productListStateRepaymentUrl = this.buildImg("productList_state6.jpg");

        return SUCCESS;
    }



	
	
	
}