package com.hzfh.fmp.model.employee;

import com.hzfh.api.employee.model.Department;
import com.hzfh.api.employee.model.query.DepartmentCondition;
import com.hzfh.fmp.facade.employee.DepartmentFacade;
import com.hzfh.fmp.model.common.properties.DeptHelper;
import com.hzframework.contract.PagedList;

import java.util.ArrayList;
import java.util.List;

public class DepartmentModel {
    public static PagedList<Department> getPagingList(
            DepartmentCondition departmentCondition) {
        return DepartmentFacade.getPagingList(departmentCondition);
    }

    public static int add(Department department) {
        return DepartmentFacade.add(department);
    }

    public static int update(Department department) {
        return DepartmentFacade.update(department);
    }

    public static List<Department> getList() {
        return DepartmentFacade.getList();
    }

    public static Department getInfo(int id) {
        return DepartmentFacade.getInfo(id);
    }

    @Deprecated
    public static List<Department> getDeptlistToCombox() {
        return DepartmentFacade.getDeptlistToCombox();
    }

    public static List<Department> getDeptListByParentNo(int parentNo) {
        return DepartmentFacade.getDeptListByParentNo(parentNo);
    }

    public static List<Department> getDeptListByCompanyNo(int companyNo) {
        return DepartmentFacade.getDeptListByCompanyNo(companyNo);
    }

    public static List<Department> getDeptListByType(int deptType) {
        return DepartmentFacade.getDeptListByType(deptType);
    }

    public static List<Department> getDepartmentByDistrictNo(int districtNo) {
        return DepartmentFacade.getListByDistrictNo(districtNo);
    }

    public static int getParentDeptByDept(int deptNo) {
        return DepartmentFacade.getParentDeptByDept(deptNo);
    }

    public static List<Department> getDeptTypeBydeptNo(int deptNo) {
        return DepartmentFacade.getDeptTypeBydeptNo(deptNo);
    }

    public static List<Department> getChannel() {
        List<Department> departments = new ArrayList<Department>();
        List<Department> result = new ArrayList<Department>();
        departments = DepartmentModel.getList();
        if (departments != null && departments.size() > 0) {
            for (Department department : departments) {
                if (department.getParentNo() == DeptHelper.DEPT_SALES && department.getDeptType() == DeptHelper.TYEP_CHANNEL) {
                    result.add(department);
                }
            }
        }
        return result;
    }

    public static List<Department> getDirect() {
        List<Department> departments = new ArrayList<Department>();
        List<Department> result = new ArrayList<Department>();
        departments = DepartmentModel.getList();
        if (departments != null && departments.size() > 0) {
            for (Department department : departments) {
                if (department.getParentNo() == DeptHelper.DEPT_SALES && department.getDeptType() == DeptHelper.TYEP_DIRECT) {
                    result.add(department);
                }
            }
        }
        return result;
    }

    @Deprecated
    public static List<Department> getSonOfWealthManagementCenter() {
        List<Department> result = new ArrayList<Department>();
        result.add((Department) DepartmentModel.getChannel());
        result.add((Department) DepartmentModel.getDirect());
        return result;
    }

    @Deprecated
    public static List<Department> getAllOfWealthManagementCenter() {
        List<Department> result = new ArrayList<Department>();
        result.add((Department) DepartmentModel.getChannel());
        result.add((Department) DepartmentModel.getDirect());
        Department department = new Department();
        department = DepartmentModel.getInfo(DeptHelper.DEPT_SALES);
        result.add(department);
        return result;
    }

    public static List<Department> getShops() {
        List<Department> departments = new ArrayList<Department>();
        List<Department> result = new ArrayList<Department>();
        departments = DepartmentModel.getList();
        if (departments != null && departments.size() > 0) {
            for (Department department : departments) {
                if (department.getParentNo() == DeptHelper.DEPT_SALES_SHOP && department.getDeptType() == DeptHelper.TYEP_SHOP) {
                    result.add(department);
                }
            }
        }
        return result;
    }

    public static List<Department> getShopsAll() {
        List<Department> result = new ArrayList<Department>();
        result = DepartmentModel.getShops();
        Department department = new Department();
        department = DepartmentModel.getInfo(DeptHelper.DEPT_SALES_SHOP);
        result.add(department);
        return result;
    }

    public static Department getDepartmentByDeptNo(int deptNo) {
        // TODO Auto-generated method stub
        return DepartmentFacade.getDepartmentByDeptNo(deptNo);
    }

}