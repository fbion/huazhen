package com.hzfh.service.employee.daoImpl;

import com.hzfh.api.employee.model.EmpCompilePlan;
import com.hzfh.api.employee.model.query.EmpCompilePlanCondition;
import com.hzfh.service.employee.dao.EmpCompilePlanDao;
import com.hzfh.service.employee.mapper.EmpCompilePlanMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("empCompilePlanDao")
public class EmpCompilePlanDaoImpl extends BaseDaoImpl<EmpCompilePlan, EmpCompilePlanCondition, EmpCompilePlanMapper> implements EmpCompilePlanDao {
    @Autowired
    private EmpCompilePlanMapper empCompilePlanMapper;
    @Override
    public List<EmpCompilePlan> getListForExcel(EmpCompilePlanCondition empCompilePlanCondition){
        return empCompilePlanMapper.getListForExcel(empCompilePlanCondition);
    }
}