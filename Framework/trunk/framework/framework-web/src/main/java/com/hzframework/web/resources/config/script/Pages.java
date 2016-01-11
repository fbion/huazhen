package com.hzframework.web.resources.config.script;

import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;

/**
 * Created by paul on 14-12-31.
 */
public class Pages {
    @XStreamImplicit(itemFieldName="pageName")
    private List<String> pageNames;

    public List<String> getPageNames() {
        return pageNames;
    }

    public void setPageNames(List<String> pageNames) {
        this.pageNames = pageNames;
    }
}
