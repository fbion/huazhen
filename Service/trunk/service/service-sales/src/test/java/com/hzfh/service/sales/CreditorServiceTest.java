package com.hzfh.service.sales;

import com.hzfh.api.sales.model.Creditor;
import com.hzfh.api.sales.model.P2pSubscribe;
import com.hzfh.api.sales.model.query.CreditorCondition;
import com.hzfh.api.sales.model.query.P2pSubscribeCondition;
import com.hzfh.api.sales.service.CreditorService;
import com.hzfh.api.sales.service.P2pSubscribeService;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.contract.SortType;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/8/25.
 */
public class CreditorServiceTest {

    @Test
    public void getPagingListTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        CreditorService creditorService = (CreditorService) context
                .getBean("creditorService");
        CreditorCondition creditorCondition = new CreditorCondition();

        creditorCondition.setPageIndex(1);
        creditorCondition.setPageSize(20);

        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem1 = new SortItem();
        sortItem1.setSortFeild("id");
        sortItem1.setSortType(SortType.DESC);
        sortItemList.add(sortItem1);

        creditorCondition.setSortItemList(sortItemList);
        PagedList<Creditor> creditorPagedList = creditorService
                .getPagingList(creditorCondition);

        System.out.println("getPagingListTest");
        for (Creditor creditor : creditorPagedList.getResultList()) {
            System.out.println(creditor.getId());
        }
//		System.out.println(p2pSubscribePagedList);
//		for (P2pSubscribe p2pSubscribe : p2pSubscribePagedList.getResultList()) {
//			System.out.println(p2pSubscribe.getId()+"-"+p2pSubscribe.getEmpNo()+"-"+p2pSubscribe.getRealName());
//		}

    }

    @Test
    public void getListTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        CreditorService creditorService = (CreditorService) context
                .getBean("creditorService");

        int result = creditorService.updateRemainAmountById(1, 100);
        System.out.println(result);
    }

    @Test
    public void getRemainAmountByProductNo() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        CreditorService creditorService = (CreditorService) context.getBean("creditorService");
        double totalMoney = creditorService.getRemainAmountByProductNo(165);
        System.out.print(totalMoney);

    }

}
