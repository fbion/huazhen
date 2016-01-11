package com.hzfh.o2o.model.common.resource;

import com.hzfh.o2o.model.PageAlias;
import com.hzfh.o2o.model.common.cache.CachePrefix;
import com.hzfh.o2o.model.common.helper.UrlHelper;
import com.hzfh.o2o.model.common.cache.CacheManager;
import com.hzfh.o2o.model.common.properties.WebInfoHelper;
import com.hzframework.web.config.Config;
import com.hzframework.web.resources.config.ResourceType;
import com.hzframework.web.resources.config.script.Script;
import com.hzframework.web.resources.config.script.ScriptConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by paul on 14-12-31.
 */
public class ScriptContext {
    public static List<String> getScriptByPageAlias(PageAlias pageAlias) {
        //String rootPage = ServletActionContext.getServletContext().getRealPath("/config");

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
                    if (script.getName().equals("environmentVariable")) {
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

        if (script.getResourceType() == ResourceType.External) {
            tagFormat = externalTagFormat;
            if (script.isDevelop()) {
                jsContent = UrlHelper.buildDevJs(script.getScript());
            } else {
                jsContent = UrlHelper.buildJs(script.getScript());
            }
        } else {
            tagFormat = inlineTagFormat;
            jsContent = script.getScript();
        }

        switch (script.getLimitBrowserType()) {
            case IEOnly:
                jsTagHeader = "<!--[if IE" + version + "]>";
                jsTagFooter = "<![endif]-->";
                break;
            case NonIEOnly:
                jsTagHeader = "<![if IE" + version + "]>";
                jsTagFooter = "<![endif]>";
                break;
            default:
                break;
        }

        return String.format(tagFormat, jsTagHeader, jsContent, jsTagFooter);
    }

    private static String buildEnvironmentVariable() {
        StringBuilder sb = new StringBuilder();

        sb.append("var Environment={");
        sb.append(String.format("%1$s:'%2$s',", "IndexSite", WebInfoHelper.WEB_O2O));
        sb.append(String.format("%1$s:'%2$s',", "ProductSite", WebInfoHelper.WEB_O2O_PRODUCT));
        sb.append(String.format("%1$s:'%2$s',", "CustomerSite", WebInfoHelper.WEB_O2O_CUSTOMER));
        sb.append(String.format("%1$s:'%2$s',", "SystemSite", WebInfoHelper.WEB_O2O_SYSTEM));
        sb.append(String.format("%1$s:'%2$s',", "OrderSite", WebInfoHelper.WEB_O2O_ORDER));
        sb.append(String.format("%1$s:'%2$s',", "PaymentSite", WebInfoHelper.WEB_O2O_PAYMENT));

        sb.append(String.format("%1$s:'%2$s',", "ImgSite", WebInfoHelper.WEB_O2O_RESOURCE_IMG));

        sb.append(String.format("%1$s:'%2$s',", "LocalFileSite", WebInfoHelper.WEB_O2O_UPLOAD));
        sb.append(String.format("%1$s:'%2$s',", "FileSite", WebInfoHelper.WEB_UPLOAD));
        sb.append("};");

        return sb.toString();

    }

}
