import com.hzfh.api.payment.model.PaymentRefund;
import com.hzfh.api.product.model.P2pProduct;
import com.hzfh.api.product.model.Product;
import com.hzfh.api.sales.model.Sales;
import com.hzfh.api.sales.model.query.SalesCondition;
import com.hzfh.fmp.model.common.enumeration.StatusType;
import com.hzfh.fmp.model.payment.PaymentRefundModel;
import com.hzfh.fmp.model.product.P2pProductModel;
import com.hzfh.fmp.model.product.ProductModel;
import com.hzfh.fmp.model.sales.SalesModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.contract.SortType;
import com.hzframework.helper.DateHelper;
import com.hzframework.helper.MathHelper;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2015/7/14.
 */
public class DayTest {

    @Test
    public void dayBetweenTest() throws ParseException {
//        java.util.Date payDate = DateHelper.getTodayDate();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String payString = "2015-10-09";
        String endString = "2015-11-17";
        java.util.Date payDate = sdf.parse(payString);
        java.util.Date endDate = sdf.parse(endString);
        PaymentRefund paymentRefund = new PaymentRefund();
        P2pProduct p2pProduct = new P2pProduct();
        paymentRefund.setPayStartTime(payDate);
        paymentRefund.setSalesMoney(50000);
        p2pProduct.setEnd(endDate);
        p2pProduct.setIncome(0.09);
        p2pProduct.setRepaymentIssue((byte) 1);
        /*int times = DateHelper.getMonthSpace(payString,endString)+1;
        double rate = 0.12;
        double money = 250000;
        calculate(payDate,endDate,rate,money);*/
        this.calculatePayment(paymentRefund, p2pProduct);
//        PaymentRefundModel.calculatePaymentRefund(paymentRefund, p2pProduct);
    }

    @Test
    public void buildAllPaymentRefund() throws ParseException {
        SalesCondition salesCondition = new SalesCondition();
        salesCondition.setPageIndex(1);
        salesCondition.setPageSize(200);
        /*salesCondition.setStatus(3);
        salesCondition.setProductType(5);
        salesCondition.setPayType(-1);
        salesCondition.setIsTest((byte)0);*/
        salesCondition.setStartTime("2015-11-18");
        salesCondition.setEndTime("2015-11-21");
        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild("id");
        sortItem.setSortType(SortType.DESC);
        sortItemList.add(sortItem);
        salesCondition.setSortItemList(sortItemList);
        PagedList<Sales> salesPagedList = SalesModel.getPagingList(salesCondition);
        System.out.print(salesPagedList.getResultList().size() + "_______" + salesPagedList.getPagingInfo().getTotalCount());
        List<Sales> salesList = salesPagedList.getResultList();
        for (Sales sales : salesList) {
            P2pProduct p2pProduct = P2pProductModel.getP2pByProductNo(sales.getProductNo());
            p2pProduct.setIncome(Double.valueOf(sales.getIncome()) / 100.00);
            p2pProduct.setEnd(sales.getRepaymentDate());
            Product product = ProductModel.getInfo(sales.getProductNo());
            PaymentRefund paymentRefund = new PaymentRefund();
            paymentRefund.setSalesNo(sales.getId());
            paymentRefund.setProductType(product.getType());
            paymentRefund.setP2pProductNo(p2pProduct.getId());
            paymentRefund.setP2pProductName(p2pProduct.getName());
            paymentRefund.setProductNo(sales.getProductNo());
            paymentRefund.setProductName(product.getName());
            paymentRefund.setCustomerNo(sales.getCustomerNo());
            paymentRefund.setCustomerName(sales.getCustomerName());
            paymentRefund.setPayerNo(p2pProduct.getBorrowerUserNo());
            paymentRefund.setPayerName(p2pProduct.getBorrowerUserName());
            paymentRefund.setPayStartTime(sales.getPurchaseDate());
            paymentRefund.setSalesMoney(sales.getMoney());
            paymentRefund.setStatus(StatusType.WAITPAYMENT);
            paymentRefund.setIsSendSms(1);
            PaymentRefundModel.calculatePaymentRefund(paymentRefund, p2pProduct);
        }
    }

