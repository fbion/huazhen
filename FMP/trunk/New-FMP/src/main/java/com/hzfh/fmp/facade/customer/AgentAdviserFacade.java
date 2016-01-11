package com.hzfh.fmp.facade.customer;

import com.hzfh.api.customer.model.AgentAdviser;
import com.hzfh.api.customer.model.query.AgentAdviserCondition;
import com.hzfh.api.customer.service.AgentAdviserService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class AgentAdviserFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-customer.xml");

    public static PagedList<AgentAdviser> getPagingList(AgentAdviserCondition agentAdviserCondition) {
        AgentAdviserService agentAdviserService = (AgentAdviserService) context.getBean("agentAdviserService");

        return  agentAdviserService.getPagingList(agentAdviserCondition);
    }

    public static int add(AgentAdviser agentAdviser){
        AgentAdviserService agentAdviserService = (AgentAdviserService) context.getBean("agentAdviserService");

        return agentAdviserService.add(agentAdviser);
    }

    public static int update(AgentAdviser agentAdviser){
        AgentAdviserService agentAdviserService = (AgentAdviserService) context.getBean("agentAdviserService");

        return agentAdviserService.update(agentAdviser);
    }
    public static int updateTradeTotalById(int id, double tradeTotal){
        AgentAdviserService agentAdviserService = (AgentAdviserService) context.getBean("agentAdviserService");

        return agentAdviserService.updateTradeTotalById(id, tradeTotal);
    }
    public static List<AgentAdviser> getList(){
        AgentAdviserService agentAdviserService = (AgentAdviserService) context.getBean("agentAdviserService");

        return agentAdviserService.getList();
    }

    public static List<AgentAdviser> getListForExcel(AgentAdviserCondition agentAdviserCondition){
        AgentAdviserService agentAdviserService = (AgentAdviserService) context.getBean("agentAdviserService");
        return agentAdviserService.getListForExcel(agentAdviserCondition);
    }

    public static AgentAdviser getInfo(int id){
        AgentAdviserService agentAdviserService = (AgentAdviserService) context.getBean("agentAdviserService");

        return agentAdviserService.getInfo(id);
    }

    public static List<AgentAdviser> getMyAgentAdviser(String workMateString) {
        AgentAdviserService agentAdviserService = (AgentAdviserService) context.getBean("agentAdviserService");

        return agentAdviserService.getMyAgentAdviser(workMateString);
    }

	public static List<AgentAdviser> getNoPagingList(AgentAdviserCondition agentAdviserCondition) {
		 AgentAdviserService agentAdviserService = (AgentAdviserService) context.getBean("agentAdviserService");

	        return  agentAdviserService.getNoPagingList(agentAdviserCondition);
	}
}
