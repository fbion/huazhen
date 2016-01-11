package com.hzfh.fmp.controller.employee.easyUI;

import com.hzfh.api.employee.model.Company;
import com.hzfh.api.employee.model.query.CompanyCondition;
import com.hzfh.fmp.controller.common.EasyUIBaseAction;
import com.hzfh.fmp.model.employee.CompanyModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.contract.SortType;

import java.util.ArrayList;
import java.util.List;


public class EasyUICompanyAction extends EasyUIBaseAction<Company> {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String execute() throws Exception {
        CompanyCondition companyCondition = new CompanyCondition();
        companyCondition.setPageSize(this.getPageSize());
        companyCondition.setPageIndex(this.getPage());
        List<SortItem> sortItemList = new ArrayList<>();
        for (SortItem sortItem : this.getSortList()) {
            SortItem newSortItem = new SortItem();
            newSortItem.setSortFeild(sortItem.getSort());
            newSortItem.setSortType("asc".equalsIgnoreCase(sortItem.getOrder()) ? SortType.ASC : SortType.DESC);
            sortItemList.add(newSortItem);
        }
        companyCondition.setSortItemList(sortItemList);
        companyCondition.setName(this.name);
        PagedList<Company> companyPagedList = CompanyModel.getPagingList(companyCondition);
        this.setRows(companyPagedList.getResultList());
        this.setTotal(companyPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }


}
