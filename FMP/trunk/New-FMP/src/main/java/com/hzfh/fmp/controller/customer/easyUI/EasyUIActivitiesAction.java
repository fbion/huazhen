package com.hzfh.fmp.controller.customer.easyUI;

import com.hzfh.api.customer.model.Activities;
import com.hzfh.api.customer.model.query.ActivitiesCondition;
import com.hzfh.fmp.controller.common.EasyUIBaseAction;
import com.hzfh.fmp.model.customer.ActivitiesModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.contract.SortType;

import java.util.ArrayList;
import java.util.List;


public class EasyUIActivitiesAction extends EasyUIBaseAction<Activities> {
	@Override
    public String execute(){
    	ActivitiesCondition activitiesCondition = new ActivitiesCondition();
        activitiesCondition.setPageSize(this.getPageSize());
        activitiesCondition.setPageIndex(this.getPage());
        List<SortItem> sortItemList = new ArrayList<SortItem>();
        for (SortItem sortItem : this.getSortList()) {
            SortItem newSortItem = new SortItem();
            newSortItem.setSortFeild(sortItem.getSort());
            newSortItem.setSortType("asc".equalsIgnoreCase(sortItem.getOrder()) ? SortType.ASC : SortType.DESC);
            sortItemList.add(newSortItem);
        }
        activitiesCondition.setSortItemList(sortItemList);

        PagedList<Activities> activitiesPagedList= ActivitiesModel.getPagingList(activitiesCondition);
        this.setRows(activitiesPagedList.getResultList());
        this.setPage(activitiesPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }

}
