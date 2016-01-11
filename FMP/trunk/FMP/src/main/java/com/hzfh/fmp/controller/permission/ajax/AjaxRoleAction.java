package com.hzfh.fmp.controller.permission.ajax;

import com.hzfh.api.permission.model.Element;
import com.hzfh.api.permission.model.Role;
import com.hzfh.api.permission.model.RoleElement;
import com.hzfh.api.permission.model.query.RoleCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.permission.ElementModel;
import com.hzfh.fmp.model.permission.RoleElementModel;
import com.hzfh.fmp.model.permission.RoleModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;


public class AjaxRoleAction extends JqGridBaseAction<Role> {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String comment;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String execute() throws Exception {
        RoleCondition roleCondition = new RoleCondition();
        roleCondition.setPageSize(this.getPageSize());
        roleCondition.setPageIndex(this.getPageIndex());
        if (!StringHelper.isNullOrEmpty(this.name))
            roleCondition.setName(this.name);

        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        roleCondition.setSortItemList(sortItemList);

        PagedList<Role> rolePagedList = RoleModel.getPagingList(roleCondition);
        this.setResultList(rolePagedList.getResultList());
        this.setPageCount(rolePagedList.getPagingInfo().getPageCount());
        this.setPageIndex(rolePagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(rolePagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }

    public String edit() {
        Role role = new Role();
        role.setName(this.name);
        role.setComment(this.comment);
        role.setEditComment(this.getEditComment());
        role.setEditUserNo(UserHelper.getEditUserNo());
        if (this.getOper().equalsIgnoreCase("add")) {
            role.setInUserNo(UserHelper.getEditUserNo());
            int id = RoleModel.add(role);
            if (id <= 0) {
                this.setErrCode("add failed");
                this.setErrDesc("add failed");
                return SUCCESS;
            }
            List<Element> elementList = ElementModel.getList();
            for (Element element : elementList) {
                RoleElement roleElement = new RoleElement();
                roleElement.setEleNo(element.getId());
                roleElement.setRoleNo(id);
                roleElement.setEditUserNo(UserHelper.getEditUserNo());
                roleElement.setNewItem((byte) 0);
                roleElement.setQuery((byte) 0);
                roleElement.setDel((byte) 0);
                roleElement.setEdit((byte) 0);
                if (RoleElementModel.add(roleElement) <= 0) {
                    this.setErrCode("add roleElement failed");
                    this.setErrDesc("add roleElement failed");
                    return SUCCESS;
                }
            }
        } else {
            if (this.getId().isEmpty()) {
                this.setErrCode("NoID");
                this.setErrDesc("NoID");
                return SUCCESS;
            }
            if (this.getOper().equalsIgnoreCase("edit")) {
                role.setId(Integer.parseInt(this.getId()));
                if (RoleModel.update(role) <= 0) {
                    this.setErrCode("update failed");
                    this.setErrDesc("update failed");
                }
            }
        }

        return SUCCESS;
    }

}
