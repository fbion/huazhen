package com.hzfh.fmp.model.employee;

import com.hzfh.api.employee.model.EmpCompilePlan;
import com.hzfh.api.employee.model.query.EmpCompilePlanCondition;
import com.hzfh.fmp.facade.employee.EmpCompilePlanFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class EmpCompilePlanModel {
    public static PagedList<EmpCompilePlan> getPagingList(EmpCompilePlanCondition empCompilePlanCondition) {
        return EmpCompilePlanFacade.getPagingList(empCompilePlanCondition);
    }

    public static int add(EmpCompilePlan empCompilePlan) {
        return EmpCompilePlanFacade.add(empCompilePlan);
    }

    public static int update(EmpCompilePlan empCompilePlan) {
        return EmpCompilePlanFacade.update(empCompilePlan);
    }

    public static List<EmpCompilePlan> getList() {
        return EmpCompilePlanFacade.getList();
    }

    public static EmpCompilePlan getInfo(int id) {
        return EmpCompilePlanFacade.getInfo(id);
    }
    public static List<EmpCompilePlan> getListForExcel( EmpCompilePlanCondition empCompilePlanCondition){
        return EmpCompilePlanFacade.getListForExcel(empCompilePlanCondition);
    }

}
