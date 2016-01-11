package com.hzfh.fmp.facade.employee;

import com.hzfh.api.employee.model.AchievementCommission;
import com.hzfh.api.employee.model.query.AchievementCommissionCondition;
import com.hzfh.api.employee.service.AchievementCommissionService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class AchievementCommissionFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-employee.xml");

    public static PagedList<AchievementCommission> getPagingList(AchievementCommissionCondition achievementCommissionCondition) {
        AchievementCommissionService achievementCommissionService = (AchievementCommissionService) context.getBean("achievementCommissionService");

        return  achievementCommissionService.getPagingList(achievementCommissionCondition);
    }

    public static List<AchievementCommission> getList(){
        AchievementCommissionService achievementCommissionService = (AchievementCommissionService) context.getBean("achievementCommissionService");

        return achievementCommissionService.getList();
    }

	public static List<AchievementCommission> getListForExcel(AchievementCommissionCondition achievementCommissionCondition) {
		AchievementCommissionService achievementCommissionService = (AchievementCommissionService) context.getBean("achievementCommissionService");
		return achievementCommissionService.getListForExcel(achievementCommissionCondition);
	}

	public static List<AchievementCommission> getListByEmpNo(int empNo) {
		AchievementCommissionService achievementCommissionService = (AchievementCommissionService) context.getBean("achievementCommissionService");
		return achievementCommissionService.getListByEmpNo(empNo);
	}
}
