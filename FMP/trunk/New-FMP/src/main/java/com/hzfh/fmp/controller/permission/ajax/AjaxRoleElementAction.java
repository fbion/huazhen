package com.hzfh.fmp.controller.permission.ajax;


import com.hzfh.api.permission.model.RoleElement;
import com.hzfh.api.permission.model.query.RoleElementCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.common.helper.FlushCacheHelper;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.permission.ElementModel;
import com.hzfh.fmp.model.permission.RoleElementModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;

import java.util.ArrayList;
import java.util.List;


public class AjaxRoleElementAction extends JqGridBaseAction<RoleElement> {
    
	private int  roleNo;
	private int  eleNo;
	public int getRoleNo() {
		return roleNo;
	}
	public void setRoleNo(int roleNo) {
		this.roleNo = roleNo;
	}
	public int getEleNo() {
		return eleNo;
	}
	public void setEleNo(int eleNo) {
		this.eleNo = eleNo;
	}
	private String newItem;
	public String getNewItem() {
		return newItem;
	}
	public void setNewItem(String newItem) {
		this.newItem = newItem;
	}
	private String edit;
	public String getEdit() {
		return edit;
	}
	public void setEdit(String edit) {
		this.edit = edit;
	}
	private String query;
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	private String del;
	public String getDel() {
		return del;
	}
	public void setDel(String del) {
		this.del = del;
	}
	
	private RoleElement roleElementInfo;
	public RoleElement getRoleElementInfo() {
		return roleElementInfo;
	}
	public void setRoleElementInfo(RoleElement roleElementInfo) {
		this.roleElementInfo = roleElementInfo;
	}
	
	private String editCommentElement;
	
	public String getEditCommentElement() {
		return editCommentElement;
	}
	@Override
    public String execute() throws Exception{
    	RoleElementCondition roleElementCondition = new RoleElementCondition();
        roleElementCondition.setPageSize(this.getPageSize());
        roleElementCondition.setPageIndex(this.getPageIndex());

        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        roleElementCondition.setSortItemList(sortItemList);

        PagedList<RoleElement> roleElementPagedList= RoleElementModel.getPagingList(roleElementCondition);
        this.setResultList(roleElementPagedList.getResultList());
        this.setPageCount(roleElementPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(roleElementPagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(roleElementPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }

    public String edit(){
    	RoleElement roleElement = new RoleElement();
    	RoleElement roleEle = RoleElementModel.getInfo(Integer.parseInt(this.getId()));
    	roleElement.setRoleNo(roleEle.getRoleNo());
		roleElement.setEleNo(roleEle.getEleNo());
		roleElement.setNewItem(Byte.valueOf(this.newItem));
		roleElement.setEdit(Byte.valueOf(this.edit));
		roleElement.setQuery(Byte.valueOf(this.query));
		roleElement.setDel(Byte.valueOf(this.del));
		roleElement.setEditComment(roleEle.getEditComment());
		roleElement.setEditUserNo(UserHelper.getEditUserNo());
		roleElement.setId(Integer.parseInt(this.getId()));
		int n=RoleElementModel.update(roleElement);
		/*if(n!=0){
			CookieManager cookieManager = new CookieManager();
			CacheManager.set(CachePrefix.MENUTREE, cookieManager.getCookieValue("userId")+"treeLists", 7*24*60*60, treeLists);
		}*/
        /*RoleElement roleElement = new RoleElement();
        
		roleElement.setRoleNo(Integer.valueOf(this.roleNo));
		roleElement.setEleNo(Integer.valueOf(this.eleNo));
		roleElement.setNewItem(Byte.valueOf(this.newItem));
		roleElement.setEdit(Byte.valueOf(this.edit));
		roleElement.setQuery(Byte.valueOf(this.query));
		roleElement.setDel(Byte.valueOf(this.del));
		roleElement.setEditComment(this.getEditComment());
		roleElement.setEditUserNo(UserHelper.getEditUserNo());

        if (this.getOper().equalsIgnoreCase("add")) {
            roleElement.setInUserNo(UserHelper.getEditUserNo());
            if (RoleElementModel.add(roleElement )<=0){
                this.setErrCode("add failed");
                this.setErrDesc("add failed");
            }
        }
        else
        {
            if (this.getId().isEmpty()) { 
                this.setErrCode("NoID");
                this.setErrDesc("NoID");
            }
            else{
                if (this.getOper().equalsIgnoreCase("edit")) {
                    roleElement.setId(Integer.parseInt(this.getId()));
                    if (RoleElementModel.update(roleElement) <= 0){
                        this.setErrCode("update failed");
                        this.setErrDesc("update failed");
                    }
                }
            }
        }*/

        return SUCCESS;
    }
    public String getInfo(){
		try {
			String alias = ElementModel.getInfo(eleNo).getAlias();
			this.editCommentElement = ElementModel.getInfo(eleNo).getEditComment();
			RoleElement roleElement = RoleElementModel.getRoleElementByRoleIdAndAlias(alias, roleNo);
			this.roleElementInfo = roleElement;
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
    	return SUCCESS;
    }
    
    public String flushMenuTree(){
    	try {
			FlushCacheHelper.flushMenuTree(roleNo);
             this.setErrDesc("缓存刷新成功！");
		} catch (Exception e) {
			this.setErrCode("flush failed");
            this.setErrDesc("缓存刷新失败！");
            e.printStackTrace();
		}
    	return SUCCESS;
    }
}
