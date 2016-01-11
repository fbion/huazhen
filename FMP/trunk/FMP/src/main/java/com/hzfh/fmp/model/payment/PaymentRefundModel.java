package com.hzfh.fmp.model.payment;

import com.hzfh.api.payment.model.PaymentRefund;
import com.hzfh.api.payment.model.query.PaymentRefundCondition;
import com.hzfh.api.product.model.P2pProduct;
import com.hzfh.fmp.facade.payment.PaymentRefundFacade;
import com.hzframework.contract.PagedList;
import com.hzframework.helper.DateHelper;
import com.hzframework.helper.MathHelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class PaymentRefundModel {
    public static PagedList<PaymentRefund> getPagingList(PaymentRefundCondition paymentRefundCondition) {
        return PaymentRefundFacade.getPagingList(paymentRefundCondition);
    }
    public static List<PaymentRefund> getListForExcel(PaymentRefundCondition paymentRefundCondition){
        return PaymentRefundFacade.getListForExcel(paymentRefundCondition);
    }
    public static int add(PaymentRefund paymentRefund) {
        return PaymentRefundFacade.add(paymentRefund);
    }

    public static int update(PaymentRefund paymentRefund) {
        return PaymentRefundFacade.update(paymentRefund);
    }

    public static int updateExamineStatusByIds(String ids,int examineStatus){
        return PaymentRefundFacade.updateExamineStatusByIds(ids,examineStatus);
    }

    public static int updatePaymentTypeBySalesNoAndHonour(int salesNo,int paymentType){
        return PaymentRefundFacade.updatePaymentTypeBySalesNoAndHonour(salesNo,paymentType);
    }
    public static int updatePayMoneyBySalesNoAndHonour(int salesNo,double payMoney){
        return PaymentRefundFacade.updatePayMoneyBySalesNoAndHonour(salesNo,payMoney);
    }
    public static List<PaymentRefund> getList() {
        return PaymentRefundFacade.getList();
    }

    public static PaymentRefund getInfo(int id) {
        return PaymentRefundFacade.getInfo(id);
    }

    public static int updateStatusById(int id, byte status) {
        return PaymentRefundFacade.updateStatusById(id, status);
    }

    public static List<PaymentRefund> getInfoBySalesId(int salesId) {
        return PaymentRefundFacade.getInfoBySalesId(salesId);
    }
    public static int cancelSendSmsByIds(List<String> idList){
        return PaymentRefundFacade.cancelSendSmsByIds(idList);
    }
    public static PaymentRefund getInfoBySalesIdLimit(int saleId){
        return PaymentRefundFacade.getInfoBySalesIdLimit(saleId);
    }

    public static int deleteBySaleNo(int salesNo){
        return PaymentRefundFacade.deleteBySaleNo(salesNo);
    }
    public static double getTotalValue(int saleNo){
        return PaymentRefundFacade.getTotalValue(saleNo);
    }

    public static void calculatePaymentRefund(PaymentRefund paymentRefund, P2pProduct p2pProduct) throws ParseException {
        double income = 0;
        int dayBetween;
        java.util.Date payStartDate;
        java.util.Date payStartTime = paymentRefund.getPayStartTime();
        int day = DateHelper.daysBetween(paymentRefund.getPayStartTime(), p2pProduct.getEnd()) + 1;
        if (p2pProduct.getRepaymentIssue() == 1) {
            java.util.Date payEndDate = DateHelper.addDay(paymentRefund.getPayStartTime(), day);
            dayBetween = DateHelper.daysBetween(paymentRefund.getPayStartTime(), payEndDate);
            income = MathHelper.getIncome(dayBetween, p2pProduct.getIncome(), paymentRefund.getSalesMoney());
            paymentRefund.setInterest(income);
            paymentRefund.setPayMoney(paymentRefund.getSalesMoney() + income);
            paymentRefund.setIsUse((byte) 1);
            paymentRefund.setTimes(1);
            paymentRefund.setIsTest(p2pProduct.getIsTest());
            paymentRefund.setPaymentType((byte)1);
            paymentRefund.setActualPayTime(DateHelper.addDay(payEndDate,-1));
            PaymentRefundModel.add(paymentRefund);
        }
        int times = DateHelper.getMonthSpace(paymentRefund.getPayStartTime(), p2pProduct.getEnd());
        for (int i = 1; i <= times + 1; i++) {
            paymentRefund.setPayStartTime(payStartTime);
            java.util.Date payEndDate = DateHelper.getNextMonthFirst(paymentRefund.getPayStartTime(), i);
            if (i == 1) {
                payStartDate = paymentRefund.getPayStartTime();
                dayBetween = DateHelper.daysBetween(payStartDate, payEndDate);
                income = MathHelper.getIncome(dayBetween, p2pProduct.getIncome(), paymentRefund.getSalesMoney());
                paymentRefund.setPayStartTime(payEndDate);
                paymentRefund.setActualPayTime(payEndDate);
                paymentRefund.setPaymentType((byte)0);
            } else if (i < times + 1) {
                payStartDate = DateHelper.getNextMonthFirst(paymentRefund.getPayStartTime(), i - 1);
                dayBetween = DateHelper.daysBetween(payStartDate, payEndDate);
                income = MathHelper.getIncome(dayBetween, p2pProduct.getIncome(), paymentRefund.getSalesMoney());
                paymentRefund.setPayStartTime(payEndDate);
                paymentRefund.setActualPayTime(payEndDate);
                paymentRefund.setPaymentType((byte)0);
            }else{
                payEndDate = DateHelper.addDay(paymentRefund.getPayStartTime(), day);
                payStartDate = DateHelper.getNextMonthFirst(paymentRefund.getPayStartTime(), i - 1);
                dayBetween = DateHelper.daysBetween(payStartDate, payEndDate);
                income = MathHelper.getIncome(dayBetween, p2pProduct.getIncome(), paymentRefund.getSalesMoney());
                paymentRefund.setPayStartTime(DateHelper.addDay(payEndDate,-1));
                paymentRefund.setActualPayTime(DateHelper.addDay(payEndDate,-1));
                paymentRefund.setPaymentType((byte)1);
            }
            paymentRefund.setTimes(i);
            paymentRefund.setInterest(income);
            paymentRefund.setPayMoney(income);
            if (p2pProduct.getRepaymentIssue() == 0) {
                paymentRefund.setIsUse((byte) 1);
            } else {
                paymentRefund.setIsUse((byte) 0);
            }
            PaymentRefundModel.add(paymentRefund);
        }
        int maxTime = PaymentRefundModel.getMaxTimeBySalesNo(paymentRefund.getSalesNo());
        PaymentRefundModel.updateLastPayMoneyOfSales(paymentRefund.getSalesNo(),maxTime);
    }

    private static int getMaxTimeBySalesNo(int salesNo) {
        return PaymentRefundFacade.getMaxTimeBySalesNo(salesNo);
    }

    private static int updateLastPayMoneyOfSales(int salesNo,int maxTime) {
        return PaymentRefundFacade.updateLastPayMoneyOfSales(salesNo, maxTime);
    }

    public  static int updateP2pCustomerNoByCustomerNo(int customerNo,int p2pCustomerNo){
        return PaymentRefundFacade.updateP2pCustomerNoByCustomerNo(customerNo,p2pCustomerNo);
    }

    public static List<PaymentRefund> getListByByHonourDateAndTypeAndStatus(String honourDate,String type,String status){
        return PaymentRefundFacade.getListByByHonourDateAndTypeAndStatus(honourDate,type,status);
    }

    public static int getTimesIsUseBySalesNo(int salesNo){
        return PaymentRefundFacade.getTimesIsUseBySalesNo(salesNo);
    }

}
