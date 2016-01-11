package com.hzfh.fmp.controller.employee;

import com.hzfh.fmp.controller.common.CommonAction;
import com.hzfh.fmp.model.common.PageAlias;
import com.hzfh.fmp.model.common.enumeration.TagPermission;
import com.hzfh.fmp.model.common.enumeration.TagPermissionType;
import com.hzfh.fmp.model.permission.view.TagPermissionView;

public class EmployeeAction extends CommonAction {

    private boolean showAddButton;

    private String pageVar;

    public boolean isShowAddButton() {
        return showAddButton;
    }

    public void setShowAddButton(boolean showAddButton) {
        this.showAddButton = showAddButton;
    }
    
    private boolean showPositiveButton;

    public boolean isShowPositiveButton() {
        return showPositiveButton;
    }

    public void setPositiveButton(boolean showPositiveButton) {
        this.showPositiveButton = showPositiveButton;
    }
    private boolean showEditButton;

    public boolean isShowEditButton() {
        return showEditButton;
    }

    public void setEditButton(boolean showEditButton) {
        this.showEditButton = showEditButton;
    }

    public String getPageVar() {
        return pageVar;
    }

    private boolean showExcelButton;

    public boolean getShowExcelButton() {
        return showExcelButton;
    }

    public void setShowExcelButton(boolean showExcelButton) {
        this.showExcelButton = showExcelButton;
    }



    @Override
    public String execute() throws Exception {
        this.setPageAlias(PageAlias.employeeList);

        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;

        if (this.getPagePermissionView() != null && this.getPagePermissionView().isCreate()) {
            this.showAddButton = true;
        }
        if (this.getPagePermissionView() != null && this.getPagePermissionView().isEdit()) {
            this.showEditButton = true;
        }
        if (this.getPagePermissionView().getTagPermission(TagPermission.EXCEL_EMPLOYEE) == TagPermissionType.query) {
            this.showExcelButton = true;
        } else {
            this.showExcelButton = false;
        }
        if (this.getPagePermissionView().getTagPermission("showPositiveBtn") == TagPermissionType.query) {
            this.showPositiveButton = true;
        } else {
            this.showPositiveButton = false;
        }

        initPageVar();
        return SUCCESS;
    }

    private void initPageVar() {
        StringBuilder sb = new StringBuilder();
        sb.append("<script type=\"text/javascript\">");

        sb.append("var ElementVar={");
        for (TagPermissionView tagPermissionView : this.getPagePermissionView().getTagPermissionViewList()) {
            sb.append(String.format("%1$s:'%2$s',", tagPermissionView.getTagName(), String.valueOf(tagPermissionView.getTagPermissionType())));
        }
        sb.append("};");
        sb.append("</script>");
        this.pageVar = sb.toString();
    }


}
