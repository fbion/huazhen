package com.hzfh.fmp.model.common.helper;

import com.hzfh.api.baseInfo.model.DicData;
import com.hzfh.api.baseInfo.model.DicType;
import com.hzfh.api.permission.model.Element;
import com.hzfh.api.permission.model.query.MenuCondition;
import com.hzfh.fmp.model.baseInfo.DicDataModel;
import com.hzfh.fmp.model.baseInfo.DicTypeModel;
import com.hzfh.fmp.model.common.TreeItem;
import com.hzfh.fmp.model.common.TreeMenu;
import com.hzfh.fmp.model.common.cache.CacheManager;
import com.hzfh.fmp.model.common.cache.CachePrefix;
import com.hzfh.fmp.model.common.view.ListItem;
import com.hzfh.fmp.model.permission.ElementModel;
import com.hzfh.fmp.model.permission.MenuModel;

import java.util.ArrayList;
import java.util.List;

public class FlushHelper {

    public  static void flushMenuTree(int roleNo){
    	List<Element> firstLevelMenu=ElementModel.get1stLevelMenuList();
    	
    	MenuCondition menuCondition = new MenuCondition();
    	menuCondition.setRoleNo(roleNo);
    	List<Element> elementList;
			elementList = MenuModel.getUserElement(menuCondition);
			//循环privilegeList，将用户赋予相应权限
        	
        	//整个菜单的list
			List<TreeMenu> treeLists= new ArrayList<TreeMenu>();
        	
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
							treeItem.setUrl(UrlHelper.buildLoginSiteUrl(element2.getValue()));
							treeItems.add(treeItem);
						}
					}
					if(treeItems.size()>0){
						treeMenu.setName(element1.getName());
						treeMenu.setTreeItems(treeItems);
						treeLists.add(treeMenu);
					}
        	}
    	CacheManager.set(CachePrefix.MENUTREE, String.valueOf(roleNo)+"treeLists", 7*24*60*60, treeLists);
    	
    }

    
    /**
     * 刷新缓存
     * 刷新全部字典缓存
     * */
    public static void flushEnumListForDictionary(){
    	List<DicType> dicTypeList  = new ArrayList<DicType>();
    	dicTypeList = DicTypeModel.getList();
    	if (dicTypeList!=null) {
			for (DicType dicType : dicTypeList) {
				getDicDataListByType(dicType.getId());
			}
		}
    	
    }
    /**
     * 刷新缓存
     * 字典缓存刷新方法
     * */
    public static void getDicDataListByType(int dicTypeNo) {
		List<DicData> dicDataList = DicDataModel.getDicDataListByType(dicTypeNo);
		if (dicDataList!=null) {
			List<ListItem> itemList = new ArrayList<ListItem>();
			itemList = ListItemHelper.getListItemList("value", "code", dicDataList);
			CacheManager.set(CachePrefix.LIST_ITEM, "getDicDataListByType"+ String.valueOf(dicTypeNo), 24 * 60 * 60 * 7, itemList);
		}
	}
    
    

}
