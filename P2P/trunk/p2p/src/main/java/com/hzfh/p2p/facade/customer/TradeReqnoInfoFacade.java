package com.hzfh.p2p.facade.customer;

import com.hzfh.api.customer.model.TradeReqnoInfo;
import com.hzfh.api.customer.model.query.TradeReqnoInfoCondition;
import com.hzfh.api.customer.service.TradeReqnoInfoService;
import com.hzframework.contract.PagedList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TradeReqnoInfoFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-customer.xml");

    public static PagedList<TradeReqnoInfo> getPagingList(TradeReqnoInfoCondition tradeReqnoInfoCondition) {
        TradeReqnoInfoService tradeReqnoInfoService = (TradeReqnoInfoService) context.getBean("tradeReqnoInfoService");

        return  tradeReqnoInfoService.getPagingList(tradeReqnoInfoCondition);
    }

    public static int add(TradeReqnoInfo tradeReqnoInfo){
        TradeReqnoInfoService tradeReqnoInfoService = (TradeReqnoInfoService) context.getBean("tradeReqnoInfoService");

        return tradeReqnoInfoService.add(tradeReqnoInfo);
    }

    public static int update(TradeReqnoInfo tradeReqnoInfo){
        TradeReqnoInfoService tradeReqnoInfoService = (TradeReqnoInfoService) context.getBean("tradeReqnoInfoService");

        return tradeReqnoInfoService.update(tradeReqnoInfo);
    }

    public static List<TradeReqnoInfo> getList(){
        TradeReqnoInfoService tradeReqnoInfoService = (TradeReqnoInfoService) context.getBean("tradeReqnoInfoService");

        return tradeReqnoInfoService.getList();
    }

    public static TradeReqnoInfo getInfo(int id){
        TradeReqnoInfoService tradeReqnoInfoService = (TradeReqnoInfoService) context.getBean("tradeReqnoInfoService");

        return tradeReqnoInfoService.getInfo(id);
    }

	public static TradeReqnoInfo getInfoBySnAndIsOk(String requestNo, int isOk) {
		TradeReqnoInfoService tradeReqnoInfoService = (TradeReqnoInfoService) context.getBean("tradeReqnoInfoService");

        return tradeReqnoInfoService.getInfoBySnAndIsOk(requestNo,isOk);
	}
}
