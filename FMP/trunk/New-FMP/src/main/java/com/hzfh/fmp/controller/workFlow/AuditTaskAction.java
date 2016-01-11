package com.hzfh.fmp.controller.workFlow;

import com.hzfh.fmp.controller.common.CommonAction;
import com.hzfh.fmp.model.common.PageAlias;

public class AuditTaskAction extends CommonAction {
	private boolean showAddButton;
	private boolean showEditButton = false;

    public boolean isShowAddButton() {
        return showAddButton;
    }
    
    public boolean isShowEditButton() {
        return showEditButton;
    }

    @Override
    public String execute() throws Exception {
        this.setPageAlias(PageAlias.auditTaskList);

        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;

		if (this.getPagePermissionView() != null && this.getPagePermissionView().isCreate()) {
            this.showAddButton = true;
        }
		
		if(this.getPagePermissionView() != null && this.getPagePermissionView().isEdit()){
            this.showEditButton = true;
        }
        return SUCCESS;
    }
}
