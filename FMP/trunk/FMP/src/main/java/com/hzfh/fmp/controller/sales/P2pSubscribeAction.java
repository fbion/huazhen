package com.hzfh.fmp.controller.sales;

import com.hzfh.fmp.controller.common.CommonAction;
import com.hzfh.fmp.model.common.PageAlias;
import com.hzfh.fmp.model.common.helper.UserHelper;

public class P2pSubscribeAction extends CommonAction {

    private String pageVar;

    public String getPageVar() {
        return pageVar;
    }

    public void setPageVar(String pageVar) {
        this.pageVar = pageVar;
    }

    @Override
    public String execute() throws Exception {
        this.setPageAlias(PageAlias.p2pSubscribeList);

        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;
        this.initPageVar();

        return SUCCESS;
    }

    private void initPageVar() {
        StringBuilder sb = new StringBuilder();

        sb.append("<script type=\"text/javascript\">");
        sb.append("var PageVar={");
        sb.append(String.format("%1$s:'%2$s',", "UserId", UserHelper.getEditUserNo()));

        sb.append("};");
        sb.append("</script>");

        this.pageVar = sb.toString();
    }
}
