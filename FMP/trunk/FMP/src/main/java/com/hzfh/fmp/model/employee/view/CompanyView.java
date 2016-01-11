package com.hzfh.fmp.model.employee.view;

import com.hzfh.api.employee.model.Company;
import com.hzfh.api.employee.model.Department;

import java.util.List;

public class CompanyView extends Company {
	private List<Department> departmentList;
	public List<Department> getDepartmentList() {
		return departmentList;
	}
	public void setDepartmentList(List<Department> departmentList) {
		this.departmentList = departmentList;
	}

	public CompanyView(Company company){
		this.setId(company.getId());
		this.setCode(company.getCode());
		this.setName(company.getName());
		this.setTelephone(company.getTelephone());
		this.setFax(company.getFax());
		this.setPostcode(company.getPostcode());
		this.setWebsite(company.getWebsite());
		this.setEmail(company.getEmail());
		this.setBankAccount(company.getBankAccount());
		this.setBankName(company.getBankName());
		this.setBankAddress(company.getBankAddress());
		this.setAddress(company.getAddress());
		this.setComment(company.getComment());
	}
}
