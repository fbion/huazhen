package com.hzfh.fmp.controller.product;

import com.hzfh.fmp.controller.common.CommonAction;
import com.hzfh.fmp.model.common.PageAlias;
import com.hzfh.fmp.model.common.enumeration.ProductStatus;
import com.hzfh.fmp.model.common.enumeration.TagPermission;
import com.hzfh.fmp.model.common.enumeration.TagPermissionType;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.permission.view.TagPermissionView;
import com.hzfh.fmp.model.product.ProductModel;
import com.hzfh.fmp.model.workFlow.ActRuTaskModel;
import com.hzframework.helper.StringHelper;

/**
 * Created by paul on 15-1-15.
 */
public class ProductAddAction extends CommonAction {

    private int id;
    private int empNo;
    private String pageVar;
    private String activitiNo;
    private boolean showCommonView;
    private boolean showIncomeRateView;
    private boolean showAgentRateView;
    private boolean showStatusButton;
    private boolean showEditButton;
    private boolean showIncomeRateAddButton;
    private boolean showProductExamine;
    private boolean showExamineDirect;
    private boolean showExamineChannel;
    private boolean showExamineButton;
    private boolean showCancelButton;

    public boolean isShowCancelButton() {
        return showCancelButton;
    }

    public void setActivitiNo(String activitiNo) {
        this.activitiNo = activitiNo;
    }

    public boolean isShowExamineButton() {
        return showExamineButton;
    }

    public boolean isShowProductExamine() {
        return showProductExamine;
    }

    public void setShowProductExamine(boolean showProductExamine) {
        this.showProductExamine = showProductExamine;
    }

    public boolean isShowExamineDirect() {
        return showExamineDirect;
    }

    public void setShowExamineDirect(boolean showExamineDirect) {
        this.showExamineDirect = showExamineDirect;
    }

    public boolean isShowExamineChannel() {
        return showExamineChannel;
    }

