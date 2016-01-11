package com.hzfh.fmp.model.common.properties;

import com.hzframework.helper.PropertyHelper;

/**
 * Created by paul on 15-1-18.
 */
public class AuditHelper {
    //产品运营
    public static final int AUDIT_PRODUCT_OPERATOR = Integer.parseInt(PropertyHelper.getContextProperty("audit.product.operator").toString());


    //产品总监职位
    public static final int AUDIT_PRODUCTDIRECTOR_POSITION = Integer.parseInt(PropertyHelper.getContextProperty("audit.productDirector.position").toString());


}
