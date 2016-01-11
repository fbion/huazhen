package com.hzfh.mobile.model.common.properties;

import com.hzframework.helper.PropertyHelper;

/**
 * Created by paul on 15-1-20.
 */
public class WebInfoHelper {
    public static final String WEB_UPLOAD =PropertyHelper.getContextProperty("web.upload").toString();
    public static final String WEB_MOBILE_UPLOAD =PropertyHelper.getContextProperty("web.mobile.upload").toString();

    public static final String WEB_MOBILE_WWW =PropertyHelper.getContextProperty("web.mobile.www").toString();

    public static final String WEB_MOBILE_RESOURCE_JS =PropertyHelper.getContextProperty("web.mobile.resource.js").toString();
    public static final String WEB_MOBILE_RESOURCE_CSS =PropertyHelper.getContextProperty("web.mobile.resource.css").toString();
    public static final String WEB_MOBILE_RESOURCE_IMG =PropertyHelper.getContextProperty("web.mobile.resource.img").toString();

    public static final String WEB_MOBILE_DEV_JS =PropertyHelper.getContextProperty("web.mobile.dev.js").toString();
}
