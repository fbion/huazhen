package com.hzfh.fmp.model.common.properties;

import com.hzframework.helper.PropertyHelper;

/**
 * Created by paul on 15-1-20.
 */
public class WebInfoHelper {

    public static final String WEB_UPLOAD_ACTION = PropertyHelper.getContextProperty("web.upload.action").toString();
    public static final String WEB_UPLOAD = PropertyHelper.getContextProperty("web.upload").toString();
    public static final String WEB_FMP_UPLOAD = PropertyHelper.getContextProperty("web.fmp.upload").toString();

    public static final String WEB_FMP_LOGIN = PropertyHelper.getContextProperty("web.fmp.login").toString();
    public static final String WEB_FMP_PRODUCT = PropertyHelper.getContextProperty("web.fmp.product").toString();
    public static final String WEB_FMP_EMPLOYEE = PropertyHelper.getContextProperty("web.fmp.employee").toString();
    public static final String WEB_FMP_CUSTOMER = PropertyHelper.getContextProperty("web.fmp.customer").toString();
    public static final String WEB_FMP_PERMISSION = PropertyHelper.getContextProperty("web.fmp.permission").toString();
    public static final String WEB_FMP_BASE_INFO = PropertyHelper.getContextProperty("web.fmp.baseInfo").toString();
    public static final String WEB_FMP_SALES = PropertyHelper.getContextProperty("web.fmp.sales").toString();
    public static final String WEB_FMP_WORK_FLOW = PropertyHelper.getContextProperty("web.fmp.workFlow").toString();
    public static final String WEB_FMP_PAYMENT = PropertyHelper.getContextProperty("web.fmp.payment").toString();
    public static final String WEB_FMP_BACK_URL = PropertyHelper.getContextProperty("web.fmp.back.url").toString();
    public static final String WEB_NEWFMP_INDEX_URL = PropertyHelper.getContextProperty("web.newFmp.index").toString();
    public static final String WEB_FMP_MARKET = PropertyHelper.getContextProperty("web.fmp.market").toString();

    public static final String WEB_FMP_RESOURCE_JS = PropertyHelper.getContextProperty("web.fmp.resource.js").toString();
    public static final String WEB_FMP_RESOURCE_CSS = PropertyHelper.getContextProperty("web.fmp.resource.css").toString();
    public static final String WEB_FMP_RESOURCE_IMG = PropertyHelper.getContextProperty("web.fmp.resource.img").toString();

    public static final String WEB_FMP_DEV_JS = PropertyHelper.getContextProperty("web.fmp.dev.js").toString();
}
