package com.hzfh.fmp.model.sales;

import com.hzfh.api.report.model.AddSalesReport;
import com.hzfh.api.report.model.query.AddSalesReportCondition;
import com.hzfh.fmp.facade.report.AddSalesReportFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class AddSalesReportModel {
    public static PagedList<AddSalesReport> getPagingList(AddSalesReportCondition addSalesReportCondition) {
        return AddSalesReportFacade.getPagingList(addSalesReportCondition);
    }

    public static int add(AddSalesReport addSalesReport) {
        return AddSalesReportFacade.add(addSalesReport);
    }

    public static int update(AddSalesReport addSalesReport) {
        return AddSalesReportFacade.update(addSalesReport);
    }

    public static List<AddSalesReport> getList() {
        return AddSalesReportFacade.getList();
    }

    public static AddSalesReport getInfo(int id) {
        return AddSalesReportFacade.getInfo(id);
    }

    public static List<AddSalesReport> getListSerch(AddSalesReportCondition addSalesReportCondition){
        return AddSalesReportFacade.getListSerch(addSalesReportCondition);
    }
}
