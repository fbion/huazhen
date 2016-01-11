package com.hzfh.fmp.controller.baseInfo.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.baseInfo.model.Letter;
import com.hzfh.api.baseInfo.model.LetterStep;
import com.hzfh.api.baseInfo.model.query.LetterCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.baseInfo.LetterModel;
import com.hzfh.fmp.model.baseInfo.LetterStepModel;
import com.hzfh.fmp.model.common.helper.LogHelper;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.employee.EmployeeModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;


public class AjaxLetterAction extends JqGridBaseAction<Letter> {
    private Letter info;

    private String comment;
    private String recipient;
    private String subject;
    private String status;
    private String importantDegree;
    private String inUserNo;
    private int letterNo;
    private String type;

    private String isRead;

    public String getIsRead() {
        return isRead;
    }

    public void setIsRead(String isRead) {
        this.isRead = isRead;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public int getLetterNo() {
        return letterNo;
    }
    public void setLetterNo(int letterNo) {
        this.letterNo = letterNo;
    }
    public Letter getInfo() {
        return info;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getImportantDegree() {
        return importantDegree;
    }
    public void setImportantDegree(String importantDegree) {
        this.importantDegree = importantDegree;
    }

    @Override
    public String getInUserNo() {
        return inUserNo;
    }

    @Override
    public void setInUserNo(String inUserNo) {
        this.inUserNo = inUserNo;
    }
    public String getRecipient() {
        return recipient;
    }
    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public void setInfo(String info) {
        this.info = JSON.parseObject(info, Letter.class);
    }
    public static final LogHelper logger = LogHelper.getLogger(AjaxLetterAction.class.getName());
    @Override
    public String execute() throws Exception {
        LetterCondition letterCondition = new LetterCondition();
        letterCondition.setPageSize(this.getPageSize());
        letterCondition.setPageIndex(this.getPageIndex());
        letterCondition.setEmpId(UserHelper.getUserCache().getUserId());
        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        letterCondition.setSortItemList(sortItemList);

        if (!StringHelper.isNullOrEmpty(this.subject)) {
            letterCondition.setSubject(this.getSubject());
        }
        if(!StringHelper.isNullOrEmpty(this.inUserNo)){
            letterCondition.setInUserNo(Integer.parseInt(this.inUserNo));
        }
        if(!StringHelper.isNullOrEmpty(this.recipient)){
            letterCondition.setRecipient(Integer.parseInt(this.recipient));
        }else{
            letterCondition.setRecipient(-1);
        }
        if(!StringHelper.isNullOrEmpty(this.status)){
            letterCondition.setStatus(Integer.parseInt(this.status));
        }
        if(!StringHelper.isNullOrEmpty(this.type)){
            letterCondition.setType(this.type);
        }
        letterCondition.setIsRead(-1);
        if(!StringHelper.isNullOrEmpty(this.importantDegree)){
            letterCondition.setImportantDegree(Integer.parseInt(this.importantDegree));
        }
        PagedList<Letter> letterPagedList = LetterModel.getPagingList(letterCondition);
        this.setResultList(letterPagedList.getResultList());
        this.setPageCount(letterPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(letterPagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(letterPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }

    public String edit() {
        int editUserNo = UserHelper.getEditUserNo();
        info.setEditUserNo(editUserNo);
        int id = 0;
        if (this.getOper().equalsIgnoreCase("add")) {
            info.setInUserNo(UserHelper.getEditUserNo());
            id = LetterModel.add(info);
            this.addStep(id,"add");
            if (id > 0) {
                this.setErrDesc(String.valueOf(id));
            } else {
                this.setErrCode("add failed");
                this.setErrDesc("add failed");
            }

        } else {
            if (info.getId() == 0) {
                this.setErrCode("NoID");
                this.setErrDesc("NoID");
            } else if (this.getOper().equalsIgnoreCase("edit")) {
                if (LetterModel.update(info) > 0) {
                    this.addStep(info.getId(),"edit");
                    this.setErrDesc(String.valueOf(info.getId()));
                } else {
                    this.setErrCode("update failed");
                    this.setErrDesc("update failed");
                }
            }else if(this.getOper().equalsIgnoreCase("solve")){
                info.setSolveUserNo(UserHelper.getUserCache().getUserId());
                info.setRecipient(info.getInUserNo());
                if (LetterModel.updateSolve(info) > 0) {
                    this.addStep(info.getId(),"solve");
                    this.setErrDesc(String.valueOf(info.getId()));
                } else {
                    this.setErrCode("update failed");
                    this.setErrDesc("update failed");
                }
            }else if(this.getOper().equalsIgnoreCase("close")){
                info.setCloseUserNo(UserHelper.getUserCache().getUserId());
                info.setRecipient(info.getSolveUserNo());
                if (LetterModel.updateClose(info) > 0) {
                    this.addStep(info.getId(),"close");
                    this.setErrDesc(String.valueOf(info.getId()));
                } else {
                    this.setErrCode("update failed");
                    this.setErrDesc("update failed");
                }
            }
        }
        return SUCCESS;
    }

    public String getInfoById() {
        if (StringHelper.isNullOrEmpty(this.getId())) {
            this.setErrCode("NoID");
            this.setErrDesc("NoID");
        } else {
            this.info = LetterModel.getInfo(Integer.parseInt(this.getId()));
            if (this.info == null) {
                this.setErrCode("No Info");
                this.setErrDesc("No Info");
            }
        }
        if(info.getRecipient()==UserHelper.getUserCache().getUserId()){
            info.setIsRead((byte)1);
            LetterModel.update(info);
        }
        this.letterNo = info.getId();
        return SUCCESS;
    }

    public int addStep(int letterNo,String operate){
        LetterStep letterStep = new LetterStep();
        letterStep.setLetterNo(letterNo);
        letterStep.setEditNo(UserHelper.getEditUserNo());
        letterStep.setOperate(info.getStatus());
        String dec = "";

        if(operate=="add") {
            if(info.getRecipient()==0){
                dec = "待办人 全体员工";
            }else{
                dec = "待办人 " + "'"+EmployeeModel.getEmpByUserId(info.getRecipient()).getName()+"' ";
            }
        }
        if(operate=="edit"&&info.getStatus()==2){
            if(info.getRecipient()==0){
                dec = "待办人 全体员工";
            }else{
                dec = "待办人 "+ "'" + EmployeeModel.getEmpByUserId(info.getRecipient()).getName()+"' ";
            }
        }
        letterStep.setComment(dec + " " + this.comment);
        if(operate=="edit"&&info.getStatus()==1){
            letterStep.setOperate(0);
            letterStep.setComment("修改");
        }
        return LetterStepModel.add(letterStep);
    }
}
