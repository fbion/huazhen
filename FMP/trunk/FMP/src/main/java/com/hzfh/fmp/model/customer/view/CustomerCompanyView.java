package com.hzfh.fmp.model.customer.view;

import com.hzfh.api.customer.model.CustomerCompany;

public class CustomerCompanyView extends CustomerCompany {

	public CustomerCompanyView(CustomerCompany customerCompany) {
		this.setAddress(customerCompany.getAddress());
		this.setAgentNo(customerCompany.getAgentNo());
		this.setCardLicense(customerCompany.getCardLicense());
		this.setCardNumber(customerCompany.getCardNumber());
		this.setCardTax(customerCompany.getCardTax());
		this.setCardType(customerCompany.getCardType());
		this.setCode(customerCompany.getCode());
		this.setContactCellphone1(customerCompany.getContactCellphone1());
		this.setContactCellphone2(customerCompany.getContactCellphone2());
		this.setContactName(customerCompany.getContactName());
		this.setContactTelephone(customerCompany.getContactTelephone());
		this.setEditComment(customerCompany.getEditComment());
		this.setEditTime(customerCompany.getEditTime());
		this.setEditUserNo(customerCompany.getEditUserNo());
		this.setEmail(customerCompany.getEmail());
		this.setField(customerCompany.getField());
		this.setFindTime(customerCompany.getFindTime());
		this.setId(customerCompany.getId());
		this.setInTime(customerCompany.getInTime());
		this.setInUserNo(customerCompany.getInUserNo());
		this.setIsTest(customerCompany.getIsTest());
		this.setName(customerCompany.getName());
		this.setRelationLevel(customerCompany.getRelationLevel());
		this.setRiskHobby(customerCompany.getRiskHobby());
		this.setSourceType(customerCompany.getSourceType());
		this.setTelephone(customerCompany.getTelephone());
		this.setTradeTotal(customerCompany.getTradeTotal());
		this.setWealth(customerCompany.getWealth());
	}

	private String realtionName;
	private String riskName;
	private String manageName;
	public String getRealtionName() {
		return realtionName;
	}
	public void setRealtionName(String realtionName) {
		this.realtionName = realtionName;
	}
	public String getRiskName() {
		return riskName;
	}
	public void setRiskName(String riskName) {
		this.riskName = riskName;
	}
	public String getManageName() {
		return manageName;
	}
	public void setManageName(String manageName) {
		this.manageName = manageName;
	}
}
