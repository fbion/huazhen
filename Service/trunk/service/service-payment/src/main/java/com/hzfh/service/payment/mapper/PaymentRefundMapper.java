package com.hzfh.service.payment.mapper;

import com.hzfh.api.payment.model.PaymentRefund;
import com.hzfh.api.payment.model.query.PaymentRefundCondition;
import com.hzframework.data.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
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


@Service("paymentRefundMapper")
public interface PaymentRefundMapper extends BaseMapper<PaymentRefund, PaymentRefundCondition> {
    int updateStatusById(@Param("id") int id, @Param("status") byte status);

    List<PaymentRefund> getInfoBySalesId(@Param("salesId") int salesId);
    List<PaymentRefund> getInfoBySalesIdAndIsUse(@Param("salesId")int salesId,@Param("isUse")int isUse);
    List<PaymentRefund> getListForExcel(PaymentRefundCondition paymentRefundCondition);

    Double getInvestmentIncome(@Param("customerNo") int customerNo, @Param("status") byte status);

    Double getInvestIncomeingByCustomerNo(@Param("customerNo") int customerNo);

    PaymentRefund getInfoBySalesIdLimit(@Param("salesNo") int salesNo);
    PaymentRefund getHonourBySalesNo(@Param("salesNo")int salesNo);
    int updateExamineStatusByIds(@Param("ids")String ids,@Param("examineStatus")int examineStatus);
    int cancelSendSmsByIds(@Param("idList") List<String> idList);

    int getMaxTimeBySalesNo(@Param("salesNo")int salesNo);

    int updatePaymentTypeBySalesNoAndHonour(@Param("salesNo")int salesNo,@Param("paymentType")int paymentType);
    int updatePayMoneyBySalesNoAndHonour(@Param("salesNo")int salesNo,@Param("payMoney")double payMoney);

    int updateLastPayMoneyOfSales(@Param("salesNo")int salesNo, @Param("maxTime")int maxTime);
    double getTotalValue(@Param("saleNo")int saleNo);

    int deleteBySaleNo(@Param("salesNo")int salesNo);
    int updateP2pCustomerNoByCustomerNo(@Param("customerNo")int customerNo,@Param("p2pCustomerNo")int p2pCustomerNo);
    int getTimesIsUseBySalesNo(@Param("salesNo")int salesNo);

    List<PaymentRefund> getListByByHonourDateAndTypeAndStatus(@Param("honourDate")String honourDate,@Param("type")String type,@Param("status")String status);
}