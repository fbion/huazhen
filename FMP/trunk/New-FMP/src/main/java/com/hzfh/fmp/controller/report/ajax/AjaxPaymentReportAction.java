package com.hzfh.fmp.controller.report.ajax;

import com.hzfh.api.report.model.PaymentReport;
import com.hzfh.api.report.model.query.PaymentReportCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.report.PaymentReportModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/12/9.
 */
public class AjaxPaymentReportAction extends JqGridBaseAction<PaymentReport> {
    @Override
    public String execute(){
        PaymentReportCondition companyCondition = new PaymentReportCondition();
        companyCondition.setPageSize(this.getPageSize());
        companyCondition.setPageIndex(this.getPageIndex());

        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        companyCondition.setSortItemList(sortItemList);

        PagedList<PaymentReport> paymentReportPagedList= PaymentReportModel.getPagingList(companyCondition);
        this.setResultList(paymentReportPagedList.getResultList());
        this.setPageCount(paymentReportPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(paymentReportPagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(paymentReportPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }
}
