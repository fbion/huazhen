package com.hzfh.fmp.model.report;

import com.hzfh.api.report.model.CompanySalesDaily;
import com.hzfh.api.report.model.query.CompanySalesDailyCondition;
import com.hzfh.fmp.facade.report.CompanySalesDailyFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class CompanySalesDailyModel {
    public static PagedList<CompanySalesDaily> getPagingList(CompanySalesDailyCondition companySalesDailyCondition) {
        return CompanySalesDailyFacade.getPagingList(companySalesDailyCondition);
    }

    public static int add(CompanySalesDaily companySalesDaily) {
        return CompanySalesDailyFacade.add(companySalesDaily);
    }

    public static int update(CompanySalesDaily companySalesDaily) {
        return CompanySalesDailyFacade.update(companySalesDaily);
    }

    public static List<CompanySalesDaily> getList() {
        return CompanySalesDailyFacade.getList();
    }

    public static CompanySalesDaily getInfo(int id) {
        return CompanySalesDailyFacade.getInfo(id);
    }

}
