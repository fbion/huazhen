package com.hzfh.p2p.model.common;

import com.hzfh.p2p.model.common.cache.CacheManager;
import com.hzfh.p2p.model.common.cache.CachePrefix;
import com.hzfh.p2p.model.common.helper.EncodeHelper;
import com.hzfh.p2p.model.common.state.StateValues;
import com.hzfh.p2p.model.common.view.LoginInfo;

/**
 * Created by paul on 15-3-16.
 */
public class AuthenticationModel {
    public static boolean isLogin() {
        return getCustomerId() > 0;
    }

    public static int getCustomerId() {
        if (StateValues.getCustomerId() == 0)
            return 0;

        String loginKey = EncodeHelper.encryptPWD(String.valueOf(StateValues.getCustomerId()), getUserName(), StateValues.getLoginTime());
        if (!loginKey.equals(StateValues.getLoginKey()))
            return 0;

        LoginInfo loginInfo = getLoginInfo();
        if (loginInfo == null)
            return 0;

        if (loginInfo.getP2pCustomerId() != StateValues.getCustomerId())
            return 0;

        return loginInfo.getP2pCustomerId();
    }

    public static String getUserName() {
        return StateValues.getUserName();
    }

    public static LoginInfo getLoginInfo() {
        String loginKey = StateValues.getLoginKey();

        Object obj = CacheManager.get(CachePrefix.LOGIN_INFO_PREFIX, loginKey);

        if (obj == null)
            return null;
        LoginInfo loginInfo = (LoginInfo) obj;

        return loginInfo;
    }
}
