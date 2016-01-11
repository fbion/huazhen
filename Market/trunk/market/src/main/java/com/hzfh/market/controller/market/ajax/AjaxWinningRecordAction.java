package com.hzfh.market.controller.market.ajax;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hzfh.api.market.model.ActivityUsers;
import com.hzfh.api.market.model.WinningRecord;
import com.hzfh.market.controller.common.CrossDomainCommon;
import com.hzfh.market.model.market.ActivityUsersModel;
import com.hzfh.market.model.market.WinningRecordModel;


public class AjaxWinningRecordAction extends CrossDomainCommon {
	private int id;
	
	public void setId(int id) {
		this.id = id;
	}

	public String  getWinnersByDraw()throws Exception {
		List<WinningRecord> winningRecordList = WinningRecordModel.getAllWinersByDrawNo(id);
		List<ActivityUser> activityUserList = new ArrayList<ActivityUser>();
		for (WinningRecord winningRecord : winningRecordList) {
			ActivityUsers activityUsers = ActivityUsersModel.getInfo(winningRecord.getUserId());
			ActivityUser activityUser = new ActivityUser();
			activityUser.setId(activityUsers.getId());
			System.out.println(activityUsers.getId());
        	activityUser.setUserName(activityUsers.getUserName());
        	//activityUser.setImgPath(UrlHelper.bulidWebUploadPath(activityUsers.getUserImgPath()));
        	activityUser.setImgPath(activityUsers.getUserImgPath());
        	activityUserList.add(activityUser);
		}
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("winners",activityUserList);
		return  outJson(map);
	}
}
