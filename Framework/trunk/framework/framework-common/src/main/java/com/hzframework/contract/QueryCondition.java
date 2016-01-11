package com.hzframework.contract;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by paul on 14-12-18.
 */
public abstract class QueryCondition extends PagingInfo implements Serializable {
    private List<SortItem> sortItemList = new ArrayList<SortItem>();

    public List<SortItem> getSortItemList() {
        return sortItemList;
    }

    public void setSortItemList(List<SortItem> sortItemList) {
        if (sortItemList == null)
            this.sortItemList.clear();
        else
            this.sortItemList = sortItemList;
    }
}
