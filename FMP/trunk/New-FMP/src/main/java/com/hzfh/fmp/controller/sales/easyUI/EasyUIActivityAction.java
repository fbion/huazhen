package com.hzfh.fmp.controller.sales.easyUI;

import com.hzfh.api.sales.model.Activity;
import com.hzfh.api.sales.model.query.ActivityCondition;
import com.hzfh.fmp.controller.common.EasyUIBaseAction;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.sales.ActivityModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.contract.SortType;

import java.util.ArrayList;
import java.util.List;


public class EasyUIActivityAction extends EasyUIBaseAction<Activity> {

    @Override
    public String execute() throws Exception{
        ActivityCondition activityCondition=new ActivityCondition();
        activityCondition.setPageSize(this.getPageSize());
        activityCondition.setPageIndex(this.getPage());
        List<SortItem> sortItemList = new ArrayList<>();
        for (SortItem sortItem : this.getSortList()) {
            SortItem newSortItem = new SortItem();
            newSortItem.setSortFeild(sortItem.getSort());
            newSortItem.setSortType("asc".equalsIgnoreCase(sortItem.getOrder()) ? SortType.ASC : SortType.DESC);
            sortItemList.add(newSortItem);
        }
        activityCondition.setSortItemList(sortItemList);
        PagedList<Activity> activityPagedList= ActivityModel.getPagingList(activityCondition);
        this.setRows(activityPagedList.getResultList());
        this.setTotal(activityPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }
}
