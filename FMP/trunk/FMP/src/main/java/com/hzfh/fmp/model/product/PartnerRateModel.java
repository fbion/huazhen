package com.hzfh.fmp.model.product;

import com.hzfh.api.product.model.PartnerRate;
import com.hzfh.api.product.model.query.PartnerRateCondition;
import com.hzfh.fmp.facade.product.PartnerRateFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class PartnerRateModel {
    public static PagedList<PartnerRate> getPagingList(PartnerRateCondition partnerRateCondition) {
        return PartnerRateFacade.getPagingList(partnerRateCondition);
    }

    public static int add(PartnerRate partnerRate) {
        return PartnerRateFacade.add(partnerRate);
    }

    public static int update(PartnerRate partnerRate) {
        return PartnerRateFacade.update(partnerRate);
    }

    public static List<PartnerRate> getList() {
        return PartnerRateFacade.getList();
    }

    public static PartnerRate getInfo(int id) {
        return PartnerRateFacade.getInfo(id);
    }

	public static PartnerRate getPartnerRate(int productNo, Long money) {
		return PartnerRateFacade.getPartnerRate(productNo, money);
	}

	public static List<PartnerRate> getListByProductNo(int productNo) {
		return PartnerRateFacade.getListByProductNo(productNo);
	}
    public static int delete(int id) {
        return PartnerRateFacade.delete(id);
    }
}
