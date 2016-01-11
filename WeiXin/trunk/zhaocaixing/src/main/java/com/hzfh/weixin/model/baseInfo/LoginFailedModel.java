package com.hzfh.weixin.model.baseInfo;

import com.hzfh.api.baseInfo.model.LoginFailed;
import com.hzfh.api.baseInfo.model.query.LoginFailedCondition;
import com.hzfh.weixin.facade.baseInfo.LoginFailedFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class LoginFailedModel {
    public static PagedList<LoginFailed> getPagingList(LoginFailedCondition loginFailedCondition) {
        return LoginFailedFacade.getPagingList(loginFailedCondition);
    }

    public static int add(LoginFailed loginFailed) {
        return LoginFailedFacade.add(loginFailed);
    }

    public static int update(LoginFailed loginFailed) {
        return LoginFailedFacade.update(loginFailed);
    }

    public static List<LoginFailed> getList() {
        return LoginFailedFacade.getList();
    }

    public static LoginFailed getInfo(int id) {
        return LoginFailedFacade.getInfo(id);
    }
}
