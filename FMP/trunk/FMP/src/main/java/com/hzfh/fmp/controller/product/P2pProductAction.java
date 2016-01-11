package com.hzfh.fmp.controller.product;

import com.hzfh.fmp.controller.common.CommonAction;
import com.hzfh.fmp.model.common.PageAlias;

public class P2pProductAction extends CommonAction {

    @Override
    public String execute() throws Exception {
        this.setPageAlias(PageAlias.p2pProductList);

        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;
        return SUCCESS;
    }

    public String financeExecute() throws Exception {
        this.setPageAlias(PageAlias.financeProductList);

        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;
        return SUCCESS;
    }
}
