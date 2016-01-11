package com.hzfh.fmp.model.employee;

import com.hzfh.api.employee.model.Position;
import com.hzfh.api.employee.model.query.PositionCondition;
import com.hzfh.fmp.facade.employee.PositionFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class PositionModel {
    public static PagedList<Position> getPagingList(PositionCondition positionCondition) {
        return PositionFacade.getPagingList(positionCondition);
    }

    public static int add(Position position) {
        return PositionFacade.add(position);
    }

    public static int update(Position position) {
        return PositionFacade.update(position);
    }

    public static List<Position> getList() {
        return PositionFacade.getList();
    }

    public static Position getInfo(int id) {
        return PositionFacade.getInfo(id);
    }

	public static List<Position> getPositionByDept(int deptNo) {
		return PositionFacade.getPositionByDept(deptNo);
	}

	public static List<Position> getPositionListBydept(int dept) {
		return PositionFacade.getPositionListBydept(dept);
	}

	public static Position getPositionByPositionNo(int positionNo) {
		return PositionFacade.getPositionByPositionNo(positionNo);
	}
}
