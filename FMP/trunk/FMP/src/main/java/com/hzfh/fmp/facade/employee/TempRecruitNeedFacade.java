package com.hzfh.fmp.facade.employee;

import com.hzfh.api.employee.model.TempRecruitNeed;
import com.hzfh.api.employee.model.query.TempRecruitNeedCondition;
import com.hzfh.api.employee.service.TempRecruitNeedService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TempRecruitNeedFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-employee.xml");

    public static PagedList<TempRecruitNeed> getPagingList(TempRecruitNeedCondition tempRecruitNeedCondition) {
        TempRecruitNeedService tempRecruitNeedService = (TempRecruitNeedService) context.getBean("tempRecruitNeedService");

        return  tempRecruitNeedService.getPagingList(tempRecruitNeedCondition);
    }

    public static int add(TempRecruitNeed tempRecruitNeed){
        TempRecruitNeedService tempRecruitNeedService = (TempRecruitNeedService) context.getBean("tempRecruitNeedService");

        return tempRecruitNeedService.add(tempRecruitNeed);
    }

    public static int update(TempRecruitNeed tempRecruitNeed){
        TempRecruitNeedService tempRecruitNeedService = (TempRecruitNeedService) context.getBean("tempRecruitNeedService");

        return tempRecruitNeedService.update(tempRecruitNeed);
    }

    public static List<TempRecruitNeed> getList(){
        TempRecruitNeedService tempRecruitNeedService = (TempRecruitNeedService) context.getBean("tempRecruitNeedService");

        return tempRecruitNeedService.getList();
    }

    public static TempRecruitNeed getInfo(int id){
        TempRecruitNeedService tempRecruitNeedService = (TempRecruitNeedService) context.getBean("tempRecruitNeedService");

        return tempRecruitNeedService.getInfo(id);
    }
}
