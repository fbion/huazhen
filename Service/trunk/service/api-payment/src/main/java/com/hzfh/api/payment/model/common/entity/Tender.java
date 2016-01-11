package com.hzfh.api.payment.model.common.entity;

import com.hzfh.api.payment.model.common.constant.TenderCon;

import java.util.HashMap;
import java.util.Map;


/**
 * 投标［TENDER］
 * @author Administrator
 *
 */
public class Tender extends CommonEntity{
	
	private String tenderOrderNo; // 项目编号
	private String tenderName; // 项目名称
	private String tenderAmount; // 项目金额
	private String tenderDescription; // 项目描述信息
	private String borrowerPlatformUserNo;// 项目的借款人平台用户编号
	public String getTenderOrderNo() {
		return tenderOrderNo;
	}

	public void setTenderOrderNo(String tenderOrderNo) {
		this.tenderOrderNo = tenderOrderNo;
	}

	public String getTenderName() {
		return tenderName;
	}

	public void setTenderName(String tenderName) {
		this.tenderName = tenderName;
	}

	public String getTenderAmount() {
		return tenderAmount;
	}

	public void setTenderAmount(String tenderAmount) {
		this.tenderAmount = tenderAmount;
	}

	public String getTenderDescription() {
		return tenderDescription;
	}

	public void setTenderDescription(String tenderDescription) {
		this.tenderDescription = tenderDescription;
	}

	public String getBorrowerPlatformUserNo() {
		return borrowerPlatformUserNo;
	}

	public void setBorrowerPlatformUserNo(String borrowerPlatformUserNo) {
		this.borrowerPlatformUserNo = borrowerPlatformUserNo;
	}
	
	public Extend getExtend(){
        Map<String, Property> propertys = new HashMap<String, Property>();
        Property property = new Property();
        property.setName(TenderCon.BORROWERPLATFORMUSERNO);
        property.setValue(getBorrowerPlatformUserNo());
        propertys.put(TenderCon.BORROWERPLATFORMUSERNO, property);
        
        Property property1 = new Property();
        property1.setName(TenderCon.TENDERAMOUNT);
        property1.setValue(getTenderAmount());
        propertys.put(TenderCon.TENDERAMOUNT, property1);
        
        Property property2 = new Property();
        property2.setName(TenderCon.TENDERDESCRIPTION);
        property2.setValue(getTenderDescription());
        propertys.put(TenderCon.TENDERDESCRIPTION, property2);
        
        Property property3 = new Property();
        property3.setName(TenderCon.TENDERNAME);
        property3.setValue(getTenderName());
        propertys.put(TenderCon.TENDERNAME, property3);
        
        Property property4 = new Property();
        property4.setName(TenderCon.TENDERORDERNO);
        property4.setValue(getTenderOrderNo());
        propertys.put(TenderCon.TENDERORDERNO, property4);
        Extend extend = new Extend();
        extend.setProperty(propertys);
        return extend; 
	}
}
