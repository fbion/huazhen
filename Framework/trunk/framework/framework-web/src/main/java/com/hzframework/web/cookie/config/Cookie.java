package com.hzframework.web.cookie.config;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;

/**
 * Created by paul on 15-4-15.
 */
@XStreamAlias("cookie")
public class Cookie {
    @XStreamAsAttribute
    private String name;
    @XStreamAsAttribute
    private boolean topLevelDomain= true;
    @XStreamAsAttribute
    private String path;
    @XStreamConverter(value = ExpireTimeSpanValueConverter.class,strings={"expiresAfter"})
    @XStreamAsAttribute
    private int expiresAfter;
    @XStreamAsAttribute
    private boolean secureOnly = false;
    @XStreamAsAttribute
    private boolean renderInClient = false;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isTopLevelDomain() {
        return topLevelDomain;
    }

    public void setTopLevelDomain(boolean topLevelDomain) {
        this.topLevelDomain = topLevelDomain;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getExpiresAfter() {
        return expiresAfter;
    }

    public void setExpiresAfter(int expiresAfter) {
        this.expiresAfter = expiresAfter;
    }

    public boolean isSecureOnly() {
        return secureOnly;
    }

    public void setSecureOnly(boolean secureOnly) {
        this.secureOnly = secureOnly;
    }

    public boolean isRenderInClient() {
        return renderInClient;
    }

    public void setRenderInClient(boolean renderInClient) {
        this.renderInClient = renderInClient;
    }
}