    public void setShowExamineChannel(boolean showExamineChannel) {
        this.showExamineChannel = showExamineChannel;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getPageVar() {
        return pageVar;
    }

    public boolean isShowCommonView() {
        return showCommonView;
    }

    public boolean isShowIncomeRateView() {
        return showIncomeRateView;
    }

    public boolean isShowAgentRateView() {
        return showAgentRateView;
    }

    public boolean isShowStatusButton() {
        return showStatusButton;
    }

    public boolean isShowEditButton() {
        return showEditButton;
    }

    public boolean isShowIncomeRateAddButton() {
        return showIncomeRateAddButton;
    }

    private boolean showExamineEditButton;

    public boolean isShowExamineEditButton() {
        return showExamineEditButton;
    }

    public void setShowExamineEditButton(boolean showExamineEditButton) {
        this.showExamineEditButton = showExamineEditButton;
    }

    @Override
    public String execute() throws Exception {
        this.setPageAlias(PageAlias.productAdd);
        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;

        this.initPageVar();
        this.initShowCommonView();
        this.initShowAgentRateView();
        this.initShowIncomeRateView();
        this.initShowEdiButton();
        this.initShowStatusButton();
        this.initShowExamineButton();
        this.intiShowIncomeRateAddButton();
        this.initShowProductExamine();
        this.initShowCancelButton();
        this.initShowExamineDirect();
        this.initShowExamineChannel();
        this.initShowExamineEditButton();
        return SUCCESS;
    }

    public String executeDetail() throws Exception {
        this.setPageAlias(PageAlias.productDetail);
        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;

        this.initPageVar();
        this.initShowEdiButton();
        this.initShowCancelButton();
        this.initShowExamineButton();
        this.initShowProductExamine();
        this.initShowExamineDirect();
        this.initShowExamineChannel();

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
        sb.append(String.format("%1$s:'%2$s',", "ID", this.id));
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

    private void initShowIncomeRateView() {
        if (this.getPagePermissionView().getTagPermission(TagPermission.PRODUCT_INCOMERATE_VIEW) == TagPermissionType.query) {
            this.showIncomeRateView = true;
        } else {
            this.showIncomeRateView = false;
        }
    }

    private void initShowAgentRateView() {
        if (this.getPagePermissionView().getTagPermission(TagPermission.PRODUCT_AGENTRATE_VIEW) == TagPermissionType.query) {
            this.showAgentRateView = true;
        } else {
            this.showAgentRateView = false;
        }
    }

    private void initShowExamineEditButton() {

        if (this.getPagePermissionView().getTagPermission(TagPermission.EXAMINE_EDIT_BUTTON) == TagPermissionType.query) {
            this.showExamineEditButton = true;
        } else {
            this.showExamineEditButton = false;
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
            }else if (UserHelper.getUserCache().getUserId() == this.empNo&&ProductModel.getInfo(this.id).getStatus()==20) {
                this.showEditButton = true;
            } else {
                this.showEditButton = false;
            }
        }
    }

    private void initShowStatusButton() {
        if (this.getPagePermissionView().getTagPermission(TagPermission.PRODUCT_STATUS_BUTTON) == TagPermissionType.query && UserHelper.getUserCache().getUserId() == this.empNo) {
            this.showStatusButton = true;
        } else if (this.getPagePermissionView().getTagPermission(TagPermission.COMMON_SHOWALLEDIT_BUTTON) == TagPermissionType.query) {
            this.showStatusButton = true;
        } else {
            this.showStatusButton = false;
        }
    }

    private void intiShowIncomeRateAddButton() {
        if (this.getPagePermissionView().getTagPermission(TagPermission.SALES_ADDINCOMERATE_BUTTON) == TagPermissionType.query && UserHelper.getUserCache().getUserId() == this.empNo) {
            this.showIncomeRateAddButton = true;
        } else if (this.getPagePermissionView().getTagPermission(TagPermission.COMMON_SHOWALLEDIT_BUTTON) == TagPermissionType.query) {
            this.showIncomeRateAddButton = true;
        } else {
            this.showIncomeRateAddButton = false;
        }
    }

    private void initShowProductExamine() {
        if (this.getPagePermissionView().getTagPermission(TagPermission.PRODUCT_EXAMINE) == TagPermissionType.query && UserHelper.getUserCache().getUserId() == this.empNo) {
            this.showProductExamine = true;
        } else if (this.getPagePermissionView().getTagPermission(TagPermission.PRODUCT_EXAMINE) == TagPermissionType.query) {
            this.showProductExamine = true;
        } else {
            this.showProductExamine = false;
        }
    }

    private void initShowExamineDirect() {
        if (this.getPagePermissionView().getTagPermission(TagPermission.EXAMINE_DIRECT) == TagPermissionType.query && UserHelper.getUserCache().getUserId() == this.empNo) {
            this.showExamineDirect = true;
        } else if (this.getPagePermissionView().getTagPermission(TagPermission.EXAMINE_DIRECT) == TagPermissionType.query) {
            this.showExamineDirect = true;
        } else {
            this.showExamineDirect = false;
        }
    }

    private void initShowExamineChannel() {
        if (this.getPagePermissionView().getTagPermission(TagPermission.EXAMINE_CHANNEL) == TagPermissionType.query && UserHelper.getUserCache().getUserId() == this.empNo) {
            this.showExamineChannel = true;
        } else if (this.getPagePermissionView().getTagPermission(TagPermission.EXAMINE_CHANNEL) == TagPermissionType.query) {
            this.showExamineChannel = true;
        } else {
            this.showExamineChannel = false;
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

    private void initShowCancelButton() {
        if (UserHelper.getUserCache().getUserId() == this.empNo && ProductModel.getInfo(this.id).getStatus() <= ProductStatus.ON_SALE) {
            this.showCancelButton = true;
        } else {
            this.showCancelButton = false;
        }
    }
}

