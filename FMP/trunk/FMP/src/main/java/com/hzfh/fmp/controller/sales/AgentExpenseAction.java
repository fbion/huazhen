package com.hzfh.fmp.controller.sales;

import com.hzfh.fmp.controller.common.CommonAction;
import com.hzfh.fmp.model.common.PageAlias;

public class AgentExpenseAction extends CommonAction {

    @Override
    public String execute() throws Exception {
        this.setPageAlias(PageAlias.agentExpenseList);

        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;

        return SUCCESS;
    }
}
