package com.hzfh.fmp.model.workFlow;

import com.hzfh.api.workFlow.model.ActHiTaskinst;
import com.hzfh.api.workFlow.model.query.ActHiTaskinstCondition;
import com.hzfh.fmp.facade.workFlow.ActHiTaskinstFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class ActHiTaskinstModel {
    public static PagedList<ActHiTaskinst> getPagingList(ActHiTaskinstCondition actHiTaskinstCondition) {
        return ActHiTaskinstFacade.getPagingList(actHiTaskinstCondition);
    }

    public static int add(ActHiTaskinst actHiTaskinst) {
        return ActHiTaskinstFacade.add(actHiTaskinst);
    }

    public static int update(ActHiTaskinst actHiTaskinst) {
        return ActHiTaskinstFacade.update(actHiTaskinst);
    }

    public static List<ActHiTaskinst> getList() {
        return ActHiTaskinstFacade.getList();
    }

    public static ActHiTaskinst getInfo(int id) {
        return ActHiTaskinstFacade.getInfo(id);
    }

    public static List<ActHiTaskinst> getListByActivitiNo(String activitiNo){
        return ActHiTaskinstFacade.getListByActivitiNo(activitiNo);
    }
}
