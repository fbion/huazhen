package com.hzfh.market.controller.baseInfo.ajax;

import com.hzfh.api.market.model.ActivityApplyUser;
import com.hzfh.market.controller.common.JsonBaseAction;
import com.hzfh.market.controller.common.JsonBaseAction.MessageType;
import com.hzfh.market.model.market.ActivityApplyUserModel;

public class AjaxActivityApplyAction extends JsonBaseAction<ActivityApplyUser>{
	
	private String name;
	private String cellphone;
	private String email;
	private String unit;
	private String job;
	private String id;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String execute(){
		
		this.message = new Message();
		
		//ActivityApplyUser activityApplyUser = ActivityApplyUserModel.getInfoByCellphone(this.cellphone,Integer.parseInt(this.id));
		if(ActivityApplyUserModel.getInfoByCellphone(this.cellphone,Integer.parseInt(this.id)) == null){
			ActivityApplyUser activityApplyUser = new ActivityApplyUser();
			activityApplyUser.setName(name);
			activityApplyUser.setCellphone(cellphone);
			activityApplyUser.setEmail(email);
			activityApplyUser.setUnit(unit);
			activityApplyUser.setJob(job);
			activityApplyUser.setActivityId(Integer.parseInt(id));
			
			int id;
			id = ActivityApplyUserModel.add(activityApplyUser);
			if(id>0){
				this.message.setType(MessageType.Info);
				this.message.setDescription("报名成功");
				return SUCCESS;
			}else{
				this.message.setType(MessageType.Error);
				this.message.setDescription("报名失败");
				return SUCCESS;
			}
		}else{
			this.message.setType(MessageType.Error);
			this.message.setDescription("此电话已报名本次活动");
			return SUCCESS;
		}
		
	}
}
