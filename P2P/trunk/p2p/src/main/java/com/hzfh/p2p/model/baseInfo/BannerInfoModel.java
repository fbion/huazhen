package com.hzfh.p2p.model.baseInfo;

import com.hzfh.api.baseInfo.model.BannerInfo;
import com.hzfh.api.baseInfo.model.query.BannerInfoCondition;
import com.hzfh.p2p.facade.baseInfo.BannerInfoFacade;
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

	public static List<BannerInfo> getInfoListByCondition(BannerInfoCondition bannerInfoCondition) {
		/*@SuppressWarnings("unchecked")
		//List<BannerInfo> bannerInfoList=(List<BannerInfo>)CacheManager.get(CachePrefix.BANNER_INFO, ""+bannerInfoCondition.getByLocation()+bannerInfoCondition.getByPageNo()+bannerInfoCondition.getByType());
		if(bannerInfoList==null){
			bannerInfoList = BannerInfoFacade.getInfoListByCondition(bannerInfoCondition);
			CacheManager.set(CachePrefix.BANNER_INFO, ""+bannerInfoCondition.getByLocation()+bannerInfoCondition.getByPageNo()+bannerInfoCondition.getByType(), ParamHelper.BANNER_EXPIRATION_TIME * 60*60*24, bannerInfoList);
		}
		return bannerInfoList;*/
		
		return BannerInfoFacade.getInfoListByCondition(bannerInfoCondition);
	}
}
