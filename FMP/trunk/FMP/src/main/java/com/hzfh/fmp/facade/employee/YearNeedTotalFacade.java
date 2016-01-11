package com.hzfh.fmp.facade.employee;

import com.hzfh.api.employee.model.YearNeedTotal;
import com.hzfh.api.employee.model.query.YearNeedTotalCondition;
import com.hzfh.api.employee.service.YearNeedTotalService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class YearNeedTotalFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-employee.xml");

    public static PagedList<YearNeedTotal> getPagingList(YearNeedTotalCondition yearNeedTotalCondition) {
        YearNeedTotalService yearNeedTotalService = (YearNeedTotalService) context.getBean("yearNeedTotalService");

        return  yearNeedTotalService.getPagingList(yearNeedTotalCondition);
    }

    public static int add(YearNeedTotal yearNeedTotal){
        YearNeedTotalService yearNeedTotalService = (YearNeedTotalService) context.getBean("yearNeedTotalService");

        return yearNeedTotalService.add(yearNeedTotal);
    }

    public static int update(YearNeedTotal yearNeedTotal){
        YearNeedTotalService yearNeedTotalService = (YearNeedTotalService) context.getBean("yearNeedTotalService");

        return yearNeedTotalService.update(yearNeedTotal);
    }

    public static List<YearNeedTotal> getList(){
        YearNeedTotalService yearNeedTotalService = (YearNeedTotalService) context.getBean("yearNeedTotalService");

        return yearNeedTotalService.getList();
    }

    public static YearNeedTotal getInfo(int id){
        YearNeedTotalService yearNeedTotalService = (YearNeedTotalService) context.getBean("yearNeedTotalService");

        return yearNeedTotalService.getInfo(id);
    }

	public static YearNeedTotal getInfoByYear(int financialYear) {
		 YearNeedTotalService yearNeedTotalService = (YearNeedTotalService) context.getBean("yearNeedTotalService");

	        return yearNeedTotalService.getInfoByYear(financialYear);
	}
}
