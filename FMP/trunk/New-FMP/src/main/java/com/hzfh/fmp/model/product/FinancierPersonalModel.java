package com.hzfh.fmp.model.product;

import com.hzfh.api.product.model.FinancierPersonal;
import com.hzfh.api.product.model.query.FinancierPersonalCondition;
import com.hzfh.fmp.facade.product.FinancierPersonalFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class FinancierPersonalModel {
    public static PagedList<FinancierPersonal> getPagingList(FinancierPersonalCondition financierPersonalCondition) {
        return FinancierPersonalFacade.getPagingList(financierPersonalCondition);
    }

    public static int add(FinancierPersonal financierPersonal) {
        return FinancierPersonalFacade.add(financierPersonal);
    }

    public static int update(FinancierPersonal financierPersonal) {
        return FinancierPersonalFacade.update(financierPersonal);
    }

    public static List<FinancierPersonal> getList() {
        return FinancierPersonalFacade.getList();
    }

    public static FinancierPersonal getInfo(int id) {
        return FinancierPersonalFacade.getInfo(id);
    }
}
