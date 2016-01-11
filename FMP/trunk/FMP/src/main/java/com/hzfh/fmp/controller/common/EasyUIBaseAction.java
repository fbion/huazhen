package com.hzfh.fmp.controller.common;

import com.hzfh.fmp.model.common.state.StateValues;
import com.hzframework.contract.SortType;

import java.util.Collections;
import java.util.List;

/**
 * Created by paul on 14-12-25.
 */
public abstract class EasyUIBaseAction<T> extends BaseAction {

    private List<T> rows = Collections.emptyList();
    private int nrows;
    private int page;
    private int total = 0;
    private String sidx;// 排序字段
    private String sord;// 排序方式
    private String id;
    private String inUserNo;
    private String inTime;
    private String editUserNo;
    private String editTime;
    private String editComment;
    private String errCode = "0000";
    private String errDesc = "";
    private String isTest = StateValues.getIsTest();

    public void setPage(int page) {
        this.page = page;
    }

    public int getPage() {
        return page;
    }

    public int getNRows() {
        return nrows;
    }

    public void setRows(String rows) {
        this.nrows = Integer.valueOf(rows);
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }


    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }


    public String getIsTest() {
        return isTest;
    }

    public void setIsTest(String isTest) {
        this.isTest = isTest;
    }


    public String getSidx() {
        return sidx;
    }

    public void setSidx(String sidx) {
        this.sidx = sidx;
    }

    public String getSord() {
        return sord;
    }

    public void setSord(String sord) {
        this.sord = sord;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrDesc() {
        return errDesc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setErrDesc(String errDesc) {
        this.errDesc = errDesc;
    }

    public String getInUserNo() {
        return inUserNo;
    }

    public void setInUserNo(String inUserNo) {
        this.inUserNo = inUserNo;
    }

    public String getInTime() {
        return inTime;
    }

    public void setInTime(String inTime) {
        this.inTime = inTime;
    }

    public String getEditUserNo() {
        return editUserNo;
    }

    public void setEditUserNo(String editUserNo) {
        this.editUserNo = editUserNo;
    }

    public String getEditTime() {
        return editTime;
    }

    public void setEditTime(String editTime) {
        this.editTime = editTime;
    }

    public String getEditComment() {
        return editComment;
    }

    public void setEditComment(String editComment) {
        this.editComment = editComment;
    }

    public SortType getSortType() {
        if (this.sord.equalsIgnoreCase("desc")) {
            return SortType.DESC;
        } else
            return SortType.ASC;
    }
}
