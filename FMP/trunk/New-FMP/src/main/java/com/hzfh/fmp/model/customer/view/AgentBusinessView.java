package com.hzfh.fmp.model.customer.view;

import com.hzfh.api.customer.model.AgentBusiness;


public class AgentBusinessView extends AgentBusiness {
    public AgentBusinessView(AgentBusiness agentBusiness) {
        this.setAddress(agentBusiness.getAddress());
        this.setCode(agentBusiness.getCode());
        this.setComment(agentBusiness.getComment());
        this.setContactAddress(agentBusiness.getContactAddress());
        this.setContactCellphone1(agentBusiness.getContactCellphone1());
        this.setContactCellphone2(agentBusiness.getContactCellphone2());
        this.setContactImportance(agentBusiness.getContactImportance());
        this.setContactPosition(agentBusiness.getContactPosition());
        this.setContactPrimary(agentBusiness.getContactPrimary());
        this.setContactQq(agentBusiness.getContactQq());
        this.setContactTelephone(agentBusiness.getContactTelephone());
        this.setContactWeixin(agentBusiness.getContactWeixin());
        this.setEditComment(agentBusiness.getEditComment());
        this.setEditTime(agentBusiness.getEditTime());
        this.setEditUserNo(agentBusiness.getEditUserNo());
        this.setEmail(agentBusiness.getEmail());
        this.setId(agentBusiness.getId());
        this.setInTime(agentBusiness.getInTime());
        this.setInUserNo(agentBusiness.getInUserNo());
        this.setIsTest(agentBusiness.getIsTest());
        this.setName(agentBusiness.getName());
        this.setManagerNo(agentBusiness.getManagerNo());
        this.setSaleTotal(agentBusiness.getSaleTotal());
        this.setTelephone(agentBusiness.getTelephone());
        this.setOwner(agentBusiness.getOwner());
        this.setRelationLevel(agentBusiness.getRelationLevel());
        this.setSaleTotal(agentBusiness.getSaleTotal());
        this.setWebsite(agentBusiness.getWebsite());
    }

    private String relationString;
    private String manageString;
	private String importanceString;
    
	public String getManageString() {
		return manageString;
	}
	public void setManageString(String manageString) {
		this.manageString = manageString;
	}
	public String getRelationString() {
		return relationString;
	}
	public void setRelationString(String relationString) {
		this.relationString = relationString;
	}
	public String getImportanceString() {
		return importanceString;
	}
	public void setImportanceString(String importanceString) {
		this.importanceString = importanceString;
	}
	
	
	
    
    
    

}
