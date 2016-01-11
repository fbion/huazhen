package com.hzfh.fmp.model.employee;

import com.hzfh.api.employee.model.RecruitFollow;
import com.hzfh.api.employee.model.query.RecruitFollowCondition;
import com.hzfh.fmp.facade.employee.RecruitFollowFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class RecruitFollowModel {
    public static PagedList<RecruitFollow> getPagingList(RecruitFollowCondition recruitFollowCondition) {
        return RecruitFollowFacade.getPagingList(recruitFollowCondition);
    }

    public static int add(RecruitFollow recruitFollow) {
        return RecruitFollowFacade.add(recruitFollow);
    }

    public static int update(RecruitFollow recruitFollow) {
        return RecruitFollowFacade.update(recruitFollow);
    }

    public static List<RecruitFollow> getList() {
        return RecruitFollowFacade.getList();
    }

    public static RecruitFollow getInfo(int id) {
        return RecruitFollowFacade.getInfo(id);
    }
}
