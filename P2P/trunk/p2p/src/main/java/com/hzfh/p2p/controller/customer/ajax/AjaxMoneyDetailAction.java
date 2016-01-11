package com.hzfh.p2p.controller.customer.ajax;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.hzfh.api.baseInfo.model.DicData;
import com.hzfh.api.customer.model.P2pCustomer;
import com.hzfh.api.customer.model.PaymentAccountInformation;
import com.hzfh.api.customer.model.PaymentMoneyChange;
import com.hzfh.api.customer.model.query.PaymentMoneyChangeCondition;
import com.hzfh.api.payment.model.PaymentRefund;
import com.hzfh.api.payment.model.query.PaymentRefundCondition;
import com.hzfh.api.product.model.P2pProduct;
import com.hzfh.api.product.model.Product;
import com.hzfh.api.sales.model.Sales;
import com.hzfh.api.sales.model.query.SalesCondition;
import com.hzfh.p2p.controller.common.CommonAction;
import com.hzfh.p2p.model.baseInfo.DicDataModel;
import com.hzfh.p2p.model.common.AuthenticationModel;
import com.hzfh.p2p.model.common.PageAlias;
import com.hzfh.p2p.model.common.helper.UrlHelper;
import com.hzfh.p2p.model.common.parameter.StatusType;
import com.hzfh.p2p.model.common.state.StateValues;
import com.hzfh.p2p.model.customer.P2pCustomerModel;
import com.hzfh.p2p.model.customer.PaymentAccountInformationModel;
import com.hzfh.p2p.model.customer.PaymentMoneyChangeModel;
import com.hzfh.p2p.model.customer.view.PaymentMoneyDetailView;
import com.hzfh.p2p.model.payment.PaymentRefundModel;
import com.hzfh.p2p.model.product.P2pProductModel;
import com.hzfh.p2p.model.product.ProductModel;
import com.hzfh.p2p.model.sales.SalesModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.contract.SortType;
import com.hzframework.helper.StringHelper;

public class AjaxMoneyDetailAction extends CommonAction {

	
	private int pageIndex;
	private int pageCount;
	private int totalCount;
	private PagedList<PaymentMoneyChange> paymentMoneyChangePagedList;
	private PagedList<PaymentRefund> paymentRefundPagedList;
	private PagedList<Sales> salesPagedList;
	private List<PaymentMoneyDetailView> paymentMoneyDetailViews;
	private String paymentMoneyRechargeUrl;
	private String paymentMoneyWithdrawUrl;
	private PaymentAccountInformation paymentAccountInformationl;
	private String moneyChangeType;
	private String startTime;
	private String endTime;
	private byte status;
	private String displayType = "1";//展现类型
	private String productType = "0";//产品类型
	private String p2pProductNo; //产品no
	private List<DicData> productTypeList;//产品类型列表
	private List<Product> productList = new ArrayList<Product>();//除线上的线下产品
	private List<P2pProduct> p2pProductList = new ArrayList<P2pProduct>();//线上
	private double income; //累计收益
	private double unIncome;//即将受益
	private long principal;//待收本金   待还款，待审核

