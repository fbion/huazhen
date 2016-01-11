package com.hzfh.fmp.controller.product;

import com.hzfh.api.product.model.P2pProduct;
import com.hzfh.fmp.controller.common.CommonAction;
import com.hzfh.fmp.model.common.PageAlias;
import com.hzfh.fmp.model.common.enumeration.ProductStatus;
import com.hzfh.fmp.model.common.enumeration.TagPermission;
import com.hzfh.fmp.model.common.enumeration.TagPermissionType;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.permission.view.TagPermissionView;
import com.hzfh.fmp.model.product.P2pProductModel;
import com.hzfh.fmp.model.workFlow.ActRuTaskModel;
import com.hzframework.helper.StringHelper;

public class P2pProductAddAction extends CommonAction {
    private int id;
    private String pageVar;
    private int productNo;
    private String activitiNo;
    private int empNo;
    private boolean showCommonView;
    private boolean showUploadButton;
    private boolean showEditButton;
    private boolean showExamineButton;
    private boolean showDurationButton;
    private boolean showCancelButton;

    public boolean isShowDurationButton() {
        return showDurationButton;
    }

    public boolean isShowCancelButton() {
        return showCancelButton;
    }

    public boolean isShowExamineButton() {
        return showExamineButton;
    }

    public void setShowEditButton(boolean showEditButton) {
        this.showEditButton = showEditButton;
    }

    public void setShowExamineButton(boolean showExamineButton) {
        this.showExamineButton = showExamineButton;
    }

    public boolean isShowUploadButton() {
        return showUploadButton;
    }

    public boolean isShowCommonView() {
        return showCommonView;
    }

    public boolean isShowEditButton() {
        return showEditButton;
    }

    public void setActivitiNo(String activitiNo) {
        this.activitiNo = activitiNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public void setProductNo(int productNo) {
        this.productNo = productNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPageVar() {
        return pageVar;
    }

    public void setPageVar(String pageVar) {
        this.pageVar = pageVar;
    }

    @Override
    public String execute() throws Exception {
        this.setPageAlias(PageAlias.p2pProductAdd);

        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;
        this.initPageVar();
        this.initShowEdiButton();
        this.initShowExamineButton();
        this.initShowCommonView();
        this.initShowUploadButton();
        return SUCCESS;
    }

    public String executeDetail() throws Exception {
        this.setPageAlias(PageAlias.p2pProductDetail);
        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;

        this.initPageVar();
        this.initShowEdiButton();
        this.initShowExamineButton();
        this.initshowDurationButton();
        return SUCCESS;
    }

    private void initPageVar() {
        StringBuilder sb = new StringBuilder();
        sb.append("<script type=\"text/javascript\">");
        sb.append("var PageVar={");
        sb.append(String.format("%1$s:'%2$s',", "StatusStore", ProductStatus.STORE));
        sb.append(String.format("%1$s:'%2$s',", "StatusPrepare", ProductStatus.PREPARE));
        sb.append(String.format("%1$s:'%2$s',", "StatusPreheat", ProductStatus.PREHEAT));
        sb.append(String.format("%1$s:'%2$s',", "StatusOnSale", ProductStatus.ON_SALE));
        sb.append(String.format("%1$s:'%2$s',", "StatusDuration", ProductStatus.DURATION));
        sb.append(String.format("%1$s:'%2$s',", "StatusFinish", ProductStatus.FINISH));
        sb.append(String.format("%1$s:'%2$s',", "StatusCancel", ProductStatus.CANCEL));
        sb.append(String.format("%1$s:'%2$s',", "StatusStop", ProductStatus.STOP));
        sb.append(String.format("%1$s:'%2$s',", "id", this.id));
        sb.append(String.format("%1$s:'%2$s',", "productNo", this.productNo));
        sb.append(String.format("%1$s:'%2$s',", "UserId", UserHelper.getEditUserNo()));
        sb.append("};");

        sb.append("var ElementVar={");
        for (TagPermissionView tagPermissionView : this.getPagePermissionView().getTagPermissionViewList()) {
            sb.append(String.format("%1$s:'%2$s',", tagPermissionView.getTagName(), String.valueOf(tagPermissionView.getTagPermissionType())));
        }
        sb.append("};");
        sb.append("</script>");
        this.pageVar = sb.toString();
    }

    private void initShowCommonView() {
        if (this.id != 0) {
            this.showCommonView = true;
        } else {
            this.showCommonView = false;
        }
    }

    private void initShowUploadButton() {
        if (this.getPagePermissionView().getTagPermission(TagPermission.P2PPRODUCT_UPLOAD_BUTTON) == TagPermissionType.query) {
            this.showUploadButton = true;
        } else {
            this.showUploadButton = false;
        }
    }

    private void initShowEdiButton() {
        int userId = UserHelper.getEditUserNo();
        if (this.getPagePermissionView() != null && this.getPagePermissionView().isEdit() && StringHelper.isNullOrEmpty(this.activitiNo)) {
            this.showEditButton = true;
        } else {
            if (this.id == 0) {
                this.showEditButton = true;
            } else if (StringHelper.isNullOrEmpty(this.activitiNo) && UserHelper.getUserCache().getUserId() == this.empNo) {
                this.showEditButton = true;
            } else if (ActRuTaskModel.getInfoByAciIdAndUserId(this.activitiNo, userId) != null) {
                this.showEditButton = true;
            } else if (this.getPagePermissionView().getTagPermission(TagPermission.COMMON_SHOWALLEDIT_BUTTON) == TagPermissionType.query) {
                this.showEditButton = true;
            } else {
                this.showEditButton = false;
            }
        }
    }

    private void initShowExamineButton() {
        int userId = UserHelper.getEditUserNo();
        if (!StringHelper.isNullOrEmpty(this.activitiNo) && ActRuTaskModel.getInfoByAciIdAndUserId(this.activitiNo, userId) != null) {
            this.showExamineButton = true;
        } else {
            this.showExamineButton = false;
        }
    }

    private void initshowDurationButton() {
        P2pProduct p2pProduct = P2pProductModel.getInfo(this.id);
        int userId = UserHelper.getEditUserNo();
        if (p2pProduct.getStatus() == ProductStatus.ON_SALE){
            if (this.getPagePermissionView().getTagPermission(TagPermission.P2PPRODUCT_DURATION_BUTTON) == TagPermissionType.edit) {
                this.showDurationButton = true;
            } else if (this.getPagePermissionView().getTagPermission(TagPermission.P2PPRODUCT_DURATION_BUTTON) == TagPermissionType.query && p2pProduct.getInUserNo() == userId) {
                this.showDurationButton = true;
            }
        }else{
            this.showDurationButton = false;
        }

    }

    private void initshowCancelButton() {
        //TODO 需求不明确，暂时不做

    }

}
