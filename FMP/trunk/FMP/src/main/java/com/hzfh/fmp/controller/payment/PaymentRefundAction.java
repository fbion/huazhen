package com.hzfh.fmp.controller.payment;

import com.hzfh.fmp.controller.common.CommonAction;
import com.hzfh.fmp.model.common.PageAlias;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.permission.view.TagPermissionView;

public class PaymentRefundAction extends CommonAction {
    private String pageVar;
	private boolean showAddButton;

    public String getPageVar() {
        return pageVar;
    }

    public boolean isShowAddButton() {
        return showAddButton;
    }

    @Override
    public String execute() throws Exception {
        this.setPageAlias(PageAlias.paymentRefundList);

        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;

        this.initPageVar();

		if (this.getPagePermissionView() != null && this.getPagePermissionView().isCreate()) {
            this.showAddButton = true;
        }

        return SUCCESS;
    }

    private void initPageVar(){
        StringBuilder sb = new StringBuilder();
        sb.append("<script type=\"text/javascript\">");
        sb.append("var PageVar={");
        sb.append(String.format("%1$s:'%2$s',", "DeptType", UserHelper.getUserCache().getDeptType()));
        sb.append("};");

        sb.append("var ElementVar={");
        for (TagPermissionView tagPermissionView : this.getPagePermissionView().getTagPermissionViewList()) {
            sb.append(String.format("%1$s:'%2$s',", tagPermissionView.getTagName(), String.valueOf(tagPermissionView.getTagPermissionType())));
        }
        sb.append("};");
        sb.append("</script>");
        this.pageVar = sb.toString();
    }
}
