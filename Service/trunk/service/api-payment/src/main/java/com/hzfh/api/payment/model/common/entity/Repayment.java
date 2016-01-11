package com.hzfh.api.payment.model.common.entity;

import com.hzfh.api.payment.model.common.constant.RepaymentCon;

import java.util.HashMap;
import java.util.Map;
/**
 * 还款［REPAYMENT］
 * @author Administrator
 *
 */
public class Repayment extends CommonEntity{
	private String tenderOrderNo;//Y 项目编号
	public String getTenderOrderNo() {
		return tenderOrderNo;
	}

	public void setTenderOrderNo(String tenderOrderNo) {
		this.tenderOrderNo = tenderOrderNo;
	}
	public Extend getExtend(){
        Map<String, Property> propertys = new HashMap<String, Property>();
        Property property = new Property();
        property.setName(RepaymentCon.TENDERORDERNO);
        property.setValue(getTenderOrderNo());
        propertys.put(RepaymentCon.TENDERORDERNO, property);
        Extend extend = new Extend();
        extend.setProperty(propertys);
        return extend; 
	}
}
