package com.hzfh.o2o.controller.common;

import com.hzfh.o2o.model.PageAlias;
import com.hzfh.o2o.model.common.helper.UrlHelper;
import com.hzfh.o2o.model.common.properties.WebInfoHelper;
import com.hzfh.o2o.model.common.resource.CssContext;
import com.hzfh.o2o.model.common.resource.ScriptContext;
import com.hzframework.helper.StringHelper;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

/**
 * Created by ulei0 on 2015/9/23.
 */
public abstract class BaseAction extends ActionSupport {
    private String exception;
    private String exceptionStack;
    private PageAlias pageAlias;
    private String pageHead;

    public String getPageHead() {
        return pageHead;
    }

    public void setPageAlias(PageAlias pageAlias) {
        this.pageAlias = pageAlias;
    }

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

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }

    protected String buildWWWSiteUrl(PageAlias pageAlias) {
        return UrlHelper.buildWWWSiteUrl(pageAlias);
    }

    protected String buildIndexSiteUrl(String action) {
        return UrlHelper.buildIndexSiteUrl(action);
    }

    protected static String buildProductSiteUrl(String action) {
        return UrlHelper.buildProductSiteUrl(action);
    }

    protected static String buildCustomerSiteUrl(String action) {
        return UrlHelper.buildCustomerSiteUrl(action);
    }

    protected static String buildSystemSiteUrl(String action) {
        return UrlHelper.buildSystemSiteUrl(action);
    }

    protected static String buildOrderSiteUrl(String action) {
        return UrlHelper.buildOrderSiteUrl(action);
    }

    protected static String buildPaymentSiteUrl(String action) {
        return UrlHelper.buildPaymentSiteUrl(action);
    }

    protected static String buildJs(String js) {
        return UrlHelper.buildJs(js);
    }

    protected static String buildCss(String css) {
        return UrlHelper.buildCss(css);
    }

    protected static String buildImg(String img) {
        return UrlHelper.buildImg(img);
    }

    protected static String buildDevJs(String js) {
        return UrlHelper.buildDevJs(js);
    }

    protected void buildJs() {
        StringBuffer stringBuffer = new StringBuffer();
        List<String> scriptList = ScriptContext.getScriptByPageAlias(this.pageAlias);
        for (String script : scriptList) {
            stringBuffer.append(script);
        }
        pageHead += stringBuffer.toString();
    }

    protected void buildCss() {
        StringBuffer stringBuffer = new StringBuffer();
        List<String> cssList = CssContext.getCssByPageAlias(this.pageAlias);
        for (String css : cssList) {
            stringBuffer.append(css);
        }
        pageHead += stringBuffer.toString();
    }

}
