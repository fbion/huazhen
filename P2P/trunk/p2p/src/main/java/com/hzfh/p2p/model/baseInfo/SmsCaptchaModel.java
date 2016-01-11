package com.hzfh.p2p.model.baseInfo;

import java.util.List;

import com.hzfh.api.baseInfo.model.SmsCaptcha;
import com.hzfh.api.baseInfo.model.query.SmsCaptchaCondition;
import com.hzfh.p2p.facade.baseInfo.SmsCaptchaFacade;
import com.hzframework.contract.PagedList;

public class SmsCaptchaModel {
    public static PagedList<SmsCaptcha> getPagingList(SmsCaptchaCondition smsCaptchaCondition) {
        return SmsCaptchaFacade.getPagingList(smsCaptchaCondition);
    }

    public static int add(SmsCaptcha smsCaptcha) {
        return SmsCaptchaFacade.add(smsCaptcha);
    }

    public static int update(SmsCaptcha smsCaptcha) {
        return SmsCaptchaFacade.update(smsCaptcha);
    }

    public static List<SmsCaptcha> getList() {
        return SmsCaptchaFacade.getList();
    }

    public static SmsCaptcha getInfo(int id) {
        return SmsCaptchaFacade.getInfo(id);
    }
}
