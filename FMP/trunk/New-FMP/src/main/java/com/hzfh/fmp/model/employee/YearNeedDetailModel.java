package com.hzfh.fmp.model.employee;

import com.hzfh.api.employee.model.YearNeedDetail;
import com.hzfh.api.employee.model.query.YearNeedDetailCondition;
import com.hzfh.fmp.facade.employee.YearNeedDetailFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class YearNeedDetailModel {
    public static PagedList<YearNeedDetail> getPagingList(YearNeedDetailCondition yearNeedDetailCondition) {
        return YearNeedDetailFacade.getPagingList(yearNeedDetailCondition);
    }

    public static int add(YearNeedDetail yearNeedDetail) {
        return YearNeedDetailFacade.add(yearNeedDetail);
    }

    public static int update(YearNeedDetail yearNeedDetail) {
        return YearNeedDetailFacade.update(yearNeedDetail);
    }

    public static List<YearNeedDetail> getList() {
        return YearNeedDetailFacade.getList();
    }

    public static YearNeedDetail getInfo(int id) {
        return YearNeedDetailFacade.getInfo(id);
    }

	public static List<YearNeedDetail> getListByNeedNo(int id) {
		// TODO Auto-generated method stub
		return YearNeedDetailFacade.getListByNeedNo(id);
	}
}
