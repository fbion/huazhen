package com.hzfh.service.workFlow.serviceTask.sales;

import org.activiti.engine.impl.el.Expression;

/**
 * Created by ulei0 on 2015/10/8.
 */
public class SalesAudit {
    private Expression userId;
    private Expression salesId;
    private Expression url;

    public Expression getUserId() {
        return userId;
    }

    public void setUserId(Expression userId) {
        this.userId = userId;
    }

    public Expression getSalesId() {
        return salesId;
    }

    public void setSalesId(Expression salesId) {
        this.salesId = salesId;
    }

    public Expression getUrl() {
        return url;
    }

    public void setUrl(Expression url) {
        this.url = url;
    }
}
