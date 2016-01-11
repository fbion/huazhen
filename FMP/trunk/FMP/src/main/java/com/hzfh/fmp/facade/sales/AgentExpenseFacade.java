package com.hzfh.fmp.facade.sales;

import com.hzfh.api.sales.model.AgentExpense;
import com.hzfh.api.sales.model.query.AgentExpenseCondition;
import com.hzfh.api.sales.service.AgentExpenseService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class AgentExpenseFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-sales.xml");

    public static PagedList<AgentExpense> getPagingList(AgentExpenseCondition agentExpenseCondition) {
        AgentExpenseService agentExpenseService = (AgentExpenseService) context.getBean("agentExpenseService");

        return  agentExpenseService.getPagingList(agentExpenseCondition);
    }

    public static int add(AgentExpense agentExpense){
        AgentExpenseService agentExpenseService = (AgentExpenseService) context.getBean("agentExpenseService");

        return agentExpenseService.add(agentExpense);
    }

    public static int update(AgentExpense agentExpense){
        AgentExpenseService agentExpenseService = (AgentExpenseService) context.getBean("agentExpenseService");

        return agentExpenseService.update(agentExpense);
    }

    public static List<AgentExpense> getList(){
        AgentExpenseService agentExpenseService = (AgentExpenseService) context.getBean("agentExpenseService");

        return agentExpenseService.getList();
    }

    public static AgentExpense getInfo(int id){
        AgentExpenseService agentExpenseService = (AgentExpenseService) context.getBean("agentExpenseService");

        return agentExpenseService.getInfo(id);
    }
}
