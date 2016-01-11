package com.hzframework.web.config;

import com.hzframework.web.cookie.config.CookieConfig;
import com.hzframework.web.cookie.config.CookieConfigHelper;
import com.hzframework.web.resources.config.WebResourceConfigHelper;
import com.hzframework.web.resources.config.css.CssConfig;
import com.hzframework.web.resources.config.page.PageConfig;
import com.hzframework.web.resources.config.script.ScriptConfig;

/**
 * Created by paul on 15-4-16.
 */
public class Config {
    public static CookieConfig getCookieConfig() {
        return CookieConfigHelper.getCookieConfig();
    }

    public static ScriptConfig getScriptConfig() {return WebResourceConfigHelper.getScriptConfig();}

    public static CssConfig getCssConfig() {return WebResourceConfigHelper.getCssConfig();}

    public static PageConfig getPageConfig(){return WebResourceConfigHelper.getPageConfig();}
}
