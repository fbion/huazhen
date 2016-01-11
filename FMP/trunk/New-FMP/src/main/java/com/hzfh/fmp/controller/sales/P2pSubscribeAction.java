package com.hzfh.fmp.controller.sales;

import com.hzfh.fmp.controller.common.CommonAction;
import com.hzfh.fmp.model.common.PageAlias;
import com.hzfh.fmp.model.common.enumeration.TagPermissionType;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.permission.view.TagPermissionView;

public class P2pSubscribeAction extends CommonAction {
    private String pageVar;
    private boolean showAddButton = false;
    private boolean showEditButton = false;
    private boolean showDetailButton = false;
    private boolean showAssignEmpButton = false;

    public boolean isShowAssignEmpButton() {
        return showAssignEmpButton;
    }

    public boolean isShowAddButton() {
        return showAddButton;
    }

    public boolean isShowEditButton() {
        return showEditButton;
    }

    public boolean isShowDetailButton() {
        return showDetailButton;
    }

    public String getPageVar() {
        return pageVar;
    }

    public void setPageVar(String pageVar) {
        this.pageVar = pageVar;
    }

    @Override
    public String execute() throws Exception {
        this.setPageAlias(PageAlias.p2pSubscribeList);

        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;

        if (this.getPagePermissionView() != null && this.getPagePermissionView().isCreate()) {
            this.showAddButton = true;
        }
        if(this.getPagePermissionView() != null && this.getPagePermissionView().isEdit()){
            this.showEditButton = true;
        }
        if(this.getPagePermissionView() != null && this.getPagePermissionView().isRead()){
            this.showDetailButton = true;
        }
        this.initPageVar();
        this.initShowAssignEmpButton();
        return SUCCESS;
    }

    private void initPageVar() {
        StringBuilder sb = new StringBuilder();

        sb.append("<script type=\"text/javascript\">");
        sb.append("var PageVar={");
        sb.append(String.format("%1$s:'%2$s',", "UserId", UserHelper.getEditUserNo()));
        sb.append("};");

        sb.append("var ElementVar={");
        for (TagPermissionView tagPermissionView : this.getPagePermissionView().getTagPermissionViewList()) {
            sb.append(String.format("%1$s:'%2$s',", tagPermissionView.getTagName(), String.valueOf(tagPermissionView.getTagPermissionType())));
        }
        sb.append("};");
        sb.append("</script>");

        this.pageVar = sb.toString();
    }

    private void initShowAssignEmpButton(){
        if (this.getPagePermissionView().getTagPermission("showAssignEmpButton") == TagPermissionType.query) {
            this.showAssignEmpButton = true;
        }
    }
}
