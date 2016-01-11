package com.hzfh.fmp.model.employee;

import com.hzfh.api.employee.model.ExtendProbationApplication;
import com.hzfh.api.employee.model.query.ExtendProbationApplicationCondition;
import com.hzfh.fmp.facade.employee.ExtendProbationApplicationFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class ExtendProbationApplicationModel {
    public static PagedList<ExtendProbationApplication> getPagingList(ExtendProbationApplicationCondition extendProbationApplicationCondition) {
        return ExtendProbationApplicationFacade.getPagingList(extendProbationApplicationCondition);
    }

    public static int add(ExtendProbationApplication extendProbationApplication) {
        return ExtendProbationApplicationFacade.add(extendProbationApplication);
    }

    public static int update(ExtendProbationApplication extendProbationApplication) {
        return ExtendProbationApplicationFacade.update(extendProbationApplication);
    }

    public static List<ExtendProbationApplication> getList() {
        return ExtendProbationApplicationFacade.getList();
    }

    public static ExtendProbationApplication getInfo(int id) {
        return ExtendProbationApplicationFacade.getInfo(id);
    }
}
