package com.hzfh.fmp.controller.sales.ajax;

import com.hzfh.api.sales.model.AgentExpense;
import com.hzfh.api.sales.model.query.AgentExpenseCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.common.helper.CodeHelper;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.sales.AgentExpenseModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


public class AjaxAgentExpenseAction extends JqGridBaseAction<AgentExpense> {
    
	private String code;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private String customerType;
	public String getCustomerType() {
		return customerType;
	}
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	private String customerNo;
	public String getCustomerNo() {
		return customerNo;
	}
	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}
	private String salesNo;
	public String getSalesNo() {
		return salesNo;
	}
	public void setSalesNo(String salesNo) {
		this.salesNo = salesNo;
	}
	private String payTotal;
	public String getPayTotal() {
		return payTotal;
	}
	public void setPayTotal(String payTotal) {
		this.payTotal = payTotal;
	}
	private String payFirst;
	public String getPayFirst() {
		return payFirst;
	}
	public void setPayFirst(String payFirst) {
		this.payFirst = payFirst;
	}
	private String payRemain;
	public String getPayRemain() {
		return payRemain;
	}
	public void setPayRemain(String payRemain) {
		this.payRemain = payRemain;
	}
	private String payReal;
	public String getPayReal() {
		return payReal;
	}
	public void setPayReal(String payReal) {
		this.payReal = payReal;
	}
	private String payDate;
	public String getPayDate() {
		return payDate;
	}
	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}
	private String agentType;
	public String getAgentType() {
		return agentType;
	}
	public void setAgentType(String agentType) {
		this.agentType = agentType;
	}
	private String agentNo;
	public String getAgentNo() {
		return agentNo;
	}
	public void setAgentNo(String agentNo) {
		this.agentNo = agentNo;
	}
	private String payType;
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	private String receiptNumber;
	public String getReceiptNumber() {
		return receiptNumber;
	}
	public void setReceiptNumber(String receiptNumber) {
		this.receiptNumber = receiptNumber;
	}
	private String comment;
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

	private String byCustomerType;
	private String byCustomer;
	private String byAgentType;
	private String byAgent;
    public String getByCustomerType() {
		return byCustomerType;
	}
	public void setByCustomerType(String byCustomerType) {
		this.byCustomerType = byCustomerType;
	}
	public String getByCustomer() {
		return byCustomer;
	}
	public void setByCustomer(String byCustomer) {
		this.byCustomer = byCustomer;
	}
	public String getByAgentType() {
		return byAgentType;
	}
	public void setByAgentType(String byAgentType) {
		this.byAgentType = byAgentType;
	}
	public String getByAgent() {
		return byAgent;
	}
	public void setByAgent(String byAgent) {
		this.byAgent = byAgent;
	}
	@Override
    public String execute() throws Exception{
    	AgentExpenseCondition agentExpenseCondition = new AgentExpenseCondition();
        agentExpenseCondition.setPageSize(this.getPageSize());
        agentExpenseCondition.setPageIndex(this.getPageIndex());

        if (StringHelper.isNullOrEmpty(this.byCustomerType)) {
			agentExpenseCondition.setCustomerType(0);
		}else{
			agentExpenseCondition.setCustomerType(Integer.parseInt(this.byCustomerType));
		}
        if (StringHelper.isNullOrEmpty(this.byCustomer)) {
			agentExpenseCondition.setCustomer(0);
		}else{
			agentExpenseCondition.setCustomer(Integer.parseInt(this.byCustomer));
		}
        if (StringHelper.isNullOrEmpty(this.byAgentType)) {
			agentExpenseCondition.setAgentType(0);
		}else{
			agentExpenseCondition.setAgentType(Integer.parseInt(this.byAgentType));
		}
        if (StringHelper.isNullOrEmpty(this.byAgent)) {
			agentExpenseCondition.setAgent(0);
		}else{
			agentExpenseCondition.setAgent(Integer.parseInt(this.byAgent));
		}
        
        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        agentExpenseCondition.setSortItemList(sortItemList);

        PagedList<AgentExpense> agentExpensePagedList= AgentExpenseModel.getPagingList(agentExpenseCondition);
        this.setResultList(agentExpensePagedList.getResultList());
        this.setPageCount(agentExpensePagedList.getPagingInfo().getPageCount());
        this.setPageIndex(agentExpensePagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(agentExpensePagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }

    public String edit(){
        AgentExpense agentExpense = new AgentExpense();
        
		//agentExpense.setCode(this.code);
		agentExpense.setName(this.name);
		if(!StringHelper.isNullOrEmpty(this.customerType)){
		agentExpense.setCustomerType(Byte.valueOf(this.customerType));
		}
		if (!StringHelper.isNullOrEmpty(this.customerNo)) {
			agentExpense.setCustomerNo(Integer.valueOf(this.customerNo));
		}
		if (!StringHelper.isNullOrEmpty(this.salesNo)) {
		agentExpense.setSalesNo(Integer.valueOf(this.salesNo));	
		}else{
		agentExpense.setSalesNo(Integer.valueOf("0"));	
		}
		if (!StringHelper.isNullOrEmpty(this.payTotal)) {
		agentExpense.setPayTotal(Long.valueOf(this.payTotal));
		}
		if (!StringHelper.isNullOrEmpty(this.payFirst)) {
		agentExpense.setPayFirst(Long.valueOf(this.payFirst));	
		}
		if (!StringHelper.isNullOrEmpty(this.payRemain)) {
		agentExpense.setPayRemain(Long.valueOf(this.payRemain));	
		}
		if (!StringHelper.isNullOrEmpty(this.payReal)) {
		agentExpense.setPayReal(Long.valueOf(this.payReal));	
		}
		if (!StringHelper.isNullOrEmpty(this.payDate)) {
		agentExpense.setPayDate(Timestamp.valueOf(this.payDate));	
		}else{
		agentExpense.setPayDate(null);	
		}
		if (!StringHelper.isNullOrEmpty(this.agentType)) {
		agentExpense.setAgentType(Byte.valueOf(this.agentType));	
		}
		agentExpense.setAgentNo(Integer.valueOf(this.agentNo));
		if (!StringHelper.isNullOrEmpty(this.payType)) {
		agentExpense.setPayType(Byte.valueOf(this.payType));	
		}
		
		agentExpense.setReceiptNumber(this.receiptNumber);
		agentExpense.setComment(this.comment);
		agentExpense.setEditComment(this.getEditComment());
		agentExpense.setEditUserNo(UserHelper.getEditUserNo());

        if (this.getOper().equalsIgnoreCase("add")) {
        	agentExpense.setInUserNo(UserHelper.getEditUserNo());
        	String r = CodeHelper.getCode("codeExpense","ZC");
        	if (!StringHelper.isNullOrEmpty(r)) {
        		agentExpense.setCode(r);
			}
        	if (AgentExpenseModel.add(agentExpense )<=0){
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
                    agentExpense.setId(Integer.parseInt(this.getId()));
                    if (AgentExpenseModel.update(agentExpense) <= 0){
                        this.setErrCode("update failed");
                        this.setErrDesc("update failed");
                    }
                }
            }
        }

        return SUCCESS;
    }

}
