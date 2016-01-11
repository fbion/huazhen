package com.hzfh.service.workFlow.serviceTask.product;

import org.activiti.engine.impl.el.Expression;

/**
 * Created by ulei0 on 2015/10/8.
 */
public class P2pProductAudit {
    private Expression p2pProductId;
    private Expression status;

    public Expression getStatus() {
        return status;
    }

    public void setStatus(Expression status) {
        this.status = status;
    }

    public Expression getP2pProductId() {
        return p2pProductId;
    }

    public void setP2pProductId(Expression p2pProductId) {
        this.p2pProductId = p2pProductId;
    }

}
