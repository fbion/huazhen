package com.hzfh.weixin.model.sales;
import com.hzfh.api.sales.model.Sales;
import com.hzfh.api.sales.model.query.SalesCondition;
import com.hzfh.weixin.facade.sales.SalesFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class SalesModel {
    public static PagedList<Sales> getPagingList(SalesCondition salesCondition) {
        return SalesFacade.getPagingList(salesCondition);
    }

    public static int add(Sales sales) {
        return SalesFacade.add(sales);
    }

    public static int update(Sales sales) {
        return SalesFacade.update(sales);
    }

    public static List<Sales> getList() {
        return SalesFacade.getList();
    }

    public static Sales getInfo(int id) {
        return SalesFacade.getInfo(id);
    }

    //need override this method
	public static int updateStatus(int id, byte status) {
		return SalesFacade.updateStatus(id,status);
	}

}
