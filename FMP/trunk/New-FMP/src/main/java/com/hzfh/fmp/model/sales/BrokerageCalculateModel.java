package com.hzfh.fmp.model.sales;

import com.hzfh.api.sales.model.BrokerageCalculate;
import com.hzfh.api.sales.model.query.BrokerageCalculateCondition;
import com.hzfh.fmp.facade.sales.BrokerageCalculateFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class BrokerageCalculateModel {
    public static PagedList<BrokerageCalculate> getPagingList(BrokerageCalculateCondition brokerageCalculateCondition) {
        return BrokerageCalculateFacade.getPagingList(brokerageCalculateCondition);
    }

    public static int add(BrokerageCalculate brokerageCalculate) {
        return BrokerageCalculateFacade.add(brokerageCalculate);
    }

    public static int update(BrokerageCalculate brokerageCalculate) {
        return BrokerageCalculateFacade.update(brokerageCalculate);
    }

    public static List<BrokerageCalculate> getList() {
        return BrokerageCalculateFacade.getList();
    }

    public static BrokerageCalculate getInfo(int id) {
        return BrokerageCalculateFacade.getInfo(id);
    }
}
