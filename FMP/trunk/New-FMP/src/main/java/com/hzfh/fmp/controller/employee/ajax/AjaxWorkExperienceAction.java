package com.hzfh.fmp.controller.employee.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.employee.model.WorkExperience;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.employee.WorkExperienceModel;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;


public class AjaxWorkExperienceAction extends JqGridBaseAction<WorkExperience> {
    private List<WorkExperience> workExperienceInfoList;
    private String empNo;

    public List<WorkExperience> getWorkExperienceInfoList() {
        return workExperienceInfoList;
    }

    public void setWorkExperienceInfoList(String workExperienceInfoList) {
        List<WorkExperience> workExperienceList = new ArrayList<>();
        for(int i=0;i<JSON.parseArray(workExperienceInfoList).size();i++){
            String workExperienceStr = JSON.toJSONString(JSON.parseArray(workExperienceInfoList).get(i));
            WorkExperience workExperience = JSON.parseObject(workExperienceStr, WorkExperience.class);
            workExperienceList.add(workExperience);

        }
        this.workExperienceInfoList = workExperienceList;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String edit() {
        for(WorkExperience workExperienceInfo:workExperienceInfoList) {
            workExperienceInfo.setEditUserNo(UserHelper.getEditUserNo());
            if (workExperienceInfo.getEmpNo() == 0) {
                this.setErrCode("NoEmpNo");
                this.setErrDesc("NoEmpNo");
                return SUCCESS;
            }
            int id;
            if (workExperienceInfo.getId() == 0) {
                workExperienceInfo.setInUserNo(UserHelper.getEditUserNo());
                id = WorkExperienceModel.add(workExperienceInfo);
                if (id <= 0) {
                    this.setErrCode("add failed");
                    this.setErrDesc("add failed");
                    return SUCCESS;
                }
                this.setErrDesc(String.valueOf(id));
            } else {
                if (WorkExperienceModel.update(workExperienceInfo) <= 0) {
                    this.setErrCode("update failed");
                    this.setErrDesc("update failed");
                    return SUCCESS;
                }
                this.setErrDesc(String.valueOf(workExperienceInfo.getId()));
            }
        }

        return SUCCESS;
    }

	public String getInfoById() {
        if (StringHelper.isNullOrEmpty(this.empNo)) {
            this.setErrCode("NoEmpNo");
            this.setErrDesc("NoEmpNo");
        } else {
            this.workExperienceInfoList = WorkExperienceModel.getWorkExperiencdByEmpNo(Integer.parseInt(this.empNo));
            if (this.workExperienceInfoList == null) {
                this.setErrCode("getWorkExperiencdByEmpNo Failed");
                this.setErrDesc("getWorkExperiencdByEmpNo Failed");
            }
        }

        return SUCCESS;
    }

}
