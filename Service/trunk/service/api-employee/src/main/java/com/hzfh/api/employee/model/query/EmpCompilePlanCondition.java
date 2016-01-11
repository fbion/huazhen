package com.hzfh.api.employee.model.query;

import com.hzframework.contract.QueryCondition;

import java.io.Serializable;


public class EmpCompilePlanCondition extends QueryCondition implements Serializable {
    private int byDept;
    private int byYear;
    private int byMonth;

    public int getByYear() {
        return byYear;
    }

    public void setByYear(int byYear) {
        this.byYear = byYear;
    }

    public int getByMonth() {
        return byMonth;
    }

    public void setByMonth(int byMonth) {
        this.byMonth = byMonth;
    }

    public int getByDept() {
        return byDept;
    }

    public void setByDept(int byDept) {
        this.byDept = byDept;
    }


}