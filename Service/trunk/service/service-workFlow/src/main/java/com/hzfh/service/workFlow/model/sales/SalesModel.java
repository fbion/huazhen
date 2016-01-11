package com.hzfh.service.workFlow.model.sales;

import com.hzfh.api.sales.model.Sales;
import com.hzfh.service.workFlow.facade.sales.SalesFacade;

/**
 * Created by ulei0 on 2015/9/11.
 */
public class SalesModel {
    public static Sales getInfo(int id) {
        return SalesFacade.getInfo(id);
    }

    public static int updateStatus(int id, byte status) {
        return SalesFacade.updateStatus(id, status);
    }
}
