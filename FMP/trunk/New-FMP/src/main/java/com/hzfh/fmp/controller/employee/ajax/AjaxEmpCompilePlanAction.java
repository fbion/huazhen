package com.hzfh.fmp.controller.employee.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.employee.model.EmpCompilePlan;
import com.hzfh.api.employee.model.query.EmpCompilePlanCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.common.helper.ExcelHelper;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.employee.EmpCompilePlanModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;


public class AjaxEmpCompilePlanAction extends JqGridBaseAction<EmpCompilePlan> {
    private EmpCompilePlan info;
    public EmpCompilePlan getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = JSON.parseObject(info, EmpCompilePlan.class);
    }

    private String byDept;
    private String byYear;
    private String byMonth;

    public String getByYear() {
        return byYear;
    }

    public void setByYear(String byYear) {
        this.byYear = byYear;
    }

    public String getByMonth() {
        return byMonth;
    }

    public void setByMonth(String byMonth) {
        this.byMonth = byMonth;
    }

    public String getByDept() {
        return byDept;
    }

    public void setByDept(String byDept) {
        this.byDept = byDept;
    }

    private EmpCompilePlanCondition getCondition(){
        EmpCompilePlanCondition empCompilePlanCondition = new EmpCompilePlanCondition();
        empCompilePlanCondition.setPageSize(this.getPageSize());
        empCompilePlanCondition.setPageIndex(this.getPageIndex());
        if (!StringHelper.isNullOrEmpty(this.byDept)) {
            empCompilePlanCondition.setByDept(Integer.parseInt(this.byDept));
        }
        if (!StringHelper.isNullOrEmpty(this.byYear)) {
            empCompilePlanCondition.setByYear(Integer.parseInt(this.byYear));
        }
        if (!StringHelper.isNullOrEmpty(this.byMonth)) {
            empCompilePlanCondition.setByMonth(Integer.parseInt(this.byMonth));
        }
        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        empCompilePlanCondition.setSortItemList(sortItemList);
        return empCompilePlanCondition;
    }

    @Override
    public String execute() throws Exception{
        PagedList<EmpCompilePlan> empCompilePlanPagedList= EmpCompilePlanModel.getPagingList(this.getCondition());
        this.setResultList(empCompilePlanPagedList.getResultList());
        this.setPageCount(empCompilePlanPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(empCompilePlanPagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(empCompilePlanPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }
    public String exportExcel(){
        ExcelHelper excelHelper =  new ExcelHelper();
        excelHelper.getExcelForEmpCompilePlan(this.getCondition(),"aa");
        return null;
    }
    public String edit(){
        info.setEditUserNo(UserHelper.getEditUserNo());
        int id = 0;
        if (this.getOper().equalsIgnoreCase("add")) {
            info.setInUserNo(UserHelper.getEditUserNo());
            id = EmpCompilePlanModel.add(info);
            if (id > 0){
                this.setErrDesc(String.valueOf(id));
            }else{
                this.setErrCode("add failed");
                this.setErrDesc("add failed");
            }

        }
        else
        {
            if (info.getId() == 0) {
                this.setErrCode("NoID");
                this.setErrDesc("NoID");
            }
            else{
                if (this.getOper().equalsIgnoreCase("edit")) {
                    if (EmpCompilePlanModel.update(info) > 0){
                        this.setErrDesc(String.valueOf(info.getId()));
                    }else{
                        this.setErrCode("update failed");
                        this.setErrDesc("update failed");
                    }

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
            this.info = EmpCompilePlanModel.getInfo(Integer.parseInt(this.getId()));
            if (this.info == null) {
                this.setErrCode("No Info");
                this.setErrDesc("No Info");
            }
        }

        return SUCCESS;
    }

}
