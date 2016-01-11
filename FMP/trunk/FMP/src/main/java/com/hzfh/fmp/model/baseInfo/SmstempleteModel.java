package com.hzfh.fmp.model.baseInfo;

import com.hzfh.api.baseInfo.model.Smstemplete;
import com.hzfh.api.baseInfo.model.query.SmstempleteCondition;
import com.hzfh.fmp.facade.baseInfo.SmstempleteFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class SmstempleteModel {
    public static PagedList<Smstemplete> getPagingList(SmstempleteCondition smstempleteCondition) {
        return SmstempleteFacade.getPagingList(smstempleteCondition);
    }

    public static int add(Smstemplete smstemplete) {
        return SmstempleteFacade.add(smstemplete);
    }

    public static int update(Smstemplete smstemplete) {
        return SmstempleteFacade.update(smstemplete);
    }

    public static List<Smstemplete> getList() {
        return SmstempleteFacade.getList();
    }

    public static Smstemplete getInfo(int id) {
        return SmstempleteFacade.getInfo(id);
    }
}
