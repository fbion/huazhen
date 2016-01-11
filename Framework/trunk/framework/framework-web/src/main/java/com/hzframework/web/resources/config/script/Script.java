package com.hzframework.web.resources.config.script;

import com.hzframework.web.resources.config.BaseItem;
import com.hzframework.web.resources.config.PageZone;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.enums.EnumSingleValueConverter;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;

/**
 * Created by paul on 14-12-31.
 */
@XStreamAlias("script")
@XStreamConverter(value=ToAttributedValueConverter.class, strings={"script"})
public class Script extends BaseItem {
    @XStreamAsAttribute
    private String name;

    @XStreamAsAttribute
    private boolean isDevelop = false;


    @XStreamConverter(value = EnumSingleValueConverter.class,strings={"pageZone"})
    @XStreamAsAttribute
    private PageZone pageZone = PageZone.Header;

    private String script;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDevelop() {
        return isDevelop;
    }

    public void setDevelop(boolean isDevelop) {
        this.isDevelop = isDevelop;
    }



    public PageZone getPageZone() {
        return pageZone;
    }

    public void setPageZone(PageZone pageZone) {
        this.pageZone = pageZone;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }
}
