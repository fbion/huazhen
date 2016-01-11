package com.hzfh.o2o.model.common.properties;

import com.hzframework.helper.PropertyHelper;

/**
 * Created by paul on 15-1-20.
 */
public class WebInfoHelper {

    public static final String WEB_O2O = PropertyHelper.getContextProperty("web.o2o").toString();
    public static final String WEB_O2O_PRODUCT = PropertyHelper.getContextProperty("web.o2o.product").toString();
    public static final String WEB_O2O_CUSTOMER = PropertyHelper.getContextProperty("web.o2o.customer").toString();
    public static final String WEB_O2O_SYSTEM = PropertyHelper.getContextProperty("web.o2o.system").toString();
    public static final String WEB_O2O_ORDER = PropertyHelper.getContextProperty("web.o2o.order").toString();
    public static final String WEB_O2O_PAYMENT = PropertyHelper.getContextProperty("web.o2o.payment").toString();

    public static final String WEB_O2O_RESOURCE_JS = PropertyHelper.getContextProperty("web.o2o.resource.js").toString();
    public static final String WEB_O2O_RESOURCE_CSS = PropertyHelper.getContextProperty("web.o2o.resource.css").toString();
    public static final String WEB_O2O_RESOURCE_IMG = PropertyHelper.getContextProperty("web.o2o.resource.img").toString();
    public static final String WEB_O2O_DEV_JS = PropertyHelper.getContextProperty("web.o2o.dev.js").toString();

    public static final String WEB_UPLOAD_ACTION = PropertyHelper.getContextProperty("web.upload.action").toString();
    public static final String WEB_UPLOAD = PropertyHelper.getContextProperty("web.upload").toString();
    public static final String WEB_O2O_UPLOAD = PropertyHelper.getContextProperty("web.o2o.upload").toString();
}
