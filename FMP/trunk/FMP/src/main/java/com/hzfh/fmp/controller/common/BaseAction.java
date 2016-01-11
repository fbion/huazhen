package com.hzfh.fmp.controller.common;

import com.hzfh.fmp.model.common.PageAlias;
import com.hzfh.fmp.model.common.helper.UrlHelper;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by paul on 14-12-24.
 */
public abstract class BaseAction extends ActionSupport {
    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }

    public String buildLoginSiteUrl(String action) {
        return UrlHelper.buildLoginSiteUrl(action);
    }

    public String buildProductSiteUrl(String action) {
        return UrlHelper.buildProductSiteUrl(action);
    }

    public String buildEmployeeSiteUrl(String action) {
        return UrlHelper.buildEmployeeSiteUrl(action);
    }

    public String buildCustomerSiteUrl(String action) {
        return UrlHelper.buildCustomerSiteUrl(action);
    }

    public String buildPermissionSiteUrl(String action) {
        return UrlHelper.buildPermissionSiteUrl(action);
    }

    public String buildBaseInfoSiteUrl(String action) {
        return UrlHelper.buildBaseInfoSiteUrl(action);
    }

    public String buildSalesSiteUrl(String action) {
        return UrlHelper.buildSalesSiteUrl(action);
    }

    public String buildWorkFlowSiteUrl(String action) {
        return UrlHelper.buildWorkFlowSiteUrl(action);
    }

    public String buildPaymentSiteUrl(String action) {
        return UrlHelper.buildPaymentSiteUrl(action);
    }

    public String buildJs(String js) {
        return UrlHelper.buildJs(js);
    }

    public String buildCss(String css) {
        return UrlHelper.buildCss(css);
    }

    public String buildImg(String img) {
        return UrlHelper.buildImg(img);
    }

    public String buildDevJs(String js) {
        return UrlHelper.buildDevJs(js);
    }

    private String exception;
    private String exceptionStack;

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public String getExceptionStack() {
        return exceptionStack;
    }

    public void setExceptionStack(String exceptionStack) {
        this.exceptionStack = exceptionStack;
    }
    public String buildWWWSiteUrl(PageAlias pageAlias){
        return UrlHelper.buildWWWSiteUrl(pageAlias);
    }

}
