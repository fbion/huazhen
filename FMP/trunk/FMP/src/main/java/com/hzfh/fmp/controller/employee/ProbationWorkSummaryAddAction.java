package com.hzfh.fmp.controller.employee;

import com.hzfh.api.employee.model.Employee;
import com.hzfh.api.employee.model.ProbationEvaluation;
import com.hzfh.api.employee.model.ProbationWorkSummary;
import com.hzfh.fmp.controller.common.CommonAction;
import com.hzfh.fmp.model.common.PageAlias;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.employee.EmployeeModel;
import com.hzfh.fmp.model.employee.ProbationEvaluationModel;
import com.hzfh.fmp.model.employee.ProbationWorkSummaryModel;
import com.hzfh.fmp.model.permission.view.TagPermissionView;
import com.hzfh.fmp.model.workFlow.ActRuTaskModel;

public class ProbationWorkSummaryAddAction extends CommonAction {
    public boolean showEditButton = false;

    public boolean isShowEditButton() {
        return showEditButton;
    }

    public boolean showSubmitButton = false;

    public boolean isShowSubmitButton() {
        return showSubmitButton;
    }

    private String pageVar;

    public String getPageVar() {
        return pageVar;
    }

    private int id;

    public void setId(int id) {
        this.id = id;
    }

    private String empName;
    private int empNo;
    private String activitiNo;

    public void setActivitiNo(String activitiNo) {
        this.activitiNo = activitiNo;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getEmpNo() {
        return empNo;
    }

    private int companyNo;
    private int deptNo;
    private int positionNo;

    public int getCompanyNo() {
        return companyNo;
    }

    public int getDeptNo() {
        return deptNo;
    }

    public int getPositionNo() {
        return positionNo;
    }

    @Override
    public String execute() throws Exception {
        this.setPageAlias(PageAlias.probationWorkSummaryAdd);

        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;

        if (this.getPagePermissionView() != null && this.getPagePermissionView().isCreate())
            this.showSubmitButton = true;

        this.initShowEditButton();
        Employee e = new Employee();
        if (id == 0) {
            e = EmployeeModel.getEmpByUserId(UserHelper.getEditUserNo());
        } else {
            e = EmployeeModel.getInfo(ProbationWorkSummaryModel.getInfo(id).getEmpNo());
        }
        this.empName = e.getName();
        this.empNo = e.getId();
        this.companyNo = e.getCompanyNo();
        this.deptNo = e.getDeptNo();
        this.positionNo = e.getPositionNo();
        initPageVar();

        return SUCCESS;
    }

    private void initPageVar() {
        StringBuilder sb = new StringBuilder();

        sb.append("<script type=\"text/javascript\">");
        sb.append("var PageVar={");
        sb.append(String.format("%1$s:'%2$s',", "ID", this.id));
        ProbationWorkSummary probationWorkSummary = ProbationWorkSummaryModel.getInfo(this.id);
        if(probationWorkSummary != null){
            ProbationEvaluation probationEvaluation = ProbationEvaluationModel.getInfoByEmpNo(probationWorkSummary.getEmpNo());
            if (probationEvaluation != null) {
                sb.append(String.format("%1$s:'%2$s',", "probationEvaluationId", probationEvaluation.getId()));
            }
            else {
                sb.append(String.format("%1$s:'%2$s',", "probationEvaluationId", 0));
            }
        }
         else {
            sb.append(String.format("%1$s:'%2$s',", "probationEvaluationId", 0));
        }
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

    private void initShowEditButton() {
        if (this.getPagePermissionView() != null && this.getPagePermissionView().isEdit()) {
            if (this.id == 0) {
                this.showEditButton = true;
                this.showSubmitButton = true;
            } else if (ProbationWorkSummaryModel.getInfo(id).getEmpNo() == UserHelper.getUserCache().getEmpId() && ActRuTaskModel.getInfoByAciIdAndUserId(this.activitiNo, UserHelper.getEditUserNo()) != null) {
                this.showEditButton = true;
                this.showSubmitButton = true;
            }
        }
    }

}