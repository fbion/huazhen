package com.hzfh.service.sales.daoImpl;

import com.hzfh.api.sales.model.Sales;
import com.hzfh.api.sales.model.query.SalesCondition;
import com.hzfh.service.sales.dao.SalesDao;
import com.hzfh.service.sales.mapper.SalesMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
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


@Service("salesDao")
public class SalesDaoImpl extends BaseDaoImpl<Sales, SalesCondition, SalesMapper> implements SalesDao {

	@Autowired
	private SalesMapper salesMapper;
	@Override
	public int updateStatus(int id, byte status) {
		return salesMapper.updateStatus(id,status);
	}
	@Override
	public int addFilePath(Sales sales) {
		return salesMapper.addFilePath(sales);
	}
	@Override
	public List<Sales> getSumMoneyList(int productNo) {
		return salesMapper.getSumMoneyList(productNo);
	}
	@Override
	public List<Sales> getSalesListByProductAndStatus(int productNo, int status) {
		return salesMapper.getSalesListByProductAndStatus(productNo,(byte)status);
	}

    @Override
    public Sales getInfoByActivitiNo(String activitiNo) {
        return salesMapper.getInfoByActivitiNo(activitiNo);
    }

    @Override
    public List<Sales> getListByEmps(String empNos) {
        return salesMapper.getListByEmps(empNos);
    }

    @Override
    public List<Sales> getSalesListByProductAndStates(int productNo, String status) {
        return salesMapper.getSalesListByProductAndStates(productNo,status);
    }

    @Override
    public List<Sales> getListByCustomerNo(int customerNo) {
        return salesMapper.getListByCustomerNo(customerNo);
    }

    @Override
    public int updateCustomerNameByCustomerNo(int customerNo, String customerName) {
        return salesMapper.updateCustomerNameByCustomerNo(customerNo,customerName);
    }

    @Override
	public int updateStatusByProductionNoAndStatus(int productNo, byte status) {
		return salesMapper.updateStatusByProductionNoAndStatus(productNo,status);
	}
    @Override
	public int updateStagesByProductionNoAndStatus(int productStagesNo,int productNo, byte status) {
		return salesMapper.updateStagesByProductionNoAndStatus(productStagesNo,productNo,status);
	}
	@Override
	public Long getAllAccountMoney(int productNo, byte status) {
		return salesMapper.getAllAccountMoney(productNo,status);
	}

    @Override
    public Long getP2pSumMoney(SalesCondition salesCondition) {

        return salesMapper.getP2pSumMoney(salesCondition);
    }

    @Override
	public List<Sales> getNoPagingList(SalesCondition salesCondition) {
		return salesMapper.getNoPagingList(salesCondition);
	}
    @Override
    public int updateEstablishDateByProductNoAndisEstablish(int productNo,Date establishDate){
        return salesMapper.updateEstablishDateByProductNoAndisEstablish(productNo,establishDate);
    }
	@Override
	public List<Sales> getSalesListByProductNoAndCount(int productNo, int count) {
		// TODO Auto-generated method stub
		return salesMapper.getSalesListByProductNoAndCount(productNo,count);
	}

	
	@Override
	public List<Sales> getListByP2pCustomerNoAndProductType(int p2pCustomerNo,
			int productType) {
		return salesMapper.getListByP2pCustomerNoAndProductType(p2pCustomerNo,
				 productType);
	}

    @Override
    public int updateP2pCustomerNoByCustomerNo(int customerNo,int p2pCustomerNo){
        return salesMapper.updateP2pCustomerNoByCustomerNo(customerNo,p2pCustomerNo);
    }
	@Override
	public Long getWillHavingPrincipal(int customerNo, byte status) {
		return salesMapper.getWillHavingPrincipal(customerNo,status);
	}
    @Override
    public List<Sales> getListForExacl(SalesCondition salesCondition){
        return salesMapper.getListForExacl(salesCondition);
    }

	@Override
	public int updateIncomeById(int id, double income) {
		return salesMapper.updateIncomeById(id,income);
	}

    @Override
    public int updateActivitiNoBySalesNo(int saleNo, String activitiNo) {
        return salesMapper.updateActivitiNoBySalesNo(saleNo,activitiNo);
    }

	@Override
	public List<Sales> getCurrentWeekSales(SalesCondition salesCondition) {
		return salesMapper.getCurrentWeekSales(salesCondition);
	}


    @Override
    public List<Sales> getSumMoneyGroupByEmp(SalesCondition salesCondition) {
        return salesMapper.getSumMoneyGroupByEmp(salesCondition);
    }

}