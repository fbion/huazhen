package com.hzfh.weixin.controller.customer;

import java.util.ArrayList;
import java.util.List;

import com.hzfh.api.customer.model.CustomerPersonal;
import com.hzfh.api.customer.model.P2pCustomer;
import com.hzfh.api.customer.model.PaymentAccountInformation;
import com.hzfh.api.product.model.Product;
import com.hzfh.api.sales.model.Sales;
import com.hzfh.api.sales.model.query.SalesCondition;
import com.hzfh.weixin.controller.common.CommonAction;
import com.hzfh.weixin.model.baseInfo.CustomerPersonalModel;
import com.hzfh.weixin.model.common.AuthenticationModel;
import com.hzfh.weixin.model.common.PageAlias;
import com.hzfh.weixin.model.common.helper.MoneyHelper;
import com.hzfh.weixin.model.common.helper.UrlHelper;
import com.hzfh.weixin.model.common.paramter.PaymentType;
import com.hzfh.weixin.model.customer.P2pCustomerModel;
import com.hzfh.weixin.model.customer.PaymentAccountInformationModel;
import com.hzfh.weixin.model.product.ProductModel;
import com.hzfh.weixin.model.sales.SalesModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.contract.SortType;
import com.hzframework.helper.StringHelper;

public class InvestAction extends CommonAction {


	private int pageIndex;
	private PagedList<Sales> salesList;
	//private PagedList<P2pInvestment> p2pInvestmentList;
	private int flag;
	

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	/*public PagedList<P2pInvestment> getP2pInvestmentList() {
		return p2pInvestmentList;
	}

	public void setP2pInvestmentList(PagedList<P2pInvestment> p2pInvestmentList) {
		this.p2pInvestmentList = p2pInvestmentList;
	}*/
	public PagedList<Sales> getSalesList() {
		return salesList;
	}

	public void setSalesList(PagedList<Sales> salesList) {
		this.salesList = salesList;
	}
	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	private String productDetailsUrl;
	
	public String getProductDetailsUrl() {
		return productDetailsUrl;
	}

	public void setProductDetailsUrl(String productDetailsUrl) {
		this.productDetailsUrl = productDetailsUrl;
	}

	@Override
	public String execute(){
		
		SalesCondition salesCondition = new SalesCondition();
		salesCondition.setPageIndex(pageIndex);
		salesCondition.setPageSize(3);
		
		P2pCustomer p2pCustomer =  P2pCustomerModel.getInfo(AuthenticationModel.getCustomerId());
		
		//salesCondition.setCustomer(p2pCustomer.getCustomerNo());
		//mengChong 2015-12-25
		
		byte online = 1;//线上线下融合
		
		if(p2pCustomer.getCustomerNo()!=0){
	        salesCondition.setCustomer(p2pCustomer.getCustomerNo());
	    }else{
	        PaymentAccountInformation paymentAccountInformation = PaymentAccountInformationModel.getInfoByCustomerNo(AuthenticationModel.getCustomerId());
	        int authName = paymentAccountInformation.getAuthenticationName();
	        if(authName==0){
	        	online=0;
	        }
	        if(authName==1){
	        	String cardNumber = p2pCustomer.getCardNumber();
	        	if(StringHelper.isNullOrEmpty(cardNumber)){
	        		online=0;
	        	}
	            if(!StringHelper.isNullOrEmpty(cardNumber)){
	            	CustomerPersonal customerPersonal = CustomerPersonalModel.getInfoByCardNumber(cardNumber);
	            	if(customerPersonal==null){
	            		online=0;
	            	}
	            	if(customerPersonal!=null){
	            		int customerNo = customerPersonal.getId();  
	            		salesCondition.setCustomer(customerNo);
	            	}
	            }
	        }
	    }
		//byte online = 1;//线上线下融合
		/*if(p2pCustomer.getCustomerNo()==0){
			online=0;
		}*/
		salesCondition.setOnline(online);
		
		salesCondition.setP2pCustomerNo(AuthenticationModel.getCustomerId());
		salesCondition.getStartIndex();
		salesCondition.setPayType(PaymentType.SALESPAY_ALL);
		
		List<SortItem> sortItemList = new ArrayList<SortItem>();
		SortItem sortItem1 = new SortItem();
		sortItem1.setSortFeild("id");
		sortItem1.setSortType(SortType.DESC);
		sortItemList.add(sortItem1);
		salesCondition.setSortItemList(sortItemList);
		salesList = SalesModel.getPagingList(salesCondition);
		
		if(salesList==null){
			this.flag = 0;
			return SUCCESS;
		}
		this.flag = salesList.getResultList().size();
		for (Sales sales : salesList.getResultList()) {
			sales.setSwitchTotalAmout(MoneyHelper.getMoney(sales.getMoney()));
			if(StringHelper.isNullOrEmpty(sales.getP2pProductName())){
				Product p = ProductModel.getInfo(sales.getProductNo());
				sales.setP2pProductName(p.getName());
			}
		}
		
		
		productDetailsUrl = UrlHelper.buildWWWSiteUrl(PageAlias.productDetails);
        return SUCCESS;
	}
}
