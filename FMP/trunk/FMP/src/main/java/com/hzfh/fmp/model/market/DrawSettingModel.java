package com.hzfh.fmp.model.market;

import com.hzfh.api.market.model.DrawSetting;
import com.hzfh.api.market.model.query.DrawSettingCondition;
import com.hzfh.fmp.facade.market.DrawSettingFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

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

	public static List<DrawSetting> getInfoListByStatus(int drawStatus) {
		return DrawSettingFacade.getInfoListByStatus(drawStatus);
	}
}
