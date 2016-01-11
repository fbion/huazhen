package com.hzframework.data.daoImpl;

import com.hzframework.contract.BaseEntity;
import com.hzframework.contract.QueryCondition;
import com.hzframework.data.dao.BaseDao;
import com.hzframework.data.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by paul on 14-12-23.
 */
public abstract class BaseDaoImpl<T extends BaseEntity,TC extends QueryCondition,M extends BaseMapper> implements BaseDao<T,TC> {
    @Autowired
    private M m;

    //@Override
    public List<T> getList()
    {
        return m.getList();
    }

    //@Override
    public List<T> getPagingList(TC tc){
        return m.getPagingList(tc);
    }

    //@Override
    public int getTotalCount(TC tc)
    {
        return m.getTotalCount(tc);
    }

    //@Override
    public T getInfo(int id){return (T)m.getInfo(id);}

    //@Override
    public int add(T t){
        if(m.add(t)>0)
            return t.getId();
        else
            return 0;
    }

    //@Override
    public int update(T t){return m.update(t);}

    //@Override
    public int delete(int id){return m.delete(id);}
}
