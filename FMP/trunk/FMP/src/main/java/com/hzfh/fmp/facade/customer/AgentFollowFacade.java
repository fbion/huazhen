package com.hzfh.fmp.facade.customer;

import com.hzfh.api.customer.model.AgentFollow;
import com.hzfh.api.customer.model.query.AgentFollowCondition;
import com.hzfh.api.customer.service.AgentFollowService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class AgentFollowFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-customer.xml");

    public static PagedList<AgentFollow> getPagingList(AgentFollowCondition agentFollowCondition) {
        AgentFollowService agentFollowService = (AgentFollowService) context.getBean("agentFollowService");

        return  agentFollowService.getPagingList(agentFollowCondition);
    }

    public static int add(AgentFollow agentFollow){
        AgentFollowService agentFollowService = (AgentFollowService) context.getBean("agentFollowService");

        return agentFollowService.add(agentFollow);
    }

    public static int update(AgentFollow agentFollow){
        AgentFollowService agentFollowService = (AgentFollowService) context.getBean("agentFollowService");

        return agentFollowService.update(agentFollow);
    }

    public static List<AgentFollow> getList(){
        AgentFollowService agentFollowService = (AgentFollowService) context.getBean("agentFollowService");

        return agentFollowService.getList();
    }

    public static AgentFollow getInfo(int id){
        AgentFollowService agentFollowService = (AgentFollowService) context.getBean("agentFollowService");

        return agentFollowService.getInfo(id);
    }
}
