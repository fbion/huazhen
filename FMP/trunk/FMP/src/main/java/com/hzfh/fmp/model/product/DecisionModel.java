package com.hzfh.fmp.model.product;

import com.hzfh.api.product.model.Decision;
import com.hzfh.api.product.model.query.DecisionCondition;
import com.hzfh.fmp.facade.product.DecisionFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class DecisionModel {
    public static PagedList<Decision> getPagingList(DecisionCondition decisionCondition) {
        return DecisionFacade.getPagingList(decisionCondition);
    }

    public static int add(Decision decision) {
        return DecisionFacade.add(decision);
    }

    public static int update(Decision decision) {
        return DecisionFacade.update(decision);
    }

    public static List<Decision> getList() {
        return DecisionFacade.getList();
    }

    public static Decision getInfo(int id) {
        return DecisionFacade.getInfo(id);
    }

    public static List<Decision> getListByProductNo(int productNo){
        return DecisionFacade.getListByProductNo(productNo);
    }
}
