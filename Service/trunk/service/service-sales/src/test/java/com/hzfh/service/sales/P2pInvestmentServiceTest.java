package com.hzfh.service.sales;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hzfh.api.sales.model.P2pInvestment;
import com.hzfh.api.sales.model.P2pSubscribe;
import com.hzfh.api.sales.model.query.P2pInvestmentCondition;
import com.hzfh.api.sales.service.P2pInvestmentService;
import com.hzfh.api.sales.service.P2pSubscribeService;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.contract.SortType;

public class P2pInvestmentServiceTest{
	@Test
	public void getPagingListTest(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		P2pInvestmentService p2pInvestmentService = (P2pInvestmentService) context.getBean("p2pInvestmentService");
		P2pInvestmentCondition p2pInvestmentCondition = new P2pInvestmentCondition();
		p2pInvestmentCondition.setPageIndex(1);
		p2pInvestmentCondition.setPageSize(20);
		p2pInvestmentCondition.setP2pCustomerNo(1);
		//p2pInvestmentCondition.setStatus(1);

		List<SortItem> sortItemList = new ArrayList<SortItem>();
		SortItem sortItem1 = new SortItem();
		sortItem1.setSortFeild("name");
		sortItem1.setSortType(SortType.ASC);
		sortItemList.add(sortItem1);

		SortItem sortItem2 = new SortItem();
		sortItem2.setSortFeild("income");
		sortItem2.setSortType(SortType.DESC);
		sortItemList.add(sortItem2);

		p2pInvestmentCondition.setSortItemList(sortItemList);
		PagedList<P2pInvestment> p2pInvestmentPagedList = p2pInvestmentService.getPagingList(p2pInvestmentCondition);
		for(P2pInvestment p:p2pInvestmentPagedList.getResultList()){
			System.out.println(p.getId()+"==="+p.getName());
		}
	}
	@Test
	public void addTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		P2pInvestmentService p2pInvestmentService = (P2pInvestmentService) context.getBean("p2pInvestmentService");
		
		P2pInvestment p2pInvestment = new P2pInvestment();
		int i=0;
		i+=1;
		p2pInvestment.setName("name"+"2");
		p2pInvestment.setPaymentTime(new Date());;

		int id = p2pInvestmentService.add(p2pInvestment);

		System.out.println("addTest");
		System.out.println(id);
	}

	@Test
	public void updateEmpNoByIdTest(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		P2pSubscribeService p2pSubscribeService = (P2pSubscribeService) context.getBean("p2pSubscribeService");
		P2pSubscribe p2pSubscribe = new P2pSubscribe();
		int  empNo=1;
		int id = 2;
        int deptNo = 4;
		int n = p2pSubscribeService.updateEmpNoById(id,deptNo, empNo);

		System.out.println("updateEmpNoByIdTest");
		System.out.println(n);
	}
    @Test
	public void updateVisitTimeAndResultAndStatusTest(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		P2pSubscribeService p2pSubscribeService = (P2pSubscribeService) context.getBean("p2pSubscribeService");
		P2pSubscribe p2pSubscribe = new P2pSubscribe();
		int id = 2;
		Date visitTime = new Date();
		String result = "ser";
		byte status = 2;
		int n = p2pSubscribeService.updateVisitTimeAndVisitTimeAndStatus(id, visitTime, result, status);

		System.out.println("updateVisitTimeAndResultAndStatusTest");
		System.out.println(n);
	}
    
    
    @Test
    public void getP2pInvestmentBySalesIdTest(){
    	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		P2pInvestmentService p2pInvestmentService = (P2pInvestmentService) context.getBean("p2pInvestmentService");
		int salesNo=330;
		P2pInvestment p2pInvestment = p2pInvestmentService.getP2pInvestmentBySalesId(salesNo);
		System.out.println(p2pInvestment.getId()+" - "+ p2pInvestment.getIncome()+" - "+ p2pInvestment.getFloatingIncome());
		
    }

    @Test
    public void updateStatusBySalesNoTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        P2pInvestmentService p2pInvestmentService = (P2pInvestmentService) context.getBean("p2pInvestmentService");
        int result = p2pInvestmentService.updateStatusBySalesNo(330,5);
        System.out.println(result);
    }

    @Test
    public void updateStatusByProductNoAndStatusTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        P2pInvestmentService p2pInvestmentService = (P2pInvestmentService) context.getBean("p2pInvestmentService");
        int result = p2pInvestmentService.updateStatusByProductNoAndStatus(17, (byte) 2);
        System.out.println(result);
    }
}