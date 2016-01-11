package com.hzfh.fmp.controller.permission;

import com.hzfh.fmp.controller.common.CommonAction;
import com.hzfh.fmp.model.common.PageAlias;


public class DataManageAction extends CommonAction {

	@Override
    public String execute() throws Exception {
        this.setPageAlias(PageAlias.dataManage);

        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;

        return SUCCESS;
    }
}
