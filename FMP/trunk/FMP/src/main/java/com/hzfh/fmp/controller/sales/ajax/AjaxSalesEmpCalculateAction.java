package com.hzfh.fmp.controller.sales.ajax;

import com.hzfh.api.sales.model.SalesEmpCalculate;
import com.hzfh.api.sales.model.query.SalesEmpCalculateCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.sales.SalesEmpCalculateModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


public class AjaxSalesEmpCalculateAction extends JqGridBaseAction<SalesEmpCalculate> {
    
	private String salesCode;
	public String getSalesCode() {
		return salesCode;
	}
	public void setSalesCode(String salesCode) {
		this.salesCode = salesCode;
	}
	private String dealTime;
	public String getDealTime() {
		return dealTime;
	}
	public void setDealTime(String dealTime) {
		this.dealTime = dealTime;
	}
	private String moneySale;
	public String getMoneySale() {
		return moneySale;
	}
	public void setMoneySale(String moneySale) {
		this.moneySale = moneySale;
	}
	private String moneyContribute;
	public String getMoneyContribute() {
		return moneyContribute;
	}
	public void setMoneyContribute(String moneyContribute) {
		this.moneyContribute = moneyContribute;
	}
	private String calcTime;
	public String getCalcTime() {
		return calcTime;
	}
	public void setCalcTime(String calcTime) {
		this.calcTime = calcTime;
	}

    @Override
    public String execute() throws Exception{
    	SalesEmpCalculateCondition salesEmpCalculateCondition = new SalesEmpCalculateCondition();
        salesEmpCalculateCondition.setPageSize(this.getPageSize());
        salesEmpCalculateCondition.setPageIndex(this.getPageIndex());

        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        salesEmpCalculateCondition.setSortItemList(sortItemList);

        PagedList<SalesEmpCalculate> salesEmpCalculatePagedList= SalesEmpCalculateModel.getPagingList(salesEmpCalculateCondition);
        this.setResultList(salesEmpCalculatePagedList.getResultList());
        this.setPageCount(salesEmpCalculatePagedList.getPagingInfo().getPageCount());
        this.setPageIndex(salesEmpCalculatePagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(salesEmpCalculatePagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }

    public String edit(){
        SalesEmpCalculate salesEmpCalculate = new SalesEmpCalculate();
        
		salesEmpCalculate.setSalesCode(this.salesCode);
		salesEmpCalculate.setDealTime(Timestamp.valueOf(this.dealTime));
		salesEmpCalculate.setMoneySale(Double.valueOf(this.moneySale));
		salesEmpCalculate.setMoneyContribute(Double.valueOf(this.moneyContribute));
		salesEmpCalculate.setCalcTime(Timestamp.valueOf(this.calcTime));
		salesEmpCalculate.setEditUserNo(UserHelper.getEditUserNo());

        if (this.getOper().equalsIgnoreCase("add")) {
        	salesEmpCalculate.setInUserNo(UserHelper.getEditUserNo());
            if (SalesEmpCalculateModel.add(salesEmpCalculate )<=0){
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
                    salesEmpCalculate.setId(Integer.parseInt(this.getId()));
                    if (SalesEmpCalculateModel.update(salesEmpCalculate) <= 0){
                        this.setErrCode("update failed");
                        this.setErrDesc("update failed");
                    }
                }
            }
        }

        return SUCCESS;
    }

}
