package com.hzfh.fmp.controller.employee.ajax;

import com.hzfh.api.employee.model.Company;
import com.hzfh.api.employee.model.query.CompanyCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.common.EnumListCacheModel;
import com.hzfh.fmp.model.common.helper.CodeHelper;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.employee.CompanyModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;


public class AjaxCompanyAction extends JqGridBaseAction<Company> {

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
	private String telephone;
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	private String fax;
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	private String postcode;
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	private String website;
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	private String email;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	private String bankAddress;
	public String getBankAddress() {
		return bankAddress;
	}
	public void setBankAddress(String bankAddress) {
		this.bankAddress = bankAddress;
	}
	private String bankName;
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	private String bankAccount;
	public String getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	private String address;
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	private String comment;
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

	private String byName;


    public String getByName() {
		return byName;
	}
	public void setByName(String byName) {
		this.byName = byName;
	}
	@Override
    public String execute() throws Exception{
    	CompanyCondition companyCondition = new CompanyCondition();
        companyCondition.setPageSize(this.getPageSize());
        companyCondition.setPageIndex(this.getPageIndex());
        //begin   query
        if (!StringHelper.isNullOrEmpty(this.byName))
        	companyCondition.setName(this.byName);


        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        companyCondition.setSortItemList(sortItemList);

        PagedList<Company> companyPagedList= CompanyModel.getPagingList(companyCondition);
        this.setResultList(companyPagedList.getResultList());
        this.setPageCount(companyPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(companyPagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(companyPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }

    public String edit(){
        Company company = new Company();

//		company.setCode(this.code);
		company.setName(this.name);
		company.setTelephone(this.telephone);
		company.setFax(this.fax);
		company.setPostcode(this.postcode);
		company.setWebsite(this.website);
		company.setEmail(this.email);
		company.setBankAddress(this.bankAddress);
		company.setBankName(this.bankName);
		company.setBankAccount(this.bankAccount);
		company.setAddress(this.address);
		company.setComment(this.comment);
		company.setEditComment(this.getEditComment());
		company.setEditUserNo(UserHelper.getEditUserNo());

        if (this.getOper().equalsIgnoreCase("add")) {
        	company.setInUserNo(UserHelper.getEditUserNo());
        	String r = CodeHelper.getCode("codeCompany","HZ");
        	if (!StringHelper.isNullOrEmpty(r)) {
        		company.setCode(r);
			}
            if (CompanyModel.add(company )<=0){
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
                    company.setId(Integer.parseInt(this.getId()));
                    
                    if (CompanyModel.update(company) <= 0){
                        this.setErrCode("update failed");
                        this.setErrDesc("update failed");
                    }
                }
            }
        }
        EnumListCacheModel.getCompanylistFromEmp(false);
        return SUCCESS;
    }

}
