package com.hzfh.fmp.controller.employee.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.employee.model.EmployeeCredential;
import com.hzfh.api.employee.model.EmployeeDetail;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.employee.EmployeeCredentialModel;
import com.hzfh.fmp.model.employee.EmployeeDetailModel;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;


public class AjaxEmployeeOtherInfoAction extends JqGridBaseAction<EmployeeCredential> {

    private EmployeeDetail empOtherInfo;
    private String empNo;
    private List<EmployeeCredential> certificateInfoList;

    public EmployeeDetail getEmpOtherInfo() {
        return empOtherInfo;
    }

    public void setEmpOtherInfo(String empOtherInfo) {
        this.empOtherInfo = JSON.parseObject(empOtherInfo, EmployeeDetail.class);
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public List<EmployeeCredential> getCertificateInfoList() {
        return certificateInfoList;
    }

    public void setCertificateInfoList(String certificateInfoList) {
        List<EmployeeCredential> employeeCredentialList = new ArrayList<>();
        for (int i = 0; i < JSON.parseArray(certificateInfoList).size(); i++) {
            String credentialStr = JSON.toJSONString(JSON.parseArray(certificateInfoList).get(i));
            EmployeeCredential employeeCredential = JSON.parseObject(credentialStr, EmployeeCredential.class);
            employeeCredentialList.add(employeeCredential);
        }

        this.certificateInfoList = employeeCredentialList;
    }

    public String edit() {
        if (empOtherInfo.getEmpNo() == 0) {
            this.setErrCode("NO EmpNo");
            this.setErrDesc("No EmpNo");
            return SUCCESS;
        }
        empOtherInfo.setEditUserNo(UserHelper.getEditUserNo());
        EmployeeDetail employeeDetail = EmployeeDetailModel.getEmpDetailByEmpNo(empOtherInfo.getEmpNo());
        if (employeeDetail == null) {
            empOtherInfo.setInUserNo(UserHelper.getEditUserNo());
            if (EmployeeDetailModel.add(empOtherInfo) <= 0) {
                this.setErrCode("add failed");
                this.setErrDesc("add failed");
                return SUCCESS;
            }
        } else {
            if (EmployeeDetailModel.updateEmpDetailByOtherInfo(empOtherInfo) <= 0) {
                this.setErrCode("update failed");
                this.setErrDesc("update failed");
                return SUCCESS;
            }
        }
        for (EmployeeCredential employeeCredential : certificateInfoList) {
            employeeCredential.setEditUserNo(UserHelper.getEditUserNo());
            if (employeeCredential.getId() == 0) {
                employeeCredential.setInUserNo(UserHelper.getEditUserNo());
                if (EmployeeCredentialModel.add(employeeCredential) <= 0) {
                    this.setErrCode("add failed");
                    this.setErrDesc("add failed");
                    return SUCCESS;
                }
            } else {
                if(EmployeeCredentialModel.update(employeeCredential) <= 0){
                    this.setErrCode("update failed");
                    this.setErrDesc("update failed");
                    return SUCCESS;
                }
            }
        }
        this.setErrDesc(String.valueOf(empOtherInfo.getEmpNo()));
        return SUCCESS;
    }

    public String getInfoById() {
        if (StringHelper.isNullOrEmpty(this.empNo)) {
            this.setErrCode("NoID");
            this.setErrDesc("NoID");
            return SUCCESS;
        }
        this.empOtherInfo = EmployeeDetailModel.getEmpDetailByEmpNo(Integer.valueOf(this.empNo));
        this.certificateInfoList = EmployeeCredentialModel.getEmpCredentialByEmpNo(Integer.valueOf((this.empNo)));
        return SUCCESS;
    }

}
