package com.hzfh.fmp.model.common.properties;

import com.hzframework.helper.PropertyHelper;

/**
 * Created by paul on 15-1-16.
 */
public class ParamHelper {
    public static final int PRODUCT_TYPE_TRUST_QUOTA =Integer.parseInt(PropertyHelper.getContextProperty("product.type.trust.quota").toString());
    public static final int PRODUCT_TYPE_ASSETS_CONTROL_QUOTA =Integer.parseInt(PropertyHelper.getContextProperty("product.type.assetsControl.quota").toString());
    public static final int PRODUCT_TYPE_CONTRACTUAL_QUOTA =Integer.parseInt(PropertyHelper.getContextProperty("product.type.Contractual.quota").toString());
    public static final int PRODUCT_TYPE_PARTNER_QUATA=Integer.parseInt(PropertyHelper.getContextProperty("product.type.Partner.quota").toString());
    public static final int PRODUCT_TYPE_OTHER_QUATA=Integer.parseInt(PropertyHelper.getContextProperty("product.type.other.quota").toString());

    public static final String LEGAL_FILE_TYPE=PropertyHelper.getContextProperty("legal.file.type").toString();
    
    //发工资日期
    public static final int INDEX_PAYMENT_DAY=Integer.parseInt(PropertyHelper.getContextProperty("index.payment.day").toString());
}
