package com.hzfh.fmp.controller.sales.ajax;

import com.hzfh.api.sales.model.Income;
import com.hzfh.api.sales.model.query.IncomeCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.common.helper.CodeHelper;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.sales.IncomeModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class AjaxIncomeAction extends JqGridBaseAction<Income> {

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

	private String incomeTotal;

	public String getIncomeTotal() {
		return incomeTotal;
	}

	public void setIncomeTotal(String incomeTotal) {
		this.incomeTotal = incomeTotal;
	}

	private String incomeFirst;

	public String getIncomeFirst() {
		return incomeFirst;
	}

	public void setIncomeFirst(String incomeFirst) {
		this.incomeFirst = incomeFirst;
	}

	private String incomeRemain;

	public String getIncomeRemain() {
		return incomeRemain;
	}

	public void setIncomeRemain(String incomeRemain) {
		this.incomeRemain = incomeRemain;
	}

	private String incomeReal;

	public String getIncomeReal() {
		return incomeReal;
	}

	public void setIncomeReal(String incomeReal) {
		this.incomeReal = incomeReal;
	}

	private String receiveDate;

	public String getReceiveDate() {
		return receiveDate;
	}

	public void setReceiveDate(String receiveDate) {
		this.receiveDate = receiveDate;
	}

	private String partnerType;

	public String getPartnerType() {
		return partnerType;
	}

	public void setPartnerType(String partnerType) {
		this.partnerType = partnerType;
	}

	private String partnerNo;

	public String getPartnerNo() {
		return partnerNo;
	}

	public void setPartnerNo(String partnerNo) {
		this.partnerNo = partnerNo;
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
	
	
	private String byName;
	private String byCustomerType;
	private String byCustomer;
	private String byPartner;
	public String getByName() {
		return byName;
	}

	public void setByName(String byName) {
		this.byName = byName;
	}

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

	public String getByPartner() {
		return byPartner;
	}

	public void setByPartner(String byPartner) {
		this.byPartner = byPartner;
	}

	@Override
	public String execute() throws Exception {
		IncomeCondition incomeCondition = new IncomeCondition();
		incomeCondition.setPageSize(this.getPageSize());
		incomeCondition.setPageIndex(this.getPageIndex());

		if (!StringHelper.isNullOrEmpty(this.byName)) {
			incomeCondition.setName(this.byName);
		}
		if (StringHelper.isNullOrEmpty(this.byCustomerType)) {
			incomeCondition.setCustomerType(0);
		}else{
			incomeCondition.setCustomerType(Integer.parseInt(this.byCustomerType));
		}
		if (StringHelper.isNullOrEmpty(this.byCustomer)) {
			incomeCondition.setCustomer(0);
		}else{
			incomeCondition.setCustomer(Integer.parseInt(this.byCustomer));
		}
		if (StringHelper.isNullOrEmpty(this.byPartner)) {
			incomeCondition.setPartner(0);
		}else{
			incomeCondition.setPartner(Integer.parseInt(this.byPartner));
		}
		
		
		List<SortItem> sortItemList = new ArrayList<SortItem>();
		SortItem sortItem = new SortItem();
		sortItem.setSortFeild(this.getSidx());
		sortItem.setSortType(this.getSortType());
		sortItemList.add(sortItem);
		incomeCondition.setSortItemList(sortItemList);

		PagedList<Income> incomePagedList = IncomeModel
				.getPagingList(incomeCondition);
		this.setResultList(incomePagedList.getResultList());
		this.setPageCount(incomePagedList.getPagingInfo().getPageCount());
		this.setPageIndex(incomePagedList.getPagingInfo().getPageIndex());
		this.setRecordCount(incomePagedList.getPagingInfo().getTotalCount());
		return SUCCESS;
	}

	public String edit() {
		Income income = new Income();

		//income.setCode(this.code);
		income.setName(this.name);
		income.setCustomerType(Byte.valueOf(this.customerType));
		income.setCustomerNo(Integer.valueOf(this.customerNo));
		income.setSalesNo(Integer.valueOf(this.salesNo));
		income.setIncomeTotal(Long.valueOf(this.incomeTotal));
		income.setIncomeFirst(Long.valueOf(this.incomeFirst));
		income.setIncomeRemain(Long.valueOf(this.incomeRemain));
		income.setIncomeReal(Long.valueOf(this.incomeReal));
		income.setReceiveDate(Timestamp.valueOf(this.receiveDate));
		
		if (!StringHelper.isNullOrEmpty(this.partnerType)) {
			income.setPartnerType(Byte.valueOf(this.partnerType));	
		}
		
		income.setPartnerNo(Integer.valueOf(this.partnerNo));
		income.setPayType(Byte.valueOf(this.payType));
		income.setReceiptNumber(this.receiptNumber);
		income.setComment(this.comment);
		income.setEditComment(this.getEditComment());
		income.setEditUserNo(UserHelper.getEditUserNo());

		if (this.getOper().equalsIgnoreCase("add")) {
			income.setInUserNo(UserHelper.getEditUserNo());
			String r = CodeHelper.getCode("codeIncome","SR");
			if (StringHelper.isNullOrEmpty(r)) {
				income.setCode(r);
			}
			if (IncomeModel.add(income) <= 0) {
				this.setErrCode("add failed");
				this.setErrDesc("add failed");
			}
		} else {
			if (this.getId().isEmpty()) {
				this.setErrCode("NoID");
				this.setErrDesc("NoID");
			} else {
				if (this.getOper().equalsIgnoreCase("edit")) {
					income.setId(Integer.parseInt(this.getId()));
					if (IncomeModel.update(income) <= 0) {
						this.setErrCode("update failed");
						this.setErrDesc("update failed");
					}
				}
			}
		}

		return SUCCESS;
	}

}
