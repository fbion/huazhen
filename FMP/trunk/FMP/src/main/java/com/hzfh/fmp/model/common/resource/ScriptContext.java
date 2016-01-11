package com.hzfh.fmp.model.common.resource;

import com.hzfh.fmp.model.common.PageAlias;
import com.hzfh.fmp.model.common.cache.CacheManager;
import com.hzfh.fmp.model.common.cache.CachePrefix;
import com.hzfh.fmp.model.common.helper.UrlHelper;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.common.properties.DeptHelper;
import com.hzfh.fmp.model.common.properties.RoleHelper;
import com.hzfh.fmp.model.common.properties.WebInfoHelper;
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

                    if (script.getName().equals("loginVariable")) {
                        script.setScript(buildRoleVariable() + buildDepartmentVariable());
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
        sb.append(String.format("%1$s:'%2$s',", "LoginSite", WebInfoHelper.WEB_FMP_LOGIN));
        sb.append(String.format("%1$s:'%2$s',", "ProductSite", WebInfoHelper.WEB_FMP_PRODUCT));
        sb.append(String.format("%1$s:'%2$s',", "EmployeeSite", WebInfoHelper.WEB_FMP_EMPLOYEE));
        sb.append(String.format("%1$s:'%2$s',", "CustomerSite", WebInfoHelper.WEB_FMP_CUSTOMER));
        sb.append(String.format("%1$s:'%2$s',", "PermissionSite", WebInfoHelper.WEB_FMP_PERMISSION));
        sb.append(String.format("%1$s:'%2$s',", "BaseInfoSite", WebInfoHelper.WEB_FMP_BASE_INFO));
        sb.append(String.format("%1$s:'%2$s',", "SalesSite", WebInfoHelper.WEB_FMP_SALES));
        sb.append(String.format("%1$s:'%2$s',", "ImgSite", WebInfoHelper.WEB_FMP_RESOURCE_IMG));
        sb.append(String.format("%1$s:'%2$s',", "WorkFlowSite", WebInfoHelper.WEB_FMP_WORK_FLOW));
        sb.append(String.format("%1$s:'%2$s',", "PaymentSite", WebInfoHelper.WEB_FMP_PAYMENT));
        sb.append(String.format("%1$s:'%2$s',", "NewIndexSite", WebInfoHelper.WEB_NEWFMP_INDEX_URL));

        sb.append(String.format("%1$s:'%2$s',", "LocalFileSite", WebInfoHelper.WEB_FMP_UPLOAD));
        sb.append(String.format("%1$s:'%2$s',", "FileSite", WebInfoHelper.WEB_UPLOAD));

        sb.append("};");

        return sb.toString();

    }

    private static String buildRoleVariable() {
        StringBuilder sb = new StringBuilder();

        //sb.append("<script type=\"text/javascript\">");
        sb.append("var RoleVar={");

        sb.append(String.format("%1$s:'%2$s',", "RoleProduct", RoleHelper.ROLE_PRODUCT));
        sb.append(String.format("%1$s:'%2$s',", "RoleProductDirector", RoleHelper.ROLE_PRODUCT_DIRECTOR));
        sb.append(String.format("%1$s:'%2$s',", "RoleSalesDirect", RoleHelper.ROLE_SALES_DIRECT));
        sb.append(String.format("%1$s:'%2$s',", "RoleSalesDirectDirector", RoleHelper.ROLE_SALES_DIRECT_DIRECTOR));
        sb.append(String.format("%1$s:'%2$s',", "RoleSalesChannel", RoleHelper.ROLE_SALES_CHANNEL));
        sb.append(String.format("%1$s:'%2$s',", "RoleSalesChannelDirector", RoleHelper.ROLE_SALES_CHANNEL_DIRECTOR));
        sb.append(String.format("%1$s:'%2$s',", "RoleSalesFortune", RoleHelper.ROLE_SALES_FORTUNE));
        sb.append(String.format("%1$s:'%2$s',", "RoleVp", RoleHelper.ROLE_VP));
        sb.append(String.format("%1$s:'%2$s',", "RoleStore", RoleHelper.ROLE_STORE));
        sb.append(String.format("%1$s:'%2$s',", "RoleCSManager", RoleHelper.ROLE_CS_MANAGER));
        sb.append(String.format("%1$s:'%2$s',", "CurrentRole", UserHelper.getUserCache().getRoleId()));

        sb.append("};");
        //sb.append("</script>");

        return sb.toString();
    }

    private static String buildDepartmentVariable() {
        StringBuilder sb = new StringBuilder();

        //sb.append("<script type=\"text/javascript\">");
        sb.append("var DEPTVar={");

        sb.append(String.format("%1$s:'%2$s',", "DEPTPresident", DeptHelper.DEPT_PRESIDENT));
        sb.append(String.format("%1$s:'%2$s',", "DEPTAdmin", DeptHelper.DEPT_ADMINISTRATION));
        sb.append(String.format("%1$s:'%2$s',", "DEPTFinance", DeptHelper.DEPT_FINANCE));
        sb.append(String.format("%1$s:'%2$s',", "DEPTOperator", DeptHelper.DEPT_OPERATOR));
        sb.append(String.format("%1$s:'%2$s',", "DEPTSales", DeptHelper.DEPT_SALES));
        sb.append(String.format("%1$s:'%2$s',", "DEPTProduct", DeptHelper.DEPT_PRODUCT));
        sb.append(String.format("%1$s:'%2$s',", "DEPTMarket", DeptHelper.DEPT_MARKET));
        sb.append(String.format("%1$s:'%2$s',", "DEPTDev", DeptHelper.DEPT_DEV));
        sb.append(String.format("%1$s:'%2$s',", "DEPTRiskControl", DeptHelper.DEPT_RISK_CONTROL));

        sb.append(String.format("%1$s:'%2$s',", "CurrentDEPT", UserHelper.getUserCache().getDeptId()));

        sb.append("};");
        //sb.append("</script>");

        return sb.toString();
    }
}
