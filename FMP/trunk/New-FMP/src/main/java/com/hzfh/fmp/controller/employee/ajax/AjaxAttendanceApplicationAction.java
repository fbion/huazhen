package com.hzfh.fmp.controller.employee.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.employee.model.AttendanceApplication;
import com.hzfh.api.employee.model.Employee;
import com.hzfh.api.employee.model.query.AttendanceApplicationCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.common.helper.ExcelHelper;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.employee.AttendanceApplicationModel;
import com.hzfh.fmp.model.employee.EmployeeModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;


public class AjaxAttendanceApplicationAction extends JqGridBaseAction<AttendanceApplication> {
    private AttendanceApplication info;

    public AttendanceApplication getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = JSON.parseObject(info, AttendanceApplication.class);
    }

    private String empName;

    public String getEmpName() {
        return empName;
    }

    private String byName;
    private String byDept;
    private String byType;
    private String byYear;
    private String byMonth;
    private String byStatus;

    public String getByStatus() {
        return byStatus;
    }

    public void setByStatus(String byStatus) {
        this.byStatus = byStatus;
    }

    public String getByName() {
        return byName;
    }

    public void setByName(String byName) {
        this.byName = byName;
    }

    public String getByDept() {
        return byDept;
    }

    public void setByDept(String byDept) {
        this.byDept = byDept;
    }

    public String getByType() {
        return byType;
    }

    public void setByType(String byType) {
        this.byType = byType;
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

    private String showAllList;

    public String getShowAllList() {
        return showAllList;
    }

    public void setShowAllList(String showAllList) {
        this.showAllList = showAllList;
    }
    private String activitiID;
    
    public void setActivitiID(String activitiID) {
		this.activitiID = activitiID;
	}

	public AttendanceApplicationCondition getCondition() {
        AttendanceApplicationCondition attendanceApplicationCondition = new AttendanceApplicationCondition();
        attendanceApplicationCondition.setPageSize(this.getPageSize());
        attendanceApplicationCondition.setPageIndex(this.getPageIndex());
        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        attendanceApplicationCondition.setSortItemList(sortItemList);

        if ("query".equals(this.showAllList)) {
            attendanceApplicationCondition.setWorkMateString(null);
        } else {
            List<Integer> workmate = UserHelper.getUserCache().getWorkMate();
            List<Integer> empList = new ArrayList<Integer>();
            if (workmate != null) {
                for (Integer user_no : workmate) {
                    empList.add(EmployeeModel.getEmpByUserId(user_no).getId());
                }
            }
            int emp_no = EmployeeModel.getEmpByUserId(UserHelper.getUserCache().getUserId()).getId();
            if (empList.size() == 0) {
                attendanceApplicationCondition.setWorkMateString(String.valueOf(emp_no));

            } else {
                empList.add(emp_no);
                String workMateString = StringHelper.listToString(empList);
                attendanceApplicationCondition.setWorkMateString(workMateString);
            }
        }

        if (!StringHelper.isNullOrEmpty(this.byName)) {
            attendanceApplicationCondition.setByName(Integer.parseInt(this.byName));
        }
        if (!StringHelper.isNullOrEmpty(this.byDept)) {
            attendanceApplicationCondition.setByDept(Integer.parseInt(this.byDept));
        }
        if (!StringHelper.isNullOrEmpty(this.byType)) {
            attendanceApplicationCondition.setByType(Integer.parseInt(this.byType));
        } else {
            attendanceApplicationCondition.setByType(-1);
        }
        if (!StringHelper.isNullOrEmpty(this.byYear)) {
            attendanceApplicationCondition.setByYear(Integer.parseInt(this.byYear));
        }
        if (!StringHelper.isNullOrEmpty(this.byMonth)) {
            attendanceApplicationCondition.setByMonth(Integer.parseInt(this.byMonth));
        }
        if (!StringHelper.isNullOrEmpty(this.byStatus)) {
            attendanceApplicationCondition.setByStatus(Integer.parseInt(this.byStatus));
        } else {
            attendanceApplicationCondition.setByStatus(-1);
        }
        return attendanceApplicationCondition;
    }

    @Override
    public String execute() throws Exception {
        PagedList<AttendanceApplication> attendanceApplicationPagedList = AttendanceApplicationModel.getPagingList(this.getCondition());
        this.setResultList(attendanceApplicationPagedList.getResultList());
        this.setPageCount(attendanceApplicationPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(attendanceApplicationPagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(attendanceApplicationPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }

    public String exportExcel() {
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.getExcelAttendanceApplication(this.getCondition());
        return null;
    }

    public String edit() {
        info.setEditUserNo(UserHelper.getEditUserNo());
        int id = 0;
        if (this.getOper().equalsIgnoreCase("add")) {
            info.setInUserNo(UserHelper.getEditUserNo());
//            info.setWorkFlowStatus(0);
            id = AttendanceApplicationModel.add(info);
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
            	if(!StringHelper.isNullOrEmpty(this.activitiID)){
            		info.setActivitiNo(this.activitiID);
            	}
                if (this.getOper().equalsIgnoreCase("edit")) {
                    if (AttendanceApplicationModel.update(info) > 0) {
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
        } else {
            if (Integer.valueOf(this.getId()) != 0) {
                this.info = AttendanceApplicationModel.getInfo(Integer.parseInt(this.getId()));
            } else {
                AttendanceApplication application = new AttendanceApplication();
                Employee employee = EmployeeModel.getInfo(UserHelper.getUserCache().getEmpId());
                if (employee != null) {
                    application.setDeptNo(employee.getDeptNo());
                    application.setPositionNo(employee.getPositionNo());
                    application.setEmpNo(employee.getId());
                }
                this.info = application;
            }

            if (this.info == null) {
                this.setErrCode("No Info");
                this.setErrDesc("No Info");
            }
        }
        this.empName = UserHelper.getUserCache().getEmpName();
        return SUCCESS;
    }

}
