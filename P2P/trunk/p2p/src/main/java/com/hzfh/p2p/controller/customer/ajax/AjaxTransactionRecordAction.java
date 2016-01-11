package com.hzfh.p2p.controller.customer.ajax;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.hzfh.api.baseInfo.model.DicData;
import com.hzfh.api.customer.model.PaymentMoneyChange;
import com.hzfh.api.customer.model.query.PaymentMoneyChangeCondition;
import com.hzfh.api.payment.model.PaymentRefund;
import com.hzfh.api.product.model.P2pProduct;
import com.hzfh.api.sales.model.Sales;
import com.hzfh.api.sales.model.query.SalesCondition;
import com.hzfh.p2p.controller.common.CommonAction;
import com.hzfh.p2p.model.baseInfo.DicDataModel;
import com.hzfh.p2p.model.common.AuthenticationModel;
import com.hzfh.p2p.model.common.PageAlias;
import com.hzfh.p2p.model.common.helper.MoneyHelper;
import com.hzfh.p2p.model.common.helper.UrlHelper;
import com.hzfh.p2p.model.common.parameter.PaymentType;
import com.hzfh.p2p.model.customer.PaymentMoneyChangeModel;
import com.hzfh.p2p.model.payment.PaymentRefundModel;
import com.hzfh.p2p.model.product.P2pProductModel;
import com.hzfh.p2p.model.sales.SalesModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.contract.SortType;
import com.hzframework.helper.DateHelper;
import com.hzframework.helper.StringHelper;

/**
 * Created by paul on 15-2-5.
 */
public class AjaxTransactionRecordAction extends CommonAction{
	private int pageIndex;
	private PagedList<PaymentMoneyChange> paymentMoneyChangeList;
	private int pageCount;
	private int totalCount;
	private int  moneyChangeType;
	
	
	

	

	public int getMoneyChangeType() {
		return moneyChangeType;
	}

	public void setMoneyChangeType(int moneyChangeType) {
		this.moneyChangeType = moneyChangeType;
	}

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

	
	public PagedList<PaymentMoneyChange> getPaymentMoneyChangeList() {
		return paymentMoneyChangeList;
	}

	public int getPageIndex() {
		return pageIndex <= pageCount?pageIndex:pageCount;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	@Override
	public String execute(){
		
		PaymentMoneyChangeCondition paymentMoneyChangeCondition=this.getCondition();
		paymentMoneyChangeList=PaymentMoneyChangeModel.getPagingList(paymentMoneyChangeCondition);
		totalCount = paymentMoneyChangeList.getPagingInfo().getTotalCount();
		pageCount = paymentMoneyChangeList.getPagingInfo().getPageCount();
		for (PaymentMoneyChange paymentMoneyChange : paymentMoneyChangeList.getResultList()) {
			
			paymentMoneyChange.setTimeCreateStr((DateHelper.format(new Date(paymentMoneyChange.getTimeCreate().getTime()), "yyyy-MM-dd HH:mm:ss")));
			
			String   refSn = paymentMoneyChange.getRefSn();
			paymentMoneyChange.getTimeCreate();
			//paymentMoneyChange.setCreateTime(DateHelper.format(new Date(paymentMoneyChange.getTimeCreate().getTime()), "yyyy-MM-dd HH:mm:ss"));
			if(paymentMoneyChange.getMoneyChangeType()==PaymentType.MONEYCHANGE_PAYCONFIRM){//还款
				if(!StringHelper.isNullOrEmpty(refSn)){
					PaymentRefund paymentRefund = PaymentRefundModel.getInfo(Integer.parseInt(refSn));
					if(paymentRefund!=null){
						paymentMoneyChange.setP2pProductName(paymentRefund.getP2pProductName());
					}
				}
			}
			if(paymentMoneyChange.getMoneyChangeType()==PaymentType.MONEYCHANGE_LOANCONFIRM){
				if(!StringHelper.isNullOrEmpty(refSn)){
					Sales sales = SalesModel.getInfo(Integer.parseInt(refSn));
					if(sales!=null){
						paymentMoneyChange.setP2pProductName(sales.getP2pProductName());
					}
				}
			}
			
		}
        return SUCCESS;
	}
	private PaymentMoneyChangeCondition getCondition(){
		PaymentMoneyChangeCondition paymentMoneyChangeCondition = new PaymentMoneyChangeCondition();
		paymentMoneyChangeCondition.setCustomerNo(AuthenticationModel.getCustomerId());
		paymentMoneyChangeCondition.setPageIndex(pageIndex);
		paymentMoneyChangeCondition.getStartIndex();
		paymentMoneyChangeCondition.setPageSize(5);
		List<SortItem> sortItemList = new ArrayList<SortItem>();
		SortItem sortItem1 = new SortItem();
		sortItem1.setSortFeild("time_create");
		sortItem1.setSortType(SortType.DESC);
		sortItemList.add(sortItem1);
		paymentMoneyChangeCondition.setSortItemList(sortItemList);	
		paymentMoneyChangeCondition.setMoneyChangeType(this.moneyChangeType);
		
		
		return paymentMoneyChangeCondition;
	}
}
