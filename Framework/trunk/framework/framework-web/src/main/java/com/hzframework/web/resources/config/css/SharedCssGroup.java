package com.hzframework.web.resources.config.css;

import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;

/**
 * Created by paul on 15-1-8.
 */
public class SharedCssGroup {
    @XStreamAsAttribute
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getCssNames() {
        return cssNames;
    }

    public void setCssNames(List<String> cssNames) {
        this.cssNames = cssNames;
    }

    @XStreamImplicit(itemFieldName="cssName")
    private List<String> cssNames;
}
