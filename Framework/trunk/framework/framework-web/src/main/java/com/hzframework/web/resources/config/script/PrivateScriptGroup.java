package com.hzframework.web.resources.config.script;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;

/**
 * Created by paul on 14-12-17.
 */
public class PrivateScriptGroup {
    @XStreamImplicit(itemFieldName="scriptName")
    private List<String> scriptNames;

    @XStreamAsAttribute
    private String name;

    @XStreamAsAttribute
    private String sharedScriptGroup;

    @XStreamAlias("pages")
    private Pages pages;

    public List<String> getScriptNames() {
        return scriptNames;
    }

    public void setScriptNames(List<String> scriptNames) {
        this.scriptNames = scriptNames;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSharedScriptGroup() {
        return sharedScriptGroup;
    }

    public void setSharedScriptGroup(String sharedScriptGroup) {
        this.sharedScriptGroup = sharedScriptGroup;
    }

    public Pages getPages() {
        return pages;
    }

    public void setPages(Pages pages) {
        this.pages = pages;
    }
}
