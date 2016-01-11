package com.hzfh.fmp.controller.baseInfo;

import com.hzfh.fmp.controller.common.CommonAction;
import com.hzfh.fmp.model.common.PageAlias;
import com.hzfh.fmp.model.common.helper.LogHelper;

public class LetterAction extends CommonAction {
    public static final LogHelper logger = LogHelper.getLogger(LetterAction.class.getName());
    private boolean showAddButton;

    public boolean isShowAddButton() {
        return showAddButton;
    }

    @Override
    public String execute() throws Exception {
        this.setPageAlias(PageAlias.letterList);
        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;
        if (this.getPagePermissionView() != null && this.getPagePermissionView().isCreate()) {
            this.showAddButton = true;
        }
        return SUCCESS;
    }
    public String remindExecute() throws Exception {
        this.setPageAlias(PageAlias.remindList);
        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;
        if (this.getPagePermissionView() != null && this.getPagePermissionView().isCreate()) {
            this.showAddButton = true;
        }
        return SUCCESS;
    }

   
}
