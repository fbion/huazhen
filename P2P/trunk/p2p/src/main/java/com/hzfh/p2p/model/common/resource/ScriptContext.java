package com.hzfh.p2p.model.common.resource;

import com.hzfh.p2p.model.common.PageAlias;
import com.hzfh.p2p.model.common.cache.CacheManager;
import com.hzfh.p2p.model.common.cache.CachePrefix;
import com.hzfh.p2p.model.common.helper.UrlHelper;
import com.hzfh.p2p.model.common.properties.WebInfoHelper;
import com.hzframework.web.config.Config;
import com.hzframework.web.resources.config.ResourceType;
import com.hzframework.web.resources.config.script.Script;
import com.hzframework.web.resources.config.script.ScriptConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by paul on 15-3-10.
 */
public class ScriptContext {
    public static List<String> getScriptByPageAlias(PageAlias pageAlias) {

        Object obj = CacheManager.get(CachePrefix.RESOURCE_PAGE_SCRIPT_PREFIX, pageAlias.toString());

        if (obj != null && (obj instanceof ArrayList<?>)) {
            return (ArrayList<String>) obj;
        }

        ScriptConfig scriptConfig = CacheManager.get(CachePrefix.RESOURCE_SCRIPT_PREFIX, "SCRIPT", ScriptConfig.class);
        if (scriptConfig == null) {
            scriptConfig = Config.getScriptConfig();
        }
        return buildScriptList(pageAlias, scriptConfig);
    }

    private static List<String> buildScriptList(PageAlias pageAlias, ScriptConfig scriptConfig) {

        List<String> resultList = new ArrayList<String>();
        if (scriptConfig != null) {
            List<Script> scriptList = scriptConfig.getScriptListInPage(pageAlias.toString());

            if (scriptList != null) {
                for (Script script : scriptList) {
                    if (script.getName().equals("environmentVariable")){
                        script.setScript(buildEnvironmentVariable());
                    }

                    resultList.add(buildScriptItem(script));
                }
            }
        }

        return resultList;
    }

    private static String buildScriptItem(Script script) {
        String externalTagFormat = "%1$s<script type=\"text/javascript\" src=\"%2$s\"></script>%3$s";
        String inlineTagFormat = "%1$s<script type=\"text/javascript\">%2$s</script>%3$s";

        String tagFormat;
        String jsContent;
        String jsTagHeader = "";
        String jsTagFooter = "";
        String version = (script.getLimitBrowserVersion() > 0) ? String.valueOf(script.getLimitBrowserVersion()) : "";

        if (script.getResourceType() == ResourceType.External)
        {
            tagFormat = externalTagFormat;
            if (script.isDevelop())
            {
                jsContent =  UrlHelper.buildDevJs(script.getScript());
            }
            else
            {
                jsContent = UrlHelper.buildJs(script.getScript());
            }
        }
        else
        {
            tagFormat = inlineTagFormat;
            jsContent = script.getScript();
        }

        switch (script.getLimitBrowserType())
        {
            case IEOnly:
                jsTagHeader = "<!--[if IE " + version + "]>";
                jsTagFooter = "<![endif]-->";
                break;
            case NonIEOnly:
                jsTagHeader = "<![if IE " + version + "]>";
                jsTagFooter = "<![endif]>";
                break;
            default:
                break;
        }

        return String.format(tagFormat, jsTagHeader, jsContent, jsTagFooter);
    }

    private static String buildEnvironmentVariable()
    {
        StringBuilder sb = new StringBuilder();

        sb.append("var Environment={");
        sb.append(String.format("%1$s:'%2$s',", "WWWSite", WebInfoHelper.WEB_P2P_WWW));
        sb.append(String.format("%1$s:'%2$s',", "ImgSite", WebInfoHelper.WEB_P2P_RESOURCE_IMG));

        sb.append(String.format("%1$s:'%2$s',", "LocalFileSite", WebInfoHelper.WEB_P2P_UPLOAD));
        sb.append(String.format("%1$s:'%2$s',", "FileSite", WebInfoHelper.WEB_UPLOAD));

        sb.append("};");

        return sb.toString();

    }
}
