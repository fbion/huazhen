package com.hzframework.data.service;

import com.hzframework.contract.BaseEntity;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.QueryCondition;

import java.util.List;

/**
 * Created by paul on 14-12-23.
 */
public interface BaseService<T extends BaseEntity,TC extends QueryCondition> {
    public List<T> getList();
    public PagedList<T> getPagingList(TC tc);
	public <T> T getInfo(int id);
    public int add(T t);
    public int update(T t);
    public int delete(int id);
}
