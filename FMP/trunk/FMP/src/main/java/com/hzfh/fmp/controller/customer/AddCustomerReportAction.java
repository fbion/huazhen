package com.hzfh.fmp.controller.customer;


import com.hzfh.fmp.controller.common.CommonAction;
import com.hzfh.fmp.model.common.PageAlias;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.permission.view.TagPermissionView;


public class AddCustomerReportAction extends CommonAction {

    private String pageVar;

    public String getPageVar() {
        return pageVar;
    }

    public void setPageVar(String pageVar) {
        this.pageVar = pageVar;
    }

    @Override
    public String execute() throws Exception {
        this.setPageAlias(PageAlias.addCustomerReport);
        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;
        initPageVar();

        return SUCCESS;
    }

    private void initPageVar() {
        StringBuilder sb = new StringBuilder();

        sb.append("<script type=\"text/javascript\">");
        sb.append("var PageVar={");

        sb.append(String.format("%1$s:'%2$s',", "UserId", UserHelper.getEditUserNo()));
        sb.append("};");

        sb.append("var ElementVar={");
        for(TagPermissionView tagPermissionView: this.getPagePermissionView().getTagPermissionViewList()){
            sb.append(String.format("%1$s:'%2$s',", tagPermissionView.getTagName(), String.valueOf(tagPermissionView.getTagPermissionType())));
        }
        sb.append("};");

        sb.append("</script>");

        this.pageVar = sb.toString();
    }
}
