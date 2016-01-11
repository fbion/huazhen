package com.hzfh.fmp.controller;

import com.hzfh.fmp.controller.common.CommonAction;
import com.hzfh.fmp.model.common.PageAlias;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.permission.view.TagPermissionView;
import com.hzframework.helper.StringHelper;
import com.opensymphony.xwork2.ActionContext;

import java.util.Map;

/**
 * Created by paul on 15-4-10.
 */
public class ErrorPageAction extends CommonAction {
    private String exception;
    private String desc;
    private String pageVar;
    private String exceptionStack;

    @Override
    public String getExceptionStack() {
        return exceptionStack;
    }

    @Override
    public void setExceptionStack(String exceptionStack) {
        this.exceptionStack = exceptionStack;
    }

    public String getPageVar() {
        return pageVar;
    }

    public void setPageVar(String pageVar) {
        this.pageVar = pageVar;
    }

    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String getException() {
        return exception;
    }

    @Override
    public void setException(String exception) {
        this.exception = exception;
    }

    @Override
    public String execute() throws Exception {
             this.desc = this.exception;
        if(this.desc==null||this.desc==""){
            this.desc = "没有该页面";
        }
        this.setPageAlias(PageAlias.errorPage);
        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;
        initPageVar();
        return SUCCESS;
    }

    private void initPageVar() {
        StringBuilder sb = new StringBuilder();

        sb.append("<script type=\"text/javascript\">");
        sb.append("var PageVar={");
        sb.append(String.format("%1$s:'%2$s',", "UserId", UserHelper.getEditUserNo()));
        sb.append("};");

        sb.append("var ElementVar={");
        for(TagPermissionView tagPermissionView: this.getPagePermissionView().getTagPermissionViewList()){
            sb.append(String.format("%1$s:'%2$s',", tagPermissionView.getTagName(), String.valueOf(tagPermissionView.getTagPermissionType())));
        }
        sb.append("};");

        sb.append("</script>");

        this.pageVar = sb.toString();
    }
}
