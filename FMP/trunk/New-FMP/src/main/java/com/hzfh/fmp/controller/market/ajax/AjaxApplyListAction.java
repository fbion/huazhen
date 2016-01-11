package com.hzfh.fmp.controller.market.ajax;

import java.util.ArrayList;
import java.util.List;

import com.hzfh.api.market.model.ActivityApplyUser;
import com.hzfh.api.market.model.query.ActivityApplyUserCondition;
import com.hzfh.api.sales.model.Activity;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.market.ActivityApplyUserModel;
import com.hzfh.fmp.model.market.ActivityUsersModel;
import com.hzfh.fmp.model.sales.ActivityModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.contract.SortType;

public class AjaxApplyListAction extends JqGridBaseAction<ActivityApplyUser> {
	private int activityNo;
	private int pageIndex;
	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	private PagedList<ActivityApplyUser> activityApplyUserPagedList;
	public PagedList<ActivityApplyUser> getActivityApplyUserPagedList() {
		return activityApplyUserPagedList;
	}

	public void setActivityApplyUserPagedList(
			PagedList<ActivityApplyUser> activityApplyUserPagedList) {
		this.activityApplyUserPagedList = activityApplyUserPagedList;
	}

	private Activity activity;

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public int getActivityNo() {
		return activityNo;
	}
	
	public void setActivityNo(int activityNo) {
		this.activityNo = activityNo;
	}

	public String execute() {
		this.activity = ActivityModel.getInfo(this.activityNo);
		this.activityApplyUserPagedList = ActivityApplyUserModel.getPagingList(this.getCondition());
		
		return SUCCESS;
	}
	
	private ActivityApplyUserCondition getCondition(){
		ActivityApplyUserCondition activityApplyUserCondition = new ActivityApplyUserCondition();
		List<SortItem> sortItemList = new ArrayList<SortItem>();
		SortItem sortItem = new SortItem();
		sortItem.setSortFeild("id");
		sortItem.setSortType(SortType.ASC);
		sortItemList.add(sortItem);
		activityApplyUserCondition.setSortItemList(sortItemList);
		activityApplyUserCondition.setPageIndex(this.pageIndex);
		activityApplyUserCondition.setPageSize(10);
		activityApplyUserCondition.setActivityNo(this.activityNo);
		
		return activityApplyUserCondition;
	}
}
