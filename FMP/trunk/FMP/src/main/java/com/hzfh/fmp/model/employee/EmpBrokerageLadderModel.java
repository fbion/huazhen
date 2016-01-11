package com.hzfh.fmp.model.employee;

import com.hzfh.api.employee.model.EmpBrokerageLadder;
import com.hzfh.api.employee.model.query.EmpBrokerageLadderCondition;
import com.hzfh.fmp.facade.employee.EmpBrokerageLadderFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class EmpBrokerageLadderModel {
    public static PagedList<EmpBrokerageLadder> getPagingList(EmpBrokerageLadderCondition empBrokerageLadderCondition) {
        return EmpBrokerageLadderFacade.getPagingList(empBrokerageLadderCondition);
    }

    public static int add(EmpBrokerageLadder empBrokerageLadder) {
        return EmpBrokerageLadderFacade.add(empBrokerageLadder);
    }

    public static int update(EmpBrokerageLadder empBrokerageLadder) {
        return EmpBrokerageLadderFacade.update(empBrokerageLadder);
    }

    public static List<EmpBrokerageLadder> getList() {
        return EmpBrokerageLadderFacade.getList();
    }

    public static EmpBrokerageLadder getInfo(int id) {
        return EmpBrokerageLadderFacade.getInfo(id);
    }
}
