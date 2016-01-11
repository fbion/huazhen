package com.hzframework.web.resources.config.script;

import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.Map;

/**
 * Created by paul on 14-12-31.
 */
public class ScriptMappings {
    @XStreamImplicit(itemFieldName="script",keyFieldName = "name")
    private Map<String, Script> scripts;

    public Map<String, Script> getScripts() {
        return scripts;
    }

    public void setScripts(Map<String, Script> scripts) {
        this.scripts = scripts;
    }
}
