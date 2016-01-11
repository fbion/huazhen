package com.hzfh.service.sales.serviceImpl;

import com.hzfh.api.sales.model.Sales;
import com.hzfh.api.sales.model.query.SalesCondition;
import com.hzfh.api.sales.service.SalesService;
import com.hzfh.service.sales.dao.SalesDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/*******************************************************************************
 * 
 * Copyright 2014 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2014/12/29 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("salesService")
public class SalesServiceImpl extends BaseServiceImpl<Sales, SalesCondition, SalesDao> implements SalesService {
	@Autowired
	private SalesDao salesDao;
	@Override
	public int updateStatus(int id, byte status) {
		return salesDao.updateStatus(id,status);
	}
	public int addFilePath(Sales sales) {
		return salesDao.addFilePath(sales);
	}

    @Override
    public List<Sales> getListByEmps(String empNos) {
        return salesDao.getListByEmps(empNos);
    }

    @Override

	public List<Sales> getSumMoneyList(int productNo) {
		return salesDao.getSumMoneyList(productNo);
	}
	@Override
	public List<Sales> getSalesListByProductAndStatus(int productNo, int status) {
		return salesDao.getSalesListByProductAndStatus(productNo,status);
	}
    @Override
    public List<Sales> getSalesListByProductAndStates(int productNo, String status) {
        return salesDao.getSalesListByProductAndStates(productNo,status);
    }

    @Override
    public Sales getInfoByActivitiNo(String activitiNo) {
        return salesDao.getInfoByActivitiNo(activitiNo);
    }

    @Override
    public List<Sales> getListByCustomerNo(int customerNo) {
        return salesDao.getListByCustomerNo(customerNo);
    }

    @Override
    public int updateCustomerNameByCustomerNo(int customerNo, String customerName) {
        return salesDao.updateCustomerNameByCustomerNo(customerNo,customerName);
    }

    @Override
	public int updateStatusByProductionNoAndStatus(int productNo, byte status) {
		return salesDao.updateStatusByProductionNoAndStatus(productNo,status);
	}
	@Override
	public int updateStagesByProductionNoAndStatus(int productStagesNo,int productNo, byte status) {
		return salesDao.updateStagesByProductionNoAndStatus(productStagesNo,productNo,status);
	}

    @Override
	public Long getAllAccountMoney(int productNo, byte status) {

        return salesDao.getAllAccountMoney(productNo,status);
	}
    @Override
    public Long getP2pSumMoney(SalesCondition salesCondition) {
        return salesDao.getP2pSumMoney(salesCondition);
    }

    @Override
	public List<Sales> getNoPagingList(SalesCondition salesCondition) {
		return salesDao.getNoPagingList(salesCondition);
	}
    @Override
    public int updateEstablishDateByProductNoAndisEstablish(int productNo,Date establishDate){
        return salesDao.updateEstablishDateByProductNoAndisEstablish(productNo,establishDate);
    }
	@Override
	public List<Sales> getSalesListByProductNoAndCount(int productNo, int count) {
		return salesDao.getSalesListByProductNoAndCount(productNo,count);
	}

	@Override
	public List<Sales> getListByP2pCustomerNoAndProductType(int p2pCustomerNo,int productType) {
		return salesDao.getListByP2pCustomerNoAndProductType( p2pCustomerNo,productType);
	}

    @Override
    public int updateP2pCustomerNoByCustomerNo(int customerNo,int p2pCustomerNo){
        return salesDao.updateP2pCustomerNoByCustomerNo(customerNo,p2pCustomerNo);
    }
	@Override
	public Long getWillHavingPrincipal(int customerNo, byte status) {
		return salesDao.getWillHavingPrincipal(customerNo,status);	
	}
    @Override
    public List<Sales> getListForExacl(SalesCondition salesCondition){
        return salesDao.getListForExacl(salesCondition);
    }

	@Override
	public int updateIncomeById(int id, double income) {
		return salesDao.updateIncomeById(id,income);
	}

    @Override
    public int updateActivitiNoBySalesNo(int salesNo, String activitiNo) {
        return salesDao.updateActivitiNoBySalesNo(salesNo,activitiNo);
    }

	@Override
	public List<Sales> getCurrentWeekSales(SalesCondition salesCondition) {
		return salesDao.getCurrentWeekSales(salesCondition);
	}

    @Override
    public List<Sales> getSumMoneyGroupByEmp(SalesCondition salesCondition) {
        return salesDao.getSumMoneyGroupByEmp(salesCondition);
    }

}