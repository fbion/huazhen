package com.hzfh.fmp.facade.employee;

import com.hzfh.api.employee.model.YearNeedDetail;
import com.hzfh.api.employee.model.query.YearNeedDetailCondition;
import com.hzfh.api.employee.service.YearNeedDetailService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class YearNeedDetailFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-employee.xml");

    public static PagedList<YearNeedDetail> getPagingList(YearNeedDetailCondition yearNeedDetailCondition) {
        YearNeedDetailService yearNeedDetailService = (YearNeedDetailService) context.getBean("yearNeedDetailService");

        return  yearNeedDetailService.getPagingList(yearNeedDetailCondition);
    }

    public static int add(YearNeedDetail yearNeedDetail){
        YearNeedDetailService yearNeedDetailService = (YearNeedDetailService) context.getBean("yearNeedDetailService");

        return yearNeedDetailService.add(yearNeedDetail);
    }

    public static int update(YearNeedDetail yearNeedDetail){
        YearNeedDetailService yearNeedDetailService = (YearNeedDetailService) context.getBean("yearNeedDetailService");

        return yearNeedDetailService.update(yearNeedDetail);
    }

    public static List<YearNeedDetail> getList(){
        YearNeedDetailService yearNeedDetailService = (YearNeedDetailService) context.getBean("yearNeedDetailService");

        return yearNeedDetailService.getList();
    }

    public static YearNeedDetail getInfo(int id){
        YearNeedDetailService yearNeedDetailService = (YearNeedDetailService) context.getBean("yearNeedDetailService");

        return yearNeedDetailService.getInfo(id);
    }

	public static List<YearNeedDetail> getListByNeedNo(int id) {
		 YearNeedDetailService yearNeedDetailService = (YearNeedDetailService) context.getBean("yearNeedDetailService");
	        return yearNeedDetailService.getListByNeedNo(id);
	}
}