    @Test
    public void buildOnePaymentRefund() throws ParseException {
        int id = 267942;
        PaymentRefundModel.deleteBySaleNo(id);
        Sales sales = SalesModel.getInfo(id);
        P2pProduct p2pProduct = P2pProductModel.getP2pByProductNo(sales.getProductNo());
        p2pProduct.setIncome(Double.valueOf(sales.getIncome()) / 100.00);
        p2pProduct.setEnd(sales.getRepaymentDate());
        Product product = ProductModel.getInfo(sales.getProductNo());
        PaymentRefund paymentRefund = new PaymentRefund();
        paymentRefund.setSalesNo(sales.getId());
        paymentRefund.setProductType(product.getType());
        paymentRefund.setP2pProductNo(p2pProduct.getId());
        paymentRefund.setP2pProductName(p2pProduct.getName());
        paymentRefund.setProductNo(sales.getProductNo());
        paymentRefund.setProductName(product.getName());
        paymentRefund.setCustomerNo(sales.getCustomerNo());
        paymentRefund.setCustomerName(sales.getCustomerName());
        paymentRefund.setPayerNo(p2pProduct.getBorrowerUserNo());
        paymentRefund.setPayerName(p2pProduct.getBorrowerUserName());
        paymentRefund.setPayStartTime(sales.getPurchaseDate());
        paymentRefund.setSalesMoney(sales.getMoney());
        paymentRefund.setStatus(StatusType.WAITPAYMENT);
        paymentRefund.setIsSendSms(1);
        PaymentRefundModel.calculatePaymentRefund(paymentRefund, p2pProduct);

    }

