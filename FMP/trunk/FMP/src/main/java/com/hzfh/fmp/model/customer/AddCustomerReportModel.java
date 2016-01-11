package com.hzfh.fmp.model.customer;

import com.hzfh.api.report.model.AddCustomerReport;
import com.hzfh.api.report.model.query.AddCustomerReportCondition;
import com.hzfh.fmp.facade.customer.AddCustomerReportFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class AddCustomerReportModel {
    public static PagedList<AddCustomerReport> getPagingList(AddCustomerReportCondition addCustomerReportCondition) {
        return AddCustomerReportFacade.getPagingList(addCustomerReportCondition);
    }

    public static int add(AddCustomerReport addCustomerReport) {
        return AddCustomerReportFacade.add(addCustomerReport);
    }

    public static int update(AddCustomerReport addCustomerReport) {
        return AddCustomerReportFacade.update(addCustomerReport);
    }

    public static List<AddCustomerReport> getList() {
        return AddCustomerReportFacade.getList();
    }
    public static List<AddCustomerReport> getListSerch(AddCustomerReportCondition addCustomerReportCondition){
        return AddCustomerReportFacade.getListSerch(addCustomerReportCondition);
    }

    public static AddCustomerReport getInfo(int id) {
        return AddCustomerReportFacade.getInfo(id);
    }

}
