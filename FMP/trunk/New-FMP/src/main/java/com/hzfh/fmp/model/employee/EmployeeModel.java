package com.hzfh.fmp.model.employee;

import com.hzfh.api.employee.model.Employee;
import com.hzfh.api.employee.model.query.EmployeeCondition;
import com.hzfh.fmp.facade.employee.EmployeeFacade;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzframework.contract.PagedList;

import java.util.ArrayList;
import java.util.List;

public class EmployeeModel {
    public static PagedList<Employee> getPagingList(EmployeeCondition employeeCondition) {
        return EmployeeFacade.getPagingList(employeeCondition);
    }

    public static int add(Employee employee) {
        return EmployeeFacade.add(employee);
    }

    public static int update(Employee employee) {
        return EmployeeFacade.update(employee);
    }

    public static List<Employee> getList() {
        return EmployeeFacade.getList();
    }
    public static List<Employee> getEmpListNoTest() {
        return EmployeeFacade.getEmpListNoTest();
    }

    public static Employee getInfo(int id) {
        return EmployeeFacade.getInfo(id);
    }

    public static List<Employee> getInfoByCondition(EmployeeCondition employeeCondition){
        return EmployeeFacade.getInfoByCondition(employeeCondition);
    }
    @Deprecated
	public static List<Employee> getEmpListByEmpId(int empId) {
		 return EmployeeFacade.getEmpListByEmpId(empId);
	}

	public static Employee getEmpByUserId(int userId) {
		return EmployeeFacade.getEmpByUserId(userId);
	}

	public static List<Employee> getEmpListByDept(int deptNo) {
		return EmployeeFacade.getEmpListByDept(deptNo);
	}
	public static List<Employee> getEmpListByDeptAndStatus(int deptNo,String status) {
		return EmployeeFacade.getEmpListByDeptAndStatus(deptNo,status);
	}
	
	public static List<Employee> getEmpListByParentNo(int id) {
		return EmployeeFacade.getEmpListByParentNo(id);
	}
	public static List<Employee> getEmpByPositionNoAndStoreNo(int positionNo,int storeNo) {
		return EmployeeFacade.getEmpByPositionNoAndStoreNo(positionNo, storeNo);
	}
	public static List<Employee> getEmpByPositionNoAndStoreNoIsUse(int positionNo,int storeNo,int status) {
		return EmployeeFacade.getEmpByPositionNoAndStoreNoIsUse(positionNo, storeNo,status);
	}

	public static int addFilePath(Employee employeeFile) {
		return EmployeeFacade.addFilePath(employeeFile);
	}

	public static List<Employee> getEmpListByPositionNo(int positionNo) {
		return EmployeeFacade.getEmpListByPositionNo(positionNo);
	}

	public static int updateEmpByEmpDetail(Employee employee){
		return EmployeeFacade.updateEmpByEmpDetail(employee);
	}

	public static Employee getEmpByEmpName(String byName) {
		// TODO Auto-generated method stub
		return EmployeeFacade.getEmpByEmpName(byName);
	}

    public static int updateIsSendEmailById(int id){
        return EmployeeFacade.updateIsSendEmailById(id);
    }
    
    public static List<Employee> getEmployeeSubordinateListByStatus(int status){
    	List<Employee> employeeList = UserHelper.getUserCache().getEmployeeWorkMateList();
    	List<Employee> resultList = new ArrayList<Employee>();
    	if (employeeList!=null&&employeeList.size()>0) {
    		for (Employee employee : employeeList) {
				if (employee.getStatus()==status) {
					resultList.add(employee);
				}
			}
		}
    	return resultList;
    }
    public static List<Employee> getEmployeeSubordinateListByStatusAgainst(int status){
    	List<Employee> employeeList = UserHelper.getUserCache().getEmployeeWorkMateList();
    	List<Employee> resultList = new ArrayList<Employee>();
    	if (employeeList!=null&&employeeList.size()>0) {
    		for (Employee employee : employeeList) {
				if (employee.getStatus()!=status) {
					resultList.add(employee);
				}
			}
		}
    	return resultList;
    }
    
	public static List<Employee> getNowEmpListByPositionNo(int positionNo) {
		// TODO Auto-generated method stub
		return EmployeeFacade.getNowEmpListByPositionNo(positionNo);
	}

	public static List<Employee> getEmpListByStatus(int status) {
		return EmployeeFacade.getEmpListByStatus(status);
	}

	public static List<Employee> getEmpListIsTest(byte isTest) {
		return EmployeeFacade.getEmpListIsTest(isTest);
	}

	public static int updateCheckById(int id,byte status) {
		return EmployeeFacade.updateCheckById(id,status);
	}

	public static int updateStatusByEmpNo(int empNo) {
		return EmployeeFacade.updateStatusByEmpNo(empNo);
		
	}

	public static List<Employee> getListForExcel(EmployeeCondition employeeCondition) {
		// TODO Auto-generated method stub
		return EmployeeFacade.getListForExcel(employeeCondition);
	}

}
