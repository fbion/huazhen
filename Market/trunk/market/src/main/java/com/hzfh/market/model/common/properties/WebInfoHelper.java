package com.hzfh.market.model.common.properties;

import com.hzframework.helper.PropertyHelper;

public class WebInfoHelper {
    public static final String WEB_UPLOAD =PropertyHelper.getContextProperty("web.upload").toString();
    public static final String WEB_MARKET_UPLOAD =PropertyHelper.getContextProperty("web.market.upload").toString();

    public static final String WEB_MARKET_WWW =PropertyHelper.getContextProperty("web.market.www").toString();

    public static final String WEB_MARKET_RESOURCE_JS =PropertyHelper.getContextProperty("web.market.resource.js").toString();
    public static final String WEB_MARKET_RESOURCE_CSS =PropertyHelper.getContextProperty("web.market.resource.css").toString();
    public static final String WEB_MARKET_RESOURCE_IMG =PropertyHelper.getContextProperty("web.market.resource.img").toString();

    public static final String WEB_MARKET_DEV_JS =PropertyHelper.getContextProperty("web.market.dev.js").toString();
    
    public static final String WEIXIN_APPID =PropertyHelper.getContextProperty("weixin.appid").toString();
    public static final String WEIXIN_APPSECRET =PropertyHelper.getContextProperty("weixin.appsecret").toString();
}
