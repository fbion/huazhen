package com.hzfh.fmp.controller.employee;

import com.hzfh.api.employee.model.AttendanceApplication;
import com.hzfh.api.employee.model.Employee;
import com.hzfh.api.employee.model.EmployeeDetail;
import com.hzfh.api.employee.model.ProbationEvaluation;
import com.hzfh.api.employee.model.ProbationWorkSummary;
import com.hzfh.fmp.controller.common.CommonAction;
import com.hzfh.fmp.model.common.PageAlias;
import com.hzfh.fmp.model.common.enumeration.TagPermissionType;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.employee.AttendanceApplicationModel;
import com.hzfh.fmp.model.employee.EmployeeDetailModel;
import com.hzfh.fmp.model.employee.EmployeeModel;
import com.hzfh.fmp.model.employee.ProbationEvaluationModel;
import com.hzfh.fmp.model.employee.ProbationWorkSummaryModel;
import com.hzfh.fmp.model.permission.view.TagPermissionView;
import com.hzfh.fmp.model.workFlow.ActRuTaskModel;
import com.hzframework.helper.StringHelper;

import java.util.Date;

public class ProbationEvaluationAddAction extends CommonAction {
    public boolean showEditButton;

    public boolean isShowEditButton() {
        return showEditButton;
    }

    public boolean showSubmitButton;
    
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

    
    private int empNo;
	private int companyNo;
	private int deptNo;
	private int positionNo;
	public int getEmpNo() {
		return empNo;
	}
	public int getCompanyNo() {
		return companyNo;
	}
	public int getDeptNo() {
		return deptNo;
	}

    public int getPositionNo() {
        return positionNo;
    }

    public void setPositionNo(int positionNo) {
        this.positionNo = positionNo;
    }

    private Date startTime;
    public Date getStartTime() {
		return startTime;
	}
	
    private int activitiStatus;
    public int getActivitiStatus() {
		return activitiStatus;
	}

	public void setActivitiStatus(int activitiStatus) {
		this.activitiStatus = activitiStatus;
	}
	private String backUrl;
	public String getBackUrl() {
		return backUrl;
	}
	public void setBackUrl(String backUrl) {
		this.backUrl = backUrl;
	}
	private boolean showExamineButton;
    private String activitiNo;

    public void setActivitiNo(String activitiNo) {
        this.activitiNo = activitiNo;
    }

    public boolean isShowExamineButton() {
        return showExamineButton;
    }
    private int status;
    
    public int getStatus() {
		return status;
	}
	@Override
    public String execute() throws Exception {
        this.setPageAlias(PageAlias.probationEvaluationAdd);

        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;

        if (this.getPagePermissionView() != null && this.getPagePermissionView().isCreate())
            this.showSubmitButton = true;

        if (this.getPagePermissionView() != null && this.getPagePermissionView().isEdit()) {
            this.showEditButton = true;
            this.showSubmitButton = true;
        }
        
        Employee e = new Employee();
        if(id==0){
        	e = EmployeeModel.getEmpByUserId(UserHelper.getEditUserNo());
        }else{
        	e = EmployeeModel.getInfo(ProbationEvaluationModel.getInfo(id).getEmpNo());
        }
        if(!StringHelper.isNullOrEmpty(this.activitiNo) && id==0){
        	ProbationWorkSummary summary = new ProbationWorkSummary();
        	summary = ProbationWorkSummaryModel.getInfoByActivitiNo(this.activitiNo);
        	e = EmployeeModel.getInfo(summary.getEmpNo());
        	this.userNo = e.getId()+"";
        	this.position = e.getPositionNo()+"";
        }
        this.empNo = e.getId();
        this.companyNo = e.getCompanyNo();
        this.deptNo = e.getDeptNo();
        this.positionNo = e.getPositionNo();
        EmployeeDetail ed = EmployeeDetailModel.getEmpDetailByEmpNo(e.getId());
        if(ed!=null){
        	this.startTime = ed.getStartTime();
        }
        this.initShowEditButton();
        this.initPageVar();
        this.initShowExamineButton();

        return SUCCESS;
    }

    private String userNo;

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    private String position;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    private void initShowEditButton() {
    	int userId = UserHelper.getEditUserNo();
    	ProbationEvaluation tApplication = ProbationEvaluationModel.getInfo(this.id);
        if (this.getPagePermissionView() != null && this.getPagePermissionView().isEdit() && StringHelper.isNullOrEmpty(this.activitiNo)) {
            this.showEditButton = true;
            this.showSubmitButton = true;
        } else if(!StringHelper.isNullOrEmpty(this.activitiNo) && ActRuTaskModel.getInfoByAciIdAndUserId(this.activitiNo, userId) != null && this.id==0){
        	this.showEditButton = true;
            this.showSubmitButton = true;
        } else {
        	if(!StringHelper.isNullOrEmpty(this.activitiNo) && ActRuTaskModel.getInfoByAciIdAndUserId(this.activitiNo, userId) != null && tApplication.getInUserNo()==userId){
        		 this.showEditButton = true;
                 this.showSubmitButton = true;
        	}else{
        		this.showEditButton = false;
                this.showSubmitButton = false;
        	}
        }
    }
    private void initPageVar() {
        StringBuilder sb = new StringBuilder();

        sb.append("<script type=\"text/javascript\">");
        sb.append("var PageVar={");
        sb.append(String.format("%1$s:'%2$s',", "ID", this.id));
        sb.append(String.format("%1$s:'%2$s',", "UserId",UserHelper.getEditUserNo()));
        sb.append(String.format("%1$s:'%2$s',", "UserNo",this.userNo));
        sb.append(String.format("%1$s:'%2$s',", "PositionNo",this.position));
        sb.append("};");

        sb.append("var ElementVar={");
        for(TagPermissionView tagPermissionView: this.getPagePermissionView().getTagPermissionViewList()){
            sb.append(String.format("%1$s:'%2$s',", tagPermissionView.getTagName(), String.valueOf(tagPermissionView.getTagPermissionType())));
        }
        sb.append("};");

        sb.append("</script>");

        this.pageVar = sb.toString();
    }
    private void initShowExamineButton() {
        int userId = UserHelper.getEditUserNo();
        if (!StringHelper.isNullOrEmpty(this.activitiNo) && ActRuTaskModel.getInfoByAciIdAndUserId(this.activitiNo, userId) != null) {
            this.showExamineButton = true;
        } else {
            this.showExamineButton = false;
        }
    }

}