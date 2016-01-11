package com.hzfh.fmp.controller.sales.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.permission.model.User;
import com.hzfh.api.sales.model.Creditor;
import com.hzfh.api.sales.model.query.CreditorCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.common.helper.EncodeHelper;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.permission.UserModel;
import com.hzfh.fmp.model.sales.CreditorModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;
import net.hydromatic.linq4j.function.DoubleFunction1;

import java.util.ArrayList;
import java.util.List;


public class AjaxCreditorAction extends JqGridBaseAction<Creditor> {
//    private Creditor info;
//    public Creditor getInfo() {
//        return info;
//    }
//
//    public void setInfo(String info) {
//        this.info = JSON.parseObject(info, Creditor.class);
//    }
    private String projectName;
    private String roomNumber;
    private String totalMoney;
    private String remainAmount;
    private String productNo;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(String totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getRemainAmount() {
        return remainAmount;
    }

    public void setRemainAmount(String remainAmount) {
        this.remainAmount = remainAmount;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    @Override
    public String execute(){
        CreditorCondition creditorCondition = new CreditorCondition();
        creditorCondition.setPageSize(this.getPageSize());
        creditorCondition.setPageIndex(this.getPageIndex());
        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        creditorCondition.setSortItemList(sortItemList);
        PagedList<Creditor> creditorPagedList= CreditorModel.getPagingList(creditorCondition);
        this.setResultList(creditorPagedList.getResultList());
        this.setPageCount(creditorPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(creditorPagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(creditorPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }

    public String edit(){
        Creditor info  = new Creditor();
        info.setProductNo(Integer.parseInt(this.productNo));
        info.setProjectName(this.projectName);
        info.setRemainAmount(Double.parseDouble(this.remainAmount));
        info.setRoomNumber(this.roomNumber);
        info.setTotalMoney(Double.parseDouble(this.totalMoney));
        info.setEditUserNo(UserHelper.getEditUserNo());
        if (this.getOper().equalsIgnoreCase("add")) {
            info.setInUserNo(UserHelper.getEditUserNo());
            if (CreditorModel.add(info) <= 0){
                this.setErrCode("add failed");
                this.setErrDesc("add failed");
            }
        }
        else
        {
            if (Integer.parseInt(this.getId()) == 0) {
                this.setErrCode("NoID");
                this.setErrDesc("NoID");
            }
            else{
                if (this.getOper().equalsIgnoreCase("edit")) {
                    info.setId(Integer.parseInt(this.getId()));
                    if (CreditorModel.update(info) <= 0){
                        this.setErrCode("update failed");
                        this.setErrDesc("update failed");
                    }
                }
            }
        }

        return SUCCESS;
    }

}
