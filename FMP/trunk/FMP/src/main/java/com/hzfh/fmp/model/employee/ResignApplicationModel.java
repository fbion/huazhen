package com.hzfh.fmp.model.employee;

import com.hzfh.api.employee.model.ResignApplication;
import com.hzfh.api.employee.model.query.ResignApplicationCondition;
import com.hzfh.fmp.facade.employee.ResignApplicationFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class ResignApplicationModel {
    public static PagedList<ResignApplication> getPagingList(ResignApplicationCondition resignApplicationCondition) {
        return ResignApplicationFacade.getPagingList(resignApplicationCondition);
    }

    public static int add(ResignApplication resignApplication) {
        return ResignApplicationFacade.add(resignApplication);
    }

    public static int update(ResignApplication resignApplication) {
        return ResignApplicationFacade.update(resignApplication);
    }

    public static List<ResignApplication> getList() {
        return ResignApplicationFacade.getList();
    }

    public static ResignApplication getInfo(int id) {
        return ResignApplicationFacade.getInfo(id);
    }
}
