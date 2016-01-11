package com.hzfh.mobile.model.common.helper;

import com.hzfh.mobile.model.common.PageAlias;
import com.hzfh.mobile.model.common.properties.WebInfoHelper;
import com.hzframework.helper.StringHelper;

/**
 * Created by paul on 15-1-6.
 */
public class UrlHelper {
    public static String buildWWWSiteUrl(PageAlias pageAlias) {
        switch(pageAlias){
            default:
                return StringHelper.trimEnd(WebInfoHelper.WEB_MOBILE_WWW, "/") + "/index";
        }
    }

    public static String buildJs(String js) {
        return WebInfoHelper.WEB_MOBILE_RESOURCE_JS + "/" + js;
    }

    public static String buildCss(String css) {
        return WebInfoHelper.WEB_MOBILE_RESOURCE_CSS + "/" + css;
    }

    public static String buildImg(String img) {
        return WebInfoHelper.WEB_MOBILE_RESOURCE_IMG + "/" + img;
    }

    public static String buildDevJs(String js) {
        return WebInfoHelper.WEB_MOBILE_DEV_JS + "/" + js;
    }
    
    public static String bulidWebUploadPath(String path){
    	return WebInfoHelper.WEB_UPLOAD+ "/"+path;
    }
}
