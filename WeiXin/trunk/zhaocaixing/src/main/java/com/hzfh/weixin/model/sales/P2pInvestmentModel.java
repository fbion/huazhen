package com.hzfh.weixin.model.sales;

import com.hzfh.api.sales.model.P2pInvestment;
import com.hzfh.api.sales.model.query.P2pInvestmentCondition;
import com.hzfh.weixin.facade.sales.P2pInvestmentFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class P2pInvestmentModel {
    public static PagedList<P2pInvestment> getPagingList(P2pInvestmentCondition p2pInvestmentCondition) {
        return P2pInvestmentFacade.getPagingList(p2pInvestmentCondition);
    }

    public static int add(P2pInvestment p2pInvestment) {
        return P2pInvestmentFacade.add(p2pInvestment);
    }

    public static int update(P2pInvestment p2pInvestment) {
        return P2pInvestmentFacade.update(p2pInvestment);
    }

    public static List<P2pInvestment> getList() {
        return P2pInvestmentFacade.getList();
    }

    public static P2pInvestment getInfo(int id) {
        return P2pInvestmentFacade.getInfo(id);
    }
}
