package com.hzfh.fmp.controller.employee.easyUI;

import com.hzfh.api.employee.model.AttendanceApplication;
import com.hzfh.api.employee.model.query.AttendanceApplicationCondition;
import com.hzfh.fmp.controller.common.EasyUIBaseAction;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.employee.AttendanceApplicationModel;
import com.hzfh.fmp.model.employee.EmployeeModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.contract.SortType;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;


public class EasyUIAttendanceApplicationAction extends EasyUIBaseAction<AttendanceApplication> {
	private String byName;
    private String byDept;
    private String byType;
    private String byYear;
    private String byMonth;
    private String byStatus;
    
    public void setByName(String byName) {
		this.byName = byName;
	}

	public void setByDept(String byDept) {
		this.byDept = byDept;
	}

	public void setByType(String byType) {
		this.byType = byType;
	}

	public void setByYear(String byYear) {
		this.byYear = byYear;
	}

	public void setByMonth(String byMonth) {
		this.byMonth = byMonth;
	}

	public void setByStatus(String byStatus) {
		this.byStatus = byStatus;
	}
	private String showAllList;

    public String getShowAllList() {
        return showAllList;
    }

    public void setShowAllList(String showAllList) {
        this.showAllList = showAllList;
    }
    @Override
    public String execute() throws Exception {
        AttendanceApplicationCondition attendanceApplicationCondition = new AttendanceApplicationCondition();
        attendanceApplicationCondition.setPageSize(this.getPageSize());
        attendanceApplicationCondition.setPageIndex(this.getPage());
        List<SortItem> sortItemList = new ArrayList<>();
        for (SortItem sortItem : this.getSortList()) {
            SortItem newSortItem = new SortItem();
            newSortItem.setSortFeild(sortItem.getSort());
            newSortItem.setSortType("asc".equalsIgnoreCase(sortItem.getOrder()) ? SortType.ASC : SortType.DESC);
            sortItemList.add(newSortItem);
        }
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
        PagedList<AttendanceApplication> attendanceApplicationPagedList = AttendanceApplicationModel.getPagingList(attendanceApplicationCondition);
        this.setRows(attendanceApplicationPagedList.getResultList());
        this.setTotal(attendanceApplicationPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }


}
