package com.hzfh.p2p.controller.customer.ajax;

import com.hzfh.api.baseInfo.model.DicData;
import com.hzfh.api.customer.model.CustomerPersonal;
import com.hzfh.api.customer.model.P2pCustomer;
import com.hzfh.api.customer.model.PaymentAccountInformation;
import com.hzfh.api.employee.model.Employee;
import com.hzfh.api.payment.model.PaymentRefund;
import com.hzfh.api.product.model.Product;
import com.hzfh.api.sales.model.Sales;
import com.hzfh.api.sales.model.query.SalesCondition;
import com.hzfh.p2p.controller.common.CommonAction;
import com.hzfh.p2p.model.baseInfo.CustomerPersonalModel;
import com.hzfh.p2p.model.baseInfo.DicDataModel;
import com.hzfh.p2p.model.baseInfo.EmployeeModel;
import com.hzfh.p2p.model.common.AuthenticationModel;
import com.hzfh.p2p.model.common.PageAlias;
import com.hzfh.p2p.model.common.helper.UrlHelper;
import com.hzfh.p2p.model.common.parameter.PaymentType;
import com.hzfh.p2p.model.common.parameter.StatusType;
import com.hzfh.p2p.model.customer.P2pCustomerModel;
import com.hzfh.p2p.model.customer.PaymentAccountInformationModel;
import com.hzfh.p2p.model.payment.PaymentRefundModel;
import com.hzfh.p2p.model.product.ProductModel;
import com.hzfh.p2p.model.sales.SalesModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.contract.SortType;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;

public class AjaxInvestmentAction extends CommonAction {


	private int pageIndex;
	private PagedList<Sales> pagedSalesList;
	private int pageCount;
	private int totalCount;
	
	
	

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}


	public PagedList<Sales> getPagedSalesList() {
		return pagedSalesList;
	}

	public void setPagedSalesList(PagedList<Sales> pagedSalesList) {
		this.pagedSalesList = pagedSalesList;
	}

	public int getPageIndex() {
		return pageIndex <= pageCount?pageIndex:pageCount;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	
	private String productType;
	private String statusStr;
	public void setProductType(String productType) {
		this.productType = productType;
	}

	public void setStatusStr(String statusStr) {
		this.statusStr = statusStr;
	}

	private String productDetailsUrl;

	public String getProductDetailsUrl() {
		return productDetailsUrl;
	}
	@Override
	public String execute(){
		SalesCondition salesCondition = new SalesCondition();
		salesCondition.setPageIndex(pageIndex);
		salesCondition.setPageSize(5);
		salesCondition.setP2pCustomerNo(AuthenticationModel.getCustomerId());
		
		
		P2pCustomer p2pCustomer =  P2pCustomerModel.getInfo(AuthenticationModel.getCustomerId());
		
		
		
		
		byte online = 1;//线上线下融合
		/*if(p2pCustomer.getCustomerNo()==0){
			online=0;
		}*/
		salesCondition.setOnline(online);
		//salesCondition.setCustomer(p2pCustomer.getCustomerNo());
		//mengChong 2015-12-25
		
		
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
		
		salesCondition.setOnline(online);
		
		salesCondition.getStartIndex();
		salesCondition.setPayType(PaymentType.SALESPAY_ALL);
		List<SortItem> sortItemList = new ArrayList<SortItem>();
		SortItem sortItem1 = new SortItem();
		sortItem1.setSortFeild("id");
		sortItem1.setSortType(SortType.DESC);
		sortItemList.add(sortItem1);
		salesCondition.setSortItemList(sortItemList);
		
		if(!StringHelper.isNullOrEmpty(this.productType)){
			salesCondition.setProductType(Integer.valueOf(productType));
		}
		/*if(!StringHelper.isNullOrEmpty(this.p2pProductNo)){
			salesCondition.setP2pProductNo(Integer.valueOf(p2pProductNo));
		}*/
		if(!StringHelper.isNullOrEmpty(this.statusStr)){
			salesCondition.setStatusStr(statusStr);
		}
		pagedSalesList=SalesModel.getPagingList(salesCondition);
		totalCount = pagedSalesList.getPagingInfo().getTotalCount();
		pageCount = pagedSalesList.getPagingInfo().getPageCount();
		List<DicData> paymenttypeList = DicDataModel.getDicDataListByType(StatusType.PAYMENTTYPE_NUM);
		for (Sales sales : pagedSalesList.getResultList()) {
//			sales.setPurchaseDateStr(DateHelper.format(sales.getPurchaseDate()));
			sales.setPurchaseDateStr(sales.getPurchaseDate().toString());
			for(DicData dic : paymenttypeList){
				if(sales.getPaymentType() == dic.getCode()){
					sales.setPaymentTypeDes(dic.getValue());
				}
			}
			if(StringHelper.isNullOrEmpty(sales.getP2pProductName())){
				Product p = ProductModel.getInfo(sales.getProductNo());
				sales.setP2pProductName(p.getName());
			}
			Employee e = EmployeeModel.getEmpByUserId(sales.getEmpNo());
			if(e!=null){
				String empCellphone = e.getCellphone1();
				if(StringHelper.isNullOrEmpty(empCellphone)){
					empCellphone = e.getCellphone2();
				}
				if(StringHelper.isNullOrEmpty(empCellphone)){
					empCellphone = e.getTelephone();
				}
				sales.setEmpCellphone(empCellphone);		
				sales.setEmpName(e.getName());
			}
			List<PaymentRefund> paymentRefundList = PaymentRefundModel.getInfoBySalesId(sales.getId());
			List<PaymentRefund> pl = new ArrayList<PaymentRefund>();
			for(PaymentRefund paymentRefund:paymentRefundList){
				if(paymentRefund.getStatus()==StatusType.FINISHPAYMENT){//已还款的
					pl.add(paymentRefund);
				}
			}
			sales.setPaymentRefundList(pl);
		}
		this.productDetailsUrl = UrlHelper.buildWWWSiteUrl(PageAlias.productDetails);
        return SUCCESS;
	}
}
