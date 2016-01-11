package com.hzfh.fmp.facade.payment;

import com.hzfh.api.payment.model.PaymentRefund;
import com.hzfh.api.payment.model.query.PaymentRefundCondition;
import com.hzfh.api.payment.service.PaymentRefundService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class PaymentRefundFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-payment.xml");

    public static PagedList<PaymentRefund> getPagingList(PaymentRefundCondition paymentRefundCondition) {
        PaymentRefundService paymentRefundService = (PaymentRefundService) context.getBean("paymentRefundService");

        return  paymentRefundService.getPagingList(paymentRefundCondition);
    }
    public static PaymentRefund getHonourBySalesNo(int salesNo){
        PaymentRefundService paymentRefundService = (PaymentRefundService) context.getBean("paymentRefundService");
        return paymentRefundService.getHonourBySalesNo(salesNo);
    }
    public static int updatePaymentTypeBySalesNoAndHonour(int salesNo,int paymentType){
        PaymentRefundService paymentRefundService = (PaymentRefundService) context.getBean("paymentRefundService");
        return paymentRefundService.updatePaymentTypeBySalesNoAndHonour(salesNo,paymentType);
    }
    public static int updatePayMoneyBySalesNoAndHonour(int salesNo,double payMoney){
        PaymentRefundService paymentRefundService = (PaymentRefundService) context.getBean("paymentRefundService");
        return paymentRefundService.updatePayMoneyBySalesNoAndHonour(salesNo,payMoney);
    }
    public static int add(PaymentRefund paymentRefund){
        PaymentRefundService paymentRefundService = (PaymentRefundService) context.getBean("paymentRefundService");

        return paymentRefundService.add(paymentRefund);
    }

    public static int deleteBySaleNo(int salesNo){
        PaymentRefundService paymentRefundService = (PaymentRefundService) context.getBean("paymentRefundService");
        return paymentRefundService.deleteBySaleNo(salesNo);
    }
    public static int update(PaymentRefund paymentRefund){
        PaymentRefundService paymentRefundService = (PaymentRefundService) context.getBean("paymentRefundService");

        return paymentRefundService.update(paymentRefund);
    }
    public static int updateExamineStatusByIds(String ids,int examineStatus){
        PaymentRefundService paymentRefundService = (PaymentRefundService) context.getBean("paymentRefundService");
        return paymentRefundService.updateExamineStatusByIds(ids,examineStatus);
    }
    public static List<PaymentRefund> getListForExcel(PaymentRefundCondition paymentRefundCondition){
        PaymentRefundService paymentRefundService = (PaymentRefundService) context.getBean("paymentRefundService");

        return paymentRefundService.getListForExcel(paymentRefundCondition);
    }

    public static List<PaymentRefund> getList(){
        PaymentRefundService paymentRefundService = (PaymentRefundService) context.getBean("paymentRefundService");

        return paymentRefundService.getList();
    }
    public static double getTotalValue(int saleNo){
        PaymentRefundService paymentRefundService = (PaymentRefundService) context.getBean("paymentRefundService");
        return paymentRefundService.getTotalValue(saleNo);
    }
    public static PaymentRefund getInfo(int id){
        PaymentRefundService paymentRefundService = (PaymentRefundService) context.getBean("paymentRefundService");

        return paymentRefundService.getInfo(id);
    }
    public static int updateStatusById(int id,byte status){
        PaymentRefundService paymentRefundService = (PaymentRefundService) context.getBean("paymentRefundService");

        return  paymentRefundService.updateStatusById(id, status);
    }

    public static List<PaymentRefund> getInfoBySalesId(int salesId) {
        PaymentRefundService paymentRefundService = (PaymentRefundService) context.getBean("paymentRefundService");
        return  paymentRefundService.getInfoBySalesId(salesId);
    }
    public static List<PaymentRefund> getInfoBySalesIdAndIsUse(int salesId,int isUse) {
        PaymentRefundService paymentRefundService = (PaymentRefundService) context.getBean("paymentRefundService");
        return  paymentRefundService.getInfoBySalesIdAndIsUse(salesId,isUse);
    }

    public static PaymentRefund getInfoBySalesIdLimit(int salesId) {
        PaymentRefundService paymentRefundService = (PaymentRefundService) context.getBean("paymentRefundService");
        return  paymentRefundService.getInfoBySalesIdLimit(salesId);
    }
    public static int cancelSendSmsByIds(List<String> idList){
        PaymentRefundService paymentRefundService = (PaymentRefundService) context.getBean("paymentRefundService");
        return paymentRefundService.cancelSendSmsByIds(idList);
    }

    public static int updateLastPayMoneyOfSales(int salesNo,int maxTime) {
        PaymentRefundService paymentRefundService = (PaymentRefundService) context.getBean("paymentRefundService");
        return paymentRefundService.updateLastPayMoneyOfSales(salesNo, maxTime);
    }

    public static int getMaxTimeBySalesNo(int salesNo) {
        PaymentRefundService paymentRefundService = (PaymentRefundService) context.getBean("paymentRefundService");
        return paymentRefundService.getMaxTimeBySalesNo(salesNo);
    }

    public static int updateP2pCustomerNoByCustomerNo(int customerNo,int p2pCustomerNo){
        PaymentRefundService paymentRefundService = (PaymentRefundService) context.getBean("paymentRefundService");
        return paymentRefundService.updateP2pCustomerNoByCustomerNo(customerNo,p2pCustomerNo);
    }

    public static int getTimesIsUseBySalesNo(int salesNo){
        PaymentRefundService paymentRefundService = (PaymentRefundService) context.getBean("paymentRefundService");
        return paymentRefundService.getTimesIsUseBySalesNo(salesNo);
    }

    public static List<PaymentRefund> getListByByHonourDateAndTypeAndStatus(String honourDate,String type,String status){
        PaymentRefundService paymentRefundService = (PaymentRefundService) context.getBean("paymentRefundService");
        return paymentRefundService.getListByByHonourDateAndTypeAndStatus(honourDate,type,status);
    }
}
