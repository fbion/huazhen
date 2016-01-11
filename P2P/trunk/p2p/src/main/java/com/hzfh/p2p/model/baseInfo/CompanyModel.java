package com.hzfh.p2p.model.baseInfo;

import com.hzfh.api.employee.model.Company;
import com.hzfh.api.employee.model.query.CompanyCondition;
import com.hzfh.p2p.facade.baseInfo.CompanyFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class CompanyModel {
    public static PagedList<Company> getPagingList(CompanyCondition companyCondition) {
        return CompanyFacade.getPagingList(companyCondition);
    }

    public static int add(Company company) {
        return CompanyFacade.add(company);
    }

    public static int update(Company company) {
        return CompanyFacade.update(company);
    }

    public static List<Company> getList() {
//    	List<CompanyView> companyViewList =(List<CompanyView>)CacheManager.get(CachePrefix.COMPANY_VIEW , "getCompanyViewList");
    	return CompanyFacade.getList();
    }

    public static Company getInfo(int id) {
        return CompanyFacade.getInfo(id);
    }
	public static Company getCompanyByCompanyId(int companyId) {
		return CompanyFacade.getCompanyByCompanyId(companyId);
	}
	
}
