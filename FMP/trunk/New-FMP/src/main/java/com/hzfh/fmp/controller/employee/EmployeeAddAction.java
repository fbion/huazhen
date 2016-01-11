package com.hzfh.fmp.controller.employee;

import com.hzfh.api.employee.model.Employee;
import com.hzfh.fmp.controller.common.CommonAction;
import com.hzfh.fmp.model.common.PageAlias;
import com.hzfh.fmp.model.common.enumeration.StatusType;
import com.hzfh.fmp.model.common.enumeration.TagPermission;
import com.hzfh.fmp.model.common.enumeration.TagPermissionType;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.employee.EmployeeModel;
import com.hzfh.fmp.model.permission.view.TagPermissionView;
import com.hzframework.helper.StringHelper;
import com.opensymphony.xwork2.ActionContext;

import java.util.Map;

public class EmployeeAddAction extends CommonAction {
    private String pageVar;
    private int id;

    public String getPageVar() {
        return pageVar;
    }

    public void setId(int id) {
        this.id = id;
    }

    private boolean showEditButton;
    private boolean showCommonView;
    private boolean showCheckButton;
    private boolean showSubmitButton;

    public boolean isShowSubmitButton() {
        return showSubmitButton;
    }

    public boolean isShowCheckButton() {
        return showCheckButton;
    }


    public boolean isShowEditButton() {
        return showEditButton;
    }

    public boolean isShowCommonView() {
        return showCommonView;
    }

    @Override
    public String execute() throws Exception {
        this.setPageAlias(PageAlias.employeeAdd);
        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;

        Map<String,Object> session = ActionContext.getContext().getSession();
        if(session.get("empId") != null){
            this.id = Integer.valueOf(session.get("empId").toString());
            session.remove("empId");
        }
        this.initPageVar();
        this.initShowEditButton();
        this.initShowCommonView();
        this.initShowCheckButton();
        this.initShowSubmitButton();



        return SUCCESS;
    }

    private void initPageVar() {
        StringBuilder sb = new StringBuilder();
        sb.append("<script type=\"text/javascript\">");
        sb.append("var PageVar={");
        sb.append(String.format("%1$s:'%2$s',", "ID", this.id));
        sb.append(String.format("%1$s:'%2$s',", "UserId", UserHelper.getUserCache().getUserId()));
        sb.append("};");

        sb.append("var ElementVar={");
        for (TagPermissionView tagPermissionView : this.getPagePermissionView().getTagPermissionViewList()) {
            sb.append(String.format("%1$s:'%2$s',", tagPermissionView.getTagName(), String.valueOf(tagPermissionView.getTagPermissionType())));
        }
        sb.append("};");
        sb.append("</script>");
        this.pageVar = sb.toString();
    }

    private void initShowEditButton() {
        if(this.id == 0){
            if (this.getPagePermissionView() != null && this.getPagePermissionView().isEdit()){
                this.showEditButton = true;
            } else {
                this.showEditButton = false;
            }
        }
        else{
            Employee employee = EmployeeModel.getInfo(UserHelper.getUserCache().getEmpId());
            if (this.getPagePermissionView() != null && this.getPagePermissionView().isEdit() && employee.getVerify() == StatusType.CHECK_DEFAULT && this.id == UserHelper.getUserCache().getEmpId()) {
                this.showEditButton = true;
            } else {
                this.showEditButton = false;
            }
        }
        if(this.getPagePermissionView().getTagPermission(TagPermission.EDIT_EMPLOYEE) == TagPermissionType.query){
            this.showEditButton = true;
        }
    }

    private void initShowCommonView() {
        if (this.id != 0) {
            this.showCommonView = true;
        } else {
            this.showCommonView = false;
        }
    }

    private void initShowCheckButton(){
        if(this.id == 0){
            if (this.getPagePermissionView() != null && this.getPagePermissionView().isEdit()){
                this.showCheckButton = true;
            } else {
                this.showCheckButton = false;
            }
        }else{
            Employee employee = EmployeeModel.getInfo(this.id);
            if(this.getPagePermissionView() != null && this.getPagePermissionView().getTagPermission(TagPermission.EMPLOYEE_CHECK) == TagPermissionType.query && employee.getVerify() == StatusType.CHECK_WAIT){
                this.showCheckButton = true;
            }else{
                this.showCheckButton = false;
            }
        }

    }

    private void initShowSubmitButton(){
        Employee employee = EmployeeModel.getInfo(this.id);
        if(this.id == UserHelper.getUserCache().getEmpId() &&employee.getVerify() == StatusType.CHECK_DEFAULT){
            this.showSubmitButton = true;
        }else{
            this.showSubmitButton = false;
        }
    }
}
