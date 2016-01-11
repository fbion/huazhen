package com.hzfh.service.employee.dao;

import com.hzfh.api.employee.model.EmpCompilePlan;
import com.hzfh.api.employee.model.query.EmpCompilePlanCondition;
import com.hzframework.data.dao.BaseDao;

import java.util.List;

public interface EmpCompilePlanDao extends BaseDao<EmpCompilePlan, EmpCompilePlanCondition> {
    public List<EmpCompilePlan> getListForExcel(EmpCompilePlanCondition empCompilePlanCondition);
}