    public static void calculatePayment(PaymentRefund paymentRefund, P2pProduct p2pProduct) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        double income = 0;
        int dayBetween;
        java.util.Date payStartDate;
        java.util.Date payStartTime = paymentRefund.getPayStartTime();
        int day = DateHelper.daysBetween(paymentRefund.getPayStartTime(), p2pProduct.getEnd()) + 1;
        if (p2pProduct.getRepaymentIssue() == 1) {
            java.util.Date payEndDate = DateHelper.addDay(paymentRefund.getPayStartTime(), day);
            dayBetween = DateHelper.daysBetween(paymentRefund.getPayStartTime(), payEndDate);
            income = MathHelper.getIncome(dayBetween, p2pProduct.getIncome(), paymentRefund.getSalesMoney());
            System.out.println(sdf.format(paymentRefund.getPayStartTime()) + "——" + sdf.format(DateHelper.addDay(payEndDate,-1)) + ":  " + income + "-----" + dayBetween);
            paymentRefund.setInterest(income);
            paymentRefund.setPayMoney(paymentRefund.getSalesMoney() + income);
            paymentRefund.setIsUse((byte) 1);
            paymentRefund.setTimes(1);
            paymentRefund.setActualPayTime(payEndDate);
//            PaymentRefundModel.add(paymentRefund);
        }
        int times = DateHelper.getMonthSpace(paymentRefund.getPayStartTime(), p2pProduct.getEnd());
        for (int i = 1; i <= times + 1; i++) {
            paymentRefund.setPayStartTime(payStartTime);
            java.util.Date payEndDate = DateHelper.getNextMonthFirst(paymentRefund.getPayStartTime(), i);
            if (i == 1) {
                payStartDate = paymentRefund.getPayStartTime();
                dayBetween = DateHelper.daysBetween(payStartDate, payEndDate);
                income = MathHelper.getIncome(dayBetween, p2pProduct.getIncome(), paymentRefund.getSalesMoney());
                paymentRefund.setTimes(i);
                System.out.println(i + ":" + sdf.format(payStartDate) + "——" + payEndDate + ":  " + income + "-----" + dayBetween);
            } else if (i < times + 1) {
                payStartDate = DateHelper.getNextMonthFirst(paymentRefund.getPayStartTime(), i - 1);
                dayBetween = DateHelper.daysBetween(payStartDate, payEndDate);
                income = MathHelper.getIncome(dayBetween, p2pProduct.getIncome(), paymentRefund.getSalesMoney());
                paymentRefund.setTimes(i);
                System.out.println(i + ":" + payStartDate + "——" + payEndDate + ":  " + income + "-----" + dayBetween);
            } else{
                payEndDate = DateHelper.addDay(paymentRefund.getPayStartTime(), day);
                payStartDate = DateHelper.getNextMonthFirst(paymentRefund.getPayStartTime(), i - 1);
                dayBetween = DateHelper.daysBetween(payStartDate, payEndDate);
                income = MathHelper.getIncome(dayBetween, p2pProduct.getIncome(), paymentRefund.getSalesMoney());
                paymentRefund.setTimes(i);
                System.out.println(i + ":" + payStartDate + "——" + sdf.format(DateHelper.addDay(payEndDate,-1)) + ":  " + income + "-----" + dayBetween);
            } /*else if (i == times + 1) {
                payStartDate = DateHelper.getNextMonthFirst(paymentRefund.getPayStartTime(), i - 1);
                dayBetween = DateHelper.daysBetween(payStartDate, payEndDate);
                income = MathHelper.getIncome(dayBetween, p2pProduct.getIncome(), paymentRefund.getSalesMoney());
                paymentRefund.setTimes(i);
                System.out.println(i + ":" + payStartDate + "——" + sdf.format(DateHelper.addDay(payEndDate,-1)) + ":  " + income + "-----" + dayBetween);
            }*/
            paymentRefund.setInterest(income);
            paymentRefund.setPayStartTime(payEndDate);
            paymentRefund.setActualPayTime(payEndDate);
            paymentRefund.setPayMoney(income);
            if (p2pProduct.getRepaymentIssue() == 0) {
                paymentRefund.setIsUse((byte) 1);
            } else {
                paymentRefund.setIsUse((byte) 0);
            }
//            PaymentRefundModel.add(paymentRefund);
        }

    }

    public void calculate(java.util.Date payDate, java.util.Date endDate, double rate, double money) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        int day = DateHelper.daysBetween(payDate, endDate) + 1;
        int times = DateHelper.getMonthSpace(payDate, endDate);
        System.out.println(day);
        double sum = 0;
        for (int i = 1; i <= times; i++) {
            java.util.Date payEndDate = DateHelper.getNextMonthFirst(payDate, i);
            if (i == 1) {
                java.util.Date payStartDate = payDate;
                int dayBetween = DateHelper.daysBetween(payStartDate, payEndDate);
                double income = MathHelper.getIncome(dayBetween, rate, money);
                sum += income;
                System.out.println(sdf.format(payStartDate) + "——" + payEndDate + ":  " + income + "-----" + dayBetween);
            } else if (i == times) {
                payEndDate = DateHelper.addDay(payDate, day);
                java.util.Date payStartDate = DateHelper.getNextMonthFirst(payDate, i - 1);
                int dayBetween = DateHelper.daysBetween(payStartDate, payEndDate);
                double income = MathHelper.getIncome(dayBetween, rate, money);
                sum += income;
                System.out.println(payStartDate + "——" + sdf.format(payEndDate) + ":  " + income + "-----" + dayBetween);
            } else {
                java.util.Date payStartDate = DateHelper.getNextMonthFirst(payDate, i - 1);
                int dayBetween = DateHelper.daysBetween(payStartDate, payEndDate);
                double income = MathHelper.getIncome(dayBetween, rate, money);
                sum += income;
                System.out.println(payStartDate + "——" + payEndDate + ":  " + income + "-----" + dayBetween);
            }
        }
        System.out.println(sum);
    }

    @Test
    public void getDaysTest() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = sdf.parse("2015-05-30");
        java.sql.Date startSqlDate = new java.sql.Date(startDate.getTime());
        System.out.print(DateHelper.addMonth(startSqlDate, 1));
    }

    public static Date getNextMonthFirst(int addMonth) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, addMonth);
        calendar.set(Calendar.DATE, 1);
        Date nextMonthFirstDate = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return DateHelper.parse(sdf.format(nextMonthFirstDate));
    }

    public static double getIncome(double days, double rate, double money) {
        double incomeDays = MathHelper.divide(days, 365);
        double incomeRate = MathHelper.multiply(incomeDays, rate);
        double income = MathHelper.multiply(incomeRate, money);
        BigDecimal bg = new BigDecimal(income);
        bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        return bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();


//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Date startDate = sdf.parse("2015-05-20");
//        Date endDate = sdf.parse("2016-05-19");
//        int result = DateHelper.daysBetween(startDate, endDate);
//        System.out.println(result);
//        System.out.println(getNextMonthFirst(11));
//        System.out.print(getIncome(31,0.12,170000));

        /*for (int i = 1; i <= 12; i++) {
            java.util.Date payEndDate = DateHelper.getNextMonthFirst(i);
            if(i == 1){
                java.util.Date payStartDate = DateHelper.getTodayDate();
                int daysBetween = DateHelper.daysBetween(payStartDate, payEndDate);
                double income = MathHelper.getIncome(daysBetween,0.14,100000);
                System.out.println(payStartDate + "——" + payEndDate + ":  " + income);
            }else if(i == 12){
                payEndDate = DateHelper.addDay(DateHelper.getTodayDate(),365);
                java.util.Date payStartDate = DateHelper.getNextMonthFirst(i-1);
                int dayBetween = DateHelper.daysBetween(payStartDate,payEndDate)+1;
                double income = MathHelper.getIncome(dayBetween,0.14,100000);
                System.out.println(payStartDate + "——" + payEndDate + ":  " + income);
            }else{
                java.util.Date payStartDate = DateHelper.getNextMonthFirst(i - 1);
                int dayBetween = DateHelper.daysBetween(payStartDate,payEndDate);
                double income = MathHelper.getIncome(dayBetween,0.14,100000);
                System.out.println(payStartDate + "——" + payEndDate + ":  " + income);
            }
        }*/
    }

    @Test
    public void dateTest(){
        /*Calendar calendar = Calendar.getInstance();
        int day_of_week = calendar.get(Calendar.DAY_OF_WEEK)-2;
        calendar.add(Calendar.DATE, -day_of_week);
        System.out.print(calendar.getTime());
        calendar.add(Calendar.DATE, 6);
        System.out.print(calendar.getTime());*/
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        System.out.println(sf.format(calendar.getTime()));
        calendar.add(Calendar.DATE,1);
        System.out.println(sf.format(calendar.getTime()));

        calendar.set(Calendar.DAY_OF_WEEK,Calendar.SATURDAY);
        System.out.println(sf.format(calendar.getTime()));


    }


}
