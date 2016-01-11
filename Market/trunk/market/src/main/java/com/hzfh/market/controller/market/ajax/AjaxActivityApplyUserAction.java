package com.hzfh.market.controller.market.ajax;

import com.hzfh.api.market.model.ActivityApplyUser;
import com.hzfh.market.controller.common.JsonBaseAction;
import com.hzfh.market.model.market.ActivityApplyUserModel;

public class AjaxActivityApplyUserAction extends JsonBaseAction<ActivityApplyUser>{
	private String cellphone;
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public String checkCellphone(){
		this.message = new Message();
		ActivityApplyUser activityApplyUser = ActivityApplyUserModel.getInfoByCellphone(this.cellphone,Integer.parseInt(this.id));
		if(activityApplyUser == null){
			this.message.setType(MessageType.Info);
			this.message.setDescription("此电话本次活动未报名");
			return SUCCESS;
		}else{
			this.message.setType(MessageType.Error);
			this.message.setDescription("此电话已报名本次活动");
			return SUCCESS;
		}
	}
}
