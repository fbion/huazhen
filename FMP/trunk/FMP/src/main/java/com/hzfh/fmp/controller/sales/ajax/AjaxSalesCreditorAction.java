package com.hzfh.fmp.controller.sales.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.sales.model.Creditor;
import com.hzfh.api.sales.model.SalesCreditor;
import com.hzfh.api.sales.model.query.SalesCreditorCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.sales.CreditorModel;
import com.hzfh.fmp.model.sales.SalesCreditorModel;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.sales.SalesModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;


public class AjaxSalesCreditorAction extends JqGridBaseAction<SalesCreditor> {
    private SalesCreditor info;
    public SalesCreditor getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = JSON.parseObject(info, SalesCreditor.class);
    }

    @Override
    public String execute(){
        SalesCreditorCondition salesCreditorCondition = new SalesCreditorCondition();
        salesCreditorCondition.setPageSize(this.getPageSize());
        salesCreditorCondition.setPageIndex(this.getPageIndex());

        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        salesCreditorCondition.setSortItemList(sortItemList);

        PagedList<SalesCreditor> salesCreditorPagedList= SalesCreditorModel.getPagingList(salesCreditorCondition);
        this.setResultList(salesCreditorPagedList.getResultList());
        this.setPageCount(salesCreditorPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(salesCreditorPagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(salesCreditorPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }



    private int infoId;

    public int getInfoId() {
        return infoId;
    }

    public void setInfoId(int infoId) {
        this.infoId = infoId;
    }

    public String edit(){
        info.setEditUserNo(UserHelper.getEditUserNo());
        int id = 0;
        if (this.getOper().equalsIgnoreCase("add")) {
            if(info.getMoney()==0||info.getCreditorNo()==0){
                this.setErrCode("add failed");
                this.setErrDesc("请填写数据");
                return SUCCESS;
            }
            info.setInUserNo(UserHelper.getEditUserNo());
            if(CreditorModel.getInfo(info.getCreditorNo()).getRemainAmount()<info.getMoney()){
                this.setErrCode("add failed");
                this.setErrDesc("该债权剩余抵用金额不足，请重新分配债权");
                return SUCCESS;
            }
            double creditorMoney = 0;
            for(SalesCreditor salesCreditor :SalesCreditorModel.getListBySalesNo(info.getSalesNo())){
                creditorMoney = creditorMoney + salesCreditor.getMoney();
            }
            if(creditorMoney+info.getMoney()>SalesModel.getInfo(info.getSalesNo()).getMoney()){
                this.setErrCode("add failed");
                this.setErrDesc("债权金额大于购买金额，请重新分配债权");
                return SUCCESS;
            }
            Creditor creditor = CreditorModel.getInfo(info.getCreditorNo());
            info.setCreditorName(creditor.getProjectName()+creditor.getRoomNumber());
            id = SalesCreditorModel.add(info);
            this.infoId = id;
            if (id > 0){
                this.setErrDesc(String.valueOf(id));
                CreditorModel.updateRemainAmountById(info.getCreditorNo(),info.getMoney());
            }else{
                this.setErrCode("add failed");
                this.setErrDesc("add failed");
            }
        }
        this.setErrCode("0000");
        this.setErrDesc("0000");
        return SUCCESS;
    }
    private int salesNo;

    public int getSalesNo() {
        return salesNo;
    }

    public void setSalesNo(int salesNo) {
        this.salesNo = salesNo;
    }

    private List<SalesCreditor> rows;

    public List<SalesCreditor> getRows() {
        return rows;
    }

    public void setRows(List<SalesCreditor> rows) {
        this.rows = rows;
    }

    public String ajaxGetInfoBySaleNo(){
        if (StringHelper.isNullOrEmpty(String.valueOf(this.salesNo))) {
            this.setErrCode("NoSaleNo");
            this.setErrDesc("NoSaleNo");
        } else {
            this.rows = SalesCreditorModel.getListBySalesNo(this.salesNo);
        }
        return SUCCESS;
    }
    public String getInfoById() {
        if (StringHelper.isNullOrEmpty(this.getId())) {
            this.setErrCode("NoID");
            this.setErrDesc("NoID");
        } else {
            this.info = SalesCreditorModel.getInfo(Integer.parseInt(this.getId()));
            if (this.info == null) {
                this.setErrCode("No Info");
                this.setErrDesc("No Info");
            }
        }

        return SUCCESS;
    }

    public String del(){
        if (StringHelper.isNullOrEmpty(String.valueOf(this.infoId))) {
            this.setErrCode("NoID");
            this.setErrDesc("NoID");
        } else {
            SalesCreditor salesCreditor = SalesCreditorModel.getInfo(this.infoId);
            if(SalesCreditorModel.delete(this.infoId)>0) {
                CreditorModel.updateRemainAmountById(salesCreditor.getCreditorNo(), -salesCreditor.getMoney());
            }
        }
        return SUCCESS;
    }

}
