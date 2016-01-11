package com.hzfh.fmp.model.employee;

import com.hzfh.api.employee.model.NeedRelease;
import com.hzfh.api.employee.model.query.NeedReleaseCondition;
import com.hzfh.fmp.facade.employee.NeedReleaseFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class NeedReleaseModel {
    public static PagedList<NeedRelease> getPagingList(NeedReleaseCondition needReleaseCondition) {
        return NeedReleaseFacade.getPagingList(needReleaseCondition);
    }

    public static int add(NeedRelease needRelease) {
        return NeedReleaseFacade.add(needRelease);
    }

    public static int update(NeedRelease needRelease) {
        return NeedReleaseFacade.update(needRelease);
    }

    public static List<NeedRelease> getList() {
        return NeedReleaseFacade.getList();
    }

    public static NeedRelease getInfo(int id) {
        return NeedReleaseFacade.getInfo(id);
    }
}
