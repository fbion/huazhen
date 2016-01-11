package com.hzframework.data.serviceImpl;

import com.hzframework.contract.BaseEntity;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.PagingInfo;
import com.hzframework.contract.QueryCondition;
import com.hzframework.data.dao.BaseDao;
import com.hzframework.data.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by paul on 14-12-23.
 */
public abstract class BaseServiceImpl<T extends BaseEntity, TC extends QueryCondition, D extends BaseDao>
		implements BaseService<T, TC> {
	@Autowired
	private D d;

	// @Override
	public List<T> getList() {
		return d.getList();
	}

	// @Override
	public PagedList<T> getPagingList(TC tc) {
		PagedList<T> tPagedList = new PagedList<T>();
		tPagedList.setResultList(d.getPagingList(tc));
		PagingInfo pagingInfo = new PagingInfo();
		pagingInfo.setPageSize(tc.getPageSize());
		pagingInfo.setPageIndex(tc.getPageIndex());
		pagingInfo.setTotalCount(d.getTotalCount(tc));
		tPagedList.setPagingInfo(pagingInfo);
		return tPagedList;
	}

	// @Override
	public T getInfo(int id) {
		return (T) d.getInfo(id);
	}

	// @Override
	public int add(T t) {
		return d.add(t);
	}

	// @Override
	public int update(T t) {
		return d.update(t);
	}

	// @Override
	public int delete(int id) {
		return d.delete(id);
	}
}
