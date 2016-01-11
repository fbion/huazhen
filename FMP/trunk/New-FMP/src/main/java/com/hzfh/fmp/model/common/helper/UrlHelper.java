package com.hzfh.fmp.model.common.helper;

import com.hzfh.fmp.model.common.PageAlias;
import com.hzfh.fmp.model.common.properties.WebInfoHelper;
import com.hzframework.helper.StringHelper;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by paul on 15-1-6.
 */
public class UrlHelper {
    public static String buildWWWSiteUrl(PageAlias pageAlias) {
        switch(pageAlias){
            case probationWorkSummaryAdd:
                return StringHelper.trimEnd(WebInfoHelper.WEB_FMP_EMPLOYEE, "/") + "/employee/probationWorkSummary/edit";
            case extendProbationApplicationAdd:
                return StringHelper.trimEnd(WebInfoHelper.WEB_FMP_EMPLOYEE, "/") + "/employee/extendProbationApplication/edit";
            case probationEvaluationAdd:
                return StringHelper.trimEnd(WebInfoHelper.WEB_FMP_EMPLOYEE, "/") + "/employee/probationEvaluation/edit";
            default:
                return StringHelper.trimEnd(WebInfoHelper.WEB_FMP_LOGIN, "/") + "/index";
        }
    }

    public static String buildLoginSiteUrl(PageAlias pageAlias) {
        throw new NotImplementedException();
    }

    public static String buildLoginSiteUrl(String action) {
        return StringHelper.trimEnd(WebInfoHelper.WEB_FMP_LOGIN, "/") + "/" + StringHelper.trimStart(action, "/");
    }

    public static String buildProductSiteUrl(PageAlias pageAlias) {
        throw new NotImplementedException();
    }

    public static String buildProductSiteUrl(String action) {
        return StringHelper.trimEnd(WebInfoHelper.WEB_FMP_PRODUCT, "/") + "/" + StringHelper.trimStart(action, "/");
    }

    public static String buildEmployeeSiteUrl(PageAlias pageAlias) {
        throw new NotImplementedException();
    }

    public static String buildEmployeeSiteUrl(String action) {
        return StringHelper.trimEnd(WebInfoHelper.WEB_FMP_EMPLOYEE, "/") + "/" + StringHelper.trimStart(action, "/");
    }

    public static String buildCustomerSiteUrl(PageAlias pageAlias) {
        throw new NotImplementedException();
    }

    public static String buildCustomerSiteUrl(String action) {
        return StringHelper.trimEnd(WebInfoHelper.WEB_FMP_CUSTOMER, "/") + "/" + StringHelper.trimStart(action, "/");
    }

    public static String buildPermissionSiteUrl(PageAlias pageAlias) {
        throw new NotImplementedException();
    }

    public static String buildPermissionSiteUrl(String action) {
        return StringHelper.trimEnd(WebInfoHelper.WEB_FMP_PERMISSION, "/") + "/" + StringHelper.trimStart(action, "/");
    }

    public static String buildBaseInfoSiteUrl(PageAlias pageAlias) {
        throw new NotImplementedException();
    }

    public static String buildBaseInfoSiteUrl(String action) {
        return StringHelper.trimEnd(WebInfoHelper.WEB_FMP_BASE_INFO, "/") + "/" + StringHelper.trimStart(action, "/");
    }

    public static String buildSalesSiteUrl(PageAlias pageAlias) {
        throw new NotImplementedException();
    }

    public static String buildSalesSiteUrl(String action) {
        return StringHelper.trimEnd(WebInfoHelper.WEB_FMP_SALES, "/") + "/" + StringHelper.trimStart(action, "/");
    }

    public static String buildWorkFlowSiteUrl(String action) {
        return StringHelper.trimEnd(WebInfoHelper.WEB_FMP_WORK_FLOW, "/") + "/" + StringHelper.trimStart(action, "/");
    }

    public static String buildPaymentSiteUrl(String action) {
        return StringHelper.trimEnd(WebInfoHelper.WEB_FMP_PAYMENT, "/") + "/" + StringHelper.trimStart(action, "/");
    }

    public static String buildBackUrl(String action) {
        return StringHelper.trimEnd(WebInfoHelper.WEB_FMP_BACK_URL, "/") + "/" + StringHelper.trimStart(action, "/");
    }

    public static String buildUploadSiteUrl(String action) {
        return StringHelper.trimEnd(WebInfoHelper.WEB_UPLOAD, "/") + "/" + StringHelper.trimStart(action, "/");
    }

    public static String buildNewFmpIndexSiteUrl(String action) {
        return StringHelper.trimEnd(WebInfoHelper.WEB_NEWFMP_INDEX_URL, "/") + "/" + StringHelper.trimStart(action, "/");
    }

    public static String buildJs(String js) {
        return WebInfoHelper.WEB_FMP_RESOURCE_JS + "/" + js;
    }

    public static String buildCss(String css) {
        return WebInfoHelper.WEB_FMP_RESOURCE_CSS + "/" + css;
    }

    public static String buildImg(String img) {
        return WebInfoHelper.WEB_FMP_RESOURCE_IMG + "/" + img;
    }

    public static String buildDevJs(String js) {
        return WebInfoHelper.WEB_FMP_DEV_JS + "/" + js;
    }

}
