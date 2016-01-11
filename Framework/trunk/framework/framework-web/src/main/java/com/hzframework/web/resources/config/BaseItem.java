package com.hzframework.web.resources.config;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.enums.EnumSingleValueConverter;

/**
 * Created by paul on 14-12-31.
 */
public class BaseItem {
    @XStreamAsAttribute
    private int order;

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @XStreamAsAttribute
    private boolean enabled = true;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @XStreamConverter(value = EnumSingleValueConverter.class,strings={"limitBrowserType"})
    @XStreamAsAttribute
    private LimitBrowserType limitBrowserType = LimitBrowserType.None;

    @XStreamAsAttribute
    private float limitBrowserVersion;

    @XStreamConverter(value = EnumSingleValueConverter.class,strings={"type"})
    @XStreamAlias("type")
    @XStreamAsAttribute
    private ResourceType resourceType = ResourceType.External;


    public LimitBrowserType getLimitBrowserType() {
        return limitBrowserType;
    }

    public void setLimitBrowserType(LimitBrowserType limitBrowserType) {
        this.limitBrowserType = limitBrowserType;
    }

    public float getLimitBrowserVersion() {
        return limitBrowserVersion;
    }

    public void setLimitBrowserVersion(float limitBrowserVersion) {
        this.limitBrowserVersion = limitBrowserVersion;
    }

    public ResourceType getResourceType() {
        return resourceType;
    }

    public void setResourceType(ResourceType resourceType) {
        this.resourceType = resourceType;
    }

}
