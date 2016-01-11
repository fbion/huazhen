package com.hzfh.fmp.controller.sales;

import com.hzfh.api.product.model.P2pProduct;
import com.hzfh.api.sales.model.SalesCreditor;
import com.hzfh.fmp.controller.common.CommonAction;
import com.hzfh.fmp.model.common.PageAlias;
import com.hzfh.fmp.model.common.enumeration.*;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.permission.view.TagPermissionView;
import com.hzfh.fmp.model.product.P2pProductModel;
import com.hzfh.fmp.model.sales.SalesCreditorModel;
import com.hzfh.fmp.model.sales.SalesModel;
import com.hzfh.fmp.model.workFlow.ActRuTaskModel;
import com.hzframework.helper.StringHelper;

public class SalesAddAction extends CommonAction {

    private int id;
    private String pageVar;
    private int empNo;
    private String activitiNo;

    public void setActivitiNo(String activitiNo) {
        this.activitiNo = activitiNo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getPageVar() {
        return pageVar;
    }

    //    Permission to upgrade start from here
    private boolean showEditButton;
    private boolean showStatusButton;
    private boolean showCommonView;
    private boolean showUploadButton;
    private boolean showExamineButton;
    private boolean showCreditorButton;
    private boolean showPaymentRefundButton;

    public boolean isShowPaymentRefundButton() {
        return showPaymentRefundButton;
    }

    public void setShowPaymentRefundButton(boolean showPaymentRefundButton) {
        this.showPaymentRefundButton = showPaymentRefundButton;
    }

    public boolean isShowCreditorButton() {
        return showCreditorButton;
    }

    public void setShowCreditorButton(boolean showCreditorButton) {
        this.showCreditorButton = showCreditorButton;
    }
    private boolean showBuildButton;
    private boolean showRecoveryButton;
    private boolean showConfirmButton;
    private boolean showCreditor;

    public boolean isShowCreditor() {
        return showCreditor;
    }

    public void setShowCreditor(boolean showCreditor) {
        this.showCreditor = showCreditor;
    }

    public boolean isShowConfirmButton() {
        return showConfirmButton;
    }

    public void setShowConfirmButton(boolean showConfirmButton) {
        this.showConfirmButton = showConfirmButton;
    }

    public boolean isShowRecoveryButton() {
        return showRecoveryButton;
    }

    public void setShowRecoveryButton(boolean showRecoveryButton) {
        this.showRecoveryButton = showRecoveryButton;
    }

    public boolean isShowBuildButton() {
        return showBuildButton;
    }

    public boolean showPaymentCkButton;

    public boolean isShowPaymentCkButton() {
        return showPaymentCkButton;
    }

    public boolean isShowExamineButton() {
        return showExamineButton;
    }

    public void setShowExamineButton(boolean showExamineButton) {
        this.showExamineButton = showExamineButton;
    }

    public boolean isShowEditButton() {
        return showEditButton;
    }

    public boolean isShowStatusButton() {
        return showStatusButton;
    }

    public boolean isShowCommonView() {
        return showCommonView;
    }

    public boolean isShowUploadButton() {
        return showUploadButton;
    }

    private int productNo;

    public void setProductNo(int productNo) {
        this.productNo = productNo;
    }

    private int minMony;

    public int getMinMony() {
        return minMony;
    }

    public void setMinMony(int minMony) {
        this.minMony = minMony;
    }

    @Override
    public String execute() throws Exception {
        this.setPageAlias(PageAlias.salesAdd);
        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;
        this.initShowEditButton();
        this.initShowCommonView();
        this.initPageVar();
        this.initShowUploadButton();
        this.initShowStatusButton();
        this.initShowExamineButton();
        if (this.getPagePermissionView().getTagPermission("showPaymentCkButton") == TagPermissionType.query) {
            this.showPaymentCkButton = true;
        } else {
            this.showPaymentCkButton = false;
        }
        return SUCCESS;
    }

    public String executeForProduct() throws Exception {
        this.setPageAlias(PageAlias.salesAddForProduct);
        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;
        this.initShowEditButton();
        this.initShowCommonView();
        this.initPageVar();
        this.initShowUploadButton();
        return SUCCESS;
    }

    public String executeForP2pProduct() throws Exception {
        this.setPageAlias(PageAlias.salesAddForP2pProduct);
        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;
        this.initShowEditButtonForP2pProduct();
        this.initShowCommonView();
        this.initPageVar();
        this.initShowUploadButton();
        this.initShowExamineButtonForP2pProduct();
        this.initShowBuildButton();
        return SUCCESS;
    }

    public String executeDetailForP2pProduct() throws Exception {
        this.setPageAlias(PageAlias.salesDetailForP2pProduct);
        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;
        this.initShowCreditorDetail();
        this.initPageVar();
        this.initShowCommonView();
        this.initShowStatusButton();
        this.initShowExamineButtonForP2pProduct();
        this.initShowBuildButton();
        this.initShowRecoveryButton();
        this.initPaymentRefundButton();
        return SUCCESS;
    }

    public String executeDetailForProduct() throws Exception {
        this.setPageAlias(PageAlias.salesDetailForProduct);
        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;
        this.initPageVar();
        this.initShowCommonView();
        this.initShowStatusButton();
        this.initShowExamineButton();
        return SUCCESS;
    }

    public String executeDetail() throws Exception {
        this.setPageAlias(PageAlias.salesDetail);
        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;
        this.initShowCreditorDetail();
        this.initShowStatusButton();
        this.initPageVar();
        this.initShowCommonView();
        return SUCCESS;
    }

    public String executeDetailOnLine() throws Exception {
        this.setPageAlias(PageAlias.salesDetailOnLine);
        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;
        this.initShowCreditorDetail();
        this.initPageVar();
        this.initShowCommonView();
        return SUCCESS;
    }

    private void initShowExamineButton() {
        if (this.getPagePermissionView().getTagPermission("showExamineButton") == TagPermissionType.query) {
            this.showExamineButton = true;
        } else {
            this.showExamineButton = false;
        }
    }

    private void initShowBuildButton() {
        int userId = UserHelper.getEditUserNo();
        if (this.getPagePermissionView().getTagPermission("showBuildButton") == TagPermissionType.edit) {
            this.showBuildButton = true;
        } else if (!StringHelper.isNullOrEmpty(this.activitiNo) && ActRuTaskModel.getInfoByAciIdAndUserId(this.activitiNo, userId) != null && this.getPagePermissionView().getTagPermission("showBuildButton") == TagPermissionType.query) {
            this.showBuildButton = true;
        } else {
            this.showBuildButton = false;
        }
    }
    private void initShowRecoveryButton() {
        int userId = UserHelper.getEditUserNo();
        if (this.getPagePermissionView().getTagPermission("showRecoveryButton") == TagPermissionType.query) {
            this.showRecoveryButton = true;
        } else if (!StringHelper.isNullOrEmpty(this.activitiNo) && ActRuTaskModel.getInfoByAciIdAndUserId(this.activitiNo, userId) != null && this.getPagePermissionView().getTagPermission("showRecoveryButton") == TagPermissionType.query) {
            this.showRecoveryButton = true;
        } else {
            this.showRecoveryButton = false;
        }
    }


    private void initShowExamineButtonForP2pProduct() {
        int userId = UserHelper.getEditUserNo();
        if (!StringHelper.isNullOrEmpty(this.activitiNo) && ActRuTaskModel.getInfoByAciIdAndUserId(this.activitiNo, userId) != null) {
            this.showExamineButton = true;
        } else {
            this.showExamineButton = false;
        }
    }

    private void initShowEditButton() {
        if (this.getPagePermissionView() != null && this.getPagePermissionView().isEdit()) {
            this.showEditButton = true;
        } else if (this.getPagePermissionView().isRead() && UserHelper.getUserCache().getUserId() == this.empNo) {
            this.showEditButton = true;
        } else {
            this.showEditButton = false;
        }
    }

    private void initShowEditButtonForP2pProduct() {
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
            } else {
                this.showEditButton = false;
            }
        }
    }

    private void initShowCommonView() {
        if (this.id != 0) {
            this.showCommonView = true;
        } else {
            this.showCommonView = false;
        }
    }

    private void initPageVar() {
//    	Sales tSales = new Sales();
//    	P2pProduct tP2pProduct = new P2pProduct();
//    	tSales=SalesModel.getInfo(this.id);
//    	if(this.id!=0){
//    		if(tSales.getProductType()==5){
//            	tP2pProduct=P2pProductModel.getP2pByProductNo(tSales.getProductNo());
//    		}
//    	}
        StringBuilder sb = new StringBuilder();
        sb.append("<script type=\"text/javascript\">");
        sb.append("var PageVar={");
        sb.append(String.format("%1$s:'%2$s',", "StatusCheck", SalesStatus.check));
        sb.append(String.format("%1$s:'%2$s',", "StatusAccount", SalesStatus.account));
        sb.append(String.format("%1$s:'%2$s',", "StatusSuccess", SalesStatus.success));
        sb.append(String.format("%1$s:'%2$s',", "StatusChecking", SalesStatus.CHECKING));
        sb.append(String.format("%1$s:'%2$s',", "StatusSubmit", SalesStatus.Submit));
        sb.append(String.format("%1$s:'%2$s',", "StatusRefund", SalesStatus.refund));
        sb.append(String.format("%1$s:'%2$s',", "StatusDuration", ProductStatus.DURATION));
        sb.append(String.format("%1$s:'%2$s',", "StoreType", StatusType.AGENT_TYPE_STORE));
        sb.append(String.format("%1$s:'%2$s',", "ID", this.id));
        sb.append(String.format("%1$s:'%2$s',", "EmpName", UserHelper.getUserCache().getEmpName()));
        sb.append(String.format("%1$s:'%2$s',", "UserId", UserHelper.getUserCache().getUserId()));
//        if(this.id!=0){
//    		if(tSales.getProductType()==5){
//            	sb.append(String.format("%1$s:'%2$s',", "P2pMinMoney", tP2pProduct.getMinMoney()));
//    		}
//    	}
        sb.append("};");

        sb.append("var ElementVar={");
        for (TagPermissionView tagPermissionView : this.getPagePermissionView().getTagPermissionViewList()) {
            sb.append(String.format("%1$s:'%2$s',", tagPermissionView.getTagName(), String.valueOf(tagPermissionView.getTagPermissionType())));
        }
        sb.append("};");
        sb.append("</script>");
        this.pageVar = sb.toString();
    }

    private void initShowUploadButton() {
        if (this.getPagePermissionView().getTagPermission(TagPermission.SALES_UPLOAD_BUTTON) == TagPermissionType.query && UserHelper.getUserCache().getUserId() == this.empNo) {
            this.showUploadButton = true;
        } else {
            this.showUploadButton = false;
        }
    }
    private void initPaymentRefundButton() {
        if (this.getPagePermissionView().getTagPermission(TagPermission.SALES_PAYMENTREFUND_BUTTON) == TagPermissionType.query) {
            this.showPaymentRefundButton = true;
        } else {
            this.showPaymentRefundButton = false;
        }
    }
    private void initShowStatusButton() {
        if (this.getPagePermissionView().getTagPermission(TagPermission.SALES_STATUS_BUTTON) == TagPermissionType.query && UserHelper.getUserCache().getUserId() == this.empNo) {
            this.showStatusButton = true;
        } else if (this.getPagePermissionView().getTagPermission(TagPermission.SALES_STATUS_BUTTON) == TagPermissionType.edit) {
            this.showStatusButton = true;
        } else {
            this.showStatusButton = false;
        }
    }

    private void initShowCreditorDetail() {
        if (this.getPagePermissionView().getTagPermission(TagPermission.SALES_CREDITOR_BUTTON) == TagPermissionType.edit) {
            this.showCreditorButton = true;
        } else if (this.getPagePermissionView().getTagPermission(TagPermission.SALES_CREDITOR_BUTTON) == TagPermissionType.query && SalesModel.getInfo(this.id).getStatus() == SalesStatus.account) {
            this.showCreditorButton = true;
        } else {
            this.showCreditorButton = false;
        }
        if (this.getPagePermissionView().getTagPermission(TagPermission.SALES_CONFIRM_BUTTON) == TagPermissionType.query) {
            this.showConfirmButton = true;
        } else {
            this.showConfirmButton = false;
        }
        if (this.getPagePermissionView().getTagPermission(TagPermission.SALES_CREDITOR) == TagPermissionType.query&& SalesCreditorModel.getListBySalesNo(this.id).size()!=0) {
            this.showCreditor = true;
        }else if(this.getPagePermissionView().getTagPermission(TagPermission.SALES_CREDITOR) == TagPermissionType.query&&SalesModel.getInfo(this.id).getStatus() == SalesStatus.account){
            this.showCreditor = true;
        }else {
            this.showCreditor = false;
        }

    }

    public String getMinMoney() throws Exception {
        P2pProduct p2pProduct = new P2pProduct();
        p2pProduct = P2pProductModel.getP2pByProductNo(this.productNo);
        if (p2pProduct != null) {
            this.minMony = p2pProduct.getMinMoney();
        } else {
            this.minMony = 0;
        }
        return SUCCESS;
    }
}
