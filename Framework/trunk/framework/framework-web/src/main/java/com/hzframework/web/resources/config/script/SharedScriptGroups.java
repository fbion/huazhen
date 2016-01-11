package com.hzframework.web.resources.config.script;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.Map;


/**
 * Created by paul on 14-12-17.
 */
public class SharedScriptGroups {
    public SharedScriptGroup getDefaultScriptGroup() {
        return getScriptGroup(this.defaultGroup);
    }

    public SharedScriptGroup getScriptGroup(String groupName) {
        return this.scriptGroups.get(groupName);
    }

    @XStreamAlias("default")
    @XStreamAsAttribute
    private String defaultGroup;

    @XStreamImplicit(itemFieldName="scriptGroup",keyFieldName = "name")
    private Map<String,SharedScriptGroup> scriptGroups;


    public String getDefaultGroup() {
        return defaultGroup;
    }

    public void setDefaultGroup(String defaultGroup) {
        this.defaultGroup = defaultGroup;
    }


    public Map<String,SharedScriptGroup> getScriptGroups() {
        return scriptGroups;
    }

    public void setScriptGroups(Map<String,SharedScriptGroup> scriptGroups) {
        this.scriptGroups = scriptGroups;
    }
}
