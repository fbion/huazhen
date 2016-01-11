package com.hzfh.weixin.controller.customer;

import com.hzfh.api.sales.model.P2pSubscribe;
import com.hzfh.api.sales.model.query.P2pSubscribeCondition;
import com.hzfh.weixin.controller.common.CommonAction;
import com.hzfh.weixin.model.common.AuthenticationModel;
import com.hzfh.weixin.model.common.PageAlias;
import com.hzfh.weixin.model.common.helper.MoneyHelper;
import com.hzfh.weixin.model.common.helper.UrlHelper;
import com.hzfh.weixin.model.product.P2pProductModel;
import com.hzfh.weixin.model.sales.P2pSubscribeModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.contract.SortType;

import java.util.ArrayList;
import java.util.List;

public class ReservationAction extends CommonAction {


	private int pageIndex;
	private int flag;
	private PagedList<P2pSubscribe> p2pSubscribePagedList;
	
	
    public PagedList<P2pSubscribe> getP2pSubscribePagedList() {
		return p2pSubscribePagedList;
	}

	public void setP2pSubscribePagedList(
			PagedList<P2pSubscribe> p2pSubscribePagedList) {
		this.p2pSubscribePagedList = p2pSubscribePagedList;
	}

	public int getPageIndex() {
		return pageIndex;
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
	
	private String productDetailsUrl;
	
	public String getProductDetailsUrl() {
		return productDetailsUrl;
	}

	public void setProductDetailsUrl(String productDetailsUrl) {
		this.productDetailsUrl = productDetailsUrl;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	@Override
	public String execute(){
		P2pSubscribeCondition p2pSubscribeCondition = new P2pSubscribeCondition();
		p2pSubscribeCondition.setPageIndex(pageIndex);
		p2pSubscribeCondition.setCustomerNo(AuthenticationModel.getCustomerId());
		//p2pSubscribeCondition.setStatus(1);
		p2pSubscribeCondition.setEmpNo(-1);
		p2pSubscribeCondition.getStartIndex();
		p2pSubscribeCondition.setPageSize(3);
		
		try {
			List<SortItem> sortItemList = new ArrayList<SortItem>();
			SortItem sortItem1 = new SortItem();
			sortItem1.setSortFeild("id");
			sortItem1.setSortType(SortType.DESC);
			sortItemList.add(sortItem1);
			p2pSubscribeCondition.setSortItemList(sortItemList);
			
			//p2pSubscribeCondition.setIsTest((byte) 0);
			
			try {
				p2pSubscribePagedList = P2pSubscribeModel.getPagingList(p2pSubscribeCondition);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(p2pSubscribePagedList==null){
				this.flag = 0;
				return SUCCESS;
			}
			this.flag = p2pSubscribePagedList.getResultList().size();
			for (P2pSubscribe p2pSubscribe : p2pSubscribePagedList.getResultList()) {
				p2pSubscribe.setP2pProductName(P2pProductModel.getInfo(p2pSubscribe.getP2pProductNo()).getName());
				p2pSubscribe.setSwitchAmount(MoneyHelper.getMoney(p2pSubscribe.getAmount()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		productDetailsUrl = UrlHelper.buildWWWSiteUrl(PageAlias.productDetails);
        return SUCCESS;
	}
}
