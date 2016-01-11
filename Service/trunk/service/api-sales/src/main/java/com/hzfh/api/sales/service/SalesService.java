package com.hzfh.api.sales.service;
import com.hzfh.api.sales.model.Sales;
import com.hzfh.api.sales.model.query.SalesCondition;
import com.hzframework.data.service.BaseService;

import java.util.Date;
import java.util.List;

/*******************************************************************************
 * Copyright 2015 HZFH. All rights reserved.
 * Author: GuoZhenYu
 * Create Date: 2015/1/8
 * Description:
 * <p/>
 * Revision History:
 * Date         Author               Description
 ******************************************************************************/


public interface SalesService extends BaseService<Sales, SalesCondition> {
    int updateStatus(int id, byte status);

    List<Sales> getListForExacl(SalesCondition salesCondition);
    List<Sales> getListByEmps(String empNos);
    int addFilePath(Sales sales);
    Sales getInfoByActivitiNo(String activitiNo);
    List<Sales> getListByCustomerNo(int customerNo);
    int updateCustomerNameByCustomerNo(int customerNo,String customerName);

    public List<Sales> getSumMoneyList(int productNo);

    public List<Sales> getSalesListByProductAndStatus(int productNo, int status);
    public List<Sales> getSalesListByProductAndStates(int productNo,String status);

    int updateStatusByProductionNoAndStatus(int productNo, byte status);

    int updateStagesByProductionNoAndStatus(int productStagesNo, int productNo, byte status);

    Long getAllAccountMoney(int productNo, byte status);
    Long getP2pSumMoney(SalesCondition salesCondition);
    List<Sales> getNoPagingList(SalesCondition salesCondition);

    int updateEstablishDateByProductNoAndisEstablish(int productNo, Date establishDate);

    List<Sales> getSalesListByProductNoAndCount(int productNo, int count);

    List<Sales> getListByP2pCustomerNoAndProductType(int p2pCustomerNo, int productType);


    int updateP2pCustomerNoByCustomerNo(int customerNo, int p2pCustomerNo);

    Long getWillHavingPrincipal(int customerNo, byte status);

    int updateIncomeById(int id, double income);
    int updateActivitiNoBySalesNo(int salesNo,String activitiNo);

    List<Sales> getCurrentWeekSales(SalesCondition salesCondition);

    List<Sales> getSumMoneyGroupByEmp(SalesCondition salesCondition);

}