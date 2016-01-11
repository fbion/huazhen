package com.hzfh.fmp.controller.employee;

import com.hzfh.fmp.controller.common.CommonAction;
import com.hzfh.fmp.model.common.PageAlias;
import com.hzfh.fmp.model.permission.view.TagPermissionView;

public class AchievementCommissionAction extends CommonAction {
	private boolean showAddButton;

    public boolean isShowAddButton() {
        return showAddButton;
    }
    private String pageVar;
    public String getPageVar() {
        return pageVar;
    }


	@Override
    public String execute() throws Exception {
        this.setPageAlias(PageAlias.achievementCommissionList);

        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;

		if (this.getPagePermissionView() != null && this.getPagePermissionView().isCreate()) {
            this.showAddButton = true;
        }
		initPageVar();
        return SUCCESS;
    }
    private void initPageVar() {
        StringBuilder sb = new StringBuilder();
        sb.append("<script type=\"text/javascript\">");

        sb.append("var ElementVar={");
        for (TagPermissionView tagPermissionView : this.getPagePermissionView().getTagPermissionViewList()) {
            sb.append(String.format("%1$s:'%2$s',", tagPermissionView.getTagName(), String.valueOf(tagPermissionView.getTagPermissionType())));
        }
        sb.append("};");
        sb.append("</script>");
        this.pageVar = sb.toString();
    }
}
