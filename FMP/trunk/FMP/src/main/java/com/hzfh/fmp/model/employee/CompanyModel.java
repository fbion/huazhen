package com.hzfh.fmp.model.employee;

import com.hzfh.api.employee.model.Company;
import com.hzfh.api.employee.model.query.CompanyCondition;
import com.hzfh.fmp.facade.employee.CompanyFacade;
import com.hzfh.fmp.model.common.cache.CacheManager;
import com.hzfh.fmp.model.common.cache.CachePrefix;
import com.hzfh.fmp.model.employee.view.CompanyView;
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
	
	@Deprecated
	public static List<CompanyView> getCompanyViewList(){
		List<CompanyView> companyViewList =(List<CompanyView>)CacheManager.get(CachePrefix.COMPANY_VIEW , "getCompanyViewList");
		if (companyViewList != null)
            return companyViewList;
		//公司集合预备
		List<Company> companyList = CompanyModel.getList();
		for (Company company : companyList) {
			//公司部门联动对象预备
			CompanyView companyView = new CompanyView(company);
			//查出跟公司关联的部门
			companyView.setDepartmentList(DepartmentModel.getDeptListByCompanyNo(company.getId()));
			//在把全部的
			companyViewList.add(companyView);
		}
        CacheManager.set(CachePrefix.COMPANY_VIEW ,"getCompanyViewList", 24 * 60 * 60 * 7, companyViewList);
        return companyViewList;
	}
}
