package com.hzfh.fmp.controller.workFlow.ajax;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.hzfh.api.employee.model.ProbationEvaluation;
import com.hzfh.api.workFlow.model.ActHiTaskinst;
import com.hzfh.fmp.model.employee.ProbationEvaluationModel;
import com.hzfh.fmp.model.employee.ProbationWorkSummaryModel;
import com.hzfh.fmp.model.workFlow.*;
import com.hzframework.helper.StringHelper;
import net.hydromatic.linq4j.expressions.ForStatement;
import org.activiti.engine.repository.ProcessDefinition;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.employee.model.Employee;
import com.hzfh.api.workFlow.model.ActHiProcinst;
import com.hzfh.api.workFlow.model.ActRuTask;
import com.hzfh.api.workFlow.model.TaskVO;
import com.hzfh.api.workFlow.model.query.ActRuTaskCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.employee.EmployeeModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.contract.SortType;
import com.hzframework.helper.DateHelper;


public class AjaxAuditTaskAction extends JqGridBaseAction<TaskVO> {
    private TaskVO info;

    public TaskVO getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = JSON.parseObject(info, TaskVO.class);
    }

    private String comment;

    public void setComment(String comment) {
        this.comment = comment;
    }

    private String activitiNo;

    public String getActivitiNo() {
        return activitiNo;
    }

    public void setActivitiNo(String activitiNo) {
        this.activitiNo = activitiNo;
    }

    private String per;

    public String getPer() {
        return per;
    }

    public void setPer(String per) {
        this.per = per;
    }

    private String bySelectTitle;
    private String byRequestUser;
    private String byDate;

    public void setBySelectTitle(String bySelectTitle) {
        this.bySelectTitle = bySelectTitle;
    }

    public void setByRequestUser(String byRequestUser) {
        this.byRequestUser = byRequestUser;
    }

    List<ActHiTaskinst> actHiTaskinstList;

    public List<ActHiTaskinst> getActHiTaskinstList() {
        return actHiTaskinstList;
    }

    public void setByDate(String byDate) {
        this.byDate = byDate;
    }

    @Override
    public String execute() throws Exception {//待办任务 暂时没用
        return SUCCESS;
    }

    public int getStartIndex() {
        return (this.getPageIndex() - 1) * this.getPageSize();
    }

    private int epId;

    public int getEpId() {
        return epId;
    }

    public void setEpId(int epId) {
        this.epId = epId;
    }

    //受理的任务
    public String acceptTask() {
        String userNo = Integer.toString(UserHelper.getEditUserNo());
        ActRuTaskCondition actRuTaskCondition = new ActRuTaskCondition();
        actRuTaskCondition.setByDate(byDate);
        actRuTaskCondition.setByRequestUser(byRequestUser);
        actRuTaskCondition.setBySelectTitle(bySelectTitle);
        actRuTaskCondition.setAssignee(userNo);
        actRuTaskCondition.setPageIndex(this.getPageIndex());
        actRuTaskCondition.setPageSize(this.getPageSize());
        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild("CREATE_TIME_");
        sortItem.setSortType(SortType.DESC);
        sortItemList.add(sortItem);
        actRuTaskCondition.setSortItemList(sortItemList);
        actRuTaskCondition.setAssignee(userNo);

        PagedList<ActRuTask> actRuTaskPagedList = ActRuTaskModel.getPagingList(actRuTaskCondition);

        List<TaskVO> auditTaskPagedList = new ArrayList<TaskVO>();
        for (ActRuTask actRuTask : actRuTaskPagedList.getResultList()) {
            TaskVO taskVO = new TaskVO();
            ActHiProcinst actHiProIns = ActHiProcinstModel.getInfoByProInsId(actRuTask.getProcInstId());
            ProcessDefinition processDef = ProcessingModel.getProcessDefinitionByProDefId(actHiProIns.getProcDefId());
            Employee employee = EmployeeModel.getEmpByUserId(Integer.parseInt(actHiProIns.getStartUserId()));
            taskVO.setId(actHiProIns.getID());
            taskVO.setStartUserId(actHiProIns.getStartUserId());
            taskVO.setRequestDate(DateHelper.format(new Date(actHiProIns.getStartTime().getTime()), "yyyy-MM-dd HH:mm:ss"));
            taskVO.setTitle(processDef.getName());
            taskVO.setUri(actHiProIns.getBusinessKey());
            taskVO.setRequestUser(employee.getName());//申请人
            taskVO.setTaskId(actRuTask.getID());
            taskVO.setActivitiNo(actRuTask.getProcInstId());
            taskVO.setTaskDate(DateHelper.format(new Date(actRuTask.getCreateTime().getTime()), "yyyy-MM-dd HH:mm:ss"));
            taskVO.setName(actRuTask.getName());
            auditTaskPagedList.add(taskVO);
        }


        int totalCount = actRuTaskPagedList.getPagingInfo().getTotalCount();

        this.setResultList(auditTaskPagedList);
        this.setPageCount(actRuTaskPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(this.getPageIndex());
        this.setRecordCount(totalCount);
        return SUCCESS;
    }

    public String addExamine() {
        comment = per + "：" + comment;
        if ("通过".equals(per)) {
            AuditTaskModel.addComplete(activitiNo, comment, Integer.toString(UserHelper.getEditUserNo()));
        } else if ("下一步".equals(per)) {
            AuditTaskModel.addComplete(activitiNo, comment, Integer.toString(UserHelper.getEditUserNo()));
        } else {
            AuditTaskModel.addCancelComplete(activitiNo, comment, Integer.toString(UserHelper.getEditUserNo()));
        }
        return SUCCESS;
    }

    public String addExamineForExtendProbationApplication() {
        if (epId != 0) {
            ActHiProcinst actHiProcinst = new ActHiProcinst();
            actHiProcinst = ActHiProcinstModel.getInfoString(activitiNo);
            String bk = actHiProcinst.getBusinessKey();
            if (bk.indexOf("id") < 0) {
                actHiProcinst.setBusinessKey(bk.replace("activitiNo", "id=" + epId + "&activitiNo"));
                ActHiProcinstModel.update(actHiProcinst);
            }
        }
        comment = per + "：" + comment;
        if ("通过".equals(per)) {
            AuditTaskModel.addComplete(activitiNo, comment, Integer.toString(UserHelper.getEditUserNo()));
        } else if ("下一步".equals(per)) {
            AuditTaskModel.addComplete(activitiNo, comment, Integer.toString(UserHelper.getEditUserNo()));
        } else {
            AuditTaskModel.finishAuditProcess(activitiNo);
        }
        return SUCCESS;
    }

    public String addExamineForProbationEvaluation() {
        ProbationEvaluation probationEvaluation = ProbationEvaluationModel.getInfoByActivitiNo(this.activitiNo);
        if (probationEvaluation != null) {
            ActHiProcinst actHiProcinst = new ActHiProcinst();
            actHiProcinst = ActHiProcinstModel.getInfoString(activitiNo);
            String url = "/employee/probationEvaluation/edit?id=" + probationEvaluation.getId() + "&activitiNo=";
            actHiProcinst.setBusinessKey(url);
            ActHiProcinstModel.update(actHiProcinst);
        }
        comment = per + "：" + comment;
        if ("通过".equals(per)) {
            AuditTaskModel.addComplete(activitiNo, comment, Integer.toString(UserHelper.getEditUserNo()));
        } else if ("下一步".equals(per)) {
            AuditTaskModel.addComplete(activitiNo, comment, Integer.toString(UserHelper.getEditUserNo()));
        } else {
//            AuditTaskModel.addCancelComplete(activitiNo, comment, Integer.toString(UserHelper.getEditUserNo()));
//            AuditTaskModel.addComplete(activitiNo, comment, Integer.toString(UserHelper.getEditUserNo()));
            AuditTaskModel.finishAuditProcess(activitiNo);
        }
        return SUCCESS;
    }

    public String addExamineForProbationWorkSummary() {
        ActHiProcinst actHiProcinst = new ActHiProcinst();
        actHiProcinst = ActHiProcinstModel.getInfoString(activitiNo);
        int empNo = ProbationWorkSummaryModel.getInfoByActivitiNo(activitiNo).getEmpNo();
        String url = "/employee/probationEvaluation/edit?id=0&activitiNo=";
        ProbationEvaluation probationEvaluation = ProbationEvaluationModel.getInfoByEmpNo(empNo);
        if (probationEvaluation != null) {
            url = "/employee/probationEvaluation/edit?id=" + probationEvaluation.getId() + "&activitiNo=";
        }
        actHiProcinst.setBusinessKey(url);
        ActHiProcinstModel.update(actHiProcinst);
        comment = per + "：" + comment;
        if ("通过".equals(per)) {
            AuditTaskModel.addComplete(activitiNo, comment, Integer.toString(UserHelper.getEditUserNo()));
        } else if ("下一步".equals(per)) {
            AuditTaskModel.addComplete(activitiNo, comment, Integer.toString(UserHelper.getEditUserNo()));
        } else {
            AuditTaskModel.addCancelComplete(activitiNo, comment, Integer.toString(UserHelper.getEditUserNo()));
        }
        return SUCCESS;
    }

    public String addExamineWithEmail() {
        if ("next".equals(this.getOper())) {
            this.comment = "通过:" + this.comment;
            AuditTaskModel.addExamineWithEmail(activitiNo, comment, Integer.toString(UserHelper.getEditUserNo()), true);
        } else {
            this.comment = "不通过:" + this.comment;
            AuditTaskModel.addExamineWithEmail(activitiNo, comment, Integer.toString(UserHelper.getEditUserNo()), false);
        }
        return SUCCESS;
    }

    public String getAuditProcess() {
        if (!StringHelper.isNullOrEmpty(this.activitiNo)) {
            this.actHiTaskinstList = ActHiTaskinstModel.getListByActivitiNo(this.activitiNo);
//            String usertask1 = "";
//            String usertask2 = "";
            int j = -1;
            for (int i = 0; i < actHiTaskinstList.size(); i++) {
                ActHiTaskinst actHiTaskinst = new ActHiTaskinst();
                actHiTaskinst = actHiTaskinstList.get(i);
//                if ((actHiTaskinst.getProcDefId()).indexOf("probationEvaluationProcess") > -1
//                        || (actHiTaskinst.getProcDefId()).indexOf("extendProbationApplicationProcesss") > -1) {
//                    if (actHiTaskinst.getTaskDefKey().equals("usertask1")) {
//                        usertask1 = actHiTaskinst.getAssignee();
//                    }
//                    if (actHiTaskinst.getTaskDefKey().equals("usertask2")) {
//                        usertask2 = actHiTaskinst.getAssignee();
//                        j = i;
//                    }
//                }
                try {
                    String name = EmployeeModel.getEmpByUserId(Integer.valueOf(actHiTaskinst.getAssignee())).getName();
                    actHiTaskinst.setAssignee(name);
                } catch (Exception e) {
                    e.printStackTrace();
                    return SUCCESS;
                }
                if (actHiTaskinst.getEndTime() != null) {
                    Date endTime = new Date(actHiTaskinst.getEndTime().getTime());
                    String formatEndTime = DateHelper.format(endTime, "yyyy-MM-dd HH:mm:ss");
                    actHiTaskinst.setDescription(formatEndTime);
                }
            }
//            if (usertask1.equals(usertask2) && !StringHelper.isNullOrEmpty(usertask1) && !StringHelper.isNullOrEmpty(usertask2) && j != -1) {
//                actHiTaskinstList.remove(j);
//            }
        }
        return SUCCESS;
    }
}
