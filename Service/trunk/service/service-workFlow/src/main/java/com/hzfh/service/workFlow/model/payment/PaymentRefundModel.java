package com.hzfh.service.workFlow.model.payment;

import com.hzfh.api.payment.model.PaymentRefund;
import com.hzfh.api.product.model.P2pProduct;
import com.hzfh.service.workFlow.facade.payment.PaymentRefundFacade;
import com.hzframework.helper.DateHelper;
import com.hzframework.helper.MathHelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class PaymentRefundModel {

    public static int add(PaymentRefund paymentRefund) {
        return PaymentRefundFacade.add(paymentRefund);
    }

    public static PaymentRefund getInfo(int id) {
        return PaymentRefundFacade.getInfo(id);
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

    private static int updateLastPayMoneyOfSales(int salesNo, int maxTime) {
        return PaymentRefundFacade.updateLastPayMoneyOfSales(salesNo, maxTime);
    }


}
