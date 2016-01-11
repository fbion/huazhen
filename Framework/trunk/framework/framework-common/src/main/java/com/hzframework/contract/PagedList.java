package com.hzframework.contract;

import java.io.Serializable;
import java.util.List;

/**
 * Created by paul on 14-12-18.
 */
public class PagedList<T> implements Serializable {
    private PagingInfo pagingInfo = new PagingInfo();
    private List<T> resultList;

    public PagingInfo getPagingInfo() {
        return pagingInfo;
    }

    public void setPagingInfo(PagingInfo pagingInfo) {
        this.pagingInfo = pagingInfo;
    }

    public List<T> getResultList() {
        return resultList;
    }

    public void setResultList(List<T> resultList) {
        this.resultList = resultList;
    }
}
