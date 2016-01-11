package com.hzfh.fmp.model.employee;

import com.hzfh.api.employee.model.CommissionWealthCenter;
import com.hzfh.api.employee.model.query.CommissionWealthCenterCondition;
import com.hzfh.fmp.facade.employee.CommissionWealthCenterFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class CommissionWealthCenterModel {
    public static PagedList<CommissionWealthCenter> getPagingList(CommissionWealthCenterCondition commissionWealthCenterCondition) {
        return CommissionWealthCenterFacade.getPagingList(commissionWealthCenterCondition);
    }

    public static int add(CommissionWealthCenter commissionWealthCenter) {
        return CommissionWealthCenterFacade.add(commissionWealthCenter);
    }

    public static int update(CommissionWealthCenter commissionWealthCenter) {
        return CommissionWealthCenterFacade.update(commissionWealthCenter);
    }

    public static List<CommissionWealthCenter> getList() {
        return CommissionWealthCenterFacade.getList();
    }

    public static CommissionWealthCenter getInfo(int id) {
        return CommissionWealthCenterFacade.getInfo(id);
    }

    public static List<CommissionWealthCenter> getListForExcel(CommissionWealthCenterCondition commissionWealthCenterCondition){
        return CommissionWealthCenterFacade.getListForExcel(commissionWealthCenterCondition);
    }
}
