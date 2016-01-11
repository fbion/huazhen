package com.hzfh.weixin.model.baseInfo;

import com.hzfh.api.baseInfo.model.DicData;
import com.hzfh.api.baseInfo.model.query.DicDataCondition;
import com.hzfh.weixin.facade.baseInfo.DicDataFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class DicDataModel {
    public static PagedList<DicData> getPagingList(DicDataCondition dicDataCondition) {
        return DicDataFacade.getPagingList(dicDataCondition);
    }

    public static int add(DicData dicData) {
        return DicDataFacade.add(dicData);
    }

    public static int update(DicData dicData) {
        return DicDataFacade.update(dicData);
    }

    public static List<DicData> getList() {
        return DicDataFacade.getList();
    }

    public static DicData getInfo(int id) {
        return DicDataFacade.getInfo(id);
    }

	public static List<DicData> getDicDataListByType(int dicTypeNo) {
		return DicDataFacade.getDicDataListByType(dicTypeNo);
	}

	public static DicData getCodeByTypeNoAndName(int typeNo, String name) {
		return DicDataFacade.getCodeByTypeNoAndName(typeNo,name);
	
	}


}
