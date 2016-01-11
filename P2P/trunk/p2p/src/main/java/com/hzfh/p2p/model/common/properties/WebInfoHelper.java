package com.hzfh.p2p.model.common.properties;

import com.hzframework.helper.PropertyHelper;

/**
 * Created by paul on 15-1-20.
 */
public class WebInfoHelper {
    public static final String WEB_UPLOAD =PropertyHelper.getContextProperty("web.upload").toString();
    public static final String WEB_P2P_UPLOAD =PropertyHelper.getContextProperty("web.p2p.upload").toString();

    public static final String WEB_P2P_WWW =PropertyHelper.getContextProperty("web.p2p.www").toString();

    public static final String WEB_P2P_RESOURCE_JS =PropertyHelper.getContextProperty("web.p2p.resource.js").toString();
    public static final String WEB_P2P_RESOURCE_CSS =PropertyHelper.getContextProperty("web.p2p.resource.css").toString();
    public static final String WEB_P2P_RESOURCE_IMG =PropertyHelper.getContextProperty("web.p2p.resource.img").toString();
	public static final String WEB_IMG =PropertyHelper.getContextProperty("web.img").toString();

	public static final String WEB_BACK_URL = PropertyHelper.getContextProperty("web.back.url").toString();
    public static final String WEB_P2P_DEV_JS =PropertyHelper.getContextProperty("web.p2p.dev.js").toString();
    public static final String WEB_UPLOAD_ACTION = PropertyHelper.getContextProperty("web.upload.action").toString();
}
