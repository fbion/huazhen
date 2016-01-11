package com.hzfh.api.employee.service;

import com.hzfh.api.employee.model.EmpCompilePlan;
import com.hzfh.api.employee.model.query.EmpCompilePlanCondition;
import com.hzframework.data.service.BaseService;

import java.util.List;


public interface EmpCompilePlanService extends BaseService<EmpCompilePlan, EmpCompilePlanCondition> {

    public  List<EmpCompilePlan> getListForExcel(EmpCompilePlanCondition empCompilePlanCondition);
}