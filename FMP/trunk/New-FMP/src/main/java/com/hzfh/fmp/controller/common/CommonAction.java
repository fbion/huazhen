package com.hzfh.fmp.controller.common;


import com.hzfh.api.employee.model.Employee;
import com.hzfh.fmp.model.common.PageAlias;
import com.hzfh.fmp.model.common.helper.LogHelper;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.common.resource.CssContext;
import com.hzfh.fmp.model.common.resource.ScriptContext;
import com.hzfh.fmp.model.employee.EmployeeModel;
import com.hzfh.fmp.model.permission.view.PagePermissionView;
import org.apache.struts2.ServletActionContext;

import java.util.List;

/**
 * Created by paul on 14-12-24.
 */
public abstract class CommonAction extends BaseAction {
    private PageAlias pageAlias;
    private String pageHead = "";
    private PagePermissionView pagePermissionView;
    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public PagePermissionView getPagePermissionView() {
        return pagePermissionView;
    }

    public static final LogHelper logger = LogHelper.getLogger(CommonAction.class.getName());

    public void setPageAlias(PageAlias pageAlias) {
        this.pageAlias = pageAlias;
    }

    public PageAlias getPageAlias() {
        return pageAlias;
    }

    public String getPageHead() {
        return pageHead;
    }

    @Override
    public String execute() throws Exception {
        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;
        if (this.pageAlias.toString().isEmpty())
            this.pageAlias = PageAlias.index;

        if (this.pageAlias != PageAlias.login && this.pageAlias != PageAlias.error && UserHelper.getUserCache() != null) {
            try {
                this.pagePermissionView = new PagePermissionView(String.valueOf(this.getPageAlias()), UserHelper.getUserCache().getRoleId());
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (!pagePermissionView.isRead()) {
                ServletActionContext.getRequest().setAttribute("exception","出错了!");
                ServletActionContext.getRequest().setAttribute("exceptionStack","您可能没有权限");
                return ERROR;
            }

            if(UserHelper.getUserCache() != null){
                this.employee = EmployeeModel.getInfo(UserHelper.getUserCache().getEmpId());
            }
        }

        this.buildCss();
        this.buildJs();
        return SUCCESS;
    }

    private void buildJs() {
        StringBuilder stringBuilder = new StringBuilder();
        List<String> scriptList = ScriptContext.getScriptByPageAlias(this.pageAlias);
        for (String script : scriptList) {
            stringBuilder.append(script);
        }
        pageHead += stringBuilder.toString();
    }

    private void buildCss() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String css : CssContext.getCssByPageAlias(this.pageAlias)) {
            stringBuilder.append(css);
        }
        pageHead += stringBuilder.toString();
    }

}
