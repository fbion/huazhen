package com.hzframework.web.resources.config.page;

import com.hzframework.annotation.XmlPath;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by paul on 15-4-20.
 */
@XmlPath("config/resource/page/Page.xml")
@XStreamAlias("pageConfig")
public class PageConfig {
    @XStreamAlias("pages")
    private Pages pages;

    public Pages getPages() {
        return pages;
    }

    public void setPages(Pages pages) {
        this.pages = pages;
    }

    public Page getPage(String name) {
        if (this.pages == null)
            return null;
        if (this.pages.getPage() == null)
            return null;
        return this.pages.getPage().get(name);
    }

}
