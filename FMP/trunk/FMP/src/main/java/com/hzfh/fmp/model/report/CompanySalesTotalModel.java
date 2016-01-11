package com.hzfh.fmp.model.report;

import com.hzfh.api.report.model.CompanySalesDaily;
import com.hzfh.api.report.model.CompanySalesTotal;
import com.hzfh.api.report.model.query.CompanySalesTotalCondition;
import com.hzfh.fmp.facade.report.CompanySalesTotalFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class CompanySalesTotalModel {
    public static PagedList<CompanySalesTotal> getPagingList(CompanySalesTotalCondition companySalesTotalCondition) {
        return CompanySalesTotalFacade.getPagingList(companySalesTotalCondition);
    }

    public static int add(CompanySalesTotal companySalesTotal) {
        return CompanySalesTotalFacade.add(companySalesTotal);
    }

    public static int update(CompanySalesTotal companySalesTotal) {
        return CompanySalesTotalFacade.update(companySalesTotal);
    }

    public static List<CompanySalesTotal> getList() {
        return CompanySalesTotalFacade.getList();
    }

    public static CompanySalesTotal getInfo(int id) {
        return CompanySalesTotalFacade.getInfo(id);
    }

	public static List<CompanySalesDaily> getListByProductNo(String productID) {
		return CompanySalesTotalFacade.getListByProductNo(productID);
	}
}
