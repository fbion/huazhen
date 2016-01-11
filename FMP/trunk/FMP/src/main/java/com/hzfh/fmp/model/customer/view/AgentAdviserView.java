package com.hzfh.fmp.model.customer.view;

import com.hzfh.api.customer.model.AgentAdviser;


public class AgentAdviserView extends AgentAdviser {
    public AgentAdviserView(AgentAdviser agentAdviser) {
        this.setAddress(agentAdviser.getAddress());
        this.setCellphone1(agentAdviser.getCellphone1());
        this.setCellphone2(agentAdviser.getCellphone2());
        this.setCode(agentAdviser.getCode());
        this.setEditComment(agentAdviser.getEditComment());
        this.setEditTime(agentAdviser.getEditTime());
        this.setEditUserNo(agentAdviser.getEditUserNo());
        this.setEmail(agentAdviser.getEmail());
        this.setId(agentAdviser.getId());
        this.setInTime(agentAdviser.getInTime());
        this.setInUserNo(agentAdviser.getInUserNo());
        this.setIsTest(agentAdviser.getIsTest());
        this.setName(agentAdviser.getName());
        this.setManagerNo(agentAdviser.getManagerNo());
        this.setQq(agentAdviser.getQq());
        this.setWeixin(agentAdviser.getWeixin());
        this.setSaleTotal(agentAdviser.getSaleTotal());
        this.setTelephone(agentAdviser.getTelephone());
        this.setWeixin(agentAdviser.getWeixin());
        
    }

    private String manageString;
	
	public String getManageString() {
		return manageString;
	}
	public void setManageString(String manageString) {
		this.manageString = manageString;
	}
    
    
    

}
