package com.hzfh.fmp.controller.sales.ajax;

import com.hzfh.api.sales.model.BrokerageCalculate;
import com.hzfh.api.sales.model.query.BrokerageCalculateCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.sales.BrokerageCalculateModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


public class AjaxBrokerageCalculateAction extends JqGridBaseAction<BrokerageCalculate> {
    
	private String empNo;
	public String getEmpNo() {
		return empNo;
	}
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	private String moneyTotal;
	public String getMoneyTotal() {
		return moneyTotal;
	}
	public void setMoneyTotal(String moneyTotal) {
		this.moneyTotal = moneyTotal;
	}
	private String sumOrder;
	public String getSumOrder() {
		return sumOrder;
	}
	public void setSumOrder(String sumOrder) {
		this.sumOrder = sumOrder;
	}
	private String moneyBrokerage;
	public String getMoneyBrokerage() {
		return moneyBrokerage;
	}
	public void setMoneyBrokerage(String moneyBrokerage) {
		this.moneyBrokerage = moneyBrokerage;
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
    	BrokerageCalculateCondition brokerageCalculateCondition = new BrokerageCalculateCondition();
        brokerageCalculateCondition.setPageSize(this.getPageSize());
        brokerageCalculateCondition.setPageIndex(this.getPageIndex());

        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        brokerageCalculateCondition.setSortItemList(sortItemList);

        PagedList<BrokerageCalculate> brokerageCalculatePagedList= BrokerageCalculateModel.getPagingList(brokerageCalculateCondition);
        this.setResultList(brokerageCalculatePagedList.getResultList());
        this.setPageCount(brokerageCalculatePagedList.getPagingInfo().getPageCount());
        this.setPageIndex(brokerageCalculatePagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(brokerageCalculatePagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }

    public String edit(){
        BrokerageCalculate brokerageCalculate = new BrokerageCalculate();
        
		brokerageCalculate.setEmpNo(Integer.valueOf(this.empNo));
		brokerageCalculate.setMoneyTotal(Double.valueOf(this.moneyTotal));
		brokerageCalculate.setSumOrder(Integer.valueOf(this.sumOrder));
		brokerageCalculate.setMoneyBrokerage(Double.valueOf(this.moneyBrokerage));
		brokerageCalculate.setCalcTime(Timestamp.valueOf(this.calcTime));
		brokerageCalculate.setEditUserNo(UserHelper.getEditUserNo());

        if (this.getOper().equalsIgnoreCase("add")) {
        	brokerageCalculate.setInUserNo(UserHelper.getEditUserNo());
            if (BrokerageCalculateModel.add(brokerageCalculate )<=0){
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
                    brokerageCalculate.setId(Integer.parseInt(this.getId()));
                    if (BrokerageCalculateModel.update(brokerageCalculate) <= 0){
                        this.setErrCode("update failed");
                        this.setErrDesc("update failed");
                    }
                }
            }
        }

        return SUCCESS;
    }

}
