package com.hzframework.web.cookie.config;

import com.hzframework.web.xml.XmlHelper;

/**
 * Created by paul on 15-4-17.
 */
public class CookieConfigHelper {
    public static CookieConfig getCookieConfig(){return XmlHelper.getConfig(CookieConfig.class);}
}
