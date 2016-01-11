package com.hzframework.web.resources.config.css;

import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by paul on 15-1-8.
 */
public class PrivateCssGroups {
    public Map<String, PrivateCssGroup> getScriptGroups() {
        return cssGroups;
    }

    public void setScriptGroups(Map<String, PrivateCssGroup> cssGroups) {
        this.cssGroups = cssGroups;
    }

    @XStreamImplicit(itemFieldName="cssGroup",keyFieldName = "name")
    private Map<String,PrivateCssGroup> cssGroups;

    public PrivateCssGroup getCssMapByPageName(String pageName) {
        if (cssMap == null || cssMap.size() == 0)
            insertItem();
        return cssMap.get(pageName);
    }

    private Map<String,PrivateCssGroup> cssMap;
    private void insertItem()
    {
        if (this.cssMap == null)
        {
            cssMap = new HashMap<String, PrivateCssGroup>();
        }

        for (Map.Entry<String, PrivateCssGroup> group:cssGroups.entrySet())
        {
            if (group.getValue().getPages() != null)
                for (String pageName:group.getValue().getPages().getPageNames()) {
                    cssMap.put(pageName, group.getValue());
                }
        }
    }
}
