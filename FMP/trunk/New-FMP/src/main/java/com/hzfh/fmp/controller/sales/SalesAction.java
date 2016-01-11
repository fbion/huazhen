package com.hzfh.fmp.controller.sales;

import com.hzfh.fmp.controller.common.CommonAction;
import com.hzfh.fmp.model.common.PageAlias;
import com.hzfh.fmp.model.common.enumeration.SalesStatus;
import com.hzfh.fmp.model.common.enumeration.TagPermission;
import com.hzfh.fmp.model.common.enumeration.TagPermissionType;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.permission.view.TagPermissionView;
import com.hzfh.fmp.model.sales.SalesModel;

public class SalesAction extends CommonAction {

    private String salesId;
    private String pageVar;
    private boolean showAddButton;
	private boolean showExcelButton;
	private boolean showCustomerName;
    private boolean showEditButton;
    private boolean showDetailButton;

    public boolean isShowEditButton() {
        return showEditButton;
    }


    public boolean isShowDetailButton() {
        return showDetailButton;
    }

    public void setSalesId(String salesId) {
        this.salesId = salesId;
    }

    public String getPageVar() {
        return pageVar;
    }

    public boolean isShowAddButton() {
        return showAddButton;
    }

    public boolean isShowExcelButton() {
		return showExcelButton;
	}
    
    public boolean isShowCustomerName() {
		return showCustomerName;
	}

	@Override
    public String execute() throws Exception {
        this.setPageAlias(PageAlias.salesList);

        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;

        this.initPageVar();
        this.initShowAddButton();
        this.initButton();
        if (this.getPagePermissionView().getTagPermission(TagPermission.EXCEL_SALES) == TagPermissionType.query) {
			this.showExcelButton = true;
		} else {
			this.showExcelButton = false;
		}
        if (this.getPagePermissionView().getTagPermission(TagPermission.SALES_CustomerName) == TagPermissionType.query) {
			this.showCustomerName = true;
		} else {
			this.showCustomerName = false;
		}

        return SUCCESS;
    }
    public String executeOnList() throws Exception {
        this.setPageAlias(PageAlias.salesListOnLine);

        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;

        this.initPageVar();
        this.initShowAddButton();

        if (this.getPagePermissionView().getTagPermission(TagPermission.EXCEL_SALES) == TagPermissionType.query) {
            this.showExcelButton = true;
        } else {
            this.showExcelButton = false;
        }
        if (this.getPagePermissionView().getTagPermission(TagPermission.SALES_CustomerName) == TagPermissionType.query) {
            this.showCustomerName = true;
        } else {
            this.showCustomerName = false;
        }

        return SUCCESS;
    }

    public void initButton(){
        if (this.getPagePermissionView() != null && this.getPagePermissionView().isCreate()) {
            this.showAddButton = true;
        }
        if(this.getPagePermissionView() != null && this.getPagePermissionView().isEdit()){
            this.showEditButton = true;
        }
        if(this.getPagePermissionView() != null && this.getPagePermissionView().isRead()){
            this.showDetailButton = true;
        }
    }
	public String updateStatusBySalesId(){
		int salesId = Integer.parseInt(this.salesId);
		SalesModel.updateStatus(salesId,SalesStatus.account);
		return SUCCESS;
	}
    private void initPageVar(){
        StringBuilder sb = new StringBuilder();
        sb.append("<script type=\"text/javascript\">");
        sb.append("var PageVar={");
        sb.append(String.format("%1$s:'%2$s',", "DeptType", UserHelper.getUserCache().getDeptType()));
        sb.append(String.format("%1$s:'%2$s',", "UserID", UserHelper.getUserCache().getUserId()));
        sb.append("};");

        sb.append("var ElementVar={");
        for (TagPermissionView tagPermissionView : this.getPagePermissionView().getTagPermissionViewList()) {
            sb.append(String.format("%1$s:'%2$s',", tagPermissionView.getTagName(), String.valueOf(tagPermissionView.getTagPermissionType())));
        }
        sb.append("};");
        sb.append("</script>");
        this.pageVar = sb.toString();
    }

    private void initShowAddButton(){
        if(this.getPagePermissionView() != null && this.getPagePermissionView().isCreate()){
            this.showAddButton = true;
        }else{
            this.showAddButton =false;
        }
    }

}
