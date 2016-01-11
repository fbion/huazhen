package com.hzfh.p2p.model.product;

import java.util.List;

import com.hzfh.api.product.model.FinancierPersonal;
import com.hzfh.api.product.model.query.FinancierPersonalCondition;
import com.hzfh.p2p.facade.product.FinancierPersonalFacade;
import com.hzframework.contract.PagedList;

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
