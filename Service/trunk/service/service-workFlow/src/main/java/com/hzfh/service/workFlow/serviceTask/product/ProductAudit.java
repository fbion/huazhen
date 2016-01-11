package com.hzfh.service.workFlow.serviceTask.product;

import org.activiti.engine.impl.el.Expression;

/**
 * Created by ulei0 on 2015/10/8.
 */
public class ProductAudit {
    private Expression productId;
    private Expression status;

    public Expression getProductId() {
        return productId;
    }

    public void setProductId(Expression productId) {
        this.productId = productId;
    }

    public Expression getStatus() {
        return status;
    }

    public void setStatus(Expression status) {
        this.status = status;
    }
}
