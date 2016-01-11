package com.hzfh.fmp.model.baseInfo;

import com.hzfh.api.baseInfo.model.BannerInfo;
import com.hzfh.api.baseInfo.model.query.BannerInfoCondition;
import com.hzfh.fmp.facade.baseInfo.BannerInfoFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class BannerInfoModel {
    public static PagedList<BannerInfo> getPagingList(BannerInfoCondition bannerInfoCondition) {
        return BannerInfoFacade.getPagingList(bannerInfoCondition);
    }

    public static int add(BannerInfo bannerInfo) {
        return BannerInfoFacade.add(bannerInfo);
    }

    public static int update(BannerInfo bannerInfo) {
        return BannerInfoFacade.update(bannerInfo);
    }

    public static List<BannerInfo> getList() {
        return BannerInfoFacade.getList();
    }

    public static BannerInfo getInfo(int id) {
        return BannerInfoFacade.getInfo(id);
    }
}
