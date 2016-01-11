package com.hzfh.fmp.model.market;

import com.hzfh.api.market.model.WinningRecord;
import com.hzfh.api.market.model.query.WinningRecordCondition;
import com.hzfh.fmp.facade.market.WinningRecordFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

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
}
