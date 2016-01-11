package com.hzfh.fmp.model.employee;

import com.hzfh.api.employee.model.AchievementCommission;
import com.hzfh.api.employee.model.query.AchievementCommissionCondition;
import com.hzfh.fmp.facade.employee.AchievementCommissionFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class AchievementCommissionModel {
    public static PagedList<AchievementCommission> getPagingList(AchievementCommissionCondition achievementCommissionCondition) {
        return AchievementCommissionFacade.getPagingList(achievementCommissionCondition);
    }

    public static List<AchievementCommission> getList() {
        return AchievementCommissionFacade.getList();
    }

	public static List<AchievementCommission> getListForExcel(AchievementCommissionCondition achievementCommissionCondition) {
		return AchievementCommissionFacade.getListForExcel(achievementCommissionCondition);
	}
	
	 public static List<AchievementCommission> getListByEmpNo(int empNo) {
	        return AchievementCommissionFacade.getListByEmpNo(empNo);
	    }
	
	
}
