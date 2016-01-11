package com.hzfh.service.sales;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hzfh.api.sales.model.P2pSubscribe;
import com.hzfh.api.sales.model.query.P2pSubscribeCondition;
import com.hzfh.api.sales.service.P2pSubscribeService;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.contract.SortType;
import com.hzframework.helper.DateHelper;

public class P2pSubscribeServiceTest {
	@Test
	public void getPagingListTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		P2pSubscribeService p2pSubscribeService = (P2pSubscribeService) context
				.getBean("p2pSubscribeService");
		P2pSubscribeCondition p2pSubscribeCondition = new P2pSubscribeCondition();

		p2pSubscribeCondition.setPageIndex(1);
		p2pSubscribeCondition.setPageSize(20);

//		p2pSubscribeCondition.setByDeptNo(0);
//		p2pSubscribeCondition.setByEmpNo(151);
 //       p2pSubscribeCondition.setEmpNo(-1);
//		p2pSubscribeCondition.setByP2pCustomerNo(1);
//		p2pSubscribeCondition.setByP2pProductNo(0);
//		p2pSubscribeCondition.setByStatus(0);

        p2pSubscribeCondition.setByP2pProductNo(44);
		List<SortItem> sortItemList = new ArrayList<SortItem>();
		SortItem sortItem1 = new SortItem();
        sortItem1.setSortFeild("id");
        sortItem1.setSortFeild("real_name");
		sortItem1.setSortType(SortType.DESC);
        sortItemList.add(sortItem1);

        p2pSubscribeCondition.setSortItemList(sortItemList);
		PagedList<P2pSubscribe> p2pSubscribePagedList = p2pSubscribeService
				.getPagingList(p2pSubscribeCondition);
		
		System.out.println("getPagingListTest");
		for (P2pSubscribe p2pSubscribe : p2pSubscribePagedList.getResultList()) {
			System.out.println(p2pSubscribe.getId());
		}
//		System.out.println(p2pSubscribePagedList);
//		for (P2pSubscribe p2pSubscribe : p2pSubscribePagedList.getResultList()) {
//			System.out.println(p2pSubscribe.getId()+"-"+p2pSubscribe.getEmpNo()+"-"+p2pSubscribe.getRealName());
//		}
			
	}

	@Test
	public void addTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		P2pSubscribeService p2pSubscribeService = (P2pSubscribeService) context
				.getBean("p2pSubscribeService");

		P2pSubscribe p2pSubscribe = new P2pSubscribe();
		p2pSubscribe.setCellphone("13624985994");
		p2pSubscribe.setRealName("胡杰");
		p2pSubscribe.setP2pProductNo(79);
		p2pSubscribe.setVisitTime(DateHelper.getCurrentTime());
		p2pSubscribe.setStatus((byte)1);

		int id = p2pSubscribeService.add(p2pSubscribe);

		System.out.println("addTest");
		System.out.println(id);
	}

	@Test
	public void updateEmpNoByIdTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		P2pSubscribeService p2pSubscribeService = (P2pSubscribeService) context
				.getBean("p2pSubscribeService");
//		/P2pSubscribe p2pSubscribe = new P2pSubscribe();
		int empNo = 100;
		int id = 2;
        int deptNo = 4;
		int n = p2pSubscribeService.updateEmpNoById(id, deptNo,empNo);

		System.out.println("updateEmpNoByIdTest");
		System.out.println(n);
	}

	@Test
	public void updateVisitTimeAndResultAndStatusTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		P2pSubscribeService p2pSubscribeService = (P2pSubscribeService) context
				.getBean("p2pSubscribeService");
		P2pSubscribe p2pSubscribe = new P2pSubscribe();
		int id = 2;
		Date visitTime = new Date();
		String result = "ser";
		byte status = 2;
		int n = p2pSubscribeService.updateVisitTimeAndVisitTimeAndStatus(id,
				visitTime, result, status);

		System.out.println("updateVisitTimeAndResultAndStatusTest");
		System.out.println(n);
	}
    @Test
    public void updateP2pSubScribeStatusTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        P2pSubscribeService p2pSubscribeService = (P2pSubscribeService) context
                .getBean("p2pSubscribeService");
        int result = p2pSubscribeService.updateP2pSubScribeStatus(1,2);
        System.out.println(result);
    }

    @Test
    public void updateP2pSubScribeByIdTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        P2pSubscribeService p2pSubscribeService = (P2pSubscribeService) context
                .getBean("p2pSubscribeService");
        int result = p2pSubscribeService.updateP2pSubscribeById(150,276);
        System.out.println(result);
    }
}