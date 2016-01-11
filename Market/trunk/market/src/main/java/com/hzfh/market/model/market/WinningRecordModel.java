package com.hzfh.market.model.market;

import java.util.List;

import com.hzfh.api.market.model.WinningRecord;
import com.hzfh.api.market.model.query.WinningRecordCondition;
import com.hzfh.market.facade.market.WinningRecordFacade;
import com.hzframework.contract.PagedList;

public class WinningRecordModel {
    public static PagedList<WinningRecord> getPagingList(WinningRecordCondition winningRecordCondition) {
        return WinningRecordFacade.getPagingList(winningRecordCondition);
    }

    public static int add(WinningRecord winningRecord) {
        return WinningRecordFacade.add(winningRecord);
    }

    public static int update(WinningRecord winningRecord) {
        return WinningRecordFacade.update(winningRecord);
    }

    public static List<WinningRecord> getList() {
        return WinningRecordFacade.getList();
    }

    public static WinningRecord getInfo(int id) {
        return WinningRecordFacade.getInfo(id);
    }

	public static List<WinningRecord> getAllWinersByDrawNo(int drawNo) {
		return WinningRecordFacade.getAllWinersByDrawNo(drawNo);
	}
}
