package com.hzfh.fmp.controller.employee.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.employee.model.FamilyMembers;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.employee.FamilyMembersModel;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;


public class AjaxFamilyMembersAction extends JqGridBaseAction<FamilyMembers> {
    private List<FamilyMembers> familyMembersInfoList;
    private String empNo;

    public List<FamilyMembers> getFamilyMembersInfoList() {
        return familyMembersInfoList;
    }

    public void setFamilyMembersInfoList(String familyMembersInfoList) {
        List<FamilyMembers> familyMembersList = new ArrayList<>();
        for(int i=0;i< JSON.parseArray(familyMembersInfoList).size();i++){
            String familyMembersStr = JSON.toJSONString(JSON.parseArray(familyMembersInfoList).get(i));
            FamilyMembers familyMembers = JSON.parseObject(familyMembersStr,FamilyMembers.class);
            familyMembersList.add(familyMembers);
        }
        this.familyMembersInfoList = familyMembersList;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String edit() {
        for(FamilyMembers familyMembersInfo:familyMembersInfoList){
            familyMembersInfo.setEditUserNo(UserHelper.getEditUserNo());
            if (familyMembersInfo.getEmpNo() == 0) {
                this.setErrCode("NoEmpNo");
                this.setErrDesc("NoEmpNo");
                return SUCCESS;
            }
            int id;
            if (familyMembersInfo.getId() == 0) {
                familyMembersInfo.setInUserNo(UserHelper.getEditUserNo());
                id = FamilyMembersModel.add(familyMembersInfo);
                if (id <= 0) {
                    this.setErrCode("add failed");
                    this.setErrDesc("add failed");
                    return SUCCESS;
                }
                this.setErrDesc(String.valueOf(id));

            } else {
                if (FamilyMembersModel.update(familyMembersInfo) <= 0) {
                    this.setErrCode("update failed");
                    this.setErrDesc("update failed");
                    return SUCCESS;
                }
                this.setErrDesc(String.valueOf(familyMembersInfo.getId()));
            }
        }
        return SUCCESS;
    }

    public String getInfoById() {
        if (StringHelper.isNullOrEmpty(this.empNo)) {
            this.setErrCode("NoEmpNo");
            this.setErrDesc("NoEmpNo");
            return SUCCESS;
        }
        this.familyMembersInfoList = FamilyMembersModel.getFamilyMembersByEmpNo(Integer.parseInt(this.empNo));
        if (this.familyMembersInfoList == null) {
            this.setErrCode("familyMembersList Failed");
            this.setErrDesc("familyMembersList Failed");
        }

        return SUCCESS;
    }

}
