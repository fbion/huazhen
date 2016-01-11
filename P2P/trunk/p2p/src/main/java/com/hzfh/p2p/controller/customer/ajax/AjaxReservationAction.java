package com.hzfh.p2p.controller.customer.ajax;

import com.hzfh.api.employee.model.Employee;
import com.hzfh.api.product.model.P2pProduct;
import com.hzfh.api.sales.model.P2pSubscribe;
import com.hzfh.api.sales.model.query.P2pSubscribeCondition;
import com.hzfh.p2p.controller.common.CommonAction;
import com.hzfh.p2p.model.baseInfo.EmployeeModel;
import com.hzfh.p2p.model.common.AuthenticationModel;
import com.hzfh.p2p.model.common.PageAlias;
import com.hzfh.p2p.model.common.helper.MoneyHelper;
import com.hzfh.p2p.model.common.helper.UrlHelper;
import com.hzfh.p2p.model.product.P2pProductModel;
import com.hzfh.p2p.model.sales.P2pSubscribeModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.contract.SortType;
import com.hzframework.helper.StringHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AjaxReservationAction extends CommonAction {


	private int pageIndex;
	private PagedList<P2pSubscribe> p2pSubscribePagedList;
	
	
    public PagedList<P2pSubscribe> getP2pSubscribePagedList() {
		return p2pSubscribePagedList;
	}

	public void setP2pSubscribePagedList(
			PagedList<P2pSubscribe> p2pSubscribePagedList) {
		this.p2pSubscribePagedList = p2pSubscribePagedList;
	}

	public int getPageIndex() {
		return pageIndex <= pageCount?pageIndex:pageCount;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	private int pageCount;
	private int totalCount;
	
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
	
	
	private String p2pProductNo;
	public void setP2pProductNo(String p2pProductNo) {
		this.p2pProductNo = p2pProductNo;
	}
	private String visitTime;
	public void setVisitTime(String visitTime) {
		this.visitTime = visitTime;
	}
	
	private String productDetailsUrl;

	public String getProductDetailsUrl() {
		return productDetailsUrl;
	}

	@Override
	public String execute(){
		
		
		P2pSubscribeCondition p2pSubscribeCondition = new P2pSubscribeCondition();
		p2pSubscribeCondition.setPageIndex(pageIndex);
		p2pSubscribeCondition.setCustomerNo(AuthenticationModel.getCustomerId());
		//p2pSubscribeCondition.setStatus(1);
		p2pSubscribeCondition.setEmpNo(-1);
		p2pSubscribeCondition.setIsTest((byte) -1);
		p2pSubscribeCondition.getStartIndex();
		p2pSubscribeCondition.setPageSize(8);
		
	
		List<SortItem> sortItemList = new ArrayList<SortItem>();
		SortItem sortItem1 = new SortItem();
		sortItem1.setSortFeild("id");
		sortItem1.setSortType(SortType.DESC);
		sortItemList.add(sortItem1);
		p2pSubscribeCondition.setSortItemList(sortItemList);
		
		if(!StringHelper.isNullOrEmpty(p2pProductNo)){
			p2pSubscribeCondition.setByP2pProductNo(Integer.valueOf(p2pProductNo));
		}
		if(!StringHelper.isNullOrEmpty(visitTime)){
			p2pSubscribeCondition.setVisitTime(visitTime.trim());
		}
		
		//p2pSubscribeCondition.setIsTest((byte) 0);
		
		p2pSubscribePagedList = P2pSubscribeModel.getPagingList(p2pSubscribeCondition);
		totalCount = p2pSubscribePagedList.getPagingInfo().getTotalCount();
		pageCount = p2pSubscribePagedList.getPagingInfo().getPageCount();
		for (P2pSubscribe p2pSubscribe : p2pSubscribePagedList.getResultList()) {
			P2pProduct p2pProduct = P2pProductModel.getInfo(p2pSubscribe.getP2pProductNo());
			if(p2pProduct!=null)
				p2pSubscribe.setP2pProductName(p2pProduct.getName());
			if(p2pSubscribe.getEmpNo()!=0){
				Employee e = EmployeeModel.getEmpByUserId(p2pSubscribe.getEmpNo());
				if(e!=null){
					p2pSubscribe.setEmpName(e.getName());
					String empCellphone = e.getCellphone1();
					if(StringHelper.isNullOrEmpty(empCellphone)){
						empCellphone = e.getCellphone2();
					}
					if(StringHelper.isNullOrEmpty(empCellphone)){
						empCellphone = e.getTelephone();
					}
					p2pSubscribe.setEmpCellphone(empCellphone);
				}
			}
			p2pSubscribe.setSwitchAmount(MoneyHelper.getMoney(p2pSubscribe.getAmount()));
		}
		this.productDetailsUrl = UrlHelper.buildWWWSiteUrl(PageAlias.productDetails);
        return SUCCESS;
	}
}
