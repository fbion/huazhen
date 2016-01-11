package com.hzfh.o2o.model.common.helper;

import com.hzfh.o2o.model.PageAlias;
import com.hzfh.o2o.model.common.properties.WebInfoHelper;
import com.hzframework.helper.StringHelper;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by paul on 15-1-6.
 */
public class UrlHelper {
    public static String buildWWWSiteUrl(PageAlias pageAlias) {
        switch (pageAlias) {
            case index:
                return StringHelper.trimEnd("", "/") + "/index";
            default:
                return StringHelper.trimEnd("", "/") + "/url";
        }
    }

    public static String buildIndexSiteUrl(String action){
        return StringHelper.trimEnd(WebInfoHelper.WEB_O2O, "/") + "/" + StringHelper.trimStart(action, "/");
    }

    public static String buildProductSiteUrl(String action) {
        return StringHelper.trimEnd(WebInfoHelper.WEB_O2O_PRODUCT, "/") + "/" + StringHelper.trimStart(action, "/");
    }

    public static String buildCustomerSiteUrl(String action) {
        return StringHelper.trimEnd(WebInfoHelper.WEB_O2O_CUSTOMER, "/") + "/" + StringHelper.trimStart(action, "/");
    }

    public static String buildSystemSiteUrl(String action){
        return StringHelper.trimEnd(WebInfoHelper.WEB_O2O_SYSTEM, "/") + "/" + StringHelper.trimStart(action, "/");
    }

    public static String buildOrderSiteUrl(String action){
        return StringHelper.trimEnd(WebInfoHelper.WEB_O2O_ORDER, "/") + "/" + StringHelper.trimStart(action, "/");
    }

    public static String buildPaymentSiteUrl(String action){
        return StringHelper.trimEnd(WebInfoHelper.WEB_O2O_PAYMENT, "/") + "/" + StringHelper.trimStart(action, "/");
    }

    public static String buildJs(String js) {
        return WebInfoHelper.WEB_O2O_RESOURCE_JS + "/" + js;
    }

    public static String buildCss(String css) {
        return WebInfoHelper.WEB_O2O_RESOURCE_CSS + "/" + css;
    }

    public static String buildImg(String img) {
        return WebInfoHelper.WEB_O2O_RESOURCE_IMG + "/" + img;
    }

    public static String buildDevJs(String js) {
        return WebInfoHelper.WEB_O2O_DEV_JS + "/" + js;
    }

    public static String buildUploadSiteUrl(String action) {
        return StringHelper.trimEnd(WebInfoHelper.WEB_UPLOAD, "/") + "/" + StringHelper.trimStart(action, "/");
    }

}
