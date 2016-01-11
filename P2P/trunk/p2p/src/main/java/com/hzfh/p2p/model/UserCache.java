package com.hzfh.p2p.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class UserCache implements Serializable {
    private int userId;
    private String userName;
    private String password;
    private Timestamp lastLogin;
    private String empName;
    private int empId;
    private String empEmail;
    private String empQQ;
    private int roleId;
    private int companyId;
    private int deptId;
    private String deptName;
    private String cardNumber;
    

    public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    private List<Integer> workMate;
    private List employeeWorkMateList;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Timestamp lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public String getEmpQQ() {
        return empQQ;
    }

    public void setEmpQQ(String empQQ) {
        this.empQQ = empQQ;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public List<Integer> getWorkMate() {
        return workMate;
    }

    public void setWorkMate(List<Integer> workMate) {
        this.workMate = workMate;
    }

    public List getEmployeeWorkMateList() {
        return employeeWorkMateList;
    }

    public void setEmployeeWorkMateList(List employeeWorkMateList) {
        this.employeeWorkMateList = employeeWorkMateList;
    }

}
