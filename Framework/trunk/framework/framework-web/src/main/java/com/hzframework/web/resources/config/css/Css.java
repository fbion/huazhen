package com.hzframework.web.resources.config.css;

import com.hzframework.web.resources.config.BaseItem;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;

/**
 * Created by paul on 15-1-8.
 */
@XStreamAlias("css")
@XStreamConverter(value=ToAttributedValueConverter.class, strings={"css"})
public class Css extends BaseItem {
    @XStreamAsAttribute
    private String name;

    private String css;

    public String getCss() {
        return css;
    }

    public void setCss(String css) {
        this.css = css;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
