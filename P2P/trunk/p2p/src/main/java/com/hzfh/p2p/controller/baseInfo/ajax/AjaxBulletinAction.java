package com.hzfh.p2p.controller.baseInfo.ajax;

import java.util.List;

import com.hzfh.api.baseInfo.model.Announcement;
import com.hzfh.api.baseInfo.model.DicData;
import com.hzfh.p2p.controller.common.CommonAction;
import com.hzfh.p2p.model.baseInfo.AnnouncementModel;
import com.hzfh.p2p.model.baseInfo.DicDataModel;
import com.hzfh.p2p.model.common.PageAlias;
import com.hzfh.p2p.model.common.parameter.StatusType;
import com.hzframework.helper.StringHelper;

public class AjaxBulletinAction extends CommonAction {

	private Announcement info;
	public Announcement getInfo() {
        return info;
    }
	private String id;
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getInfoById() {
        this.info = AnnouncementModel.getInfo(Integer.parseInt(this.getId()));
        if(info==null){
        	return SUCCESS;
        }
        List<DicData> dicList = DicDataModel.getDicDataListByType(StatusType.BULLETINSTATE);
        for(DicData d:dicList){
        	if(d.getCode()==info.getType()){
        		info.setTypeValue(d.getValue());
        		break;
        	}
        }
        return SUCCESS;
    }
}
