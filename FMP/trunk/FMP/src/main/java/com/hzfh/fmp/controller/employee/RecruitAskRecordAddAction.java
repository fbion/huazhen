package com.hzfh.fmp.controller.employee;

import org.apache.poi.hssf.record.RecalcIdRecord;

import com.hzfh.api.employee.model.RecruitAskRecord;
import com.hzfh.fmp.controller.common.CommonAction;
import com.hzfh.fmp.model.common.PageAlias;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.employee.RecruitAskRecordModel;
import com.hzfh.fmp.model.permission.view.TagPermissionView;

public class RecruitAskRecordAddAction extends CommonAction {
    public boolean showEditButton;

    public boolean isShowEditButton() {
        return showEditButton;
    }

    public boolean showSubmitButton;
    
    public boolean isShowSubmitButton() {
        return showSubmitButton;
    }
    public boolean showFollowAddButton;
    public boolean showFollowEditButton;
    public boolean isShowFollowAddButton() {
        return showFollowAddButton;
    }
    public boolean isShowFollowEditButton() {
        return showFollowEditButton;
    }
    private String pageVar;

    public String getPageVar() {
        return pageVar;
    }

    private int id;

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String execute() throws Exception {
        this.setPageAlias(PageAlias.recruitAskRecordAdd);
        
        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;

        if (this.getPagePermissionView() != null && this.getPagePermissionView().isCreate())
            this.showSubmitButton = true;
        RecruitAskRecord askRecord = new RecruitAskRecord();
        if(this.id!=0){
            askRecord=RecruitAskRecordModel.getInfo(this.id);
        }
        if(askRecord!=null){
        	if (this.getPagePermissionView() != null && this.getPagePermissionView().isEdit() && askRecord.getInUserNo()==UserHelper.getUserCache().getUserId()) {
                this.showEditButton = true;
                this.showSubmitButton = true;
                this.showFollowAddButton = true;
                this.showFollowEditButton = true;
            }
        }
        



        initPageVar();

        return SUCCESS;
    }

    private void initPageVar() {
        StringBuilder sb = new StringBuilder();

        sb.append("<script type=\"text/javascript\">");
        sb.append("var PageVar={");
        sb.append(String.format("%1$s:'%2$s',", "ID", this.id));
        sb.append(String.format("%1$s:'%2$s',", "UserId", UserHelper.getEditUserNo()));
        sb.append("};");

        sb.append("var ElementVar={");
        for(TagPermissionView tagPermissionView: this.getPagePermissionView().getTagPermissionViewList()){
            sb.append(String.format("%1$s:'%2$s',", tagPermissionView.getTagName(), String.valueOf(tagPermissionView.getTagPermissionType())));
        }
        sb.append("};");

        sb.append("</script>");

        this.pageVar = sb.toString();
    }

}