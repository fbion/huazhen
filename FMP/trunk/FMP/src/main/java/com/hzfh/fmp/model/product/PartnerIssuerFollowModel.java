package com.hzfh.fmp.model.product;

import com.hzfh.api.product.model.PartnerIssuerFollow;
import com.hzfh.api.product.model.query.PartnerIssuerFollowCondition;
import com.hzfh.fmp.facade.product.PartnerIssuerFollowFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class PartnerIssuerFollowModel {
    public static PagedList<PartnerIssuerFollow> getPagingList(PartnerIssuerFollowCondition partnerIssuerFollowCondition) {
        return PartnerIssuerFollowFacade.getPagingList(partnerIssuerFollowCondition);
    }

    public static int add(PartnerIssuerFollow partnerIssuerFollow) {
        return PartnerIssuerFollowFacade.add(partnerIssuerFollow);
    }

    public static int update(PartnerIssuerFollow partnerIssuerFollow) {
        return PartnerIssuerFollowFacade.update(partnerIssuerFollow);
    }

    public static List<PartnerIssuerFollow> getList() {
        return PartnerIssuerFollowFacade.getList();
    }

    public static PartnerIssuerFollow getInfo(int id) {
        return PartnerIssuerFollowFacade.getInfo(id);
    }
}
