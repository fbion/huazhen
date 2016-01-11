package com.hzfh.fmp.model.employee;

import com.hzfh.api.employee.model.TempRecruitNeed;
import com.hzfh.api.employee.model.query.TempRecruitNeedCondition;
import com.hzfh.fmp.facade.employee.TempRecruitNeedFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class TempRecruitNeedModel {
    public static PagedList<TempRecruitNeed> getPagingList(TempRecruitNeedCondition tempRecruitNeedCondition) {
        return TempRecruitNeedFacade.getPagingList(tempRecruitNeedCondition);
    }

    public static int add(TempRecruitNeed tempRecruitNeed) {
        return TempRecruitNeedFacade.add(tempRecruitNeed);
    }

    public static int update(TempRecruitNeed tempRecruitNeed) {
        return TempRecruitNeedFacade.update(tempRecruitNeed);
    }

    public static List<TempRecruitNeed> getList() {
        return TempRecruitNeedFacade.getList();
    }

    public static TempRecruitNeed getInfo(int id) {
        return TempRecruitNeedFacade.getInfo(id);
    }
}
