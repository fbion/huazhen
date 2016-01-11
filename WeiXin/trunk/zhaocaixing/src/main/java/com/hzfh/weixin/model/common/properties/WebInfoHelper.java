package com.hzfh.weixin.model.common.properties;

import com.hzframework.helper.PropertyHelper;

/**
 * Created by paul on 15-1-20.
 */
public class WebInfoHelper {
    public static final String WEB_UPLOAD =PropertyHelper.getContextProperty("web.upload").toString();
    public static final String WEB_P2P_UPLOAD =PropertyHelper.getContextProperty("web.weixin.upload").toString();

    public static final String WEB_P2P_WWW =PropertyHelper.getContextProperty("web.weixin.www").toString();

    public static final String WEB_P2P_RESOURCE_JS =PropertyHelper.getContextProperty("web.weixin.resource.js").toString();
    public static final String WEB_P2P_RESOURCE_CSS =PropertyHelper.getContextProperty("web.weixin.resource.css").toString();
    public static final String WEB_P2P_RESOURCE_IMG =PropertyHelper.getContextProperty("web.weixin.resource.img").toString();
	public static final String WEB_IMG =PropertyHelper.getContextProperty("web.img").toString();

    public static final String WEB_P2P_DEV_JS =PropertyHelper.getContextProperty("web.weixin.dev.js").toString();
    
    
    public static final String WEIXIN_APPID =PropertyHelper.getContextProperty("weixin.appid").toString();
    public static final String WEIXIN_APPSECRET =PropertyHelper.getContextProperty("weixin.appsecret").toString();
}
