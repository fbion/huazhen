package com.hzfh.fmp.facade.employee;

import com.hzfh.api.employee.model.PositionLevel;
import com.hzfh.api.employee.model.query.PositionLevelCondition;
import com.hzfh.api.employee.service.PositionLevelService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class PositionLevelFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-employee.xml");

    public static PagedList<PositionLevel> getPagingList(PositionLevelCondition positionLevelCondition) {
        PositionLevelService positionLevelService = (PositionLevelService) context.getBean("positionLevelService");

        return  positionLevelService.getPagingList(positionLevelCondition);
    }

    public static int add(PositionLevel positionLevel){
        PositionLevelService positionLevelService = (PositionLevelService) context.getBean("positionLevelService");

        return positionLevelService.add(positionLevel);
    }

    public static int update(PositionLevel positionLevel){
        PositionLevelService positionLevelService = (PositionLevelService) context.getBean("positionLevelService");

        return positionLevelService.update(positionLevel);
    }

    public static List<PositionLevel> getList(){
        PositionLevelService positionLevelService = (PositionLevelService) context.getBean("positionLevelService");

        return positionLevelService.getList();
    }

    public static PositionLevel getInfo(int id){
        PositionLevelService positionLevelService = (PositionLevelService) context.getBean("positionLevelService");

        return positionLevelService.getInfo(id);
    }

	public static List<PositionLevel> getPositionLevelListByDept(int dept) {
		PositionLevelService positionLevelService = (PositionLevelService) context.getBean("positionLevelService");
        return positionLevelService.getPositionLevelListByDept(dept);
	}
}
