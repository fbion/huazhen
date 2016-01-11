package com.hzframework.web.resources.config;

import com.hzframework.web.resources.config.css.CssConfig;
import com.hzframework.web.resources.config.page.PageConfig;
import com.hzframework.web.resources.config.script.ScriptConfig;
import com.hzframework.web.xml.XmlHelper;

/**
 * Created by paul on 14-12-31.
 */
public class WebResourceConfigHelper {
//    @Deprecated
//    public static ScriptConfig getScriptConfig(String rootPath)
//    {
//        ScriptConfig scriptConfig = XmlHelper.getConfig(ScriptConfig.class, rootPath + "/resource/script/Script.xml");
//
//        ScriptConfig sharedScriptConfig = XmlHelper.getConfig(ScriptConfig.class, rootPath + "/resource/script/SharedScriptGroup.xml");
//
//        if (sharedScriptConfig != null)
//            scriptConfig.setSharedScriptGroups(sharedScriptConfig.getSharedScriptGroups());
//
//        ScriptConfig privateScriptConfig = XmlHelper.getConfig(ScriptConfig.class, rootPath + "/resource/script/PrivateScriptGroup.xml");
//
//        if (privateScriptConfig != null)
//            scriptConfig.setPrivateScriptGroups(privateScriptConfig.getPrivateScriptGroups());
//
//        return scriptConfig;
//    }
//
//    @Deprecated
//    public static CssConfig getCssConfig(String rootPath)
//    {
//        CssConfig cssConfig = XmlHelper.getConfig(CssConfig.class, rootPath + "/resource/css/Css.xml");
//        if (cssConfig == null)
//            cssConfig = new CssConfig();
//
//        CssConfig sharedCssConfig = XmlHelper.getConfig(CssConfig.class, rootPath + "/resource/css/SharedCssGroup.xml");
//
//        if (sharedCssConfig != null)
//            cssConfig.setSharedCssGroups(sharedCssConfig.getSharedCssGroups());
//
//        CssConfig privateCssConfig = XmlHelper.getConfig(CssConfig.class, rootPath + "/resource/css/PrivateCssGroup.xml");
//
//        if (privateCssConfig != null)
//            cssConfig.setPrivateCssGroups(privateCssConfig.getPrivateCssGroups());
//
//        return cssConfig;
//    }

    public static ScriptConfig getScriptConfig() {
        return XmlHelper.getConfig(ScriptConfig.class);
    }

    public static CssConfig getCssConfig() {
        return XmlHelper.getConfig(CssConfig.class);
    }

    public static PageConfig getPageConfig(){return XmlHelper.getConfig(PageConfig.class);}
}
