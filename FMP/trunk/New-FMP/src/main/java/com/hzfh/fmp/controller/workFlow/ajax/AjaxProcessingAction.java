package com.hzfh.fmp.controller.workFlow.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.employee.model.*;
import com.hzfh.api.product.model.P2pProduct;
import com.hzfh.api.product.model.Product;
import com.hzfh.api.sales.model.Creditor;
import com.hzfh.api.sales.model.Sales;
import com.hzfh.api.workFlow.model.ActHiProcinst;
import com.hzfh.api.workFlow.model.CommentVO;
import com.hzfh.api.workFlow.model.Processing;
import com.hzfh.api.workFlow.model.query.ActHiProcinstCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.baseInfo.LetterModel;
import com.hzfh.fmp.model.common.enumeration.ProductType;
import com.hzfh.fmp.model.common.enumeration.SalesStatus;
import com.hzfh.fmp.model.common.enumeration.StatusType;
import com.hzfh.fmp.model.common.helper.SalesLogHelper;
import com.hzfh.fmp.model.common.helper.UrlHelper;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.common.properties.AuditHelper;
import com.hzfh.fmp.model.common.properties.DeptHelper;
import com.hzfh.fmp.model.common.properties.WebInfoHelper;
import com.hzfh.fmp.model.customer.CustomerCompanyModel;
import com.hzfh.fmp.model.customer.CustomerPersonalModel;
import com.hzfh.fmp.model.employee.*;
import com.hzfh.fmp.model.product.P2pProductModel;
import com.hzfh.fmp.model.product.ProductModel;
import com.hzfh.fmp.model.sales.CreditorModel;
import com.hzfh.fmp.model.sales.SalesModel;
import com.hzfh.fmp.model.workFlow.ActHiProcinstModel;
import com.hzfh.fmp.model.workFlow.ActHiTaskinstModel;
import com.hzfh.fmp.model.workFlow.ActRuTaskModel;
import com.hzfh.fmp.model.workFlow.ProcessingModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.contract.SortType;
import com.hzframework.helper.DateHelper;
import com.hzframework.helper.StringHelper;
import org.activiti.engine.repository.ProcessDefinition;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AjaxProcessingAction extends JqGridBaseAction<Processing> {
    private Processing info;

    public Processing getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = JSON.parseObject(info, Processing.class);
    }

    private String comment;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    private String id;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String uri;

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String activitiNo;
    private String bySelectTitle;
    private String byStatus;
    private String byDate;

    public void setActivitiNo(String activitiNo) {
        this.activitiNo = activitiNo;
    }

    public String getActivitiNo() {
        return activitiNo;
    }

    public void setBySelectTitle(String bySelectTitle) {
        this.bySelectTitle = bySelectTitle;
    }

    public void setByStatus(String byStatus) {
        this.byStatus = byStatus;
    }

    public void setByDate(String byDate) {
        this.byDate = byDate;
    }

    private List<CommentVO> commentList;

    public List<CommentVO> getCommentList() {
        return commentList;
    }

    private int rootDeptNo;
    private String updateActivitiAssigneeInput;

    public void setUpdateActivitiAssigneeInput(String updateActivitiAssigneeInput) {
        this.updateActivitiAssigneeInput = updateActivitiAssigneeInput;
    }

    private static final SalesLogHelper salesLog = SalesLogHelper.getLogger(AjaxProcessingAction.class.getName());

    @Override
    public String execute() throws Exception {
        String userNo = Integer.toString(UserHelper.getEditUserNo());
        List<Processing> actIdProcessingPagedList = new ArrayList<Processing>();


        ///
        ActHiProcinstCondition actHiProcinstCondition = new ActHiProcinstCondition();
        actHiProcinstCondition.setPageSize(this.getPageSize());
        actHiProcinstCondition.setPageIndex(this.getPageIndex());

        if (!StringHelper.isNullOrEmpty(userNo)) {
            actHiProcinstCondition.setStartUserId(Integer.parseInt(userNo));
        } else {
            actHiProcinstCondition.setStartUserId(0);
        }

        actHiProcinstCondition.setBySelectTitle(bySelectTitle);
        actHiProcinstCondition.setByStatus(byStatus);
        actHiProcinstCondition.setByDate(byDate);


        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild("START_TIME_");
        sortItem.setSortType(SortType.DESC);
        sortItemList.add(sortItem);
        actHiProcinstCondition.setSortItemList(sortItemList);

        PagedList<ActHiProcinst> actHiProcPagedList = ActHiProcinstModel.getPagingList(actHiProcinstCondition);


        for (ActHiProcinst actHiProcList : actHiProcPagedList.getResultList()) {
            Processing processing = new Processing();
//        	Task  task = ProcessingModel.getBackTask(actHiProcList.getProcInstId(),userNo);
            ProcessDefinition processDef = ProcessingModel.getProcessDefinitionByProDefId(actHiProcList.getProcDefId());
            processing.setId(actHiProcList.getProcInstId());
            processing.setTitle(processDef.getName());//标题
            processing.setRequestDate(DateHelper.format(new Date(actHiProcList.getStartTime().getTime()), "yyyy-MM-dd HH:mm:ss"));//申请时间
            processing.setUri(actHiProcList.getBusinessKey());

            if (actHiProcList.getEndTime() == null) {
                processing.setStatus("未通过");//未结束
            } else {
                if (actHiProcList.getEndActId().equals("deleteActiviti")) {
                    processing.setStatus("流程手动删除");//结束
                } else {
                    processing.setStatus("通过");//结束
                }
            }
            actIdProcessingPagedList.add(processing);
        }
        int totalCount = actHiProcPagedList.getPagingInfo().getTotalCount();
        this.setResultList(actIdProcessingPagedList);
        this.setPageCount(actHiProcPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(this.getPageIndex());
        this.setRecordCount(totalCount);
        return SUCCESS;
    }


    public int getStartIndex() {
        return (this.getPageIndex() - 1) * this.getPageSize();
    }


    // 临时招聘表审批流程开始
    public String startTempRecruitNeedProcess() {
        String userNo = Integer.toString(UserHelper.getEditUserNo());
        String type = "tempRecruitNeedProcess";

        Map<String, Object> variables = new HashMap<>();
        this.transmitVariables(variables);
        String uri1 = WebInfoHelper.WEB_FMP_LOGIN;
        this.uri = uri.substring(uri1.length());
        String processInstanceNo = ProcessingModel.startFlowProcess(type, userNo, variables, comment, uri);
        this.activitiNo = processInstanceNo;
        TempRecruitNeed tempRecruitNeed = TempRecruitNeedModel.getInfo(Integer.parseInt(id));
        tempRecruitNeed.setActivitiNo(processInstanceNo);
        TempRecruitNeedModel.update(tempRecruitNeed);
        return SUCCESS;
    }

    // 部门年度需求审批流程开始
    public String startDeptYearNeedProcess() {
        String userNo = Integer.toString(UserHelper.getEditUserNo());
        String type = "deptYearNeedProcess";
        Map<String, Object> variables = new HashMap<>();
        this.transmitVariables(variables);

        String uri1 = WebInfoHelper.WEB_FMP_LOGIN;
        this.uri = uri.substring(uri1.length());

        String processInstanceNo = ProcessingModel.startFlowProcess(type, userNo, variables, comment, uri);
        this.activitiNo = processInstanceNo;
        DeptYearNeed deptYearNeed = DeptYearNeedModel.getInfo(Integer.parseInt(id));
        deptYearNeed.setActivitiNo(processInstanceNo);
        DeptYearNeedModel.update(deptYearNeed);
        return SUCCESS;
    }

    // 延迟试用期审批流程管理开始
    public String startExtendProbationApplicationProcesss() {
        String type = "extendProbationApplicationProcess";
        Map<String, Object> variables = new HashMap<>();
        this.transmitVariablesForProbationEvaluation(variables, type);
        String uri1 = WebInfoHelper.WEB_FMP_LOGIN;
        this.uri = uri.substring(uri1.length());
        String processInstanceNo = ProcessingModel.startFlowProcess(type, this.id, variables, comment, uri);
        this.activitiNo = processInstanceNo;
//        ExtendProbationApplication extendProbationApplication = ExtendProbationApplicationModel.getInfo(Integer.parseInt(id));
//        extendProbationApplication.setActivitiNo(processInstanceNo);
//        ExtendProbationApplicationModel.update(extendProbationApplication);
        return SUCCESS;
    }

    // 考勤批流程管理开始
    public String startAttendanceApplicationProcess() {
        int userNo = UserHelper.getEditUserNo();
//        int deptNo = EmployeeModel.getEmpByUserId(userNo).getDeptNo();
        String type = "";
//        if (deptNo == DeptHelper.DEPT_ADMINISTRATION) {
//            type = "attendanceApplicationProcessForPersonnel";
//        } else if (deptNo == DeptHelper.DEPT_SALES || deptNo == DeptHelper.DEPT_FINANCE || deptNo == DeptHelper.DEPT_OPERATOR || deptNo == DeptHelper.DEPT_PRODUCT || deptNo == DeptHelper.DEPT_MARKET || deptNo == DeptHelper.DEPT_DEV || deptNo == DeptHelper.DEPT_RISK_CONTROL) {
//            type = "attendanceApplicationProcessForBackOffice";
//        } else {
//            type = "attendanceApplicationProcessForSales";
//        }
        type = "attendanceApplicationProcess_New";
        Map<String, Object> variables = new HashMap<>();
        this.transmitVariablesForAttendanceApplication(variables);
        String tempLeader = variables.get("leader").toString();
        String tempDeprtLeader = variables.get("deprtLeader").toString();
        if (tempLeader.equals(tempDeprtLeader)) {
            type = "attendanceApplicationProcess_NewTwo";
        }
        String uri1 = WebInfoHelper.WEB_FMP_LOGIN;
        this.uri = uri.substring(uri1.length());
        String processInstanceNo = ProcessingModel.startFlowProcessForNoApplicant(type, String.valueOf(userNo), variables, comment, uri);
        this.activitiNo = processInstanceNo;
        AttendanceApplication attendanceApplication = AttendanceApplicationModel.getInfo(Integer.parseInt(id));
        attendanceApplication.setActivitiNo(processInstanceNo);
        AttendanceApplicationModel.update(attendanceApplication);
        return SUCCESS;
    }

    // 辞职申请审批流程管理开始
    public String startResignApplicationProcess() {
        String userNo = Integer.toString(UserHelper.getEditUserNo());
        String type = "resignApplicationProcess";

        Map<String, Object> variables = new HashMap<>();
        this.transmitVariables(variables);
         /*int tempNo = EmployeeModel.getInfo(UserHelper.getEditUserNo()).getParentNo();
         variables.put("teamLeader",Integer.toString(tempNo));*/
        String uri1 = WebInfoHelper.WEB_FMP_LOGIN;
        this.uri = uri.substring(uri1.length());
        String processInstanceNo = ProcessingModel.startFlowProcess(type, userNo, variables, comment, uri);
        this.activitiNo = processInstanceNo;
        ResignApplication resignApplication = ResignApplicationModel.getInfo(Integer.parseInt(id));
        resignApplication.setActivitiNo(processInstanceNo);
        ResignApplicationModel.update(resignApplication);
        return SUCCESS;
    }

    // 人事调动期审批流程管理开始
    public String startPersonalChangeProcess() {
        String userNo = Integer.toString(UserHelper.getEditUserNo());
        String type = "personalChangeProcess";

        Map<String, Object> variables = new HashMap<>();
        this.transmitVariables(variables);
        String uri1 = WebInfoHelper.WEB_FMP_LOGIN;
        this.uri = uri.substring(uri1.length());
        String processInstanceNo = ProcessingModel.startFlowProcess(type, userNo, variables, comment, uri);
        this.activitiNo = processInstanceNo;
        PersonalChange personalChange = PersonalChangeModel.getInfo(Integer.parseInt(id));
        personalChange.setActivitiNo(processInstanceNo);
        PersonalChangeModel.update(personalChange);
        return SUCCESS;
    }

    // 年度需求审批流程管理开始
    public String startYearNeedProcess() {
        String userNo = Integer.toString(UserHelper.getEditUserNo());
        String type = "yearNeedProcess";

        Map<String, Object> variables = new HashMap<>();
        this.transmitVariables(variables);
        String uri1 = WebInfoHelper.WEB_FMP_LOGIN;
        this.uri = uri.substring(uri1.length());
        String processInstanceNo = ProcessingModel.startFlowProcess(type, userNo, variables, comment, uri);
        this.activitiNo = processInstanceNo;
        YearNeedTotal yearNeedTotal = YearNeedTotalModel.getInfo(Integer.parseInt(id));
        yearNeedTotal.setActivitiNo(processInstanceNo);

        YearNeedTotalModel.update(yearNeedTotal);
        return SUCCESS;
    }

    // 员工试用期转正评估审批流程管理开始
    public String startProbationEvaluationProcess() {
        String type = "probationEvaluationProcess";
        Map<String, Object> variables = new HashMap<>();
        this.transmitVariablesForProbationEvaluation(variables, type);
        String uri1 = WebInfoHelper.WEB_FMP_LOGIN;
        this.uri = uri.substring(uri1.length());
        String processInstanceNo = ProcessingModel.startFlowProcess(type, this.id, variables, comment, uri);
        this.activitiNo = processInstanceNo;
        return SUCCESS;
    }

    // 评分确认审批流程管理开始
    public String startManagerEvaluationProcess() {
        String userNo = Integer.toString(UserHelper.getEditUserNo());
        String type = "managerEvaluationProcess";

        Map<String, Object> variables = new HashMap<>();
        this.transmitVariables(variables);
        String uri1 = WebInfoHelper.WEB_FMP_LOGIN;
        this.uri = uri.substring(uri1.length());
        String processInstanceNo = ProcessingModel.startFlowProcess(type, userNo, variables, comment, uri);
        this.activitiNo = processInstanceNo;
        ManagerEvaluation managerEvaluation = ManagerEvaluationModel.getInfo(Integer.parseInt(id));
        managerEvaluation.setActivitiNo(processInstanceNo);
        ManagerEvaluationModel.update(managerEvaluation);
        return SUCCESS;
    }

    //产品审核流程开始
    public String startProductAuditProcess() {
        String userNo = String.valueOf(UserHelper.getEditUserNo());
        String type = "productAuditProcess";
        Map<String, Object> variables = new HashMap<>();
        Product product = ProductModel.getInfo(Integer.parseInt(this.id));
        if (product.getType() == ProductType.P2P) {
            variables.put("isXianFangBao", true);
        } else if (product.getType() < 7) {
            variables.put("isXianFangBao", false);
        } else {
            this.setErrCode("NO Success");
            this.setErrDesc("出错啦！此产品还未确定审核流程，不需要提交审核。");
            return SUCCESS;
        }
        this.transmitVariablesForProductAudit(variables);
        String uri1 = WebInfoHelper.WEB_FMP_LOGIN;
        this.uri = uri.substring(uri1.length());
        String processInstanceNo = ProcessingModel.startFlowProcessWithEmail(type, userNo, variables, comment, uri);
        this.activitiNo = processInstanceNo;
        product.setActivitiNo(processInstanceNo);
        ProductModel.update(product);
        return SUCCESS;
    }

    //新金融产品审核
    public String startP2pProductAuditProcess() {
        String userNo = String.valueOf(UserHelper.getEditUserNo());
        String type = "p2pProductAuditProcess";
        Map<String, Object> variables = new HashMap<>();
        int id = Integer.parseInt(this.id);
        P2pProduct p2pProduct = P2pProductModel.getInfo(id);
        if (p2pProduct.getType() == ProductType.P2P) {
            variables.put("isXianFangBao", true);
        } else {
            this.setErrCode("NO Success");
            this.setErrDesc("出错啦！此产品还未确定审核流程，不需要提交审核。");
            return SUCCESS;
        }
        List<Creditor> creditorList = CreditorModel.getListByPrductNo(p2pProduct.getProductNo());
        if (creditorList == null || creditorList.size() == 0) {
            this.setErrCode("failure");
            this.setErrDesc("请导入债权后重新提交审核");
            return SUCCESS;
        }
        double totalMoney = CreditorModel.getRemainAmountByProductNo(p2pProduct.getProductNo());
        if (totalMoney < p2pProduct.getTotalAmout()) {
            this.setErrCode("failure");
            this.setErrDesc("你导入的债权小于此产品的募集规模，请核对债权后重新提交审核");
            return SUCCESS;
        }

        this.transmitVariablesForP2pProductAudit(variables);
        String uri1 = WebInfoHelper.WEB_FMP_LOGIN;
        this.uri = uri.substring(uri1.length());
        String processInstanceNo = ProcessingModel.startFlowProcessWithEmail(type, userNo, variables, comment, uri);
        this.activitiNo = processInstanceNo;
        p2pProduct.setActivitiNo(processInstanceNo);
        P2pProductModel.update(p2pProduct);
        return SUCCESS;
    }

    //打款审核流程开始
    public String startSalesAuditProcess() {
        int salesNo = Integer.parseInt(this.id);
        Sales sales = SalesModel.getInfo(salesNo);
        int productNo = sales.getProductNo();
        long money = sales.getMoney();
        int count = 1;
        if ((ProductModel.getInfo(productNo).getRemainAmount() - money) < 0 || (P2pProductModel.getP2pByProductNo(productNo).getRemainAmout() - money) < 0) {
            this.setErrCode("打款金额大于产品剩余额度");
            this.setErrDesc("打款金额大于产品剩余额度");
            return SUCCESS;
        }
        ProductModel.updateReduceRemainAmount(productNo, money);
        salesLog.addSalesLog("提交审核（减少产品剩余额度）", String.valueOf(money), salesNo);
        P2pProductModel.updateRemainAmountByProductNo(productNo, -money);
        salesLog.addSalesLog("提交审核（减少新金额产品剩余额度）", String.valueOf(money), salesNo);
        P2pProductModel.updateOrderCountByProductNo(productNo, count);
        salesLog.addSalesLog("提交审核（增加打款个数", "", salesNo);
        this.updateTradeTotalBySales(sales, money);
        salesLog.addSalesLog("提交审核（增加客户累计购买金额）", String.valueOf(money), salesNo);
        String userNo = String.valueOf(UserHelper.getEditUserNo());
        String type = "salesAuditProcess";
        Map<String, Object> variables = new HashMap<>();
        this.transmitVariablesForSalesAudit(variables);
        String uri1 = WebInfoHelper.WEB_FMP_LOGIN;
        this.uri = uri.substring(uri1.length());
        String processInstanceNo = ProcessingModel.startFlowProcessForNoApplicant(type, userNo, variables, comment, uri);
        this.activitiNo = processInstanceNo;
        sales.setActivitiNo(processInstanceNo);
        sales.setStatus(SalesStatus.check);
        salesLog.addSalesLog("提交审核（更新状态）", String.valueOf(SalesStatus.check), salesNo);
        SalesModel.update(sales);
        return SUCCESS;
    }

    private void updateTradeTotalBySales(Sales sales, double money) {
        //更新(增加)客户的累计购买金额
        if (sales.getCustomerType() == StatusType.CUSTOMER_PERSONAL_TYPE) {
            CustomerPersonalModel.updateTradeTotalById(sales.getCustomerNo(), money);
        } else if (sales.getCustomerType() == StatusType.CUSTOMER_COMPANY_TYPE) {
            CustomerCompanyModel.updateTradeTotalById(sales.getCustomerNo(), money);
        }
    }

    // 还款审批流程管理开始
    public String startRepaymentExaminationProcess() {
        String type = "repaymentExaminationProcess";
        Map<String, Object> variables = new HashMap<>();
        this.transmitVariables(variables);
        String uri1 = WebInfoHelper.WEB_FMP_LOGIN;
        this.uri = uri.substring(uri1.length());
        String processInstanceNo = ProcessingModel.startFlowProcess(type, variables.get("user") + "", variables, comment, uri + "&activitiNo=");
        this.activitiNo = processInstanceNo;
        return SUCCESS;
    }

    //传递参数
    public Map<String, Object> transmitVariables(Map<String, Object> variables) {
        int userNo = UserHelper.getEditUserNo();
        int deptNo = EmployeeModel.getEmpByUserId(userNo).getDeptNo();
        /*if(deptNo==10&&deptNo==11){
            deptNo=5;
		}*/
        int empNo = 0;
        int teamNo = 0;
        Department department = DepartmentModel.getInfo(deptNo);
        if (department.getParentNo() == 1) {
            empNo = department.getEmpNo();
        }
        if (department.getParentNo() == 5) {
            empNo = DepartmentModel.getInfo(5).getEmpNo();
        }
        if (department.getParentNo() == 13) {
            empNo = DepartmentModel.getInfo(13).getEmpNo();
        }
        empNo = EmployeeModel.getInfo(empNo).getUserNo();
        int hrNo = DepartmentModel.getInfo(2).getEmpNo();
        hrNo = EmployeeModel.getInfo(hrNo).getUserNo();
        int companyNo = EmployeeModel.getInfo(1).getUserNo();
        //int  deptLeaderNo = EmployeeModel.getInfo(empNo).getUserNo();

        if (department.getParentNo() != 1) {
            teamNo = DepartmentModel.getInfo(deptNo).getEmpNo();
        }
        int CEO = EmployeeModel.getInfo(DepartmentModel.getInfo(1).getEmpNo()).getUserNo();//总裁
        int financeDirector = EmployeeModel.getInfo(DepartmentModel.getInfo(DeptHelper.DEPT_FINANCE).getEmpNo()).getUserNo();//财务总监
        variables.put("user", Integer.toString(userNo));//申请人
        variables.put("teamLeader", Integer.toString(teamNo));//主管
        //variables.put("deptLeader",Integer.toString(empNo));//部门领导
        variables.put("deptLeader", EmployeeModel.getInfo(EmployeeModel.getEmpByUserId(userNo).getParentNo()).getUserNo());//部门领导
        variables.put("hrLeader", Integer.toString(hrNo));//行政（李）
        variables.put("HR", EmployeeModel.getInfo(DepartmentModel.getInfo(2).getEmpNo()).getUserNo());//人事（贺）
        variables.put("NewHR", EmployeeModel.getInfo(DepartmentModel.getInfo(58).getEmpNo()).getUserNo());//人事（贺）
        variables.put("companyLeader", Integer.toString(companyNo));//公司领导
        variables.put("approver", Integer.toString(EmployeeModel.getInfo(DepartmentModel.getInfo(5).getEmpNo()).getUserNo()));
        variables.put("parentLeader", EmployeeModel.getInfo(EmployeeModel.getEmpByUserId(userNo).getParentNo()).getUserNo());//上级领导
        variables.put("CEO", CEO);//总裁
        variables.put("financeDirector", financeDirector);//财务
        return variables;
    }

    //查询评论数据


    public String getAuditComment() {
        commentList = ProcessingModel.getProintCommnets(activitiNo);
        return SUCCESS;
    }

    public Map<String, Object> transmitVariablesForAttendanceApplication(Map<String, Object> variables) {
        int userId = UserHelper.getEditUserNo();
        Employee employee = EmployeeModel.getEmpByUserId(userId);
        int CEO = EmployeeModel.getInfo(DepartmentModel.getInfo(1).getEmpNo()).getUserNo();
        int HR = EmployeeModel.getInfo(DepartmentModel.getInfo(58).getEmpNo()).getUserNo();
        int highestLeaderForDirect = DepartmentModel.getInfo(10).getEmpNo();
        int highestLeaderForChannel = DepartmentModel.getInfo(11).getEmpNo();
        int highestLeaderForNewFinance = DepartmentModel.getInfo(13).getEmpNo();
        int day = AttendanceApplicationModel.getInfo(Integer.parseInt(id)).getTotalDay();
        int deprtLeader = EmployeeModel.getInfo(DepartmentModel.getInfo(getRootDeptNoByDeptNo(employee.getDeptNo())).getEmpNo()).getUserNo();
        int leader = EmployeeModel.getInfo(employee.getParentNo()).getUserNo();
        String leaderPosition = PositionModel.getInfo(EmployeeModel.getEmpByUserId(leader).getPositionNo()).getName();
        String leaderPositionName = PositionModel.getInfo(EmployeeModel.getEmpByUserId(leader).getPositionNo()).getName();
        int leaderForTeamLeader = 0;
        if ("团队长".equals(leaderPositionName)) {
            leaderForTeamLeader = EmployeeModel.getEmpByUserId(leader).getUserNo();
        }
        List<Integer> leaderList = UserHelper.getUserCache().getLeaderList();
        int highestLeader = 0;
        for (int empNo : leaderList) {
            if (empNo == highestLeaderForDirect) {
                highestLeader = EmployeeModel.getInfo(empNo).getUserNo();
                break;
            } else if (empNo == highestLeaderForChannel) {
                highestLeader = EmployeeModel.getInfo(empNo).getUserNo();
                break;
            } else if (empNo == highestLeaderForNewFinance) {
                highestLeader = EmployeeModel.getInfo(empNo).getUserNo();
                break;
            } else {
                continue;
            }

        }

        variables.put("user", userId);//申请人
        variables.put("CEO", CEO);//公司领导
        variables.put("HR", HR);//人力资源总监
        variables.put("leader", leader);//上级领导
        variables.put("leaderPosition", leaderPosition);//领导的职位
        variables.put("teamLeader", "团队长");
        variables.put("leaderForTeamLeader", leaderForTeamLeader);//团队长的上级领导
        variables.put("highestLeader", highestLeader);
        variables.put("deprtLeader", deprtLeader);
        variables.put("day", day);//请假天数
        return variables;
    }

    public Map<String, Object> transmitVariablesForProductAudit(Map<String, Object> variables) {
        int userId = UserHelper.getEditUserNo();
        int productDirector = EmployeeModel.getInfo(EmployeeModel.getEmpByUserId(userId).getParentNo()).getUserNo();
        int positionNo = EmployeeModel.getEmpByUserId(UserHelper.getEditUserNo()).getPositionNo();
        int fortuneDirector = EmployeeModel.getInfo(DepartmentModel.getInfo(DeptHelper.DEPT_SALES_DIRECT1).getEmpNo()).getUserNo();
        int riskDirector = EmployeeModel.getInfo(DepartmentModel.getInfo(DeptHelper.DEPT_RISK_CONTROL).getEmpNo()).getUserNo();
        int financeDirector = EmployeeModel.getInfo(DepartmentModel.getInfo(DeptHelper.DEPT_FINANCE).getEmpNo()).getUserNo();
        int CEO = EmployeeModel.getInfo(DepartmentModel.getInfo(DeptHelper.DEPT_PRESIDENT).getEmpNo()).getUserNo();
        int productOperator = EmployeeModel.getInfo(DepartmentModel.getInfo(59).getEmpNo()).getUserNo();

        variables.put("creator", userId);
        variables.put("userPosition", positionNo);
        variables.put("productDirectorPosition", AuditHelper.AUDIT_PRODUCTDIRECTOR_POSITION);
        variables.put("productDirector", productDirector);
        variables.put("fortuneDirector", fortuneDirector);
        variables.put("riskDirector", riskDirector);
        variables.put("financeDirector", financeDirector);
        variables.put("productOperator", productOperator);
        variables.put("CEO", CEO);
        variables.put("productId", Integer.valueOf(this.id));
        return variables;
    }

    public Map<String, Object> transmitVariablesForP2pProductAudit(Map<String, Object> variables) {
        int userId = UserHelper.getEditUserNo();
        int productOperator = EmployeeModel.getInfo(DepartmentModel.getInfo(59).getEmpNo()).getUserNo();

        variables.put("creator", userId);
        variables.put("productOperator", productOperator);
        variables.put("p2pProductId", Integer.valueOf(this.id));
        return variables;
    }

    public Map<String, Object> transmitVariablesForSalesAudit(Map<String, Object> variables) {
        int userId = UserHelper.getEditUserNo();
        Employee employee = EmployeeModel.getEmpByUserId(userId);
        int leader = EmployeeModel.getInfo(employee.getParentNo()).getUserNo();
        int financeDirector = EmployeeModel.getInfo(DepartmentModel.getInfo(DeptHelper.DEPT_FINANCE_SHOP).getEmpNo()).getUserNo();
        String url = UrlHelper.buildWorkFlowSiteUrl("/workFlow/auditTask/list?navSub=我的任务");
        int shopOperation = EmployeeModel.getInfo(DepartmentModel.getInfo(DeptHelper.DEPT_SHOPOPERATOR).getEmpNo()).getUserNo();

        variables.put("creator", userId);//申请人
        variables.put("leader", leader);//上级领导
        variables.put("financeDirector", financeDirector);//财务审核人
        variables.put("shopOperation", shopOperation);//门店运营
        variables.put("salesId", Integer.valueOf(this.id));
        variables.put("url", url);
        return variables;
    }

    public Map<String, Object> transmitVariablesForProbationEvaluation(Map<String, Object> variables, String type) {
        int noticeUser = UserHelper.getEditUserNo();
        Employee employee = EmployeeModel.getEmpByUserId(Integer.valueOf(this.id));
        int positiveUser = employee.getUserNo();
        int CEO = EmployeeModel.getInfo(DepartmentModel.getInfo(DeptHelper.DEPT_PRESIDENT).getEmpNo()).getUserNo();
        int newHR = EmployeeModel.getInfo(DepartmentModel.getInfo(58).getEmpNo()).getUserNo();//  贺
        List<Integer> leaderList = new ArrayList<>();
        this.getLeaderListByEmpNo(employee.getId(), leaderList);
        if (leaderList.size() <= 1) {
            variables.put("CEO", CEO);
            addLetter(type, CEO, positiveUser);
        } else if (leaderList.size() == 2) {
            variables.put("deptLeader", EmployeeModel.getInfo(leaderList.get(0)).getUserNo());
            addLetter(type, EmployeeModel.getInfo(DepartmentModel.getInfo(getRootDeptNoByDeptNo(employee.getDeptNo())).getEmpNo()).getUserNo(), positiveUser);
        } else if (leaderList.size() > 2) {
            variables.put("leader", EmployeeModel.getInfo(leaderList.get(0)).getUserNo());
            variables.put("deptLeader", EmployeeModel.getInfo(DepartmentModel.getInfo(getRootDeptNoByDeptNo(employee.getDeptNo())).getEmpNo()).getUserNo());
            addLetter(type, EmployeeModel.getInfo(leaderList.get(0)).getUserNo(), positiveUser);
        }
        variables.put("leaderCount", leaderList.size());
        variables.put("noticeUser", noticeUser);
        variables.put("positiveUser", positiveUser);
        variables.put("NewHR", newHR);//人事（贺）

        return variables;
    }

    public void addLetter(String type, int userId, int positiveUser) {
        String empName = EmployeeModel.getEmpByUserId(positiveUser).getName();
        if (type.equals("probationEvaluationProcess")) {
            LetterModel.addReminds("您有下属员工即将转正", "已通知员工" + empName + "转正，填写试用期工作总结", userId);
        }
        if (type.equals("extendProbationApplicationProcess")) {
            LetterModel.addReminds("您有下属员工延迟转正", "已通知员工" + empName + "延迟转正", userId);
        }
    }

    public List<Integer> getLeaderListByEmpNo(int empNo, List<Integer> leaderList) {
        int leaderNo = EmployeeModel.getInfo(empNo).getParentNo();
        if (leaderNo != 0) {
            leaderList.add(leaderNo);
            getLeaderListByEmpNo(leaderNo, leaderList);
        }
        return leaderList;
    }

    public int getRootDeptNoByDeptNo(int deptno) {
        int dNo = DepartmentModel.getInfo(deptno).getParentNo();
        if (dNo != 1) {
            return getRootDeptNoByDeptNo(dNo);
        }
        return deptno;
    }

    public String deleteActivitis() {
        if (!StringHelper.isNullOrEmpty(this.activitiNo)) {
            int actRuTaskCode = ActRuTaskModel.deleteByActivitiNo(this.activitiNo);
            int actHiTaskinstMCode = ActHiTaskinstModel.deleteByActivitiNo(this.activitiNo);
            int actHiProcinstCode = ActHiProcinstModel.cancelHistoryTaskByActivitiNo(this.activitiNo);
            if (actRuTaskCode == 0 || actHiTaskinstMCode == 0 || actHiProcinstCode == 0) {
                this.setErrDesc("删除流程失败");
            } else {
                this.setErrDesc("删除流程成功");
            }
        }
        return SUCCESS;
    }

    public String updateActivitis() {
        if (!StringHelper.isNullOrEmpty(this.updateActivitiAssigneeInput) && !StringHelper.isNullOrEmpty(this.activitiNo)) {
            Employee employee = EmployeeModel.getInfo(Integer.parseInt(this.updateActivitiAssigneeInput));
            int actRuTaskCode = ActRuTaskModel.updateAssigneeByActivitiNo(this.activitiNo, employee.getUserNo() + "");
            int actHiTaskinstMCode = ActHiTaskinstModel.updateAssigneeByActivitiNo(this.activitiNo, employee.getUserNo() + "");
            if (actRuTaskCode == 0 || actHiTaskinstMCode == 0) {
                this.setErrCode("0000");
                this.setErrDesc("修改流程失败");
            } else {
                this.setErrCode("4040");
                this.setErrDesc("修改流程成功");
            }
        }

        return SUCCESS;
    }
}
