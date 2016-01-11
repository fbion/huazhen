package com.hzfh.fmp.facade.employee;

import com.hzfh.api.employee.model.DeptYearNeed;
import com.hzfh.api.employee.model.query.DeptYearNeedCondition;
import com.hzfh.api.employee.service.DeptYearNeedService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class DeptYearNeedFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-employee.xml");

    public static PagedList<DeptYearNeed> getPagingList(DeptYearNeedCondition deptYearNeedCondition) {
        DeptYearNeedService deptYearNeedService = (DeptYearNeedService) context.getBean("deptYearNeedService");

        return  deptYearNeedService.getPagingList(deptYearNeedCondition);
    }

    public static int add(DeptYearNeed deptYearNeed){
        DeptYearNeedService deptYearNeedService = (DeptYearNeedService) context.getBean("deptYearNeedService");

        return deptYearNeedService.add(deptYearNeed);
    }

    public static int update(DeptYearNeed deptYearNeed){
        DeptYearNeedService deptYearNeedService = (DeptYearNeedService) context.getBean("deptYearNeedService");

        return deptYearNeedService.update(deptYearNeed);
    }

    public static List<DeptYearNeed> getList(){
        DeptYearNeedService deptYearNeedService = (DeptYearNeedService) context.getBean("deptYearNeedService");

        return deptYearNeedService.getList();
    }

    public static DeptYearNeed getInfo(int id){
        DeptYearNeedService deptYearNeedService = (DeptYearNeedService) context.getBean("deptYearNeedService");
        return deptYearNeedService.getInfo(id);
    }

	public static List<DeptYearNeed> getFinancialYear() {
		 DeptYearNeedService deptYearNeedService = (DeptYearNeedService) context.getBean("deptYearNeedService");
		// TODO Auto-generated method stub
		return deptYearNeedService.getFinancialYear();
	}

	public static List<DeptYearNeed> getListByYear(int y) {
		 DeptYearNeedService deptYearNeedService = (DeptYearNeedService) context.getBean("deptYearNeedService");
		// TODO Auto-generated method stub
		return deptYearNeedService.getListByYear(y);
	}

	public static int updateStatusByActivitiNo(String activitiNo) {
		DeptYearNeedService deptYearNeedService = (DeptYearNeedService) context.getBean("deptYearNeedService");
		// TODO Auto-generated method stub
		return deptYearNeedService.updateStatusByActivitiNo(activitiNo);
	}

	public static DeptYearNeed getByActivitiNo(String activitiNo) {
		DeptYearNeedService deptYearNeedService = (DeptYearNeedService) context.getBean("deptYearNeedService");
		// TODO Auto-generated method stub
		return deptYearNeedService.getByActivitiNo(activitiNo);
	}
}
