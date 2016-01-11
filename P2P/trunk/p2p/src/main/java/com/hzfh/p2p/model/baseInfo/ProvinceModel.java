package com.hzfh.p2p.model.baseInfo;

import com.hzfh.api.baseInfo.model.Province;
import com.hzfh.api.baseInfo.model.query.ProvinceCondition;
import com.hzfh.p2p.facade.baseInfo.ProvinceFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class ProvinceModel {
    public static PagedList<Province> getPagingList(ProvinceCondition provinceCondition) {
        return ProvinceFacade.getPagingList(provinceCondition);
    }

    public static int add(Province province) {
        return ProvinceFacade.add(province);
    }

    public static int update(Province province) {
        return ProvinceFacade.update(province);
    }

    public static List<Province> getList() {
        return ProvinceFacade.getList();
    }

    public static Province getInfo(int id) {
        return ProvinceFacade.getInfo(id);
    }
    
    public static List<Province> getListByEnabled(byte enabled){
    	return ProvinceFacade.getListByEnabled(enabled);
    }
}
