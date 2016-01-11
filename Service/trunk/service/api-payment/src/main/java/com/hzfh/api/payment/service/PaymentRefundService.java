package com.hzfh.api.payment.service;

import com.hzfh.api.payment.model.PaymentRefund;
import com.hzfh.api.payment.model.query.PaymentRefundCondition;
import com.hzframework.data.service.BaseService;

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


public interface PaymentRefundService extends BaseService<PaymentRefund, PaymentRefundCondition> {
    int updateStatusById(int id, byte status);

    List<PaymentRefund> getInfoBySalesId(int salesId);
    List<PaymentRefund> getInfoBySalesIdAndIsUse(int salesId,int isUse);
    List<PaymentRefund> getListForExcel(PaymentRefundCondition paymentRefundCondition);
    PaymentRefund getHonourBySalesNo(int salesNo);
    Double getInvestmentIncome(int customerNo, byte status);

    Double getInvestIncomeingByCustomerNo(int customerNo);

    PaymentRefund getInfoBySalesIdLimit(int salesNo);

    int cancelSendSmsByIds(List<String> idList);
    int updatePaymentTypeBySalesNoAndHonour(int salesNo,int paymentType);
    int updatePayMoneyBySalesNoAndHonour(int salesNo,double payMoney);
    int updateExamineStatusByIds(String ids,int examineStatus);

    int updateLastPayMoneyOfSales(int salesNo ,int maxTime);

    int getMaxTimeBySalesNo(int salesNo);

    double getTotalValue(int saleNo);

    int deleteBySaleNo(int salesNo);

    int updateP2pCustomerNoByCustomerNo(int customerNo,int p2pCustomerNo);
    int getTimesIsUseBySalesNo(int salesNo);

    List<PaymentRefund> getListByByHonourDateAndTypeAndStatus(String honourDate,String type,String status);
}