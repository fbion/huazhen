package com.hzfh.fmp.controller.product;

import com.hzfh.fmp.controller.common.CommonAction;
import com.hzfh.fmp.model.common.PageAlias;

public class ProductAction extends CommonAction {
    private boolean showAddButton = false;
    private boolean showEditButton = false;
    private boolean showDetailButton = false;

    public boolean isShowAddButton() {
        return showAddButton;
    }

    public boolean isShowEditButton() {
        return showEditButton;
    }

    public boolean isShowDetailButton() {
        return showDetailButton;
    }

    @Override
    public String execute() throws Exception{
        this.setPageAlias(PageAlias.productList);

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

        return SUCCESS;
    }
}
