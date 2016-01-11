package com.hzfh.fmp.controller.employee.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.baseInfo.model.Email;
import com.hzfh.api.employee.model.Department;
import com.hzfh.api.employee.model.Employee;
import com.hzfh.api.employee.model.EmployeeDetail;
import com.hzfh.api.employee.model.query.EmployeeCondition;
import com.hzfh.api.permission.model.User;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.UserCache;
import com.hzfh.fmp.model.baseInfo.EmailModel;
import com.hzfh.fmp.model.baseInfo.LetterModel;
import com.hzfh.fmp.model.common.EnumListCacheModel;
import com.hzfh.fmp.model.common.PageAlias;
import com.hzfh.fmp.model.common.helper.CodeHelper;
import com.hzfh.fmp.model.common.helper.EncodeHelper;
import com.hzfh.fmp.model.common.helper.MailHelper;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.customer.CustomerPersonalModel;
import com.hzfh.fmp.model.employee.DepartmentModel;
import com.hzfh.fmp.model.employee.EmployeeDetailModel;
import com.hzfh.fmp.model.employee.EmployeeModel;
import com.hzfh.fmp.model.employee.PositionModel;
import com.hzfh.fmp.model.permission.UserModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;


import java.util.ArrayList;
import java.util.List;


public class AjaxEmployeeAction extends JqGridBaseAction<Employee> {

    private String sysUser;
    private String sysPwd;

    public String getSysUser() {
        return sysUser;
    }

    public void setSysUser(String sysUser) {
        this.sysUser = sysUser;
    }

    public String getSysPwd() {
        return sysPwd;
    }

    public void setSysPwd(String sysPwd) {
        this.sysPwd = sysPwd;
    }


    private String byName;
    private String bySex;
    private String byCompany;
    private String byDept;
    private String status;
    private String byVerify;

    public void setByVerify(String byVerify) {
        this.byVerify = byVerify;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getByName() {
        return byName;
    }

    public void setByName(String byName) {
        this.byName = byName;

    }

    public String getBySex() {
        return bySex;
    }

    public void setBySex(String bySex) {
        this.bySex = bySex;
    }

    public String getByCompany() {
        return byCompany;
    }

    public void setByCompany(String byCompany) {
        this.byCompany = byCompany;
    }

    public String getByDept() {
        return byDept;
    }

    public void setByDept(String byDept) {
        this.byDept = byDept;
    }


    private List<Employee> resultList;

    private int param;

    public void setParam(int param) {
        this.param = param;
    }

    private Employee info;

    public Employee getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = JSON.parseObject(info, Employee.class);
    }

    @Override
    public List<Employee> getResultList() {
        return resultList;
    }

