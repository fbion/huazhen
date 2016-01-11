package com.hzfh.fmp.model.sales;

import com.hzfh.api.sales.model.Sales;
import com.hzfh.api.sales.model.SalesCreditor;
import com.hzfh.api.sales.model.query.SalesCondition;
import com.hzfh.fmp.facade.sales.SalesFacade;
import com.hzfh.fmp.model.common.EnumListCacheModel;
import com.hzfh.fmp.model.payment.PaymentRefundModel;
import com.hzframework.contract.PagedList;

import java.util.Date;
import java.util.List;

public class SalesModel {
    public static PagedList<Sales> getPagingList(SalesCondition salesCondition) {
        return SalesFacade.getPagingList(salesCondition);
    }
    public static List<Sales> getListByEmps(String empNos){
        return SalesFacade.getListByEmps(empNos);
    }
    public static int add(Sales sales) {
        int result =  SalesFacade.add(sales);
        EnumListCacheModel.getProductList(false);
        return result;
    }
    public static Sales getInfoByActivitiNo(String activitiNo){
        return SalesFacade.getInfoByActivitiNo(activitiNo);
    }
    public static List<Sales> getListByCustomerNo(int customerNo){
        return SalesFacade.getListByCustomerNo(customerNo);
    }
    public static int updateCustomerNameByCustomerNo(int customerNo,String customerName){
        return SalesFacade.updateCustomerNameByCustomerNo(customerNo,customerName);
    }
    public static int update(Sales sales) {
        int result = SalesFacade.update(sales);
        EnumListCacheModel.getProductList(false);
        return result;
    }
    public static int updateActivitiNoBySalesNo(int salesNo,String activitiNo){
        return SalesFacade.updateActivitiNoBySalesNo(salesNo,activitiNo);
    }
    public static List<Sales> getList() {
        return SalesFacade.getList();
    }

    public static Sales getInfo(int id) {
        return SalesFacade.getInfo(id);
    }

    //need override this method
	public static int updateStatus(int id, byte status) {
        int result = SalesFacade.updateStatus(id,status);
        EnumListCacheModel.getProductList(false);
		return result;
	}
	public static int addFilePath(Sales sales) {
		return SalesFacade.addFilePath(sales);
	}

	public static List<Sales> getSalesListByProductAndStatus(int productNo,int status) {
		return SalesFacade.getSalesListByProductAndStatus(productNo, status);
	}
    public static List<Sales> getSalesListByProductAndStates(int productNo,String status) {
        return SalesFacade.getSalesListByProductAndStates(productNo, status);
    }
	//mengchong 2015/03/02
	public static int updateStatusByProductionNoAndStatus(int productNo,byte status){
        int result = SalesFacade.updateStatusByProductionNoAndStatus(productNo,status);
        EnumListCacheModel.getProductList(false);
		return result;
	}
	public static int updateStagesByProductionNoAndStatus(int productStagesNo,int productNo,byte status){
		return SalesFacade.updateStagesByProductionNoAndStatus(productStagesNo,productNo,status);
	}
	public static Long getAllAccountMoney(int productNo,byte status){
		return SalesFacade.getAllAccountMoney(productNo,status);
	}

    public static Long getP2pSumMoney(SalesCondition salesCondition){
        return SalesFacade.getP2pSumMoney(salesCondition);
    }
    //create by Zorro 2015/4/30
	public static List<Sales> getNoPagingList(SalesCondition salesCondition) {
	        return SalesFacade.getNoPagingList(salesCondition);
	}
    public static int updateEstablishDateByProductNoAndisEstablish(int productNo,Date establishDate){
        return SalesFacade.updateEstablishDateByProductNoAndisEstablish(productNo,establishDate);
    }
    public static int updateP2pCustomerNoByCustomerNo(int customerNo,int p2pCustomerNo){
        return SalesFacade.updateP2pCustomerNoByCustomerNo(customerNo,p2pCustomerNo);
    }
	public static boolean  updateCreditorAndPaymentRefundBySaleNo(int salesNo){
        boolean result = true;
        List<SalesCreditor> salesCreditorList = SalesCreditorModel.getListBySalesNo(salesNo);
        for(SalesCreditor salesCreditor:salesCreditorList){
            if(CreditorModel.updateRemainAmountById(salesCreditor.getCreditorNo(),-salesCreditor.getMoney())==0){
                result = false;
                return result;
            }
            if(SalesCreditorModel.delete(salesCreditor.getId())==0){
                result = false;
                return result;
            }
        }
        if(PaymentRefundModel.deleteBySaleNo(salesNo)==0){
            result = false;
        }
        return result;
    }
    public static List<Sales> getListForExaclX(SalesCondition salesCondition){
        return SalesFacade.getListForExacl(salesCondition);
    }

    public static int updateIncomeById(int id,double income){
        return SalesFacade.updateIncomeById(id,income);
    }

    public static List<Sales> getSumMoneyGroupByEmp(SalesCondition salesCondition){
        return SalesFacade.getSumMoneyGroupByEmp(salesCondition);
    }

    public static List<Sales> getCurrentWeekSales(SalesCondition salesCondition){
        return SalesFacade.getCurrentWeekSales(salesCondition);
    }

}