	public PagedList<PaymentRefund> getPaymentRefundPagedList() {
		return paymentRefundPagedList;
	}
	public void setPaymentRefundPagedList(
			PagedList<PaymentRefund> paymentRefundPagedList) {
		this.paymentRefundPagedList = paymentRefundPagedList;
	}
	public PagedList<Sales> getSalesPagedList() {
		return salesPagedList;
	}
	public void setSalesPagedList(PagedList<Sales> salesPagedList) {
		this.salesPagedList = salesPagedList;
	}
	public long getPrincipal() {
		return principal;
	}
	public double getUnIncome() {
		return unIncome;
	}
	public double getIncome() {
		return income;
	}
	public void setP2pProductNo(String p2pProductNo) {
		this.p2pProductNo = p2pProductNo;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public List<Product> getProductList() {
		return productList;
	}
	public List<P2pProduct> getP2pProductList() {
		return p2pProductList;
	}
	public byte getStatus() {
		return status;
	}
	public List<DicData> getProductTypeList() {
		return productTypeList;
	}
	public void setStatus(byte status) {
		this.status = status;
	}
	public String getDisplayType() {
		return displayType;
	}
	public void setDisplayType(String displayType) {
		this.displayType = displayType;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getMoneyChangeType() {
		return moneyChangeType;
	}
	public void setMoneyChangeType(String moneyChangeType) {
		this.moneyChangeType = moneyChangeType;
	}
	public void setPaymentMoneyRechargeUrl(String paymentMoneyRechargeUrl) {
		this.paymentMoneyRechargeUrl = paymentMoneyRechargeUrl;
	}
	public void setPaymentMoneyWithdrawUrl(String paymentMoneyWithdrawUrl) {
		this.paymentMoneyWithdrawUrl = paymentMoneyWithdrawUrl;
	}
	public void setPaymentAccountInformationl(
			PaymentAccountInformation paymentAccountInformationl) {
		this.paymentAccountInformationl = paymentAccountInformationl;
	}
	public PaymentAccountInformation getPaymentAccountInformationl() {
		return paymentAccountInformationl;
	}
	public String getPaymentMoneyRechargeUrl() {
		return paymentMoneyRechargeUrl;
	}
	public String getPaymentMoneyWithdrawUrl() {
		return paymentMoneyWithdrawUrl;
	}
	public List<PaymentMoneyDetailView> getPaymentMoneyDetailViews() {
		return paymentMoneyDetailViews;
	}
	public void setPaymentMoneyDetailViews(
			List<PaymentMoneyDetailView> paymentMoneyDetailViews) {
		this.paymentMoneyDetailViews = paymentMoneyDetailViews;
	}
	public PagedList<PaymentMoneyChange> getPaymentMoneyChangePagedList() {
		return paymentMoneyChangePagedList;
	}
	public void setPaymentMoneyChangePagedList(
			PagedList<PaymentMoneyChange> paymentMoneyChangePagedList) {
		this.paymentMoneyChangePagedList = paymentMoneyChangePagedList;
	}
	public int getPageIndex() {
		return pageIndex <= pageCount?pageIndex:pageCount;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
	@Override
	public String execute(){
	    //this.paymentMoneyRechargeUrl = this.buildWWWSiteUrl(PageAlias.myPaymentMoneyRechargeList);
	   //this.paymentMoneyWithdrawUrl = this.buildWWWSiteUrl(PageAlias.myPaymentMoneyWithdrawList);
		SalesCondition salesCondition = new SalesCondition();
		PaymentRefundCondition paymentRefundCondition = this.getPaymentRefundCondition();
		int p2pCustomerNo = StateValues.getCustomerId();
		if("1".equals(this.displayType)){//已收收益
			paymentRefundCondition.setStatus((byte) StatusType.FINISHPAYMENT);
		}
		if("2".equals(this.displayType)){//待收收益
			paymentRefundCondition.setStatus((byte) StatusType.WAITPAYMENT);
		}
		if(!"3".equals(this.displayType)){
			paymentRefundPagedList = PaymentRefundModel.getPagingList(paymentRefundCondition);
			totalCount = paymentRefundPagedList.getPagingInfo().getTotalCount();
			pageCount = paymentRefundPagedList.getPagingInfo().getPageCount();
		}
		if("3".equals(this.displayType)){//待收本金
			salesCondition.setPageIndex(pageIndex);
			salesCondition.setPageSize(5);
			salesCondition.setP2pCustomerNo(p2pCustomerNo);
			salesCondition.setPayType(StatusType.PAY_TYPE);
			P2pCustomer p2pCustomer =  P2pCustomerModel.getInfo(AuthenticationModel.getCustomerId());
			byte online = 1;//线上线下融合
			if(p2pCustomer.getCustomerNo()==0){
				online=0;
			}
			salesCondition.setOnline(online);
			salesCondition.setCustomer(p2pCustomer.getCustomerNo());
			
			salesCondition.getStartIndex();
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
			if (!StringHelper.isNullOrEmpty(this.startTime)) {
				salesCondition.setStartTime(this.startTime);
			}
			if (!StringHelper.isNullOrEmpty(this.endTime)) {
				salesCondition.setEndTime(this.endTime);
			}
			salesCondition.setStatus(StatusType.AUTHENTICATIONOK);//待收本金状态
			salesPagedList=SalesModel.getPagingList(salesCondition);
			totalCount = salesPagedList.getPagingInfo().getTotalCount();
			pageCount = salesPagedList.getPagingInfo().getPageCount();
		}
		if(paymentRefundPagedList!=null){
			for(PaymentRefund pr:paymentRefundPagedList.getResultList()){
				Sales s = SalesModel.getInfo(pr.getSalesNo());
				pr.setSalesTime(s.getPurchaseDate());//投资时间
			}
		}
		
		//this.bindMoneyDetail();
		
		return SUCCESS;
	}
	
	/**
	 * 获取资金明细中的查询条件
	 * @return
	 */
	public String getMoneyDetailCondition(){
		int customerNo = StateValues.getCustomerId();
		byte status =StatusType.FINISHPAYMENT;
		Double di = PaymentRefundModel.getInvestmentIncome(customerNo,status);
        Double du = PaymentRefundModel.getInvestIncomeingByCustomerNo(customerNo);
        if(di!=null)
        	income = di;
        if(du!=null) 
        	unIncome = du;
		status = StatusType.AUTHENTICATIONOK;//认购成功   待收本金状态6
		Long principalMoney = SalesModel.getWillHavingPrincipal(customerNo,status);
		if(principalMoney!=null){
			principal = principalMoney;
		}
		this.productTypeList = DicDataModel.getDicDataListByType(StatusType.PRODUCTTYPE);
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
		return SUCCESS;
	}
	private PaymentRefundCondition getPaymentRefundCondition(){
		PaymentRefundCondition paymentRefundCondition = new PaymentRefundCondition();
		int p2pCustomerNo = AuthenticationModel.getCustomerId();
		paymentRefundCondition.setP2pCustomerNo(p2pCustomerNo);
		
		P2pCustomer p2pCustomer =  P2pCustomerModel.getInfo(p2pCustomerNo);
		byte online = 1;//线上线下融合
		if(p2pCustomer.getCustomerNo()==0){
			online=0;
		}
		paymentRefundCondition.setOnline(online);
		paymentRefundCondition.setCustomerNo(p2pCustomer.getCustomerNo());
		
		
		paymentRefundCondition.setPageIndex(pageIndex);
		paymentRefundCondition.setStatus(status);
		paymentRefundCondition.setPageSize(5);
		List<SortItem> sortItemList = new ArrayList<SortItem>();
		SortItem sortItem1 = new SortItem();
		sortItem1.setSortFeild("id");
		sortItem1.setSortType(SortType.DESC);
		sortItemList.add(sortItem1);
		paymentRefundCondition.setSortItemList(sortItemList);
		if(!StringHelper.isNullOrEmpty(this.productType)){
			paymentRefundCondition.setProductType(Integer.valueOf(productType));
		}
		/*if(!StringHelper.isNullOrEmpty(p2pProductNo)){
			paymentRefundCondition.setP2pProductNo(Integer.valueOf(p2pProductNo));
		}*/
		if (!StringHelper.isNullOrEmpty(this.startTime)) {
			paymentRefundCondition.setStartTime(this.startTime);
		}
		if (!StringHelper.isNullOrEmpty(this.endTime)) {
			paymentRefundCondition.setEndTime(this.endTime);
		}
		paymentRefundCondition.setSmsStatus(-1);
		paymentRefundCondition.setPayType((byte) -1);//支付方式 0线下，1线上
		paymentRefundCondition.setIsNow(0);
		return paymentRefundCondition;
	}
/*	private PaymentMoneyChangeCondition getCondition(){
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
		if (!StringHelper.isNullOrEmpty(this.moneyChangeType)) {
			paymentMoneyChangeCondition.setMoneyChangeType(Integer.valueOf(this.moneyChangeType));
		}
		if (!StringHelper.isNullOrEmpty(this.startTime)) {
			paymentMoneyChangeCondition.setStartTime(this.startTime);
		}
		if (!StringHelper.isNullOrEmpty(this.endTime)) {
			paymentMoneyChangeCondition.setEndTime(this.endTime);
		}
		return paymentMoneyChangeCondition;
	}*/
	
	
	/*private void bindMoneyDetail(){
		int customerNo = AuthenticationModel.getCustomerId();
		if (customerNo<=0) {
			return;
		}
		PaymentAccountInformation paymentAccountInformation = PaymentAccountInformationModel.getInfoByCustomerNo(customerNo);
		if (paymentAccountInformation==null) {
			return;
		}
		this.paymentAccountInformationl = paymentAccountInformation;
		PaymentMoneyChangeCondition paymentMoneyChangeCondition = this.getCondition();
		if (paymentMoneyChangeCondition==null) {
			return;
		}
		this.paymentMoneyChangePagedList = PaymentMoneyChangeModel.getPagingList(paymentMoneyChangeCondition);
		
		if (paymentMoneyChangePagedList==null&&paymentMoneyChangePagedList.getResultList().size()<=0) {
			return;
		}
		this.totalCount = paymentMoneyChangePagedList.getPagingInfo().getTotalCount();
		this.pageCount = paymentMoneyChangePagedList.getPagingInfo().getPageCount();
		List<PaymentMoneyDetailView> paymentMoneyDetailViews = new ArrayList<PaymentMoneyDetailView>();
		for (PaymentMoneyChange paymentMoneyChange : paymentMoneyChangePagedList.getResultList()) {
			PaymentMoneyDetailView paymentMoneyDetailViewTemp = new PaymentMoneyDetailView();
			SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
			String finalTime = time.format(paymentMoneyChange.getTimeCreate());
			paymentMoneyDetailViewTemp.setMoneyDetailTime(finalTime);
			paymentMoneyDetailViewTemp.setMoneyDetailBalance(String.valueOf(paymentMoneyChange.getMoneyAmountLater()));
			paymentMoneyDetailViewTemp.setMoneyDetailNote(paymentMoneyChange.getNote());
			
			String balanceMoney = String.valueOf(paymentMoneyChange.getMoneyWithdraw());
			switch (paymentMoneyChange.getMoneyChangeType()) {
			case 1:
				paymentMoneyDetailViewTemp.setMoneyDetailType("充值");
				paymentMoneyDetailViewTemp.setMoneyDetailIncome(balanceMoney);
				break;
			case 2:
				paymentMoneyDetailViewTemp.setMoneyDetailType("冻结");
				paymentMoneyDetailViewTemp.setMoneyDetailExpend(balanceMoney);
				paymentMoneyDetailViewTemp.setMoneyDetailNote("平台确认后，扣除");
				break;
			case 3:
				paymentMoneyDetailViewTemp.setMoneyDetailType("提现");
				paymentMoneyDetailViewTemp.setMoneyDetailExpend(balanceMoney);
				break;
			case 9:
				paymentMoneyDetailViewTemp.setMoneyDetailType("收款");
				paymentMoneyDetailViewTemp.setMoneyDetailIncome(balanceMoney);
				break;
			case 10:
				paymentMoneyDetailViewTemp.setMoneyDetailType("付款");
				paymentMoneyDetailViewTemp.setMoneyDetailExpend(balanceMoney);
				break;
			default:
				break;
			}
			
			
			listItems.add(new ListItem("充值", "1"));
			listItems.add(new ListItem("提现", "3"));
			listItems.add(new ListItem("冻结", "2"));
			listItems.add(new ListItem("收款", "9"));
			listItems.add(new ListItem("支付", "10"));
			
			paymentMoneyDetailViews.add(paymentMoneyDetailViewTemp);
			
		}
		
		this.paymentMoneyDetailViews = paymentMoneyDetailViews;
		
	}	*/
}
