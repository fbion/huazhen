package com.hzfh.fmp.facade.sales;

import com.hzfh.api.sales.model.Sales;
import com.hzfh.api.sales.model.query.SalesCondition;
import com.hzfh.api.sales.service.SalesService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

public class SalesFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-sales.xml");

    public static PagedList<Sales> getPagingList(SalesCondition salesCondition) {
        SalesService salesService = (SalesService) context.getBean("salesService");

        return  salesService.getPagingList(salesCondition);
    }
    public static List<Sales> getListByEmps(String empNos) {
        SalesService salesService = (SalesService) context.getBean("salesService");

        return  salesService.getListByEmps(empNos);
    }
    public static Sales getInfoByActivitiNo(String activitiNo){
        SalesService salesService = (SalesService) context.getBean("salesService");
        return salesService.getInfoByActivitiNo(activitiNo);
    }
    public static List<Sales> getListByCustomerNo(int customerNo){
        SalesService salesService = (SalesService) context.getBean("salesService");
        return salesService.getListByCustomerNo(customerNo);
    }
    public static int updateCustomerNameByCustomerNo(int customerNo,String customerName){
        SalesService salesService = (SalesService) context.getBean("salesService");
        return salesService.updateCustomerNameByCustomerNo(customerNo,customerName);
    }
    public static int add(Sales sales){
        SalesService salesService = (SalesService) context.getBean("salesService");

        return salesService.add(sales);
    }
    public static int updateActivitiNoBySalesNo(int salesNo,String activitiNo){
        SalesService salesService = (SalesService) context.getBean("salesService");

        return salesService.updateActivitiNoBySalesNo(salesNo,activitiNo);
    }

    public static int update(Sales sales){
        SalesService salesService = (SalesService) context.getBean("salesService");

        return salesService.update(sales);
    }

    public static List<Sales> getList(){
        SalesService salesService = (SalesService) context.getBean("salesService");

        return salesService.getList();
    }
    public static List<Sales> getListForExacl(SalesCondition salesCondition){
        SalesService salesService = (SalesService) context.getBean("salesService");

        return salesService.getListForExacl(salesCondition);
    }

    public static Sales getInfo(int id){
        SalesService salesService = (SalesService) context.getBean("salesService");

        return salesService.getInfo(id);
    }

	public static int updateStatus(int id, byte status) {
		 SalesService salesService = (SalesService) context.getBean("salesService");

	        return salesService.updateStatus(id,status);
	}

	public static int addFilePath(Sales sales) {
		SalesService salesService = (SalesService) context.getBean("salesService");
		return salesService.addFilePath(sales);
	}
	
	public static List<Sales> getSalesListByProductAndStatus(int productNo,int status) {
		SalesService salesService = (SalesService) context.getBean("salesService");
		return salesService.getSalesListByProductAndStatus(productNo, status);
	}
    public static List<Sales> getSalesListByProductAndStates(int productNo,String status) {
        SalesService salesService = (SalesService) context.getBean("salesService");
        return salesService.getSalesListByProductAndStates(productNo, status);
    }

	public static int updateStatusByProductionNoAndStatus(int productNo, byte status) {
		SalesService salesService = (SalesService) context.getBean("salesService");
		return salesService.updateStatusByProductionNoAndStatus(productNo,status);
	}

	public static int updateStagesByProductionNoAndStatus(int productStagesNo,int productNo, byte status) {
		SalesService salesService = (SalesService) context.getBean("salesService");
		return salesService.updateStagesByProductionNoAndStatus(productStagesNo,productNo,status);
	}

	public static Long getAllAccountMoney(int productNo, byte status) {
		SalesService salesService = (SalesService) context.getBean("salesService");
		return salesService.getAllAccountMoney(productNo,status);
	}

    public static Long getP2pSumMoney(SalesCondition salesCondition){
        SalesService salesService = (SalesService) context.getBean("salesService");
        return salesService.getP2pSumMoney(salesCondition);
    }


	public static List<Sales> getNoPagingList(SalesCondition salesCondition) {
		 SalesService salesService = (SalesService) context.getBean("salesService");

	        return  salesService.getNoPagingList(salesCondition);
	}
    public static int updateEstablishDateByProductNoAndisEstablish(int productNo,Date establishDate){
        SalesService salesService = (SalesService) context.getBean("salesService");
        return salesService.updateEstablishDateByProductNoAndisEstablish(productNo,establishDate);
    }
    public static int updateP2pCustomerNoByCustomerNo(int customerNo,int p2pCustomerNo){
        SalesService salesService = (SalesService) context.getBean("salesService");
        return salesService.updateP2pCustomerNoByCustomerNo(customerNo,p2pCustomerNo);
    }

    public static int updateIncomeById(int id,double income){
        SalesService salesService = (SalesService) context.getBean("salesService");
        return salesService.updateIncomeById(id,income);
    }

    public static List<Sales> getSumMoneyGroupByEmp(SalesCondition salesCondition){
        SalesService salesService = (SalesService) context.getBean("salesService");
        return salesService.getSumMoneyGroupByEmp(salesCondition);
    }

    public static List<Sales> getCurrentWeekSales(SalesCondition salesCondition){
        SalesService salesService = (SalesService) context.getBean("salesService");
        return salesService.getCurrentWeekSales(salesCondition);
    }
}
