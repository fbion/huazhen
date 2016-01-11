package com.hzfh.fmp.controller.layout;

import com.hzfh.api.permission.model.Element;
import com.hzfh.api.permission.model.Tree;
import com.hzfh.api.permission.model.query.MenuCondition;
import com.hzfh.fmp.controller.common.CommonAction;
import com.hzfh.fmp.controller.common.EasyUIBaseAction;
import com.hzfh.fmp.model.common.TreeItem;
import com.hzfh.fmp.model.common.TreeMenu;
import com.hzfh.fmp.model.common.cache.CacheManager;
import com.hzfh.fmp.model.common.cache.CachePrefix;
import com.hzfh.fmp.model.common.helper.UrlHelper;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.permission.ElementModel;
import com.hzfh.fmp.model.permission.MenuModel;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by paul on 14-11-4.
 */
public class MenuTreeAction extends EasyUIBaseAction {
    private static final int FIRSTLEVELMENU = 2;
    private static final int SECONDLEVELMENU = 3;
    private static final int THREELEVELMENU = 4;

    private List<TreeMenu> treeLists;
    private List<Element> menuList;
    private int id;
    private List<Tree> easyUITree;

    public List<Tree> getEasyUITree() {
        return easyUITree;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<TreeMenu> getTreeLists() {
        return treeLists;
    }

    public List<Element> getMenuList() {
        return menuList;
    }

    @Override
    public String execute() throws Exception {
        treeLists = (List<TreeMenu>) CacheManager.get(CachePrefix.MENUTREE, String.valueOf(UserHelper.getUserCache().getRoleId()) + "treeLists");
        if (treeLists != null && treeLists.size() != 0) {
            return SUCCESS;
        } else {
            //int userId=StateValues.getUserId();
            int roleNo = UserHelper.getUserCache().getRoleId();
            List<Element> firstLevelMenu = ElementModel.get1stLevelMenuList();

            MenuCondition menuCondition = new MenuCondition();
            //menuCondition.setUserNo(userId);
            menuCondition.setRoleNo(roleNo);
            List<Element> elementList;
            try {
                elementList = MenuModel.getUserElement(menuCondition);
                //循环privilegeList，将用户赋予相应权限

                //整个菜单的list
                treeLists = new ArrayList<TreeMenu>();

                for (Element element1 : firstLevelMenu) {
                    // 菜单的一个类型，父级菜单对应着几个子级菜单
                    TreeMenu treeMenu = new TreeMenu();
                    // 多个子级菜单
                    List<TreeItem> treeItems = new ArrayList<TreeItem>();
                    for (Element element2 : elementList) {
                        if (element1.getId() == element2.getParentNo() && element2.getValue() != null) {
                            // 一个子级菜单
                            TreeItem treeItem = new TreeItem();
                            treeItem.setName(element2.getName());
                            treeItem.setUrl(this.buildLoginSiteUrl(element2.getValue()));
                            treeItems.add(treeItem);
                        }
                    }
                    if (treeItems.size() > 0) {
                        treeMenu.setName(element1.getName());
                        treeMenu.setTreeItems(treeItems);
                        treeLists.add(treeMenu);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            CacheManager.set(CachePrefix.MENUTREE, String.valueOf(UserHelper.getUserCache().getRoleId()) + "treeLists", 7 * 24 * 60 * 60, treeLists);
            return SUCCESS;
        }

    }

    public String getEasyUIAccordion() {
        menuList = (List<Element>) CacheManager.get(CachePrefix.EASYUIMENU, String.valueOf(UserHelper.getUserCache().getRoleId()) + "getEasyUIAccordion");
        if (menuList != null && menuList.size() != 0)
            return SUCCESS;

        int roleId = UserHelper.getUserCache().getRoleId();
        String level = String.valueOf(FIRSTLEVELMENU);
        menuList = MenuModel.getUserElementByRoleNoAndLevel(roleId, 0, level);
        for (Element element : menuList) {
            element.setValue(UrlHelper.buildLoginSiteUrl(element.getValue()));
        }
        CacheManager.set(CachePrefix.EASYUIMENU, String.valueOf(UserHelper.getUserCache().getRoleId()) + "getEasyUIAccordion", 7 * 24 * 60 * 60, menuList);
        return SUCCESS;
    }

    public String getEasyUIMenuTree() {
        this.menuList = (List<Element>) CacheManager.get(CachePrefix.TREELIST, String.valueOf(UserHelper.getUserCache().getRoleId())+this.id + "menuList");
        if (this.menuList == null || this.menuList.size() == 0) {
            int roleId = UserHelper.getUserCache().getRoleId();
            String level = SECONDLEVELMENU +"," +THREELEVELMENU;
            menuList = MenuModel.getUserElementByRoleNoAndLevel(roleId, this.id, level);
            CacheManager.set(CachePrefix.TREELIST, String.valueOf(UserHelper.getUserCache().getRoleId())+this.id + "menuList", 7 * 24 * 60 * 60, menuList);
        }
        this.easyUITree = new ArrayList<>();
        for (Element element : menuList) {
            Tree tree = new Tree();
            tree.setId(element.getId());
            tree.setText(element.getName());
            tree.setUrl(UrlHelper.buildLoginSiteUrl(element.getValue()));
            this.easyUITree.add(tree);
        }
        return SUCCESS;
    }
}
