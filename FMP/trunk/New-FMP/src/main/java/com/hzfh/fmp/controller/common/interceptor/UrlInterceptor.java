package com.hzfh.fmp.controller.common.interceptor;

import com.hzfh.fmp.model.common.TreeItem;
import com.hzfh.fmp.model.common.TreeMenu;
import com.hzfh.fmp.model.common.cache.CacheManager;
import com.hzfh.fmp.model.common.cache.CachePrefix;
import com.hzfh.fmp.model.common.state.StateValues;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/4/7.
 */
public class UrlInterceptor extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        ActionContext actionContext = actionInvocation.getInvocationContext();
        HttpServletRequest request = (HttpServletRequest) actionContext.get(ServletActionContext.HTTP_REQUEST);
        String url = request.getRequestURL().toString();
        List<TreeMenu> treeLists = (List<TreeMenu>) CacheManager.get(CachePrefix.MENUTREE,String.valueOf(StateValues.getUserId())+"treeLists");
        if(treeLists == null || treeLists.size() == 0){
            return Action.LOGIN;
        }
        List<TreeItem> firstLevelMenu = new ArrayList<TreeItem>();
        for(int i=0;i<treeLists.size();i++){
            firstLevelMenu = treeLists.get(i).getTreeItems();
            for(TreeItem secondLevleMenu : firstLevelMenu){
                if(url.equals(secondLevleMenu.getUrl())){
                    return actionInvocation.invoke();
                }
            }
        }
        return Action.LOGIN;
    }
}
