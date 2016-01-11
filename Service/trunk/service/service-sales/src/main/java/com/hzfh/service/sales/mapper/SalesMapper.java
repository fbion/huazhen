package com.hzfh.service.sales.mapper;

import com.hzfh.api.sales.model.Sales;
import com.hzfh.api.sales.model.query.SalesCondition;
import com.hzframework.data.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/*******************************************************************************
 * Copyright 2014 HZFH. All rights reserved.
 * Author: GuoZhenYu
 * Create Date: 2014/12/29
 * Description:
 * <p/>
 * Revision History:
 * Date         Author               Description
 ******************************************************************************/


@Service("salesMapper")
public interface SalesMapper extends BaseMapper<Sales, SalesCondition> {
    int updateStatus(int id, byte status);

    int addFilePath(Sales sales);
    Sales getInfoByActivitiNo(@Param("activitiNo")String activitiNo);
    List<Sales> getSumMoneyList(int productNo);
    List<Sales> getListByEmps(@Param("empNos")String empNos);
    List<Sales> getSalesListByProductAndStatus(int productNo, int status);

    List<Sales> getSalesListByProductAndStates(@Param("productNo")int productNo,@Param("status")String status);

    int updateStatusByProductionNoAndStatus(@Param("productNo") int productNo, @Param("status") int status);

    int updateStagesByProductionNoAndStatus(@Param("productStagesNo") int productStagesNo, @Param("productNo") int productNo, @Param("status") byte status);

    Long getAllAccountMoney(@Param("productNo") int productNo, @Param("status") byte status);

    Long getP2pSumMoney(SalesCondition salesCondition);

    List<Sales> getNoPagingList(SalesCondition salesCondition);

    int updateEstablishDateByProductNoAndisEstablish(@Param("productNo") int productNo, @Param("establishDate") Date establishDate);

    List<Sales> getSalesListByProductNoAndCount(@Param("productNo") int productNo, @Param("count") int count);

    List<Sales> getListByP2pCustomerNoAndProductType(@Param("p2pCustomerNo") int p2pCustomerNo, @Param("productType") int productType);

    List<Sales> getListByCustomerNo(@Param("customerNo")int customerNo);
    int updateCustomerNameByCustomerNo(@Param("customerNo")int customerNo,@Param("customerName")String customerName);

    int updateP2pCustomerNoByCustomerNo(@Param("customerNo") int customerNo, @Param("p2pCustomerNo") int p2pCustomerNo);

    Long getWillHavingPrincipal(@Param("customerNo") int customerNo, @Param("status") byte status);


    List<Sales> getListForExacl(SalesCondition salesCondition);

    int updateIncomeById(@Param("id") int id, @Param("income") double income);

    int updateActivitiNoBySalesNo(@Param("salesNo") int salesNo, @Param("activitiNo") String activitiNo);

    List<Sales> getCurrentWeekSales(SalesCondition salesCondition);

    List<Sales> getSumMoneyGroupByEmp(SalesCondition salesCondition);

}