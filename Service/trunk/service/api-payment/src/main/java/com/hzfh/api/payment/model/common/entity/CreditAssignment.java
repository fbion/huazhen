package com.hzfh.api.payment.model.common.entity;

import com.hzfh.api.payment.model.common.constant.CreditAssignmentCon;

import java.util.HashMap;
import java.util.Map;
/**
 * 债权转让［CREDIT_ASSIGNMENT］
 * @author Administrator
 *
 */
public class CreditAssignment extends CommonEntity{
	
	private String tenderOrderNo;//项目编号
	private String creditorPlatformUserNo;//债权购买人
	private String originalRequestNo;//需要转让的投资记录流水号
	public String getTenderOrderNo() {
		return tenderOrderNo;
	}
	public void setTenderOrderNo(String tenderOrderNo) {
		this.tenderOrderNo = tenderOrderNo;
	}
	public String getCreditorPlatformUserNo() {
		return creditorPlatformUserNo;
	}
	public void setCreditorPlatformUserNo(String creditorPlatformUserNo) {
		this.creditorPlatformUserNo = creditorPlatformUserNo;
	}
	public String getOriginalRequestNo() {
		return originalRequestNo;
	}
	public void setOriginalRequestNo(String originalRequestNo) {
		this.originalRequestNo = originalRequestNo;
	}
	public Extend getExtend(){
        Map<String, Property> propertys = new HashMap<String, Property>();
        Property property = new Property();
        property.setName(CreditAssignmentCon.CREDITORPLATFORMUSERNO);
        property.setValue(getCreditorPlatformUserNo());
        propertys.put(CreditAssignmentCon.CREDITORPLATFORMUSERNO, property);
        
        Property property1 = new Property();
        property1.setName(CreditAssignmentCon.ORIGINALREQUESTNO);
        property1.setValue(getOriginalRequestNo());
        propertys.put(CreditAssignmentCon.ORIGINALREQUESTNO, property1);
        
        Property property4 = new Property();
        property4.setName(CreditAssignmentCon.TENDERORDERNO);
        property4.setValue(getTenderOrderNo());
        propertys.put(CreditAssignmentCon.TENDERORDERNO, property4);
        Extend extend = new Extend();
        extend.setProperty(propertys);
        return extend; 
	}
}
