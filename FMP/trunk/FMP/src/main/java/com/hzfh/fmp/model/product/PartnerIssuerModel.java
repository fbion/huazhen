package com.hzfh.fmp.model.product;

import com.hzfh.api.product.model.PartnerIssuer;
import com.hzfh.api.product.model.query.PartnerIssuerCondition;
import com.hzfh.fmp.facade.product.PartnerIssuerFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class PartnerIssuerModel {
    public static PagedList<PartnerIssuer> getPagingList(PartnerIssuerCondition partnerIssuerCondition) {
        return PartnerIssuerFacade.getPagingList(partnerIssuerCondition);
    }

    public static int add(PartnerIssuer partnerIssuer) {
        return PartnerIssuerFacade.add(partnerIssuer);
    }

    public static int update(PartnerIssuer partnerIssuer) {
        return PartnerIssuerFacade.update(partnerIssuer);
    }

    public static List<PartnerIssuer> getList() {
        return PartnerIssuerFacade.getList();
    }

    public static PartnerIssuer getInfo(int id) {
        return PartnerIssuerFacade.getInfo(id);
    }
}
