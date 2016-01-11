package com.hzfh.service.payment.serviceImpl;

import com.hzfh.api.payment.model.PaymentRefund;
import com.hzfh.api.payment.model.query.PaymentRefundCondition;
import com.hzfh.api.payment.service.PaymentRefundService;
import com.hzfh.service.payment.dao.PaymentRefundDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*******************************************************************************
 * Copyright 2015 HZFH. All rights reserved.
 * Author: HuLei
 * Create Date: 2015/6/19
 * Description:
 * <p/>
 * Revision History:
 * Date         Author               Description
 ******************************************************************************/


@Service("paymentRefundService")
public class PaymentRefundServiceImpl extends BaseServiceImpl<PaymentRefund, PaymentRefundCondition, PaymentRefundDao> implements PaymentRefundService {
    @Autowired
    PaymentRefundDao paymentRefundDao;

    @Override
    public int updateStatusById(int id, byte status) {
        return paymentRefundDao.updateStatusById(id, status);
    }

    @Override
    public List<PaymentRefund> getInfoBySalesId(int salesId) {
        return paymentRefundDao.getInfoBySalesId(salesId);
    }

    @Override
    public List<PaymentRefund> getListForExcel(PaymentRefundCondition paymentRefundCondition){
        return paymentRefundDao.getListForExcel(paymentRefundCondition);
    }

    @Override
    public List<PaymentRefund> getInfoBySalesIdAndIsUse(int salesId, int isUse) {
        return paymentRefundDao.getInfoBySalesIdAndIsUse(salesId,isUse);
    }

    @Override
    public Double getInvestmentIncome(int customerNo, byte status) {
        return paymentRefundDao.getInvestmentIncome(customerNo, status);
    }

    @Override
    public int updatePaymentTypeBySalesNoAndHonour(int salesNo, int paymentType) {
        return paymentRefundDao.updatePaymentTypeBySalesNoAndHonour(salesNo,paymentType);
    }

    @Override
    public PaymentRefund getHonourBySalesNo(int salesNo) {
        return paymentRefundDao.getHonourBySalesNo(salesNo);
    }

    @Override
    public int updatePayMoneyBySalesNoAndHonour(int salesNo, double payMoney) {
        return paymentRefundDao.updatePayMoneyBySalesNoAndHonour(salesNo,payMoney);
    }

    @Override
    public Double getInvestIncomeingByCustomerNo(int customerNo) {
        return paymentRefundDao.getInvestIncomeingByCustomerNo(customerNo);
    }

    @Override
    public PaymentRefund getInfoBySalesIdLimit(int salesId) {
        return paymentRefundDao.getInfoBySalesIdLimit(salesId);
    }

    @Override
    public int cancelSendSmsByIds(List<String> idList) {

        return paymentRefundDao.cancelSendSmsByIds(idList);
    }

    @Override
    public int updateExamineStatusByIds(String ids,int examineStatus) {
        return paymentRefundDao.updateExamineStatusByIds(ids,examineStatus);
    }

    @Override
    public double getTotalValue(int saleNo){
        return paymentRefundDao.getTotalValue(saleNo);
    }
    @Override
    public int updateLastPayMoneyOfSales(int salesNo,int maxTime) {
        return paymentRefundDao.updateLastPayMoneyOfSales(salesNo, maxTime);
    }

    @Override
    public int getMaxTimeBySalesNo(int salesNo) {
        return paymentRefundDao.getMaxTimeBySalesNo(salesNo);
    }

    @Override
    public int deleteBySaleNo(int salesNo){
        return paymentRefundDao.deleteBySaleNo(salesNo);
    }

    @Override
    public int updateP2pCustomerNoByCustomerNo(int customerNo,int p2pCustomerNo){
        return paymentRefundDao.updateP2pCustomerNoByCustomerNo(customerNo,p2pCustomerNo);
    }

    @Override
    public int getTimesIsUseBySalesNo(int salesNo) {
        return paymentRefundDao.getTimesIsUseBySalesNo(salesNo);
    }

    @Override
    public List<PaymentRefund> getListByByHonourDateAndTypeAndStatus(String honourDate, String type, String status) {
        return paymentRefundDao.getListByByHonourDateAndTypeAndStatus(honourDate,type,status);
    }
}