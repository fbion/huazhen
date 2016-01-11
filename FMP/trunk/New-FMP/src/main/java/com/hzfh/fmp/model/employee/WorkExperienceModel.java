package com.hzfh.fmp.model.employee;

import com.hzfh.api.employee.model.WorkExperience;
import com.hzfh.api.employee.model.query.WorkExperienceCondition;
import com.hzfh.fmp.facade.employee.WorkExperienceFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class WorkExperienceModel {
    public static PagedList<WorkExperience> getPagingList(WorkExperienceCondition workExperienceCondition) {
        return WorkExperienceFacade.getPagingList(workExperienceCondition);
    }

    public static int add(WorkExperience workExperience) {
        return WorkExperienceFacade.add(workExperience);
    }

    public static int update(WorkExperience workExperience) {
        return WorkExperienceFacade.update(workExperience);
    }

    public static List<WorkExperience> getList() {
        return WorkExperienceFacade.getList();
    }

    public static WorkExperience getInfo(int id) {
        return WorkExperienceFacade.getInfo(id);
    }

    public static List<WorkExperience> getWorkExperiencdByEmpNo(int empNo){
        return  WorkExperienceFacade.getWorkExperiencdByEmpNo(empNo);
    }
}
