package com.hzfh.weixin.model.baseInfo;

import com.hzfh.api.baseInfo.model.District;
import com.hzfh.api.baseInfo.model.query.DistrictCondition;
import com.hzfh.weixin.facade.baseInfo.DistrictFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class DistrictModel {
    public static PagedList<District> getPagingList(DistrictCondition districtCondition) {
        return DistrictFacade.getPagingList(districtCondition);
    }

    public static int add(District district) {
        return DistrictFacade.add(district);
    }

    public static int update(District district) {
        return DistrictFacade.update(district);
    }

    public static List<District> getList() {
        return DistrictFacade.getList();
    }

    public static District getInfo(int id) {
        return DistrictFacade.getInfo(id);
    }
    public static List<District> getDistrictListByCityNo(int cityNo) {
		return DistrictFacade.getDistrictListByCityNo(cityNo);
	}
    public static List<District> getDistrictListByCityNoAndEnabled(int cityNo,byte enabled) {
    	return DistrictFacade.getDistrictListByCityNoAndEnabled(cityNo, enabled);
    }
}
