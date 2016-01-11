package com.hzfh.fmp.facade.report;

import com.hzfh.api.report.model.AddSalesReport;
import com.hzfh.api.report.model.query.AddSalesReportCondition;
import com.hzfh.api.report.service.AddSalesReportService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class AddSalesReportFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-report.xml");

    public static PagedList<AddSalesReport> getPagingList(AddSalesReportCondition addSalesReportCondition) {
        AddSalesReportService addSalesReportService = (AddSalesReportService) context.getBean("addSalesReportService");

        return  addSalesReportService.getPagingList(addSalesReportCondition);
    }

    public static int add(AddSalesReport addSalesReport){
        AddSalesReportService addSalesReportService = (AddSalesReportService) context.getBean("addSalesReportService");

        return addSalesReportService.add(addSalesReport);
    }

    public static int update(AddSalesReport addSalesReport){
        AddSalesReportService addSalesReportService = (AddSalesReportService) context.getBean("addSalesReportService");

        return addSalesReportService.update(addSalesReport);
    }

    public static List<AddSalesReport> getList(){
        AddSalesReportService addSalesReportService = (AddSalesReportService) context.getBean("addSalesReportService");

        return addSalesReportService.getList();
    }

    public static AddSalesReport getInfo(int id){
        AddSalesReportService addSalesReportService = (AddSalesReportService) context.getBean("addSalesReportService");

        return addSalesReportService.getInfo(id);
    }
    public static List<AddSalesReport> getListSerch(AddSalesReportCondition addSalesReportCondition){
        AddSalesReportService addSalesReportService = (AddSalesReportService) context.getBean("addSalesReportService");

        return addSalesReportService.getListSerch(addSalesReportCondition);
    }


}
