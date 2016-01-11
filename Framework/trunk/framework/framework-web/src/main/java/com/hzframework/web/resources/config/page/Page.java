package com.hzframework.web.resources.config.page;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * Created by paul on 15-4-20.
 */
@XStreamAlias("css")
public class Page {
    @XStreamAsAttribute
    private String name;
    @XStreamAsAttribute
    private String action;
    @XStreamAsAttribute
    private String rootPath;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getRootPath() {
        return rootPath;
    }

    public void setRootPath(String rootPath) {
        this.rootPath = rootPath;
    }
}
