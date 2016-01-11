package com.hzfh.fmp.controller.customer;

import com.hzfh.fmp.controller.common.CommonAction;
import com.hzfh.fmp.model.common.PageAlias;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.common.properties.DictionaryHelper;
import com.hzfh.fmp.model.permission.view.TagPermissionView;

public class CustomerCompanyAddAction extends CommonAction {

	public boolean showEditButton;

	public boolean isShowEditButton() {
		return showEditButton;
	}

	public boolean showSubmitButton;

	public boolean isShowSubmitButton() {
		return showSubmitButton;
	}

	private String pageVar;
	private int id;

	public String getPageVar() {
		return pageVar;
	}

	public void setPageVar(String pageVar) {
		this.pageVar = pageVar;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String execute() throws Exception {
		this.setPageAlias(PageAlias.customerCompanyAdd);
		String ret = super.execute();
		if (!ret.equals(SUCCESS))
			return ret;

		if (this.getPagePermissionView() != null
				&& this.getPagePermissionView().isCreate())
			this.showSubmitButton = true;

		if (this.getPagePermissionView() != null
				&& this.getPagePermissionView().isEdit()) {
			this.showEditButton = true;
			this.showSubmitButton = true;
		}

		this.initPageVar();
		return SUCCESS;
	}
	public String executeDetail() throws Exception {
        this.setPageAlias(PageAlias.customerCompanyDetail);
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
		sb.append(String.format("%1$s:'%2$s',", "ID", this.id));
		sb.append(String.format("%1$s:'%2$s',", "CustomerType",	DictionaryHelper.DIC_CUSTOMERCOMPANY));
		sb.append(String.format("%1$s:'%2$s',", "UserId", UserHelper.getUserCache().getUserId()));
		sb.append("};");

		sb.append("var ElementVar={");
		for (TagPermissionView tagPermissionView : this.getPagePermissionView().getTagPermissionViewList()) {
			sb.append(String.format("%1$s:'%2$s',",tagPermissionView.getTagName(),String.valueOf(tagPermissionView.getTagPermissionType())));
		}
		sb.append("};");

		sb.append("</script>");
		this.pageVar = sb.toString();
	}

}
