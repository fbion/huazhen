package com.hzframework.data.mapper;

import com.hzframework.contract.BaseEntity;
import com.hzframework.contract.QueryCondition;

import java.util.List;

/**
 * Created by paul on 14-12-23.
 */
public interface BaseMapper<T extends BaseEntity,TC extends QueryCondition> {
    public List<T> getList();
    public List<T> getPagingList(TC tc);
    public int getTotalCount(TC tc);
    public T getInfo(int id);

    public int add(T t);
    public int update(T t);
    public int delete(int id);
}
