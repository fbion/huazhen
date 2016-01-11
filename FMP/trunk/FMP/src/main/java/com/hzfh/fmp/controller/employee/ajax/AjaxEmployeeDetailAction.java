package com.hzfh.fmp.controller.employee.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.employee.model.Employee;
import com.hzfh.api.employee.model.EmployeeDetail;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.employee.EmployeeDetailModel;
import com.hzfh.fmp.model.employee.EmployeeModel;
import com.hzframework.helper.StringHelper;


public class AjaxEmployeeDetailAction extends JqGridBaseAction<EmployeeDetail> {
    private EmployeeDetail info;
    private Employee employeeInfo;

    public EmployeeDetail getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = JSON.parseObject(info, EmployeeDetail.class);
    }

    public void setEmployeeInfo(String employeeInfo) {
        this.employeeInfo = JSON.parseObject(employeeInfo, Employee.class);
    }

    public String edit() {
        info.setEditUserNo(UserHelper.getEditUserNo());
        if (info.getEmpNo() == 0) {
            this.setErrCode("NoEmpNo");
            this.setErrDesc("NoEmpNo");
            return SUCCESS;
        }
        if(EmployeeModel.updateEmpByEmpDetail(employeeInfo) <= 0){
            this.setErrCode("updateEmpByEmpDetail failed");
            this.setErrDesc("updateEmpByEmpDetail failed");
            return SUCCESS;
        }
        EmployeeDetail employeeDetail = EmployeeDetailModel.getEmpDetailByEmpNo(info.getEmpNo());
        int id;
        if (employeeDetail == null) {
            info.setInUserNo(UserHelper.getEditUserNo());
            id = EmployeeDetailModel.add(info);
            if (id <= 0) {
                this.setErrCode("add failed");
                this.setErrDesc("add failed");
                return SUCCESS;
            }
            this.setErrDesc(String.valueOf(info.getEmpNo()));
        } else {
            if (EmployeeDetailModel.updateEmpDetailByEmpNo(info) <= 0) {
                this.setErrCode("update failed");
                this.setErrDesc("update failed");
                return SUCCESS;
            }
            this.setErrDesc(String.valueOf(info.getEmpNo()));
        }

        return SUCCESS;
    }

    public String getInfoById() {
        if (StringHelper.isNullOrEmpty(this.getId())) {
            this.setErrCode("NoID");
            this.setErrDesc("NoID");
            return SUCCESS;
        }
        this.info = EmployeeDetailModel.getEmpDetailByEmpNo(Integer.valueOf(this.getId()));
        return SUCCESS;
    }

}
