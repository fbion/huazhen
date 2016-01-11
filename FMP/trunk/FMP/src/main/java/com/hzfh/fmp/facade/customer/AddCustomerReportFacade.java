package com.hzfh.fmp.facade.customer;

import com.hzfh.api.report.model.AddCustomerReport;
import com.hzfh.api.report.model.query.AddCustomerReportCondition;
import com.hzfh.api.report.service.AddCustomerReportService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class AddCustomerReportFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-report.xml");

    public static PagedList<AddCustomerReport> getPagingList(AddCustomerReportCondition addCustomerReportCondition) {
        AddCustomerReportService addCustomerReportService = (AddCustomerReportService) context.getBean("addCustomerReportService");

        return  addCustomerReportService.getPagingList(addCustomerReportCondition);
    }

    public static int add(AddCustomerReport addCustomerReport){
        AddCustomerReportService addCustomerReportService = (AddCustomerReportService) context.getBean("addCustomerReportService");

        return addCustomerReportService.add(addCustomerReport);
    }

    public static int update(AddCustomerReport addCustomerReport){
        AddCustomerReportService addCustomerReportService = (AddCustomerReportService) context.getBean("addCustomerReportService");

        return addCustomerReportService.update(addCustomerReport);
    }

    public static List<AddCustomerReport> getList(){
        AddCustomerReportService addCustomerReportService = (AddCustomerReportService) context.getBean("addCustomerReportService");

        return addCustomerReportService.getList();
    }
    public static List<AddCustomerReport> getListSerch(AddCustomerReportCondition addCustomerReportCondition){
        AddCustomerReportService addCustomerReportService = (AddCustomerReportService) context.getBean("addCustomerReportService");

        return addCustomerReportService.getListSerch(addCustomerReportCondition);
    }

    public static AddCustomerReport getInfo(int id){
        AddCustomerReportService addCustomerReportService = (AddCustomerReportService) context.getBean("addCustomerReportService");

        return addCustomerReportService.getInfo(id);
    }
}
