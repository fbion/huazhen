package com.hzfh.fmp.controller.employee;

import com.hzfh.fmp.controller.common.CommonAction;
import com.hzfh.fmp.model.common.PageAlias;
import com.hzfh.fmp.model.common.helper.UrlHelper;
import com.hzfh.fmp.model.permission.view.TagPermissionView;

public class SubsidyTotalAction extends CommonAction {
	private boolean showAddButton;

    public boolean isShowAddButton() {
        return showAddButton;
    }
    private String pageVar;
    public String getPageVar() {
        return pageVar;
    }
    
    private String subsidyDetailUrl;
    

    public String getSubsidyDetailUrl() {
		return subsidyDetailUrl;
	}

	public void setSubsidyDetailUrl(String subsidyDetailUrl) {
		this.subsidyDetailUrl = subsidyDetailUrl;
	}

	@Override
    public String execute() throws Exception {
        this.setPageAlias(PageAlias.subsidyTotalList);

        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;

		if (this.getPagePermissionView() != null && this.getPagePermissionView().isCreate()) {
            this.showAddButton = true;
        }
		this.subsidyDetailUrl = UrlHelper.buildEmployeeSiteUrl("/employee/subsidy/list");
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
