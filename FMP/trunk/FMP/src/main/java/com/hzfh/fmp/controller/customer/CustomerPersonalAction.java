package com.hzfh.fmp.controller.customer;

import com.hzfh.fmp.controller.common.CommonAction;
import com.hzfh.fmp.model.common.PageAlias;
import com.hzfh.fmp.model.common.enumeration.TagPermission;
import com.hzfh.fmp.model.common.enumeration.TagPermissionType;
import com.hzfh.fmp.model.permission.view.TagPermissionView;

public class CustomerPersonalAction extends CommonAction {

	private boolean showAddButton;
    private String pageVar;
    private boolean showExcelButton;
    private boolean showUpdateManagerNo;
    
    public boolean isShowUpdateManagerNo() {
		return showUpdateManagerNo;
	}

	public boolean isShowExcelButton() {
		return showExcelButton;
	}

	public boolean isShowAddButton() {
        return showAddButton;
    }

    public String getPageVar() {
        return pageVar;
    }

    @Override
    public String execute() throws Exception {
        this.setPageAlias(PageAlias.customerPersonalList);

        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;

        if (this.getPagePermissionView() != null && this.getPagePermissionView().isCreate()) {
            this.showAddButton = true;
        }
        
        if (this.getPagePermissionView().getTagPermission(TagPermission.EXCEL_CUSTOMER_PERSONAL) == TagPermissionType.query) {
			this.showExcelButton = true;
		} else {
			this.showExcelButton = false;
		}
        
        if(this.getPagePermissionView().getTagPermission(TagPermission.UPDATE_MANAGER_NO) == TagPermissionType.query){
            this.showUpdateManagerNo = true;
        }else{
            this.showUpdateManagerNo = false;
        }
        
        initPageVar();
        return SUCCESS;
    }
    public String executeEffective() throws Exception {
        this.setPageAlias(PageAlias.customerPersonalListEffective);

        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;
        if (this.getPagePermissionView().getTagPermission(TagPermission.SHOW_EXCAL_BUTTON) == TagPermissionType.query) {
            this.showExcelButton = true;
        } else {
            this.showExcelButton = false;
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
