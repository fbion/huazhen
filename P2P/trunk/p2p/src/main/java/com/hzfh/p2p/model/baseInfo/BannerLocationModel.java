package com.hzfh.p2p.model.baseInfo;

import com.hzfh.api.baseInfo.model.BannerLocation;
import com.hzfh.api.baseInfo.model.query.BannerLocationCondition;
import com.hzfh.p2p.facade.baseInfo.BannerLocationFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class BannerLocationModel {
    public static PagedList<BannerLocation> getPagingList(BannerLocationCondition bannerLocationCondition) {
        return BannerLocationFacade.getPagingList(bannerLocationCondition);
    }

    public static int add(BannerLocation bannerLocation) {
        return BannerLocationFacade.add(bannerLocation);
    }

    public static int update(BannerLocation bannerLocation) {
        return BannerLocationFacade.update(bannerLocation);
    }

    public static List<BannerLocation> getList() {
        return BannerLocationFacade.getList();
    }

    public static BannerLocation getInfo(int id) {
        return BannerLocationFacade.getInfo(id);
    }

	public static BannerLocation getInfoByCondition(
			BannerLocationCondition bannerLocationCondition) {
		return BannerLocationFacade.getInfoByCondition(bannerLocationCondition);
	}
}
