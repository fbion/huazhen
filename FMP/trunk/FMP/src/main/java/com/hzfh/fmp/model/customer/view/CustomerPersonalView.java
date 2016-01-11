package com.hzfh.fmp.model.customer.view;

import com.hzfh.api.customer.model.CustomerPersonal;

/**
 * Created by paul on 15-4-29.
 */
public class CustomerPersonalView extends CustomerPersonal {
    public CustomerPersonalView(CustomerPersonal customerPersonal) {
        this.setAddress(customerPersonal.getAddress());
        this.setAgentNo(customerPersonal.getAgentNo());
        this.setBirthday(customerPersonal.getBirthday());
        this.setCardNumber(customerPersonal.getCardNumber());
        this.setCardType(customerPersonal.getCardType());
        this.setCellphone1(customerPersonal.getCellphone1());
        this.setCellphone2(customerPersonal.getCellphone2());
        this.setCode(customerPersonal.getCode());
        this.setCompanyName(customerPersonal.getCompanyName());
        this.setEditComment(customerPersonal.getEditComment());
        this.setEditTime(customerPersonal.getEditTime());
        this.setEditUserNo(customerPersonal.getEditUserNo());
        this.setEmail(customerPersonal.getEmail());
        this.setField(customerPersonal.getField());
        this.setFindTime(customerPersonal.getFindTime());
        this.setId(customerPersonal.getId());
        this.setInTime(customerPersonal.getInTime());
        this.setInUserNo(customerPersonal.getInUserNo());
        this.setIsTest(customerPersonal.getIsTest());
        this.setMarry(customerPersonal.getMarry());
        this.setName(customerPersonal.getName());
        this.setPhone(customerPersonal.getPhone());
        this.setQq(customerPersonal.getQq());
        this.setRelationLevel(customerPersonal.getRelationLevel());
        this.setRiskHobby(customerPersonal.getRiskHobby());
        this.setSex(customerPersonal.getSex());
        this.setSourceType(customerPersonal.getSourceType());
        this.setTradeTotal(customerPersonal.getTradeTotal());
        this.setWealth(customerPersonal.getWealth());
        this.setWeixin(customerPersonal.getWeixin());
    }

    private String sexName;
    private String marryName;
    private String realtionName;
    private String riskName;
    private String manageName;
    public String getSexName() {
        return sexName;
    }
    public void setSexName(String sexName) {
        this.sexName = sexName;
    }
	public String getMarryName() {
		return marryName;
	}
	public void setMarryName(String marryName) {
		this.marryName = marryName;
	}
	public String getRealtionName() {
		return realtionName;
	}
	public void setRealtionName(String realtionName) {
		this.realtionName = realtionName;
	}
	public String getManageName() {
		return manageName;
	}
	public void setManageName(String manageName) {
		this.manageName = manageName;
	}
	public String getRiskName() {
		return riskName;
	}
	public void setRiskName(String riskName) {
		this.riskName = riskName;
	}
}
