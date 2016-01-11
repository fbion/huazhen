package com.hzfh.fmp.controller.employee.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.employee.model.CommissionWealthCenter;
import com.hzfh.api.employee.model.query.CommissionWealthCenterCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.common.helper.ExcelHelper;
import com.hzfh.fmp.model.employee.CommissionWealthCenterModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;


public class AjaxCommissionWealthCenterAction extends JqGridBaseAction<CommissionWealthCenter> {
    private CommissionWealthCenter info;
    public CommissionWealthCenter getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = JSON.parseObject(info, CommissionWealthCenter.class);
    }

    private String byName;
    private String bySelectDepartment;
    private String bySelectPositionNo;
    private String year;
    private String month;

    public String getByName() {
        return byName;
    }

    public void setByName(String byName) {
        this.byName = byName;
    }

    public String getBySelectDepartment() {
        return bySelectDepartment;
    }

    public void setBySelectDepartment(String bySelectDepartment) {
        this.bySelectDepartment = bySelectDepartment;
    }

    public String getBySelectPositionNo() {
        return bySelectPositionNo;
    }

    public void setBySelectPositionNo(String bySelectPositionNo) {
        this.bySelectPositionNo = bySelectPositionNo;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    private CommissionWealthCenterCondition getCondition(){
        CommissionWealthCenterCondition commissionWealthCenterCondition = new CommissionWealthCenterCondition();
        commissionWealthCenterCondition.setPageSize(this.getPageSize());
        commissionWealthCenterCondition.setPageIndex(this.getPageIndex());

        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        commissionWealthCenterCondition.setSortItemList(sortItemList);

        if(!StringHelper.isNullOrEmpty(this.byName)){
            commissionWealthCenterCondition.setEmpName(this.byName);
        }
        if(!StringHelper.isNullOrEmpty(this.bySelectDepartment)){
            commissionWealthCenterCondition.setDeptNo(Byte.valueOf(this.bySelectDepartment));
        }
        if(!StringHelper.isNullOrEmpty(this.bySelectPositionNo)){
            commissionWealthCenterCondition.setPositionNo(Byte.valueOf(this.bySelectPositionNo));
        }
        if(!StringHelper.isNullOrEmpty(this.year)){
            commissionWealthCenterCondition.setYear(Integer.valueOf(year));
        }
        if(!StringHelper.isNullOrEmpty(this.month)){
            commissionWealthCenterCondition.setMonth(Integer.valueOf(month));
        }
        return  commissionWealthCenterCondition;
    }
    @Override
    public String execute() throws Exception{
        PagedList<CommissionWealthCenter> commissionWealthCenterPagedList= CommissionWealthCenterModel.getPagingList(this.getCondition());
        this.setResultList(commissionWealthCenterPagedList.getResultList());
        this.setPageCount(commissionWealthCenterPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(commissionWealthCenterPagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(commissionWealthCenterPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }

    public String exportExcel(){
        ExcelHelper excelHelper =  new ExcelHelper();
        excelHelper.getExcelCommissionWealthCenter(this.getCondition(),"aa");
        return null;
        }

}
