package com.hzfh.service.payment.dao;

import com.hzfh.api.payment.model.PaymentRefund;
import com.hzfh.api.payment.model.query.PaymentRefundCondition;
import com.hzframework.data.dao.BaseDao;

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


public interface PaymentRefundDao extends BaseDao<PaymentRefund, PaymentRefundCondition> {
    int updateStatusById(int id, byte status);

    List<PaymentRefund> getInfoBySalesId(int salesId);
    List<PaymentRefund> getInfoBySalesIdAndIsUse(int salesId,int isUse);

    List<PaymentRefund> getListForExcel(PaymentRefundCondition paymentRefundCondition);
    Double getInvestmentIncome(int customerNo, byte status);
    PaymentRefund getHonourBySalesNo(int salesNo);
    Double getInvestIncomeingByCustomerNo(int customerNo);
    int updatePaymentTypeBySalesNoAndHonour(int salesNo,int paymentType);
    int updatePayMoneyBySalesNoAndHonour(int salesNo,double payMoney);
    PaymentRefund getInfoBySalesIdLimit(int salesId);

    int cancelSendSmsByIds(List<String> idList);

    int updateLastPayMoneyOfSales(int salesNo, int maxTime);
    int updateExamineStatusByIds(String ids,int examineStatus);
    int getMaxTimeBySalesNo(int salesNo);

    double getTotalValue(int saleNo);

    int deleteBySaleNo(int salesNo);
    int updateP2pCustomerNoByCustomerNo(int customerNo,int p2pCustomerNo);

    int getTimesIsUseBySalesNo(int salesNo);

    List<PaymentRefund> getListByByHonourDateAndTypeAndStatus(String honourDate,String type,String status);
}