package com.hzfh.market.model.market;

import java.util.List;

import com.hzfh.api.market.model.DrawSetting;
import com.hzfh.api.market.model.query.DrawSettingCondition;
import com.hzfh.market.facade.market.DrawSettingFacade;
import com.hzframework.contract.PagedList;

public class DrawSettingModel {
    public static PagedList<DrawSetting> getPagingList(DrawSettingCondition drawSettingCondition) {
        return DrawSettingFacade.getPagingList(drawSettingCondition);
    }

    public static int add(DrawSetting drawSetting) {
        return DrawSettingFacade.add(drawSetting);
    }

    public static int update(DrawSetting drawSetting) {
        return DrawSettingFacade.update(drawSetting);
    }

    public static List<DrawSetting> getList() {
        return DrawSettingFacade.getList();
    }

    public static DrawSetting getInfo(int id) {
        return DrawSettingFacade.getInfo(id);
    }

	public static DrawSetting getMinDrawSeting(int status) {
		return DrawSettingFacade.getMinDrawSeting(status);
	}

	public static List<DrawSetting> getEndDrawSeting(int status) {
		return DrawSettingFacade.getEndDrawSeting(status);
	}

	/*public static DrawSetting getNextDrawSettingByCurrentNo(int currentNo,int status) {
		return DrawSettingFacade.getNextDrawSettingByCurrentNo(currentNo,status);
	}*/
}
