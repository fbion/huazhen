package com.hzframework.web.resources.config.css;

import com.hzframework.annotation.XmlPath;
import com.hzframework.web.resources.config.BaseItem;
import com.hzframework.web.resources.config.ComparatorResource;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by paul on 15-1-8.
 */
@XmlPath("config/resource/css/*.xml")
@XStreamAlias("cssConfig")
public class CssConfig {
    @XStreamAlias("cssMappings")
    private CssMappings cssMappings;
    @XStreamAlias("privateCssGroups")
    private PrivateCssGroups privateCssGroups;
    @XStreamAlias("sharedCssGroups")
    private SharedCssGroups sharedCssGroups;

    public CssMappings getCssMappings() {
        return cssMappings;
    }

    public void setCssMappings(CssMappings cssMappings) {
        this.cssMappings = cssMappings;
    }

    public PrivateCssGroups getPrivateCssGroups() {
        return privateCssGroups;
    }

    public void setPrivateCssGroups(PrivateCssGroups privateCssGroups) {
        this.privateCssGroups = privateCssGroups;
    }

    public SharedCssGroups getSharedCssGroups() {
        return sharedCssGroups;
    }

    public void setSharedCssGroups(SharedCssGroups sharedCssGroups) {
        this.sharedCssGroups = sharedCssGroups;
    }

    public List<Css> getCssListInPage(String pageName)
    {
        List<Css> cssList = new ArrayList<Css>();

        PrivateCssGroup privateCssGroup = this.privateCssGroups.getCssMapByPageName(pageName);
        // 处理Shared Script
        SharedCssGroup sharedCssGroup = null;
        if (privateCssGroup != null)
        {
            if (!privateCssGroup.getSharedCssGroup().isEmpty())
            {
                sharedCssGroup = sharedCssGroups.getCssGroup(privateCssGroup.getSharedCssGroup());
            }
        }

        if (sharedCssGroup == null)
        {
            sharedCssGroup = sharedCssGroups.getDefaultCssGroup();
        }

        if (sharedCssGroup != null)
        {
            AddCss(cssList, sharedCssGroup.getCssNames());
        }

        if (privateCssGroup != null)
        {
            AddCss(cssList, privateCssGroup.getCssNames());
        }

        Collections.sort(cssList, new ComparatorResource<BaseItem>());

        return cssList;
    }

    private void AddCss(List<Css> cssListInPage, List<String> cssNames)
    {
        if (cssNames == null)
            return;

        if (cssMappings == null || cssMappings.getCss() == null)
            return;

        for (String cssName : cssNames)
        {
            Css css = cssMappings.getCss().get(cssName);
            if (css != null && css.isEnabled())
            {
                cssListInPage.add(css);
            }
        }
    }
}
