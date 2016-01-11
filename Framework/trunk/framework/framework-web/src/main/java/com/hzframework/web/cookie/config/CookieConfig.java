package com.hzframework.web.cookie.config;

import com.hzframework.annotation.XmlPath;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.Map;

/**
 * Created by paul on 15-4-15.
 */

@XmlPath("config/Cookie.xml")
@XStreamAlias("cookieConfig")
public class CookieConfig {
    public Map<String, Cookie> getCookie() {
        return cookie;
    }

    public void setCookie(Map<String, Cookie> cookie) {
        this.cookie = cookie;
    }

    @XStreamImplicit(itemFieldName="cookie",keyFieldName = "name")
    private Map<String, Cookie> cookie;

    public Cookie getCookeInfo(String name){
        return cookie.get(name);
    }
}
