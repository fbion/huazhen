package com.hzframework.web.resources.config.page;

import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.Map;

/**
 * Created by paul on 15-4-20.
 */
public class Pages {
    public Map<String, Page> getPage() {
        return page;
    }

    public void setPage(Map<String, Page> page) {
        this.page = page;
    }

    @XStreamImplicit(itemFieldName="page",keyFieldName = "name")
    private Map<String, Page> page;
}
