           package com.hzfh.service.employee.dao;

		   import com.hzfh.api.employee.model.DeptYearNeed;
		   import com.hzfh.api.employee.model.query.DeptYearNeedCondition;
		   import com.hzframework.data.dao.BaseDao;

		   import java.util.List;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/5/11 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


public interface DeptYearNeedDao extends BaseDao<DeptYearNeed, DeptYearNeedCondition> {

	List<DeptYearNeed> getFinancialYear();

	List<DeptYearNeed> getListByYear(int y);

	int updateStatusByActivitiNo(String activitiNo);

	DeptYearNeed getByActivitiNo(String activitiNo);
}