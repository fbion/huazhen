package com.hzframework.contract;

import java.io.Serializable;

/**
 * Created by paul on 14-12-18.
 */
public class SortItem implements Serializable {
    private String sortFeild;
    private SortType sortType;
    private String sort;
    private String order;

    public String getSortFeild() {
        return sortFeild;
    }

    public void setSortFeild(String sortFeild) {
        this.sortFeild = sortFeild;
    }

    public SortType getSortType() {
        return sortType;
    }

    public void setSortType(SortType sortType) {
        this.sortType = sortType;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
