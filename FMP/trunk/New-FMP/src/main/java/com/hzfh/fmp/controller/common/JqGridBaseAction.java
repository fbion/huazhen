package com.hzfh.fmp.controller.common;

import com.hzfh.fmp.model.common.state.StateValues;
import com.hzframework.contract.SortType;

import java.util.Collections;
import java.util.List;

/**
 * Created by paul on 14-12-25.
 */
public abstract class JqGridBaseAction<T> extends BaseAction {
	
	private List<T> resultList = Collections.emptyList();
	private List<T> rows = Collections.emptyList();
	private int total = 0;
	private int pageSize = 0;
	private int pageIndex = 0;
	private int pageCount = 0;
	private int recordCount = 0;// 记录数
	private String sidx;// 排序字段
	private String sord;// 排序方式
	private String search;
	private String oper;
	private String id;
	private String inUserNo;
	private String inTime;
	private String editUserNO;
	private String editTime;
	private String editComment;
	
	private String isTest=StateValues.getIsTest();
	public String getIsTest() {
		return isTest;
	}
	public void setIsTest(String isTest) {
		this.isTest = isTest;
	}

	private String errCode = "0000";
	private String errDesc = "";
	public List<T> getResultList() {
		return resultList;
	}

	public void setResultList(List<T> resultList) {
		this.resultList = resultList;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
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

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getOper() {
		return oper;
	}

	public void setOper(String oper) {
		this.oper = oper;
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

	public String getEditUserNO() {
		return editUserNO;
	}

	public void setEditUserNO(String editUserNO) {
		this.editUserNO = editUserNO;
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

    public SortType getSortType(){
        if (this.sord.equalsIgnoreCase("desc")){
            return SortType.DESC;
        }
        else
            return SortType.ASC;
    }

    
}
