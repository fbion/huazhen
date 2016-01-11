package com.hzfh.fmp.controller.sales;

import com.hzfh.fmp.controller.common.CommonAction;
import com.hzfh.fmp.model.common.PageAlias;
import com.hzfh.fmp.model.common.enumeration.TagPermission;
import com.hzfh.fmp.model.common.enumeration.TagPermissionType;
import com.hzfh.fmp.model.common.enumeration.TaskStatus;
import com.hzfh.fmp.model.permission.view.TagPermissionView;

/**
 * Created by paul on 15-1-26.
 */
public class TaskAddAction extends CommonAction {
    private int id;
    private int productNo;
    private String pageVar;
    private boolean showEditButton;
    private boolean showAgentRateAddButton;
    private boolean showCommonView;
    private boolean showIncomeRateView;
    private boolean showAgentRateView;

    public void setId(int id) {
        this.id = id;
    }

    public void setProductNo(int productNo) {
        this.productNo = productNo;
    }

    public String getPageVar() {
        return pageVar;
    }

    public boolean isShowEditButton() {
        return showEditButton;
    }

    public boolean isShowAgentRateAddButton() {
        return showAgentRateAddButton;
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

    @Override
    public String execute() throws Exception {
        this.setPageAlias(PageAlias.taskAdd);
        String ret = super.execute();
        if(!ret.equals(SUCCESS))
            return ret;

        this.initPageVar();
        this.initShowCommonView();
        this.initShowIncomeRateView();
        this.initShowAgentRateView();
        this.initShowEditButton();
        this.initShowAgentRateAddButton();

        return SUCCESS;
    }

    private void initPageVar() {
        StringBuilder sb = new StringBuilder();
        sb.append("<script type=\"text/javascript\">");
        sb.append("var PageVar={");
        sb.append(String.format("%1$s:'%2$s',", "ID", this.id));
        sb.append(String.format("%1$s:'%2$s',", "ProductNo", this.productNo));
        sb.append(String.format("%1$s:'%2$s',", "StatusNotReceive", TaskStatus.NOT_RECEIVE));
        sb.append(String.format("%1$s:'%2$s',", "StatusReceived", TaskStatus.RECEIVED));
        sb.append(String.format("%1$s:'%2$s',", "StatusAudit", TaskStatus.AUDIT));
        sb.append("};");

        sb.append("var ElementVar={");
        for (TagPermissionView tagPermissionView : this.getPagePermissionView().getTagPermissionViewList()) {
            sb.append(String.format("%1$s:'%2$s',", tagPermissionView.getTagName(), String.valueOf(tagPermissionView.getTagPermissionType())));
        }
        sb.append("};");
        sb.append("</script>");
        this.pageVar = sb.toString();
    }

    private void initShowCommonView(){
        if(this.id != 0){
            this.showCommonView = true;
        }else{
            this.showCommonView = false;
        }
    }

    private void initShowIncomeRateView(){
        if(this.getPagePermissionView().getTagPermission(TagPermission.PRODUCT_INCOMERATE_VIEW) == TagPermissionType.query){
            this.showIncomeRateView = true;
        }else{
            this.showIncomeRateView = false;
        }
    }

    private void initShowAgentRateView(){
        if(this.getPagePermissionView().getTagPermission(TagPermission.PRODUCT_AGENTRATE_VIEW) == TagPermissionType.query){
            this.showAgentRateView = true;
        }else{
            this.showAgentRateView = false;
        }
    }

    private void initShowAgentRateAddButton(){
        if(this.getPagePermissionView().getTagPermission(TagPermission.TASK_ADDAGENTRATE_BUTTON) == TagPermissionType.query){
            this.showAgentRateAddButton = true;
        }else{
            this.showAgentRateAddButton = false;
        }
    }

    private void initShowEditButton(){
        if(this.getPagePermissionView() != null && this.getPagePermissionView().isEdit()){
            this.showEditButton = true;
        }else{
            this.showEditButton =false;
        }
    }
}
