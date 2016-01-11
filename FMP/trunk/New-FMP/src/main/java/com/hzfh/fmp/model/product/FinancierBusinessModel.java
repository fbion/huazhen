package com.hzfh.fmp.model.product;

import com.hzfh.api.product.model.FinancierBusiness;
import com.hzfh.api.product.model.query.FinancierBusinessCondition;
import com.hzfh.fmp.facade.product.FinancierBusinessFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class FinancierBusinessModel {
    public static PagedList<FinancierBusiness> getPagingList(FinancierBusinessCondition financierBusinessCondition) {
        return FinancierBusinessFacade.getPagingList(financierBusinessCondition);
    }

    public static int add(FinancierBusiness financierBusiness) {
        return FinancierBusinessFacade.add(financierBusiness);
    }

    public static int update(FinancierBusiness financierBusiness) {
        return FinancierBusinessFacade.update(financierBusiness);
    }

    public static List<FinancierBusiness> getList() {
        return FinancierBusinessFacade.getList();
    }

    public static FinancierBusiness getInfo(int id) {
        return FinancierBusinessFacade.getInfo(id);
    }
}
