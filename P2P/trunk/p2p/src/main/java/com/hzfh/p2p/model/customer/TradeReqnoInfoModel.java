package com.hzfh.p2p.model.customer;

import com.hzfh.api.customer.model.TradeReqnoInfo;
import com.hzfh.api.customer.model.query.TradeReqnoInfoCondition;
import com.hzfh.p2p.facade.customer.TradeReqnoInfoFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class TradeReqnoInfoModel {
    public static PagedList<TradeReqnoInfo> getPagingList(TradeReqnoInfoCondition tradeReqnoInfoCondition) {
        return TradeReqnoInfoFacade.getPagingList(tradeReqnoInfoCondition);
    }

    public static int add(TradeReqnoInfo tradeReqnoInfo) {
        return TradeReqnoInfoFacade.add(tradeReqnoInfo);
    }

    public static int update(TradeReqnoInfo tradeReqnoInfo) {
        return TradeReqnoInfoFacade.update(tradeReqnoInfo);
    }

    public static List<TradeReqnoInfo> getList() {
        return TradeReqnoInfoFacade.getList();
    }

    public static TradeReqnoInfo getInfo(int id) {
        return TradeReqnoInfoFacade.getInfo(id);
    }

	public static TradeReqnoInfo getInfoBySnAndIsOk(String requestNo, int isOk) {
		 return TradeReqnoInfoFacade.getInfoBySnAndIsOk(requestNo,isOk);
	}
}
