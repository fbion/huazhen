package com.hzfh.fmp.facade.customer;

import com.hzfh.api.customer.model.AgentBusiness;
import com.hzfh.api.customer.model.query.AgentBusinessCondition;
import com.hzfh.api.customer.service.AgentBusinessService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class AgentBusinessFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-customer.xml");

    public static PagedList<AgentBusiness> getPagingList(AgentBusinessCondition agentBusinessCondition) {
        AgentBusinessService agentBusinessService = (AgentBusinessService) context.getBean("agentBusinessService");

        return  agentBusinessService.getPagingList(agentBusinessCondition);
    }

    public static int add(AgentBusiness agentBusiness){
        AgentBusinessService agentBusinessService = (AgentBusinessService) context.getBean("agentBusinessService");

        return agentBusinessService.add(agentBusiness);
    }

    public static int update(AgentBusiness agentBusiness){
        AgentBusinessService agentBusinessService = (AgentBusinessService) context.getBean("agentBusinessService");

        return agentBusinessService.update(agentBusiness);
    }
    
    public static int updateTradeTotalById(int id, double tradeTotal) {
        AgentBusinessService agentBusinessService = (AgentBusinessService) context.getBean("agentBusinessService");

        return agentBusinessService.updateTradeTotalById(id,tradeTotal);
    }

    public static List<AgentBusiness> getList(){
        AgentBusinessService agentBusinessService = (AgentBusinessService) context.getBean("agentBusinessService");

        return agentBusinessService.getList();
    }

    public static List<AgentBusiness> getListForExcel(AgentBusinessCondition agentBusinessCondition){
        AgentBusinessService agentBusinessService = (AgentBusinessService) context.getBean("agentBusinessService");
        return agentBusinessService.getListForExcel(agentBusinessCondition);
    }
    public static AgentBusiness getInfo(int id){
        AgentBusinessService agentBusinessService = (AgentBusinessService) context.getBean("agentBusinessService");

        return agentBusinessService.getInfo(id);
    }

    public static List<AgentBusiness> getMyAgentBusiness(String workMateString) {
        AgentBusinessService agentBusinessService = (AgentBusinessService) context.getBean("agentBusinessService");

        return agentBusinessService.getMyAgentBusiness(workMateString);
    }

	public static List<AgentBusiness> getNoPagingList(AgentBusinessCondition agentBusinessCondition) {
		 AgentBusinessService agentBusinessService = (AgentBusinessService) context.getBean("agentBusinessService");

	        return  agentBusinessService.getNoPagingList(agentBusinessCondition);
	}

	public static List<AgentBusiness> getAgentBusinessListByManageNo(int mamageNo) {
		 AgentBusinessService agentBusinessService = (AgentBusinessService) context.getBean("agentBusinessService");

	        return  agentBusinessService.getAgentBusinessListByManageNo(mamageNo);
	}
}
