package com.hzfh.fmp.model.sales;

import com.hzfh.api.sales.model.Creditor;
import com.hzfh.api.sales.model.query.CreditorCondition;
import com.hzfh.fmp.facade.sales.CreditorFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class CreditorModel {
    public static PagedList<Creditor> getPagingList(CreditorCondition creditorCondition) {
        return CreditorFacade.getPagingList(creditorCondition);
    }

    public static int add(Creditor creditor) {
        return CreditorFacade.add(creditor);
    }

    public static int update(Creditor creditor) {
        return CreditorFacade.update(creditor);
    }

    public static List<Creditor> getList() {
        return CreditorFacade.getList();
    }

    public static List<Creditor> getListByPrductNo(int productNo) {
        return CreditorFacade.getListByPrductNo(productNo);
    }

    public static Creditor getInfo(int id) {
        return CreditorFacade.getInfo(id);
    }

    public static int updateRemainAmountById(int id, double money) {
        return CreditorFacade.updateRemainAmountById(id, money);
    }

    public static Creditor getInfoEffectiveByProductNo(int productNo) {
        return CreditorFacade.getInfoEffectiveByProductNo(productNo);
    }

    public static double getRemainAmountByProductNo(int productNo) {
        return CreditorFacade.getRemainAmountByProductNo(productNo);
    }

}
