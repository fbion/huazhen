package com.hzfh.fmp.facade.employee;

import com.hzfh.api.employee.model.Company;
import com.hzfh.api.employee.model.query.CompanyCondition;
import com.hzfh.api.employee.service.CompanyService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class CompanyFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-employee.xml");

    public static PagedList<Company> getPagingList(CompanyCondition companyCondition) {
        CompanyService companyService = (CompanyService) context.getBean("companyService");

        return  companyService.getPagingList(companyCondition);
    }

    public static int add(Company company){
        CompanyService companyService = (CompanyService) context.getBean("companyService");

        return companyService.add(company);
    }

    public static int update(Company company){
        CompanyService companyService = (CompanyService) context.getBean("companyService");

        return companyService.update(company);
    }

    public static List<Company> getList(){
        CompanyService companyService = (CompanyService) context.getBean("companyService");

        return companyService.getList();
    }

    public static Company getInfo(int id){
        CompanyService companyService = (CompanyService) context.getBean("companyService");

        return companyService.getInfo(id);
    }
    
	public static Company getCompanyByCompanyId(int companyId) {
		CompanyService companyService = (CompanyService) context.getBean("companyService");
		return companyService.getCompanyByCompanyId(companyId);
	}
}
