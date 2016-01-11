package com.hzfh.weixin.controller.product.ajax;


import java.util.ArrayList;
import java.util.List;

import com.hzfh.api.customer.model.CustomerPersonal;
import com.hzfh.api.customer.model.P2pCustomer;
import com.hzfh.api.customer.model.PaymentAccountInformation;
import com.hzfh.api.payment.model.request.controller.AccountInfoReq;
import com.hzfh.api.payment.model.response.controller.AccountInfoResp;
import com.hzfh.api.product.model.P2pProduct;
import com.hzfh.api.product.model.query.P2pProductCondition;
import com.hzfh.api.sales.model.P2pSubscribe;
import com.hzfh.api.sales.model.Sales;
import com.hzfh.api.sales.model.query.SalesCondition;
import com.hzfh.weixin.controller.common.JsonBaseAction;
import com.hzfh.weixin.model.baseInfo.CustomerPersonalModel;
import com.hzfh.weixin.model.common.AuthenticationModel;
import com.hzfh.weixin.model.common.helper.MoneyHelper;
import com.hzfh.weixin.model.common.state.StateValues;
import com.hzfh.weixin.model.customer.P2pCustomerModel;
import com.hzfh.weixin.model.customer.PaymentAccountInformationModel;
import com.hzfh.weixin.model.payment.ControllerModel;
import com.hzfh.weixin.model.product.P2pProductModel;
import com.hzfh.weixin.model.sales.SalesModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.contract.SortType;
import com.hzframework.helper.StringHelper;

/**
 * Created by paul on 15-2-5.
 */
