package com.hzfh.fmp.facade.employee;

import com.hzfh.api.employee.model.RecruitFollow;
import com.hzfh.api.employee.model.query.RecruitFollowCondition;
import com.hzfh.api.employee.service.RecruitFollowService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class RecruitFollowFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-employee.xml");

    public static PagedList<RecruitFollow> getPagingList(RecruitFollowCondition recruitFollowCondition) {
        RecruitFollowService recruitFollowService = (RecruitFollowService) context.getBean("recruitFollowService");

        return  recruitFollowService.getPagingList(recruitFollowCondition);
    }

    public static int add(RecruitFollow recruitFollow){
        RecruitFollowService recruitFollowService = (RecruitFollowService) context.getBean("recruitFollowService");

        return recruitFollowService.add(recruitFollow);
    }

    public static int update(RecruitFollow recruitFollow){
        RecruitFollowService recruitFollowService = (RecruitFollowService) context.getBean("recruitFollowService");

        return recruitFollowService.update(recruitFollow);
    }

    public static List<RecruitFollow> getList(){
        RecruitFollowService recruitFollowService = (RecruitFollowService) context.getBean("recruitFollowService");

        return recruitFollowService.getList();
    }

    public static RecruitFollow getInfo(int id){
        RecruitFollowService recruitFollowService = (RecruitFollowService) context.getBean("recruitFollowService");

        return recruitFollowService.getInfo(id);
    }
}
