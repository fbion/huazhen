package com.hzfh.fmp.model.baseInfo;

import com.hzfh.api.baseInfo.model.City;
import com.hzfh.api.baseInfo.model.query.CityCondition;
import com.hzfh.fmp.facade.baseInfo.CityFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class CityModel {
    public static PagedList<City> getPagingList(CityCondition cityCondition) {
        return CityFacade.getPagingList(cityCondition);
    }

    public static int add(City city) {
        return CityFacade.add(city);
    }

    public static int update(City city) {
        return CityFacade.update(city);
    }

    public static List<City> getList() {
        return CityFacade.getList();
    }

    public static City getInfo(int id) {
        return CityFacade.getInfo(id);
    }

    public static List<City> getCityListByProvinceNo(int provinceNo) {
		return CityFacade.getCityListByProvinceNo(provinceNo);
	}

    public static List<City> getCityListByProvinceNoAndEnabled(int provinceNo,byte enabled) {
        return CityFacade.getCityListByProvinceNoAndEnabled(provinceNo,enabled);
    }
}
