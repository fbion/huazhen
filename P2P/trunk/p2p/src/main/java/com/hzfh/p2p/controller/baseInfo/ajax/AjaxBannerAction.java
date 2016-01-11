package com.hzfh.p2p.controller.baseInfo.ajax;

import java.util.List;

import com.hzfh.api.baseInfo.model.BannerInfo;
import com.hzfh.api.baseInfo.model.BannerLocation;
import com.hzfh.api.baseInfo.model.query.BannerInfoCondition;
import com.hzfh.api.baseInfo.model.query.BannerLocationCondition;
import com.hzfh.p2p.controller.common.BaseAction;
import com.hzfh.p2p.model.baseInfo.BannerInfoModel;
import com.hzfh.p2p.model.baseInfo.BannerLocationModel;
import com.hzfh.p2p.model.common.helper.PageAliasHelper;
import com.hzfh.p2p.model.common.helper.UrlHelper;
import com.hzframework.helper.StringHelper;


public class AjaxBannerAction extends BaseAction {
    private String pageType;
    private String pageNo;
    private String position;
    private int displayType;
    private String webUrl;
    private int bannerCount=5;
	public void setBannerCount(int bannerCount) {
		this.bannerCount = bannerCount;
	}

	public int getBannerCount() {
		return bannerCount;
	}

	public String getWebUrl() {
		return webUrl;
	}

	public int getDisplayType() {
		return displayType;
	}

	public void setDisplayType(int displayType) {
		this.displayType = displayType;
	}

	public String getPageType() {
		return pageType;
	}

	public void setPageType(String pageType) {
		this.pageType = pageType;
	}

	public String getPageNo() {
		return pageNo;
	}

	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	private BannerLocation bannerLocation;
	public BannerLocation getBannerLocation() {
		return bannerLocation;
	}

	public void setBannerLocation(BannerLocation bannerLocation) {
		this.bannerLocation = bannerLocation;
	}
	private List<BannerInfo> bannerInfoList;
	public List<BannerInfo> getBannerInfoList() {
		return bannerInfoList;
	}

	public void setBannerInfoList(List<BannerInfo> bannerInfoList) {
		this.bannerInfoList = bannerInfoList;
	}

	@Override
	public String execute() {
		/*System.out.println(bannerCount);*/
		BannerLocationCondition bannerLocationCondition = new BannerLocationCondition();
		int tpye = PageAliasHelper.getPageType(pageType);
		if(tpye!=0){
			bannerLocationCondition.setPageType(tpye);
		}
		if(!StringHelper.isNullOrEmpty(position)){
			bannerLocationCondition.setPositionNo(Integer.valueOf(position));
		}
		this.bannerLocation = BannerLocationModel.getInfoByCondition(bannerLocationCondition);
		
		BannerInfoCondition bannerInfoCondition = new BannerInfoCondition();
		bannerInfoCondition.setByLocation(bannerLocation.getId());
		if(!StringHelper.isNullOrEmpty(pageNo)){
			bannerInfoCondition.setByPageNo(Integer.valueOf(pageNo));
		}
		bannerInfoCondition.setCount(this.bannerCount);//广告条数
		this.bannerInfoList = BannerInfoModel.getInfoListByCondition(bannerInfoCondition);
		for (BannerInfo bannerInfo : bannerInfoList) {
			if(StringHelper.isNullOrEmpty(bannerInfo.getLinkUrl())){
				bannerInfo.setLinkUrl("javascript:void(0)");
			}
			bannerInfo.setResrcurl(UrlHelper.bulidBannerImg(bannerInfo.getResrcurl()));
		}
		webUrl = UrlHelper.bulidWebUrl("");
		return SUCCESS;
	}
    
}
