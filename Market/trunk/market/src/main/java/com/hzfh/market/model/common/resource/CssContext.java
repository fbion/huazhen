package com.hzfh.market.model.common.resource;

import java.util.ArrayList;
import java.util.List;

import com.hzfh.market.model.common.PageAlias;
import com.hzfh.market.model.common.cache.CacheManager;
import com.hzfh.market.model.common.cache.CachePrefix;
import com.hzfh.market.model.common.helper.UrlHelper;
import com.hzframework.web.config.Config;
import com.hzframework.web.resources.config.ResourceType;
import com.hzframework.web.resources.config.css.Css;
import com.hzframework.web.resources.config.css.CssConfig;

public class CssContext {
    public static List<String> getCssByPageAlias(PageAlias pageAlias) {
        //String rootPage = ServletActionContext.getServletContext().getRealPath("/config");

        Object obj = CacheManager.get(CachePrefix.RESOURCE_PAGE_CSS_PREFIX, pageAlias.toString());

        if (obj != null && (obj instanceof ArrayList<?>)) {
            return (ArrayList<String>) obj;
        }

        CssConfig cssConfig = CacheManager.get(CachePrefix.RESOURCE_CSS_PREFIX, "CSS", CssConfig.class);
        if (cssConfig == null) {
            cssConfig = Config.getCssConfig();
            //CacheManager.set(CachePrefix.RESOURCE_CSS_PREFIX, "CSS", 7 * 24 * 60 * 60, CssConfig.class);
        }
        List<String> cssList = buildCssList(pageAlias, cssConfig);

        CacheManager.set(CachePrefix.RESOURCE_PAGE_CSS_PREFIX, pageAlias.toString(), 7 * 24 * 60 * 60, cssList);
        return cssList;
    }

    private static List<String> buildCssList(PageAlias pageAlias, CssConfig cssConfig) {
        List<String> resultList = new ArrayList<String>();
        if (cssConfig != null) {
            List<Css> cssList = cssConfig.getCssListInPage(pageAlias.toString());

            if (cssList != null) {
                for (Css css : cssList) {
                    resultList.add(buildCssItem(css));
                }
            }
        }

        return resultList;
    }

    private static String buildCssItem(Css css) {
        String externalTagFormat = "%1$s<link rel=\"stylesheet\" type=\"text/css\" href=\"%2$s\" />%3$s";
        String inlineTagFormat = "%1$s%2$s%2$s";

        String tagFormat = "";
        String styleTagHeader = "";
        String styleTagFooter = "";
        String version = (css.getLimitBrowserVersion() > 0) ? String.valueOf(css.getLimitBrowserVersion()) : "";
        String content = "";

        if (css.getResourceType() == ResourceType.External) {
            tagFormat = externalTagFormat;
            content = UrlHelper.buildCss(css.getCss());
        } else {
            tagFormat = inlineTagFormat;
            content = css.getCss();
        }

        switch (css.getLimitBrowserType()) {
            case IEOnly:
                styleTagHeader = "<!--[if IE" + version + "]>";
                styleTagFooter = "<![endif]-->";
                break;
            case NonIEOnly:
                styleTagHeader = "<![if IE" + version + "]>";
                styleTagFooter = "<![endif]>";
                break;
            default:
                break;
        }

        return String.format(tagFormat, styleTagHeader, content, styleTagFooter);
    }
}
