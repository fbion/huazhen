package com.hzfh.fmp.controller.sales;

import com.hzfh.fmp.controller.common.CommonAction;
import com.hzfh.fmp.model.common.PageAlias;

public class p2pSubscribeAssignAction extends CommonAction {
    @Override
    public String execute() throws Exception {
        this.setPageAlias(PageAlias.p2pSubscribeAssign);

        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;
        return SUCCESS;
    }

}
