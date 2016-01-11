package com.hzfh.weixin.facade.sales;

import com.hzfh.api.sales.model.P2pSubscribe;
import com.hzfh.api.sales.model.query.P2pSubscribeCondition;
import com.hzfh.api.sales.service.P2pSubscribeService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Timestamp;
import java.util.List;

public class P2pSubscribeFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-sales.xml");

    public static PagedList<P2pSubscribe> getPagingList(P2pSubscribeCondition p2pSubscribeCondition) {
        P2pSubscribeService p2pSubscribeService = (P2pSubscribeService) context.getBean("p2pSubscribeService");

        return  p2pSubscribeService.getPagingList(p2pSubscribeCondition);
    }

    public static int add(P2pSubscribe p2pSubscribe){
        P2pSubscribeService p2pSubscribeService = (P2pSubscribeService) context.getBean("p2pSubscribeService");

        return p2pSubscribeService.add(p2pSubscribe);
    }

    public static int update(P2pSubscribe p2pSubscribe){
        P2pSubscribeService p2pSubscribeService = (P2pSubscribeService) context.getBean("p2pSubscribeService");

        return p2pSubscribeService.update(p2pSubscribe);
    }

    public static List<P2pSubscribe> getList(){
        P2pSubscribeService p2pSubscribeService = (P2pSubscribeService) context.getBean("p2pSubscribeService");

        return p2pSubscribeService.getList();
    }

    public static P2pSubscribe getInfo(int id){
        P2pSubscribeService p2pSubscribeService = (P2pSubscribeService) context.getBean("p2pSubscribeService");

        return p2pSubscribeService.getInfo(id);
    }

	/*public static int updateEmpNoById(int id, int empNo) {
		P2pSubscribeService p2pSubscribeService = (P2pSubscribeService) context.getBean("p2pSubscribeService");
		return p2pSubscribeService.updateEmpNoById(id,empNo);
	}*/

	public static int updateVisitTimeAndVisitTimeAndStatus(int id, Timestamp visitTime, String result, byte status) {
		P2pSubscribeService p2pSubscribeService = (P2pSubscribeService) context.getBean("p2pSubscribeService");
		return p2pSubscribeService.updateVisitTimeAndVisitTimeAndStatus(id,visitTime,result,status);
	}
}
