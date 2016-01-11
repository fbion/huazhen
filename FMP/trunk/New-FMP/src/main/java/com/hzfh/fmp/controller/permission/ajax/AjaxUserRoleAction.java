package com.hzfh.fmp.controller.permission.ajax;

import com.hzfh.api.permission.model.UserRole;
import com.hzfh.api.permission.model.query.UserRoleCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.permission.UserRoleModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;


public class AjaxUserRoleAction extends JqGridBaseAction<UserRole> {

    private String userNo;

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    private String roleNo;

    public String getRoleNo() {
        return roleNo;
    }

    public void setRoleNo(String roleNo) {
        this.roleNo = roleNo;
    }

    //mengchong
    private String param1;
    private String[] params;
    private boolean data;

    public String getParam1() {
        return param1;
    }

    public void setParam1(String param1) {
        this.param1 = param1;
    }

    public String[] getParams() {
        return params;
    }

    public void setParams(String[] params) {
        this.params = params;
    }

    public boolean getDate() {
        return data;
    }

    public void setDate(boolean data) {
        this.data = data;
    }

    @Override
    public String execute() throws Exception {
        UserRoleCondition userRoleCondition = new UserRoleCondition();
        userRoleCondition.setPageSize(this.getPageSize());
        userRoleCondition.setPageIndex(this.getPageIndex());
        if (StringHelper.isNullOrEmpty(this.userNo))
            userRoleCondition.setUserNo(0);
        else
            userRoleCondition.setUserNo(Integer.valueOf(this.userNo));

        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        userRoleCondition.setSortItemList(sortItemList);

        PagedList<UserRole> userRolePagedList = UserRoleModel.getPagingList(userRoleCondition);
        this.setResultList(userRolePagedList.getResultList());
        this.setPageCount(userRolePagedList.getPagingInfo().getPageCount());
        this.setPageIndex(userRolePagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(userRolePagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }

    public String edit() {
        UserRole userRole = new UserRole();

        userRole.setUserNo(Integer.parseInt(this.userNo));
        userRole.setRoleNo(Integer.parseInt(this.roleNo));
        userRole.setEditComment(this.getEditComment());
        userRole.setEditUserNo(UserHelper.getEditUserNo());

        if (this.getOper().equalsIgnoreCase("add")) {
            userRole.setInUserNo(UserHelper.getEditUserNo());
            if (UserRoleModel.add(userRole) <= 0) {
                this.setErrCode("add failed");
                this.setErrDesc("add failed");
            }
        } else {
            if (this.getId().isEmpty()) {
                this.setErrCode("NoID");
                this.setErrDesc("NoID");
                return SUCCESS;
            }
            if (this.getOper().equalsIgnoreCase("edit")) {
                userRole.setId(Integer.parseInt(this.getId()));
                if (UserRoleModel.update(userRole) <= 0) {
                    this.setErrCode("update failed");
                    this.setErrDesc("update failed");
                }
            }
        }
        return SUCCESS;
    }

    //updateRoles 正反授权 2015/02/11
    public String updateRoles() {
        try {
            for (String roleId : params) {
                UserRole userRoleRelation = UserRoleModel.getInfo(Integer.parseInt(param1), Integer.parseInt(roleId));
                if (userRoleRelation == null) {
                    //正向授权
                    userRoleRelation = new UserRole();
                    userRoleRelation.setUserNo(Integer.parseInt(this.param1));
                    userRoleRelation.setRoleNo(Integer.parseInt(roleId));
                    userRoleRelation.setEditComment(this.getEditComment());
                    userRoleRelation.setEditUserNo(UserHelper.getEditUserNo());
                    userRoleRelation.setInUserNo(UserHelper.getEditUserNo());
                    UserRoleModel.add(userRoleRelation);
                } else {
                    //负向授权
                    UserRoleModel.delete(userRoleRelation.getId());
                }
            }
            data = true;
        } catch (Exception e) {
            e.printStackTrace();
            data = false;
        }

        return SUCCESS;
    }


}
