package com.hzfh.service.payment.daoImpl;

import com.hzfh.api.payment.model.PaymentRefund;
import com.hzfh.api.payment.model.query.PaymentRefundCondition;
import com.hzfh.service.payment.dao.PaymentRefundDao;
import com.hzfh.service.payment.mapper.PaymentRefundMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: HuLei  
 * Create Date: 2015/6/19 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("paymentRefundDao")
public class PaymentRefundDaoImpl extends BaseDaoImpl<PaymentRefund, PaymentRefundCondition, PaymentRefundMapper> implements PaymentRefundDao {
    @Autowired
    PaymentRefundMapper paymentRefundMapper;
    @Override
    public int updateStatusById(int id, byte status) {
        return paymentRefundMapper.updateStatusById(id, status);
    }

    @Override
    public int updateExamineStatusByIds(String ids,int examineStatus) {
        return paymentRefundMapper.updateExamineStatusByIds(ids,examineStatus);
    }

    @Override
    public List<PaymentRefund> getInfoBySalesIdAndIsUse(int salesId, int isUse) {
        return paymentRefundMapper.getInfoBySalesIdAndIsUse(salesId,isUse);
    }

    @Override
    public int updatePaymentTypeBySalesNoAndHonour(int salesNo, int paymentType) {
        return paymentRefundMapper.updatePaymentTypeBySalesNoAndHonour(salesNo,paymentType);
    }

    @Override
    public PaymentRefund getHonourBySalesNo(int salesNo) {
        return paymentRefundMapper.getHonourBySalesNo(salesNo);
    }

    @Override
    public int updatePayMoneyBySalesNoAndHonour(int salesNo, double payMoney) {
        return paymentRefundMapper.updatePayMoneyBySalesNoAndHonour(salesNo,payMoney);
    }

    @Override
    public List<PaymentRefund> getInfoBySalesId(int salesId) {
        return paymentRefundMapper.getInfoBySalesId(salesId);
    }
    @Override
    public List<PaymentRefund> getListForExcel(PaymentRefundCondition paymentRefundCondition){
        return paymentRefundMapper.getListForExcel(paymentRefundCondition);
    }
	@Override
	public Double getInvestmentIncome(int customerNo,byte status) {
		return paymentRefundMapper.getInvestmentIncome(customerNo,status);
	}

	@Override
	public Double getInvestIncomeingByCustomerNo(int customerNo) {
		return paymentRefundMapper.getInvestIncomeingByCustomerNo(customerNo);
	}
    @Override
    public PaymentRefund getInfoBySalesIdLimit(int salesId) {
        return paymentRefundMapper.getInfoBySalesIdLimit(salesId);
    }
    @Override
    public int cancelSendSmsByIds(List<String> idList){

        return paymentRefundMapper.cancelSendSmsByIds(idList);
    }

    @Override
    public int updateLastPayMoneyOfSales(int salesNo, int maxTime) {
        return paymentRefundMapper.updateLastPayMoneyOfSales(salesNo, maxTime);
    }
    @Override
    public double getTotalValue(int saleNo){
        return paymentRefundMapper.getTotalValue(saleNo);
    }

    @Override
    public int getMaxTimeBySalesNo(int salesNo) {
        return paymentRefundMapper.getMaxTimeBySalesNo(salesNo);
    }

    @Override
    public int deleteBySaleNo(int salesNo){
        return paymentRefundMapper.deleteBySaleNo(salesNo);
    }

    @Override
    public int updateP2pCustomerNoByCustomerNo(int customerNo,int p2pCustomerNo){
        return paymentRefundMapper.updateP2pCustomerNoByCustomerNo(customerNo,p2pCustomerNo);
    }

    @Override
    public int getTimesIsUseBySalesNo(int salesNo) {
        return paymentRefundMapper.getTimesIsUseBySalesNo(salesNo);
    }

    @Override
    public List<PaymentRefund> getListByByHonourDateAndTypeAndStatus(String honourDate, String type, String status) {
        return paymentRefundMapper.getListByByHonourDateAndTypeAndStatus(honourDate,type,status);
    }
}