package com.hzfh.market.controller.market.ajax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hzfh.api.market.model.DrawSetting;
import com.hzfh.market.controller.common.CrossDomainCommon;
import com.hzfh.market.model.market.DrawSettingModel;


public class AjaxDrawSettingAction extends CrossDomainCommon {
	private int currentNo;
	public void setCurrentNo(int currentNo) {
		this.currentNo = currentNo;
	}
	/*private String type;
	
	public void setType(String type) {
		this.type = type;
	}*/
	public String  getMinDrawSeting()throws Exception {
		int status = 1;//可用的
		DrawSetting drawSetting = DrawSettingModel.getMinDrawSeting(status);
		
		 Map<String,Object> map = new HashMap<String, Object>();
	        map.put("res",1);
		if(drawSetting==null){
			map.put("res",0);
			return  outJson(map);
		}
		/*if("1".equals(type)){//下一轮
			status = 2;//抽过
			drawSetting.setStatus(status);
		}*/
		
		map.put("draw",drawSetting);
		//DrawSettingModel.update(drawSetting);
		
		return  outJson(map);
	}
	public String  getEndDrawSeting()throws Exception {
		int status = 2;//可用的
		List<DrawSetting> drawSettingList = DrawSettingModel.getEndDrawSeting(status);//获取已经抽过的奖项
		Map<String,Object> map = new HashMap<String, Object>();
        map.put("awards",drawSettingList);
		return  outJson(map);
	}
	
	public String updateDrawSeting()throws Exception{
		DrawSetting drawSetting = DrawSettingModel.getInfo(currentNo);
		int status = 2;//抽过
		drawSetting.setStatus(status);
		DrawSettingModel.update(drawSetting);
		Map<String,Object> map = new HashMap<String, Object>();
        map.put("res",1);
		return  outJson(map);
	}
	public String getCurrentDrawSetingStatus()throws Exception{
		DrawSetting drawSetting = DrawSettingModel.getInfo(currentNo);
		Map<String,Object> map = new HashMap<String, Object>();
		if(drawSetting.getStatus()==2){
			map.put("res",0);
			return outJson(map);
		}
		map.put("res",1);
		return outJson(map);
	}
	/*public String  getNextDrawSeting()throws Exception {
		int status = 1;//可用的
		DrawSetting drawSetting = DrawSettingModel.getMinDrawSeting(status);//获取下一轮抽奖  有效的
		status = 2;//抽过
		drawSetting.setStatus(status);
		DrawSettingModel.update(drawSetting);
		return  outJson(drawSetting);
	}*/
	
}
