package com.hzfh.fmp.controller.employee.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.employee.model.Employee;
import com.hzfh.api.employee.model.ProbationWorkSummary;
import com.hzfh.api.employee.model.query.ProbationWorkSummaryCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.employee.EmployeeModel;
import com.hzfh.fmp.model.employee.ProbationEvaluationModel;
import com.hzfh.fmp.model.employee.ProbationWorkSummaryModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;


public class AjaxProbationWorkSummaryAction extends JqGridBaseAction<ProbationWorkSummary> {
    private String activitiID;
    private String empNo;

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getActivitiID() {
        return activitiID;
    }

    public void setActivitiID(String activitiID) {
        this.activitiID = activitiID;
    }

    private ProbationWorkSummary info;

    public ProbationWorkSummary getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = JSON.parseObject(info, ProbationWorkSummary.class);
    }

    private String byName;
    private String bySelectCompany;
    private String bySelectDepartment;
    private String bySelectPositionNo;
    private String byYear;
    private String byMonth;
    private String showAllList;

    public String getByName() {
        return byName;
    }

    public void setByName(String byName) {
        this.byName = byName;
    }

    public String getBySelectCompany() {
        return bySelectCompany;
    }

    public void setBySelectCompany(String bySelectCompany) {
        this.bySelectCompany = bySelectCompany;
    }

    public String getBySelectDepartment() {
        return bySelectDepartment;
    }

    public void setBySelectDepartment(String bySelectDepartment) {
        this.bySelectDepartment = bySelectDepartment;
    }

    public String getBySelectPositionNo() {
        return bySelectPositionNo;
    }

    public void setBySelectPositionNo(String bySelectPositionNo) {
        this.bySelectPositionNo = bySelectPositionNo;
    }

    public String getByYear() {
        return byYear;
    }

    public void setByYear(String byYear) {
        this.byYear = byYear;
    }

    public String getByMonth() {
        return byMonth;
    }

    public void setByMonth(String byMonth) {
        this.byMonth = byMonth;
    }

    public String getShowAllList() {
        return showAllList;
    }

    public void setShowAllList(String showAllList) {
        this.showAllList = showAllList;
    }

    public ProbationWorkSummaryCondition getCondition() {
        ProbationWorkSummaryCondition probationWorkSummaryCondition = new ProbationWorkSummaryCondition();
        probationWorkSummaryCondition.setPageSize(this.getPageSize());
        probationWorkSummaryCondition.setPageIndex(this.getPageIndex());

        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        probationWorkSummaryCondition.setSortItemList(sortItemList);

        if ("query".equals(this.showAllList)) {
            probationWorkSummaryCondition.setWorkMateString(null);
        } else {
            List<Integer> workmate = UserHelper.getUserCache().getWorkMate();
            if (workmate != null) {
                List<Integer> workmateEmpNoList = new ArrayList<Integer>();
                for (int i = 0; i < workmate.size(); i++) {
                    int empNo = EmployeeModel.getEmpByUserId(workmate.get(i)).getId();
                    workmateEmpNoList.add(empNo);
                }
                workmateEmpNoList.add(EmployeeModel.getEmpByUserId(UserHelper.getUserCache().getUserId()).getId());
                String workMateString = StringHelper.listToString(workmateEmpNoList);
                probationWorkSummaryCondition.setWorkMateString(workMateString);
            } else {
                probationWorkSummaryCondition.setWorkMateString(String.valueOf(EmployeeModel.getEmpByUserId(UserHelper.getUserCache().getUserId()).getId()));
            }
        }
        if (!StringHelper.isNullOrEmpty(this.byName)) {
            Employee e = EmployeeModel.getEmpByEmpName(this.byName);
            if (e != null) {
                probationWorkSummaryCondition.setEmpNo(e.getId());
            } else {
                probationWorkSummaryCondition.setEmpNo(-1);
            }
        }
        if (!StringHelper.isNullOrEmpty(this.bySelectPositionNo)) {
            probationWorkSummaryCondition.setPositionNo(Integer.valueOf(this.bySelectPositionNo));
        }
        if (!StringHelper.isNullOrEmpty(this.bySelectCompany)) {
            probationWorkSummaryCondition.setCompanyNo(Integer.valueOf(this.bySelectCompany));
        }
        if (!StringHelper.isNullOrEmpty(this.bySelectDepartment)) {
            probationWorkSummaryCondition.setDeptNo(Integer.valueOf(this.bySelectDepartment));
        }

        if (!StringHelper.isNullOrEmpty(this.byYear) && !"".equals(this.byYear) && !"0".equals(this.byYear)) {
            if (StringHelper.isNullOrEmpty(this.byMonth) || "".equals(this.byMonth) || "0".equals(this.byMonth)) {
                probationWorkSummaryCondition.setDateDown(this.byYear + "-" + "01" + "-" + "01");
                probationWorkSummaryCondition.setDateUp(Integer.valueOf(this.byYear) + 1 + "-" + "01" + "-" + "01");
            } else {
                probationWorkSummaryCondition.setDateDown(this.byYear + "-" + this.byMonth + "-" + "01");
                int nextMonth = Integer.valueOf(this.byMonth);
                if (Integer.valueOf(this.byMonth) < 12) {
                    nextMonth = Integer.valueOf(this.byMonth) + 1;
                } else {
                    nextMonth = 1;
                    this.byYear = Integer.valueOf(this.byYear) + 1 + "";
                }
                probationWorkSummaryCondition.setDateUp(this.byYear + "-" + nextMonth + "-" + "01");
            }
        }

        return probationWorkSummaryCondition;
    }

    @Override
    public String execute() throws Exception {


        PagedList<ProbationWorkSummary> probationWorkSummaryPagedList = ProbationWorkSummaryModel.getPagingList(this.getCondition());
        this.setResultList(probationWorkSummaryPagedList.getResultList());
        this.setPageCount(probationWorkSummaryPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(probationWorkSummaryPagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(probationWorkSummaryPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }

    public String edit() {
        info.setEditUserNo(UserHelper.getEditUserNo());
        int id = 0;
        if (this.getOper().equalsIgnoreCase("add")) {
            info.setInUserNo(UserHelper.getEditUserNo());
            if (!StringHelper.isNullOrEmpty(activitiID)) {
                info.setActivitiNo(activitiID);
            }
            id = ProbationWorkSummaryModel.add(info);
            if (id > 0) {
                this.setErrDesc(String.valueOf(id));
            } else {
                this.setErrCode("add failed");
                this.setErrDesc("add failed");
            }

        } else {
            if (info.getId() == 0) {
                this.setErrCode("NoID");
                this.setErrDesc("NoID");
            } else {
                if (this.getOper().equalsIgnoreCase("edit")) {
                    if (!StringHelper.isNullOrEmpty(activitiID)) {
                        info.setActivitiNo(activitiID);
                    }
                    if (ProbationWorkSummaryModel.update(info) > 0) {
                        this.setErrDesc(String.valueOf(info.getId()));
                    } else {
                        this.setErrCode("update failed");
                        this.setErrDesc("update failed");
                    }

                }
            }
        }

        return SUCCESS;
    }

    public String getInfoById() {
        if (StringHelper.isNullOrEmpty(this.getId())) {
            this.setErrCode("NoID");
            this.setErrDesc("NoID");
            return SUCCESS;
        }
        this.info = ProbationWorkSummaryModel.getInfo(Integer.parseInt(this.getId()));
        if (this.info == null) {
            this.setErrCode("No Info");
            this.setErrDesc("No Info");
            return SUCCESS;
        }
        this.info.setEmpName(EmployeeModel.getInfo(info.getEmpNo()).getName());
        return SUCCESS;
    }

    public String ajaxGetWorkSummaryByEmpNo() {
        if (StringHelper.isNullOrEmpty(this.getEmpNo())) {
            this.setErrCode("NoEmpNo");
            this.setErrDesc("NoEmpNo");
        } else {
            this.info = ProbationWorkSummaryModel.getInfoByEmpNo(Integer.parseInt(this.empNo));
            //info.setId(14);
            if (this.info == null) {
                this.setErrCode("No Info");
                this.setErrDesc("No Info");
            }
        }

        return SUCCESS;
    }

}
