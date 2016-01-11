package com.hzfh.fmp.model.employee;

import com.hzfh.api.employee.model.PositionLevel;
import com.hzfh.api.employee.model.query.PositionLevelCondition;
import com.hzfh.fmp.facade.employee.PositionLevelFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class PositionLevelModel {
    public static PagedList<PositionLevel> getPagingList(PositionLevelCondition positionLevelCondition) {
        return PositionLevelFacade.getPagingList(positionLevelCondition);
    }

    public static int add(PositionLevel positionLevel) {
        return PositionLevelFacade.add(positionLevel);
    }

    public static int update(PositionLevel positionLevel) {
        return PositionLevelFacade.update(positionLevel);
    }

    public static List<PositionLevel> getList() {
        return PositionLevelFacade.getList();
    }

    public static PositionLevel getInfo(int id) {
        return PositionLevelFacade.getInfo(id);
    }

	public static List<PositionLevel> getPositionLevelListByDept(int dept) {
		return PositionLevelFacade.getPositionLevelListByDept(dept);
	}
}
