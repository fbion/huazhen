package com.hzfh.weixin.model.baseInfo;

import com.hzfh.api.baseInfo.model.Captcha;
import com.hzfh.api.baseInfo.model.query.CaptchaCondition;
import com.hzfh.weixin.facade.baseInfo.CaptchaFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class CaptchaModel {
    public static PagedList<Captcha> getPagingList(CaptchaCondition captchaCondition) {
        return CaptchaFacade.getPagingList(captchaCondition);
    }

    public static int add(Captcha captcha) {
        return CaptchaFacade.add(captcha);
    }

    public static int update(Captcha captcha) {
        return CaptchaFacade.update(captcha);
    }

    public static List<Captcha> getList() {
        return CaptchaFacade.getList();
    }

    public static Captcha getInfo(int id) {
        return CaptchaFacade.getInfo(id);
    }
    public static Captcha selectByIdAndCode(int id,String code){
    	return CaptchaFacade.selectByIdAndCode(id,code);
    }

    public static int delete(int id){
        return CaptchaFacade.delete(id);
    }
}
