package com.hzfh.fmp.controller.baseInfo;

import com.hzfh.api.baseInfo.model.LetterStep;
import com.hzfh.fmp.controller.common.CommonAction;
import com.hzfh.fmp.model.baseInfo.LetterStepModel;
import com.hzfh.fmp.model.employee.EmployeeModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/4/22.
 */
public class LetterStepAction extends CommonAction {
    private int id;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    private List<Step> stepList;
    public List<Step> getStepList() {
        return stepList;
    }

    public void setStepList(List<Step> stepList) {
        this.stepList = stepList;
    }

    public String execute() throws Exception{
        this.stepList = getStepListByLetterNo(this.id);
        return SUCCESS;
    }
    public List<Step> getStepListByLetterNo(int letterNo){
        List<Step> stepList = new ArrayList<>();
        for(LetterStep letterstep: LetterStepModel.getListByLetterNo(letterNo)){
            Step step = new Step();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            step.setEditTime(sdf.format(letterstep.getEditTime()).substring(0,16));
            step.setEditName(EmployeeModel.getEmpByUserId(letterstep.getEditNo()).getName());
            step.setComment(letterstep.getComment());
            if(letterstep.getOperate()==1){
                step.setOperate("待处理");
            }
            else if(letterstep.getOperate()==2){
                step.setOperate("处理中");
            }
            else if(letterstep.getOperate()==3){
                step.setOperate("已处理");
            }
            else if(letterstep.getOperate()==3){
                step.setOperate("关闭");
            }
            else{
                step.setOperate("");
            }
            stepList.add(step);
        }

        return stepList;
    }
    public class Step{
        private String editName;
        private String editTime;
        private String operate;
        private String comment;

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public String getEditName() {
            return editName;
        }

        public void setEditName(String editName) {
            this.editName = editName;
        }

        public String getEditTime() {
            return editTime;
        }

        public void setEditTime(String editTime) {
            this.editTime = editTime;
        }

        public String getOperate() {
            return operate;
        }

        public void setOperate(String operate) {
            this.operate = operate;
        }
    }
}
