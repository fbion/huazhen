package com.hzfh.fmp.controller.index;
import com.hzfh.api.sales.model.Activity;
import com.hzfh.fmp.controller.common.CommonAction;
import com.hzfh.fmp.model.common.PageAlias;
import com.hzfh.fmp.model.common.helper.UrlHelper;
import com.hzfh.fmp.model.sales.ActivityModel;

import java.util.List;

public class ActivityIndexAction extends CommonAction {
    private List<Activity> activity;

	public List<Activity> getActivity() {
		return activity;
	}

	public void setActivity(List<Activity> activity) {
		this.activity = activity;
	}
	private String activityListUrl;
	private String activityDetailUrl;
	
	public String getActivityListUrl() {
		return activityListUrl;
	}

	public void setActivityListUrl(String activityListUrl) {
		this.activityListUrl = activityListUrl;
	}

	public String getActivityDetailUrl() {
		return activityDetailUrl;
	}

	public void setActivityDetailUrl(String activityDetailUrl) {
		this.activityDetailUrl = activityDetailUrl;
	}

	@Override
    public String execute() throws Exception {
	
    	this.setPageAlias(PageAlias.activityIndex);
    	activity=ActivityModel.getList();
    	 this.showUrl();
    	return SUCCESS;
    }
	private void showUrl(){	
		this.activityListUrl = UrlHelper.buildSalesSiteUrl("sales/activity/list");
		this.activityDetailUrl = UrlHelper.buildSalesSiteUrl("sales/activity/edit?id=");
	}
	
}
