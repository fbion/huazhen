package com.hzfh.service.workFlow.serviceTask.product;

import com.hzfh.service.workFlow.model.product.ProductModel;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

/**
 * Created by 磊 on 2015/10/22.
 */
public class ProductAuditUpdateStatusServiceTask extends ProductAudit implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        int productId = (int) this.getProductId().getValue(execution);
        byte status = Byte.parseByte(this.getStatus().getValue(execution).toString());
        ProductModel.updateStatus(productId,status);
    }
}
