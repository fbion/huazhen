package com.hzfh.service.sales.dao;

import com.hzfh.api.sales.model.Sales;
import com.hzfh.api.sales.model.query.SalesCondition;
import com.hzframework.data.dao.BaseDao;

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


public interface SalesDao extends BaseDao<Sales, SalesCondition> {

    int updateStatus(int id, byte status);

    int addFilePath(Sales sales);
    List<Sales> getListByEmps(String empNos);
    List<Sales> getSumMoneyList(int productNo);

    List<Sales> getSalesListByProductAndStatus(int productNo, int status);
    List<Sales> getSalesListByProductAndStates(int productNo, String status);
    int updateStatusByProductionNoAndStatus(int productNo, byte status);

    int updateStagesByProductionNoAndStatus(int productStagesNo, int productNo, byte status);

    Long getAllAccountMoney(int productNo, byte status);
    Long getP2pSumMoney(SalesCondition salesCondition);

    List<Sales> getNoPagingList(SalesCondition salesCondition);
    Sales getInfoByActivitiNo(String activitiNo);
    int updateEstablishDateByProductNoAndisEstablish(int productNo, Date establishDate);
    List<Sales> getListByCustomerNo(int customerNo);
    int updateCustomerNameByCustomerNo(int customerNo,String customerName);

    List<Sales> getSalesListByProductNoAndCount(int productNo, int count);

    int updateP2pCustomerNoByCustomerNo(int customerNo, int p2pCustomerNo);

    List<Sales> getListByP2pCustomerNoAndProductType(int p2pCustomerNo,
                                                     int productType);
    Long getWillHavingPrincipal(int customerNo, byte status);

    List<Sales> getListForExacl(SalesCondition salesCondition);

    int updateIncomeById(int id, double income);

    int updateActivitiNoBySalesNo(int salesNo,String activitiNo);

    List<Sales> getCurrentWeekSales(SalesCondition salesCondition);
    List<Sales> getSumMoneyGroupByEmp(SalesCondition salesCondition);
}