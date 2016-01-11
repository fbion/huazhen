package com.hzfh.fmp.controller.ajax;

import com.hzfh.api.employee.model.Company;
import com.hzfh.api.employee.model.Department;
import com.hzfh.api.employee.model.Employee;
import com.hzfh.api.permission.model.Role;
import com.hzfh.api.permission.model.User;
import com.hzfh.fmp.controller.common.BaseAction;
import com.hzfh.fmp.model.UserCache;
import com.hzfh.fmp.model.common.cache.CacheManager;
import com.hzfh.fmp.model.common.cache.CachePrefix;
import com.hzfh.fmp.model.common.enumeration.LogConstant;
import com.hzfh.fmp.model.common.helper.EncodeHelper;
import com.hzfh.fmp.model.common.helper.LogHelper;
import com.hzfh.fmp.model.common.state.StateValues;
import com.hzfh.fmp.model.employee.CompanyModel;
import com.hzfh.fmp.model.employee.DepartmentModel;
import com.hzfh.fmp.model.employee.EmployeeModel;
import com.hzfh.fmp.model.permission.RoleModel;
import com.hzfh.fmp.model.permission.UserModel;
import com.hzframework.helper.DateHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by paul on 15-1-12.
 */
public class AjaxLogin extends BaseAction {
    public static final LogHelper logger = LogHelper.getLogger(AjaxLogin.class.getName());
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String execute() throws Exception {
        msg = "";
        User loginUser = new User();
        loginUser.setName(this.getName());
        loginUser.setPassword(EncodeHelper.encryptPWD(this.getName(),this.getPassword()));
        User user = UserModel.login(loginUser);
        if (user == null) {
            msg = "用户名或密码不正确!";
            logger.error("登录失败！！！");
            return SUCCESS;
        }
        UserModel.updateLastLoginById(user.getId(),DateHelper.getCurrentTime());
        Employee employee = EmployeeModel.getEmpByUserId(user.getId());
        if (employee == null) {
            msg = "请通知管理员完善员工信息!";
            return SUCCESS;
        }
        if (employee.getStatus() == 2) {
            msg = "您已离职，不能登录!";
            return SUCCESS;
        }
        UserCache userCache = new UserCache();
        userCache.setUserId(user.getId());
        userCache.setUserName(user.getName());
        userCache.setLastLogin(user.getLastLogin());
        userCache.setEmpId(employee.getId());
        userCache.setEmpName(employee.getName());
        userCache.setEmpEmail(employee.getEmail());
        userCache.setEmpQQ(employee.getQq());
        Department dept = DepartmentModel.getInfo(employee.getDeptNo());
        if (dept == null) {
            msg = "请通知管理员完善部门信息!";
            return SUCCESS;
        }
        userCache.setDeptId(dept.getId());
        userCache.setDeptName(dept.getName());
        userCache.setDeptType(dept.getDeptType());
        Company company = CompanyModel.getCompanyByCompanyId(dept
                .getCompanyNo());
        if (company == null) {
            msg = "请通知管理员完善公司信息!";
            return SUCCESS;
        }
        userCache.setCompanyId(company.getId());

        Role role = RoleModel.getRoleByUserId(user.getId());
        if (role == null) {
            msg = "请通知管理员完善角色信息!";
            return SUCCESS;
        }
        userCache.setRoleId(role.getId());
        // recursion
        List<Employee> employeeWorkMate = new ArrayList<Employee>();
        this.getWorkMateById(employee.getId(), employeeWorkMate);
        // get list to id
        if (employeeWorkMate.size() > 0) {
            userCache.setEmployeeWorkMateList(employeeWorkMate);
            List<Integer> x = new ArrayList<Integer>();
            for (Employee emp : employeeWorkMate) {
                x.add(emp.getUserNo());
            }
            userCache.setWorkMate(x);
        }
        List<Integer> leaderList = new ArrayList<>();
        leaderList = this.getLeaderListByEmpNo(employee.getId(),leaderList);
        userCache.setLeaderList(leaderList);
        //CookieManager.getInstance().setLoginCookie(user);
        StateValues.setLastLogin(user.getLastLogin());
        StateValues.setUserId(user.getId());

        String cacheKey = EncodeHelper.encryptPWD(String.valueOf(user.getId()), user.getLastLogin().toString());
        CacheManager.set(CachePrefix.LOGIN_INFO_PREFIX,cacheKey, 24 * 60 * 60, userCache);

        logger.info("login success",user.getId());
        return SUCCESS;
    }

    // recursion subordinate's subordinate all
    private void getWorkMateById(int id, List<Employee> employeeWorkMateList) {
        List<Employee> employeeWorkMate = EmployeeModel.getEmpListByParentNo(id);
        if (employeeWorkMate != null && employeeWorkMate.size() > 0) {
            employeeWorkMateList.addAll(employeeWorkMate);
            for (Employee WorkMate : employeeWorkMate) {
                this.getWorkMateById(WorkMate.getId(), employeeWorkMateList);
            }
        }
    }

    //get all leaders for employee
    public List<Integer> getLeaderListByEmpNo(int empNo,List<Integer> leaderList){
        int leaderNo = EmployeeModel.getInfo(empNo).getParentNo();
        if(leaderNo != 0){
            leaderList.add(leaderNo);
            getLeaderListByEmpNo(leaderNo, leaderList);
        }
        return leaderList;
    }

}
