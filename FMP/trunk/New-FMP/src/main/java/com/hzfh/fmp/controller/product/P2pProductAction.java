package com.hzfh.fmp.controller.product;

import com.hzfh.fmp.controller.common.CommonAction;
import com.hzfh.fmp.model.common.PageAlias;

public class P2pProductAction extends CommonAction {
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
        this.setPageAlias(PageAlias.p2pProductList);

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
    public String financeExecute() throws Exception {
        this.setPageAlias(PageAlias.financeProductList);

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
