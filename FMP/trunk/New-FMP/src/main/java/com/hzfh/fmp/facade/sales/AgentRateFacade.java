package com.hzfh.fmp.facade.sales;

import com.hzfh.api.sales.model.AgentRate;
import com.hzfh.api.sales.model.query.AgentRateCondition;
import com.hzfh.api.sales.service.AgentRateService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class AgentRateFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-sales.xml");

    public static PagedList<AgentRate> getPagingList(AgentRateCondition agentRateCondition) {
        AgentRateService agentRateService = (AgentRateService) context.getBean("agentRateService");

        return  agentRateService.getPagingList(agentRateCondition);
    }

    public static int add(AgentRate agentRate){
        AgentRateService agentRateService = (AgentRateService) context.getBean("agentRateService");

        return agentRateService.add(agentRate);
    }

    public static int update(AgentRate agentRate){
        AgentRateService agentRateService = (AgentRateService) context.getBean("agentRateService");

        return agentRateService.update(agentRate);
    }

    public static List<AgentRate> getList(){
        AgentRateService agentRateService = (AgentRateService) context.getBean("agentRateService");

        return agentRateService.getList();
    }

    public static AgentRate getInfo(int id){
        AgentRateService agentRateService = (AgentRateService) context.getBean("agentRateService");

        return agentRateService.getInfo(id);
    }

	public static AgentRate getAgentRate(AgentRate agentRate, long money) {
		AgentRateService agentRateService = (AgentRateService) context.getBean("agentRateService");
        
		return agentRateService.getAgentRate(agentRate,money);
	}

	public static List<AgentRate> getAgentRateListByCondition(AgentRateCondition agentRateCondition) {
        AgentRateService agentRateService = (AgentRateService) context.getBean("agentRateService");
        return agentRateService.getAgentRateListByCondition(agentRateCondition);
    }

    public static int delete(int id){
        AgentRateService agentRateService = (AgentRateService) context.getBean("agentRateService");
        return agentRateService.delete(id);
    }
}
