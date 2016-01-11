package com.hzfh.market.controller.market.ajax;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import weixin.pojo.SNSUserInfo;

import com.hzfh.api.market.model.ActivityUsers;
import com.hzfh.api.market.model.WinningRecord;
import com.hzfh.market.controller.common.CrossDomainCommon;
import com.hzfh.market.model.market.ActivityUsersModel;
import com.hzfh.market.model.market.WinningRecordModel;


public class AjaxActivityUsersAction extends CrossDomainCommon{
	
	private int num;
	private int id;
	public void setNum(int num) {
		this.num = num;
	}
	public void setId(int id) {
		this.id = id;
	}
	private int res;
	public int getRes() {
		return res;
	}
	private String openid;
	private String nickname;
	private String headImgUrl;
	private String name;
	private String telephone;
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public void setHeadImgUrl(String headImgUrl) {
		this.headImgUrl = headImgUrl;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String addActivityUsers() {
		ActivityUsers user = ActivityUsersModel.getInfoByOpenId(openid);//判断用户是否已参加
		res=1;//已经参加
		if(user!=null){
			if("1".equals(user.getMark())){
				return SUCCESS;
			}else{
				user.setMark("1");
				user.setCellphone(telephone);
				user.setName(name);
				ActivityUsersModel.update(user);
				return SUCCESS;
			}
		}
		ActivityUsers activityUsers = new ActivityUsers();
		activityUsers.setUserOpenid(openid);
		activityUsers.setUserName(nickname);
		activityUsers.setUserImgPath(headImgUrl);
		activityUsers.setName(name);
		activityUsers.setCellphone(telephone);
		activityUsers.setMark("1");
		ActivityUsersModel.add(activityUsers);
		return SUCCESS;
	}
	public String  getAllLotteryMember()throws Exception {
        //获取所有的参与人员
        List<ActivityUser> activityUserList = new ArrayList<ActivityUser>();
        int isWin = 0;
        List<ActivityUsers> activityUsersList =  ActivityUsersModel.getListByIsWin(isWin);//获取未获奖的所有人员        
        for (ActivityUsers activityUsers : activityUsersList) {
        		ActivityUser activityUser = new ActivityUser();
        		activityUser.setId(activityUsers.getId());
        		activityUser.setUserName(activityUsers.getUserName());
        		//activityUser.setImgPath(UrlHelper.bulidWebUploadPath(activityUsers.getUserImgPath()));
        		activityUser.setImgPath(activityUsers.getUserImgPath());
        		activityUserList.add(activityUser);
		}
        Map<String,Object> activityUserMap = new HashMap<String, Object>();
        activityUserMap.put("count",activityUserList.size());
        activityUserMap.put("activityUser",activityUserList);
		return  outJson(activityUserMap);
	}
	public String getLotteryWinners()throws Exception{
		List<ActivityUsers> intrinsicUserList  = ActivityUsersModel.getIntrinsicUsersByDrawNo(id);//获取本轮抽奖内定的人员 未获奖
		int intrinsicNo = 0;
		if(intrinsicUserList!=null){
			intrinsicNo = intrinsicUserList.size();
		}
		int otherNum = num - intrinsicNo;
		int isWin = 0;
		List<ActivityUsers> otherWinerList = ActivityUsersModel.getOtherWinersByIsWin(isWin,otherNum);//获取本轮抽奖其他的未获奖人员  随机
		otherWinerList.addAll(intrinsicUserList);
		for (ActivityUsers activityUsers : otherWinerList) {
			isWin = 1;
			activityUsers.setIsWin(isWin);
			ActivityUsersModel.update(activityUsers);
			WinningRecord winningRecord = new WinningRecord();
			winningRecord.setUserId(activityUsers.getId());
			winningRecord.setDrawNo(id);
			WinningRecordModel.add(winningRecord);
		}
		Collections.shuffle(otherWinerList);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("res",1);
        map.put("winers",otherWinerList);
		return outJson(map);
	}
}
