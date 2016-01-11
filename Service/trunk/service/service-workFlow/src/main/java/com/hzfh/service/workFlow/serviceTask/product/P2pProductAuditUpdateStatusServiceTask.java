package com.hzfh.service.workFlow.serviceTask.product;

import com.hzfh.api.product.model.P2pProduct;
import com.hzfh.service.workFlow.model.baseInfo.LetterModel;
import com.hzfh.service.workFlow.model.product.P2pProductModel;
import com.hzfh.service.workFlow.model.product.ProductModel;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

import java.text.SimpleDateFormat;

/**
 * Created by 磊 on 2015/10/22.
 */
public class P2pProductAuditUpdateStatusServiceTask extends P2pProductAudit implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        int p2pProductId = (int) this.getP2pProductId().getValue(execution);
        byte status = Byte.parseByte(this.getStatus().getValue(execution).toString());
        P2pProductModel.updateStatusById(p2pProductId,status);
        P2pProduct p2pProduct = P2pProductModel.getInfo(p2pProductId);
        ProductModel.updateStatus(p2pProduct.getProductNo(),status);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String content = p2pProduct.getName()+"于"+sdf.format(p2pProduct.getStart())+"成立，成立金额："+p2pProduct.getTotalAmout()+"存续期："+p2pProduct.getDuration()+"天";
        LetterModel.addNotice("新产品成立通知", content);
    }
}
