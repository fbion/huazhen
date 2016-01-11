package com.hzfh.fmp.controller.product;

import com.hzfh.fmp.controller.common.CommonAction;
import com.hzfh.fmp.model.common.PageAlias;

public class ProductAction extends CommonAction {
    private boolean showAddButton;

    public boolean isShowAddButton() {
        return showAddButton;
    }

    @Override
    public String execute() throws Exception {
        this.setPageAlias(PageAlias.productList);

        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;

        if(this.getPagePermissionView() != null && this.getPagePermissionView().isCreate()){
            this.showAddButton = true;
        }
        return SUCCESS;
    }


}
