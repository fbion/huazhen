package com.hzframework.web.resources.config.css;

import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;

/**
 * Created by paul on 15-1-8.
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
