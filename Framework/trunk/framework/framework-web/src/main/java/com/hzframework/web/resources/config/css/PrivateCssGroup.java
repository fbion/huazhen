package com.hzframework.web.resources.config.css;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;

/**
 * Created by paul on 15-1-8.
 */
public class PrivateCssGroup {
    @XStreamImplicit(itemFieldName="cssName")
    private List<String> cssNames;

    @XStreamAsAttribute
    private String name;

    public List<String> getCssNames() {
        return cssNames;
    }

    public void setCssNames(List<String> cssNames) {
        this.cssNames = cssNames;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSharedCssGroup() {
        return sharedCssGroup;
    }

    public void setSharedCssGroup(String sharedCssGroup) {
        this.sharedCssGroup = sharedCssGroup;
    }

    public Pages getPages() {
        return pages;
    }

    public void setPages(Pages pages) {
        this.pages = pages;
    }

    @XStreamAsAttribute

    private String sharedCssGroup;

    @XStreamAlias("pages")
    private Pages pages;
}
