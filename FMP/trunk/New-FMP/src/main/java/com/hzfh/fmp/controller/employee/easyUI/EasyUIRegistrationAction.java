package com.hzfh.fmp.controller.employee.easyUI;

import com.hzfh.api.employee.model.Registration;
import com.hzfh.api.employee.model.query.RegistrationCondition;
import com.hzfh.fmp.controller.common.EasyUIBaseAction;
import com.hzfh.fmp.model.employee.RegistrationModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.contract.SortType;

import java.util.ArrayList;
import java.util.List;


public class EasyUIRegistrationAction extends EasyUIBaseAction<Registration> {

    @Override
    public String execute() throws Exception {
        RegistrationCondition registrationCondition = new RegistrationCondition();
        registrationCondition.setPageSize(this.getPageSize());
        registrationCondition.setPageIndex(this.getPage());
        List<SortItem> sortItemList = new ArrayList<>();
        for (SortItem sortItem : this.getSortList()) {
            SortItem newSortItem = new SortItem();
            newSortItem.setSortFeild(sortItem.getSort());
            newSortItem.setSortType("asc".equalsIgnoreCase(sortItem.getOrder()) ? SortType.ASC : SortType.DESC);
            sortItemList.add(newSortItem);
        }
        registrationCondition.setSortItemList(sortItemList);
        PagedList<Registration> registrationPagedList = RegistrationModel.getPagingList(registrationCondition);
        this.setRows(registrationPagedList.getResultList());
        this.setTotal(registrationPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }


}
