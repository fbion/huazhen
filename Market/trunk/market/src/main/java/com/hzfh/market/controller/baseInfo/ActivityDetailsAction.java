package com.hzfh.market.controller.baseInfo;

import java.util.Calendar;
import java.util.List;

import com.hzfh.api.sales.model.Activity;
import com.hzfh.api.sales.model.ActivityAttachment;
import com.hzfh.market.controller.common.CommonAction;
import com.hzfh.market.model.common.PageAlias;
import com.hzfh.market.model.common.helper.UrlHelper;
import com.hzfh.market.model.employee.EmployeeModel;
import com.hzfh.market.model.sales.ActivityAttachmentModel;
import com.hzfh.market.model.sales.ActivityModel;
import com.hzframework.helper.DateHelper;

public class ActivityDetailsAction extends CommonAction {
	private String id;
	private Activity activity;
	private String activityDay;
	public String getActivityDay() {
		return activityDay;
	}
	public void setActivityDay(String activityDay) {
		this.activityDay = activityDay;
	}
	private String publisher;
	private String publishDay;
	public String getPublishDay() {
		return publishDay;
	}
	public void setPublishDay(String publishDay) {
		this.publishDay = publishDay;
	}
	public String getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}
	private String publishTime;
	private String activityTime;
	private List<ActivityAttachment> activityAttachmentList;
	public List<ActivityAttachment> getActivityAttachmentList() {
		return activityAttachmentList;
	}
	public void setActivityAttachmentList(
			List<ActivityAttachment> activityAttachmentList) {
		this.activityAttachmentList = activityAttachmentList;
	}
	public String getActivityTime() {
		return activityTime;
	}
	public void setActivityTime(String activityTime) {
		this.activityTime = activityTime;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Activity getActivity() {
		return activity;
	}
	public void setActivity(Activity activity) {
		this.activity = activity;
	}
	public String execute() {
			
			this.setPageAlias(PageAlias.activityDetails);
			String ret = super.execute();
			if (!ret.equals(SUCCESS)){
				return ret;
			}
			this.activity = ActivityModel.getInfo(Integer.parseInt(this.id));
			if(this.activity.getStatus()==2||this.activity.getStatus()==3){
				this.publisher = EmployeeModel.getEmpByUserId(this.activity.getInUserNo()).getName();
				this.publishDay = DateHelper.format(new java.sql.Date(this.activity.getInTime().getTime()));
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(this.activity.getInTime());
				this.publishTime = (calendar.get(Calendar.HOUR_OF_DAY)<10?"0"+calendar.get(Calendar.HOUR_OF_DAY):calendar.get(Calendar.HOUR_OF_DAY))+":"+
						(calendar.get(Calendar.MINUTE)<10?"0"+calendar.get(Calendar.MINUTE):calendar.get(Calendar.MINUTE));
				this.activityTime = DateHelper.format(new java.sql.Date(this.activity.getActivityTime().getTime()));
				this.activityAttachmentList = ActivityAttachmentModel.getListByActivityNo(this.activity.getId());
				for(ActivityAttachment activityAttachment : this.activityAttachmentList){
					activityAttachment.setPath(UrlHelper.bulidWebUploadPath(activityAttachment.getPath()));
				}
				calendar.setTime(this.activity.getActivityTime());
				String[] weekDays = {"","周日","周一","周二","周三","周四","周五","周六"};
				this.activityDay = weekDays[calendar.get(Calendar.DAY_OF_WEEK)];
				
				return SUCCESS;
			}else{
				this.activity = null;
				return ERROR;
			}
		}
}
