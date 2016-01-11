package com.hzfh.fmp.model.employee;

import com.hzfh.api.employee.model.TempRecruitDetail;
import com.hzfh.api.employee.model.query.TempRecruitDetailCondition;
import com.hzfh.fmp.facade.employee.TempRecruitDetailFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class TempRecruitDetailModel {
    public static PagedList<TempRecruitDetail> getPagingList(TempRecruitDetailCondition tempRecruitDetailCondition) {
        return TempRecruitDetailFacade.getPagingList(tempRecruitDetailCondition);
    }

    public static int add(TempRecruitDetail tempRecruitDetail) {
        return TempRecruitDetailFacade.add(tempRecruitDetail);
    }
    public static int updateByNeedNo(TempRecruitDetail tempRecruitDetail) {
        return TempRecruitDetailFacade.updateByNeedNo(tempRecruitDetail);
    }
    public static int update(TempRecruitDetail tempRecruitDetail) {
        return TempRecruitDetailFacade.update(tempRecruitDetail);
    }
    
    public static List<TempRecruitDetail> getList() {
        return TempRecruitDetailFacade.getList();
    }

    public static TempRecruitDetail getInfo(int id) {
        return TempRecruitDetailFacade.getInfo(id);
    }

	public static TempRecruitDetail getInfoByNeedNo(int id) {
		// TODO Auto-generated method stub
		return TempRecruitDetailFacade.getInfoByNeedNo(id);
	}
}
