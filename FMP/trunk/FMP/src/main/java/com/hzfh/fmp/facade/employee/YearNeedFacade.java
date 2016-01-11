package com.hzfh.fmp.facade.employee;

import com.hzfh.api.employee.model.YearNeed;
import com.hzfh.api.employee.model.query.YearNeedCondition;
import com.hzfh.api.employee.service.YearNeedService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class YearNeedFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-employee.xml");

    public static PagedList<YearNeed> getPagingList(YearNeedCondition yearNeedCondition) {
        YearNeedService yearNeedService = (YearNeedService) context.getBean("yearNeedService");

        return  yearNeedService.getPagingList(yearNeedCondition);
    }

    public static int add(YearNeed yearNeed){
        YearNeedService yearNeedService = (YearNeedService) context.getBean("yearNeedService");

        return yearNeedService.add(yearNeed);
    }

    public static int update(YearNeed yearNeed){
        YearNeedService yearNeedService = (YearNeedService) context.getBean("yearNeedService");

        return yearNeedService.update(yearNeed);
    }

    public static List<YearNeed> getList(){
        YearNeedService yearNeedService = (YearNeedService) context.getBean("yearNeedService");

        return yearNeedService.getList();
    }

    public static YearNeed getInfo(int id){
        YearNeedService yearNeedService = (YearNeedService) context.getBean("yearNeedService");

        return yearNeedService.getInfo(id);
    }

	public static List<YearNeed> getListByYear(int param) {
		 YearNeedService yearNeedService = (YearNeedService) context.getBean("yearNeedService");
	        return yearNeedService.getListByYear(param);
	}

	public static List<YearNeed> getFinancialYear() {
		 YearNeedService yearNeedService = (YearNeedService) context.getBean("yearNeedService");
	        return yearNeedService.getFinancialYear();
	}
}
