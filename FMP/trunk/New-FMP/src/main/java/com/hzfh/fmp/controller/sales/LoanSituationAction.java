package com.hzfh.fmp.controller.sales;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hzfh.api.payment.model.PaymentRefund;
import com.hzfh.api.product.model.P2pProduct;
import com.hzfh.api.sales.model.Sales;
import com.hzfh.fmp.controller.common.CommonAction;
import com.hzfh.fmp.model.common.PageAlias;
import com.hzfh.fmp.model.payment.PaymentRefundModel;
import com.hzfh.fmp.model.product.P2pProductModel;
import com.hzfh.fmp.model.sales.SalesModel;
import com.hzframework.helper.DateHelper;


public class LoanSituationAction extends CommonAction {
    private int saleNo;
    private PaymentRefund paymentRefund;
    private P2pProduct productInfo;
    private Sales saleInfo;
    private List<PaymentRefund> paymentRefundList;
    private int pieriod;
    private String profit;
    private String sumprofit;
    private int customerNo;
    private String purchDate;
    private String endDate;
    private String date;
    private String creditorNo;

    public String getCreditorNo() {
        return creditorNo;
    }

    public void setCreditorNo(String creditorNo) {
        this.creditorNo = creditorNo;
    }

    public String getDate() {
        return date;
    }

    public String getPurchDate() {
        return purchDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public int getCustomerNo() {
        return customerNo;
    }

    public PaymentRefund getPaymentRefund() {
        return paymentRefund;
    }

    public void setSaleNo(int saleNo) {
        this.saleNo = saleNo;
    }

    public P2pProduct getProductInfo() {
        return productInfo;
    }

    public Sales getSaleInfo() {
        return saleInfo;
    }

    public void setSaleInfo(Sales saleInfo) {
        this.saleInfo = saleInfo;
    }

    public List<PaymentRefund> getPaymentRefundList() {
        return paymentRefundList;
    }

    public int getPieriod() {
        return pieriod;
    }

    public String getProfit() {
        return profit;
    }

    public String getSumprofit() {
        return sumprofit;
    }

    @Override
    public String execute() throws Exception {
        this.setPageAlias(PageAlias.loanSituation);

        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;
        this.saleInfo = SalesModel.getInfo(this.saleNo);
        productInfo = P2pProductModel.getP2pByProductNo(saleInfo.getProductNo());
        if(productInfo.getRepaymentIssue()==0){
            paymentRefundList = PaymentRefundModel.getInfoBySalesIdAndIsUse(this.saleNo,1);
        }
        if(productInfo.getRepaymentIssue()==1){
            paymentRefundList = PaymentRefundModel.getInfoBySalesIdAndIsUse(this.saleNo,0);
        }
        for (int i = 0; i < paymentRefundList.size()-1; i++) {
        		Date actDate=new Date(paymentRefundList.get(i).getActualPayTime().getTime() - 24*60*60*1000);
        		paymentRefundList.get(i).setActualPayTime(actDate);
		}
        double profitTemp = PaymentRefundModel.getTotalValue(this.saleNo) - saleInfo.getMoney();
        this.profit = new java.text.DecimalFormat("#.00").format(profitTemp);
        paymentRefund = paymentRefundList.get(0);
        if (paymentRefund.getPayType() == 1) {
            this.customerNo = paymentRefund.getP2pCustomerNo();
            pieriodExecute();
        } else {
            this.customerNo = paymentRefund.getCustomerNo();
            pieriodExecute();
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        this.creditorNo = "HZJJ-"+sdf.format(new Date()) + "-XFB-" + saleInfo.getContractCode();
        this.sumprofit = new java.text.DecimalFormat("#.00").format(PaymentRefundModel.getTotalValue(this.saleNo));
        SimpleDateFormat dateFormatTemp = new SimpleDateFormat("yyyy年MM月dd日");
        date = dateFormatTemp.format(new java.util.Date());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.purchDate = dateFormat.format(saleInfo.getPurchaseDate());
        this.endDate = dateFormat.format(productInfo.getEnd());
        return SUCCESS;
    }

    public void pieriodExecute() {
        productInfo = P2pProductModel.getP2pByProductNo(saleInfo.getProductNo());
        try {
            this.pieriod = DateHelper.daysBetween(saleInfo.getPurchaseDate(), productInfo.getEnd()) + 1;
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
