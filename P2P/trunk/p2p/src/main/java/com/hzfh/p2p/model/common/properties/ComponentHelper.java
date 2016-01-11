package com.hzfh.p2p.model.common.properties;

import com.hzframework.helper.PropertyHelper;

/**
 * Created by paul on 15-3-12.
 */
public class ComponentHelper {
    public static final int SHOW_INVESTBTN = Integer.parseInt(PropertyHelper.getContextProperty("show_investBtn").toString());
    public static final int SHOW_RESERVATBTN = Integer.parseInt(PropertyHelper.getContextProperty("show_reservatBtn").toString());
}
