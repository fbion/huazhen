package com.hzfh.fmp.facade.employee;

import com.hzfh.api.employee.model.NeedRelease;
import com.hzfh.api.employee.model.query.NeedReleaseCondition;
import com.hzfh.api.employee.service.NeedReleaseService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class NeedReleaseFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-employee.xml");

    public static PagedList<NeedRelease> getPagingList(NeedReleaseCondition needReleaseCondition) {
        NeedReleaseService needReleaseService = (NeedReleaseService) context.getBean("needReleaseService");

        return  needReleaseService.getPagingList(needReleaseCondition);
    }

    public static int add(NeedRelease needRelease){
        NeedReleaseService needReleaseService = (NeedReleaseService) context.getBean("needReleaseService");

        return needReleaseService.add(needRelease);
    }

    public static int update(NeedRelease needRelease){
        NeedReleaseService needReleaseService = (NeedReleaseService) context.getBean("needReleaseService");

        return needReleaseService.update(needRelease);
    }

    public static List<NeedRelease> getList(){
        NeedReleaseService needReleaseService = (NeedReleaseService) context.getBean("needReleaseService");

        return needReleaseService.getList();
    }

    public static NeedRelease getInfo(int id){
        NeedReleaseService needReleaseService = (NeedReleaseService) context.getBean("needReleaseService");

        return needReleaseService.getInfo(id);
    }
}
