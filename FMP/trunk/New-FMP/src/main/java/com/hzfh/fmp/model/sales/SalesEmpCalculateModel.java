package com.hzfh.fmp.model.sales;

import com.hzfh.api.sales.model.SalesEmpCalculate;
import com.hzfh.api.sales.model.query.SalesEmpCalculateCondition;
import com.hzfh.fmp.facade.sales.SalesEmpCalculateFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class SalesEmpCalculateModel {
    public static PagedList<SalesEmpCalculate> getPagingList(SalesEmpCalculateCondition salesEmpCalculateCondition) {
        return SalesEmpCalculateFacade.getPagingList(salesEmpCalculateCondition);
    }

    public static int add(SalesEmpCalculate salesEmpCalculate) {
        return SalesEmpCalculateFacade.add(salesEmpCalculate);
    }

    public static int update(SalesEmpCalculate salesEmpCalculate) {
        return SalesEmpCalculateFacade.update(salesEmpCalculate);
    }

    public static List<SalesEmpCalculate> getList() {
        return SalesEmpCalculateFacade.getList();
    }

    public static SalesEmpCalculate getInfo(int id) {
        return SalesEmpCalculateFacade.getInfo(id);
    }
}
