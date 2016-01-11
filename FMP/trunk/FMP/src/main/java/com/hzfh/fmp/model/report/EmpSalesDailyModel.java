package com.hzfh.fmp.model.report;

import com.hzfh.api.report.model.EmpSalesDaily;
import com.hzfh.api.report.model.query.EmpSalesDailyCondition;
import com.hzfh.fmp.facade.report.EmpSalesDailyFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class EmpSalesDailyModel {
    public static PagedList<EmpSalesDaily> getPagingList(EmpSalesDailyCondition empSalesDailyCondition) {
        return EmpSalesDailyFacade.getPagingList(empSalesDailyCondition);
    }

    public static int add(EmpSalesDaily empSalesDaily) {
        return EmpSalesDailyFacade.add(empSalesDaily);
    }

    public static int update(EmpSalesDaily empSalesDaily) {
        return EmpSalesDailyFacade.update(empSalesDaily);
    }

    public static List<EmpSalesDaily> getList() {
        return EmpSalesDailyFacade.getList();
    }

    public static EmpSalesDaily getInfo(int id) {
        return EmpSalesDailyFacade.getInfo(id);
    }
}
