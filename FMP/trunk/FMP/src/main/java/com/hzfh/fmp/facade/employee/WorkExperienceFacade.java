package com.hzfh.fmp.facade.employee;

import com.hzfh.api.employee.model.WorkExperience;
import com.hzfh.api.employee.model.query.WorkExperienceCondition;
import com.hzfh.api.employee.service.WorkExperienceService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class WorkExperienceFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-employee.xml");

    public static PagedList<WorkExperience> getPagingList(WorkExperienceCondition workExperienceCondition) {
        WorkExperienceService workExperienceService = (WorkExperienceService) context.getBean("workExperienceService");

        return  workExperienceService.getPagingList(workExperienceCondition);
    }

    public static int add(WorkExperience workExperience){
        WorkExperienceService workExperienceService = (WorkExperienceService) context.getBean("workExperienceService");

        return workExperienceService.add(workExperience);
    }

    public static int update(WorkExperience workExperience){
        WorkExperienceService workExperienceService = (WorkExperienceService) context.getBean("workExperienceService");

        return workExperienceService.update(workExperience);
    }

    public static List<WorkExperience> getList(){
        WorkExperienceService workExperienceService = (WorkExperienceService) context.getBean("workExperienceService");

        return workExperienceService.getList();
    }

    public static WorkExperience getInfo(int id){
        WorkExperienceService workExperienceService = (WorkExperienceService) context.getBean("workExperienceService");

        return workExperienceService.getInfo(id);
    }

    public static List<WorkExperience> getWorkExperiencdByEmpNo(int empNo){
        WorkExperienceService workExperienceService = (WorkExperienceService) context.getBean("workExperienceService");
        return  workExperienceService.getWorkExperiencdByEmpNo(empNo);
    }

}
