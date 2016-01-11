package com.hzfh.fmp.model.baseInfo;

import com.hzfh.api.baseInfo.model.DicType;
import com.hzfh.api.baseInfo.model.query.DicTypeCondition;
import com.hzfh.fmp.facade.baseInfo.DicTypeFacade;
import com.hzfh.fmp.model.common.cache.RedisManager;
import com.hzframework.contract.PagedList;

import java.util.List;

public class DicTypeModel {
    public static PagedList<DicType> getPagingList(DicTypeCondition dicTypeCondition) {
        return DicTypeFacade.getPagingList(dicTypeCondition);
    }

    public static int add(DicType dicType) {
        return DicTypeFacade.add(dicType);
    }

    public static int update(DicType dicType) {
        return DicTypeFacade.update(dicType);
    }

    public static List<DicType> getList() {
        return DicTypeFacade.getList();
    }

    public static DicType getInfo(int id) {
        return DicTypeFacade.getInfo(id);
    }
}
