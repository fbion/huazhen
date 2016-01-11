package com.hzframework.web.resources.config.script;

import com.hzframework.annotation.XmlPath;
import com.hzframework.web.resources.config.BaseItem;
import com.hzframework.web.resources.config.ComparatorResource;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Created by paul on 14-12-17.
 */
@XmlPath("config/resource/script/*.xml")
@XStreamAlias("scriptConfig")
public class ScriptConfig{
    @XStreamAlias("sharedScriptGroups")
    private SharedScriptGroups sharedScriptGroups;

    @XStreamAlias("privateScriptGroups")
    private PrivateScriptGroups privateScriptGroups;

    @XStreamAlias("scriptMappings")
    private ScriptMappings scriptMappings;

    public ScriptMappings getScriptMappings() {
        return scriptMappings;
    }

    public void setScriptMappings(ScriptMappings scriptMappings) {
        this.scriptMappings = scriptMappings;
    }

    public PrivateScriptGroups getPrivateScriptGroups() {
        return privateScriptGroups;
    }

    public void setPrivateScriptGroups(PrivateScriptGroups privateScriptGroups) {
        this.privateScriptGroups = privateScriptGroups;
    }

    public SharedScriptGroups getSharedScriptGroups() {
        return sharedScriptGroups;
    }

    public void setSharedScriptGroups(SharedScriptGroups sharedScriptGroups) {
        this.sharedScriptGroups = sharedScriptGroups;
    }

    public List<Script> getScriptListInPage(String pageName)
    {
        List<Script> scriptList = new ArrayList<Script>();

        PrivateScriptGroup privateScriptGroup = this.privateScriptGroups.getScriptMapByPageName(pageName);
        // 处理Shared Script
        SharedScriptGroup sharedScriptGroup = null;
        if (privateScriptGroup != null)
        {
            if (!privateScriptGroup.getSharedScriptGroup().isEmpty())
            {
                sharedScriptGroup = sharedScriptGroups.getScriptGroup(privateScriptGroup.getSharedScriptGroup());
            }
        }

        if (sharedScriptGroup == null)
        {
            sharedScriptGroup = sharedScriptGroups.getDefaultScriptGroup();
        }

        if (sharedScriptGroup != null)
        {
            AddScripts(scriptList, sharedScriptGroup.getScriptNames());
        }

        if (privateScriptGroup != null)
        {
            AddScripts(scriptList, privateScriptGroup.getScriptNames());
        }

        Collections.sort(scriptList,new ComparatorResource<BaseItem>());

        return scriptList;
    }

    private void AddScripts(List<Script> scriptListInPage, List<String> scriptNames)
    {
        if (scriptNames == null)
            return;

        if (scriptMappings == null || scriptMappings.getScripts() == null)
            return;

        for (String scriptName : scriptNames)
        {
            Script script = scriptMappings.getScripts().get(scriptName);
            if (script != null && script.isEnabled())
            {
                scriptListInPage.add(script);
            }
        }
    }
}
