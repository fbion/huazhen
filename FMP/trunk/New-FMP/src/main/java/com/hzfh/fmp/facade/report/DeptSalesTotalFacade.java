package com.hzfh.fmp.facade.report;

import com.hzfh.api.report.model.DeptSalesTotal;
import com.hzfh.api.report.model.query.DeptSalesTotalCondition;
import com.hzfh.api.report.service.DeptSalesTotalService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class DeptSalesTotalFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-report.xml");

    public static PagedList<DeptSalesTotal> getPagingList(DeptSalesTotalCondition deptSalesTotalCondition) {
        DeptSalesTotalService deptSalesTotalService = (DeptSalesTotalService) context.getBean("deptSalesTotalService");

        return  deptSalesTotalService.getPagingList(deptSalesTotalCondition);
    }

    public static int add(DeptSalesTotal deptSalesTotal){
        DeptSalesTotalService deptSalesTotalService = (DeptSalesTotalService) context.getBean("deptSalesTotalService");

        return deptSalesTotalService.add(deptSalesTotal);
    }

    public static int update(DeptSalesTotal deptSalesTotal){
        DeptSalesTotalService deptSalesTotalService = (DeptSalesTotalService) context.getBean("deptSalesTotalService");

        return deptSalesTotalService.update(deptSalesTotal);
    }

    public static List<DeptSalesTotal> getList(){
        DeptSalesTotalService deptSalesTotalService = (DeptSalesTotalService) context.getBean("deptSalesTotalService");

        return deptSalesTotalService.getList();
    }

    public static DeptSalesTotal getInfo(int id){
        DeptSalesTotalService deptSalesTotalService = (DeptSalesTotalService) context.getBean("deptSalesTotalService");

        return deptSalesTotalService.getInfo(id);
    }
	//create by zorro 2015/4/21
	public static List<DeptSalesTotal> getListByProductNo(int productNo) {
		DeptSalesTotalService deptSalesTotalService = (DeptSalesTotalService) context.getBean("deptSalesTotalService");

        return deptSalesTotalService.getListByProductNo(productNo);
	}
}
