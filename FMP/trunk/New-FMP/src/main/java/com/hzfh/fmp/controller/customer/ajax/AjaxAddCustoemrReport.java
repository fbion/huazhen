package com.hzfh.fmp.controller.customer.ajax;

import com.hzfh.api.customer.model.ActivityRuleRelation;
import com.hzfh.api.employee.model.Department;
import com.hzfh.api.report.model.AddCustomerReport;
import com.hzfh.api.report.model.query.AddCustomerReportCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.customer.AddCustomerReportModel;
import com.hzfh.fmp.model.employee.DepartmentModel;
import com.hzframework.helper.DateHelper;
import com.hzframework.helper.StringHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2015/10/20.
 */
public class AjaxAddCustoemrReport extends JqGridBaseAction<AddCustomerReport> {

    private List<AddCustomerReport> rows;

    public List<AddCustomerReport> getRows() {
        return rows;
    }

    public void setRows(List<AddCustomerReport> rows) {
        this.rows = rows;
    }

    private int total;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private Date monthTime;
    private Date dayTime;
    private Date weekTime;

    public Date getWeekTime() {
        return weekTime;
    }

    public void setWeekTime(Date weekTime) {
        this.weekTime = weekTime;
    }

    public Date getMonthTime() {
        return monthTime;
    }

    public void setMonthTime(Date monthTime) {
        this.monthTime = monthTime;
    }

    public Date getDayTime() {
        return dayTime;
    }

    public void setDayTime(Date dayTime) {
        this.dayTime = dayTime;
    }
    private String year;
    private String week;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }
    private String showAllList;

    public String getShowAllList() {
        return showAllList;
    }

    public void setShowAllList(String showAllList) {
        this.showAllList = showAllList;
    }

    @Override
    public String execute(){

        SimpleDateFormat sdfy = new SimpleDateFormat("yyyy");
        SimpleDateFormat sdfm = new SimpleDateFormat("M");
        SimpleDateFormat sdfd = new SimpleDateFormat("d");
        Date date = new Date();
        Date now = DateHelper.addDay(date,-1);
        AddCustomerReportCondition addCustomerReportCondition = new AddCustomerReportCondition();
        if (!StringHelper.isNullOrEmpty(this.type)) {
            if(this.type.equals("1")){
                addCustomerReportCondition.setMonth(Integer.parseInt(sdfm.format(dayTime)));
                addCustomerReportCondition.setYear(Integer.parseInt(sdfy.format(dayTime)));
                addCustomerReportCondition.setDay(Integer.parseInt(sdfd.format(dayTime)));
            }
            if(this.type.equals("3")){
                addCustomerReportCondition.setMonth(Integer.parseInt(sdfm.format(monthTime)));
                addCustomerReportCondition.setYear(Integer.parseInt(sdfy.format(monthTime)));
            }
            if(this.type.equals("2")){
                Calendar c = Calendar.getInstance();
                c.setTime(this.weekTime);
                addCustomerReportCondition.setYear(c.get(Calendar.YEAR));
                addCustomerReportCondition.setWeek(c.get(Calendar.WEEK_OF_YEAR));
            }
            addCustomerReportCondition.setType(Integer.parseInt(this.type));
        }else{
            addCustomerReportCondition.setType(1);
            addCustomerReportCondition.setMonth(Integer.parseInt(sdfm.format(now)));
            addCustomerReportCondition.setYear(Integer.parseInt(sdfy.format(now)));
            addCustomerReportCondition.setDay(Integer.parseInt(sdfd.format(now)));
        }
        if ("query".equals(this.showAllList)) {
            addCustomerReportCondition.setDepts(null);
        }else{
            List<Department> departmentList = new ArrayList<Department>();
            getWorkMateById(UserHelper.getUserCache().getDeptId(), departmentList);
            List<Integer> workMate = new ArrayList<Integer>();
            for (Department department : departmentList) {
                workMate.add(department.getId());
            }
            workMate.add(UserHelper.getUserCache().getDeptId());
            addCustomerReportCondition.setDepts(StringHelper.listToString(workMate));
        }
        this.rows = AddCustomerReportModel.getListSerch(addCustomerReportCondition);

        addCustomerReportCondition.setEmpStatus(2);
        List<AddCustomerReport> addCustomerReportList = AddCustomerReportModel.getListSerch(addCustomerReportCondition);

        rows.addAll(addCustomerReportList);

        if(rows.size()!=0){
            rows.get(0).set_parentId(0);
        }
        return SUCCESS;
    }
    private void getWorkMateById(int id, List<Department> departmentList) {
        List<Department> departmentWorkMate = DepartmentModel.getDeptListByParentNo(id);
        if (departmentWorkMate != null && departmentWorkMate.size() > 0) {
            departmentList.addAll(departmentWorkMate);
            for (Department WorkMate : departmentWorkMate) {
                this.getWorkMateById(WorkMate.getId(), departmentList);
            }
        }
    }
}
