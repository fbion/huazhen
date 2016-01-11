package com.hzfh.service.sales;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.caucho.hessian.client.HessianProxyFactory;
import com.hzframework.contract.SortItem;
import com.hzframework.contract.SortType;
import com.hzframework.helper.DateHelper;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hzfh.api.sales.model.Sales;
import com.hzfh.api.sales.model.query.SalesCondition;
import com.hzfh.api.sales.service.SalesService;
import com.hzframework.contract.PagedList;

public class SalesTest {
    @Test
    public void getList(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        SalesService salesService =(SalesService) context.getBean("salesService");
        SalesCondition salesCondition = new SalesCondition();
        salesCondition.setPageIndex(1);
        salesCondition.setPageSize(20);
        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem1 = new SortItem();
        sortItem1.setSortFeild("id");
        sortItem1.setSortType(SortType.DESC);
        sortItemList.add(sortItem1);
        salesCondition.setSortItemList(sortItemList);
        List<Sales> salesList = salesService.getPagingList(salesCondition).getResultList();
        for(Sales sales:salesList){
            System.out.print(sales.getId());
        }

    }
	@Test
	public void updateStatus(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		SalesService salesService =(SalesService) context.getBean("salesService");
		System.out.print(salesService.getAllAccountMoney(64,(byte)3));
	}
    @Test
    public void getAllAccountMoney() throws Exception{
//        String url = "http://192.168.1.232:8080/service-sales/sales";
//        HessianProxyFactory factory = new HessianProxyFactory();
//        SalesService salesService = (SalesService) factory.create(SalesService.class, url);

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        SalesService salesService =(SalesService) context.getBean("salesService");
        SalesCondition salesCondition = new SalesCondition();
        salesCondition.setEmpNos("92");
        salesCondition.setProductType(5);
        System.out.println(salesService.getP2pSumMoney(salesCondition));
    }

	@Test
	public void addTest() throws Exception {
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        SalesService salesService =(SalesService) context.getBean("salesService");
        String url = "http://172.16.26.13:8080/service-sales/sales";
        HessianProxyFactory factory = new HessianProxyFactory();
        SalesService salesService = (SalesService) factory.create(SalesService.class, url);
	    List<Sales> salesList = salesService.getSalesListByProductAndStates(171,"1,2,8,9");
        System.out.print(salesList.size());
	}
	
	@Test
	public void addFilePath(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		SalesService salesService =(SalesService) context.getBean("salesService");
		Sales sales = new Sales();
		sales.setId(51);
		sales.setDocumentPath("dsafdfa");
		salesService.addFilePath(sales);
		
	}
	
	@Test
	public void getSumMoneyList(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		SalesService salesService =(SalesService) context.getBean("salesService");
		int productNo = 2;
		List<Sales> sumMoneyList =  salesService.getSumMoneyList(productNo);
		for (Sales s : sumMoneyList) {
			System.out.println(s.getDeptNo()+"======="+s.getMoney());
		}
	}
	
	@Test
	public void getSalesListByProductAndStatus(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		SalesService salesService =(SalesService) context.getBean("salesService");
		int productNo = 195;
		int status = 1; 
		List<Sales> salesList = salesService.getSalesListByProductAndStatus(productNo,status);
//		salesList = salesList.subList(0, 5);
		for (Sales sales : salesList) {
			System.out.println(sales.getId()+"=="+sales.getMoney()+"=="+sales.getPurchaseDate()+"=="+sales.getStatus());
		}
	}

	//mengchong 2015/03/02
	@Test
	public void updateStatusByProductionNoAndStatusTest(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		SalesService salesService =(SalesService) context.getBean("salesService");
		int productNo = 154;
		byte status =20;
		int result=salesService.updateStatusByProductionNoAndStatus(productNo, status);
		System.out.println(result);
	}
    @Test
    public void updateStagesByProductionNoAndStatusTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        SalesService salesService =(SalesService) context.getBean("salesService");
        int productNo = 122;
        byte status =2;
        int productStagesNo = 1;
        int result = salesService.updateStagesByProductionNoAndStatus(productStagesNo,productNo,status);
        System.out.print(result);
    }
    @Test
    public void updateEstablishDateByProductNoAndisEstablish(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        SalesService salesService =(SalesService) context.getBean("salesService");
        int result = salesService.updateEstablishDateByProductNoAndisEstablish(64,new Date());
        System.out.println(result);
    }
    @Test
    public void getPagingList(){
    	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    	SalesService salesService =(SalesService) context.getBean("salesService");
    	SalesCondition salesCondition = new SalesCondition();
        salesCondition.setPageSize(3);
        salesCondition.setPageIndex(1);
        salesCondition.setP2pCustomerNo(221);
        salesCondition.setPayType(-1);
        List<SortItem> sortItemList = new ArrayList<SortItem>();
		SortItem sortItem1 = new SortItem();
		sortItem1.setSortFeild("id");
		sortItem1.setSortType(SortType.DESC);
		sortItemList.add(sortItem1);
        
        PagedList<Sales> salesPagedList = salesService.getPagingList(salesCondition);
        System.out.println(salesPagedList.getResultList().size());
        for(Sales sales:salesPagedList.getResultList()){
        	System.out.println(sales.getP2pProductNo());
        }
    }

    @Test
    public void getSalesListByProductNoAndCountTest(){
    	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    	SalesService salesService = (SalesService)context.getBean("salesService");
    	List<Sales> list = new ArrayList<Sales>();
    	list = salesService.getSalesListByProductNoAndCount(50, 10);
    	for(Sales l:list){
    		System.out.println(l.getMoney());
    	}
    }

    @Test
    public void updateP2pCustoemrNotest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        SalesService salesService = (SalesService)context.getBean("salesService");
        int result = salesService.updateP2pCustomerNoByCustomerNo(443,383);
        System.out.println(result);

    }
}
