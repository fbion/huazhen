package com.hzfh.service.employee.serviceImpl;

import com.hzfh.api.employee.model.EmpCompilePlan;
import com.hzfh.api.employee.model.query.EmpCompilePlanCondition;
import com.hzfh.api.employee.service.EmpCompilePlanService;
import com.hzfh.service.employee.dao.EmpCompilePlanDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("empCompilePlanService")
public class EmpCompilePlanServiceImpl extends BaseServiceImpl<EmpCompilePlan, EmpCompilePlanCondition, EmpCompilePlanDao> implements EmpCompilePlanService {
    @Autowired
    private EmpCompilePlanDao empCompilePlanDao;
    @Override
    public List<EmpCompilePlan> getListForExcel(EmpCompilePlanCondition empCompilePlanCondition){
        return empCompilePlanDao.getListForExcel(empCompilePlanCondition);
    }
}