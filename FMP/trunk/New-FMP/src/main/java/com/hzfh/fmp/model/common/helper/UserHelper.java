package com.hzfh.fmp.model.common.helper;

import com.hzfh.fmp.model.UserCache;
import com.hzfh.fmp.model.common.cache.CacheManager;
import com.hzfh.fmp.model.common.cache.CachePrefix;
import com.hzfh.fmp.model.common.state.StateValues;

public class UserHelper {
	public static UserCache getUserCache(){
		String cacheKey=EncodeHelper.encryptPWD(String.valueOf(StateValues.getUserId()), StateValues.getLastLogin());
		return (UserCache) CacheManager.get(CachePrefix.LOGIN_INFO_PREFIX, cacheKey);
	}
/*	public static UserCache getUserCache(){
		String cacheKey=EncodeHelper.encryptPWD(String.valueOf(StateValues.getUserId()), StateValues.getLastLogin());
		return (UserCache) CacheManager.get(CachePrefix.LOGIN_INFO_PREFIX, cacheKey);
	}
*/	public static int getEditUserNo(){
		return getUserCache().getUserId();
	}
	
	
}
