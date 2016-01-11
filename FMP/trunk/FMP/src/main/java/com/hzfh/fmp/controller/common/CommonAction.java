package com.hzfh.fmp.controller.common;


import com.hzfh.api.baseInfo.model.Letter;
import com.hzfh.api.permission.model.Element;
import com.hzfh.fmp.model.baseInfo.LetterModel;
import com.hzfh.fmp.model.common.PageAlias;
import com.hzfh.fmp.model.common.TreeItem;
import com.hzfh.fmp.model.common.TreeMenu;
import com.hzfh.fmp.model.common.cache.CacheManager;
import com.hzfh.fmp.model.common.cache.CachePrefix;
import com.hzfh.fmp.model.common.helper.LogHelper;
import com.hzfh.fmp.model.common.helper.UrlHelper;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.common.resource.CssContext;
import com.hzfh.fmp.model.common.resource.ScriptContext;
import com.hzfh.fmp.model.employee.EmployeeModel;
import com.hzfh.fmp.model.permission.ElementModel;
import com.hzfh.fmp.model.permission.view.PagePermissionView;
import org.apache.struts2.interceptor.ServletResponseAware;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by paul on 14-12-24.
 */
public abstract class CommonAction extends BaseAction implements ServletResponseAware {
    private PageAlias pageAlias;
    private String pageHead = "";
    private String navSub = "";//获取前台的导航子级
    private List<String> nav;//面包屑导航
    private String empName;//母版页的欢迎提示员工名称
    private int empId;
    private String updatePwdUrl;
    private String logoutUrl;
    private String knowledgeBaseUrl;
    private String letterUrl;
    private String mailUrl;
    private String calendarUrl;
    private List<Letter> noticeList;
    private String remindUrl;

    public String getRemindUrl() {
        return remindUrl;
    }
    public String getLetterUrl() {
        return letterUrl;
    }

    public String getMailUrl() {
        return mailUrl;
    }

    public String getCalendarUrl() {
        return calendarUrl;
    }

    public List<Letter> getNoticeList() {
        return noticeList;
    }

    public void setNoticeList(List<Letter> noticeList) {
        this.noticeList = noticeList;
    }

    public String getKnowledgeBaseUrl() {
		return knowledgeBaseUrl;
	}

	public void setKnowledgeBaseUrl(String knowledgeBaseUrl) {
		this.knowledgeBaseUrl = knowledgeBaseUrl;
	}

	public String getLogoutUrl() {
		return logoutUrl;
	}

	public String getUpdatePwdUrl() {
		return updatePwdUrl;
	}

	public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    //用response,来返回XML字符串   mengchong 2015/02/14
    private HttpServletResponse response;

    private PagePermissionView pagePermissionView;

    public PagePermissionView getPagePermissionView() {
        return pagePermissionView;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public PageAlias getPageAlias() {
        return pageAlias;
    }

    public void setPageAlias(PageAlias pageAlias) {
        this.pageAlias = pageAlias;
    }

    public String getPageHead() {
        return pageHead;
    }

    public String getNavSub() {
        return navSub;
    }

    public void setNavSub(String navSub) {
        this.navSub = navSub;
    }

    public List<String> getNav() {
        return nav;
    }

    public void setNav(List<String> nav) {
        this.nav = nav;
    }
    public static final LogHelper logger = LogHelper.getLogger(CommonAction.class.getName());
    private int letterListSize;

    public int getLetterListSize() {
        return letterListSize;
    }

    public void setLetterListSize(int letterListSize) {
        this.letterListSize = letterListSize;
    }
    private String baseUrl;

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Override
    public String execute() throws Exception{


        if (this.pageAlias != PageAlias.login && this.pageAlias != PageAlias.error && UserHelper.getUserCache() != null) {
            try {
				this.pagePermissionView = new PagePermissionView(String.valueOf(this.getPageAlias()), UserHelper.getUserCache().getRoleId());
			} catch (Exception e) {
				e.printStackTrace();
			}
            if (!pagePermissionView.isRead()){
                this.setException("出错了!");
                this.setExceptionStack("您可能没有权限");
                return ERROR;
            }
        }

        //获取员工的姓名
        if (UserHelper.getUserCache() != null) {
            this.empName = UserHelper.getUserCache().getEmpName();
            this.empId = UserHelper.getUserCache().getEmpId();
        } else {
            this.empName = "";
            this.empId = 0;
        }
        String ret = super.execute();

        if (!ret.equals(SUCCESS))
            return ret;
        if (this.pageAlias.toString().isEmpty())
            this.pageAlias = PageAlias.index;

        this.buildCss();
        this.buildJs();
        if(UserHelper.getUserCache()!=null){
        	List<TreeMenu> treeLists = (List<TreeMenu>) CacheManager.get(CachePrefix.MENUTREE,  String.valueOf(UserHelper.getUserCache().getRoleId())+ "treeLists");
        	System.out.println(this.navSub);
        	nav = new ArrayList<String>();
        	if (treeLists != null) {
        		for (TreeMenu treeMenu : treeLists) {
        			List<TreeItem> treeItems = treeMenu.getTreeItems();
        			boolean bFound = false;
        			for (TreeItem treeItem : treeItems) {
        				if (this.navSub.equals(treeItem.getName())) {
        					this.nav.add(treeMenu.getName());
        					this.nav.add(this.navSub);
        					bFound = true;
        					break;
        				}
        			}
        			if (bFound)
        				break;
        		}
        	}
            this.letterListSize = LetterModel.getListLimitByEmpId(UserHelper.getUserCache().getUserId()).size();
        }
        this.updatePwdUrl = UrlHelper.buildLoginSiteUrl("/updatePwd");
        this.logoutUrl = UrlHelper.buildLoginSiteUrl("/logout");
        this.knowledgeBaseUrl = UrlHelper.buildEmployeeSiteUrl("/employee/knowledgeBase/list");
        this.calendarUrl = UrlHelper.buildBaseInfoSiteUrl("/baseInfo/calendar/list");
        this.mailUrl = UrlHelper.buildBaseInfoSiteUrl("/baseInfo/mailList/list");
        this.letterUrl = UrlHelper.buildBaseInfoSiteUrl("/baseInfo/letter/list");
        this.remindUrl = UrlHelper.buildBaseInfoSiteUrl("/baseInfo/letter/remindList");
        this.noticeList = LetterModel.getListByTime();
        this.baseUrl = UrlHelper.buildBaseInfoSiteUrl("/index.action");
        return SUCCESS;
    }

    private void buildJs() {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            List<String> scriptList = ScriptContext.getScriptByPageAlias(this.pageAlias);

			for (String script : scriptList) {
			    stringBuilder.append(script);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        pageHead += stringBuilder.toString();
    }

    private void buildCss() {
        StringBuilder stringBuilder = new StringBuilder();

        for (String css : CssContext.getCssByPageAlias(this.pageAlias)) {
            stringBuilder.append(css);
        }
        //stringBuilder.append("<link type=\"text/css\" rel=\"stylesheet\" href=\""+ UrlHelper.buildCss("page.css")+"\">");

        pageHead += stringBuilder.toString();
    }
    
    
    


    /**
     * 向浏览器返回xml字符串
     *
     * @param xml
     * @return
     * @throws Exception
     * @author mengchong 2015/02/14
     */
    public String xmlOut(String xml) throws Exception {
        response.setContentType("text/xml;charset=UTF-8");
        response.getWriter().print(xml);
        return null;
    }

    public void setServletResponse(HttpServletResponse response) {
        this.response = response;

    }
}
