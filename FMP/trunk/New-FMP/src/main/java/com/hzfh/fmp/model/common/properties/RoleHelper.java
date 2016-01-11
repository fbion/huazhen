package com.hzfh.fmp.model.common.properties;

import com.hzframework.helper.PropertyHelper;

/**
 * Created by paul on 15-1-18.
 */
public class RoleHelper {
	//直销顾问
    public static final int ROLE_SALES_DIRECT =Integer.parseInt(PropertyHelper.getContextProperty("role.sales.direct").toString());
    //直销总监
    public static final int ROLE_SALES_DIRECT_DIRECTOR =Integer.parseInt(PropertyHelper.getContextProperty("role.sales.direct.director").toString());
    //渠道顾问
    public static final int ROLE_SALES_CHANNEL=Integer.parseInt(PropertyHelper.getContextProperty("role.sales.channel").toString());
    //渠道总监
    public static final int ROLE_SALES_CHANNEL_DIRECTOR=Integer.parseInt(PropertyHelper.getContextProperty("role.sales.channel.director").toString());
    //财富管理中心总监
    public static final int ROLE_SALES_FORTUNE = Integer.parseInt(PropertyHelper.getContextProperty("role.sales.fortune").toString());
    //产品经理
    public static final int ROLE_PRODUCT =Integer.parseInt(PropertyHelper.getContextProperty("role.product").toString());
    //产品总监
    public static final int ROLE_PRODUCT_DIRECTOR =Integer.parseInt(PropertyHelper.getContextProperty("role.product.director").toString());
    //运营
    public static final int ROLE_OPERATOR =Integer.parseInt(PropertyHelper.getContextProperty("role.operator").toString());
    //总裁
    public static final int ROLE_PRESIDENT = Integer.parseInt(PropertyHelper.getContextProperty("role.president").toString());
    //副总
    public static final int ROLE_VP=Integer.parseInt(PropertyHelper.getContextProperty("role.vp").toString());
    //风控
    public static final int ROLE_RISKCONTROL=Integer.parseInt(PropertyHelper.getContextProperty("role.RiskControl").toString());
    //门店经理
    public static final int ROLE_STORE = Integer.parseInt(PropertyHelper.getContextProperty("role.store").toString());
    //门店店长
    public static final int ROLR_STORE_MANAGER = Integer.parseInt(PropertyHelper.getContextProperty("role.store.manager").toString());
    //客服经理
    public static final int ROLE_CS_MANAGER = Integer.parseInt(PropertyHelper.getContextProperty("role.customerservice.manager").toString());
}
