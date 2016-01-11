package com.hzframework.web.resources.config.css;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.Map;

/**
 * Created by paul on 15-1-8.
 */
public class SharedCssGroups {
    public SharedCssGroup getDefaultCssGroup() {
        return getCssGroup(this.defaultGroup);
    }

    public SharedCssGroup getCssGroup(String groupName) {
        return this.cssGroups.get(groupName);
    }

    @XStreamAlias("default")
    @XStreamAsAttribute
    private String defaultGroup;

    @XStreamImplicit(itemFieldName="cssGroup",keyFieldName = "name")
    private Map<String,SharedCssGroup> cssGroups;

    public Map<String, SharedCssGroup> getCssGroups() {
        return cssGroups;
    }

    public void setCssGroups(Map<String, SharedCssGroup> cssGroups) {
        this.cssGroups = cssGroups;
    }

    public String getDefaultGroup() {
        return defaultGroup;
    }

    public void setDefaultGroup(String defaultGroup) {
        this.defaultGroup = defaultGroup;
    }
}
