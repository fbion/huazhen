package com.hzfh.fmp.model.sales;

import com.hzfh.api.sales.model.Income;
import com.hzfh.api.sales.model.query.IncomeCondition;
import com.hzfh.fmp.facade.sales.IncomeFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class IncomeModel {
    public static PagedList<Income> getPagingList(IncomeCondition incomeCondition) {
        return IncomeFacade.getPagingList(incomeCondition);
    }

    public static int add(Income income) {
        return IncomeFacade.add(income);
    }

    public static int update(Income income) {
        return IncomeFacade.update(income);
    }

    public static List<Income> getList() {
        return IncomeFacade.getList();
    }

    public static Income getInfo(int id) {
        return IncomeFacade.getInfo(id);
    }
}
