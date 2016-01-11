package com.hzfh.weixin.controller.common;


import com.hzfh.weixin.model.common.PageAlias;
import com.hzfh.weixin.model.common.helper.UrlHelper;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

/**
 * Created by paul on 14-12-24.
 */
public abstract class BaseAction extends ActionSupport {
    private String ip;

    public String getIp() {
        return ip;
    }

    @Override
    public String execute() {
        ip = ServletActionContext.getRequest().getRemoteAddr();
        return SUCCESS;
    }

    public String buildWWWSiteUrl(PageAlias pageAlias){
        return UrlHelper.buildWWWSiteUrl(pageAlias);
    }

    public String buildJs(String js){
        return UrlHelper.buildJs(js);
    }

    public String buildCss(String css){
        return UrlHelper.buildCss(css);
    }

    public String buildImg(String img){
        return UrlHelper.buildImg(img);
    }

    public String buildDevJs(String js){
        return UrlHelper.buildDevJs(js);
    }
}
