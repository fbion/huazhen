package com.hzfh.fmp.controller.product.ajax;

import com.hzfh.api.product.model.ProductStages;
import com.hzfh.api.product.model.query.ProductStagesCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.product.ProductStagesModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


public class AjaxProductStagesAction extends JqGridBaseAction<ProductStages> {
    
	
	private String sumMoney;
	public String getSumMoney() {
		return sumMoney;
	}
	public void setSumMoney(String sumMoney) {
		this.sumMoney = sumMoney;
	}
	private String productNo;
	public String getProductNo() {
		return productNo;
	}
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	private String stage;
	public String getStage() {
		return stage;
	}
	public void setStage(String stage) {
		this.stage = stage;
	}
	private String start;
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	private String end;
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	private String dayCount;
	public String getDayCount() {
		return dayCount;
	}
	public void setDayCount(String dayCount) {
		this.dayCount = dayCount;
	}
	private String amount;
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	private String reason;
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}

	private String byProductNo;
	private String byStages;
	public String getByStages() {
		return byStages;
	}
	public void setByStages(String byStages) {
		this.byStages = byStages;
	}
	
	public String getByProductNo() {
		return byProductNo;
	}
	public void setByProductNo(String byProductNo) {
		this.byProductNo = byProductNo;
	}
	@Override
    public String execute() throws Exception{
    	ProductStagesCondition productStagesCondition = new ProductStagesCondition();
        productStagesCondition.setPageSize(this.getPageSize());
        productStagesCondition.setPageIndex(this.getPageIndex());

        if (!StringHelper.isNullOrEmpty(this.byStages)) {
			productStagesCondition.setStages(this.byStages);
		}
        
        if (StringHelper.isNullOrEmpty(this.byProductNo)) {
			productStagesCondition.setProductNo(0);
		}else{
			productStagesCondition.setProductNo(Integer.parseInt(this.byProductNo));
		}
        
        
        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        productStagesCondition.setSortItemList(sortItemList);

        PagedList<ProductStages> productStagesPagedList= ProductStagesModel.getPagingList(productStagesCondition);
        this.setResultList(productStagesPagedList.getResultList());
        this.setPageCount(productStagesPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(productStagesPagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(productStagesPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }

    public String edit(){
        ProductStages productStages = new ProductStages();
        if (!StringHelper.isNullOrEmpty(this.sumMoney)) {
        productStages.setSumMoney(Long.parseLong(this.sumMoney));	
		}
		productStages.setProductNo(Integer.parseInt(this.productNo));
		productStages.setStage(Integer.parseInt(this.stage));
		if (!StringHelper.isNullOrEmpty(this.start)) {
		productStages.setStart(Timestamp.valueOf(this.start+" 00:00:00"));	
		}else{
		productStages.setStart(null);
		}
		if (!StringHelper.isNullOrEmpty(this.end)) {
		productStages.setEnd(Timestamp.valueOf(this.end+" 00:00:00"));
		}else{
			productStages.setEnd(null);
		}
		productStages.setDayCount(Integer.parseInt(this.dayCount));
		productStages.setAmount(Long.parseLong(this.amount));
		productStages.setReason(this.reason);
		productStages.setEditComment(this.getEditComment());
		productStages.setEditUserNo(UserHelper.getEditUserNo());

        if (this.getOper().equalsIgnoreCase("add")) {
        	productStages.setInUserNo(UserHelper.getEditUserNo());
            if (ProductStagesModel.add(productStages )<=0){
                this.setErrCode("add failed");
                this.setErrDesc("add failed");
            }
        }
        else
        {
            if (this.getId().isEmpty()) {
                this.setErrCode("NoID");
                this.setErrDesc("NoID");
            }
            else{
                if (this.getOper().equalsIgnoreCase("edit")) {
                    productStages.setId(Integer.parseInt(this.getId()));
                    if (ProductStagesModel.update(productStages) <= 0){
                        this.setErrCode("update failed");
                        this.setErrDesc("update failed");
                    }
                }
            }
        }

        return SUCCESS;
    }

}