    @Override
    public void setResultList(List<Employee> resultList) {
        this.resultList = resultList;
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
        employeeCondition.setPageIndex(this.getPageIndex());
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
        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        employeeCondition.setSortItemList(sortItemList);
        PagedList<Employee> employeePagedList = EmployeeModel.getPagingList(employeeCondition);
        this.setResultList(employeePagedList.getResultList());
        this.setPageCount(employeePagedList.getPagingInfo().getPageCount());
        this.setPageIndex(employeePagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(employeePagedList.getPagingInfo().getTotalCount());
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
    public String edit() {
        info.setEditUserNo(UserHelper.getEditUserNo());
        int id = 0;
        if (this.getOper().equalsIgnoreCase("add")) {
            info.setInUserNo(UserHelper.getEditUserNo());
            info.setCode(CodeHelper.getCode("codeEmp", "EMP"));
            if (!StringHelper.isNullOrEmpty(this.sysUser) && !StringHelper.isNullOrEmpty(this.sysPwd)) {
                User user = new User();
                user.setName(this.sysUser);
                user.setPassword(EncodeHelper.encryptPWD(this.sysUser, this.sysPwd));
                int userId = UserModel.add(user);
                if (userId > 0) {
                    info.setEmail(this.sysUser+"@bestinvestor.com.cn");
                    info.setUserNo(userId);
                    id = EmployeeModel.add(info);
                    if (id > 0) {
                        this.setErrDesc(String.valueOf(id));
                    } else {
                        this.setErrCode("add failed");
                        this.setErrDesc("add failed");
                    }
                } else {
                    this.setErrCode("set system user failed");
                    this.setErrDesc("set system user failed");
                }
            } else {
                this.setErrCode("no system user");
                this.setErrDesc("no system user");
            }
        } else {
            info.setUserNo( EmployeeModel.getInfo(info.getId()).getUserNo());
            if (info.getId() == 0) {
                this.setErrCode("NoID");
                this.setErrDesc("NoID");
            } else {
                if (this.getOper().equalsIgnoreCase("edit")) {
                    info.setEmail( UserModel.getInfo(info.getUserNo()).getName()+"@bestinvestor.com.cn");
                    if(info.getStatus()==2&&EmployeeModel.getInfo(info.getId()).getStatus()!=2&&
                        CustomerPersonalModel.getCustomerPersonalListByManagerNo(info.getUserNo()).size()!=0){
                        String content = "您的下属"+info.getName()+"已经离职,请及时分配客户资源";
                        LetterModel.addReminds("员工离职提醒",content,EmployeeModel.getInfo(info.getParentNo()).getUserNo());
                    }
                    if (EmployeeModel.update(info) > 0) {
                        this.setErrDesc(String.valueOf(info.getId()));
                    } else {
                        this.setErrCode("update failed");
                        this.setErrDesc("update failed");
                    }
                }
            }
        }
        EnumListCacheModel.getEmpListById(false);
        EnumListCacheModel.getUserList(false);
        EnumListCacheModel.getEmployeeManagerByDept(info.getDeptNo(),false);
        EnumListCacheModel.getEmpList(false);
        EnumListCacheModel.getEmployeeTree("all", false,"empNo");
        EnumListCacheModel.getEmployeeTree("all", false,"userNo");
        EnumListCacheModel.getEmployeeTree("on", false,"empNo");
        EnumListCacheModel.getEmployeeTree("on", false,"userNo");
        EnumListCacheModel.getEmployeeTree("out", false,"empNo");
        EnumListCacheModel.getEmployeeTree("out", false,"userNo");
        EnumListCacheModel.getEmployeeTree("test", false,"empNo");
        EnumListCacheModel.getEmployeeTree("test", false,"userNo");
        return SUCCESS;
    }

    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String ajaxGetEmployeeById() {
        int id = Integer.parseInt(this.getId());
        Employee e = null;
        if (id != 0) {
            e = EmployeeModel.getInfo(id);
        }
        if (e != null) {
            this.employee = e;
        }
        return SUCCESS;
    }

    public String getInfoById() {
        if (StringHelper.isNullOrEmpty(this.getId())) {
            this.setErrCode("NoID");
            this.setErrDesc("NoID");
        } else {
            this.info = EmployeeModel.getInfo(Integer.parseInt(this.getId()));
            if (this.info == null) {
                this.setErrCode("No Info");
                this.setErrDesc("No Info");
            }
        }
        return SUCCESS;
    }

    public String ajaxGetEmpListByDept() {
        this.resultList = EmployeeModel.getEmpListByDept(this.param);
        return SUCCESS;
    }
    public String ajaxGetEmpListByDeptAndStatus() {
        this.resultList = EmployeeModel.getEmpListByDeptAndStatus(this.param,"0");
        return SUCCESS;
    }

    private String msgType;
    private String msgDescribe;

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getMsgDescribe() {
        return msgDescribe;
    }

    public void setMsgDescribe(String msgDescribe) {
        this.msgDescribe = msgDescribe;
    }

    //ajax to check userName is exit
    public String checkUserName() {//check user name repetition
        //select database to see if the name is exit
        User user = UserModel.getUserByUserName(this.sysUser);
        if (user == null) {
            this.msgType = "OK";
            this.msgDescribe = "尚未注册";
        } else {
            this.msgType = "NO";
            this.msgDescribe = "该账号已注册，请更换账号后再试一次";

        }
        return SUCCESS;
    }

    private String isPositive;

    public String getIsPositive() {
        return isPositive;
    }

    public void setIsPositive(String isPositive) {
        this.isPositive = isPositive;
    }

    public String positive() {
        int type = 0;
        String cipherTextUrl = "";
        String mailContent = "";

//        if (this.getIsPositive().equalsIgnoreCase("positive")) {
//            type = 1;
//            cipherTextUrl = this.buildWWWSiteUrl(PageAlias.probationWorkSummaryAdd);
//            mailContent = String.format(MailHelper.MAIL_POSITIVE_BODY, cipherTextUrl);
//
//        } else if (this.getIsPositive().equalsIgnoreCase("delay")) {
//            type = 2;
//            cipherTextUrl = this.buildWWWSiteUrl(PageAlias.extendProbationApplicationAdd);
//            mailContent = String.format(MailHelper.MAIL_DELAY_BODY, cipherTextUrl);
//        }
//        Employee employee = EmployeeModel.getInfo(Integer.parseInt(this.getId()));
//        int inUserNo = UserHelper.getUserCache().getUserId();
//        EmailModel.addpositive(employee.getEmail(), inUserNo, type, mailContent);
//        EmployeeModel.updateIsSendEmailById(Integer.parseInt(this.getId()));
//        if(type==1){
//            int parentNo = employee.getParentNo();
//            Employee employeePar = EmployeeModel.getInfo(parentNo);
//            cipherTextUrl = this.buildWWWSiteUrl(PageAlias.probationEvaluationAdd) +
//                    "?userNo="+employee.getId()+"&position="+employee.getPositionNo();
//            String body = String.format(MailHelper.MAIL_POSITIVEEVALUATION_BODY,employee.getName(),cipherTextUrl);
//            EmailModel.addPositiveEvaluationEmail(employeePar.getEmail(),inUserNo,body);
//        }
        return SUCCESS;

    }

    public String extendEmp() {
        int userId = UserHelper.getEditUserNo();
        this.employee = EmployeeModel.getEmpByUserId(userId);
        if (EmployeeDetailModel.getEmpDetailByEmpNo(employee.getId()) != null) {
            EmployeeDetail employeeDetail = EmployeeDetailModel.getEmpDetailByEmpNo(employee.getId());
            employee.setStartTime(employeeDetail.getStartTime());
        } else {
            employee.setStartTime(null);
        }
        return SUCCESS;
    }

    public String updateCheck(){
        if(StringHelper.isNullOrEmpty(this.getId()) || StringHelper.isNullOrEmpty(this.status)){
            this.setErrCode("No ID or Status");
            this.setErrDesc("参数出现异常，请核对后重新操作");
            return SUCCESS;
        }
        if(EmployeeModel.updateCheckById(Integer.valueOf(this.getId()),Byte.valueOf(this.status)) <= 0){
            this.setErrCode("UpdateCheckById Failed");
            this.setErrDesc("操作异常，请核对后重新操作");
        }

        EmailModel.examineRemindEmail(UserHelper.getUserCache().getUserId(),UserHelper.getUserCache().getEmpName());
        return SUCCESS;
    }

    private String cellphone;
    private String userNo;

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String ajaxGetInfoByCondition(){

        if (StringHelper.isNullOrEmpty(this.byName)&&StringHelper.isNullOrEmpty(this.cellphone)&&StringHelper.isNullOrEmpty(this.userNo)) {
            this.setErrCode("NoValue");
            this.setErrDesc("NoValue");
        } else {
            EmployeeCondition employeeCondition = new EmployeeCondition();

            if (!StringHelper.isNullOrEmpty(this.byName)) {
                employeeCondition.setUserNo(Integer.parseInt(this.byName));
            }
            if (!StringHelper.isNullOrEmpty(this.cellphone)) {
                employeeCondition.setCellPhone(this.cellphone);
            }
            if (!StringHelper.isNullOrEmpty(this.userNo)){
                employeeCondition.setUserNo(Integer.parseInt(this.userNo));
            }
            List<Employee> employeeList = EmployeeModel.getInfoByCondition(employeeCondition);
            if(employeeList.size()>1){
                this.setErrCode("Too Many");
                this.setErrDesc("数据不唯一，请姓名查找");
                return SUCCESS;
            }
            if (employeeList.size()!=0) {
                this.info = employeeList.get(0);
                if(info.getSex()==1){
                    info.setAddress("男");
                }else{
                    info.setAddress("女");
                }
            }else{
                this.setErrCode("No Info");
                this.setErrDesc("没有该用户");
            }
        }
        return SUCCESS;
    }
    public String getEmployeeForIndex(){
        UserCache userCache = UserHelper.getUserCache();
        if(userCache == null){
            this.setErrCode("userCache is null");
            this.setErrDesc("请重新登录。");
            return SUCCESS;
        }
        this.info = EmployeeModel.getInfo(userCache.getEmpId());
        return SUCCESS;
    }


}
