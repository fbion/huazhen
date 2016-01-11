package com.hzfh.fmp.controller.common;

import com.hzfh.fmp.model.common.state.StateValues;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;
import net.sf.json.JSONArray;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by paul on 14-12-25.
 */
public abstract class EasyUIBaseAction<T> extends BaseAction {

    private List<T> rows = Collections.emptyList();
    private int pageSize = 10;
    private int page = 1;
    private int total = 0;
    private List<SortItem> sortList = new ArrayList<>();
    private String sort;
    private String order;
    private String id;
    private String errCode = "0000";
    private String errDesc = "";
    private String isTest = StateValues.getIsTest();

    public void setPage(int page) {
        this.page = page;
    }

    public int getPage() {
        return page;
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

    public int getPageSize() {
        HttpServletRequest request =  ServletActionContext.getRequest();
        String rows = request.getParameter("rows");
        if (!StringHelper.isNullOrEmpty(rows)) {
            return Integer.valueOf(request.getParameter("rows"));
        }
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getIsTest() {
        return isTest;
    }

    public void setIsTest(String isTest) {
        this.isTest = isTest;
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

    public List<SortItem> getSortList() {
        if(StringHelper.isNullOrEmpty(this.sort)){
            if(this.sortList.size() == 0){
                this.sortList = new ArrayList<>();
                SortItem sortItem = new SortItem();
                sortItem.setSort("id");
                sortItem.setOrder("desc");
                this.sortList.add(sortItem);
            }
            return sortList;
        }
        String[] sortArray = this.sort.split(",");
        String[] orderArray = this.order.split(",");
        for (int i = 0; i < sortArray.length; i++) {
            SortItem sortItem = new SortItem();
            sortItem.setSort(StringHelper.turnSQLVariable(sortArray[i]));
            sortItem.setOrder(orderArray[i]);
            this.sortList.add(sortItem);
        }
        return sortList;
    }

    public void setSortList(String sortList) {
        JSONArray sortArray = JSONArray.fromObject(sortList);
        this.sortList = (List<SortItem>) JSONArray.toCollection(sortArray,SortItem.class);
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
