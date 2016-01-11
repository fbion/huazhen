package com.hzfh.fmp.model.employee;

import com.hzfh.api.employee.model.Other;
import com.hzfh.api.employee.model.query.OtherCondition;
import com.hzfh.fmp.facade.employee.OtherFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class OtherModel {
    public static PagedList<Other> getPagingList(OtherCondition otherCondition) {
        return OtherFacade.getPagingList(otherCondition);
    }

    public static int add(Other other) {
        return OtherFacade.add(other);
    }

    public static int update(Other other) {
        return OtherFacade.update(other);
    }

    public static List<Other> getList() {
        return OtherFacade.getList();
    }

    public static Other getInfo(int id) {
        return OtherFacade.getInfo(id);
    }
}
