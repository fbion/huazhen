package com.hzframework.web.resources.config.script;

import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by paul on 14-12-31.
 */
public class PrivateScriptGroups {
    public Map<String, PrivateScriptGroup> getScriptGroups() {
        return scriptGroups;
    }

    public void setScriptGroups(Map<String, PrivateScriptGroup> scriptGroups) {
        this.scriptGroups = scriptGroups;
    }

    @XStreamImplicit(itemFieldName="scriptGroup",keyFieldName = "name")
    private Map<String,PrivateScriptGroup> scriptGroups;

    public PrivateScriptGroup getScriptMapByPageName(String pageName) {
        if (scriptMap == null || scriptMap.size() == 0)
            insertItem();
        return scriptMap.get(pageName);
    }

    private Map<String,PrivateScriptGroup> scriptMap;
    private void insertItem()
    {
        if (this.scriptMap == null)
        {
            scriptMap = new HashMap<String, PrivateScriptGroup>();
        }

        for (Map.Entry<String, PrivateScriptGroup> group:scriptGroups.entrySet())
        {
            if (group.getValue().getPages() != null)
            for (String pageName:group.getValue().getPages().getPageNames()) {
                scriptMap.put(pageName, group.getValue());
            }
        }
    }
}
