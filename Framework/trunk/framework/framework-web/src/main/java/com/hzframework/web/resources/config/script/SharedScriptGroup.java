package com.hzframework.web.resources.config.script;

import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;

/**
 * Created by paul on 14-12-17.
 */
public class SharedScriptGroup{
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getScriptNames() {
        return scriptNames;
    }

    public void setScriptNames(List<String> scriptNames) {
        this.scriptNames = scriptNames;
    }

    @XStreamAsAttribute
    private String name;

    @XStreamImplicit(itemFieldName="scriptName")
    private List<String> scriptNames;
}
