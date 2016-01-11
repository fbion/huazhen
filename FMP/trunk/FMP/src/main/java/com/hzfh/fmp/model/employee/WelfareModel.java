package com.hzfh.fmp.model.employee;

import com.hzfh.api.employee.model.Welfare;
import com.hzfh.api.employee.model.query.WelfareCondition;
import com.hzfh.fmp.facade.employee.WelfareFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class WelfareModel {
    public static PagedList<Welfare> getPagingList(WelfareCondition welfareCondition) {
        return WelfareFacade.getPagingList(welfareCondition);
    }

    public static int add(Welfare welfare) {
        return WelfareFacade.add(welfare);
    }

    public static int update(Welfare welfare) {
        return WelfareFacade.update(welfare);
    }

    public static List<Welfare> getList() {
        return WelfareFacade.getList();
    }

    public static Welfare getInfo(int id) {
        return WelfareFacade.getInfo(id);
    }
}
