package com.hzframework.web.resources.config.css;

import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.Map;

/**
 * Created by paul on 15-1-8.
 */
public class CssMappings {
    public Map<String, Css> getCss() {
        return css;
    }

    public void setCss(Map<String, Css> css) {
        this.css = css;
    }

    @XStreamImplicit(itemFieldName="css",keyFieldName = "name")
    private Map<String, Css> css;
}
