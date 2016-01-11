package com.hzfh.fmp.model.product;

import com.hzfh.api.product.model.DecisionLog;
import com.hzfh.api.product.model.query.DecisionLogCondition;
import com.hzfh.fmp.facade.product.DecisionLogFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class DecisionLogModel {
    public static PagedList<DecisionLog> getPagingList(DecisionLogCondition decisionLogCondition) {
        return DecisionLogFacade.getPagingList(decisionLogCondition);
    }

    public static int add(DecisionLog decisionLog) {
        return DecisionLogFacade.add(decisionLog);
    }

    public static int update(DecisionLog decisionLog) {
        return DecisionLogFacade.update(decisionLog);
    }

    public static List<DecisionLog> getList() {
        return DecisionLogFacade.getList();
    }

    public static DecisionLog getInfo(int id) {
        return DecisionLogFacade.getInfo(id);
    }
}
