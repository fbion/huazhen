package com.hzfh.fmp.controller.common;

import com.hzfh.api.employee.model.Company;
import com.hzfh.api.employee.model.Department;
import com.hzfh.api.employee.model.Employee;
import com.hzfh.fmp.facade.employee.CompanyFacade;
import com.hzfh.fmp.facade.employee.DepartmentFacade;
import com.hzfh.fmp.facade.employee.EmployeeFacade;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;


public class TreeAction {
	
	private int id ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private int status;
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	private int type;
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	public String getTree(){
		String xml;
		try {
			xml = getEmployeeTree();
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/xml;charset=UTF-8");
			PrintWriter out = response.getWriter();
			System.out.println(xml);
			out.print(xml);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
    }
	
	
	public  String getEmployeeTree() {
		StringBuilder xml = new StringBuilder(100);
		xml.append("<?xml version='1.0' encoding='utf-8'?> ");
		xml.append("<tree id='0'>");
		List<Company> companyList = CompanyFacade.getList();
		if(companyList.size()!=0){
			for (Company company : companyList) {
				getEmployeeTree(company, xml);
				xml.append("</item>");
			}
		}
		xml.append("</tree>");
		return xml.toString();
	}

	private  void getEmployeeTree(Company company, StringBuilder xml) {
		xml.append("<item text='" + company.getName() + "' id='" + (company.getId()+10000000) +"' open='1' >");	
		List<Department> departmentList = DepartmentFacade.getDeptListByCompanyNo(company.getId());
			if (departmentList.size()!= 0) {
				for (Department department : departmentList) {
					getEmployeeTree(department, xml);
					xml.append("</item>");
				}
			}
	}
	private  void getEmployeeTree(Department department, StringBuilder xml) {
		xml.append("<item text='" + department.getName() + "' id='" + (department.getId() +2000000)+ "' >");
		List<Employee> employeeList  = EmployeeFacade.getEmpListByDept(department.getId());
		if (employeeList.size()!= 0) {
			for (Employee employee: employeeList) {
				if(this.type==0){
					xml.append("<item text='" + employee.getName() + "' id='" + employee.getId() + "' >");
				}else{
					xml.append("<item text='" + employee.getName() + "' id='" + employee.getUserNo() + "' >");
				}
				xml.append("</item>");
			}
		}

	}
}
