package com.hzfh.api.payment.model.request.gateway;

import com.hzfh.api.payment.model.request.CommonRequest;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 企业用户注册
 * Action名称  toEnterpriseRegister
 * 支持properties N
 * @author Administrator
 *
 */
@XStreamAlias("request")
public class EnterpriseRegisterReq extends CommonRequest{
	@XStreamAlias("enterpriseName")
	private String enterpriseName; 	//Y 企业名称
	@XStreamAlias("bankLicense")
	private String bankLicense;		//Y 开户银行许可证
	@XStreamAlias("orgNo")
	private String orgNo;			//Y 组织机构代码
	@XStreamAlias("businessLicense")
	private String businessLicense;	//Y 营业执照编号
	@XStreamAlias("taxNo")
	private String taxNo;			//Y 税务登记号
	@XStreamAlias("legal")
	private String legal;			//Y 法人姓名
	@XStreamAlias("legalIdNo")
	private String legalIdNo;		//Y 法人身份证号
	@XStreamAlias("contact")
	private String contact;			//Y 企业联系人
	@XStreamAlias("contactPhone")
	private String contactPhone;	//Y 联系人手机号
	@XStreamAlias("email")
	private String email;			//Y 联系人邮箱
	@XStreamAlias("memberClassType")
	private String memberClassType;	//Y ENTERPRISE：企业借款人  	 GUARANTEE_CORP：担保公司
	public String getEnterpriseName() {
		return enterpriseName;
	}
	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}
	public String getBankLicense() {
		return bankLicense;
	}
	public void setBankLicense(String bankLicense) {
		this.bankLicense = bankLicense;
	}
	public String getOrgNo() {
		return orgNo;
	}
	public void setOrgNo(String orgNo) {
		this.orgNo = orgNo;
	}
	public String getBusinessLicense() {
		return businessLicense;
	}
	public void setBusinessLicense(String businessLicense) {
		this.businessLicense = businessLicense;
	}
	public String getTaxNo() {
		return taxNo;
	}
	public void setTaxNo(String taxNo) {
		this.taxNo = taxNo;
	}
	public String getLegal() {
		return legal;
	}
	public void setLegal(String legal) {
		this.legal = legal;
	}
	public String getLegalIdNo() {
		return legalIdNo;
	}
	public void setLegalIdNo(String legalIdNo) {
		this.legalIdNo = legalIdNo;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getContactPhone() {
		return contactPhone;
	}
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMemberClassType() {
		return memberClassType;
	}
	public void setMemberClassType(String memberClassType) {
		this.memberClassType = memberClassType;
	}

	
}
