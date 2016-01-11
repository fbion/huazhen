package com.hzfh.fmp.controller.employee.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.employee.model.EmployeeEducation;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.employee.EmployeeEducationModel;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;


public class AjaxEmployeeEducationAction extends JqGridBaseAction<EmployeeEducation> {
    private List<EmployeeEducation> employeeEducationInfoList;
    private String empNo;

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public List<EmployeeEducation> getEmployeeEducationInfoList() {
        return employeeEducationInfoList;
    }

    public void setEmployeeEducationInfoList(String employeeEducationInfoList) {
        List<EmployeeEducation> employeeEducationList = new ArrayList<>();
        for (int i = 0; i < JSON.parseArray(employeeEducationInfoList).size(); i++) {
            String employeeStr = JSON.toJSONString(JSON.parseArray(employeeEducationInfoList).get(i));
            EmployeeEducation employeeEducation = JSON.parseObject(employeeStr, EmployeeEducation.class);
            employeeEducationList.add(employeeEducation);
        }
        this.employeeEducationInfoList = employeeEducationList;
    }

    public String edit() {
        for (EmployeeEducation employeeEducationInfo : employeeEducationInfoList) {
            employeeEducationInfo.setEditUserNo(UserHelper.getEditUserNo());
            if (employeeEducationInfo.getEmpNo() == 0) {
                this.setErrCode("NoEmpNo");
                this.setErrDesc("NoEmpNo");
                return SUCCESS;
            }
            int id;
            if (employeeEducationInfo.getId() == 0) {
                employeeEducationInfo.setInUserNo(UserHelper.getEditUserNo());
                id = EmployeeEducationModel.add(employeeEducationInfo);
                if (id <= 0) {
                    this.setErrCode("add failed");
                    this.setErrDesc("add failed");
                    return SUCCESS;
                }
                this.setErrDesc(String.valueOf(id));
            } else {
                if (EmployeeEducationModel.update(employeeEducationInfo) <= 0) {
                    this.setErrCode("update failed");
                    this.setErrDesc("update failed");
                    return SUCCESS;
                }
                this.setErrDesc(String.valueOf(employeeEducationInfo.getId()));
            }
        }
        return SUCCESS;
    }

    public String getInfoById() {
        if (StringHelper.isNullOrEmpty(this.empNo)) {
            this.setErrCode("NoEmpNo");
            this.setErrDesc("NoEmpNo");
        } else {
            this.employeeEducationInfoList = EmployeeEducationModel.getEmpEduByEmpNo(Integer.parseInt(this.empNo));
            if (this.employeeEducationInfoList == null) {
                this.setErrCode("employeeEducationList Failed");
                this.setErrDesc("employeeEducationList Failed");
            }
        }

        return SUCCESS;
    }

}
