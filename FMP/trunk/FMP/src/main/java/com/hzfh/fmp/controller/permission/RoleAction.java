package com.hzfh.fmp.controller.permission;

import com.hzfh.fmp.controller.common.CommonAction;
import com.hzfh.fmp.model.common.PageAlias;

public class RoleAction extends CommonAction {

    @Override
    public String execute() throws Exception {
        this.setPageAlias(PageAlias.roleList);

        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;

        return SUCCESS;
    }
    /*public String AssignElements() {
    	this.setPageAlias(PageAlias.rolePrivilegeList);

        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;

        return SUCCESS;
    }*/
}
