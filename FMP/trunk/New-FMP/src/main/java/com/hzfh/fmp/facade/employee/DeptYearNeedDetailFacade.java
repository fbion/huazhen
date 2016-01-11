package com.hzfh.fmp.facade.employee;

import com.hzfh.api.employee.model.DeptYearNeedDetail;
import com.hzfh.api.employee.model.query.DeptYearNeedDetailCondition;
import com.hzfh.api.employee.service.DeptYearNeedDetailService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class DeptYearNeedDetailFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-employee.xml");

    public static PagedList<DeptYearNeedDetail> getPagingList(DeptYearNeedDetailCondition deptYearNeedDetailCondition) {
        DeptYearNeedDetailService deptYearNeedDetailService = (DeptYearNeedDetailService) context.getBean("deptYearNeedDetailService");

        return  deptYearNeedDetailService.getPagingList(deptYearNeedDetailCondition);
    }

    public static int add(DeptYearNeedDetail deptYearNeedDetail){
        DeptYearNeedDetailService deptYearNeedDetailService = (DeptYearNeedDetailService) context.getBean("deptYearNeedDetailService");

        return deptYearNeedDetailService.add(deptYearNeedDetail);
    }

    public static int update(DeptYearNeedDetail deptYearNeedDetail){
        DeptYearNeedDetailService deptYearNeedDetailService = (DeptYearNeedDetailService) context.getBean("deptYearNeedDetailService");

        return deptYearNeedDetailService.update(deptYearNeedDetail);
    }

    public static List<DeptYearNeedDetail> getList(){
        DeptYearNeedDetailService deptYearNeedDetailService = (DeptYearNeedDetailService) context.getBean("deptYearNeedDetailService");

        return deptYearNeedDetailService.getList();
    }

    public static DeptYearNeedDetail getInfo(int id){
        DeptYearNeedDetailService deptYearNeedDetailService = (DeptYearNeedDetailService) context.getBean("deptYearNeedDetailService");

        return deptYearNeedDetailService.getInfo(id);
    }

	public static List<DeptYearNeedDetail> getInfoByNeedNo(int id) {
		DeptYearNeedDetailService deptYearNeedDetailService = (DeptYearNeedDetailService) context.getBean("deptYearNeedDetailService");

        return deptYearNeedDetailService.getInfoByNeedNo(id);
    }
}
