package com.hzfh.fmp.model.report;

import com.hzfh.api.report.model.DeptSalesDaily;
import com.hzfh.api.report.model.query.DeptSalesDailyCondition;
import com.hzfh.fmp.facade.report.DeptSalesDailyFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class DeptSalesDailyModel {
    public static PagedList<DeptSalesDaily> getPagingList(DeptSalesDailyCondition deptSalesDailyCondition) {
        return DeptSalesDailyFacade.getPagingList(deptSalesDailyCondition);
    }

    public static int add(DeptSalesDaily deptSalesDaily) {
        return DeptSalesDailyFacade.add(deptSalesDaily);
    }

    public static int update(DeptSalesDaily deptSalesDaily) {
        return DeptSalesDailyFacade.update(deptSalesDaily);
    }

    public static List<DeptSalesDaily> getList() {
        return DeptSalesDailyFacade.getList();
    }

    public static DeptSalesDaily getInfo(int id) {
        return DeptSalesDailyFacade.getInfo(id);
    }
}
