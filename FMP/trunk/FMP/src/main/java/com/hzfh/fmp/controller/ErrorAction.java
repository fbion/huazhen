package com.hzfh.fmp.controller;

import com.hzfh.fmp.controller.common.CommonAction;
import com.hzfh.fmp.model.common.PageAlias;
import com.hzframework.helper.StringHelper;
import com.opensymphony.xwork2.ActionContext;

import java.util.Map;

/**
 * Created by paul on 15-4-10.
 */
public class ErrorAction extends CommonAction {

    @Override
    public String execute() throws Exception {
        this.setPageAlias(PageAlias.error);

        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;

        Map<String, Object> session = ActionContext.getContext().getSession();
        if (session.get("exception") != null){
            this.setException(session.get("exception").toString());
            session.remove("exception");
        }
        if (session.get("exceptionStack") != null){
            this.setExceptionStack(session.get("exceptionStack").toString());
            session.remove("exceptionStack");
        }
        return SUCCESS;
    }

    public String errorPage() throws Exception{
        this.setPageAlias(PageAlias.errorPage);

        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;

        return SUCCESS;
    }
}
