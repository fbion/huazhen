package com.hzfh.service.payment.serviceImpl.Helper;

import com.hzframework.helper.PropertyHelper;

/**
 * Created by paul on 15-1-20.
 */
public class WebInfoHelper {

    public static final String PAYMENT_URL_GATEWAY = PropertyHelper.getContextProperty("payment.url.gateway").toString();
    public static final String PAYMENT_URL_CONNECTION = PropertyHelper.getContextProperty("payment.url.connection").toString();
}
