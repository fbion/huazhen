package com.hzfh.o2o.controller.common;

/**
 * Created by ulei0 on 2015/9/23.
 */
public class CommonAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;
        this.buildCss();
        this.buildJs();
        return SUCCESS;
    }

}
