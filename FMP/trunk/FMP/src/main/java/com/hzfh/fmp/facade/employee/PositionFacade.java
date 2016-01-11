package com.hzfh.fmp.facade.employee;

import com.hzfh.api.employee.model.Position;
import com.hzfh.api.employee.model.query.PositionCondition;
import com.hzfh.api.employee.service.PositionService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class PositionFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-employee.xml");

    public static PagedList<Position> getPagingList(PositionCondition positionCondition) {
        PositionService positionService = (PositionService) context.getBean("positionService");

        return  positionService.getPagingList(positionCondition);
    }

    public static int add(Position position){
        PositionService positionService = (PositionService) context.getBean("positionService");

        return positionService.add(position);
    }

    public static int update(Position position){
        PositionService positionService = (PositionService) context.getBean("positionService");

        return positionService.update(position);
    }

    public static List<Position> getList(){
        PositionService positionService = (PositionService) context.getBean("positionService");

        return positionService.getList();
    }

    public static Position getInfo(int id){
        PositionService positionService = (PositionService) context.getBean("positionService");

        return positionService.getInfo(id);
    }

	public static List<Position> getPositionByDept(int deptNo) {
		PositionService positionService = (PositionService) context.getBean("positionService");
		return positionService.getPositionByDept(deptNo);
	}

	public static List<Position> getPositionListBydept(int dept) {
		PositionService positionService = (PositionService) context.getBean("positionService");
		return positionService.getPositionListBydept(dept);
	}

	public static Position getPositionByPositionNo(int positionNo) {
		PositionService positionService = (PositionService) context.getBean("positionService");
		return positionService.getPositionByPositionNo(positionNo);
	}
}
