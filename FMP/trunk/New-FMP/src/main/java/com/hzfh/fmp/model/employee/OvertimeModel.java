package com.hzfh.fmp.model.employee;

import com.hzfh.api.employee.model.Overtime;
import com.hzfh.api.employee.model.query.OvertimeCondition;
import com.hzfh.fmp.facade.employee.OvertimeFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class OvertimeModel {
    public static PagedList<Overtime> getPagingList(OvertimeCondition overtimeCondition) {
        return OvertimeFacade.getPagingList(overtimeCondition);
    }

    public static int add(Overtime overtime) {
        return OvertimeFacade.add(overtime);
    }

    public static int update(Overtime overtime) {
        return OvertimeFacade.update(overtime);
    }

    public static List<Overtime> getList() {
        return OvertimeFacade.getList();
    }

    public static Overtime getInfo(int id) {
        return OvertimeFacade.getInfo(id);
    }
}
