package com.hzfh.fmp.controller.baseInfo;

import com.hzfh.fmp.controller.common.CommonAction;
import com.hzfh.fmp.model.common.PageAlias;

/**
 * Created by Administrator on 2015/10/14.
 */
public class ImportDataAction extends CommonAction{
    @Override
    public String execute() throws Exception {
        this.setPageAlias(PageAlias.importData);

        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;

        return SUCCESS;
    }
}