public class AjaxProductDetailAction extends JsonBaseAction<P2pProduct> {
	private int p2pProductNo;
	private int amount;
	private List<Sales> p2pProductRecordList;
	private int flag;
	
	
   
	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public void setP2pProductNo(int p2pProductNo) {
		this.p2pProductNo = p2pProductNo;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	private int pageIndex=1;
	private PagedList<Sales> Pagedp2pProductRecordList;
	private int pageCount;
	private int totalCount;
	
	public int getPageIndex() {
		return pageIndex <= pageCount?pageIndex:pageCount;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public PagedList<Sales> getPagedp2pProductRecordList() {
		return Pagedp2pProductRecordList;
	}

	public void setPagedp2pProductRecordList(
			PagedList<Sales> pagedp2pProductRecordList) {
		Pagedp2pProductRecordList = pagedp2pProductRecordList;
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

	public List<Sales> getP2pProductRecordList() {
		return p2pProductRecordList;
	}

	@Override
    public String execute() {
		int userId = AuthenticationModel.getCustomerId();
		if(userId==0){
			this.message.setType(MessageType.Info);
			this.message.setDescription("请登录后操作！");
			return SUCCESS;
		}
		PaymentAccountInformation paymentAccountInformation = PaymentAccountInformationModel.getInfoByCustomerNo(userId);
		if(paymentAccountInformation.getAuthenticationEmail()==0){
			this.message.setType(MessageType.Info);
			this.message.setDescription("请先邮箱认证后操作！");
			return SUCCESS;
		}
		if(paymentAccountInformation.getAuthenticationName()==0){
			this.message.setType(MessageType.Info);
			this.message.setDescription("请先实名认证后操作！");
			return SUCCESS;
		}
		if(paymentAccountInformation.getAccountPwd()==0){
			this.message.setType(MessageType.Info);
			this.message.setDescription("请先设置交易密码后操作！");
			return SUCCESS;
		}
		this.message = new Message();
		P2pCustomer p2pCustomer = P2pCustomerModel.getInfo(userId);
		P2pProduct p2pProduct =  P2pProductModel.getInfo(p2pProductNo);
		long reservationMoney = p2pProduct.getRemainAmout();
		int minMoney = p2pProduct.getMinMoney();
		if(amount>reservationMoney){
			this.message.setType(MessageType.Info);
			this.message.setDescription("投资金额需小于产品剩余金额！");
			return SUCCESS;
		}
		if(amount<minMoney){
			this.message.setType(MessageType.Info);
			this.message.setDescription("投资起购价为"+MoneyHelper.getMoney(minMoney)+ "元！");
			return SUCCESS;
		}
		
		AccountInfoReq accountInfoReq = new AccountInfoReq();
        accountInfoReq.setPlatformUserNo(String.valueOf(StateValues.getCustomerId()));
        accountInfoReq.setPlatformNo(accountInfoReq.getPlatformNo());
        AccountInfoResp accountInfoResp = ControllerModel.getAccountInfo(accountInfoReq);
        if(accountInfoResp!=null){
        	if(amount>accountInfoResp.getAvailableAmount()){
        		this.message.setType(MessageType.Info);
    			this.message.setDescription("账户余额不足！");
        		return SUCCESS;
        	}
        }
	   return SUCCESS;
    }
	/**
	 * 取该产品的投资记录
	 * @return
	 */
	public String getProductRecordList(){
		this.Pagedp2pProductRecordList = SalesModel.getPagingList(this.getCondition());
		if(Pagedp2pProductRecordList==null){
			this.flag = 0;
			return SUCCESS;
		}
		if(Pagedp2pProductRecordList!=null){
			this.flag = Pagedp2pProductRecordList.getResultList().size();
			this.p2pProductRecordList = Pagedp2pProductRecordList.getResultList();
			totalCount = Pagedp2pProductRecordList.getPagingInfo().getTotalCount();
			pageCount = Pagedp2pProductRecordList.getPagingInfo().getPageCount();
			/*int no = -1;
			String name = "";
			for(Sales sales:p2pProductRecordList){
				if(no!=sales.getP2pCustomerNo()){
					name = P2pCustomerModel.getInfo(sales.getP2pCustomerNo()).getUserName();
					no = sales.getP2pCustomerNo();
				}
				sales.setP2pCustomerName(name);
			}*/
			
			String name = "**";
			for(Sales sales:p2pProductRecordList){
				int p2pCustomerNo = sales.getP2pCustomerNo();
				if(p2pCustomerNo!=0){
					P2pCustomer p2pCustomer = P2pCustomerModel.getInfo(p2pCustomerNo);
					if(p2pCustomer!=null){
						name = p2pCustomer.getCellphone();
					}
				}else{
					int customerNo = sales.getCustomerNo();
					CustomerPersonal customer = CustomerPersonalModel.getInfo(customerNo);
					if(customer!=null){
						name = customer.getCellphone1();
						if(StringHelper.isNullOrEmpty(name)){
							name = customer.getCellphone2();
							if(StringHelper.isNullOrEmpty(name)){
								name = customer.getPhone();
							}
						}
					}
				}
				if(!StringHelper.isNullOrEmpty(name)){
					name = name.substring(0,3)+"****"+name.substring(7);
				}else{
					name = "**";
				}
				/*String cName="**";
				if(!StringHelper.isNullOrEmpty(name)){
					cName = name.substring(0,1);
					for(int i=0 ;i<name.length()-1;i++){
						cName = cName +" *";
					}
				}*/
				P2pProduct p2pProduct = P2pProductModel.getInfo(p2pProductNo);

				String  income = p2pProduct.getIncome()+"%";
				if(p2pProduct.getFloatingIncome()!=0){
					income = p2pProduct.getIncome()+"% ± "+p2pProduct.getFloatingIncome()+"%";
				}
				//sales.setIncomeMoney(incomeMoney);
				sales.setPurchaseDateStr(income);
				sales.setP2pCustomerName(name);
			}
		}
		return SUCCESS;
	}
	
	public SalesCondition getCondition(){
		SalesCondition salesCondition = new SalesCondition();
		salesCondition.setPageIndex(pageIndex);
		salesCondition.setPageSize(5);
		//salesCondition.getStartIndex();
		//salesCondition.setP2pProductNo(p2pProductNo);
		salesCondition.setPayType(-1);
		salesCondition.setStatusStr("2,3,6,7,10");
		
		
		P2pProduct  p2pProduct = P2pProductModel.getInfo(p2pProductNo);
		salesCondition.setProduct(p2pProduct.getProductNo());
		
		List<SortItem> sortItemList = new ArrayList<SortItem>();
		SortItem sortItem = new SortItem();
		sortItem.setSortFeild("id");
		sortItem.setSortType(SortType.DESC);
		sortItemList.add(sortItem);
		salesCondition.setSortItemList(sortItemList);
		
		return salesCondition;
	}
}
