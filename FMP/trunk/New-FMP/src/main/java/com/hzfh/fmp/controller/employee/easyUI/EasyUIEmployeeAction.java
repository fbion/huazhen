package com.hzfh.fmp.controller.employee.easyUI;

import com.hzfh.api.employee.model.Department;
import com.hzfh.api.employee.model.Employee;
import com.hzfh.api.employee.model.query.EmployeeCondition;
import com.hzfh.fmp.controller.common.EasyUIBaseAction;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.employee.DepartmentModel;
import com.hzfh.fmp.model.employee.EmployeeModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.contract.SortType;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;


public class EasyUIEmployeeAction extends EasyUIBaseAction<Employee> {
	private String byName;
    private String bySex;
    private String byCompany;
    private String byDept;
    private String status;
    private String byVerify;

    public void setByName(String byName) {
		this.byName = byName;
	}


	public void setBySex(String bySex) {
		this.bySex = bySex;
	}


	public void setByCompany(String byCompany) {
		this.byCompany = byCompany;
	}


	public void setByDept(String byDept) {
		this.byDept = byDept;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public void setByVerify(String byVerify) {
		this.byVerify = byVerify;
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
        EmployeeCondition employeeCondition = new EmployeeCondition();
        employeeCondition.setPageSize(this.getPageSize());
        employeeCondition.setPageIndex(this.getPage());
        List<SortItem> sortItemList = new ArrayList<>();
        for (SortItem sortItem : this.getSortList()) {
            SortItem newSortItem = new SortItem();
            newSortItem.setSortFeild(sortItem.getSort());
            newSortItem.setSortType("asc".equalsIgnoreCase(sortItem.getOrder()) ? SortType.ASC : SortType.DESC);
            sortItemList.add(newSortItem);
        }
        employeeCondition.setSortItemList(sortItemList);
        if ("query".equals(this.showAllList)) {
            employeeCondition.setWorkMateString(null);
        } else {
            List<Integer> workmate = UserHelper.getUserCache().getWorkMate();
            if (workmate != null) {
                workmate.add(UserHelper.getUserCache().getUserId());
                String workMateString = StringHelper.listToString(workmate);
                employeeCondition.setWorkMateString(workMateString);
            } else {
                employeeCondition.setWorkMateString(String.valueOf(UserHelper.getUserCache().getUserId()));
            }
        }
        if (!StringHelper.isNullOrEmpty(this.byName)) {
            employeeCondition.setName(this.byName);
        }
        if (StringHelper.isNullOrEmpty(this.bySex)) {
            employeeCondition.setSex(0);
        } else {
            employeeCondition.setSex(Integer.parseInt(this.bySex));
        }
        if (StringHelper.isNullOrEmpty(this.byCompany)) {
            employeeCondition.setCompany(0);
        } else {
            employeeCondition.setCompany(Integer.parseInt(this.byCompany));
        }
        if (StringHelper.isNullOrEmpty(this.status)) {
            employeeCondition.setByStatus("1,5");
        }else{
            if(Integer.parseInt(this.status)==0){
                employeeCondition.setByStatus("");
            }else{
                employeeCondition.setByStatus(this.status);
            }
        }
        if (!StringHelper.isNullOrEmpty(this.byDept)) {
            List<Department> departmentList = new ArrayList<Department>();
            getWorkMateById(Integer.parseInt(this.byDept), departmentList);
            List<Integer> workMate = new ArrayList<Integer>();
            for (Department department : departmentList) {
                workMate.add(department.getId());
            }
            workMate.add(Integer.parseInt(this.byDept));
            employeeCondition.setDept(StringHelper.listToString(workMate));
        }
        if (StringHelper.isNullOrEmpty(this.getIsTest())) {
            employeeCondition.setIsTest((byte) 0);
        } else {
            employeeCondition.setIsTest(Byte.valueOf(this.getIsTest()));
        }
        if(!StringHelper.isNullOrEmpty(this.byVerify)){
            employeeCondition.setVerify(Byte.valueOf(this.byVerify));
        }else{
            employeeCondition.setVerify((byte)-1);
        }
        PagedList<Employee> employeePagedList = EmployeeModel.getPagingList(employeeCondition);
        this.setRows(employeePagedList.getResultList());
        this.setTotal(employeePagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }
	private void getWorkMateById(int id, List<Department> departmentList) {
        List<Department> departmentWorkMate = DepartmentModel.getDeptListByParentNo(id);
        if (departmentWorkMate != null && departmentWorkMate.size() > 0) {
            departmentList.addAll(departmentWorkMate);
            for (Department WorkMate : departmentWorkMate) {
                this.getWorkMateById(WorkMate.getId(), departmentList);
            }
        }
    }

}
